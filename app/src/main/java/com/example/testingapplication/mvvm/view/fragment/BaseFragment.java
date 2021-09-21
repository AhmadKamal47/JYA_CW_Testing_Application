package com.example.testingapplication.mvvm.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public abstract class BaseFragment<VB> extends Fragment {

    protected VB mBinding;
    protected NavController mNavController;

    public BaseFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = initBindingRef(inflater, container,false);
        return initRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRef();
        clicks();
    }

    protected void initNavGraph() {
        mNavController = Navigation.findNavController(initRoot());
    }

    protected abstract VB initBindingRef(LayoutInflater inflater, ViewGroup container, Boolean attatchToParent);
    protected abstract View initRoot();
    protected abstract void initRef();
    protected abstract void clicks();
}
