package ultraime.game.dominia.ecran;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
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
	private Stage stageHUD;
	private Stage stageCarte;
	private Skin skin;
	private OrthographicCamera cameraCarte;

	@Override
	public void changerEcran(InputMultiplexer inputMultiplexer) {
		inputMultiplexer.addProcessor(this);
		inputMultiplexer.addProcessor(stageCarte);
		inputMultiplexer.addProcessor(stageHUD);
	}

	@Override
	public void create(final EcranManagerAbstract ecranManager) {
		stageHUD = new Stage();

		stageCarte = new Stage(new ScreenViewport());
		cameraCarte = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		stageCarte.getViewport().setCamera(cameraCarte);

		resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		skin = new Skin(Gdx.files.internal("ui-editor/neonuiblue/neonuiblue.json"));

		// HUD
		Table table = new Table();
		table.setFillParent(true);
		table.setDebug(Parametre.MODE_DEBUG);

		table.top();
		table.add().expandX().fillX();
		table.add(new Label("E1 IMG", skin)).width(50).height(50);
		table.add(new Label("E1 %WIN", skin)).width(100).height(30);
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

		final Texture zone_normal_base1 = new Texture(Gdx.files.internal("carte/zone_normal_base1.png"));
		final Texture zone_glace_base1 = new Texture(Gdx.files.internal("carte/zone_glace_base1.png"));
		final Texture zone_chaude_base1 = new Texture(Gdx.files.internal("carte/zone_chaude_base1.png"));

		final Texture eau1 = new Texture(Gdx.files.internal("carte/eau1.png"));
		for (int i = 0; i < 7; i++) {
			tableCarte.row();
			tableCarte.add().expandX().fillX();
			for (int j = 0; j < 13; j++) {
				Label label = new Label("[" + i + "][" + j + "]", skin);
				label.addListener(new ClickListener(){
			        @Override
			        public void clicked(InputEvent event, float x, float y) {
			            System.out.println("clique");
			        }
			    });
		
				tableCarte.add(label).width(128).height(128);
			}
			tableCarte.add().expandX().fillX();
		}
		
		stageCarte.addActor(tableCarte);
		
		
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stageHUD.act(Gdx.graphics.getDeltaTime());
		stageCarte.act(Gdx.graphics.getDeltaTime());
		
		stageHUD.draw();
		stageCarte.draw();
		
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
		stageHUD.getViewport().update(width, height, true);
		stageCarte.getViewport().update(width, height, true);
	}

}
