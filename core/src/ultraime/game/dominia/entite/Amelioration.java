package ultraime.game.dominia.entite;

import java.util.ArrayList;

public class Amelioration {

	public Caracteristique caracteristique;
	public int cout;
	public String nom;

	public ArrayList<Amelioration> ameliorationsRequise = new ArrayList<>();

	public Amelioration(final Caracteristique caracteristique, final String nom, final int cout) {
		this.caracteristique = caracteristique;
		this.nom = nom;
		this.cout = cout;
	}
}
