package ultraime.game.dominia.ecran;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.ultraime.game.gdxtraime.ecran.Ecran;
import com.ultraime.game.gdxtraime.ecran.EcranManagerAbstract;
import com.ultraime.game.gdxtraime.parametrage.Parametre;

import ultraime.game.dominia.composant.StackAmelioration;

/**
 * @author ultraime Ecran de base pour d�marrer une partie
 */
public class EcranAmelioration extends Ecran {

	private Stage stageBoutonBas;
	private Stage stageAmerlioration;
	private Stage stageUpgrade;
	private Skin skin;
	private ArrayList<StackAmelioration> stackAmeliorations = new ArrayList<StackAmelioration>();

	@Override
	public void changerEcran(InputMultiplexer inputMultiplexer) {
		inputMultiplexer.addProcessor(this);
		inputMultiplexer.addProcessor(stageBoutonBas);
		inputMultiplexer.addProcessor(stageUpgrade);

	}

	@Override
	public void create(final EcranManagerAbstract ecranManagerAb) {
		this.ecranManager = (EcranManager) ecranManagerAb;
		this.batch = new SpriteBatch();
		stageBoutonBas = new Stage();
		stageAmerlioration = new Stage();
		stageUpgrade = new Stage();
		resize(1920,1080);
		skin = new Skin(Gdx.files.internal("ui-editor/neonuiblue/neonuiblue.json"));
		//param general
		int hauteur_btn = 50;
		int largeur_btn = 200;
		//stageBoutonBas
		Table tableBtnBas = new Table();
		tableBtnBas.setDebug(Parametre.MODE_DEBUG);
		tableBtnBas.setFillParent(true);
		tableBtnBas.bottom();

		TextButton btnMenuCarte = new TextButton(Parametre.bundle.get("txt.menu.carte"), skin);
		btnMenuCarte.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				ecranManager.initialiserEcran(ecranManager.ecranGame);
			}
		});
		TextButton btnMenuAmelioration = new TextButton(Parametre.bundle.get("txt.menu.amelioration"), skin);

		tableBtnBas.add(btnMenuCarte).height(hauteur_btn).width(largeur_btn);
		tableBtnBas.add(btnMenuAmelioration).height(hauteur_btn).width(largeur_btn);

		tableBtnBas.add().expandX().fillX();
		stageBoutonBas.addActor(tableBtnBas);

		
		//stageAmerlioration
		Table tableCase = new Table();
		tableCase.setDebug(Parametre.MODE_DEBUG);
		tableCase.setFillParent(true);

		StackAmelioration stack = new StackAmelioration("griffe");
		stack.changeColorCase(StackAmelioration.BLEU);
		tableCase.add(stack).width(96).height(96);

		stageAmerlioration.addActor(tableCase);
		
		//stageUpgrade
		Table tableUpgrade = new Table();
		tableUpgrade.setDebug(Parametre.MODE_DEBUG);
		tableUpgrade.setFillParent(true);
		tableUpgrade.bottom();
		Image imgCadre = new Image(new Texture(Gdx.files.internal("ui/cadre.png")));
		tableUpgrade.add(imgCadre).height(250).width(800).padBottom(hauteur_btn);
		
		Button button = new Button(skin);
		button.setPosition(550, 40);
		stageUpgrade.addActor(tableUpgrade);
		stageUpgrade.addActor(button);
		
		Image imgCadre2 = new Image(new Texture(Gdx.files.internal("ui/cadre.png")));
		imgCadre2.setPosition(560, 50);
		imgCadre2.setWidth(800);
		imgCadre2.setHeight(250);
		stageUpgrade.addActor(imgCadre2);
		
		
		resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stageBoutonBas.act(Gdx.graphics.getDeltaTime());
		stageAmerlioration.act(Gdx.graphics.getDeltaTime());
		stageUpgrade.act(Gdx.graphics.getDeltaTime());
		
		stageBoutonBas.draw();
		stageUpgrade.draw();
		stageAmerlioration.draw();
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
		return false;
	}

	@Override
	public void resize(int width, int height) {
		stageBoutonBas.getViewport().update(width, height, true);
		stageAmerlioration.getViewport().update(width, height, true);
		stageUpgrade.getViewport().update(width, height, true);
	}

}
