package com.example.testingapplication.mvvm.repository.db.roomdb.entity.relations.manytomany;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.testingapplication.mvvm.repository.db.roomdb.entity.Course;
import com.example.testingapplication.mvvm.repository.db.roomdb.entity.User;

import java.util.List;

public class UserWithCourses {

    @Embedded
    private User user;

    @Relation(entity = Course.class,parentColumn = "courseId", entityColumn = "cid")
    private List<Course> course;

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
