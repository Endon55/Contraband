package com.studio.contraband;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.studio.contraband.Utils.ContrabandItems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Player
{

    private float money;
    private int maxSpace;
    private int usedSpace;


    private int numberOfItems;

    private ArrayList<GameItems> gameItems;

    /**
     Init() must be called before using anything in the class
     */
    public Player()
    {

    }

    public void init(float startingMoney, int startingMaxSpace)
    {
        money = startingMoney;
        maxSpace = startingMaxSpace;
        usedSpace = 0;
        getFreshItemList();
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

    private void getFreshItemList()
    {
        //Assembles the Array that hold all the different Buy/Sell Items
        gameItems = new ArrayList<GameItems>();
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

        numberOfItems = gameItems.size();
    }

    public float getMoney()
    {
        return money;
    }
    public void setMoney(float money)
    {
        this.money = money;
    }
    public int getMaxSpace()
    {
        return maxSpace;
    }
    public void setMaxSpace(int maxSpace)
    {
        this.maxSpace = maxSpace;
    }
    public int getUsedSpace()
    {
        return usedSpace;
    }
    public void setUsedSpace(int usedSpace)
    {
        this.usedSpace = usedSpace;
    }
    public int getNumberOfItems()
    {
        return numberOfItems;
    }
    public void setNumberOfItems(int numberOfItems)
    {
        this.numberOfItems = numberOfItems;
    }
    public ArrayList<GameItems> getGameItems()
    {
        return gameItems;
    }
}
