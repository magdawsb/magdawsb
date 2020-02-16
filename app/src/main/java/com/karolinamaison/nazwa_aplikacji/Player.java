package com.karolinamaison.nazwa_aplikacji;

/**
 * Created by Karolina on 29.07.2017.
 */

public class Player {
    private int combo_click;
    private float combo_sec,score;
    Water water=new Water(1);
    Focusing focusing=new Focusing(1);
    Player(float HS,float sec,int click)
    {
        score=HS;
        combo_sec=0.1f;
        combo_click=1;
        water=new Water(0);
    }
    float getScore()
    {
        return score;
    }

    float getCombo_sec()
    {
        return combo_sec;
    }
    int getCombo_click()
    {
        return combo_click;
    }

    void setCombo_sec(float a)
    {
        combo_sec+=a;
    }
    void pay(int a)
    {
        score-=a;
    }
    void second()
    {
        score+=combo_sec;
    }

    void click()
    {
        score+=combo_click;
    }

    Boolean can_buy(int k)
    {
        if(score>k)
            return true;
        else return false;
    }
    Boolean buy(String name,int type)
    {
        if(type==1) //sec
        {
            switch (name)
            {
                case "focus": {
                    if(can_buy(focusing.getPrice())) {
                        pay(focusing.getPrice());
                        focusing.buy();
                        combo_sec+=focusing.getCombo();
                        return true;
                    }
                }
                default: return false;
            }
        }
        else
        {
            switch (name) //click
            {
                case "water": {
                    if(can_buy(water.getPrice())) {
                        pay(water.getPrice());
                        water.buy();
                        combo_click+=water.getCombo();
                        return true;
                    }
                }
                default: return false;
            }
        }
    }

}
