package ultraime.game.dominia.ecran;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.ultraime.game.gdxtraime.parametrage.Parametre;

import ultraime.game.dominia.composant.StackAmelioration;
import ultraime.game.dominia.entite.Caracteristique;
import ultraime.game.dominia.service.AmeliorationManager;

public class MenuUpgrade {

	public final static int WIDTH_LABEL = 100;
	public final static int HEIGHT_LABEL = 30;
	public final static int ECART_LABEL = 20;
	private Skin skin;

	private Image imgCadre;
	public StackAmelioration stackAmelioration;

	private Label lForce;
	private Label lFertilite;
	private Label lMigration;
	private Label lIntelligence;
	private Label lResistChaleur;
	private Label lResistFroid;
	private Label lVitalite;

	private Label lForceStat;
	private Label lFertiliteStat;
	private Label lMigrationStat;
	private Label lIntelligenceStat;
	private Label lResistChaleurStat;
	private Label lResistFroidStat;
	private Label lVitaliteStat;

	public void modifierStack(StackAmelioration stackAmelioration) {
		this.stackAmelioration.init(this, stackAmelioration.nomImage, stackAmelioration.amelioration);
		this.stackAmelioration.changeColorCase(StackAmelioration.BLEU);
	}

	public void createSDtage(Stage stageUpgrade) {
		skin = new Skin(Gdx.files.internal("ui-editor/neonuiblue/neonuiblue.json"));
		imgCadre = new Image(new Texture(Gdx.files.internal("ui/cadre.png")));
		imgCadre.setPosition(560, 50);
		imgCadre.setWidth(800);
		imgCadre.setHeight(200);
		stageUpgrade.addActor(imgCadre);

		// inutile c'est juste pour l'initialisation.
		stackAmelioration = new StackAmelioration(this, "griffe", AmeliorationManager.ameliorationTrasnpi);
		stackAmelioration.setPosition(580, 110);
		stackAmelioration.setWidth(80);
		stackAmelioration.setHeight(80);
		stackAmelioration.changeColorCase(StackAmelioration.BLEU);
		stageUpgrade.addActor(stackAmelioration);

		lForce = new Label(Parametre.bundle.get("txt.stat.force"), skin);
		lFertilite = new Label(Parametre.bundle.get("txt.stat.fertilite"), skin);
		lMigration = new Label(Parametre.bundle.get("txt.stat.migration"), skin);
		lIntelligence = new Label(Parametre.bundle.get("txt.stat.intelligence"), skin);
		lResistChaleur = new Label(Parametre.bundle.get("txt.stat.resist.chaleur"), skin);
		lResistFroid = new Label(Parametre.bundle.get("txt.stat.resist.froid"), skin);
		lVitalite = new Label(Parametre.bundle.get("txt.stat.vitalite"), skin);

		lForce.setSize(WIDTH_LABEL, HEIGHT_LABEL);
		lFertilite.setSize(WIDTH_LABEL, HEIGHT_LABEL);
		lMigration.setSize(WIDTH_LABEL, HEIGHT_LABEL);
		lIntelligence.setSize(WIDTH_LABEL, HEIGHT_LABEL);
		lResistChaleur.setSize(WIDTH_LABEL, HEIGHT_LABEL);
		lVitalite.setSize(WIDTH_LABEL, HEIGHT_LABEL);
		lResistFroid.setSize(WIDTH_LABEL, HEIGHT_LABEL);

		lForce.setPosition(700, 190);
		lFertilite.setPosition(700, 190 - (ECART_LABEL));
		lMigration.setPosition(700, 190 - (ECART_LABEL * 2));
		lIntelligence.setPosition(700, 190 - (ECART_LABEL * 3));
		lResistChaleur.setPosition(700, 190 - (ECART_LABEL * 4));
		lVitalite.setPosition(700, 190 - (ECART_LABEL * 5));
		lResistFroid.setPosition(700, 190 - (ECART_LABEL * 6));

		stageUpgrade.addActor(lForce);
		stageUpgrade.addActor(lFertilite);
		stageUpgrade.addActor(lMigration);
		stageUpgrade.addActor(lIntelligence);
		stageUpgrade.addActor(lResistChaleur);
		stageUpgrade.addActor(lVitalite);
		stageUpgrade.addActor(lResistFroid);
		
//		final Caracteristique caracteristique = stackAmelioration.amelioration.caracteristique;
		lForceStat = new Label(": ", skin);
		lFertiliteStat = new Label("", skin);
		lMigrationStat = new Label("", skin);
		lIntelligenceStat = new Label("", skin);
		lResistChaleurStat = new Label("", skin);
		lResistFroidStat = new Label("", skin);
		lVitaliteStat = new Label("", skin);
//		
//		lForce.setPosition(800, 190);
//		
//		stageUpgrade.addActor(lForceStat);
	}

	public void showMenu(boolean isShow) {
		imgCadre.setVisible(isShow);
		stackAmelioration.setVisible(isShow);
		
		lForce.setVisible(isShow);
		lFertilite.setVisible(isShow);
		lMigration.setVisible(isShow);
		lIntelligence.setVisible(isShow);
		lResistChaleur.setVisible(isShow);
		lVitalite.setVisible(isShow);
		lResistFroid.setVisible(isShow);
		
		lForceStat.setVisible(isShow);
		lFertiliteStat.setVisible(isShow);
		lMigrationStat.setVisible(isShow);
		lIntelligenceStat.setVisible(isShow);
		lResistChaleurStat.setVisible(isShow);
		lVitaliteStat.setVisible(isShow);
		lResistFroidStat.setVisible(isShow);
	}

}
