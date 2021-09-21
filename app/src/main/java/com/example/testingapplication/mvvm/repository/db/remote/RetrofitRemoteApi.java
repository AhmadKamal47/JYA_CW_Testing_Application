package com.example.testingapplication.mvvm.repository.db.remote;

import com.example.testingapplication.mvvm.repository.db.remote.clients.ProfileClient;
import com.example.testingapplication.mvvm.repository.db.remote.clients.TodoClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRemoteApi {
    private final Retrofit retrofit;

    private static RetrofitRemoteApi instance;

    public static RetrofitRemoteApi getInstance() {
        if(instance == null)
            instance = new RetrofitRemoteApi();
        return instance;
    }

    private RetrofitRemoteApi() {
        retrofit = new Retrofit
                .Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public TodoClient initTodoClient(){
        return retrofit.create(TodoClient.class);
    }

    public ProfileClient initProfileClient(){
        return retrofit.create(ProfileClient.class);
    }

}
