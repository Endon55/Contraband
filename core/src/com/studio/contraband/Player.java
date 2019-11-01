package com.studio.contraband;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.studio.contraband.Utils.ContrabandItems;

public class Player
{

    //Data to save
    //Item Name, Amount Owned, Price Bought At

    float money;
    int maxSpace;
    int usedSpace;

    String[] ItemsList;
    int[] NumberOfItemsOwned;
    float[] PurchasePrice;




    public Player(float startingMoney, int startingBagSpace, int usedSpace, String[] ItemsList, int[] NumberOfItemsOwned, float[] PurchasePrice)
    {
        money = startingMoney;
        maxSpace = startingBagSpace;
        this.usedSpace = usedSpace;

        this.NumberOfItemsOwned = NumberOfItemsOwned;
        this.ItemsList = ItemsList;
        this.PurchasePrice = PurchasePrice;
    }

    void labelGenerator()
    {

        //return new Label(skin);
    }


}
