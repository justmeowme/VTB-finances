package com.example.vtb_finances.viewModels;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.vtb_finances.model.Stock;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class CatalogVM extends ViewModel {
    private final String TAG = "CatalogVM";
    private MutableLiveData<List<Stock>> stocks = new MutableLiveData<List<Stock>>(new ArrayList<Stock>());
    private FirebaseAuth mAuth;

    public LiveData<List<Stock>> getStocks() {
        return stocks;
    }

    public CatalogVM() {
        super();
        load();
    }

    public void load() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        Log.d(TAG, "auth : " + (currentUser != null));

        db.collection("stocks")
                .get()
                .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                ArrayList<Stock> newStoks = new ArrayList<>();
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Log.d(TAG, document.getId() + " => " + document.getData());

                                    Stock stock = new Stock(
                                            document.get("name", String.class),
                                            document.get("count", Integer.class),
                                            document.get("sellingPrice", Long.class),
                                            document.get("purchaseCost", Long.class),
                                            document.get("image", String.class)
                                    );
                                    newStoks.add(stock);
                                    Log.d(TAG, document.getId() + " => " + stock.toString());
                                }
                                stocks.postValue(newStoks);
                            } else {
                                Log.d(TAG, "Error getting documents: ", task.getException());
                            }
                        }
                );
    }
}
