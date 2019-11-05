package com.studio.contraband;

import com.badlogic.gdx.Game;
import com.studio.contraband.Screens.*;

public class Contraband extends Game
{



	private MainMenuScreen mainMenuScreen;
	private GameScreen gameScreen;
	private SettingsScreen settingsScreen;
	private PauseScreen pauseScreen;
	private SplashScreen splashScreen;
	private TestbenchScreen testbenchScreen;


	@Override
	public void create () {


		mainMenuScreen = new MainMenuScreen(this);
		gameScreen = new GameScreen(this);
		settingsScreen = new SettingsScreen(this);
		pauseScreen = new PauseScreen();
		splashScreen = new SplashScreen();
		testbenchScreen = new TestbenchScreen(this);

		debug(false);


		//setScreen(testbenchScreen);
	}

	public void render()
    {
        super.render();
    }

	public MainMenuScreen getMainMenuScreen()
	{
		return mainMenuScreen;
	}
	public GameScreen getGameScreen()
	{
		return gameScreen;
	}
	public SettingsScreen getSettingsScreen()
	{
		return settingsScreen;
	}
	public PauseScreen getPauseScreen()
	{
		return pauseScreen;
	}
	public SplashScreen getSplashScreen()
	{
		return splashScreen;
	}

	public void debug(boolean debug)
	{
		if(debug)
		{
			setScreen(testbenchScreen);
		}
		else setScreen(mainMenuScreen);
	}

}
