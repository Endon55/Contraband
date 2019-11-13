package com.studio.contraband;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.studio.contraband.Utils.HelperFunctions;


public class MarketplaceWindow
{
    Window window;
    Window.WindowStyle style;

    BitmapFont font;
    Skin skin;
    Table windowTable;
    TextButton buyButton;
    TextButton sellButton;
    String title;


    public MarketplaceWindow(String title, Skin skin, BitmapFont font, Table windowTable)
    {
        this.title = title;
        this.skin = skin;
        this.font = font;
        this.windowTable = windowTable;

    }

    public void setup()
    {
        window = new Window(title, skin);

        buyButton = HelperFunctions.createCustomButton("Buy", font, "ButtonUp.png", "ButtonDown.png");
        sellButton = HelperFunctions.createCustomButton("Sell", font, "ButtonUp.png", "ButtonDown.png");

        buyButton.addListener( new ClickListener(Input.Buttons.LEFT)
        {

            public void clicked(InputEvent event, float x, float y)
            {
                //TODO Listener Functionality
                hide(windowTable, window);
            }

        });

        sellButton.addListener( new ClickListener(Input.Buttons.LEFT)
        {

            public void clicked(InputEvent event, float x, float y)
            {
                //TODO Listener Functionality
                hide(windowTable, window);
            }

        });

        window.add(buyButton);
        window.add(sellButton);

        window.keepWithinStage();
        window.setMovable(false);
        window.pack();

    }

    public void show(GameItems item)
    {

        windowTable.add(window).align(Align.center);

    }

    private static void hide(Table windowTable, Window window)
    {
        windowTable.removeActor(window);
    }





}
