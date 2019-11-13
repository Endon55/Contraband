package com.studio.contraband.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.studio.contraband.Contraband;
import com.studio.contraband.ScreenManager;

public class MainMenuScreen extends ScreenManager
{

    TextButton playButton;
    TextButton settingsButton;
    TextButton exitButton;


    public MainMenuScreen(Contraband game)
    {
        super(game);
    }



    @Override
    public void show()
    {
        Gdx.input.setInputProcessor(stage);

        playButton = createNewGameButton(skin);
        settingsButton = createSettingsButton(skin);
        exitButton = createExitButton(skin);


        table.add(playButton);
        table.row();
        table.add(settingsButton);
        table.row();
        table.add(exitButton);
        table.row();
    }



    private TextButton createNewGameButton(Skin skin)
    {
        TextButton gameButton = new TextButton("New Game", skin);

        gameButton.addListener(new ClickListener(Input.Buttons.LEFT)
        {
            public void clicked(InputEvent event, float x, float y)
            {
                game.setScreen(game.getGameScreen());
            }
        });
        return gameButton;
    }

    private TextButton createSettingsButton(Skin skin)
    {
        TextButton settingsButton;
        settingsButton = new TextButton("Settings", skin);

        settingsButton.addListener(new ClickListener(Input.Buttons.LEFT)
        {
            public void clicked(InputEvent event, float x, float y)
            {
                game.setScreen(game.getSettingsScreen());
            }
        });
        return settingsButton;
    }


    private TextButton createExitButton(Skin skin)
    {
        TextButton exitButton;
        exitButton = new TextButton("Exit", skin);

        exitButton.addListener(new ClickListener(Input.Buttons.LEFT)
        {
            public void clicked(InputEvent event, float x, float y)
            {
                Gdx.app.exit();
            }
        });
        return exitButton;
    }




}

