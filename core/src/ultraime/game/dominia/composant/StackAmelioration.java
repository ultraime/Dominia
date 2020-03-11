package ultraime.game.dominia.composant;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;

import ultraime.game.dominia.ecran.MenuUpgrade;
import ultraime.game.dominia.entite.Amelioration;

public class StackAmelioration extends Stack {
	public final static int BLEU = 0;
	public final static int ROUGE = 1;
	public final static int VERT = 2;
	public final static Texture txtCase = new Texture(Gdx.files.internal("amelioration/case_bleu.png"));
	public final static Texture txtCase_rouge = new Texture(Gdx.files.internal("amelioration/case_rouge.png"));
	public final static Texture txtCase_verte = new Texture(Gdx.files.internal("amelioration/case_verte.png"));

	public MenuUpgrade menuUpgrade;
	/**
	 * Image de l'amélioration
	 */
	public Image[] img = new Image[3];

	public String nomImage;

	public int color = BLEU;

	/**
	 * Image du cadre
	 */
	public Image[] imgCadre = new Image[3];

	public Amelioration amelioration;

	public StackAmelioration(MenuUpgrade menuUpgrade, final String image, final Amelioration amelioration) {
		init(menuUpgrade, image, amelioration);
		nomImage = image;

	}

	/**
	 * @param menuUpgrade
	 * @param image
	 * @param amelioration
	 */
	public void init(MenuUpgrade menuUpgrade, final String image, final Amelioration amelioration) {
		final Texture t1 = new Texture(Gdx.files.internal("amelioration/" + image + "_bleu.png"));
		final Texture t2 = new Texture(Gdx.files.internal("amelioration/" + image + "_rouge.png"));
		final Texture t3 = new Texture(Gdx.files.internal("amelioration/" + image + "_vert.png"));
		img[0] = new Image(t1);
		img[1] = new Image(t2);
		img[2] = new Image(t3);

		imgCadre[0] = new Image(txtCase);
		imgCadre[1] = new Image(txtCase_rouge);
		imgCadre[2] = new Image(txtCase_verte);

		this.amelioration = amelioration;

		this.menuUpgrade = menuUpgrade;
	}

	public void changeColorCase(final int color) {
		clear();
		add(imgCadre[color]);
		add(img[color]);
		this.color = color;
	}

}
