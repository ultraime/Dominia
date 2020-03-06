package ultraime.game.dominia.composant;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.ultraime.game.gdxtraime.parametrage.Parametre;

import ultraime.game.dominia.entite.Joueur;
import ultraime.game.dominia.entite.Personnage;
import ultraime.game.dominia.entite.Zone;

public class LabelListenner extends ClickListener {
	public static boolean JOUEUR_PLACE = false;
	public Zone zone;
	public int posX, posY;
	public ArrayList<Integer> idJoueursPresent = new ArrayList<Integer>();
	List<Joueur> joueurs;
	/**
	 * @param zone
	 * @param posX
	 * @param posY
	 * @param joueurs 
	 */
	public LabelListenner(final Zone zone, final int posX, final int posY, List<Joueur> joueurs) {
		this.zone = zone;
		this.posX = posX;
		this.posY = posY;
		this.joueurs = joueurs;
	}

	@Override
	public void clicked(InputEvent event, float x, float y) {
		if (!JOUEUR_PLACE && zone.isActif) {
			JOUEUR_PLACE = true;
			Joueur joueur = this.joueurs.get(0);
			Personnage personnage = new Personnage(joueur.id, joueur.caracteristiqueDeBase);
			personnage.nbPersonnage = 200;
			zone.addPersonnage(personnage);
			Parametre.PAUSE = false;
		}

		if (Parametre.MODE_DEBUG) {
			String complement = "";
			if (!zone.isActif) {
				complement = " (zone non actif)";
			}
			System.out.println("Clique sur Zone" + "[" + posX + "][" + posY + "]" + complement);
		}
	}

}
