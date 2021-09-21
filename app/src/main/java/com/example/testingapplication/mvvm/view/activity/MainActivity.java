package com.example.testingapplication.mvvm.view.activity;

import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.testingapplication.callbacks.IItemActionClick;
import com.example.testingapplication.databinding.ActivityMainBinding;
import com.example.testingapplication.mvvm.repository.db.roomdb.entity.Address;
import com.example.testingapplication.mvvm.repository.db.roomdb.entity.CNIC;
import com.example.testingapplication.mvvm.repository.db.roomdb.entity.User;
import com.example.testingapplication.mvvm.repository.db.roomdb.entity.relations.onetomany.UserWithAddresses;
import com.example.testingapplication.mvvm.repository.models.Todo;
import com.example.testingapplication.mvvm.view.adapter.UsersAdapter;
import com.example.testingapplication.mvvm.viewmodel.MainViewModel;
import com.example.testingapplication.mvvm.viewmodel.TodoViewModel;
import com.example.testingapplication.threads.MyAsyncTaskThread;
import com.example.testingapplication.threads.MyRunnableThread;
import com.example.testingapplication.threads.MyRunnableThread2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<ActivityMainBinding>
        implements IItemActionClick<UserWithAddresses> {

    private static final String TAG = "MainActivity";

    private UsersAdapter adapter;
    private List<UserWithAddresses> userList;
    private MainViewModel mMainViewModel;
    private TodoViewModel mTodoViewModel;

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

        adapter.setList(userList);
        mBinding.usersRv.setAdapter(adapter);
        mBinding.usersRv.setHasFixedSize(true);

        mTodoViewModel = new ViewModelProvider(this).get(TodoViewModel.class);
        mMainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mMainViewModel.fetchUsers();
        observeUsers();

        mTodoViewModel.fetchAllTodos();
        observeTodos();
//        initThreads();
    }

    private void observeTodos() {
        mTodoViewModel.getTodosLiveData().observe(this, new Observer<List<Todo>>() {
            @Override
            public void onChanged(List<Todo> todos) {
                Log.d(TAG, "onChanged_List: "+todos);
                if(todos != null)
                    Log.d(TAG, "onChanged_List_Size: "+todos.size());
            }
        });
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
                String cnic = mBinding.cnicEt.getText().toString().trim();

                long cnicId = mMainViewModel.saveCNIC(new CNIC(cnic, "PK"));
                long userId = mMainViewModel.saveUser(new User(name, cnicId));
                mMainViewModel.saveAddresses(new Address("Lahore", "A-26", address, "54000", userId));
                mMainViewModel.fetchUsers();
            }
        });

        mBinding.tempBtn.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, SecondActivity.class)));
    }

    @Override
    public void onItemDeleted(UserWithAddresses record, int position) {
        mMainViewModel.removeRecord(record);
        userList.remove(position);
        adapter.notifyItemRemoved(position);
    }

    private void initThreads(){
        String url = "https://www.google.com/";
        // Thread No. 1
        new MyAsyncTaskThread().execute(url);
        // Thread No. 2
        Thread thread = new Thread(new MyRunnableThread(url));
        thread.start();
        // Thread No. 3
        new Handler().post(new MyRunnableThread2(url));
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                initRef();
                handler.post(this);
            }
        }, 3000);
        // Thread No. 4 Broadcast Receiver
        // Thread No. 5 Services -> Unbound Service: Background Service & Foreground Service & Bound Service => Background Service
    }

}