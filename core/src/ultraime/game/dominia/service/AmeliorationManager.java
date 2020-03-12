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
	
	public static Amelioration ameliorationSangFroid;
	public static Amelioration ameliorationSangChaud;
	public static Amelioration ameliorationAgressivite;
	public static Amelioration ameliorationGriffe;
	public static Amelioration ameliorationCroc;
	public static Amelioration ameliorationJumeau;
	public static Amelioration ameliorationSagesse;
	public static Amelioration ameliorationVueAccrue;
	public static Amelioration ameliorationLongevite;
	public static Amelioration ameliorationSurvivaliste;
	public static Amelioration ameliorationExplorateur;
	public static Amelioration ameliorationAiles;

	public static void initList() {

		creerAmeliorationNiveau1();
		creerAmeliorationNiveau2();
		creerAmeliorationNiveau3();

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
		ameliorationHormoneFertile = new Amelioration(caracteristique,
				Parametre.bundle.get("txt.amelioration.hormone.fertile"), 1);
		ameliorations.add(ameliorationHormoneFertile);

		// Matiere grise
		final Caracteristique caracteristiqueMatiereGrise = new Caracteristique();
		caracteristiqueMatiereGrise.clear();
		caracteristiqueMatiereGrise.intelligence = 3;
		ameliorationMatiereGrise = new Amelioration(caracteristiqueMatiereGrise,
				Parametre.bundle.get("txt.amelioration.hormone.fertile"), 1);
		ameliorations.add(ameliorationMatiereGrise);

		// Resistance
		final Caracteristique caracteristiqueResistance = new Caracteristique();
		caracteristiqueResistance.clear();
		caracteristiqueResistance.vitalite = 3;
		ameliorationResistance = new Amelioration(caracteristiqueResistance,
				Parametre.bundle.get("txt.amelioration.resistance"), 1);
		ameliorations.add(ameliorationResistance);

		// Migrateur
		final Caracteristique caracteristiqueMigrateur = new Caracteristique();
		caracteristiqueMigrateur.clear();
		caracteristiqueMigrateur.migration = 3;
		ameliorationMigrateur = new Amelioration(caracteristiqueMigrateur,
				Parametre.bundle.get("txt.amelioration.migrateur"), 1);
		ameliorations.add(ameliorationMigrateur);

	}

	private static void creerAmeliorationNiveau2() {
		// transpiration
		final Caracteristique caracteristiqueTrasnpi = new Caracteristique();
		caracteristiqueTrasnpi.clear();
		caracteristiqueTrasnpi.resistChaleur = 3;
		ameliorationTrasnpi2 = new Amelioration(caracteristiqueTrasnpi,
				Parametre.bundle.get("txt.amelioration.transpiration") + " 2", 1);
		ameliorationTrasnpi2.ameliorationsRequise.add(ameliorationTrasnpi);
		ameliorations.add(ameliorationTrasnpi2);

		// flux sanguin
		final Caracteristique caracteristiqueFluxSanguin = new Caracteristique();
		caracteristiqueFluxSanguin.clear();
		caracteristiqueFluxSanguin.resistFroid = 3;
		ameliorationFluxSanguin2 = new Amelioration(caracteristiqueFluxSanguin,
				Parametre.bundle.get("txt.amelioration.flux.sanguin") + " 2", 1);
		ameliorationFluxSanguin2.ameliorationsRequise.add(ameliorationFluxSanguin);
		ameliorations.add(ameliorationFluxSanguin2);

		// Masse Musculaire
		final Caracteristique caracteristiqueMasseMusculaire = new Caracteristique();
		caracteristiqueMasseMusculaire.clear();
		caracteristiqueMasseMusculaire.force = 3;
		ameliorationMasseMusculaire2 = new Amelioration(caracteristiqueMasseMusculaire,
				Parametre.bundle.get("txt.amelioration.masse.musculaire") + " 2", 1);
		ameliorationMasseMusculaire2.ameliorationsRequise.add(ameliorationMasseMusculaire);
		ameliorations.add(ameliorationMasseMusculaire2);

		// hormone fertile
		final Caracteristique caracteristique = new Caracteristique();
		caracteristique.clear();
		caracteristique.fertilite = 3;
		ameliorationHormoneFertile2 = new Amelioration(caracteristique,
				Parametre.bundle.get("txt.amelioration.hormone.fertile") + " 2", 1);
		ameliorationHormoneFertile2.ameliorationsRequise.add(ameliorationHormoneFertile);
		ameliorations.add(ameliorationHormoneFertile2);

		// Matiere grise
		final Caracteristique caracteristiqueMatiereGrise = new Caracteristique();
		caracteristiqueMatiereGrise.clear();
		caracteristiqueMatiereGrise.intelligence = 3;
		ameliorationMatiereGrise2 = new Amelioration(caracteristiqueMatiereGrise,
				Parametre.bundle.get("txt.amelioration.hormone.fertile") + " 2", 1);
		ameliorationMatiereGrise2.ameliorationsRequise.add(ameliorationMatiereGrise);
		ameliorations.add(ameliorationMatiereGrise2);

		// Resistance
		final Caracteristique caracteristiqueResistance = new Caracteristique();
		caracteristiqueResistance.clear();
		caracteristiqueResistance.vitalite = 3;
		ameliorationResistance2 = new Amelioration(caracteristiqueResistance,
				Parametre.bundle.get("txt.amelioration.resistance") + " 2", 1);
		ameliorationResistance2.ameliorationsRequise.add(ameliorationResistance);
		ameliorations.add(ameliorationResistance2);

		// Migrateur
		final Caracteristique caracteristiqueMigrateur = new Caracteristique();
		caracteristiqueMigrateur.clear();
		caracteristiqueMigrateur.migration = 3;
		ameliorationMigrateur2 = new Amelioration(caracteristiqueMigrateur, Parametre.bundle.get("txt.amelioration.migrateur") + " 2", 1);
		ameliorationMigrateur2.ameliorationsRequise.add(ameliorationMigrateur);
		ameliorations.add(ameliorationMigrateur2);

	}
	
	private static void creerAmeliorationNiveau3() {
		final Caracteristique caracteristiqueSangFroid= new Caracteristique();
		final Caracteristique caracteristiqueSangChaud= new Caracteristique();
		final Caracteristique caracteristiqueAgressivite= new Caracteristique();
		final Caracteristique caracteristiqueGriffe= new Caracteristique();
		final Caracteristique caracteristiqueCroc= new Caracteristique();
		final Caracteristique caracteristiqueJumeau= new Caracteristique();
		final Caracteristique caracteristiqueSagesse= new Caracteristique();
		final Caracteristique caracteristiqueVueAccrue= new Caracteristique();
		final Caracteristique caracteristiqueLongevite= new Caracteristique();
		final Caracteristique caracteristiqueSurvivaliste= new Caracteristique();
		final Caracteristique caracteristiqueExplorateur= new Caracteristique();
		final Caracteristique caracteristiqueAiles= new Caracteristique();
		
		caracteristiqueSangFroid.clear();
		caracteristiqueSangChaud.clear();
		caracteristiqueAgressivite.clear();
		caracteristiqueGriffe.clear();
		caracteristiqueCroc.clear();
		caracteristiqueJumeau.clear();
		caracteristiqueSagesse.clear();
		caracteristiqueVueAccrue.clear();
		caracteristiqueLongevite.clear();
		caracteristiqueSurvivaliste.clear();
		caracteristiqueExplorateur.clear();
		caracteristiqueAiles.clear();
		
		caracteristiqueSangFroid.resistChaleur = 5;
		caracteristiqueSangFroid.resistFroid = -5;
		
		caracteristiqueSangChaud.resistChaleur = -5;
		caracteristiqueSangChaud.resistFroid = 5;
		
		caracteristiqueAgressivite.force = 5;
		caracteristiqueAgressivite.vitalite = -5;
		
		caracteristiqueGriffe.force = 3;
		
		caracteristiqueCroc.force = 3;
		
		caracteristiqueJumeau.fertilite = 10;
		caracteristiqueJumeau.vitalite = -5;
		
		caracteristiqueSagesse.intelligence = 5;
		caracteristiqueSagesse.force = -5;
		
		caracteristiqueVueAccrue.intelligence = 3;
		caracteristiqueVueAccrue.migration = 3;
		caracteristiqueVueAccrue.force = 2;
		caracteristiqueVueAccrue.fertilite = -8;
		
		caracteristiqueLongevite.vitalite = 5;
		caracteristiqueLongevite.force = -5;
		
		caracteristiqueSurvivaliste.vitalite = 2;
		caracteristiqueSurvivaliste.force = 2;
		caracteristiqueSurvivaliste.migration = -2;
		
		caracteristiqueExplorateur.migration = 5;
		caracteristiqueExplorateur.fertilite = -5;
		
		caracteristiqueAiles.migration = 5;
		caracteristiqueAiles.force = 2;
		caracteristiqueAiles.resistFroid = -2;
		
		ameliorationSangFroid = new Amelioration(caracteristiqueSangFroid, Parametre.bundle.get("txt.amelioration.sang.froid"), 1);
		ameliorationSangChaud= new Amelioration(caracteristiqueSangChaud, Parametre.bundle.get("txt.amelioration.sang.chaud"), 1);
		ameliorationAgressivite= new Amelioration(caracteristiqueAgressivite, Parametre.bundle.get("txt.amelioration.agressivite"), 1);
		ameliorationGriffe= new Amelioration(caracteristiqueGriffe, Parametre.bundle.get("txt.amelioration.griffe"), 1);
		ameliorationCroc= new Amelioration(caracteristiqueCroc, Parametre.bundle.get("txt.amelioration.croc"), 1);
		ameliorationJumeau= new Amelioration(caracteristiqueJumeau, Parametre.bundle.get("txt.amelioration.jumeau"), 1);
		ameliorationSagesse= new Amelioration(caracteristiqueSagesse, Parametre.bundle.get("txt.amelioration.sagesse"), 1);
		ameliorationVueAccrue= new Amelioration(caracteristiqueVueAccrue, Parametre.bundle.get("txt.amelioration.vue.accrue"), 1);
		ameliorationLongevite= new Amelioration(caracteristiqueLongevite, Parametre.bundle.get("txt.amelioration.longevite"), 1);
		ameliorationSurvivaliste= new Amelioration(caracteristiqueSurvivaliste, Parametre.bundle.get("txt.amelioration.survivaliste"), 1);
		ameliorationExplorateur= new Amelioration(caracteristiqueExplorateur, Parametre.bundle.get("txt.amelioration.explorateur"), 1);
		ameliorationAiles= new Amelioration(caracteristiqueAiles, Parametre.bundle.get("txt.amelioration.ailes"), 1);
		
		
		ameliorationSangFroid.ameliorationsRequise.add(ameliorationTrasnpi2);
		ameliorationSangChaud.ameliorationsRequise.add(ameliorationFluxSanguin2);
		ameliorationAgressivite.ameliorationsRequise.add(ameliorationMasseMusculaire2);
		ameliorationGriffe.ameliorationsRequise.add(ameliorationMasseMusculaire2);
		ameliorationCroc.ameliorationsRequise.add(ameliorationMasseMusculaire2);
		ameliorationJumeau.ameliorationsRequise.add(ameliorationHormoneFertile2);
		ameliorationSagesse.ameliorationsRequise.add(ameliorationMatiereGrise2);
		ameliorationVueAccrue.ameliorationsRequise.add(ameliorationMatiereGrise2);
		ameliorationLongevite.ameliorationsRequise.add(ameliorationResistance);
		ameliorationSurvivaliste.ameliorationsRequise.add(ameliorationResistance);
		ameliorationExplorateur.ameliorationsRequise.add(ameliorationMigrateur);
		ameliorationAiles.ameliorationsRequise.add(ameliorationMigrateur);
		
		ameliorations.add(ameliorationSangFroid);
		ameliorations.add(ameliorationSangChaud);
		ameliorations.add(ameliorationAgressivite);
		ameliorations.add(ameliorationGriffe);
		ameliorations.add(ameliorationCroc);
		ameliorations.add(ameliorationJumeau);
		ameliorations.add(ameliorationSagesse);
		ameliorations.add(ameliorationVueAccrue);
		ameliorations.add(ameliorationLongevite);
		ameliorations.add(ameliorationSurvivaliste);
		ameliorations.add(ameliorationExplorateur);
		
	}

}
