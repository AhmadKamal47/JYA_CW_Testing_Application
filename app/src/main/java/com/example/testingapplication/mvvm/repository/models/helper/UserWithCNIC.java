package com.example.testingapplication.mvvm.repository.models.helper;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.testingapplication.mvvm.repository.db.roomdb.entity.CNIC;
import com.example.testingapplication.mvvm.repository.db.roomdb.entity.User;

public class UserWithCNIC {

    @Embedded
    private User user;
//    @Relation(parentColumn = "userpk_id", entityColumn = "id")
    @Embedded
    private CNIC cnic;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CNIC getCnic() {
        return cnic;
    }
    public void setCnic(CNIC cnic) {
        this.cnic = cnic;
    }
}
