package com.studio.contraband.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.utils.Json;
import com.studio.contraband.Contraband;
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
        int[] ints = {1 , 2, 3, 4};
        System.out.println(ints);
        pref = Gdx.app.getPreferences("Preferences");

        Json json = new Json();

        System.out.println((pref.getString("preferences")));

        //int[][] builtArray = json.fromJson(int[][].class, pref.getString("preferences"));

        String theArrayString = pref.getString("preferences");

        System.out.println(theArrayString);
        int[] ints2 = json.fromJson(int[].class, theArrayString);
        System.out.println(ints2[2]);
        //System.out.println(ints2);


        //int[] ints = {1 , 2, 3, 4};          //, {1 , 2, 3, 4}, {1 , 2, 3, 4}, {1 , 2, 3, 4}, {1 , 2, 3, 4}};
        //String str = json.toJson(ints);
        //pref.putString("preferences", str);
       // pref.flush();


        //Player player1 = new Player(100f, 00, 10);











    }


}
