package com.studio.contraband.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.studio.contraband.*;
import com.studio.contraband.Dialogs.ChangeCityDialog;
import com.studio.contraband.Dialogs.MarketplaceDialog;
import com.studio.contraband.Utils.Constants;
import com.studio.contraband.Utils.HelperFunctions;
import com.studio.contraband.Utils.PreferencesAccess;


/**
 UI Elements
 Cash, Debt, Location
 Buy greys out if not enough money
 Sell greys out if none to sell
 */


public class GameScreen extends ScreenManager
{
    PreferencesAccess preferences;
    Player player;
    CityManager cityManager;

    FreeTypeFontGenerator generator;
    FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    BitmapFont font;
    Label.LabelStyle fontStyle;
    Skin defaultSkin;

    Table clickableTable;
    Table textTable;
    Table top;
    Table bottom;
    VerticalGroup itemGroup;
    VerticalGroup quantityGroup;
    VerticalGroup priceGroup;
    VerticalGroup clickableGroup;

    HorizontalGroup totalOwnedGroup;
    MarketplaceDialog marketDialog;
    ChangeCityDialog changeCityDialog;

    Button changeCityButton;

    Boolean debug = false;

    public GameScreen(Contraband game)
    {
        super(game);
    }

    @Override
    public void show()
    {
        Gdx.input.setInputProcessor(stage);

        init();

        table.setBackground(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("BasicBackground.png")))));
        table.align(Align.center);
        bottom.align(Align.topLeft);

        top.add(cityManager.getCurrentCityLabel());
        top.row();
        top.add(player.getMoneyLabel());
        table.add(top).expand().fill();
        table.row();
        assembleGroups();
        table.row();
        table.add(bottom).expand().fill();
        bottom.add(totalOwnedGroup).expandX();
        totalOwnedGroup.addActor(player.getUsedSpaceLabel());
        totalOwnedGroup.addActor(player.getMaxSpaceLabel());
        bottom.row();

        bottom.add(changeCityButton).expandX();

        System.out.println(Constants.ITEM_LIST.get(0).Name);
    }

    private ClickListener itemClickImplimentation(final int itemIndex)
    {
        ClickListener listener = new ClickListener(Input.Buttons.LEFT)
        {
            public void clicked(InputEvent event, float x, float y)
            {
                //TODO Listener Functionality
                System.out.println("Clicked: " + player.getGameItems().get(itemIndex).getItemName());
                marketDialog = new MarketplaceDialog("", defaultSkin, font, fontStyle, player, itemIndex);
                marketDialog.show(stage);
            }
        };
        return listener;
    }

    private void assembleGroups()
    {
        // Builds the Columns of item labels to be displayed
        /*  First issue was that if the item text such as "Weed" doesn't take up much width so the actually clickable label was only
        about 4 letters wide and the goal was full width. So i had to overlay each row with a custom actor but the biggest issue with
        that was estimating the height of each item row. Basically i couldn't find a way to calculate or guess the height that would work
        on different resolutions. Because the actor seemed to actually be sized to fit i could'nt just let the formatting stretch it itself.
        Eventually I found getPrefHeight which returns a usable number which you divide by the number of items and that's the actors height.  */

        int itemListLength = player.getNumberOfItems();

        //Formatting
        itemGroup.columnAlign(Align.left);
        priceGroup.columnAlign(Align.right);

        //Creates the 3 labels for each item/row and adds each one to a separate group.
        for(int i = 0; i < itemListLength; i++)
        {
            itemGroup.addActor(player.getGameItems().get(i).getItemNameLabel());
            //priceGroup.addActor(player.getGameItems().get(i).getBasePricelabel());
            priceGroup.addActor(cityManager.getPriceLabels().get(i));
            quantityGroup.addActor(player.getGameItems().get(i).getNumberOwnedLabel());
        }
        //Padding Between Rows
        quantityGroup.space(Constants.VERTICAL_PADDING);
        itemGroup    .space(Constants.VERTICAL_PADDING);
        priceGroup   .space(Constants.VERTICAL_PADDING);
        //Expand and Fill cause the table to expand all the way to the sides of the screen.
        textTable.add(quantityGroup).expandX().expandX().fillX().minWidth(stage.getViewport().getWorldWidth() * Constants.QUANTITY_OWNED_WIDTH).padLeft(stage.getViewport().getWorldWidth() * Constants.QUANTITY_LEFT_PAD_SIZE);
        textTable.add(itemGroup)    .expandX().fillX().padLeft(stage.getViewport().getWorldWidth() * Constants.NAME_LEFT_SIZE_PAD);
        textTable.add(priceGroup)   .expandX().fillX().minWidth(stage.getViewport().getWorldWidth() * Constants.PRICE_WIDTH);

        //Gets the "height" of the above groups
        float height = textTable.getPrefHeight();
        //Creates a separate group for the clickable actors that span the whole width.
        for(int i = 0; i < itemListLength; i++)
        {
            Actor clickActor = new Actor();
            clickActor.addListener(itemClickImplimentation(i));

            clickActor.setSize(stage.getViewport().getWorldWidth(), height / itemListLength);
            clickableGroup.addActor(clickActor);
        }
        //Adds the above group to its own table, to be overlaid onto the textTable
        clickableTable.add(clickableGroup).setActorWidth(textTable.getPrefWidth());
        table.add(new Stack(textTable, clickableTable));
    }

    private void init()
    {
        preferences = new PreferencesAccess();

        defaultSkin = new Skin(Gdx.files.internal("DefaultSkin/uiskin.json"));
        generator = new FreeTypeFontGenerator(Gdx.files.internal("SulphurPoint-Bold.otf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = Constants.DEFAULT_GAME_TEXT_SIZE;
        parameter.minFilter = Texture.TextureFilter.Linear;
        font = generator.generateFont(parameter);
        generator.dispose();
        fontStyle = new Label.LabelStyle(font, Color.BLACK);

        player = new Player();
        player.init(Constants.STARTING_MONEY, Constants.STARTING_SPACE, fontStyle);
        cityManager = new CityManager();
        cityManager.init(fontStyle);

        top = new Table();
        bottom = new Table();
        textTable = new Table();
        clickableTable = new Table();
        clickableTable.setDebug(true);
        itemGroup = new VerticalGroup();
        quantityGroup = new VerticalGroup();
        priceGroup = new VerticalGroup();
        clickableGroup = new VerticalGroup();
        totalOwnedGroup = new HorizontalGroup();
        clickableGroup.setDebug(true);

        changeCityButton = HelperFunctions.createCustomButton("Change City", font, "ButtonUp3.png", "ButtonDown3.png");
        changeCityButton.addListener(new ClickListener(Input.Buttons.LEFT)
        {
            public void clicked(InputEvent event, float x, float y)
            {
                //TODO Listener Functionality
                changeCityDialog = new ChangeCityDialog("", defaultSkin, font, cityManager);
                changeCityDialog.show(stage);
            }
        });
        debug();
    }
    private void debug()
    {
        //quantityGroup.setDebug(debug);
        //itemGroup.setDebug(debug);
        //priceGroup.setDebug(debug);
        //table.setDebug(debug);
        //clickableTable.setDebug(debug);
        bottom.debug();
        top.debug();
        textTable.setDebug(debug);
    }
}