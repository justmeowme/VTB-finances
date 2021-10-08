package com.example.vtb_finances;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //штучка которая делает первое окошечко на 1.2 секунды
        int milliseconds_delayed = 1200;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (MainActivity.getDefaults("visited", SplashActivity.this)==null){
                    startActivity(new Intent(SplashActivity.this, StartActivity.class));
                } else{
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                }
                finish();
            }
        }, milliseconds_delayed);

    }
}