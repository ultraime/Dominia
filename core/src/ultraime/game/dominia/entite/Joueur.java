package ultraime.game.dominia.entite;

public class Joueur {

	public int id;
	public Caracteristique caracteristiqueDeBase;
	public Caracteristique caracteristiqueMoyenne;

	public Joueur(final int id) {
		this.id = id;
		this.caracteristiqueDeBase = new Caracteristique();
		this.caracteristiqueMoyenne = new Caracteristique();
	}

}
