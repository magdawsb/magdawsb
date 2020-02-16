package com.karolinamaison.nazwa_aplikacji;

import java.util.AbstractCollection;

/**
 * Created by Karolina on 30.07.2017.
 */

public class powers {
    private int amount;
    private int price;
    private final float combo; //nie mozna zmieniac

    powers(int a,int p, float c)
    {
        amount=a;
        price=p;
        combo=c;
    }
    /*void setAmount(int a)
    {
        amount=a;
    }*/
    void setPrice(int p)
    {
        price=p;
    }
    int getAmount()
    {
        return amount;
    }
    int getPrice()
    {
        return price;
    }
    float getCombo()
    {
        return combo;
    }
    void add()
    {
        amount+=1;
    }
}
