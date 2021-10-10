package com.example.vtb_finances.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.vtb_finances.R;
import com.example.vtb_finances.model.Stock;
import com.example.vtb_finances.ui.utils.GridMarginItemDecoration;
import com.example.vtb_finances.ui.utils.StockAdapter;
import com.example.vtb_finances.viewModels.CatalogVM;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CatalogFragment extends Fragment {

    private CatalogVM catalogVM;

    public CatalogFragment() {
        // Required empty public constructor
    }

    public static CatalogFragment newInstance() {
        return new CatalogFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_catalog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("CatalogyFrag", "onViewCreated");
        catalogVM = new ViewModelProvider(this).get(CatalogVM.class);
        RecyclerView rv = view.findViewById(R.id.frag_catalog_stocks_rv);
        FloatingActionButton fab = view.findViewById(R.id.frag_catalog_fab);
        fab.setOnClickListener(v -> {
            FragmentTransaction ft = requireActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, NewsFragment.newInstance());
            ft.addToBackStack(null);
            ft.commit();
        });
        rv.setLayoutManager(new GridLayoutManager(requireActivity(), 2));
        rv.addItemDecoration(new GridMarginItemDecoration(getResources().getDimensionPixelSize(R.dimen.news_margin), 2));
        rv.setAdapter(new StockAdapter(
                new ArrayList<Stock>(),
                Glide.with(requireActivity().getApplicationContext()))
        );
        catalogVM.getStocks().observe(getViewLifecycleOwner(), stocks -> {
            rv.setAdapter(new StockAdapter(
                    stocks,
                    Glide.with(requireActivity().getApplicationContext()))
            );
        });
    }
}