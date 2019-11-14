package com.studio.contraband.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.studio.contraband.*;
import com.studio.contraband.Utils.Constants;
import com.studio.contraband.Utils.HelperFunctions;
import com.studio.contraband.Utils.PreferencesAccess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


/**
    UI Elements
    Cash, Debt, Location

 Buy greys out if not enough money
 Sell greys out if none to sell

 */


public class GameScreen extends ScreenManager
{
    int screenWidth = Gdx.graphics.getWidth();
    int screenHeight = Gdx.graphics.getHeight();


    //List items;

    Button playButton;
    PreferencesAccess preferences;
    Player player;

    FreeTypeFontGenerator generator;
    FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    BitmapFont font;
    Label.LabelStyle fontStyle;
    Skin defaultSkin;

    Table clickableTable;
    Table textTable;
    VerticalGroup itemGroup;
    VerticalGroup quantityGroup;
    VerticalGroup priceGroup;
    VerticalGroup clickableGroup;
    MarketplaceDialog marketDialog;

    public GameScreen(Contraband game)
    {
        super(game);
    }

    @Override
    public void show()
    {
        Gdx.input.setInputProcessor(stage);

        init();
        table.setBackground(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("BasicBackground.png")))));
        table.align(Align.left);

        playButton = createNewGameButton(skin);

        assembleGroups();
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




    private ClickListener itemClickImplimentation(final GameItems item)
    {
        ClickListener listener = new ClickListener(Input.Buttons.LEFT)
        {

            public void clicked(InputEvent event, float x, float y)
            {
                //TODO Listener Functionality
                System.out.println("Clicked: " + item.getItemName());
                //marketplaceDialog(item);
                //marketWindow.show(item);
                marketDialog.show(stage);
            }

        };
        return listener;
    }




    private void assembleGroups()
    {
        // Builds the Columns of item labels to be displayed
        /*  First issue was that if the item text such as "Weed" doesnt take up much width so the actualy clickable label was only
        about 4 letters wide and the goal was full width. So i had to overlay each row with a custom actor but the biggest issue with
        that was estimating the height of each item row. Basically i couldnt find a way to calculate or guess the height that would work
        on different resolutions. Because the actor seemed to actually be sized to fit i couldnt just let the formatting stretch it itself.
        Eventually I found getPrefHeight which returns a usable number which you divide by the number of items and that's the actors height.  */

        int itemListLength = player.getNumberOfItems();

        //Formatting
        itemGroup.columnAlign(Align.left);
        priceGroup.columnAlign(Align.right);

        //Creates the 3 labels for each item/row and adds each one to a separate group.
        for(int i = 0; i < itemListLength; i++)
        {
            Label itemLabel     = new Label(player.getGameItems().get(i).getItemName(), fontStyle);
            Label priceLabel    = new Label("$" + HelperFunctions.getPrettyIntString(player.getGameItems().get(i).getBasePrice()), fontStyle);
            Label quantityLabel = new Label(Integer.toString(player.getGameItems().get(i).getItemQuantity()), fontStyle);
            itemGroup.addActor(itemLabel);
            priceGroup.addActor(priceLabel);
            quantityGroup.addActor(quantityLabel);
        }
        //Padding Between Rows
        quantityGroup.space(Constants.VERTICAL_PADDING);
        itemGroup    .space(Constants.VERTICAL_PADDING);
        priceGroup   .space(Constants.VERTICAL_PADDING);

        //Expand and Fill cause the table to expand all the way to the sides of the screen.
        textTable.add(quantityGroup).expandX().fillX().padLeft(screenWidth * Constants.QUANTITY_LEFT_PAD_SIZE);
        textTable.add(itemGroup)    .expandX().fillX().padLeft(screenWidth * Constants.NAME_LEFT_SIZE_PAD);
        textTable.add(priceGroup)   .expandX().fillX().padLeft(screenWidth * Constants.PRICE_LEFT_SIZE_PAD);

        //Gets the "height" of the above groups
        float height = textTable.getPrefHeight();
        //Creates a separate group for the clickable actors that span the whole width.
        for(int i = 0; i < itemListLength; i++)
        {
            Actor clickActor = new Actor();
            clickActor.addListener(itemClickImplimentation(player.getGameItems().get(i)));

            clickActor.setSize(Gdx.graphics.getWidth(), height / itemListLength);
            clickActor.setColor(Color.TAN);
            clickableGroup.addActor(clickActor);
        }
        //Adds the above group to its own table, to be overlaid onto the textTable
        clickableTable.add(clickableGroup).maxHeight(100f);
        table.add(new Stack(textTable, clickableGroup));
    }



    private void init()
    {
        player = new Player();
        player.init(Constants.STARTING_MONEY, Constants.STARTING_SPACE);
        defaultSkin = new Skin(Gdx.files.internal("DefaultSkin/uiskin.json"));
        generator = new FreeTypeFontGenerator(Gdx.files.internal("SulphurPoint-Bold.otf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = (int)HelperFunctions.resizeText(screenWidth, 50f, 1080);
        font = generator.generateFont(parameter);
        generator.dispose();
        fontStyle = new Label.LabelStyle(font, Color.BLACK);
        preferences = new PreferencesAccess();

        textTable = new Table();
        clickableTable = new Table();
        clickableTable.setDebug(true);
        itemGroup = new VerticalGroup();
        quantityGroup = new VerticalGroup();
        priceGroup = new VerticalGroup();
        clickableGroup = new VerticalGroup();

        marketDialog = new MarketplaceDialog("", defaultSkin, font);

    }
}
