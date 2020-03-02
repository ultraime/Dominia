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
			if(i == 1) {
//				j.caracteristiqueDeBase.fertilite = 35;
//				j.caracteristiqueDeBase.vitalite = 10;
//				j.caracteristiqueDeBase.migration = 30;
			}
			joueurs.add(j);
		}
	}

	public void creerZone() {
		zones = new Zone[3][3];
		zones[0][0] = new Zone();
		zones[0][1] = new Zone();
		zones[0][2] = new Zone();

		zones[1][0] = new Zone();
		zones[1][1] = new Zone();
		zones[1][2] = new Zone();

		zones[2][0] = new Zone();
		zones[2][1] = new Zone();
		zones[2][2] = new Zone();

		for (int i = 0; i < this.joueurs.size(); i++) {
			Joueur joueur = this.joueurs.get(i);
			Personnage personnage = new Personnage(joueur.id, joueur.caracteristiqueDeBase);
			personnage.nbPersonnage = 200;
			
			zones[0][0].addPersonnage(personnage);
		}
	}

	public double getAllPersonnageFromJoueur(final int idJoueur) {
		double nbPersonnages = 0;
		for (int x = 0; x < zones.length; x++) {
			for (int y = 0; y < zones[x].length; y++) {
				nbPersonnages += zones[x][y].getNbPersonnageFromJoueur(idJoueur);
			}
		}
		return nbPersonnages;
	}

	public JeuService() {
	}

}
