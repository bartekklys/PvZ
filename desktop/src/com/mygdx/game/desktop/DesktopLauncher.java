package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.PvZGame;

public class DesktopLauncher {

	public static final int WIDTH = 1200;
	public static final int HEIGHT = 800;

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = WIDTH;
		config.height = HEIGHT;
		config.resizable = false;
		new LwjglApplication(new PvZGame(), config);
	}
}
