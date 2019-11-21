package com.studio.contraband.Utils;

import java.util.ArrayList;
import java.util.Arrays;

public class Constants
{
    public static final int SCREEN_WIDTH = 1080;
    public static final int SCREEN_HEIGHT = 1920;

    public static final int STARTING_SPACE = 100;
    public static final int STARTING_MONEY = 10000;

    public static final int DEFAULT_GAME_TEXT_SIZE = 52;

    public static final float TOTAL_OWNED_PADDING = .338F;
    public static final float QUANTITY_OWNED_WIDTH = .06f;
    public static final float QUANTITY_LEFT_PAD_SIZE = .15F;

    public static final float NAME_WIDTH = .45F;
    public static final float NAME_LEFT_SIZE_PAD = .01F;

    public static final float PRICE_WIDTH = .45F;
    public static final float PRICE_LEFT_SIZE_PAD = .00F;
    public static final float PRICE_RIGHT_SIZE_PAD = .00F;

    public static final int VERTICAL_PADDING = 5;

    public static final ArrayList<RawItemStruct> ITEM_LIST = new ArrayList<RawItemStruct>(Arrays.asList(
            //new RawItemStruct("Anti-Air", 2000000,1, true),
            //new RawItemStruct("Apache Helicopter", 61000000,1, true),
            new RawItemStruct("Assault Rifle", 1500, 1,true),
            new RawItemStruct("Cocaine", 850, 1,false),
            //new RawItemStruct("F18", 55000000, 1,true),
            new RawItemStruct("Handgun", 750, 1,true),
            new RawItemStruct("Heroin", 350, 1,false),
            //new RawItemStruct("M1-Abrams", 6200000,1, true),
            new RawItemStruct("MDMA", 300, 1,false),
            new RawItemStruct("Meth", 550, 1,false),
            new RawItemStruct("Moonshine", 95, 1,false),
            new RawItemStruct("Mushrooms", 200, 1,false),
            new RawItemStruct("Peyote", 150, 1,false),
            new RawItemStruct("Plastic Explosive", 450, 1,true),
            new RawItemStruct("Speed", 120, 1,false),
            new RawItemStruct("Weed", 75, 1,false)

    ));




}
