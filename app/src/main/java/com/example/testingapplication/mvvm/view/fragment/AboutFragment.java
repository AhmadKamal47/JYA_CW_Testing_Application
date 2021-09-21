package com.example.testingapplication.mvvm.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.testingapplication.mvvm.repository.models.Profile;
import com.example.testingapplication.databinding.FragmentAboutBinding;

public class AboutFragment extends BaseFragment<FragmentAboutBinding>{

    private static final String TAG = "AboutFragment";

    private void populate(Profile profile) {
        mBinding.nameTv.setText(profile.getName());
        mBinding.emailTv.setText(profile.getEmail());
        mBinding.ageTv.setText(String.valueOf(profile.getAge()));
    }


    @Override
    protected FragmentAboutBinding initBindingRef(LayoutInflater inflater, ViewGroup container, Boolean attatchToParent) {
        return FragmentAboutBinding.inflate(inflater, container, attatchToParent);
    }

    @Override
    protected View initRoot() {
        return mBinding.getRoot();
    }

    @Override
    protected void initRef() {

        // Receive Passed data - 1st Method
        /*if (getArguments() != null) {
            Profile profile = (Profile) getArguments().getSerializable(Constants.KEY_MY_PROFILE);

            if (profile != null)
                populate(profile);
        }*/

//        Profile profile = AboutFragmentArgs.fromBundle(getArguments()).getMyProfile();
//        populate(profile);

    }

    @Override
    protected void clicks() {

    }
}