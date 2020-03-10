package ultraime.game.dominia.service;

import java.util.ArrayList;
import java.util.List;

import com.ultraime.game.gdxtraime.parametrage.Parametre;

import ultraime.game.dominia.entite.Amelioration;
import ultraime.game.dominia.entite.Caracteristique;

public class AmeliorationManager {

	public static List<Amelioration> ameliorations = new ArrayList<Amelioration>();

	public static Amelioration ameliorationTrasnpi;
	public static Amelioration ameliorationFluxSanguin;
	public static Amelioration ameliorationMasseMusculaire;
	public static Amelioration ameliorationHormoneFertile;
	public static Amelioration ameliorationMatiereGrise;
	public static Amelioration ameliorationResistance;
	public static Amelioration ameliorationMigrateur;

	public static Amelioration ameliorationTrasnpi2;
	public static Amelioration ameliorationFluxSanguin2;
	public static Amelioration ameliorationMasseMusculaire2;
	public static Amelioration ameliorationHormoneFertile2;
	public static Amelioration ameliorationMatiereGrise2;
	public static Amelioration ameliorationResistance2;
	public static Amelioration ameliorationMigrateur2;

	public static void initList() {

		creerAmeliorationNiveau1();
		creerAmeliorationNiveau2();

	}

	private static void creerAmeliorationNiveau1() {
		// transpiration
		final Caracteristique caracteristiqueTrasnpi = new Caracteristique();
		caracteristiqueTrasnpi.clear();
		caracteristiqueTrasnpi.resistChaleur = 3;
		ameliorationTrasnpi = new Amelioration(caracteristiqueTrasnpi,
				Parametre.bundle.get("txt.amelioration.transpiration"), 1);
		ameliorations.add(ameliorationTrasnpi);

		// flux sanguin
		final Caracteristique caracteristiqueFluxSanguin = new Caracteristique();
		caracteristiqueFluxSanguin.clear();
		caracteristiqueFluxSanguin.resistFroid = 3;
		ameliorationFluxSanguin = new Amelioration(caracteristiqueFluxSanguin,
				Parametre.bundle.get("txt.amelioration.flux.sanguin"), 1);
		ameliorations.add(ameliorationFluxSanguin);

		// Masse Musculaire
		final Caracteristique caracteristiqueMasseMusculaire = new Caracteristique();
		caracteristiqueMasseMusculaire.clear();
		caracteristiqueMasseMusculaire.force = 3;
		ameliorationMasseMusculaire = new Amelioration(caracteristiqueMasseMusculaire,
				Parametre.bundle.get("txt.amelioration.masse.musculaire"), 1);
		ameliorations.add(ameliorationMasseMusculaire);

		// hormone fertile
		final Caracteristique caracteristique = new Caracteristique();
		caracteristique.clear();
		caracteristique.fertilite = 3;
		ameliorationHormoneFertile = new Amelioration(caracteristique, "txt.amelioration.hormone.fertile", 1);
		ameliorations.add(ameliorationHormoneFertile);

		// Matiere grise
		final Caracteristique caracteristiqueMatiereGrise = new Caracteristique();
		caracteristiqueMatiereGrise.clear();
		caracteristiqueMatiereGrise.intelligence = 3;
		ameliorationMatiereGrise = new Amelioration(caracteristiqueMatiereGrise, "txt.amelioration.hormone.fertile", 1);
		ameliorations.add(ameliorationMatiereGrise);

		// Resistance
		final Caracteristique caracteristiqueResistance = new Caracteristique();
		caracteristiqueResistance.clear();
		caracteristiqueResistance.vitalite = 3;
		ameliorationResistance = new Amelioration(caracteristiqueResistance, "txt.amelioration.resistance", 1);
		ameliorations.add(ameliorationResistance);

		// Migrateur
		final Caracteristique caracteristiqueMigrateur = new Caracteristique();
		caracteristiqueMigrateur.clear();
		caracteristiqueMigrateur.migration = 3;
		ameliorationMigrateur = new Amelioration(caracteristiqueMigrateur, "txt.amelioration.migrateur", 1);
		ameliorations.add(ameliorationMigrateur);

	}

	private static void creerAmeliorationNiveau2() {
		// transpiration
		final Caracteristique caracteristiqueTrasnpi = new Caracteristique();
		caracteristiqueTrasnpi.clear();
		caracteristiqueTrasnpi.resistChaleur = 3;
		ameliorationTrasnpi = new Amelioration(caracteristiqueTrasnpi,
				Parametre.bundle.get("txt.amelioration.transpiration") + " 2", 1);
		ameliorations.add(ameliorationTrasnpi);

		// flux sanguin
		final Caracteristique caracteristiqueFluxSanguin = new Caracteristique();
		caracteristiqueFluxSanguin.clear();
		caracteristiqueFluxSanguin.resistFroid = 3;
		ameliorationFluxSanguin = new Amelioration(caracteristiqueFluxSanguin,
				Parametre.bundle.get("txt.amelioration.flux.sanguin") + " 2", 1);
		ameliorations.add(ameliorationFluxSanguin);

		// Masse Musculaire
		final Caracteristique caracteristiqueMasseMusculaire = new Caracteristique();
		caracteristiqueMasseMusculaire.clear();
		caracteristiqueMasseMusculaire.force = 3;
		ameliorationMasseMusculaire = new Amelioration(caracteristiqueMasseMusculaire,
				Parametre.bundle.get("txt.amelioration.masse.musculaire") + " 2", 1);
		ameliorations.add(ameliorationMasseMusculaire);

		// hormone fertile
		final Caracteristique caracteristique = new Caracteristique();
		caracteristique.clear();
		caracteristique.fertilite = 3;
		ameliorationHormoneFertile = new Amelioration(caracteristique,
				Parametre.bundle.get("txt.amelioration.hormone.fertile") + " 2", 1);
		ameliorations.add(ameliorationHormoneFertile);

		// Matiere grise
		final Caracteristique caracteristiqueMatiereGrise = new Caracteristique();
		caracteristiqueMatiereGrise.clear();
		caracteristiqueMatiereGrise.intelligence = 3;
		ameliorationMatiereGrise = new Amelioration(caracteristiqueMatiereGrise,
				Parametre.bundle.get("txt.amelioration.hormone.fertile") + " 2", 1);
		ameliorations.add(ameliorationMatiereGrise);

		// Resistance
		final Caracteristique caracteristiqueResistance = new Caracteristique();
		caracteristiqueResistance.clear();
		caracteristiqueResistance.vitalite = 3;
		ameliorationResistance = new Amelioration(caracteristiqueResistance,
				Parametre.bundle.get("txt.amelioration.resistance") + " 2", 1);
		ameliorations.add(ameliorationResistance);

		// Migrateur
		final Caracteristique caracteristiqueMigrateur = new Caracteristique();
		caracteristiqueMigrateur.clear();
		caracteristiqueMigrateur.migration = 3;
		ameliorationMigrateur = new Amelioration(caracteristiqueMigrateur, "txt.amelioration.migrateur" + " 2", 1);
		ameliorations.add(ameliorationMigrateur);

	}

}
