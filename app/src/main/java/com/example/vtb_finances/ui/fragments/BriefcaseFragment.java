package com.example.vtb_finances.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vtb_finances.R;

public class BriefcaseFragment extends Fragment {


    public BriefcaseFragment() {
    }

    public static BriefcaseFragment newInstance() {
        return new BriefcaseFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_briefcase, container, false);
    }
}