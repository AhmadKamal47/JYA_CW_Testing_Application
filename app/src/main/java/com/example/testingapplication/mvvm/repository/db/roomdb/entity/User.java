package com.example.testingapplication.mvvm.repository.db.roomdb.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Delete;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "userpk_id")
    private long id;

    @ColumnInfo (name = "user_name")
    private String name;

    @ColumnInfo (name = "email")
    private String email;

    @ColumnInfo(name = "cnicfk_id")
    private long cnicId;

    public User(String name, long cnicId) {
        this.name = name;
        this.cnicId = cnicId;
    }

    /*@Embedded
    private CNIC cnic;

    public User(String name, String address, CNIC cnic) {
        this.name = name;
        this.address = address;
        this.cnic = cnic;
    }*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCnicId() {
        return cnicId;
    }

    public void setCnicId(long cnicId) {
        this.cnicId = cnicId;
    }

    /*public CNIC getCnic() {
        return cnic;
    }

    public void setCnic(CNIC cnic) {
        this.cnic = cnic;
    }*/

}
