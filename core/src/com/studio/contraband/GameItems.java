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
    private Label itemNameLabel;
    private Label numberOwnedLabel;
    private Label basePricelabel;
    private Label.LabelStyle fontStyle;

    public GameItems() { }

    public void init(String itemName, int numberOwned, int basePrice, Label.LabelStyle fontStyle)
    {
        this.fontStyle = fontStyle;
        this.itemName = itemName;
        this.numberOwned = numberOwned;
        this.basePrice = basePrice;
        itemNameLabel = new Label("", fontStyle);
        numberOwnedLabel = new Label("", fontStyle);
        basePricelabel = new Label("", fontStyle);
        update();
    }



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

    public Label getItemNameLabel()
    {
        return itemNameLabel;
    }
    public Label getNumberOwnedLabel()
    {
        return numberOwnedLabel;
    }
    public Label getBasePricelabel()
    {
        return basePricelabel;
    }
    public void setItemNameLabel(Label itemNameLabel)
    {
        this.itemNameLabel = itemNameLabel;
    }
    public void setNumberOwnedLabel(Label numberOwnedLabel)
    {
        this.numberOwnedLabel = numberOwnedLabel;
    }
    public void setBasePricelabel(Label basePricelabel)
    {
        this.basePricelabel = basePricelabel;
    }

    public void update()
    {
        itemNameLabel   .setText(itemName);
        numberOwnedLabel.setText(Integer.toString(numberOwned));
        basePricelabel  .setText("$" + HelperFunctions.getPrettyIntString(basePrice));
    }

}