package ultraime.game.dominia.composant;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import ultraime.game.dominia.ecran.MenuUpgrade;

public class BtnAchatListenner extends ClickListener {

	private MenuUpgrade MenuUpgrade;

	@Override
	public void clicked(InputEvent event, float x, float y) {
		super.clicked(event, x, y);

	}

	public BtnAchatListenner(MenuUpgrade menuUpgrade) {
		this.MenuUpgrade = menuUpgrade;
	}

}
