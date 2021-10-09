package com.example.vtb_finances.viewModels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.vtb_finances.model.News;
import com.example.vtb_finances.model.Stock;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class NewsVM extends ViewModel {
    private final String TAG = "NewsVM";

    private MutableLiveData<List<News>> content = new MutableLiveData<List<News>>();

    public NewsVM() {
        loadNews();
    }

    public LiveData<List<News>> getContent() {
        return content;
    }

    private void loadNews() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        Log.d(TAG, "auth : " + (currentUser != null));
        db.collection("news")
                .get()
                .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                ArrayList<News> news = new ArrayList<>();
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Log.d(TAG, document.getId() + " => " + document.getData());
                                    news.add(document.toObject(News.class));
                                }
                                content.postValue(news);
                            } else {
                                Log.d(TAG, "Error getting documents: ", task.getException());
                            }
                        }
                );
    }
}