package com.example.testingapplication.mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private MutableLiveData<String> nameLiveData;

    public MainViewModel() {
        nameLiveData = new MutableLiveData<>();
    }

    public LiveData<String> getNameLiveData() {
        return nameLiveData;
    }

    public void updateName(String name){
        name = "Hello, "+name;
        nameLiveData.setValue(name);
    }
}
