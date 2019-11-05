package com.studio.contraband;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.studio.contraband.Utils.HelperFunctions;

import java.text.NumberFormat;

public class GameItems
{

    private String itemName;
    private int purchasePrice;
    private int itemQuantity;
    private int basePrice;

    //Label itemLabel;

    //Skin skin;



    public GameItems()  {}
/*
    private Label createLabel()
    {
        Label label = new Label(itemName, skin);
        label.addListener(new ClickListener(Input.Buttons.LEFT)
        {
            public void clicked(InputEvent event, float x, float y)
            {
                Gdx.app.exit();
            }
        });

        return label;
    }
*/
    public HorizontalGroup getGroupLabel(Skin skin, Stage stage)
    {
        HorizontalGroup group = new HorizontalGroup();
        stage.addActor(group);
        group.addActor(new Label(itemName, skin));
        group.addActor(new Label(Integer.toString(itemQuantity), skin));
        group.space(10f);
        group.addActor(new Label(HelperFunctions.getPrettyIntString(basePrice), skin));
        group.space(10f);
        group.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        group.align(Align.bottom);
        return group;
    }

    public void destroyLabel()
    {

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

    public int getItemQuantity()
    {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity)
    {
        this.itemQuantity = itemQuantity;
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
