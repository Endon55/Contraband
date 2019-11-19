package com.studio.contraband;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.studio.contraband.Utils.Enums;
import com.studio.contraband.Utils.HelperFunctions;

public class MarketplaceDialog extends Dialog
{

    String buyText;
    String sellText;

    private BitmapFont font;
    private TextButton buyButton;
    private TextButton sellButton;
    private Table table;

    private int sliderValue;
    private Slider slider;
    private Label sliderLabel;
    private TextButton sliderButton;
    private Player player;
    private int index;
    private Enums.DialogStates state;

    private float currentPrice;


    public MarketplaceDialog(String title, Skin skin, BitmapFont font, Player player, int index)
    {
        super(title, skin);
        this.player = player;
        this.font = font;
        this.index = index;
        setup();
        currentPrice = 100f;
    }


    private void secondDialogWindow()
    {
        int currentSliderValue;
        //Takes the lower of the 2, the max number the player can hold or max of what they can buy
        int maxBuy = Math.min(player.getMaxSpace() - player.getUsedSpace(),(int)(player.getMoney() / currentPrice));
        int maxSell = player.getGameItems().get(index).getNumberOwned();
        sliderLabel = new Label("0", getSkin());

        if(state == Enums.DialogStates.buy)
        {
            currentSliderValue = maxBuy;
            sliderLabel = new Label(Integer.toString(currentSliderValue), getSkin());
            slider = new Slider(0f, maxBuy, 1, false, getSkin());
            slider.setValue(currentSliderValue);
            sliderButton = HelperFunctions.createCustomButton(buyText, font, "ButtonUp3.png", "ButtonDown3.png");

            slider.addListener(new ChangeListener()
            {
                public void changed(ChangeEvent event, Actor actor)
                {
                    updateLabel((int)slider.getValue());
                }
            });

            sliderButton.addListener(new ClickListener(Input.Buttons.LEFT)
            {
                public void clicked(InputEvent event, float x, float y)
                {
                    player.buy(index, (int)slider.getValue(), currentPrice);
                    hide();
                }
            });

            getContentTable().add(sliderLabel);
            getContentTable().row();
            getContentTable().add(slider).width(getWidth() * .8f);
            getButtonTable().add(sliderButton);
        }
        else if(state == Enums.DialogStates.sell)
        {
            currentSliderValue = maxSell;
            sliderLabel = new Label(Integer.toString(currentSliderValue), getSkin());
            slider = new Slider(0f, maxSell, 1, false, getSkin());
            slider.setValue(currentSliderValue);
            sliderButton = HelperFunctions.createCustomButton(sellText, font, "ButtonUp3.png", "ButtonDown3.png");

            slider.addListener(new ChangeListener()
            {
                public void changed(ChangeEvent event, Actor actor)
                {
                    updateLabel((int)slider.getValue());
                }
            });

            sliderButton.addListener(new ClickListener(Input.Buttons.LEFT)
            {
                public void clicked(InputEvent event, float x, float y)
                {
                    player.sell(index, (int)slider.getValue(), currentPrice);
                    hide();
                }
            });

            getContentTable().add(sliderLabel);
            getContentTable().row();
            getContentTable().add(slider).width(getWidth() * .8f);
            getButtonTable().add(sliderButton);
        }



    }
/*
    private void specificsWindow(float money, float currentPrice)
    {
        sliderValue = 0;


        final Slider
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
        getButtonTable().add(buySliderButton);
        buyButton.addListener(new ClickListener(Input.Buttons.LEFT)
        {

            public void clicked(InputEvent event, float x, float y)
            {
                hide();
            }

        });
    }

 */
    private void updateLabel(int sliderValue)
    {
        sliderLabel.setText(Integer.toString(sliderValue));
    }


    public void setup()
    {
        buyText = "Buy";
        sellText = "Sell";
        table = new Table();
        sliderValue = 0;

        buyButton        = HelperFunctions.createCustomButton(buyText, font, "ButtonUp3.png", "ButtonDown3.png");
        sellButton       = HelperFunctions.createCustomButton(sellText, font, "ButtonUp3.png", "ButtonDown3.png");

        padTop(0);
        padBottom(0);
        getButtonTable().row();

        getButtonTable().add(buyButton);
        getButtonTable().row();
        getButtonTable().add(sellButton);

        buyButton.addListener(new ClickListener(Input.Buttons.LEFT)
        {
            public void clicked(InputEvent event, float x, float y)
            {
                System.out.println("BuyClicked");
                getButtonTable().clear();
                getContentTable().clear();
                state = Enums.DialogStates.buy;
                secondDialogWindow();
            }
        });
        sellButton.addListener(new ClickListener(Input.Buttons.LEFT)
        {

            public void clicked(InputEvent event, float x, float y)
            {
                System.out.println("SellClicked");
                getButtonTable().clear();
                getContentTable().clear();
                state = Enums.DialogStates.sell;
                secondDialogWindow();
            }
        });
    }




}
