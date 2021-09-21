package com.example.testingapplication.mvvm.view.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testingapplication.R;
import com.example.testingapplication.databinding.FragmentHomeBinding;

public class HomeFragment extends BaseFragment<FragmentHomeBinding> {
    private static final String TAG = "HomeFragment";


    @Override
    protected FragmentHomeBinding initBindingRef(LayoutInflater inflater, ViewGroup container, Boolean attatchToParent) {
        return FragmentHomeBinding.inflate(inflater, container, attatchToParent);
    }

    @Override
    protected View initRoot() {
        return mBinding.getRoot();
    }

    @Override
    protected void initRef() {
        initNavGraph();

        mBinding.toAbout.setOnClickListener(view1 -> {
            mNavController.navigate(R.id.aboutFragment);
            /*
            String name = mBinding.nameEt.getText().toString().trim();
            String email = mBinding.emailEt.getText().toString().trim();
            String ageStr = mBinding.ageEt.getText().toString().trim();

            int age = 0;
            if(!TextUtils.isEmpty(ageStr))
                age = Integer.parseInt(ageStr);

                if(TextUtils.isEmpty(name)){
                mBinding.nameEt.setError("Name required!");
                return;
            }

            if(TextUtils.isEmpty(email)){
                mBinding.emailEt.setError("Email required!");
                return;
            }

            // Pass Name to About Fragment - 1st Method
            *//*Bundle bundle = new Bundle();
            bundle.putSerializable(Constants.KEY_MY_PROFILE, new Profile(name, email, age));
            mNavController.navigate(R.id.action_homeFragment_to_aboutFragment, bundle);*//*

            // Pass Name to About Fragment - 2nd Method
//            HomeFragmentDirections.ActionHomeFragmentToAboutFragment gotoAboutFragment = HomeFragmentDirections.actionHomeFragmentToAboutFragment(new Profile(name, email, age), name);
//            mNavController.navigate(gotoAboutFragment);*/
        });
    }

    protected void clicks()
    {

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStarted: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResumed: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPaused: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStopped: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyedView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroyed: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetached: ");
    }
}