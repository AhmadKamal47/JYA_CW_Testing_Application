package com.example.testingapplication.mvvm.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.testingapplication.mvvm.repository.db.remote.RetrofitRemoteApi;
import com.example.testingapplication.mvvm.repository.models.Todo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodoViewModel extends ViewModel {
    private MutableLiveData<List<Todo>> todosLiveData;

    public TodoViewModel() {
        todosLiveData = new MutableLiveData<>();
    }

    public LiveData<List<Todo>> getTodosLiveData() {
        return todosLiveData;
    }

    public void fetchAllTodos() {
        RetrofitRemoteApi
                .getInstance()
                .initTodoClient()
                .getAllTodos()
                .enqueue(new Callback<List<Todo>>() {
                    @Override
                    public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                        try {
                            Log.d("TAG", "onResponse_: " + response);
                            Log.d("TAG", "onResponse_Code: " + response.code());
                            Log.d("TAG", "onResponse_Body: " + response.body());

                            if (response.code() == 200)
                                todosLiveData.setValue(response.body());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    @Override
                    public void onFailure(Call<List<Todo>> call, Throwable t) {
                        Log.e("TAG", "onFailure: " + t.getMessage());
                    }
                });
    }
}
