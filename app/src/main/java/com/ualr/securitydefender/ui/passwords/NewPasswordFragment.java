package com.ualr.securitydefender.ui.passwords;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;
import com.ualr.securitydefender.R;
import com.ualr.securitydefender.data.PasswordEntity;

import java.util.List;


public class NewPasswordFragment extends DialogFragment {
    private static final String PASSWORDS_LIST_FRAGMENT_TAG = "PasswordsFragment";
    private MaterialButton createPasswordButton;
    private PasswordsViewModel passwordsViewModel;
    private PasswordRecyclerAdapter mAdapter;
    private MaterialTextView newPasswordTextview;
    private MaterialTextView usernameTextview;
    private MaterialTextView passwordTextview;
    private MaterialTextView websiteTextview;
    private TextInputEditText usernameEditText;
    private TextInputEditText passwordEditText;
    private TextInputEditText websiteEditText;

    public NewPasswordFragment(PasswordsViewModel vm) {
        this.passwordsViewModel = vm;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.DialogStyle);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_password_add, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.passwordsViewModel = new ViewModelProvider(getActivity()).get(PasswordsViewModel.class);
        this.createPasswordButton = view.findViewById(R.id.new_password_create_button);
        this.usernameEditText = view.findViewById(R.id.new_username_edittext);
        this.passwordEditText = view.findViewById(R.id.new_password_edittext);
        this.websiteEditText = view.findViewById(R.id.new_website_edittext);

        this.createPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getEditableText().toString();
                String password = passwordEditText.getEditableText().toString();
                String website = websiteEditText.getEditableText().toString();
                boolean selected = false;
                PasswordEntity passwordEntity = new PasswordEntity(username,password,website,selected);




                List<PasswordEntity> currentPasswordItems = passwordsViewModel.getPasswords().getValue();
                if (currentPasswordItems != null) {
                    currentPasswordItems.add(0,passwordEntity);
                }

                //passwordsViewModel.setPasswords(currentPasswordItems);
                passwordsViewModel.insert(passwordEntity);
                dismissFragment();
            }
        });
    }

    public void dismissFragment() {
        this.dismiss();
    }

}
