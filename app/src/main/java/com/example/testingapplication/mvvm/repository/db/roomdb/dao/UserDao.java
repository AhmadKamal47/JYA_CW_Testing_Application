package com.example.testingapplication.mvvm.repository.db.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.testingapplication.mvvm.repository.db.roomdb.entity.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void createUser(User... user);

    @Update
    void updateUser(User... user);

    @Delete
    void deleteUser(User... user);

    @Query("select * from users where name = :value")
    User getUserInfo(String value);

    @Query("select * from users")
    List<User> getAllUsers();
}
