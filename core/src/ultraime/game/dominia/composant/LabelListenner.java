package ultraime.game.dominia.composant;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.ultraime.game.gdxtraime.parametrage.Parametre;

import ultraime.game.dominia.ecran.menu.MenuHud;
import ultraime.game.dominia.entite.Joueur;
import ultraime.game.dominia.entite.Personnage;
import ultraime.game.dominia.entite.Zone;

public class LabelListenner extends ClickListener {
	public static boolean JOUEUR_PLACE = false;
	public Zone zone;
	public int posX, posY;
	public ArrayList<Integer> idJoueursPresent = new ArrayList<Integer>();
	public List<Joueur> joueurs;
	public MenuHud menuInfosRegion;

	/**
	 * @param zone
	 * @param posX
	 * @param posY
	 * @param joueurs
	 * @param menuInfosRegion
	 */
	public LabelListenner(final Zone zone, final int posX, final int posY, List<Joueur> joueurs,
			MenuHud menuInfosRegion) {
		this.zone = zone;
		this.posX = posX;
		this.posY = posY;
		this.joueurs = joueurs;
		this.menuInfosRegion = menuInfosRegion;
	}

	@Override
	public void clicked(InputEvent event, float x, float y) {
		// Premier Clique, pour placer l'entité
		if (!JOUEUR_PLACE && zone.isActif) {
			JOUEUR_PLACE = true;
			Joueur joueur = this.joueurs.get(0);
			Personnage personnage = new Personnage(joueur.id, joueur.caracteristiqueDeBase);
			personnage.nbPersonnage = 200;
			zone.addPersonnage(personnage);
			Parametre.PAUSE = false;
		}else if(zone.isActif) {
			menuInfosRegion.showMenu(true);
		}

	}

}
