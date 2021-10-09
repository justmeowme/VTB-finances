package com.example.vtb_finances.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.vtb_finances.R;
import com.example.vtb_finances.model.AuthState;
import com.example.vtb_finances.viewModels.SplashVM;

public class SplashActivity extends AppCompatActivity {

    private SplashVM splashVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        splashVM = new ViewModelProvider(this).get(SplashVM.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        bind();
        // штучка которая делает первое окошечко на 1.2 секунды
        int milliseconds_delayed = 1200;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                splashVM.checkAuth();
            }
        }, milliseconds_delayed);
    }

    private void bind() {
        splashVM.getState().observe(this, state -> {
            if (state == AuthState.Auth) {
                startActivity(
                        new Intent(
                                SplashActivity.this,
                                MainActivity.class
                        ));
            } else if (state == AuthState.NotAuth && MainActivity.getDefaults("visited", SplashActivity.this) == null) {
                startActivity(
                        new Intent(
                                SplashActivity.this,
                                StartActivity.class
                        )
                );
            } else if (state == AuthState.NotAuth) {
                startActivity(
                        new Intent(
                                SplashActivity.this,
                                MainActivity.class
                        ));
            }
            else {
                return;
            }
            finish();
        });
    }
}