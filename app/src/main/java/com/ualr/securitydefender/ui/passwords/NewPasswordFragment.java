package com.ualr.securitydefender.ui.passwords;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;
import com.ualr.securitydefender.R;
import com.ualr.securitydefender.data.PasswordEntity;


public class NewPasswordFragment extends Fragment {
    private MaterialButton createPasswordButton;
    private PasswordsViewModel vm;
    private MaterialTextView newPasswordTextview;
    private MaterialTextView usernameTextview;
    private MaterialTextView passwordTextview;
    private MaterialTextView websiteTextview;
    private TextInputEditText usernameEditText;
    private TextInputEditText passwordEditText;
    private TextInputEditText websiteEditText;

    public NewPasswordFragment(PasswordsViewModel vm) {
        this.vm = vm;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        this.vm = new ViewModelProvider(requireActivity()).get(PasswordsViewModel.class);
        this.createPasswordButton = view.findViewById(R.id.new_password_create_button);
        this.usernameEditText = view.findViewById(R.id.new_username_edittext);
        this.passwordEditText = view.findViewById(R.id.new_password_edittext);
        this.websiteEditText = view.findViewById(R.id.new_website_edittext);
        this.createPasswordButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                PasswordEntity passwordEntity = new PasswordEntity();
                passwordEntity.setUsername(usernameEditText.getEditableText().toString());
                passwordEntity.setPassword(passwordEditText.getEditableText().toString());
                passwordEntity.setWebsite(websiteEditText.getEditableText().toString());
                vm.getPasswords().getValue().add(passwordEntity);
                goBack();
            }
        });
    }

    private void goBack() {
        this.getParentFragmentManager().beginTransaction()
                .replace(this.getId(), new PasswordsFragment(this.vm)).commitNow();
    }
}
