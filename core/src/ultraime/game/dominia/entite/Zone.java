package ultraime.game.dominia.entite;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Zone {
	private List<Personnage> listPersonage = new ArrayList<Personnage>();

	public Zone() {
	}

	/**
	 * R�gle : nb nouveau perso = [1 � X% fertilit�]/100 + 1]
	 * 
	 * @param idJoueur
	 * @param caracteristique
	 *            (moyenne)
	 */
	public void gererNaissance(final int idJoueur, final Caracteristique caracteristique) {

		double nbPersonnage = getNbPersonnageFromJoueur(idJoueur);

		if (nbPersonnage > 0) {
			float reducteur = 0.5f;
			if (nbPersonnage > 100000) {
				reducteur -= 0.1f;
			}
			if (nbPersonnage > 1000000) {
				reducteur -= 0.02f;
			}
			if (nbPersonnage > 3000000) {
				reducteur -= 0.02f;
			}
			if (nbPersonnage > 5000000) {
				reducteur -= 0.05f;
			}
			if (nbPersonnage > 10000000) {
				reducteur -= 0.05f;
			}
			if (nbPersonnage > 20000000) {
				reducteur -= 0.05f;
			}
			if (nbPersonnage > 30000000) {
				reducteur -= 0.03f;
			}
			int maxFertilite = (int) (caracteristique.fertilite * reducteur);
			if (maxFertilite <= 0) {
				maxFertilite = 1;
			}
			int diviseurMinFertil = 2;

			int minfertilite = maxFertilite / diviseurMinFertil + 1;
			float nbRandom = new Random().nextInt(maxFertilite) + minfertilite;
			// int diviseur = 3;
			//
			// if (nbPersonnage > 500000) {
			// diviseur += 1;
			// }
			// if (nbPersonnage > 3000000) {
			// diviseur += 2;
			// }
			// if (nbPersonnage > 10000000) {
			// diviseur += 2;
			// }
			// if (nbPersonnage > 15000000) {
			// diviseur += 2;
			// }
			// nbRandom = nbRandom / diviseur;

			double nbNewPersonnages = (int) (((nbPersonnage * nbRandom) / 100) + 1);
			// System.err.println(nbNewPersonnages);
			Caracteristique caracteristiqueNew = new Caracteristique(caracteristique);
			Personnage personnage = new Personnage(idJoueur, caracteristiqueNew);

			personnage.nbPersonnage = nbNewPersonnages;
			addPersonnage(personnage);
		}
	}

	/**
	 * @param idJoueur
	 * @param caracteristique
	 * @param zones
	 * @param x
	 *            -> de la zone actuel
	 * @param y
	 *            -> de la zone actuel R�gle : Pour chaque groupe: % chance de
	 *            migrer = [ X% migration]/100 + 1]
	 */
	public void gererMigration(final int idJoueur, Zone[][] zones, final int x, final int y) {
		List<Personnage> personnages = getPersonnageFromJoueur(idJoueur).collect(Collectors.toList());
		for (int i = 0; i < personnages.size(); i++) {
			Personnage perso = personnages.get(i);
			float pourcentageMigration = perso.caracteristique.migration / 100 + 1;
			float nbRandom = new Random().nextInt(100) + 1;
			if (pourcentageMigration >= nbRandom) {
				boolean exit = false;
				do {
					int newX = randomLessToOne();
					int newY = randomLessToOne();
					if (x + newX < zones.length && x + newX > -1) {
						if (y + newY < zones[x + newX].length && y + newY > -1) {
							this.listPersonage.remove(perso);
							zones[x + newX][y + newY].addPersonnage(perso);
							// System.err.println("MIGRATION DE :"+x+"-"+y +"
							// VERS : " + (x + newX) + "-" + (y + newY));
							exit = true;
						}
					}
				} while (!exit);
			}
		}
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
		listPersonage.removeAll(personnagesMort);

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
