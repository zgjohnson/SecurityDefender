package com.ualr.securitydefender.ui.passwords;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.ualr.securitydefender.R;
import com.ualr.securitydefender.data.PasswordEntity;

import java.util.List;

public class PasswordRecyclerAdapter extends RecyclerView.Adapter {
    private List<PasswordEntity> passwordEntityList;
    private Context context;
    private OnItemClickListener mListener;

    public OnItemClickListener getmListener() {
        return mListener;
    }

    public void setOnItemClickListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    public interface OnItemClickListener{
        void onItemClick(View view, PasswordEntity obj, int position);
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.password_list_item, parent, false);
        return new PasswordViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PasswordEntity passwordEntity = passwordEntityList.get(position);
        PasswordViewHolder passwordViewHolder = (PasswordViewHolder) holder;

        passwordViewHolder.setUsernameValue(passwordEntity.getUsername());
        passwordViewHolder.setPasswordValue(passwordEntity.getPassword());
        passwordViewHolder.setWebsiteName(passwordEntity.getWebsite());
        passwordViewHolder.setWebsiteIcon(passwordEntity.getWebsiteIconLetter());

    }


    @Override
    public int getItemCount() {
        if (this.passwordEntityList == null) {
            return 0;
        } else {
            return passwordEntityList.size();
        }
    }

    public PasswordRecyclerAdapter(Context context){ this.context = context;}
    public PasswordRecyclerAdapter(Context context, List<PasswordEntity> passwords) {
        this.context = context;
        this.passwordEntityList = passwords;
    }

    public void addPasswordItem(int position, PasswordEntity item){
        passwordEntityList.add(position, item);
        notifyItemInserted(position);
    }

    public void clearAllSelections(){
        for (PasswordEntity mItem: passwordEntityList) {
            mItem.setSelected(false);
        }
        notifyDataSetChanged();
    }
    public List<PasswordEntity> getPasswordEntityList(){
        return this.passwordEntityList;
    }

}