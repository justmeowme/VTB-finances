package com.example.vtb_finances.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vtb_finances.R;
import com.example.vtb_finances.databinding.ActivityLoginBinding;
import com.example.vtb_finances.viewModels.LoginVM;
import com.example.vtb_finances.viewModels.RegistrationVM;

public class LoginActivity extends AppCompatActivity {

    private LoginVM loginVM;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        loginVM = new ViewModelProvider(this).get(LoginVM.class);
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        bindView();
        bind();
    }

    private void bindView() {
        binding.enterButton.setOnClickListener(v ->
                loginVM.login(binding.email.getText().toString(), binding.password.getText().toString())
        );
        binding.registerButton.setOnClickListener(v -> {
                    Intent intent = new Intent(this, RegistrationActivity.class);
                    startActivity(intent);
                }
        );
    }

    private void bind() {
        loginVM.getIsAuth().observe(this, isAuth -> {
            if (isAuth) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        });
        loginVM.getIsInvalidData().observe(this, isInvalide -> {
            if (isInvalide) {
                Toast.makeText(this, "Неверный формат!", Toast.LENGTH_SHORT).show();
            }
        });
        loginVM.getIsErrorAuth().observe(this, isErrorAuth -> {
            if (isErrorAuth) {
                Toast.makeText(this, "Ошибка авторизации!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}