package com.studio.contraband;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.studio.contraband.Utils.Constants;
import com.studio.contraband.Utils.HelperFunctions;
import com.studio.contraband.Utils.RawItemStruct;

import java.util.ArrayList;

public class Player
{
    private int money;
    private int maxSpace;
    private int usedSpace;
    private int numberOfItems;
    private ArrayList<GameItems> gameItems;

    private Label.LabelStyle fontStyle;
    private Label moneyLabel;
    private Label maxSpaceLabel;
    private Label usedSpaceLabel;

    /**
     Init() must be called before using anything in the class
     */
    public Player()
    {

    }

    private void calculateUsedSpace()
    {
        int temp = 0;
        for (GameItems item: gameItems)
        {
            temp += item.getNumberOwned();
        }
        usedSpace = temp;
    }
    
    private void updatePlayer()
    {
        moneyLabel.setText("$" + HelperFunctions.getPrettyIntString(money));
        usedSpaceLabel.setText(Integer.toString(usedSpace));
        maxSpaceLabel.setText("/" + Integer.toString(maxSpace));
    }


    public void buy(int index, int numberBought, int buyPrice)
    {
        int currentQuantity = gameItems.get(index).getNumberOwned();
        money = money - (numberBought * buyPrice);
        gameItems.get(index).setNumberOwned(currentQuantity + numberBought);
        gameItems.get(index).update();
        usedSpace += numberBought;
        updatePlayer();
    }

    public void sell(int index, int numberSold, int sellPrice)
    {
        int currentQuantity = gameItems.get(index).getNumberOwned();
        money = money + (numberSold * sellPrice);
        gameItems.get(index).setNumberOwned(currentQuantity - numberSold);
        gameItems.get(index).update();
        usedSpace -= numberSold;
        updatePlayer();
    }

    public void init(int startingMoney, int startingMaxSpace, Label.LabelStyle fontStyle)
    {
        this.fontStyle = fontStyle;

        money = startingMoney;
        maxSpace = startingMaxSpace;
        usedSpace = 0;
        moneyLabel = new Label("$" + HelperFunctions.getPrettyIntString(money), fontStyle);
        maxSpaceLabel = new Label("/" + Integer.toString(maxSpace), fontStyle);
        usedSpaceLabel =  new Label(Integer.toString(usedSpace), fontStyle);
        getFreshItemList();
    }
    private GameItems buildItemObject(String name, boolean isWeapon, int numberPurchased, int purchasePrice, int basePrice)
    {
        GameItems item = new GameItems();
        item.init(name, isWeapon, numberPurchased, basePrice, fontStyle);
        item.setItemName(name);
        item.setNumberOwned(numberPurchased);
        item.setPurchasePrice(purchasePrice);
        item.setBasePrice(basePrice);
        return item;
    }

    private void getFreshItemList()
    {
        //Assembles the Array that hold all the different Buy/Sell Items
        gameItems = new ArrayList<GameItems>();
        //Drugs

        for (RawItemStruct item : Constants.ITEM_LIST)
        {
            gameItems.add(buildItemObject(item.Name, item.Weapon, 0, 0, item.BasePrice));
        }
        //Alphabetizes the list
/*
        Collections.sort(gameItems, new Comparator<GameItems>()
        {
            @Override
            public int compare(GameItems item1, GameItems item2)
            {
                return item1.getItemName().compareTo(item2.getItemName());
            }
        });

*/
        calculateUsedSpace();
        numberOfItems = gameItems.size();

    }
    public float getMoney()
    {
        return money;
    }
    public void setMoney(int money)
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
    public Label getMoneyLabel()
    {
        return moneyLabel;
    }
    public void setMoneyLabel(Label moneyLabel)
    {
        this.moneyLabel = moneyLabel;
    }
    public Label getMaxSpaceLabel()
    {
        return maxSpaceLabel;
    }
    public void setMaxSpaceLabel(Label maxSpaceLabel)
    {
        this.maxSpaceLabel = maxSpaceLabel;
    }
    public Label getUsedSpaceLabel()
    {
        return usedSpaceLabel;
    }
    public void setUsedSpaceLabel(Label usedSpaceLabel)
    {
        this.usedSpaceLabel = usedSpaceLabel;
    }

}
