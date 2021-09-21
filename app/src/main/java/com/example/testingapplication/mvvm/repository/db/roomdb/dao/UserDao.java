package com.example.testingapplication.mvvm.repository.db.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.testingapplication.mvvm.repository.db.roomdb.entity.Address;
import com.example.testingapplication.mvvm.repository.db.roomdb.entity.User;
import com.example.testingapplication.mvvm.repository.db.roomdb.entity.relations.onetomany.UserWithAddresses;
import com.example.testingapplication.mvvm.repository.models.helper.UserWithCNIC;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    long createUser(User user);

    @Update
    int updateUser(User... user);

    @Insert
    void addAddress(Address... addresses);

    @Delete
    void deleteUser(User... user);

    @Query("select * from users where user_name = :value")
    User getUserInfo(String value);

    @Query("select * from users where cnicfk_id = :cnicId LIMIT 1")
    User getUserWithCnic(long cnicId);

    @Query("select * from users")
    List<User> getAllUsers();

    @Transaction
    @Query("select * from users")
    List<UserWithCNIC> getAllUsersWithCnics();

    @Transaction
    @Query("select * from users")
    List<UserWithAddresses> getAllUsersWithAddresses();

    @Query("select * from users where user_name =:name LIMIT 1")
    User findUser(String name);
}
