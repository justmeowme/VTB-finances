package com.example.vtb_finances.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.vtb_finances.R;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        ImageView mStart = findViewById(R.id.button_start);
        mStart.setOnClickListener(v ->
                startActivity(new Intent(StartActivity.this, LoginActivity.class))
        );
    }
}