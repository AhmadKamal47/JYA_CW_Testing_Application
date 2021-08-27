package com.example.testingapplication.mvvm.view.activity;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.testingapplication.callbacks.IItemActionClick;
import com.example.testingapplication.databinding.ActivityMainBinding;
import com.example.testingapplication.mvvm.repository.db.roomdb.entity.User;
import com.example.testingapplication.mvvm.view.adapter.UsersAdapter;
import com.example.testingapplication.mvvm.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<ActivityMainBinding> implements IItemActionClick {
    private static final String TAG = "MainActivity";

    private List<User> userList;
    private UsersAdapter adapter;
    private MainViewModel mMainViewModel;

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
        // Setup RecyclerView
        adapter = new UsersAdapter(this, this);
        userList = new ArrayList<>();

        adapter.setUserList(userList);
        mBinding.usersRv.setAdapter(adapter);
        mBinding.usersRv.setHasFixedSize(true);

        mMainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mMainViewModel.fetchUsers();
        observeUsers();
    }

    private void observeUsers() {
        mMainViewModel.getUsersLiveData().observe(this, list -> {
            if(list != null && list.size() > 0){
                userList.clear();
                userList.addAll(list);
            }
        });
    }

    @Override
    protected void clicks() {
        mBinding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mBinding.nameEt.getText().toString().trim();
                if(TextUtils.isEmpty(name)){
                    mBinding.nameEt.setError("Name required!");
                    return;
                }

                String address = mBinding.addressEt.getText().toString().trim();
                mMainViewModel.saveUser(new User(name, address));
            }
        });
    }

    @Override
    public void onItemDeleted(User user, int position) {
        mMainViewModel.removeUser(user);
        userList.remove(position);
        adapter.notifyItemRemoved(position);
    }
}