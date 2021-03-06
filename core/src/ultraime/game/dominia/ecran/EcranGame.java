package ultraime.game.dominia.ecran;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.ultraime.game.gdxtraime.ecran.Ecran;
import com.ultraime.game.gdxtraime.ecran.EcranManagerAbstract;
import com.ultraime.game.gdxtraime.parametrage.Parametre;

import ultraime.game.dominia.composant.LabelListenner;
import ultraime.game.dominia.ecran.menu.MenuHud;
import ultraime.game.dominia.entite.Zone;
import ultraime.game.dominia.service.AmeliorationManager;
import ultraime.game.dominia.service.JeuService;

/**
 * @author ultraime Ecran de base pour d�marrer une partie
 */
public class EcranGame extends Ecran {

	// Graphisme
	private Stage stageHUD;
	private Stage stageFond;
	private Stage stageCarte;
	private Stage stageBoutonBas;

	private Skin skin;
	private OrthographicCamera cameraCarte;

	// Texture
	final private Texture txt_j1 = new Texture(Gdx.files.internal("logo/joueur_0.png"));

	// Jeu
	public JeuService jeuService;
	private ArrayList<Label> labelZone = new ArrayList<Label>();
	
	private MenuHud menuInfosRegion;

	@Override
	public void changerEcran(InputMultiplexer inputMultiplexer) {
		inputMultiplexer.addProcessor(this);
		inputMultiplexer.addProcessor(stageCarte);
		inputMultiplexer.addProcessor(stageHUD);
		inputMultiplexer.addProcessor(stageBoutonBas);
	}

	@Override
	public void create(final EcranManagerAbstract ecranManagerAb) {
		//init des amelioration 
		AmeliorationManager.initList();
		
		this.ecranManager = (EcranManager) ecranManagerAb;
		
		Parametre.PAUSE = true;
		stageHUD = new Stage();
		stageBoutonBas = new Stage();
		stageCarte = new Stage();
		cameraCarte = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		stageCarte.getViewport().setCamera(cameraCarte);

		stageFond = new Stage();

		resize(1920,1080);
		skin = new Skin(Gdx.files.internal("ui-editor/neonuiblue/neonuiblue.json"));
		
		//HUD + menu info zone
		menuInfosRegion = new MenuHud();
		menuInfosRegion.createStage(stageHUD);
		
		// FOND
		Table tableFond = new Table();
		tableFond.setFillParent(true);
		Image imgFond = new Image(new Texture(Gdx.files.internal("logo/fond.png")));
		tableFond.add(imgFond).expand().fill();
		stageFond.addActor(tableFond);

		// STAGE CARTE BACKGROUND
		Table tableBackground = new Table();
		tableBackground.setDebug(Parametre.MODE_DEBUG);
		tableBackground.setFillParent(true);
		tableBackground.top();
		tableBackground.add().expandX().fillX().height(50);
		tableBackground.row();
		final Texture carteImg = new Texture(Gdx.files.internal("carte/carte.png"));
		tableBackground.add().expandX().fillX();
		tableBackground.add(new Image(carteImg));
		tableBackground.add().expandX().fillX();
		stageCarte.addActor(tableBackground);

		// STAGE CARTE
		Table tableCarte = new Table();
		tableCarte.setDebug(Parametre.MODE_DEBUG);
		tableCarte.setFillParent(true);
		tableCarte.top();
		tableCarte.add().expandX().fillX().height(50);

		// cr�ation du plateau (métier)
		jeuService = new JeuService();
		this.jeuService.zones = new Zone[7][13];
		for (int i = 0; i < 7; i++) {
			tableCarte.row();
			tableCarte.add().expandX().fillX();
			for (int j = 0; j < 13; j++) {
				final Zone zone = this.jeuService.genererZone(i, j);
				Label label = new Label("[" + i + "][" + j + "]", skin);
				label.addListener(new LabelListenner(zone, i, j, this.jeuService.joueurs,menuInfosRegion));
				labelZone.add(label);
				tableCarte.add(label).width(128).height(128);
			}
			tableCarte.add().expandX().fillX();
		}

		stageCarte.addActor(tableCarte);

		Table tableBtnBas = new Table();
		tableBtnBas.setDebug(Parametre.MODE_DEBUG);
		tableBtnBas.setFillParent(true);
		tableBtnBas.bottom();

		TextButton btnMenuCarte = new TextButton(Parametre.bundle.get("txt.menu.carte"), skin);

		TextButton btnMenuAmelioration = new TextButton(Parametre.bundle.get("txt.menu.amelioration"), skin);
		btnMenuAmelioration.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				ecranManager.initialiserEcran(ecranManager.ecranAmelioration);
			}
		});

		tableBtnBas.add(btnMenuCarte).height(50).width(200);
		tableBtnBas.add(btnMenuAmelioration).height(50).width(200);

		tableBtnBas.add().expandX().fillX();
		stageBoutonBas.addActor(tableBtnBas);

		// lance le jeu
		jeuService.startGame(1);
		resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		try {
			for (int i = 0; i < labelZone.size(); i++) {
				Label label = labelZone.get(i);
				LabelListenner labelListenner = (LabelListenner) label.getListeners().first();

				int idJoueur = 0;
				if (!labelListenner.idJoueursPresent.contains(idJoueur)
						&& labelListenner.zone.getNbListePersonnageFromJoueur(idJoueur) > 0) {
					Image img = new Image(txt_j1);
					img.setPosition(label.getX() + 16, label.getY() + 16);
					stageCarte.addActor(img);
					labelListenner.idJoueursPresent.add(idJoueur);
				}

			}
			stageHUD.act(Gdx.graphics.getDeltaTime());
			stageCarte.act(Gdx.graphics.getDeltaTime());
			stageFond.act(Gdx.graphics.getDeltaTime());
			stageBoutonBas.act(Gdx.graphics.getDeltaTime());

			stageFond.draw();
			stageCarte.draw();
			stageHUD.draw();
			stageBoutonBas.draw();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void dispose() {
		this.batch.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {

		return false;
	}

	@Override
	public boolean keyUp(int keycode) {

		return false;
	}

	@Override
	public boolean keyTyped(char character) {

		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		menuInfosRegion.showMenu(false);
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		cameraCarte.zoom += amount;
		cameraCarte.update();
		return false;
	}

	@Override
	public void resize(int width, int height) {
		stageHUD.getViewport().update(width, height, true);
		stageCarte.getViewport().update(width, height, true);
		stageBoutonBas.getViewport().update(width, height, true);
		// viewport.update(width, height);
	}

}
