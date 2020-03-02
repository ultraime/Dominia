package ultraime.game.dominia.service;

import java.util.ArrayList;
import java.util.List;

import ultraime.game.dominia.entite.Amelioration;
import ultraime.game.dominia.entite.Caracteristique;

public class AmeliorationManager {

	public static List<Amelioration> ameliorations = new ArrayList<Amelioration>();;

	public static void initList() {
		// hormone fertile
		final Caracteristique caracteristique = new Caracteristique();
		caracteristique.clear();
		caracteristique.fertilite = 5;
		final Amelioration amelioration = new Amelioration(caracteristique, "hotmaone fertile", 1);
		ameliorations.add(amelioration);

	}

}
