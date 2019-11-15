package com.studio.contraband;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;
import com.studio.contraband.Utils.HelperFunctions;

import java.text.NumberFormat;

public class GameItems
{
    private String itemName;
    private int purchasePrice;
    private int numberOwned;
    private int basePrice;

    public GameItems()  {}

    public String getItemName()
    {
        return itemName;
    }
    public void setItemName(String itemName)
    {
        this.itemName = itemName;
    }
    public float getPurchasePrice()
    {
        return purchasePrice;
    }
    public void setPurchasePrice(int purchasePrice)
    {
        this.purchasePrice = purchasePrice;
    }
    public int getNumberOwned()
    {
        return numberOwned;
    }
    public void setNumberOwned(int itemQuantity)
    {
        this.numberOwned = itemQuantity;
    }
    public int getBasePrice()
    {
        return basePrice;
    }
    public void setBasePrice(int basePrice)
    {
        this.basePrice = basePrice;
    }
}