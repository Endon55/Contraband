package com.studio.contraband.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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
    //List items;
    Button playButton;
    Player player;
    PreferencesAccess preferences;
    ArrayList<GameItems> gameObjects;

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
        preferences = new PreferencesAccess();
        Gdx.input.setInputProcessor(stage);
        itemGroup = new VerticalGroup();
        quantityGroup = new VerticalGroup();
        priceGroup = new VerticalGroup();


        if(preferences.isGameInProgress())
        {
            gameObjects = getFreshItemList();
        }
        else gameObjects = getFreshItemList();

        playButton = createNewGameButton(skin);

        assembleGroups();

        //table.add(player.cocaine.getLabel());
        //table.add(playButton);
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
        gameItems.add(buildItemObject("C4", 0, 0, 450));
        gameItems.add(buildItemObject("Anti-Air", 0, 0, 2000000));//2 Million
        gameItems.add(buildItemObject("Handgun", 0, 0, 750));
        gameItems.add(buildItemObject("F18", 0, 0, 55000000));//55 Million
        gameItems.add(buildItemObject("M1-Abrams", 0, 0, 6200000));//6.2 Million
        gameItems.add(buildItemObject("Apache-Helicopter", 0, 0, 61000000)); //61 Million

/*        for(int i = 0; i < gameItems.size(); i++)
        {
            table.add(gameItems.get(i).getGroupLabel(skin, stage));
            table.row();
            //table.row();

        }*/
        return gameItems;
    }

    private void assembleGroups()
    {
        // Builds the Columns of item labels to be displayed
        //itemGroup.grow();
        //itemGroup.left();
        itemGroup.columnAlign(Align.left);
        priceGroup.columnAlign(Align.right);
        //priceGroup.setWidth(500f);
        for(int i = 0; i < gameObjects.size(); i++)
        {
            itemGroup.addActor(new Label(gameObjects.get(i).getItemName(), skin));

            quantityGroup.addActor(new Label(Integer.toString(gameObjects.get(i).getItemQuantity()), skin));
            //quantityGroup.setWidth(250);
            priceGroup.addActor(new Label("$" + HelperFunctions.getPrettyIntString(gameObjects.get(i).getBasePrice()), skin));
            //table.row();


        }
        //.width(150f)
        table.add(quantityGroup).pad(10);
        table.add(itemGroup).pad(10);
        table.add(priceGroup).pad(10);
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


}
