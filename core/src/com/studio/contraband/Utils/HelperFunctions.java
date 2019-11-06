package com.studio.contraband.Utils;

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
}
