package tetris15.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;

import tetris15.Tetris15;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "Tetris_15 " + Tetris15.VERSION;
		config.useGL30 = true;
		config.fullscreen =false;
		config.width = 1000;
		config.height = 800;
		config.initialBackgroundColor =Color.BLACK;
               
		new LwjglApplication(new Tetris15(), config);
	}
}
