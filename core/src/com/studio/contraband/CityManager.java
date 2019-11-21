package com.studio.contraband;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.studio.contraband.Utils.Constants;
import com.studio.contraband.Utils.HelperFunctions;
import com.studio.contraband.Utils.RawItemStruct;

import java.util.ArrayList;

public class CityManager
{
    private Cities currentCity;
    private int[] startingPrices;

    public Cities tokyo;
    public Cities istanbul;
    public Cities shanghai;
    public Cities paris;
    public Cities newYork;
    public Cities mumbai;

    private Label currentCityLabel;


    private ArrayList<Label> priceLabels;
    private Label.LabelStyle fontStyle;
    private int currentCityIndex;


    public CityManager() { }

    public void init( Label.LabelStyle fontStyle)
    {
        this.fontStyle = fontStyle;
        getStartingPrices();
        currentCityIndex = 0;
        buildCitiesList();
        currentCity = tokyo;
        currentCityLabel = new Label(currentCity.getName(), fontStyle);
        buildPriceLabels();
    }
    private void buildCitiesList()
    {
        tokyo    = new Cities("Tokyo",startingPrices);
        istanbul = new Cities("Istanbul",startingPrices);
        shanghai = new Cities("Shanghai",startingPrices);
        paris    = new Cities("Paris",startingPrices);
        newYork  = new Cities("New York",startingPrices);
        mumbai   = new Cities("Mumbai",startingPrices);
    }

    private void buildPriceLabels()
    {
        priceLabels = new ArrayList<Label>();
        for (int city: currentCity.getPrices())
        {
            priceLabels.add(new Label("$" + HelperFunctions.getPrettyIntString(city),fontStyle));
        }
    }

    public void changeCity(Cities newCity)
    {
        currentCity = newCity;
        currentCityLabel.setText(currentCity.getName());
        updatePriceLabels();
    }

    private void getStartingPrices()
    {
        startingPrices = new int[Constants.ITEM_LIST.size()];
        int counter = 0;
        for(RawItemStruct item: Constants.ITEM_LIST)
        {
            startingPrices[counter++] = item.BasePrice;
        }
    }
    private void updatePriceLabels()
    {
        int counter = 0;
        int[] newPrices = currentCity.getPrices();
        for (Label label: priceLabels)
        {
            label.setText("$" + HelperFunctions.getPrettyIntString(newPrices[counter++]));
        }
    }


    public Cities getCurrentCity()
    {
        return currentCity;
    }
    public Label getCurrentCityLabel()
    {
        return currentCityLabel;
    }
    public ArrayList<Label> getPriceLabels()
    {
        return priceLabels;
    }


}
