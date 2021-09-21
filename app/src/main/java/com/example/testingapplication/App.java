package com.example.testingapplication;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.example.testingapplication.utils.Constants;

public class App extends Application {
    private static App instance;

    public static App getInstance() {
        return instance;
    }

    public Context getAppContext(){
        return instance.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        AndroidNetworking.initialize(this);
    }
}
