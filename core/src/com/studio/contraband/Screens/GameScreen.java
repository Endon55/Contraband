package com.studio.contraband.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.studio.contraband.Contraband;
import com.studio.contraband.GameItems;
import com.studio.contraband.Player;
import com.studio.contraband.ScreenManager;
import com.studio.contraband.Utils.Constants;
import com.studio.contraband.Utils.HelperFunctions;
import com.studio.contraband.Utils.PreferencesAccess;

import java.util.ArrayList;


/*
    UI Elements
    Cash, Debt, Location

    Items for Sale
    Prices
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


    VerticalGroup itemGroup;
    VerticalGroup quantityGroup;
    VerticalGroup priceGroup;

    public GameScreen(Contraband game)
    {
        super(game);
    }

    @Override
    public void show()
    {
        Gdx.input.setInputProcessor(stage);
        generator = new FreeTypeFontGenerator(Gdx.files.internal("SulphurPoint-Bold.otf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = (int)HelperFunctions.resizeText(screenWidth, 50f, 1080);
        font = generator.generateFont(parameter);
        generator.dispose();
        fontStyle = new Label.LabelStyle(font, Color.BLACK);

        preferences = new PreferencesAccess();

        itemGroup = new VerticalGroup();
        quantityGroup = new VerticalGroup();
        priceGroup = new VerticalGroup();

        table.align(Align.left);
        //table.setBounds(0, 0, screenWidth, screenHeight);

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




    private void assembleGroups()
    {
        // Builds the Columns of item labels to be displayed

        itemGroup.columnAlign(Align.left);
        priceGroup.columnAlign(Align.right);
        for(int i = 0; i < gameObjects.size(); i++)
        {
            /*
                  gameButton.addListener(new ClickListener(Input.Buttons.LEFT)
        {
            public void clicked(InputEvent event, float x, float y)
            {
                game.setScreen(game.getGameScreen());
            }
        });
             */

            Label itemLabel     = new Label(gameObjects.get(i).getItemName(), fontStyle);
            Label priceLabel    = new Label("$" + HelperFunctions.getPrettyIntString(gameObjects.get(i).getBasePrice()), fontStyle);
            Label quantityLabel = new Label(Integer.toString(gameObjects.get(i).getItemQuantity()), fontStyle);
            itemLabel.addListener(new ClickListener(Input.Buttons.LEFT)
            {
                public void clicked(InputEvent event, float x, float y)
                {
                    //TODO Listener Functionality
                    System.out.println("Clicked");
                }
            });
            priceLabel.addListener(new ClickListener(Input.Buttons.LEFT)
            {
                public void clicked(InputEvent event, float x, float y)
                {
                    //TODO Listener Functionality
                    System.out.println("Clicked");
                }
            });
            quantityLabel.addListener(new ClickListener(Input.Buttons.LEFT)
            {
                public void clicked(InputEvent event, float x, float y)
                {
                    //TODO Listener Functionality
                    System.out.println("Clicked");
                }
            });

            itemGroup.addActor(itemLabel);
            priceGroup.addActor(priceLabel);
            quantityGroup.addActor(quantityLabel);

        }
        table.add(quantityGroup).expand().padLeft(screenWidth * Constants.QUANTITY_LEFT_PAD_SIZE);//.setActorWidth(screenWidth * Constants.QUANTITY_SIZE);
        table.add(itemGroup)    .expand().padLeft(screenWidth * Constants.NAME_LEFT_SIZE_PAD);//    .setActorWidth(screenWidth * Constants.NAME_SIZE);
        table.add(priceGroup)   .expand().padLeft(screenWidth * Constants.PRICE_LEFT_SIZE_PAD);//   .padRight(screenWidth * Constants.PRICE_RIGHT_SIZE_PAD).setActorWidth(screenWidth * Constants.PRICE_SIZE);
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
        gameItems.add(buildItemObject("Anti-Air", 0, 0, 2000000));//2 Million
        gameItems.add(buildItemObject("Handgun", 0, 0, 750));
        gameItems.add(buildItemObject("F18", 0, 0, 55000000));//55 Million
        gameItems.add(buildItemObject("M1-Abrams", 0, 0, 6200000));//6.2 Million
        gameItems.add(buildItemObject("Apache Helicopter", 0, 0, 61000000)); //61 Million
        return gameItems;
    }

    //private ClickListener()


}
