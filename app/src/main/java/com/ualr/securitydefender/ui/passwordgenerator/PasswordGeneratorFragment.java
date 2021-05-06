package com.ualr.securitydefender.ui.passwordgenerator;

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

public class PasswordGeneratorFragment extends Fragment {

    private PasswordGeneratorViewModel passwordGeneratorViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        passwordGeneratorViewModel =
                new ViewModelProvider(this).get(PasswordGeneratorViewModel.class);
        View root = inflater.inflate(R.layout.fragment_password_generator, container, false);

        return root;
    }
}