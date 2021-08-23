package com.example.testingapplication.mvvm.view.activity;

import android.view.View;

import com.example.testingapplication.databinding.ActivitySecondBinding;
import com.google.android.material.snackbar.Snackbar;

public class SecondActivity extends BaseActivity<ActivitySecondBinding> {
    private static final String TAG = "SecondActivity";

    @Override
    protected ActivitySecondBinding initBindingRef() {
        return ActivitySecondBinding.inflate(getLayoutInflater());
    }

    @Override
    protected View initRoot() {
        return mBinding.getRoot();
    }

    @Override
    protected void initRef() {

    }

    @Override
    protected void clicks() {
        mBinding.formLayoutInc.registerBtn.setOnClickListener(view -> {
            String name = mBinding.formLayoutInc.nameEt.getText().toString().trim();
            Snackbar.make(mBinding.getRoot(), "Welcome! "+name, Snackbar.LENGTH_SHORT).show();
        });
    }
}