package com.example.vtb_finances.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.vtb_finances.ui.utils.Tab;

public class MainVM extends ViewModel {

    private final MutableLiveData<Tab> currentTab = new MutableLiveData<>(Tab.Catalog);

    public LiveData<Tab> getCurrentTab() {
        return currentTab;
    }

    public void changeTab(Tab tab) {
        currentTab.postValue(tab);
    }
}
