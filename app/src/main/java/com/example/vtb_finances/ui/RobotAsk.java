package com.example.vtb_finances.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.vtb_finances.R;

public class RobotAsk extends AppCompatActivity {

    String isActive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robot_ask);

        ImageView mMale = findViewById(R.id.button_male);
        ImageView mFemale = findViewById(R.id.button_female);

        isActive = "none";

        mFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isActive == "none" || isActive == "male") {
                    mMale.setImageResource(R.drawable.ic_malebutton);
                    mFemale.setImageResource(R.drawable.ic_femalebuttonactive);
                    isActive = "female";
                } else {
                    mFemale.setImageResource(R.drawable.ic_femalebutton);
                    isActive = "none";
                }
            }
        });

        mMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isActive == "none" || isActive == "female") {
                    mMale.setImageResource(R.drawable.ic_malebuttonactive);
                    mFemale.setImageResource(R.drawable.ic_femalebutton);
                    isActive = "male";
                } else {
                    mMale.setImageResource(R.drawable.ic_malebutton);
                    isActive = "none";
                }
            }
        });
    }
}