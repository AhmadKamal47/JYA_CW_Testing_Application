package com.example.testingapplication.mvvm.repository.db.remote.clients;

import com.example.testingapplication.mvvm.repository.models.Todo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface TodoClient {

    @GET("todos")
    Call<List<Todo>> getAllTodos();

    @POST("todos/create")
    Call<Todo> addTodoNote(@Body Todo todo);
}
