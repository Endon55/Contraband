package com.studio.contraband.Utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class PreferencesAccess
{
    /*
    Load the preferences file
    Read each individual variable
    Generate game state

    Save game state

    Data to save
    Item Name, Amount Owned, Price Bought At

    Player Data
    Day or Turn, Current Money, Debt, Current City

    City Data
    Prices of all items for each city.

     */


    Preferences gameData;


    public PreferencesAccess()
    {

    }

    public boolean isGameInProgress()
    {
        return gameData.getBoolean("GameInProgress");
    }

    private void openPreferencesFile(String fileName)
    {
        gameData = Gdx.app.getPreferences(fileName);
    }

    private void saveGameData()
    {

    }

    private void loadGameData()
    {
        /*
            Pass it the player, city and item objects, instantiate those objects with the data read.
         */



    }


}
