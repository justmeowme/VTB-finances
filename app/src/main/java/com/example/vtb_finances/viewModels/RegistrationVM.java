package com.example.vtb_finances.viewModels;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.vtb_finances.model.Stock;
import com.example.vtb_finances.model.UserInfo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Collections;

public class RegistrationVM extends ViewModel {

    private final String TAG = "RegistrationVM";
    private MutableLiveData<Boolean> result = new MutableLiveData<Boolean>(false);
    private MutableLiveData<Boolean> isEmailError = new MutableLiveData<>(false);
    private MutableLiveData<Boolean> isPasswordError = new MutableLiveData<>(false);
    private MutableLiveData<Boolean> isName = new MutableLiveData<>(false);
    private FirebaseAuth mAuth;

    public LiveData<Boolean> getResult() {
        return result;
    }

    public void register(String name, String email, String password) {
        mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        createUserInfo(mAuth.getCurrentUser().getUid(), name, email);
                    } else {
                        Log.d("RegistrationVM", "failure", task.getException());
                        result.postValue(false);
                    }
                })

        ;
    }

    private void createUserInfo(String id, String name, String email) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("users")
                .add(new UserInfo(
                        id,
                        name,
                        1000,
                        1,
                        email,
                        18,
                        Collections.emptyList()
                ))
                .addOnSuccessListener(documentReference -> {
                    result.postValue(true);
                    Log.d(TAG, "");
                })
                .addOnFailureListener(ex -> {
                    Log.w(TAG, "Error adding document", ex);
                    result.postValue(false);
                })
        ;
    }
}