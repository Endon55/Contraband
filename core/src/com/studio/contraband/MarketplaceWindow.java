package com.studio.contraband;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
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
    Stage stage;


    public MarketplaceWindow(String title, Skin skin, BitmapFont font, Table windowTable, Stage stage )
    {
        this.stage = stage;
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

        buyButton.addListener(buttonListener());
        sellButton.addListener(buttonListener());


        window.add(buyButton);
        window.add(sellButton);

        window.keepWithinStage();
        window.setMovable(false);
        window.pack();

    }

    public void show(GameItems item)
    {

        windowTable.add(window).align(Align.center);
        InputListener ignoreTouchDown = new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                event.cancel();
                return false;
            }
        };
        //stage.setKeyboardFocus(window);
        //stage.setScrollFocus(window);
        //System.out.println(stage.getKeyboardFocus());
        //System.out.println(stage.getScrollFocus());

    }

    private static void hide(Table windowTable, Window window)
    {
        windowTable.removeActor(window);
        window.defaults();
    }

    private ClickListener buttonListener()
    {
        return new ClickListener(Input.Buttons.LEFT)
        {

            public void clicked(InputEvent event, float x, float y)
            {
                //TODO Listener Functionality
                hide(windowTable, window);
            }

        };
    }



}
