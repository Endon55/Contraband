package com.studio.contraband.Dialogs;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.studio.contraband.CityManager;
import com.studio.contraband.Utils.HelperFunctions;

public class ChangeCityDialog extends Dialog
{
    private BitmapFont font;
    private Button tokyo;
    private Button istanbul;
    private Button shanghai;
    private Button paris;
    private Button newYork;
    private Button mumbai;
    private Button cancel;
    CityManager cityManager;


    public ChangeCityDialog(String title, Skin skin, BitmapFont font, CityManager cityManager)
    {
        super(title, skin);
        this.font = font;
        this.cityManager = cityManager;
        init();
    }

    private void init()
    {
        tokyo = HelperFunctions.createCustomButton("Tokyo", font,"CitySelectButtonBlack.png", "CitySelectButtonGreen.png");
        istanbul = HelperFunctions.createCustomButton("Istanbul", font,"CitySelectButtonBlack.png", "CitySelectButtonGreen.png");
        shanghai = HelperFunctions.createCustomButton("Shanghai", font,"CitySelectButtonBlack.png", "CitySelectButtonGreen.png");
        paris = HelperFunctions.createCustomButton("Paris", font,"CitySelectButtonBlack.png", "CitySelectButtonGreen.png");
        newYork = HelperFunctions.createCustomButton("New York", font,"CitySelectButtonBlack.png", "CitySelectButtonGreen.png");
        mumbai = HelperFunctions.createCustomButton("Mumbai", font,"CitySelectButtonBlack.png", "CitySelectButtonGreen.png");

        cancel = HelperFunctions.createCustomButton("Cancel", font,"CitySelectButtonBlack.png", "CitySelectButtonGreen.png");

        buttonListeners();



        getButtonTable().add(tokyo);
        getButtonTable().row();
        getButtonTable().add(istanbul);
        getButtonTable().row();
        getButtonTable().add(shanghai);
        getButtonTable().row();
        getButtonTable().add(paris);
        getButtonTable().row();
        getButtonTable().add(newYork);
        getButtonTable().row();
        getButtonTable().add(mumbai);
        getButtonTable().row();
        getButtonTable().add(cancel);
    }

    private void buttonListeners()
    {

        tokyo.addListener(new ClickListener(Input.Buttons.LEFT)
        {
            public void clicked(InputEvent event, float x, float y)
            {
                //TODO Listener Functionality
                cityManager.changeCity(cityManager.tokyo);
                hide();
            }
        });
        istanbul.addListener(new ClickListener(Input.Buttons.LEFT)
        {
            public void clicked(InputEvent event, float x, float y)
            {
                //TODO Listener Functionality
                cityManager.changeCity(cityManager.istanbul);
                hide();
            }
        });
        shanghai.addListener(new ClickListener(Input.Buttons.LEFT)
    {
        public void clicked(InputEvent event, float x, float y)
        {
            //TODO Listener Functionality
            cityManager.changeCity(cityManager.shanghai);
            hide();
        }
    });
        paris.addListener(new ClickListener(Input.Buttons.LEFT)
        {
            public void clicked(InputEvent event, float x, float y)
            {
                //TODO Listener Functionality
                cityManager.changeCity(cityManager.paris);
                hide();
            }
        });
        newYork.addListener(new ClickListener(Input.Buttons.LEFT)
        {
            public void clicked(InputEvent event, float x, float y)
            {
                //TODO Listener Functionality
                cityManager.changeCity(cityManager.newYork);
                hide();
            }
        });
        mumbai.addListener(new ClickListener(Input.Buttons.LEFT)
        {
            public void clicked(InputEvent event, float x, float y)
            {
                //TODO Listener Functionality
                cityManager.changeCity(cityManager.mumbai);
                hide();
            }
        });
        cancel.addListener(new ClickListener(Input.Buttons.LEFT)
        {
            public void clicked(InputEvent event, float x, float y)
            {
                //TODO Listener Functionality
                hide();
            }
        });



    }


}
