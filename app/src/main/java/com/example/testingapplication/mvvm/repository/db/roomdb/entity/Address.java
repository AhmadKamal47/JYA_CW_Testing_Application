package com.example.testingapplication.mvvm.repository.db.roomdb.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "addresses",
        foreignKeys =
                {
                        @ForeignKey(
                                entity = User.class,
                                parentColumns = "userpk_id",
                                childColumns = "userId"
                        )
                })
public class Address {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String city;
    private String houseNo;
    private String streetNo;
    private String postalCode;
    private long userId;

    public Address(String city, String houseNo, String streetNo, String postalCode, long userId) {
        this.city = city;
        this.houseNo = houseNo;
        this.streetNo = streetNo;
        this.postalCode = postalCode;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
