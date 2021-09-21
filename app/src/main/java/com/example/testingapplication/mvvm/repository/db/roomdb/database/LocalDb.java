package com.example.testingapplication.mvvm.repository.db.roomdb.database;


import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import com.example.testingapplication.App;
import com.example.testingapplication.mvvm.repository.db.roomdb.dao.CnicDao;
import com.example.testingapplication.mvvm.repository.db.roomdb.dao.CourseDao;
import com.example.testingapplication.mvvm.repository.db.roomdb.dao.UserCoursesDao;
import com.example.testingapplication.mvvm.repository.db.roomdb.dao.UserDao;
import com.example.testingapplication.mvvm.repository.db.roomdb.entity.Address;
import com.example.testingapplication.mvvm.repository.db.roomdb.entity.CNIC;
import com.example.testingapplication.mvvm.repository.db.roomdb.entity.Course;
import com.example.testingapplication.mvvm.repository.db.roomdb.entity.User;
import com.example.testingapplication.mvvm.repository.db.roomdb.entity.UserCourses;


@Database(entities = {User.class, CNIC.class, Address.class, Course.class, UserCourses.class}, version = 1)
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
    public abstract CnicDao getCnicDao();
    public abstract CourseDao getCoursesDao();
    public abstract UserCoursesDao getUserCoursesDao();
}
