package com.example.testingapplication.mvvm.repository.db.remote.clients;

import com.example.testingapplication.mvvm.repository.models.Profile;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ProfileClient {
    @POST("addprofile")
    Call<String> createProfile(@Body Profile profile);

}
