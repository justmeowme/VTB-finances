package com.example.vtb_finances.viewModels;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginVM extends ViewModel {

    private final String TAG = "LoginVM";
    private MutableLiveData<Boolean> isAuth = new MutableLiveData<>(false);
    private MutableLiveData<Boolean> isErrorAuth = new MutableLiveData<>(false);
    private FirebaseAuth mAuth;

    public LiveData<Boolean> getIsAuth() {
        return isAuth;
    }

    public void login(String mail, String password) {
        mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(mail, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Log.d(TAG, "signInWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        isAuth.postValue(true);
                    } else {
                        Log.w(TAG, "signInWithEmail:failure", task.getException());
                        isAuth.postValue(false);
                        isErrorAuth.postValue(true);
                    }
                });
    }
}