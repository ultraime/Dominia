package ultraime.game.dominia.ecran;

import java.text.DecimalFormat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ultraime.game.gdxtraime.ecran.Ecran;
import com.ultraime.game.gdxtraime.ecran.EcranManagerAbstract;

import ultraime.game.dominia.entite.Caracteristique;
import ultraime.game.dominia.entite.Joueur;
import ultraime.game.dominia.service.AmeliorationManager;
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
		AmeliorationManager.initList();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		BOUCLE++;
		if (BOUCLE == 20) {
			this.jeuService.joueurs.get(0).ameliorations.add(AmeliorationManager.ameliorations.get(0));
		}
		DecimalFormat decimalPrintFormat = new DecimalFormat("#,##0");
		for (int i = 0; i < this.jeuService.joueurs.size(); i++) {
			final Joueur joueur = this.jeuService.joueurs.get(i);
			final int idJoueur = joueur.id;
			System.out.println("=============JOUEUR " + idJoueur + " ========================");
			for (int x = 0; x < this.jeuService.zones.length; x++) {
				for (int y = 0; y < this.jeuService.zones[x].length; y++) {
					final Caracteristique caracteristique = this.jeuService.zones[x][y]
							.getCaracteristiqueMoyenFromJoueur(idJoueur);
					if(	caracteristique.fertilite > 1) {
						System.err.println("population zone[" + x + "][" + y + "] ="+caracteristique);
					}
					this.jeuService.zones[x][y].gererNaissance(idJoueur, joueur.ameliorations, caracteristique);
				
//				this.jeuService.zones[x][y].gererVie(0);
					this.jeuService.zones[x][y].gererMigration(idJoueur, this.jeuService.zones, x, y);

					String nbPerso = "";
					nbPerso = decimalPrintFormat
							.format(this.jeuService.zones[x][y].getNbPersonnageFromJoueur(idJoueur));
//					System.out.println("Boucle : " + BOUCLE + " population zone[" + x + "][" + y + "] = " + nbPerso);
				}
			}
//			System.out.println("Boucle : " + BOUCLE + " Nombre total de personnage : "
//					+ decimalPrintFormat.format(this.jeuService.getAllPersonnageFromJoueur(idJoueur)));

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
