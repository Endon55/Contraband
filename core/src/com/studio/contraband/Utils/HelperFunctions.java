package com.studio.contraband.Utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import java.text.NumberFormat;
import java.util.Locale;

public class HelperFunctions
{

    public static String getPrettyIntString(int number)
    {
        //Takes an integer and formats it with commas
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        String prettyString = formatter.format(number);
        return prettyString;
    }

    public static float resizeText(float newWidth, float defaultSize, float defaultWidth)
    {
        //Takes the new Width and scales the new font using the default size of screen width and fault
        float a = newWidth * defaultSize;
        float b = a / defaultWidth;
        return b;
    }

    public static TextButton createCustomButton(String buttonText, BitmapFont font, String buttonUpPath, String buttonDownPath)
    {

        TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
        buttonStyle.font = font;
        buttonStyle.up = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal(buttonUpPath))));
        buttonStyle.down = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal(buttonDownPath))));

        return new TextButton(buttonText, buttonStyle);
    }

}
