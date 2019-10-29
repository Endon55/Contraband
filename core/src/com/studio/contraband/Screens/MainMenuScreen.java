package com.studio.contraband.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.studio.contraband.Contraband;

public class MainMenuScreen implements Screen
{
    Contraband game;
    Stage stage;
    private Table table;
    private Skin skin;
    TextButton playButton;
    TextButton settingsButton;
    TextButton exitButton;

    public MainMenuScreen(Contraband game) {this.game = game;}



    @Override
    public void show()
    {

        skin = new Skin(Gdx.files.internal("GlassySkinUI/glassy-ui.json"));
        playButton = createNewGameButton(skin);
        settingsButton = createSettingsButton(skin);
        exitButton = createExitButton(skin);
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        stage.addActor(table);


        table.add(playButton);
        table.row();
        table.add(settingsButton);
        table.row();
        table.add(exitButton);
        table.row();
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1/30f));
        stage.draw();
        stage.act(delta);
    }

    @Override
    public void resize(int width, int height)    {

    }
    @Override
    public void pause()    {

    }
    @Override
    public void resume()    {

    }
    @Override
    public void hide()      {

    }
    @Override
    public void dispose()    {

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
                game.setScreen(game.getGameScreen());
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

