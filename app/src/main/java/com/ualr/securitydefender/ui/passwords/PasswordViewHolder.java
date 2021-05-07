package com.ualr.securitydefender.ui.passwords;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textview.MaterialTextView;
import com.ualr.securitydefender.R;

public class PasswordViewHolder extends RecyclerView.ViewHolder {

    private TextView websiteIcon;
    private TextView websiteTitle;
    private TextView usernameValue;
    private EditText passwordValue;
    public View lyt_parent;
    private PasswordRecyclerAdapter mAdapter;

    public PasswordViewHolder(@NonNull View itemView) {
        super(itemView);
        this.websiteIcon = itemView.findViewById(R.id.icon);
        this.websiteTitle = itemView.findViewById(R.id.website_value);
        this.usernameValue = itemView.findViewById(R.id.username_value);
        this.passwordValue = itemView.findViewById(R.id.password_value);
        this.passwordValue.setKeyListener(null);
        lyt_parent = itemView.findViewById(R.id.lyt_parent);

        lyt_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.getmListener().onItemClick(v, mAdapter.getPasswordEntityList().get(getLayoutPosition()), getLayoutPosition());
            }
        });
    }
    //SETTERS

    public void setUsernameValue(String username) {
        this.usernameValue.setText(username);
    }

    public void setPasswordValue(String password) {
        this.passwordValue.setText(password);
    }
    /* Icon is from PasswordEntity's websiteIconLetter variable, which is initialized when
     *  PasswordEntity's website String variable is set */
    public void setWebsiteIcon(String icon) {
        this.websiteIcon.setText(icon);

    }

    public void setWebsiteName(String websiteName) {
        this.websiteTitle.setText(websiteName);
    }
    //GETTERS

    public TextView getWebsiteIcon() {
        return websiteIcon;
    }

    public TextView getWebsiteTitle() {
        return websiteTitle;
    }

    public TextView getUsernameValue() {
        return usernameValue;
    }

    public EditText getPasswordValue() {
        return passwordValue;
    }




}
