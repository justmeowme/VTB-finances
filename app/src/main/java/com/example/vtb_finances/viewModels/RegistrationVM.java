package com.example.vtb_finances.viewModels;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.vtb_finances.model.Stock;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

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
                        /*
                        Stock stock = new Stock("Sberbank", 30, 3500L);
                        FirebaseFirestore db = FirebaseFirestore.getInstance();
                        db.collection("stocks")
                                .add(stock)
                                .addOnSuccessListener(documentReference -> Log.d("RegistrationVM", "DocumentSnapshot added with ID: " + documentReference.getId()))
                                .addOnFailureListener(e -> Log.w("RegistrationVM", "Error adding document", e));
                        Log.d("RegistrationVM", "success");
                        result.postValue(true);
                        */
                    } else {
                        Log.d("RegistrationVM", "failure");
                        result.postValue(false);
                    }
                });
    }
}