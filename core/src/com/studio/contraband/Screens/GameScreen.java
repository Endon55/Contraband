package com.studio.contraband.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.studio.contraband.Contraband;
import com.studio.contraband.ScreenManager;


/*
    UI Elements
    Cash, Debt, Location

    Items for Sale
    Prices
 */


public class GameScreen extends ScreenManager
{
    //List items;
    Label testLabel;
    Button playButton;
    public GameScreen(Contraband game)
    {
        super(game);
    }

    @Override
    public void show()
    {
        Gdx.input.setInputProcessor(stage);
        playButton = createNewGameButton(skin);
        testLabel = new Label("Cocaine", skin);
        //Array<String> listItems = new Array<String> (new String[] {"Cocaine", "Heroin", "C4"});
        //items = new List(skin);
        //items.setItems(listItems);

        testLabel.addListener(new ClickListener(Input.Buttons.LEFT)
        {
            public void clicked(InputEvent event, float x, float y)
            {
                Gdx.app.exit();
            }
        });


        //table.add(items);
        //table.row();
        table.add(testLabel);
        table.add(playButton);
        //Gdx.app.exit();







        //table.add(items);

    }
    private TextButton createNewGameButton(Skin skin)
    {
        TextButton gameButton = new TextButton("New Game", skin);

        gameButton.addListener(new ClickListener(Input.Buttons.LEFT)
        {
            public void clicked(InputEvent event, float x, float y)
            {
                Gdx.app.exit();
            }

        });
        return gameButton;
    }

}
