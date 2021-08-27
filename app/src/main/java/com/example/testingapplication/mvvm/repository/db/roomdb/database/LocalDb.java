package com.example.testingapplication.mvvm.repository.db.roomdb.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.testingapplication.App;
import com.example.testingapplication.mvvm.repository.db.roomdb.dao.UserDao;
import com.example.testingapplication.mvvm.repository.db.roomdb.entity.User;

@Database(entities = {User.class}, version = 1)
public abstract class LocalDb extends RoomDatabase {
    private static final String DATABASE_NAME = "mytestdb";

    private static LocalDb instance;

    public static LocalDb getInstance() {
        if(instance == null) {
            instance = Room
                        .databaseBuilder(
                                App.getInstance().getAppContext(),
                                LocalDb.class,
                                DATABASE_NAME
                        )
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }

    public abstract UserDao getUserDao();
}
