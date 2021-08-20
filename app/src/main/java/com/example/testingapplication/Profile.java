package com.example.testingapplication;

import java.io.Serializable;

public class Profile implements Serializable {
    private String name, email;
    private int age;

    public Profile(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
