package com.example.testingapplication.mvvm.repository.db.roomdb.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "userCourses",
        foreignKeys =
                {
                        @ForeignKey(entity = Course.class, parentColumns = "courseId", childColumns = "cid"),
                        @ForeignKey(entity = User.class, parentColumns = "userpk_id", childColumns = "uid")
                })
public class UserCourses {

    @PrimaryKey(autoGenerate = true)
    private long ucid;

    private long cid;
    private long uid;

    public UserCourses(long cid, long uid) {
        this.cid = cid;
        this.uid = uid;
    }

    public long getUcid() {
        return ucid;
    }

    public void setUcid(long ucid) {
        this.ucid = ucid;
    }

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }
}
