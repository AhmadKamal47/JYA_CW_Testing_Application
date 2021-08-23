package com.example.testingapplication;

import android.app.Application;
import android.content.Context;

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
    }
}
