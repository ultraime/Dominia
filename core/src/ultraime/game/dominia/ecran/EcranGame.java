package ultraime.game.dominia.ecran;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.ultraime.game.gdxtraime.ecran.Ecran;
import com.ultraime.game.gdxtraime.ecran.EcranManagerAbstract;
import com.ultraime.game.gdxtraime.parametrage.Parametre;

import ultraime.game.dominia.composant.LabelListenner;
import ultraime.game.dominia.entite.Zone;
import ultraime.game.dominia.service.AmeliorationManager;
import ultraime.game.dominia.service.JeuService;

/**
 * @author ultraime Ecran de base pour dï¿½marrer une partie
 */
public class EcranGame extends Ecran {

	// Graphisme
	private Stage stageHUD;
	private Stage stageFond;
	private Stage stageCarte;
	private Skin skin;
	private OrthographicCamera cameraCarte;

	// Texture
	final private Texture txt_j1 = new Texture(Gdx.files.internal("logo/joueur_0.png"));

	// Jeu
	private JeuService jeuService;
	private ArrayList<Label> labelZone = new ArrayList<Label>();

	@Override
	public void changerEcran(InputMultiplexer inputMultiplexer) {
		inputMultiplexer.addProcessor(this);
		inputMultiplexer.addProcessor(stageCarte);
		inputMultiplexer.addProcessor(stageHUD);
	}

	@Override
	public void create(final EcranManagerAbstract ecranManager) {
		Parametre.PAUSE = true;
		stageHUD = new Stage();

		stageCarte = new Stage();
		cameraCarte = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		stageCarte.getViewport().setCamera(cameraCarte);

		stageFond = new Stage();
		
		resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		skin = new Skin(Gdx.files.internal("ui-editor/neonuiblue/neonuiblue.json"));
		
		//FOND
		Table tableFond = new Table();
		tableFond.setFillParent(true);
		Image imgFond = new Image(new Texture(Gdx.files.internal("logo/fond.png")));
		tableFond.add(imgFond).expand().fill();
		stageFond.addActor(tableFond);

		// HUD
		Table table = new Table();
		table.setFillParent(true);
		table.setDebug(Parametre.MODE_DEBUG);

		table.top();
		table.add().expandX().fillX();
		Texture barre = new Texture(Gdx.files.internal("logo/barre_1.png"));
		Image img = new Image(new Texture(Gdx.files.internal("logo/joueur_0_logo.png")));
		
		table.add(img).width(50).height(50);
		
		table.add(new Image(barre)).width(100).height(50);
		table.add(new Label("E2 IMG", skin)).width(50).height(50);
		table.add(new Label("E2 %WIN", skin)).width(100).height(30);
		table.add(new Label("E3 IMG", skin)).width(50).height(50);
		table.add(new Label("E3 %WIN", skin)).width(100).height(30);
		table.add(new Label("E4 IMG", skin)).width(50).height(50);
		table.add(new Label("E4 %WIN", skin)).width(100).height(30);
		table.add(new Label("E5 IMG", skin)).width(50).height(50);
		table.add(new Label("E5 %WIN", skin)).width(100).height(30);
		table.add().expandX().fillX();
		table.row();

		stageHUD.addActor(table);
		stageHUD.setDebugAll(Parametre.MODE_DEBUG);

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

		// création du plateau (métier)
		jeuService = new JeuService();
		this.jeuService.zones = new Zone[7][13];
		for (int i = 0; i < 7; i++) {
			tableCarte.row();
			tableCarte.add().expandX().fillX();
			for (int j = 0; j < 13; j++) {
				final Zone zone = this.jeuService.genererZone(i, j);
				Label label = new Label("[" + i + "][" + j + "]", skin);
				label.addListener(new LabelListenner(zone, i, j, this.jeuService.joueurs));
				labelZone.add(label);
				tableCarte.add(label).width(128).height(128);
			}
			tableCarte.add().expandX().fillX();
		}

		stageCarte.addActor(tableCarte);
		

		// lance le jeu
		AmeliorationManager.initList();
		jeuService.startGame(1);

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
					img.setPosition(label.getX() + 32, label.getY() + 32);
					stageCarte.addActor(img);
					labelListenner.idJoueursPresent.add(idJoueur);
				}

			}
			stageHUD.act(Gdx.graphics.getDeltaTime());
			stageCarte.act(Gdx.graphics.getDeltaTime());
			stageFond.act(Gdx.graphics.getDeltaTime());
			stageFond.draw();
			stageHUD.draw();
			stageCarte.draw();
			
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
		// viewport.update(width, height);
	}

}
