package ultraime.game.dominia.composant;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;

public class StackAmelioration extends Stack {
	public final static int BLEU = 0;
	public final static int ROUGE = 1;
	public final static int VERT = 2;
	public final static Texture txtCase = new Texture(Gdx.files.internal("amelioration/case_bleu.png"));
	public final static Texture txtCase_rouge = new Texture(Gdx.files.internal("amelioration/case_rouge.png"));
	public final static Texture txtCase_verte = new Texture(Gdx.files.internal("amelioration/case_verte.png"));

	/**
	 * Image de l'amélioration
	 */
	public Image[] img = new Image[3];

	/**
	 * Image du cadre
	 */
	public Image[] imgCadre = new Image[3];


	public StackAmelioration(String amelioration) {
		final Texture t1 = new Texture(Gdx.files.internal("amelioration/" + amelioration + "_bleu.png"));
		final Texture t2 = new Texture(Gdx.files.internal("amelioration/" + amelioration + "_rouge.png"));
		final Texture t3 = new Texture(Gdx.files.internal("amelioration/" + amelioration + "_vert.png"));
		img[0] = new Image(t1);
		img[1] = new Image(t2);
		img[2] = new Image(t3);
		
		imgCadre[0] = new Image(txtCase);
		imgCadre[1] = new Image(txtCase_rouge);
		imgCadre[2] = new Image(txtCase_verte);
	}

	public void changeColorCase(final int color) {
		clear();
		add(imgCadre[color]);
		add(img[color]);
	}
}
