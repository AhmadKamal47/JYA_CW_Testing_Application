package com.example.testingapplication.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.testingapplication.Profile;
import com.example.testingapplication.databinding.FragmentAboutBinding;
import com.example.testingapplication.utils.Constants;

public class AboutFragment extends Fragment {

    private FragmentAboutBinding mBinding;
    private static final String TAG = "AboutFragment";

    public AboutFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttached: ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreated: ");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");
        mBinding = FragmentAboutBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated: ");
        super.onViewCreated(view, savedInstanceState);

        // Receive Passed data - 1st Method
        /*if (getArguments() != null) {
            Profile profile = (Profile) getArguments().getSerializable(Constants.KEY_MY_PROFILE);

            if (profile != null)
                populate(profile);
        }*/

        Profile profile = AboutFragmentArgs.fromBundle(getArguments()).getMyProfile();
        populate(profile);
    }

    private void populate(Profile profile) {
        mBinding.nameTv.setText(profile.getName());
        mBinding.emailTv.setText(profile.getEmail());
        mBinding.ageTv.setText(String.valueOf(profile.getAge()));
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