package com.studio.contraband.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Timer;
import com.studio.contraband.Contraband;
import com.studio.contraband.GameItems;
import com.studio.contraband.ScreenManager;
import com.studio.contraband.Utils.HelperFunctions;


public class TestbenchScreen extends ScreenManager
{
    FreeTypeFontGenerator generator;
    FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    BitmapFont font;
    Label.LabelStyle fontStyle;

    Dialog endDialog;


    Preferences pref;
    public TestbenchScreen(Contraband game)
    {
        super(game);
    }

    @Override
    public void show()
    {

        Gdx.input.setInputProcessor(stage);
        generator = new FreeTypeFontGenerator(Gdx.files.internal("SulphurPoint-Bold.OTF"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 50; //(int) HelperFunctions.resizeText(Gdx.graphics.getWidth(), 50f, 1080);
        font = generator.generateFont(parameter);
        generator.dispose();

        fontStyle = new Label.LabelStyle(font, Color.BLACK);



    endDialog = new Dialog("End Game", skin)
    {
        protected void result(Object object)
        {
            System.out.println("Option: " + object);
            Timer.schedule(new Timer.Task()
            {
                @Override
                public void run()
                {
                    endDialog.show(stage);
                }
            }, 1);
        };
    };

    endDialog.button("B1", 1l);
    endDialog.button("B2", 2l);

        Timer.schedule(new Timer.Task()
        {
            @Override
            public void run()
            {
                endDialog.show(stage);
            }
        }, 1);










        pref = Gdx.app.getPreferences("Preferences");
        Json json = new Json();
        //GameItems go = new GameItems();
        //go.itemName = "cocaine";
        //go.basePrice = 100f;
        //go.currentBuyablePrice = 100f;
        //go.itemQuantitiy = 10;
        //go.purchasePrice = 50f;
        json.addClassTag("GameObjects", GameItems.class);
        //String objectString = json.toJson(go, GameItems.class);
        //System.out.println(json.toJson(go));
        //System.out.println(json.prettyPrint(objectString));



        //GameItems go2 = json.fromJson(GameItems.class, objectString);
        //System.out.println(gottenString);
        //GameObjects go = json.fromJson(GameObjects.class, gottenString);
        //System.out.println(go.purchasePrice);





        //pref.putString("preferences", objectString);
        //pref.flush();

        String theArrayString = pref.getString("preferences");













    }


}
