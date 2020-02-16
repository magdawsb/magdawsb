package com.karolinamaison.nazwa_aplikacji;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity{

    static ImageView image;
    static Animation shake;
    TextView tv_score,info;
    Button b_focusing,b_water;
    Player player;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getSupportActionBar().hide();
        tv_score=(TextView)findViewById(R.id.score);
        info=(TextView)findViewById(R.id.info);
        b_water=(Button) findViewById(R.id.b_water);
        b_focusing=(Button)findViewById(R.id.b_focusing);
        player=new Player(1,1,1);


        image = (ImageView) findViewById(R.id.tyson_image);
        shake = AnimationUtils.loadAnimation(this, R.anim.shake);

        info();
        tv_score.setText(""+player.getScore());

        image.setOnClickListener(new View.OnClickListener()     //  KLIKANIE
        {
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "klik", Toast.LENGTH_SHORT).show();
                image.startAnimation(shake);
                player.click();
                tv_score.setText(""+player.getScore());
                info();
            }
        });

        b_water.setOnClickListener(new View.OnClickListener()   // WODA
        {
            @Override
            public void onClick(View v){
                if(player.buy("water",0)) {
                    b_water.setText("WATER +1/click COST:" + player.water.getPrice());
                    info();
                }
            }
        });

        b_focusing.setOnClickListener(new View.OnClickListener()   // Skupinie
        {
            @Override
            public void onClick(View v){
                if(player.buy("focus",1)) {
                    b_focusing.setText("FOCUSING +0.2/sec COST:" + player.focusing.getPrice());
                    info();
                }
            }
        });

        handler = new Handler();
        final Runnable r = new Runnable() {    //CO SEKUNDE
            public void run() {
                player.second();
                tv_score.setText(""+player.getScore());
                handler.postDelayed(this, 1000);
            }
        };
        r.run();
    }

    void game()
    {
        image.startAnimation(shake);
    }
    void info(){
        info.setText("Per sec: " + player.getCombo_sec() + "\nPer click: "+player.getCombo_click());
    }
}


  /*  int score, combo_click;
    float combo_sec;
    SharedPreferences HS,combo;
    SharedPreferences.Editor editor_HS,editor_combo;

        HS = getSharedPreferences("highScore", Context.MODE_PRIVATE);
        editor_HS=HS.edit();
        combo= getSharedPreferences("combo", Context.MODE_PRIVATE);
        editor_combo=combo.edit();

                score=HS.getInt("highScore",0);
                combo_sec=combo.getFloat("combo",1);


                @Override
    public void onPause() {
        super.onPause();
        saveAction();
    }
    void saveAction()
    {
        editor_HS.putInt("highScore",score);
        editor_HS.commit();
    }

                */
