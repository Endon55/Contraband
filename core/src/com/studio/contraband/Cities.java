package com.studio.contraband;

public class Cities
{
    private String name;
    private int[] prices;

    public Cities(String name, int[] prices)
    {
        this.name = name;
        this.prices = prices;
    }

    public void updatePrices()
    {

    }

    public String getName()
    {
        return name;
    }
    public int[] getPrices()
    {
        return prices;
    }
}
