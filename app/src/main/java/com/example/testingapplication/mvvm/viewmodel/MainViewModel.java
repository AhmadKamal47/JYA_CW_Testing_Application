package com.example.testingapplication.mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.testingapplication.mvvm.repository.db.roomdb.dao.UserDao;
import com.example.testingapplication.mvvm.repository.db.roomdb.database.LocalDb;
import com.example.testingapplication.mvvm.repository.db.roomdb.entity.User;

import java.util.List;

public class MainViewModel extends ViewModel {
    private UserDao userDao;
    private MutableLiveData<List<User>> usersLiveData;

    public MainViewModel() {
        userDao = LocalDb.getInstance().getUserDao();
        usersLiveData = new MutableLiveData<>();
    }

    public LiveData<List<User>> getUsersLiveData() {
        return usersLiveData;
    }

    public void saveUser(User user){
        /*List<User> users = usersLiveData.getValue();

        if(users == null)
            users = new ArrayList<>();

        users.add(user);
        usersLiveData.setValue(users);*/

        userDao.createUser(user);
        fetchUsers();
    }

    public void fetchUsers(){
        List<User> list = userDao.getAllUsers();
        usersLiveData.setValue(list);
    }

    public void removeUser(User user) {
        userDao.deleteUser(user);
        //fetchUsers();
    }
}
