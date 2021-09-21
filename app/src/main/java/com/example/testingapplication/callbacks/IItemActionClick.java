package com.example.testingapplication.callbacks;

public interface IItemActionClick<T> {
    void onItemDeleted(T item, int position);
}
