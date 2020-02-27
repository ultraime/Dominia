package ultraime.game.dominia.entite;

public class Personnage {

	public int idJoueur;
	public Caracteristique caracteristique;
	public int nbPersonnage;

	/**
	 * @param idJoueur
	 * @param caracteristique
	 */
	public Personnage(final int idJoueur, final Caracteristique caracteristique) {
		this.idJoueur = idJoueur;
		this.caracteristique = caracteristique;
	}

	/**
	 * @return isMort
	 */
	public boolean perdreVie() {
		boolean isMort = false;
		this.caracteristique.vitalite--;
		if (this.caracteristique.vitalite <= 0) {
			isMort = true;
		}
		return isMort;
	}

}
