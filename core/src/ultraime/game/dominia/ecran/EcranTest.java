package ultraime.game.dominia.ecran;

import java.text.DecimalFormat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ultraime.game.gdxtraime.ecran.Ecran;
import com.ultraime.game.gdxtraime.ecran.EcranManagerAbstract;

import ultraime.game.dominia.entite.Caracteristique;
import ultraime.game.dominia.service.JeuService;

/**
 * @author ultraime Ecran de base pour d�marrer une partie
 */
public class EcranTest extends Ecran {

	private JeuService jeuService;
	static int BOUCLE = 0;

	@Override
	public void changerEcran(InputMultiplexer inputMultiplexer) {
		inputMultiplexer.addProcessor(this);
	}

	@Override
	public void create(final EcranManagerAbstract ecranManager) {
		this.ecranManager = (EcranManager) ecranManager;
		this.batch = new SpriteBatch();
		this.jeuService = new JeuService();
		this.jeuService.creerJoueurs(1);
		this.jeuService.creerZone();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		// int nb = this.jeuService.zones[0][0].getNbPersonnageFromJoueur(0);
		// System.err.println(nb);
		// System.err.println(this.jeuService.zones[0][0].getCaracteristiqueMoyenFromJoueur(0));

		// System.err.println(this.jeuService.zones[0][0].getNbPersonnageFromJoueur(0));
		BOUCLE++;
		for (int x = 0; x < this.jeuService.zones.length; x++) {
			for (int y = 0; y < this.jeuService.zones[x].length; y++) {
				final Caracteristique caracteristique = this.jeuService.zones[x][y]
						.getCaracteristiqueMoyenFromJoueur(0);
				this.jeuService.zones[x][y].gererNaissance(0, caracteristique);
				this.jeuService.zones[x][y].gererVie(0);
				this.jeuService.zones[x][y].gererMigration(0, this.jeuService.zones, x, y);
				
				DecimalFormat decimalPrintFormat = new DecimalFormat("#,##0");
				String nbPerso="";
				nbPerso =  decimalPrintFormat.format(this.jeuService.zones[x][y].getNbPersonnageFromJoueur(0));
				System.out.println("Boucle : " + BOUCLE + " population zone[" + x + "][" + y + "] = "
						+nbPerso );

			}
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
		return false;
	}

	@Override
	public void resize(int width, int height) {
	}

}
