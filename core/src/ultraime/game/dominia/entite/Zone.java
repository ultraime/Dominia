package ultraime.game.dominia.entite;

import java.util.ArrayList;
import java.util.List;

public class Zone {

	private List<Personnage> listPersonage = new ArrayList<Personnage>();

	public Zone() {
	}

	public void addPersonnage(Personnage personnage, final int nbPersonnages) {
		for (int i = 0; i < nbPersonnages; i++) {
			final Personnage personnageNew = new Personnage(personnage.idJoueur, personnage.caracteristique);
			listPersonage.add(personnageNew);
		}
	}

	public int getPersonnageFromJoueur(final int idJoueur) {
		int nbPersonnage = (int) listPersonage.stream().filter(p -> p.idJoueur == idJoueur).count();
		return nbPersonnage;
	}

}
