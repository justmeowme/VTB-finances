package com.example.vtb_finances.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vtb_finances.R;
import com.example.vtb_finances.ui.adapters.NewsAdapter;
import com.example.vtb_finances.ui.utils.MarginItemDecoration;
import com.example.vtb_finances.viewModels.NewsVM;

import java.util.Collections;


public class NewsFragment extends Fragment {

    private NewsAdapter newsAdapter = new NewsAdapter(Collections.emptyList());
    private RecyclerView rv;
    private NewsVM newsVM;

    public NewsFragment() {
    }

    public static NewsFragment newInstance() {
        return new NewsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        newsVM = new ViewModelProvider(this).get(NewsVM.class);
        rv = view.findViewById(R.id.frag_news_rv);
        rv.setLayoutManager(new LinearLayoutManager(requireActivity()));
        rv.setAdapter(newsAdapter);
        rv.addItemDecoration(
                new MarginItemDecoration(
                        getResources().getDimensionPixelSize(R.dimen.news_margin)
                )
        );
        newsVM.getContent().observe(getViewLifecycleOwner(), content -> {
            rv.setAdapter(new NewsAdapter(content));
        });
    }

    @Override
    public void onDestroyView() {
        rv.setAdapter(null);
        rv = null;
        super.onDestroyView();
    }
}