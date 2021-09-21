package com.example.testingapplication.mvvm.repository.db.roomdb.entity.relations.onetomany;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.testingapplication.mvvm.repository.db.roomdb.entity.Address;
import com.example.testingapplication.mvvm.repository.db.roomdb.entity.User;

import java.util.List;

public class UserWithAddresses {
    @Embedded
    private User user;

    @Relation(parentColumn = "userpk_id", entityColumn = "userId")
    private List<Address> addressList;

    public void setUser(User user) {
        this.user = user;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
    public User getUser() {
        return user;
    }

    public List<Address> getAddressList() {
        return addressList;
    }
}
