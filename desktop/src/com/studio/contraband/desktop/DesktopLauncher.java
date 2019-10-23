package com.studio.contraband.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.studio.contraband.Contraband;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Contraband";
		config.width = 800;
		config.height = 480;
		new LwjglApplication(new Contraband(), config);
	}
}
