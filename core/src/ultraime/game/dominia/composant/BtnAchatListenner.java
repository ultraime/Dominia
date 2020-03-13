package ultraime.game.dominia.composant;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import ultraime.game.dominia.ecran.menu.MenuAchatAmelioration;

public class BtnAchatListenner extends ClickListener {

	private MenuAchatAmelioration menuUpgrade;

	@Override
	public void clicked(InputEvent event, float x, float y) {
		menuUpgrade.achatAmelioration();
	}

	public BtnAchatListenner(MenuAchatAmelioration menuUpgrade) {
		this.menuUpgrade = menuUpgrade;
	}

}
