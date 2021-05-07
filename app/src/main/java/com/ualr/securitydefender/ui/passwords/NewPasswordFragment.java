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
        this.passwordsViewModel = new ViewModelProvider(requireActivity()).get(PasswordsViewModel.class);
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
                passwordEntity.setSelected(false);



                List<PasswordEntity> currentPasswordItems = passwordsViewModel.getPasswords().getValue();
                if (currentPasswordItems != null) {
                    currentPasswordItems.add(0,passwordEntity);
                }
                passwordsViewModel.setPasswords(currentPasswordItems);
                goBack();
            }
        });
    }

    public void dismissFragment() {
        this.dismiss();
    }
    private void goBack() {
//        this.getParentFragmentManager().beginTransaction()
//                .replace(this.getId(), new PasswordsFragment(this.passwordsViewModel)).commitNow();

        FragmentManager fm = getParentFragmentManager();
        PasswordsFragment pf = new PasswordsFragment(passwordsViewModel);
        fm.beginTransaction().show(pf).commitNow();

    }
}
