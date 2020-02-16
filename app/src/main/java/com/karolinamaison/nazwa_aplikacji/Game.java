package com.karolinamaison.nazwa_aplikacji;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

/**
 * Created by Karolina on 30.07.2017.
 */

public class Game implements Runnable{

    ImageButton image;
    Animation shake;
    Context context;
    Game(Context c)
    {
        context=c;
        //image=GameActivity.image;
       // shake=GameActivity.shake;
        run();
    }
    public void run() {
            while(true) {
                image.startAnimation(shake);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
}
