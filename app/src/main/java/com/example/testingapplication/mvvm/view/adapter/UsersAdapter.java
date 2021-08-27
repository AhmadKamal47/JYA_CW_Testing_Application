package com.example.testingapplication.mvvm.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testingapplication.callbacks.IItemActionClick;
import com.example.testingapplication.databinding.ItemUserBinding;
import com.example.testingapplication.mvvm.repository.db.roomdb.entity.User;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder> {

    private final Context context;
    private List<User> userList;
    private ItemUserBinding binding;

    private final IItemActionClick listener;

    public void setUserList(List<User> userList) {
        this.userList = userList;
        this.notifyDataSetChanged();
    }

    public UsersAdapter(Context context, IItemActionClick listener) {
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemUserBinding.inflate(LayoutInflater.from(context), parent, false);
        return new MyViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = userList.get(position);

        binding.idTv.setText(String.valueOf(user.getId()));
        binding.nameTv.setText(user.getName());
        binding.addressTv.setText(user.getAddress());

        binding.deleteIv.setOnClickListener(view -> {
            if(listener != null)
                listener.onItemDeleted(user, position);
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
