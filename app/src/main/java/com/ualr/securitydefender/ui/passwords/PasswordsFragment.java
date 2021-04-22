package com.ualr.securitydefender.ui.passwords;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ualr.securitydefender.R;

public class PasswordsFragment extends Fragment {

    private PasswordsViewModel passwordsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        passwordsViewModel =
                new ViewModelProvider(this).get(PasswordsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_passwords, container, false);
        final TextView textView = root.findViewById(R.id.text_passwords);
        passwordsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}