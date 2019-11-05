package com.studio.contraband.Utils;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

public class HelperFunctions
{


    public static int[] getEmptyIntArray()
    {
        int length = Constants.ITEMS_LIST.length;
        int[] array = new int[length];

        Arrays.fill(array, 0);

        return array;
    }

    public static float[] getEmptyFloatArray()
    {
        int length = Constants.ITEMS_LIST.length;
        float[] array = new float[length];

        Arrays.fill(array, 0);

        return array;
    }


    public static String getPrettyIntString(int number)
    {
        //Takes an integer and formats it with commas
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        String prettyString = formatter.format(number);
        return prettyString;
    }

}
