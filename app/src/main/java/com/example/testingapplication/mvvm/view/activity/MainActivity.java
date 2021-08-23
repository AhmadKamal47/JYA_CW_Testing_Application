package com.example.testingapplication.mvvm.view.activity;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;

import com.example.testingapplication.databinding.ActivityMainBinding;
import com.example.testingapplication.mvvm.viewmodel.MainViewModel;
import com.example.testingapplication.mvvm.viewmodel.MainViewModelFactory;

public class MainActivity extends BaseActivity<ActivityMainBinding> {
    private static final String TAG = "MainActivity";
    private NavController mNavController;

    private MainViewModel mMainViewModel;
    private int times = 1;

    @Override
    protected ActivityMainBinding initBindingRef() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    @Override
    protected View initRoot() {
        return mBinding.getRoot();
    }

    @Override
    protected void initRef() {
        mMainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        observeName();
    }

    private void observeName() {
        mMainViewModel.getNameLiveData().observe(this, name -> {
            Log.d(TAG, "observerCalled_Times: "+times++);
            if(!TextUtils.isEmpty(name))
                mBinding.greetingsTv.setText(name);
        });
    }

    @Override
    protected void clicks() {
        mBinding.helloBtn.setOnClickListener(view -> {
            String name = mBinding.nameEt.getText().toString().trim();
            mMainViewModel.updateName(name);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

}