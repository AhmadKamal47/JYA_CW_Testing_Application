package com.example.testingapplication.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<VB> extends AppCompatActivity {
    protected VB mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = initBindingRef();
        setContentView(initRoot());

        initRef();
        clicks();
    }

    protected abstract VB initBindingRef();
    protected abstract View initRoot();
    protected abstract void initRef();
    protected abstract void clicks();
}
