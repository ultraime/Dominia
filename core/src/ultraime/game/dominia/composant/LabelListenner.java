package ultraime.game.dominia.composant;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.ultraime.game.gdxtraime.parametrage.Parametre;

import ultraime.game.dominia.entite.Zone;

public class LabelListenner extends ClickListener {
	public Zone zone;
	public int posX, posY;

	/**
	 * @param zone
	 * @param posX
	 * @param posY
	 */
	public LabelListenner(final Zone zone, final int posX, final int posY) {
		this.zone = zone;
		this.posX = posX;
		this.posY = posY;
	}

	@Override
	public void clicked(InputEvent event, float x, float y) {
		if (Parametre.MODE_DEBUG) {
			String complement = "";
			if (!zone.isActif) {
				complement = " (zone non actif)";
			}
			System.out.println("Clique sur Zone" + "[" + posX + "][" + posY + "]" + complement);
		}
	}

}
