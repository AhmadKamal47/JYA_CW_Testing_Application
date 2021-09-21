package com.example.testingapplication.mvvm.repository.db.roomdb.entity.relations.manytomany;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.testingapplication.mvvm.repository.db.roomdb.entity.Course;
import com.example.testingapplication.mvvm.repository.db.roomdb.entity.User;

import java.util.List;

public class CourseWithUsers {
    @Embedded
    private Course course;

    @Relation(parentColumn = "userpk_id", entityColumn = "uid")
    private List<User> user;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
