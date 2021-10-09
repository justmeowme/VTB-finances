package com.example.vtb_finances.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.vtb_finances.R;

public class Robot extends AppCompatActivity {

    int flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robot);

        flag = 0;

        ImageView mImage = findViewById(R.id.imageView);
        Button mButton = findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag==0){
                    mButton.setText("Попробуем");
                    mImage.setImageResource(R.drawable.ic_robot2);
                    flag = 1;
                } else{
                    startActivity(new Intent(Robot.this, RobotAsk.class));
                }
            }
        });
    }
}