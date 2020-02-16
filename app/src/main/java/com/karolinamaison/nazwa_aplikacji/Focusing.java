package com.karolinamaison.nazwa_aplikacji;

/**
 * Created by Karolina on 31.07.2017.
 */

public class Focusing extends powers{
    Focusing(int a)
    {
        super(a,1,0.2f);
    }

    private void  cost()
    {
        int cost=getAmount()*10; //koszt=ilosc*10   1 10 20 30
        this.setPrice(cost);
    }


    void buy()
    {
        this.cost();
        this.add();
    }
}
