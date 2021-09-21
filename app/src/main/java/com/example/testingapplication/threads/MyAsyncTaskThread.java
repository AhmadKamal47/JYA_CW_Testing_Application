package com.example.testingapplication.threads;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class MyAsyncTaskThread extends AsyncTask<String, Integer, Double> {
    private static final String TAG = "MyAsyncTaskThread";
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected Double doInBackground(String... urls) {
        int progress = 0;
        // Uploading Image Url
        for(int i = 1; i <= 3; i++){
            try {
                Log.d(TAG, "_onDoInBackground: "+ i);
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return Double.valueOf(progress);
    }

    @Override
    protected void onPostExecute(Double result) {
        super.onPostExecute(result);
    }
}
