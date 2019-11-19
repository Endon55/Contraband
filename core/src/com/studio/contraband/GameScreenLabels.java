package com.studio.contraband;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.studio.contraband.Utils.Constants;
import com.studio.contraband.Utils.HelperFunctions;


public class GameScreenLabels
{
    private Stage stage;

    private Player player;

    private Table textTable;
    private VerticalGroup itemGroup;
    private VerticalGroup quantityGroup;
    private VerticalGroup priceGroup;


    private VerticalGroup clickableGroup;

    private MarketplaceDialog marketDialog;
    private Label money;
    private Label bagSpace;

    private Skin defaultSkin;
    private FreeTypeFontGenerator generator;
    private FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    private BitmapFont font;
    private Label.LabelStyle fontStyle;

    int screenWidth = Gdx.graphics.getWidth();

    public GameScreenLabels(Player player, Stage stage, Skin skin)
    {
        defaultSkin = skin;
        this.stage = stage;
        this.player = player;

        textTable = new Table();
        itemGroup = new VerticalGroup();
        quantityGroup = new VerticalGroup();
        priceGroup = new VerticalGroup();
        clickableGroup = new VerticalGroup();

        generator = new FreeTypeFontGenerator(Gdx.files.internal("SulphurPoint-Bold.otf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = Constants.DEFAULT_GAME_TEXT_SIZE;//(int)HelperFunctions.resizeText(screenWidth, 50f, 1080);
        font = generator.generateFont(parameter);
        generator.dispose();
        fontStyle = new Label.LabelStyle(font, Color.BLACK);
        debugFormatting(true);
    }

    public Stack assembleGroups()
    {
        // Builds the Columns of item labels to be displayed
        /*  First issue was that if the item text such as "Weed" doesnt take up much width so the actualy clickable label was only
        about 4 letters wide and the goal was full width. So i had to overlay each row with a custom actor but the biggest issue with
        that was estimating the height of each item row. Basically i couldnt find a way to calculate or guess the height that would work
        on different resolutions. Because the actor seemed to actually be sized to fit i couldnt just let the formatting stretch it itself.
        Eventually I found getPrefHeight which returns a usable number which you divide by the number of items and that's the actors height.  */

        int itemListLength = player.getNumberOfItems();

        //Formatting
        itemGroup.columnAlign(Align.left);
        priceGroup.columnAlign(Align.right);

        //Creates the 3 labels for each item/row and adds each one to a separate group.
        for(int i = 0; i < itemListLength; i++)
        {
            player.getGameItems().get(i).setItemNameLabel(new Label(player.getGameItems().get(i).getItemName(), fontStyle));
            player.getGameItems().get(i).setBasePricelabel(new Label("$" + HelperFunctions.getPrettyIntString(player.getGameItems().get(i).getBasePrice()), fontStyle));
            player.getGameItems().get(i).setNumberOwnedLabel(new Label(Integer.toString(player.getGameItems().get(i).getNumberOwned()), fontStyle));
            itemGroup.addActor(player.getGameItems().get(i).getItemNameLabel());
            priceGroup.addActor(player.getGameItems().get(i).getBasePricelabel());
            quantityGroup.addActor(player.getGameItems().get(i).getNumberOwnedLabel());
        }
        //Padding Between Rows
        quantityGroup.space(Constants.VERTICAL_PADDING);
        itemGroup    .space(Constants.VERTICAL_PADDING);
        priceGroup   .space(Constants.VERTICAL_PADDING);

        //Expand and Fill cause the table to expand all the way to the sides of the screen.
        textTable.add(quantityGroup).expandX().fillX().padLeft(screenWidth * Constants.QUANTITY_LEFT_PAD_SIZE);
        textTable.add(itemGroup)    .expandX().fillX().padLeft(screenWidth * Constants.NAME_LEFT_SIZE_PAD);
        textTable.add(priceGroup)   .expandX().fillX().padLeft(screenWidth * Constants.PRICE_LEFT_SIZE_PAD);

        //Gets the "height" of the above groups
        float height = textTable.getPrefHeight();
        //Creates a separate group for the clickable actors that span the whole width.
        for(int i = 0; i < itemListLength; i++)
        {
            Actor clickActor = new Actor();
            clickActor.addListener(itemClickImplementation(i));

            clickActor.setSize(Gdx.graphics.getWidth(), height / itemListLength);
            clickActor.setColor(Color.TAN);
            clickableGroup.addActor(clickActor);
        }
        //Adds the above group to its own table, to be overlaid onto the textTable
        return new Stack(textTable, clickableGroup);
    }


    private void debugFormatting(boolean debug)
    {
        if(debug)
        {
            textTable.debug();
            itemGroup.debug();
            quantityGroup.debug();
            priceGroup.debug();
            clickableGroup.debug();
        }
    }
    private ClickListener itemClickImplementation(final int itemIndex)
    {
        ClickListener listener = new ClickListener(Input.Buttons.LEFT)
        {
            public void clicked(InputEvent event, float x, float y)
            {
                //TODO Listener Functionality
                System.out.println("Clicked: " + player.getGameItems().get(itemIndex).getItemName());
                //marketDialog = new MarketplaceDialog("", defaultSkin, font, player, itemIndex);
                //marketDialog.show(stage);
            }
        };
        return listener;
    }

    public VerticalGroup getItemGroup()
    {
        return itemGroup;
    }

    public VerticalGroup getQuantityGroup()
    {
        return quantityGroup;
    }

    public VerticalGroup getPriceGroup()
    {
        return priceGroup;
    }

    public VerticalGroup getClickableGroup()
    {
        return clickableGroup;
    }



}
