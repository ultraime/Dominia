package ultraime.game.dominia.ecran;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.ultraime.game.gdxtraime.ecran.Ecran;
import com.ultraime.game.gdxtraime.ecran.EcranManagerAbstract;
import com.ultraime.game.gdxtraime.parametrage.Parametre;

/**
 * @author ultraime Ecran de base pour d�marrer une partie
 */
public class EcranTestEcran extends Ecran {
	private Stage stage;
	private Skin skin;
	private OrthographicCamera camera;

	@Override
	public void changerEcran(InputMultiplexer inputMultiplexer) {
		inputMultiplexer.addProcessor(this);
	}

	@Override
	public void create(final EcranManagerAbstract ecranManager) {
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		stage = new Stage();
		stage.getViewport().setCamera(camera);
		resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		skin = new Skin(Gdx.files.internal("ui-editor/neonuiblue/neonuiblue.json"));

		// Table table = new Table();
		// table.setFillParent(true);
		// table.setDebug(Parametre.MODE_DEBUG);
		//
		// table.top();
		// table.add(new Label("E1 IMG", skin)).width(50).height(50);
		// table.add(new Label("E1 %WIN", skin)).width(100).height(30);
		// table.add(new Label("E2 IMG", skin)).width(50).height(50);
		// table.add(new Label("E2 %WIN", skin)).width(100).height(30);
		// table.add(new Label("E3 IMG", skin)).width(50).height(50);
		// table.add(new Label("E3 %WIN", skin)).width(100).height(30);
		// table.add(new Label("E4 IMG", skin)).width(50).height(50);
		// table.add(new Label("E4 %WIN", skin)).width(100).height(30);
		// table.add(new Label("E5 IMG", skin)).width(50).height(50);
		// table.add(new Label("E5 %WIN", skin)).width(100).height(30);
		// table.add(Actor).colspan(1).expandX();
		// add(Actor0).colspan(1).expandX();

		// table.add(new Label("MENU DROITE",
		// skin)).width(200).height(Gdx.graphics.getHeight());
		// table2.add(new Label("MENU DROITE",
		// skin)).width(200).height(Gdx.graphics.getHeight());

		// table.add(new Label("MENU DROITE",
		// skin)).width(200).height(Gdx.graphics.getHeight());
		// table.add(new Label("bonjour", skin)).width(300).height(30);
		// stage.addActor(table);

		///////// EXEMPLE//////
		// Table table = new Table();
		// table.defaults().pad(10F);
		// table.setFillParent(true);
		//
		// Label label = new Label("PLAYER NAME", skin);
		// label.setAlignment(Align.center);
		//
		// Table first_table = new Table();
		// first_table.setDebug(true);
		// first_table.add(new Label("FIRST TABLE", skin));
		//
		// Table second_table = new Table();
		// second_table.add(new Label("SECOND TABLE", skin));
		//
		// table.add(label).colspan(2).fillX();
		// table.row();
		// table.add(first_table).expand();
		// table.add(second_table).expand();
		//
		// stage.addActor(table);
		// stage.setDebugAll(true);

		Table table = new Table();
//		table.defaults().pad(10F);
		table.setFillParent(true);

		Label label = new Label("PLAYER NAME", skin);
//		label.setAlignment(Align.center);

		Table first_table = new Table();
		first_table.setDebug(true);
		
		 first_table.top();
		 first_table.add(new Label("E1 IMG", skin)).width(50).height(50);
		 first_table.add(new Label("E1 %WIN", skin)).width(100).height(30);
		 first_table.add(new Label("E2 IMG", skin)).width(50).height(50);
		 first_table.add(new Label("E2 %WIN", skin)).width(100).height(30);
		 first_table.add(new Label("E3 IMG", skin)).width(50).height(50);
		 first_table.add(new Label("E3 %WIN", skin)).width(100).height(30);
		 first_table.add(new Label("E4 IMG", skin)).width(50).height(50);
		 first_table.add(new Label("E4 %WIN", skin)).width(100).height(30);
		 first_table.add(new Label("E5 IMG", skin)).width(50).height(50);
		 first_table.add(new Label("E5 %WIN", skin)).width(100).height(30);
		
		
//		first_table.add(new Label("FIRST TABLE", skin));

		Table second_table = new Table();
		second_table.add(new Label("SECOND TABLE", skin));
		table.top();
		table.add(first_table).width(Gdx.graphics.getWidth() - 300).expandY();
		//table.add(second_table).expand();

		stage.addActor(table);
		stage.setDebugAll(true);

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
