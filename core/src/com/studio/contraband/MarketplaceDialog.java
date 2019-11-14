package com.studio.contraband;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.studio.contraband.Utils.Constants;
import com.studio.contraband.Utils.HelperFunctions;

public class MarketplaceDialog extends Dialog
{

    Window.WindowStyle style;

    BitmapFont font;
    TextButton buyButton;
    TextButton sellButton;
    Table table;
    private int buySliderValue;
    private int sellSliderValue;
    private Label buySliderLabel;
    private Label sellSliderLabel;



    public MarketplaceDialog(String title, Skin skin, BitmapFont font)
    {
        super(title, skin);
        this.font = font;
        setup();
    }


    public void setup()
    {
        buySliderValue = 0;
        sellSliderValue = 0;
        table = new Table();
        buyButton = HelperFunctions.createCustomButton("Buy", font, "ButtonUp3.png", "ButtonDown3.png");
        sellButton = HelperFunctions.createCustomButton("Sell", font, "ButtonUp3.png", "ButtonDown3.png");

        padTop(0);
        padBottom(0);
        //button(buyButton, "buyButton");
        getButtonTable().row();
        //button(sellButton, "sellButton");

        getButtonTable().add(buyButton);
        getButtonTable().row();
        getButtonTable().add(sellButton);

        buyButton.addListener(buttonListener());
        sellButton.addListener(buttonListener());

        //getContentTable().add(sellButton).width(Gdx.graphics.getWidth() * .8f);
        //table.add(buyButton).left();
        //table.row();
        //table.add(sellButton).left();
        //this.getContentTable().add(table).align(Align.left).expand().fill();


    }

    private void buyDialogWindow(float money, float currentPrice)
    {
        buySliderValue = 0;
        float maxBuy = (int)(money / currentPrice);
        final int currentSliderValue = 0;
        final Slider slider = new Slider(0f, maxBuy, 1, false, getSkin());
        buySliderLabel = new Label(Integer.toString(currentSliderValue), getSkin());

        slider.addListener(new ChangeListener()
        {

            public void changed(ChangeEvent event, Actor actor)
            {
                //currentSliderValue = slider.getValue();
               sliderReturn((int)slider.getValue(), true);
            }

        });

        getContentTable().add(buySliderLabel);
        getContentTable().row();
        getContentTable().add(slider).width(getWidth() * .8f);
    }
    private void sliderReturn(int sliderValue, boolean isBuy)
    {
        if(isBuy)
        {
            buySliderValue = sliderValue;
            buySliderLabel.setText(buySliderValue);
        }
        else sellSliderValue = sliderValue;
    }
    private void sellDialogWindow()
    {
        sellSliderValue = 0;
    }




    private ClickListener buttonListener()
    {
        return new ClickListener(Input.Buttons.LEFT)
        {

            public void clicked(InputEvent event, float x, float y)
            {
                System.out.println("BuySellClicked");
                getButtonTable().clear();
                getContentTable().clear();
                buyDialogWindow(100, 10);
            }

        };
    }






}
