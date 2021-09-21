package com.example.testingapplication.threads;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class MyRunnableThread implements Runnable {
    private static final String TAG = "MyRunnableThread";
    private String url;

    public MyRunnableThread(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        // Do work on URL
        for(int i = 1; i <= 5; i++){
            try {
                Log.d(TAG, "_onRun: "+ i);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
