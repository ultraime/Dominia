package ultraime.game.dominia.entite;

import java.util.ArrayList;
import java.util.List;

public class Joueur {

	public int id;
	public Caracteristique caracteristiqueDeBase;
	public Caracteristique caracteristiqueMoyenne;

	public List<Amelioration> ameliorations = new ArrayList<Amelioration>();

	public Joueur(final int id) {
		this.id = id;
		this.caracteristiqueDeBase = new Caracteristique();
		this.caracteristiqueMoyenne = new Caracteristique();
	}

}
