package com.ualr.securitydefender.ui.passwords;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textview.MaterialTextView;
import com.ualr.securitydefender.R;

public class PasswordViewHolder extends RecyclerView.ViewHolder {
    private MaterialTextView websiteIcon;
    private MaterialTextView websiteTitle;
    private MaterialTextView usernameTitle;
    private MaterialTextView passwordTitle;
    private MaterialTextView usernameValue;
    private MaterialTextView passwordValue;

    public PasswordViewHolder(@NonNull View itemView) {
        super(itemView);
        this.websiteIcon = itemView.findViewById(R.id.website_letter);
        this.websiteTitle = itemView.findViewById(R.id.website_title);
        this.usernameTitle = itemView.findViewById(R.id.username_title);
        this.usernameValue = itemView.findViewById(R.id.username_value);
        this.passwordTitle = itemView.findViewById(R.id.password_title);
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

    public MaterialTextView getUsernameTitle() {
        return usernameTitle;
    }

    public MaterialTextView getPasswordTitle() {
        return passwordTitle;
    }

    public MaterialTextView getUsernameValue() {
        return usernameValue;
    }

    public MaterialTextView getPasswordValue() {
        return passwordValue;
    }




}
