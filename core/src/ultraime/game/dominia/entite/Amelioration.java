package ultraime.game.dominia.entite;

public class Amelioration {

	public Caracteristique caracteristique;
	public int cout;
	public String nom;

	public Amelioration(final Caracteristique caracteristique, final String nom, final int cout) {
		this.caracteristique = caracteristique;
		this.nom = nom;
		this.cout = cout;
	}
}
