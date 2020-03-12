package ultraime.game.dominia.ecran;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.ultraime.game.gdxtraime.parametrage.Parametre;

import ultraime.game.dominia.composant.StackAmelioration;
import ultraime.game.dominia.composant.StackAmeliorationListenner;
import ultraime.game.dominia.entite.Amelioration;
import ultraime.game.dominia.service.AmeliorationManager;

public class MenuAmelioration {
	public static final int NB_CASE = 23;
	public static final int WIDTH_CASE = 80;
	public static final int HEIGHT_CASE = 80;
	public static final int HEIGHT_DECALAGE = 30;
	private MenuUpgrade menuUpgrade;

	public MenuAmelioration(final MenuUpgrade menuUpgrade) {
		this.menuUpgrade = menuUpgrade;
	}

	public Table creerMenuAmelioration() {
		Table tableCase = new Table();

		tableCase.setDebug(Parametre.MODE_DEBUG);
		tableCase.setFillParent(true);
		tableCase.top();

		tableCase.add().height(HEIGHT_DECALAGE).expandX().fillX();
		for (int i = 0; i < NB_CASE; i++) {
			tableCase.add().width(WIDTH_CASE).height(HEIGHT_DECALAGE);
		}
		tableCase.add().height(HEIGHT_DECALAGE).expandX().fillX();
		tableCase.row();
		// premiere ligne
		Amelioration amelioration = AmeliorationManager.ameliorationTrasnpi;
		String image = "griffe";

		creerPremiereLigneMenu(amelioration, image, tableCase);
		tableCase.row();
		tableCase.add().height(HEIGHT_DECALAGE).expandX().fillX();
		tableCase.row();
		creerDeuxiemeLigneMenu(amelioration, image, tableCase);
		tableCase.row();
		tableCase.add().height(HEIGHT_DECALAGE).expandX().fillX();
		tableCase.row();
		creerTroisiemeLigneMenu(amelioration, image, tableCase);
	

		return tableCase;
	}

	private void addElement(Amelioration amelioration, String image, final Table tableCase, boolean isVide) {
		if (isVide) {
			tableCase.add().width(WIDTH_CASE).height(HEIGHT_CASE);
		} else {
			StackAmelioration stack = new StackAmelioration(menuUpgrade, image, amelioration);
			if (stack.amelioration.ameliorationsRequise.size() > 0) {
				stack.changeColorCase(StackAmelioration.ROUGE);
			} else {
				stack.changeColorCase(StackAmelioration.BLEU);
			}
			stack.addListener(new StackAmeliorationListenner(stack));
			tableCase.add(stack).width(WIDTH_CASE).height(HEIGHT_CASE);
		}
	}

	private void creerPremiereLigneMenu(Amelioration amelioration, String image, final Table tableCase) {
		tableCase.add().height(HEIGHT_DECALAGE).expandX().fillX();
		for (int i = 0; i < NB_CASE; i++) {
			boolean isVide = false;
			switch (i) {
			case 0:
				image = "transpiration";
				amelioration = AmeliorationManager.ameliorationTrasnpi;
				break;
			case 2:
				image = "transpiration";
				amelioration = AmeliorationManager.ameliorationFluxSanguin;
				break;
			case 4:
				image = "transpiration";
				amelioration = AmeliorationManager.ameliorationMasseMusculaire;
				break;
			case 10:
				image = "transpiration";
				amelioration = AmeliorationManager.ameliorationHormoneFertile;
				break;
			case 12:
				image = "transpiration";
				amelioration = AmeliorationManager.ameliorationMatiereGrise;
				break;
			case 16:
				image = "transpiration";
				amelioration = AmeliorationManager.ameliorationResistance;
				break;
			case 20:
				image = "transpiration";
				amelioration = AmeliorationManager.ameliorationMigrateur;
				break;
			default:
				isVide = true;
				break;
			}
			addElement(amelioration, image, tableCase, isVide);
		}
		tableCase.add().height(30).expandX().fillX();
	}

	private void creerDeuxiemeLigneMenu(Amelioration amelioration, String image, final Table tableCase) {
		tableCase.add().height(HEIGHT_DECALAGE).expandX().fillX();
		for (int i = 0; i < NB_CASE; i++) {
			boolean isVide = false;
			switch (i) {
			case 0:
				image = "transpiration";
				amelioration = AmeliorationManager.ameliorationTrasnpi2;
				break;
			case 2:
				image = "transpiration";
				amelioration = AmeliorationManager.ameliorationFluxSanguin2;
				break;
			case 4:
				image = "transpiration";
				amelioration = AmeliorationManager.ameliorationMasseMusculaire2;
				break;
			case 10:
				image = "transpiration";
				amelioration = AmeliorationManager.ameliorationHormoneFertile2;
				break;
			case 12:
				image = "transpiration";
				amelioration = AmeliorationManager.ameliorationMatiereGrise2;
				break;
			case 16:
				image = "transpiration";
				amelioration = AmeliorationManager.ameliorationResistance2;
				break;
			case 20:
				image = "transpiration";
				amelioration = AmeliorationManager.ameliorationMigrateur2;
				break;
			default:
				isVide = true;
				break;
			}
			addElement(amelioration, image, tableCase, isVide);
		}
		tableCase.add().height(30).expandX().fillX();
	}

	private void creerTroisiemeLigneMenu(Amelioration amelioration, String image, Table tableCase) {
		tableCase.add().height(HEIGHT_DECALAGE).expandX().fillX();
		for (int i = 0; i < NB_CASE; i++) {
			boolean isVide = false;
			switch (i) {
			case 0:
				image = "transpiration";
				amelioration = AmeliorationManager.ameliorationSangFroid;
				break;
			case 2:
				image = "transpiration";
				amelioration = AmeliorationManager.ameliorationSangChaud;
				break;
			case 4:
				image = "transpiration";
				amelioration = AmeliorationManager.ameliorationAgressivite;
				break;
			case 6:
				image = "transpiration";
				amelioration = AmeliorationManager.ameliorationGriffe;
				break;
			case 8:
				image = "transpiration";
				amelioration = AmeliorationManager.ameliorationCroc;
				break;
			case 10:
				image = "transpiration";
				amelioration = AmeliorationManager.ameliorationJumeau;
				break;
			case 12:
				image = "transpiration";
				amelioration = AmeliorationManager.ameliorationSagesse;
				break;
			case 14:
				image = "transpiration";
				amelioration = AmeliorationManager.ameliorationVueAccrue;
				break;
			case 16:
				image = "transpiration";
				amelioration = AmeliorationManager.ameliorationLongevite;
				break;
			case 18:
				image = "transpiration";
				amelioration = AmeliorationManager.ameliorationSurvivaliste;
				break;
			case 20:
				image = "transpiration";
				amelioration = AmeliorationManager.ameliorationExplorateur;
				break;
			case 22:
				image = "transpiration";
				amelioration = AmeliorationManager.ameliorationAiles;
				break;
			default:
				isVide = true;
				break;
			}
			addElement(amelioration, image, tableCase, isVide);
		}
		tableCase.add().height(30).expandX().fillX();
	}
}
