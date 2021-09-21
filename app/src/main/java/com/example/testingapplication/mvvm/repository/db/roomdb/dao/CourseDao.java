package com.example.testingapplication.mvvm.repository.db.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.testingapplication.mvvm.repository.db.roomdb.entity.Course;

import java.util.List;

@Dao
public interface CourseDao {

    @Insert
    long insertCourse(Course course);

    @Delete
    int deleteCourse(Course course);

    @Update
    int UpdateCourse(Course course);

    @Query("select * from courses where courseId = :id")
    Course getCourseWithId(long id);

    @Query("select * from courses")
    List<Course> getAllCourses();

}
