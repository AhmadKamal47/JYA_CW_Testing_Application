package com.example.testingapplication.mvvm.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testingapplication.callbacks.IItemActionClick;
import com.example.testingapplication.databinding.ItemUserBinding;
import com.example.testingapplication.mvvm.repository.db.roomdb.entity.relations.onetomany.UserWithAddresses;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder> {

    private final Context context;
    private List<UserWithAddresses> itemList;
    private ItemUserBinding binding;

    private final IItemActionClick<UserWithAddresses> listener;

    public void setList(List<UserWithAddresses> itemList) {
        this.itemList = itemList;
        this.notifyDataSetChanged();
    }

    public UsersAdapter(Context context, IItemActionClick<UserWithAddresses> listener) {
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
        UserWithAddresses item = itemList.get(position);

        binding.idTv.setText(String.valueOf(item.getUser().getId()));
        binding.nameTv.setText(item.getUser().getName());
        //binding.addressTv.setText(item.getAddressList().get(0).getCity());
        binding.cnic.setText("CNIC");

        /*if (user.getCnic() != null){
            binding.cnic.setText(user.getCnic().getCnicNo());
        }
        else
            binding.cnic.setText("No CNIC");*/

        binding.deleteIv.setOnClickListener(view -> {
            if(listener != null)
                listener.onItemDeleted(item, position);
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
