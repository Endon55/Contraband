package com.studio.contraband.Utils;

import java.util.Arrays;

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

}
