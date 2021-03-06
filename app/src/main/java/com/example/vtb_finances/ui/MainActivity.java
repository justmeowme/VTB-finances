package com.example.vtb_finances.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.example.vtb_finances.R;
import com.example.vtb_finances.ui.fragments.BriefcaseFragment;
import com.example.vtb_finances.ui.fragments.CatalogFragment;
import com.example.vtb_finances.ui.fragments.NewsFragment;
import com.example.vtb_finances.ui.fragments.ProfileFragment;
import com.example.vtb_finances.ui.utils.Tab;
import com.example.vtb_finances.viewModels.MainVM;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private MainVM mainVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mainVM = new ViewModelProvider(this).get(MainVM.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.act_main_menu);
        bottomNavigationView.setOnNavigationItemReselectedListener(menuItem -> {
            menuItem.getItemId();
        });
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.main_item_menu_catalog) {
                mainVM.changeTab(Tab.Catalog);
            } else if (id == R.id.main_item_menu_briefcase) {
                mainVM.changeTab(Tab.Briefcase);
            } else if (id == R.id.main_item_menu_profile) {
                mainVM.changeTab(Tab.Profile);
            }
            return true;
        });
        mainVM.getCurrentTab().observe(this, this::openFragment);
    }

    private void openFragment(Tab tab) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (tab == Tab.Profile)
            ft.replace(R.id.container, ProfileFragment.newInstance());
        else if (tab == Tab.Catalog)
            ft.replace(R.id.container, CatalogFragment.newInstance());
        else if (tab == Tab.Briefcase)
            ft.replace(R.id.container, BriefcaseFragment.newInstance());
        ft.commit();
    }

    //?????? ?????????????????? ????????????????????
    public static void setDefaults(String key, String value, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    //???????? ?????? ?????????????????? ????????????????????
    public static String getDefaults(String key, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, null);
    }
}