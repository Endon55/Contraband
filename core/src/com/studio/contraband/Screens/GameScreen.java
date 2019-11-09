package com.studio.contraband.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.studio.contraband.Contraband;
import com.studio.contraband.GameItems;
import com.studio.contraband.Player;
import com.studio.contraband.ScreenManager;
import com.studio.contraband.Utils.Constants;
import com.studio.contraband.Utils.HelperFunctions;
import com.studio.contraband.Utils.PreferencesAccess;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


/*
    UI Elements
    Cash, Debt, Location

    Items for Sale
    Prices

    Create 2 tables, one that holds all the text, 3 vGroups
    the second holds 1 vgroup that spans the whole screen width with the number of rows the first has
    the second table gets autosized height wise to the first




 */


public class GameScreen extends ScreenManager
{
    int screenWidth = Gdx.graphics.getWidth();
    int screenHeight = Gdx.graphics.getHeight();


    //List items;
    Button playButton;
    Player player;
    PreferencesAccess preferences;
    ArrayList<GameItems> gameObjects;

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

    public GameScreen(Contraband game)
    {
        super(game);
    }

    @Override
    public void show()
    {
        Gdx.input.setInputProcessor(stage);
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

        table.align(Align.left);
        //table.setBounds(0, , screenWidth, );
        //table.setBounds(0, screenHeight * Constants.GAME_TABLE_SIZE_BOTTOM_Y, screenWidth, screenHeight * Constants.GAME_TABLE_SIZE_TOP_Y);
        if(preferences.isGameInProgress())
        {
            gameObjects = getFreshItemList();
        }
        else gameObjects = getFreshItemList();

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



    private GameItems buildItemObject(String name, int numberPurchased, int purchasePrice, int basePrice)
    {
        GameItems item = new GameItems();
        item.setItemName(name);
        item.setItemQuantity(numberPurchased);
        item.setPurchasePrice(purchasePrice);
        item.setBasePrice(basePrice);
        return item;
    }

    private ClickListener itemClickImplimentation(final GameItems item)
    {
        ClickListener listener = new ClickListener(Input.Buttons.LEFT)
        {

            public void clicked(InputEvent event, float x, float y)
            {
                //TODO Listener Functionality
                System.out.println("Clicked: " + item.getItemName());
                marketplaceDialog(item);
            }

        };
        return listener;
    }

    private Dialog marketplaceDialog(final GameItems item)
    {

        final Dialog dialog = new Dialog("", defaultSkin, "dialog");

        TextureRegionDrawable drawable = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ButtonUp.png"))));
        Window.WindowStyle windowStyle = new Window.WindowStyle(font, Color.RED, drawable);
        final Dialog dialog2 = new Dialog("Title", windowStyle);


        TextButton button = HelperFunctions.createCustomButton("Button", font, "ButtonUp.png", "ButtonDown.png");
        button.addListener(new ClickListener(Input.Buttons.LEFT)
        {

            public void clicked(InputEvent event, float x, float y)
            {
                //TODO Listener Functionality
                System.out.println("ButtonClicked");
                dialog.remove();
            }

        });
        dialog2.scaleBy(2f);
        //dialog2.text(item.getItemName());
        dialog2.add(button);
        //dialog2.button("Yes", true);

        //dialog2.text(item.getItemName());
        //dialog2.button("No", true);
        dialog2.show(stage);

        return dialog2;
    }



    private ArrayList<GameItems> getFreshItemList()
    {
        //Assembles the Array that hold all the different Buy/Sell Items
        ArrayList<GameItems> gameItems = new ArrayList<GameItems>();
        //Drugs
        gameItems.add(buildItemObject("Cocaine", 0, 0, 850));
        gameItems.add(buildItemObject("Heroin", 255, 0, 350));
        gameItems.add(buildItemObject("Weed", 0, 0, 75));
        gameItems.add(buildItemObject("Speed", 0, 0, 125));
        gameItems.add(buildItemObject("Mushrooms", 0, 0, 200));
        gameItems.add(buildItemObject("Peyote", 0, 0, 150));
        gameItems.add(buildItemObject("Meth", 0, 0, 550));
        gameItems.add(buildItemObject("MDMA", 0, 0, 300));
        gameItems.add(buildItemObject("Moonshine", 0, 0, 95));
        //Weapons
        gameItems.add(buildItemObject("Assault Rifle", 0, 0, 1500));
        gameItems.add(buildItemObject("Plastic Explosive", 0, 0, 450));
        gameItems.add(buildItemObject("Handgun", 0, 0, 750));
        gameItems.add(buildItemObject("Anti-Air", 0, 0, 2000000));//2 Million
        gameItems.add(buildItemObject("F18", 0, 0, 55000000));//55 Million
        gameItems.add(buildItemObject("M1-Abrams", 0, 0, 6200000));//6.2 Million
        gameItems.add(buildItemObject("Apache Helicopter", 0, 0, 61000000)); //61 Million


        //Alphabetizes the list
        Collections.sort(gameItems, new Comparator<GameItems>()
        {
            @Override
            public int compare(GameItems item1, GameItems item2)
            {
                return item1.getItemName().compareTo(item2.getItemName());
            }
        });




        return gameItems;
    }


    private void assembleGroups()
    {
        // Builds the Columns of item labels to be displayed
        /*  First issue was that if the item text such as "Weed" doesnt take up much width so the actualy clickable label was only
        about 4 letters wide and the goal was full width. So i had to overlay each row with a custom actor but the biggest issue with
        that was estimating the height of each item row. Basically i couldnt find a way to calculate or guess the height that would work
        on different resolutions. Because the actor seemed to actually be sized to fit i couldnt just let the formatting stretch it itself.
        Eventually I found getPrefHeight which returns a usable number which you divide by the number of items and that's the actors height.  */

        int itemListLength = gameObjects.size();

        //Formatting
        itemGroup.columnAlign(Align.left);
        priceGroup.columnAlign(Align.right);

        //Creates the 3 labels for each item/row and adds each one to a separate group.
        for(int i = 0; i < itemListLength; i++)
        {
            Label itemLabel     = new Label(gameObjects.get(i).getItemName(), fontStyle);
            Label priceLabel    = new Label("$" + HelperFunctions.getPrettyIntString(gameObjects.get(i).getBasePrice()), fontStyle);
            Label quantityLabel = new Label(Integer.toString(gameObjects.get(i).getItemQuantity()), fontStyle);
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
            clickActor.addListener(itemClickImplimentation(gameObjects.get(i)));

            clickActor.setSize(Gdx.graphics.getWidth(), height / itemListLength);
            clickActor.setColor(Color.TAN);
            clickableGroup.addActor(clickActor);
        }
        //Adds the above group to its own table, to be overlaid onto the textTable
        clickableTable.add(clickableGroup).maxHeight(100f);
        table.add(new Stack(textTable, clickableGroup));
    }


}
