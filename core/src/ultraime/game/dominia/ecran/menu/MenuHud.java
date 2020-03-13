package ultraime.game.dominia.ecran.menu;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.ultraime.game.gdxtraime.parametrage.Parametre;

public class MenuHud {

	private Skin skin;
	private Image imgCadre;
	
	private ArrayList<Label> labelJoueurs;
	
	public MenuHud() {
		skin = new Skin(Gdx.files.internal("ui-editor/neonuiblue/neonuiblue.json"));
	}

	public void createStage(Stage stageHUD) {
		Table table = new Table();
		table.setFillParent(true);
		table.setDebug(Parametre.MODE_DEBUG);

		table.top();
		table.add().expandX().fillX();
		Texture barre = new Texture(Gdx.files.internal("logo/barre_1.png"));
		Image img = new Image(new Texture(Gdx.files.internal("logo/joueur_0_logo.png")));

		table.add(img).width(50).height(50);

		table.add(new Image(barre)).width(100).height(50);
		table.add(new Label("E2 IMG", skin)).width(50).height(50);
		table.add(new Label("E2 %WIN", skin)).width(100).height(30);
		table.add(new Label("E3 IMG", skin)).width(50).height(50);
		table.add(new Label("E3 %WIN", skin)).width(100).height(30);
		table.add(new Label("E4 IMG", skin)).width(50).height(50);
		table.add(new Label("E4 %WIN", skin)).width(100).height(30);
		table.add(new Label("E5 IMG", skin)).width(50).height(50);
		table.add(new Label("E5 %WIN", skin)).width(100).height(30);
		table.add().expandX().fillX();
		table.row();

		stageHUD.addActor(table);
		stageHUD.setDebugAll(Parametre.MODE_DEBUG);

		imgCadre = new Image(new Texture(Gdx.files.internal("ui/cadre.png")));
		imgCadre.setPosition(560, 0);
		imgCadre.setWidth(800);
		imgCadre.setHeight(150);
		stageHUD.addActor(imgCadre);
		
		labelJoueurs = new ArrayList<Label>();

		showMenu(false);

	}

	public void showMenu(boolean isSHow) {
		imgCadre.setVisible(isSHow);

	}

}
