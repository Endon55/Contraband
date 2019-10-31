package com.studio.contraband.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.studio.contraband.Contraband;
import com.studio.contraband.GameObjects;
import com.studio.contraband.Player;
import com.studio.contraband.ScreenManager;
import com.studio.contraband.Utils.Constants;
import com.studio.contraband.Utils.HelperFunctions;
import com.studio.contraband.Utils.PreferencesAccess;


/*
    UI Elements
    Cash, Debt, Location

    Items for Sale
    Prices
 */


public class GameScreen extends ScreenManager
{
    //List items;
    Button playButton;
    Player player;
    PreferencesAccess preferences;


    public GameScreen(Contraband game)
    {
        super(game);
    }

    @Override
    public void show()
    {
        preferences = new PreferencesAccess();
        Gdx.input.setInputProcessor(stage);

        if(preferences.isGameInProgress())
        {
            player = new Player(100000f, 100, 0, Constants.ITEMS_LIST, HelperFunctions.getEmptyIntArray(), HelperFunctions.getEmptyFloatArray());
        }
        else player = new Player(100000f, 100, 0, Constants.ITEMS_LIST, HelperFunctions.getEmptyIntArray(), HelperFunctions.getEmptyFloatArray());

        playButton = createNewGameButton(skin);

        //table.add(player.cocaine.getLabel());
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
