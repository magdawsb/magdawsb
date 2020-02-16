package com.karolinamaison.nazwa_aplikacji;


public class Water extends powers{

    Water(int a)
    {
        super(a,1,1.0f);
    }

    private void  cost()
    {
        int cost=getAmount()*15; //koszt=ilosc*10   1 10 20 30
        this.setPrice(cost);
    }


    void buy()
    {
        this.add();
        this.cost();
    }
}
