package ultraime.game.dominia.entite;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Zone {
	static int BOUCLE = 0;
	private List<Personnage> listPersonage = new ArrayList<Personnage>();

	public Zone() {
	}

	/**
	 * RG basé sur la fertilité.
	 * 
	 * @param idJoueur
	 * @param caracteristique (moyenne)
	 */
	public void gererNaissance(final int idJoueur, final Caracteristique caracteristique) {
		int fertilite = caracteristique.fertilite;
		int nbPersonnage = getNbPersonnageFromJoueur(idJoueur);
		float nbRandom = new Random().nextInt(fertilite) + 1;
		int diviseur = 10;
		if (nbPersonnage > 500000) {
			diviseur += 20;
		}
		if (nbPersonnage > 1000000) {
			diviseur += 30;
		}
		if (nbPersonnage > 2000000) {
			diviseur += 30;
		}
		if (nbPersonnage > 3000000) {
			diviseur += 30;
		}
		if (nbPersonnage > 4000000) {
			diviseur += 30;
		}
		if (nbPersonnage > 5000000) {
			diviseur += 50;
		}
		nbRandom = nbRandom / diviseur;
		int nbNewPersonnages = (int) (((nbPersonnage * nbRandom) / 100) + 1);
		BOUCLE++;
		System.err.println(
				"Boucle :" + BOUCLE + " Total : " + getNbPersonnageFromJoueur(idJoueur) + " Add :" + nbNewPersonnages);

		Personnage personnage = new Personnage(idJoueur, caracteristique);
		personnage.nbPersonnage = nbNewPersonnages;
		addPersonnage(personnage);

	}

	public void gererVie(final int idJoueur) {
		List<Personnage> personnages = getPersonnageFromJoueur(idJoueur).collect(Collectors.toList());
		List<Personnage> personnagesMort = new ArrayList<Personnage>();
		for (int i = 0; i < personnages.size(); i++) {
			boolean isMort = personnages.get(i).perdreVie();
			if (isMort) {
				personnagesMort.add(personnages.get(i));
			}
		}
		personnages.removeAll(personnagesMort);
		
	}

	public void addPersonnage(Personnage personnage) {
		listPersonage.add(personnage);

	}

	public Stream<Personnage> getPersonnageFromJoueur(final int idJoueur) {
		return listPersonage.stream().filter(p -> p.idJoueur == idJoueur);
	}

	public int getNbPersonnageFromJoueur(final int idJoueur) {
		AtomicInteger ordinal = new AtomicInteger(0);
		getPersonnageFromJoueur(idJoueur).forEach(p -> ordinal.set(p.nbPersonnage + ordinal.intValue()));
		return ordinal.intValue();
	}

	private int getNbListePersonnageFromJoueur(final int idJoueur) {
		return (int) getPersonnageFromJoueur(idJoueur).count();
	}

	public Caracteristique getCaracteristiqueMoyenFromJoueur(final int idJoueur) {
		List<Personnage> personnages = getPersonnageFromJoueur(idJoueur).collect(Collectors.toList());
		Caracteristique caracteristique = new Caracteristique();
		caracteristique.clear();
		personnages.forEach(p -> caracteristique.addition(p.caracteristique));
		caracteristique.divisionStats(getNbListePersonnageFromJoueur(idJoueur));
		return caracteristique;
	}

}
