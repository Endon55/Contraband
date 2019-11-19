package com.studio.contraband.Depricated;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.studio.contraband.*;
import com.studio.contraband.GameScreenLabels;
import com.studio.contraband.Utils.Constants;
import com.studio.contraband.Utils.PreferencesAccess;


/**
    UI Elements
    Cash, Debt, Location

 Buy greys out if not enough money
 Sell greys out if none to sell

 */


public class GameScreen2 extends ScreenManager
{
    int screenWidth = Gdx.graphics.getWidth();
    int screenHeight = Gdx.graphics.getHeight();


    //List items;

    PreferencesAccess preferences;
    Player player;
    com.studio.contraband.GameScreenLabels screenLabels;


    Skin defaultSkin;


    MarketplaceDialog marketDialog;
    Label money;
    Label bagSpace;

    public GameScreen2(Contraband game)
    {
        super(game);
        Gdx.input.setInputProcessor(stage);


        //table.row();
        //table.add(bagSpace);
        //table.row();
        //table.add(money);


    }

    @Override
    public void show()
    {

        Gdx.input.setInputProcessor(stage);
        defaultSkin = new Skin(Gdx.files.internal("DefaultSkin/uiskin.json"));

        player = new Player();
        preferences = new PreferencesAccess();
        screenLabels = new GameScreenLabels(player, stage, defaultSkin);
        //player.init(Constants.STARTING_MONEY, Constants.STARTING_SPACE, fontStyle);

        bagSpace = new Label(player.getUsedSpace() + "/" + player.getMaxSpace(), defaultSkin);
        money = new Label("$" + (int)player.getMoney(), defaultSkin);

        table.setBackground(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("BasicBackground.png")))));
        table.align(Align.left);
        table.add(screenLabels.assembleGroups());
    }

}
