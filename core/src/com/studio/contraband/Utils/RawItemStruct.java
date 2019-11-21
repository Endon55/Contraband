package com.studio.contraband.Utils;

public class RawItemStruct
{
    public String Name = "";
    public int BasePrice = 0;
    public boolean Weapon = false;
    public float Variance = 1;
    public RawItemStruct(String Name, int BasePrice, float Variance, boolean Weapon)
    {
        this.Name = Name;
        this.BasePrice = BasePrice;
        this.Variance = Variance;
        this.Weapon = Weapon;
    }
}
