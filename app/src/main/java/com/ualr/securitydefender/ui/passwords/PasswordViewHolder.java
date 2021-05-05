package com.ualr.securitydefender.ui.passwords;

import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textview.MaterialTextView;
import com.ualr.securitydefender.R;

public class PasswordViewHolder extends RecyclerView.ViewHolder {

    private MaterialTextView websiteIcon;
    private MaterialTextView websiteTitle;
    private MaterialTextView usernameValue;
    private EditText passwordValue;

    public PasswordViewHolder(@NonNull View itemView) {
        super(itemView);
        this.websiteIcon = itemView.findViewById(R.id.icon);
        this.websiteTitle = itemView.findViewById(R.id.website_value);
        this.usernameValue = itemView.findViewById(R.id.username_value);
        this.passwordValue = itemView.findViewById(R.id.password_value);
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

    public MaterialTextView getWebsiteIcon() {
        return websiteIcon;
    }

    public MaterialTextView getWebsiteTitle() {
        return websiteTitle;
    }

    public MaterialTextView getUsernameValue() {
        return usernameValue;
    }

    public EditText getPasswordValue() {
        return passwordValue;
    }




}
