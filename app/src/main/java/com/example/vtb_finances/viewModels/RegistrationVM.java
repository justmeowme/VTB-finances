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

public class RegistrationVM extends ViewModel {

    private MutableLiveData<Boolean> result = new MutableLiveData<Boolean>(false);
    private FirebaseAuth mAuth;

    public LiveData<Boolean> getResult() {
        return result;
    }

    public void register(String email, String password) {
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        Log.d("RegistrationVM", "success");
                        result.postValue(true);
                    } else {
                        Log.d("RegistrationVM", "failure");
                        result.postValue(false);
                    }
                });
    }
}