package com.example.vtb_finances.viewModels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.vtb_finances.model.AuthState;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.rpc.context.AttributeContext;

public class SplashVM extends ViewModel {
    private MutableLiveData<AuthState> state = new MutableLiveData<>(AuthState.Empty);
    private FirebaseAuth mAuth;

    public LiveData<AuthState> getState() {
        return state;
    }

    public void checkAuth() {
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        Log.d("SplashVm", "isAuth : " + (currentUser != null));
        if (currentUser != null) {
            state.postValue(AuthState.Auth);
        } else {
            state.postValue(AuthState.NotAuth);
        }
    }
}