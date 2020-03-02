package ultraime.game.dominia.entite;

import java.util.ArrayList;
import java.util.List;

public class Personnage {

	public int idJoueur;
	public Caracteristique caracteristique;
	public double nbPersonnage;

	public List<Amelioration> ameliorations = new ArrayList<Amelioration>();
	public int age;

	/**
	 * @param idJoueur
	 * @param caracteristique
	 */
	public Personnage(final int idJoueur, final Caracteristique caracteristique) {
		this.idJoueur = idJoueur;
		this.caracteristique = caracteristique;
		this.age = this.caracteristique.vitalite;
	}

	/**
	 * @return isMort
	 */
	public boolean perdreVie() {
		boolean isMort = false;
		this.age--;
		if (this.age <= 0) {
			isMort = true;
		}
		return isMort;
	}

}
