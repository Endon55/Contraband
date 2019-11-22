package com.studio.contraband;

import com.studio.contraband.Utils.Constants;

import java.util.Random;

public class Cities
{
    private String name;
    private int[] pricesBase;
    private int[] prices;
    Random rand;


    public Cities(String name, int[] prices, Random rand)
    {
        this.pricesBase = prices;
        this.prices = new int[prices.length];
        System.arraycopy(this.pricesBase, 0, this.prices, 0, prices.length);
        this.name = name;
        this.rand = rand;
    }

    public void updatePrices()
    {
        for (int i = 0; i < prices.length; i++)
        {
            int randNum = rand.nextInt(20) + 1;

            if(randNum >= Constants.LOWER_BOUND_AVG_VALUE && randNum <= Constants.UPPER_BOUND_AVG_VALUE)
            {
                //Avg
                prices[i] = calculatedPrice(pricesBase[i], .7f, 1.5f);
            }
            else if (randNum == Constants.LOW_VALUE)
            {
                //Low Low(20-39)
                prices[i] = calculatedPrice(pricesBase[i], .2f, .4f);
            }
            else if (randNum == Constants.LOW_VALUE + 1)
            {
                //Low High(40-69)
                prices[i] = calculatedPrice(pricesBase[i], .4f, .7f);
            }
            else if(randNum == Constants.HIGH_VALUE)
            {
                //High Low(150-229)
                prices[i] = calculatedPrice(pricesBase[i], 1.5f, 2.3f);
            }
            else if(randNum == Constants.HIGH_VALUE +  1)
            {
                //High High(230-300)
                prices[i] = calculatedPrice(pricesBase[i], 2.3f, 3f);
            }
        }
    }

    private int calculatedPrice(int basePrice, float lowerBound, float upperBound)
    {
        int priceUpperBound = (int)(basePrice * upperBound);
        int priceLowerBound = (int)(basePrice * lowerBound);
        int difference = priceUpperBound - priceLowerBound;
        return rand.nextInt(difference) + priceLowerBound + 1;
    }

    public String getName()
    {
        return name;
    }
    public int[] getPrices()
    {
        return prices;
    }
    public int getPrice(int index)
    {
        return prices[index];
    }
}
