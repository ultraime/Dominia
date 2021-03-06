package ultraime.game.dominia.ecran;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.ultraime.game.gdxtraime.ecran.Ecran;
import com.ultraime.game.gdxtraime.ecran.EcranManagerAbstract;
import com.ultraime.game.gdxtraime.parametrage.Parametre;

/**
 * @author ultraime Ecran de base pour d�marrer une partie
 */
public class EcranPrincipal extends Ecran {

	private Stage stage;
	private Skin skin;

	@Override
	public void changerEcran(InputMultiplexer inputMultiplexer) {
		inputMultiplexer.addProcessor(this);
	}

	@Override
	public void create(final EcranManagerAbstract ecranManager) {
		this.ecranManager = (EcranManager) ecranManager;
		this.batch = new SpriteBatch();
		// old method
		String label = Parametre.bundle.get("txt.menu.start");

		stage = new Stage();

		skin = new Skin(Gdx.files.internal("ui-editor/neonuiblue/neonuiblue.json"));
		stage = new Stage(new ScreenViewport());

		TextButton buttonLancerPartie = new TextButton(label, skin);
		buttonLancerPartie.setWidth(250);
		buttonLancerPartie.setHeight(50);

		final EcranManager ecran = (EcranManager) ecranManager;
		buttonLancerPartie.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				ecran.ecranTest.create(ecran);
				ecran.initialiserEcran(ecran.ecranTest);
			}
		});
		String label2 = Parametre.bundle.get("txt.menu.start.test");
		TextButton buttonLancerPartieEcran = new TextButton(label2, skin);
		buttonLancerPartieEcran.setWidth(250);
		buttonLancerPartieEcran.setHeight(50);
		buttonLancerPartieEcran.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				ecran.ecranGame.create(ecran);
				ecran.ecranAmelioration.create(ecran);
				ecran.initialiserEcran(ecran.ecranGame);
			}
		});
		// table
		Table table = new Table();
		table.setFillParent(true);
		table.setDebug(Parametre.MODE_DEBUG);

		table.add(buttonLancerPartie).width(buttonLancerPartieEcran.getWidth())
				.height(buttonLancerPartieEcran.getHeight()).pad(buttonLancerPartieEcran.getHeight());
		table.row();
		table.add(buttonLancerPartieEcran).width(buttonLancerPartieEcran.getWidth())
				.height(buttonLancerPartieEcran.getHeight());
		stage.addActor(table);

		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
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
		stage.getViewport().update(width, height, true);
	}

}
