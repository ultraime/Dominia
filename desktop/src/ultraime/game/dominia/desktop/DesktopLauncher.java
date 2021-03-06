package ultraime.game.dominia.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import ultraime.game.dominia.ecran.EcranManager;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = LwjglApplicationConfiguration.getDesktopDisplayMode().width;
		config.height = LwjglApplicationConfiguration.getDesktopDisplayMode().height;
		
//		config.width =1024;
//		config.height = 768;
//		config.fullscreen = true;
		new LwjglApplication(new EcranManager(), config);
	}
}
