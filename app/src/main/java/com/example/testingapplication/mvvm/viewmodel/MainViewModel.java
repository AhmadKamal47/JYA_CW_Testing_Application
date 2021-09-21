package com.example.testingapplication.mvvm.viewmodel;

import android.os.Handler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.testingapplication.mvvm.repository.db.roomdb.dao.CnicDao;
import com.example.testingapplication.mvvm.repository.db.roomdb.dao.UserDao;
import com.example.testingapplication.mvvm.repository.db.roomdb.database.LocalDb;
import com.example.testingapplication.mvvm.repository.db.roomdb.entity.Address;
import com.example.testingapplication.mvvm.repository.db.roomdb.entity.CNIC;
import com.example.testingapplication.mvvm.repository.db.roomdb.entity.User;
import com.example.testingapplication.mvvm.repository.db.roomdb.entity.relations.onetomany.UserWithAddresses;
import com.example.testingapplication.threads.AppExecutor;
import com.example.testingapplication.threads.MyRunnableThread;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MainViewModel extends ViewModel {
    private UserDao userDao;
    private CnicDao cnicDao;

    private MutableLiveData<List<UserWithAddresses>> usersLiveData;

    public MainViewModel() {
        userDao = LocalDb.getInstance().getUserDao();
        cnicDao = LocalDb.getInstance().getCnicDao();
        usersLiveData = new MutableLiveData<>();
    }

    public LiveData<List<UserWithAddresses>> getUsersLiveData() {
        return usersLiveData;
    }

    /*public long saveUser(User user){
        final long[] id = {-1};

        queryThread.execute(new Runnable() {
            @Override
            public void run() {
                User availableUser = userDao.findUser(user.getName());

                if(availableUser == null) {
                    id[0] = userDao.createUser(user);
                }
                else {
                    id[0] = userDao.updateUser(user);
                }
            }
        });

        return id[0];
    }*/

    public long saveUser(User user) {
        return AppExecutor.getInstance().submitTask(() -> {
            User availableUser = userDao.findUser(user.getName());

            if (availableUser == null) {
                return userDao.createUser(user);
            } else {
                return (long) userDao.updateUser(user);
            }
        });
    }

    /*public long saveUser(User user) {
        Future<Long> result = AppExecutor.getInstance().getQueryThread().submit(() -> {
            User availableUser = userDao.findUser(user.getName());

            if (availableUser == null) {
                return userDao.createUser(user);
            } else {
                return (long) userDao.updateUser(user);
            }
        });

        try {
            return result.get(); // get() - Blocks Thread iff result is not ready
        } catch (Exception e) {
            e.printStackTrace();
            queryThread.shutdown();
        }

        return 0; // will execute iff exception occurred
    }*/

    public void fetchUsers() {
        /*List<CNIC> cnicList = cnicDao.getAllCNICs();
        List<UserWithCNIC> usersWithCnics = new ArrayList<>();

        for(CNIC cnic :  cnicList){
            if(cnic != null) {
                User user = userDao.getUserWithCnic(cnic.getId());
                if(user != null)
                {
                    UserWithCNIC userWithCNIC = new UserWithCNIC(user, cnic);
                    usersWithCnics.add(userWithCNIC);
                }
            }
        }*/

        AppExecutor
                .getInstance()
                .getQueryThread()
                .execute(() -> {
                    List<UserWithAddresses> userWithAddresses = userDao.getAllUsersWithAddresses();
                    usersLiveData.postValue(userWithAddresses);
                });

    }

    public void removeRecord(UserWithAddresses record) {
        userDao.deleteUser(record.getUser());
        //cnicDao.deleteCnic(record.getCnic());
    }

    public long saveCNIC(CNIC cnic) {
        Future<Long> cnicIdFuture = AppExecutor
                .getInstance()
                .getQueryThread()
                .submit(new Callable<Long>() {
                    @Override
                    public Long call() throws Exception {
                        return cnicDao.insert(cnic);
                    }
                });

        try {
            return cnicIdFuture.get();
        } catch (ExecutionException | InterruptedException e) {
            AppExecutor.getInstance().getQueryThread().shutdown();
            e.printStackTrace();
        }

        return 0;
    }

    public void saveAddresses(Address address) {
        AppExecutor
                .getInstance()
                .getQueryThread()
                .execute(new Runnable() {
                    @Override
                    public void run() {
                        userDao.addAddress(address);
                    }
                });
    }
}
