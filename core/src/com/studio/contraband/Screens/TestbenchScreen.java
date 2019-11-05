package com.studio.contraband.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.utils.Json;
import com.studio.contraband.Contraband;
import com.studio.contraband.GameItems;
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
        GameItems go = new GameItems();
        //go.itemName = "cocaine";
        //go.basePrice = 100f;
        //go.currentBuyablePrice = 100f;
        //go.itemQuantitiy = 10;
        //go.purchasePrice = 50f;
        json.addClassTag("GameObjects", GameItems.class);
        String objectString = json.toJson(go, GameItems.class);
        //System.out.println(json.toJson(go));
        System.out.println(json.prettyPrint(objectString));



        GameItems go2 = json.fromJson(GameItems.class, objectString);
        //System.out.println(gottenString);
        //GameObjects go = json.fromJson(GameObjects.class, gottenString);
        //System.out.println(go.purchasePrice);





        //pref.putString("preferences", objectString);
        //pref.flush();

        String theArrayString = pref.getString("preferences");













    }


}
