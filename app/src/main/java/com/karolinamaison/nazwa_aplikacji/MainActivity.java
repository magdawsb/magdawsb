package com.karolinamaison.nazwa_aplikacji;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {


    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        sharedPreferences = getSharedPreferences("nameActivity", MODE_PRIVATE);

        Thread thread = new Thread(){
            public void run(){
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    //Toast.makeText(getApplicationContext(), sharedPreferences.getString("nameActivity","0"), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(".GameActivity");
                    startActivity(intent);
                }
            }
        };
        thread.start();




    }
}
