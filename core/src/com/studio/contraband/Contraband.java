package com.studio.contraband;

import com.badlogic.gdx.Game;
import com.studio.contraband.Screens.SplashScreen;

public class Contraband extends Game
{
	@Override
	public void create () {
		setScreen(new SplashScreen());
	}

	public void render()
    {
        super.render();
    }

}