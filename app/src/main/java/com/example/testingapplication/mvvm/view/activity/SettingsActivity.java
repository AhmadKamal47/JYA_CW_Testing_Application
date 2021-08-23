package com.example.testingapplication.mvvm.view.activity;

import android.view.View;

import com.example.testingapplication.databinding.ActivitySettingsBinding;

public class SettingsActivity extends BaseActivity<ActivitySettingsBinding> {

    @Override
    protected ActivitySettingsBinding initBindingRef() {
        return ActivitySettingsBinding.inflate(getLayoutInflater());
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

    }
}