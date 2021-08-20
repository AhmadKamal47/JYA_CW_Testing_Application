package com.example.testingapplication.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testingapplication.Profile;
import com.example.testingapplication.R;
import com.example.testingapplication.databinding.FragmentHomeBinding;
import com.example.testingapplication.utils.Constants;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding mBinding;
    private static final String TAG = "HomeFragment";

    private NavController mNavController;

    public HomeFragment() {}

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
        mBinding = FragmentHomeBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated: ");
        super.onViewCreated(view, savedInstanceState);

        mNavController = Navigation.findNavController(view);
        mBinding.toAbout.setOnClickListener(view1 -> {
            String name = mBinding.nameEt.getText().toString().trim();
            String email = mBinding.emailEt.getText().toString().trim();
            int age = Integer.parseInt(mBinding.ageEt.getText().toString().trim());

            if(TextUtils.isEmpty(name)){
                mBinding.nameEt.setError("Name required!");
                return;
            }

            if(TextUtils.isEmpty(email)){
                mBinding.emailEt.setError("Email required!");
                return;
            }

            // Pass Name to About Fragment - 1st Method
            /*Bundle bundle = new Bundle();
            bundle.putSerializable(Constants.KEY_MY_PROFILE, new Profile(name, email, age));
            mNavController.navigate(R.id.action_homeFragment_to_aboutFragment, bundle);*/

            // Pass Name to About Fragment - 2nd Method
            HomeFragmentDirections.ActionHomeFragmentToAboutFragment gotoAboutFragment = HomeFragmentDirections.actionHomeFragmentToAboutFragment(new Profile(name, email, age), name);
            mNavController.navigate(gotoAboutFragment);
        });
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