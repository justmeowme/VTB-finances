package com.example.vtb_finances.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.vtb_finances.R;
import com.example.vtb_finances.viewModels.LoginVM;
import com.example.vtb_finances.viewModels.RegistrationVM;

public class LoginActivity extends AppCompatActivity {

    private LoginVM loginVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        loginVM = new ViewModelProvider(this).get(LoginVM.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    private void bind() {

    }

    public void clickLogin(View view) {
    }
}