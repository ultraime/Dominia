package ultraime.game.dominia.composant;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;

public class CadreAmelioration extends Stack {

	public final static Texture cadre_fond = new Texture(Gdx.files.internal("ui/cadre.png"));

	public CadreAmelioration(Skin skin) {
		add(new Image(cadre_fond));
		Button button = new Button(skin);
		button.setPosition(50, 50);
		add(button);
	}

}
