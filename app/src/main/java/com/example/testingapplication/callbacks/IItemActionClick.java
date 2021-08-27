package com.example.testingapplication.callbacks;

import com.example.testingapplication.mvvm.repository.db.roomdb.entity.User;

public interface IItemActionClick {
    void onItemDeleted(User user, int position);
}
