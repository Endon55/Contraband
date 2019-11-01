package com.studio.contraband.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.utils.Json;
import com.studio.contraband.Contraband;
import com.studio.contraband.GameObjects;
import com.studio.contraband.Player;
import com.studio.contraband.ScreenManager;


public class TestbenchScreen extends ScreenManager
{

    Preferences pref;
    public TestbenchScreen(Contraband game)
    {
        super(game);
    }

    @Override
    public void show()
    {
        pref = Gdx.app.getPreferences("Preferences");
        Json json = new Json();
        GameObjects go = new GameObjects();
        go.itemName = "cocaine";
        go.basePrice = 100f;
        go.currentBuyablePrice = 100f;
        go.itemQuantitiy = 10;
        go.priceBoughtAt = 50f;
        json.addClassTag("GameObjects", GameObjects.class);
        String objectString = json.toJson(go, GameObjects.class);
        //System.out.println(json.toJson(go));
        System.out.println(json.prettyPrint(objectString));



        GameObjects go2 = json.fromJson(GameObjects.class, objectString);
        //System.out.println(gottenString);
        //GameObjects go = json.fromJson(GameObjects.class, gottenString);
        System.out.println(go.priceBoughtAt);





        //pref.putString("preferences", objectString);
        //pref.flush();

        String theArrayString = pref.getString("preferences");













    }


}
