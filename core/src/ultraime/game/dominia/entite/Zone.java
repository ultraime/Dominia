package ultraime.game.dominia.entite;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Zone {
	private List<Personnage> listPersonage = new ArrayList<Personnage>();

	/**
	 * if actif = false = zone vide.
	 */
	public Boolean isActif = true;

	public Zone() {
	}

	/**
	 * Règle : nb nouveau perso = [1 à X% fertilité]/100 + 1]
	 * 
	 * @param idJoueur
	 * @param ameliorations
	 * @param caracteristique
	 *            (moyenne)
	 */
	public void gererNaissance(final int idJoueur, final List<Amelioration> ameliorations,
			final Caracteristique caracteristique) {

		double nbPersonnage = getNbPersonnageFromJoueur(idJoueur);
		if (nbPersonnage > 0) {
			int diviseurMinFertil = 2;
			int maxFertilite = caracteristique.fertilite;
			int minfertilite = maxFertilite / diviseurMinFertil + 1;
			double nbNewPersonnages = new Random().nextInt(maxFertilite) + minfertilite;
			nbNewPersonnages += getNbListePersonnageFromJoueur(idJoueur);
			Caracteristique caracteristiqueNew = new Caracteristique(caracteristique);
			List<Personnage> personnagesMort = gererVie(idJoueur);
			if (personnagesMort.size() > 0) {
				personnagesMort.get(0).nbPersonnage += nbNewPersonnages;
				personnagesMort.get(0).caracteristique = caracteristiqueNew;
				personnagesMort.get(0).age = caracteristiqueNew.vitalite;
				gererBonusADN(personnagesMort.get(0), ameliorations);
				personnagesMort.remove(0);
				for (int i = 0; i < personnagesMort.size(); i++) {
					Personnage personnageMort = personnagesMort.get(i);
					final Caracteristique caracteristiqueNew2 = new Caracteristique(caracteristique);
					personnageMort.caracteristique = caracteristiqueNew2;
					personnageMort.age = caracteristiqueNew2.vitalite;
				}
			} else {
				Personnage personnage = new Personnage(idJoueur, caracteristiqueNew);
				personnage.nbPersonnage = nbNewPersonnages;
				addPersonnage(personnage);
				gererBonusADNnew(personnage, ameliorations);
			}
		}
	}

	private void gererBonusADNnew(Personnage personnage, List<Amelioration> ameliorations) {
		List<Personnage> personnages = getPersonnageFromJoueur(0).collect(Collectors.toList());

		OptionalInt indexOpt = IntStream.range(0, personnages.size()).filter(i -> personnage.equals(personnages.get(i)))
				.findFirst();
		final int nb = indexOpt.getAsInt() - 1;
		final Personnage personnageParent = personnages.get(nb);
		for (int i = 0; i < ameliorations.size(); i++) {
			final Amelioration ameliorationRef = ameliorations.get(i);
			if (!personnage.ameliorations.contains(ameliorationRef)) {
				if (!personnageParent.ameliorations.contains(ameliorationRef)) {
					personnage.caracteristique.addition(ameliorationRef.caracteristique);
				}
				personnage.ameliorations.add(ameliorationRef);
			}
		}

	}

	private void gererBonusADN(Personnage personnage, List<Amelioration> ameliorations) {
		for (int i = 0; i < ameliorations.size(); i++) {
			final Amelioration ameliorationRef = ameliorations.get(i);
			if (!personnage.ameliorations.contains(ameliorationRef)) {
				personnage.ameliorations.add(ameliorationRef);
				personnage.caracteristique.addition(ameliorationRef.caracteristique);
			}
		}
	}

	/**
	 * @param idJoueur
	 * @param caracteristique
	 * @param zones
	 * @param x
	 *            -> de la zone actuel
	 * @param y
	 *            -> de la zone actuel Règle : Pour chaque groupe: % chance de
	 *            migrer = [ X% migration]/100 + 1]
	 */
	public void gererMigration(final int idJoueur, Zone[][] zones, final int x, final int y) {
		List<Personnage> personnages = getPersonnageFromJoueur(idJoueur).collect(Collectors.toList());
		for (int i = 0; i < personnages.size(); i++) {
			Personnage perso = personnages.get(i);
			int pourcentageMigration = perso.caracteristique.migration + 1;
			int nbRandom = new Random().nextInt(100000) + 1;
			if (pourcentageMigration >= nbRandom) {
				boolean exit = false;
				do {
					int newX = randomLessToOne();
					int newY = randomLessToOne();
					if (x + newX < zones.length && x + newX > -1) {
						if (y + newY < zones[x + newX].length && y + newY > -1) {
							if (zones[x + newX][y + newY].isActif) {
								this.listPersonage.remove(perso);
								zones[x + newX][y + newY].addPersonnage(perso);
								exit = true;
							}
						}
					}
				} while (!exit);
			}
		}
	}

	private List<Personnage> gererVie(final int idJoueur) {
		List<Personnage> personnages = getPersonnageFromJoueur(idJoueur).collect(Collectors.toList());
		List<Personnage> personnagesMort = new ArrayList<Personnage>();
		for (int i = 0; i < personnages.size(); i++) {
			boolean isMort = personnages.get(i).perdreVie();
			if (isMort) {
				personnagesMort.add(personnages.get(i));
			}
		}
		return personnagesMort;

	}

	public void addPersonnage(Personnage personnage) {
		listPersonage.add(personnage);

	}

	public Stream<Personnage> getPersonnageFromJoueur(final int idJoueur) {
		return listPersonage.stream().filter(p -> p.idJoueur == idJoueur);
	}

	public double getNbPersonnageFromJoueur(final int idJoueur) {
		double nbPersonnages[] = { 0 };
		getPersonnageFromJoueur(idJoueur).forEach(p -> nbPersonnages[0] = nbPersonnages[0] + p.nbPersonnage);
		return nbPersonnages[0];
	}

	public int getNbListePersonnageFromJoueur(final int idJoueur) {
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

	private int randomLessToOne() {
		int random = new Random().nextInt(3) + 1;
		if (random == 2) {
			random = 0;
		} else if (random == 3) {
			random = -1;
		}
		return random;
	}

}
