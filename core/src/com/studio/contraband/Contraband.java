package com.studio.contraband;

import com.badlogic.gdx.Game;

public class Contraband extends Game
{
	@Override
	public void create () {
		setScreen(new GameScreen());
	}
}