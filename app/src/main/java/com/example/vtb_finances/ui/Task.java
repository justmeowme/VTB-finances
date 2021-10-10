package com.example.vtb_finances.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vtb_finances.R;
import com.example.vtb_finances.ui.MainActivity;

public class Task extends AppCompatActivity {

    int task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);

        task = 1;
        TextView text = findViewById(R.id.text);
        ImageView image = findViewById(R.id.imageView);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (task==1){
                    image.setImageResource(R.drawable.ic_g2);
                }
                if (task==2){
                    image.setImageResource(R.drawable.ic_g3);
                    button.setText("Круто!");
                }
                if (task==3){
                    text.setText("Тема 2");
                    image.setImageResource(R.drawable.ic_g21);
                    button.setText("Далее");
                }
                if (task==4){
                    image.setImageResource(R.drawable.ic_g22);
                }
                if (task==5){
                    image.setImageResource(R.drawable.ic_g23);
                }
                if (task==6){
                    image.setImageResource(R.drawable.ic_g24);
                    button.setText("Завершить");
                }
                if (task==7){
                    startActivity(new Intent(Task.this, MainActivity.class));
                }
                task += 1;
            }
        });
    }
}