package com.example.testingapplication.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public final class AppExecutor {
    private static AppExecutor instance;
    private final ExecutorService queryThread;

    public static AppExecutor getInstance()
    {
        if(instance == null)
            instance = new AppExecutor();
        return instance;
    }

    private AppExecutor()
    {
        queryThread = Executors.newSingleThreadExecutor();
    }

    public ExecutorService getQueryThread() {
        return queryThread;
    }

    public <T> T submitTask(Callable<T> task){
        Future<T> result = queryThread.submit(task);

        try {
            return result.get(); // get() - Blocks Thread iff result is not ready
        } catch (Exception e) {
            e.printStackTrace();
            queryThread.shutdown();
        }

        return null;
    }

}
