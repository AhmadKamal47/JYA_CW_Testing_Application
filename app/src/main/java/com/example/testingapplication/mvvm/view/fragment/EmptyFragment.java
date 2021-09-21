package com.example.testingapplication.mvvm.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testingapplication.R;
import com.example.testingapplication.databinding.FragmentEmptyBinding;
import com.example.testingapplication.databinding.FragmentHomeBinding;

public class EmptyFragment extends BaseFragment<FragmentEmptyBinding> {


    @Override
    protected FragmentEmptyBinding initBindingRef(LayoutInflater inflater, ViewGroup container, Boolean attatchToParent) {
        return FragmentEmptyBinding.inflate(inflater, container, attatchToParent);
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