package com.studio.contraband;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class GameObjects
{
    String itemName;
    float priceBoughtAt;
    float currentBuyablePrice;
    int itemQuantitiy;
    float basePrice;

    Label itemLabel;

    Skin skin;



    public GameObjects(String itemName, float basePrice, Skin skin)
    {
        this.itemName = itemName;
        this.basePrice = basePrice;
        this.skin = skin;
        itemLabel = createLabel();
    }

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

    public Label getLabel()
    {
        return itemLabel;
    }

    public void destroyLabel()
    {

    }

}