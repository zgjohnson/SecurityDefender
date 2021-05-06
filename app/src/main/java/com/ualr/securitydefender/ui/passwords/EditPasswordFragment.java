package com.ualr.securitydefender.ui.passwords;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.ualr.securitydefender.R;
import com.ualr.securitydefender.data.PasswordEntity;

public class EditPasswordFragment extends DialogFragment{



    private static final String SELECTED = "selectedPassword";
    private PasswordsViewModel mPasswordViewModel;

    public static EditPasswordFragment newInstance(int selectedPassword){
        EditPasswordFragment mFragment = new EditPasswordFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(SELECTED, selectedPassword);
        mFragment.setArguments(arguments);
        return mFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPasswordViewModel = new ViewModelProvider(getActivity()).get(PasswordsViewModel.class);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.DialogStyle);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_password_edit, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final int selectedPasswordIndex = getArguments().getInt(SELECTED);
        final PasswordEntity selectedPasswordItem = mPasswordViewModel.getPasswords().getValue().get(selectedPasswordIndex);
        final TextView currentUsername = view.findViewById(R.id.current_username);
        final EditText newUsername = view.findViewById(R.id.edit_username_edittext);
        final TextView currentPassword = view.findViewById(R.id.current_password);
        final EditText newPassword = view.findViewById(R.id.edit_password_edittext);
        final TextView currentWebsite = view.findViewById(R.id.current_website);
        final EditText newWebsite = view.findViewById(R.id.edit_website_edittext);

        currentUsername.setText(selectedPasswordItem.getUsername());
        currentPassword.setText(selectedPasswordItem.getPassword());
        currentWebsite.setText(selectedPasswordItem.getWebsite());

        Button saveBtn = view.findViewById(R.id.edit_password_button);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
