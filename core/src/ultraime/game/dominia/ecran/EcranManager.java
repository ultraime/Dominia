package ultraime.game.dominia.ecran;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.ultraime.game.gdxtraime.ecran.EcranDebug;
import com.ultraime.game.gdxtraime.ecran.EcranManagerAbstract;
import com.ultraime.game.gdxtraime.parametrage.Parametre;

/**
 * @author ultraime Gï¿½re l'affichage des ï¿½crans
 */
public class EcranManager extends EcranManagerAbstract {

	/**
	 * Menu démarrage
	 */
	public EcranPrincipal ecranPrincipal;

	/**
	 * pour des tests. Il n'y a pas d'ihm.
	 */
	public EcranTest ecranTest;

	/**
	 * Ecran du jeu
	 */
	public EcranGame ecranGame;

	@Override
	public void create() {
		Parametre.initLangue();
		Gdx.graphics.setTitle(Parametre.TITRE_JEU);
		ecranDebug = new EcranDebug(this);

		ecranPrincipal = new EcranPrincipal();
		// initialiserEcran(ecranPrincipal);

		ecranTest = new EcranTest();
		ecranGame = new EcranGame();

		initialiserEcran(ecranPrincipal);
		ecranActuel.create(this);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		ecranActuel.render();

		// if (Parametre.MODE_DEBUG && this.ecranDebug != null) {
		// this.ecranDebug.render();
		// }
		this.ecranDebug.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		ecranActuel.resize(width, height);
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

}