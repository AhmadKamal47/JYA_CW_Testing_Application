package com.example.testingapplication.mvvm.repository.db.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.testingapplication.mvvm.repository.db.roomdb.entity.CNIC;

import java.util.List;

@Dao
public interface CnicDao {

    @Insert
    long insert(CNIC cnic);

    @Query("select * from cnics")
    List<CNIC> getAllCNICs();

    @Delete
    void deleteCnic(CNIC cnic);
}
