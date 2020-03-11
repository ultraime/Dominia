package ultraime.game.dominia.composant;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class StackAmeliorationListenner extends ClickListener {
	public StackAmelioration stackAmelioration;

	public StackAmeliorationListenner(final StackAmelioration stackAmelioration) {
		this.stackAmelioration = stackAmelioration;
	}

	@Override
	public void clicked(InputEvent event, float x, float y) {
//		super.clicked(event, x, y);

		this.stackAmelioration.menuUpgrade.modifierStack(stackAmelioration);
		this.stackAmelioration.menuUpgrade.showMenu(true);
	}

}
