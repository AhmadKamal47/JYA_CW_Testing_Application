package com.example.testingapplication.mvvm.repository.db.roomdb.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cnics")
public class CNIC {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private long id;

    @ColumnInfo(name = "cnic_no")
    private String cnicNo;

    @ColumnInfo(name = "nationality")
    private String nationality;

    public CNIC(String cnicNo, String nationality)
    {
        this.cnicNo = cnicNo;
        this.nationality = nationality;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCnicNo() {
        return cnicNo;
    }

    public void setCnicNo(String cnicNo) {
        this.cnicNo = cnicNo;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
