package ultraime.game.dominia.service;

import java.util.ArrayList;
import java.util.List;

import ultraime.game.dominia.entite.Joueur;
import ultraime.game.dominia.entite.Personnage;
import ultraime.game.dominia.entite.Zone;

public class JeuService {

	/**
	 * le joueurs 1 est toujours le vrai joueur
	 */
	public List<Joueur> joueurs = new ArrayList<Joueur>();

	public Zone[][] zones;

	public void creerJoueurs(final int nbJoueur) {
		for (int i = 0; i < nbJoueur; i++) {
			final Joueur j = new Joueur(i);
			joueurs.add(j);
		}
	}

	public void creerZone() {
		zones = new Zone[2][1];
		zones[0][0] = new Zone();
		zones[1][0] = new Zone();
		Joueur joueur = this.joueurs.get(0);
		Personnage personnage = new Personnage(joueur.id, joueur.caracteristiqueDeBase);
		personnage.nbPersonnage = 200;
		zones[0][0].addPersonnage(personnage);
	}

	public JeuService() {
	}

}
