package com.example.testingapplication.activity;

import android.view.View;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.testingapplication.R;
import com.example.testingapplication.databinding.ActivityMainBinding;
import com.example.testingapplication.fragment.AboutFragment;
import com.example.testingapplication.fragment.HomeFragment;

public class MainActivity extends BaseActivity<ActivityMainBinding> {
    private static final String TAG = "MainActivity";
    private NavController mNavController;

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
        mNavController = Navigation.findNavController(this, R.id.fragmentContainerView);
    }

    @Override
    protected void clicks() {
        mBinding.toAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNavController.navigate(R.id.aboutFragment);
            }
        });
    }
}