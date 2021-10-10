package com.example.vtb_finances.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.vtb_finances.R;
import com.example.vtb_finances.viewModels.LoginVM;
import com.example.vtb_finances.viewModels.RegistrationVM;
import com.google.android.material.textfield.TextInputEditText;

public class RegistrationActivity extends AppCompatActivity {

    private final String TAG = "RegistrationActivity";
    private RegistrationVM registrationVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        registrationVM = new ViewModelProvider(this).get(RegistrationVM.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Button btn = findViewById(R.id.act_registration_send);

        EditText name = findViewById(R.id.act_registration_name_et);
        EditText password = findViewById(R.id.act_registration_password_et);
        EditText mail = findViewById(R.id.act_registration_mail_et);
        bind();
        btn.setOnClickListener(v -> {
            Log.d(
                    TAG,
                    String.format("name : %s, password : %s", name.getText().toString(), password.getText().toString()));
            registrationVM.register(
                    name.getText().toString(),
                    mail.getText().toString(),
                    password.getText().toString()
            );
        });
    }

    private void bind() {
        registrationVM.getResult().observe(this, result -> {
            if (result) {
                startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
            }
        });
    }
}