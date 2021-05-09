package com.ualr.securitydefender.ui.passwordgenerator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputEditText;
import com.ualr.securitydefender.R;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PasswordGeneratorFragment extends Fragment {

    private PasswordGeneratorViewModel passwordGeneratorViewModel;

    private Button generateButton;
    private SwitchCompat upperCase;
    private SwitchCompat numbers;
    private SwitchCompat specialCharacters;
    private TextInputEditText length;
    private EditText generatedPassword;



    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        passwordGeneratorViewModel = new ViewModelProvider(getActivity()).get(PasswordGeneratorViewModel.class);
        View root = inflater.inflate(R.layout.fragment_password_generator, container, false);
        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.generateButton = view.findViewById(R.id.generatePassword);
        this.upperCase = view.findViewById(R.id.capitalsSwitch);
        this.numbers = view.findViewById(R.id.numberSwitch);
        this.specialCharacters = view.findViewById(R.id.symbolSwitch);
        this.length = view.findViewById(R.id.length_editText);
        this.generatedPassword = view.findViewById(R.id.generatedPasswordTextView);

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean useLower = true;
                boolean useUpper = false;
                boolean useNumbers = false;
                boolean useSpecialCharacters = false;
                int length_value;

                if(upperCase.isChecked()){
                    useUpper = true;
                }

                if(numbers.isChecked()){
                    useNumbers = true;
                }

                if(specialCharacters.isChecked()){
                    useSpecialCharacters = true;
                }

                length_value = Integer.parseInt(length.getText().toString());
                String password = generatePassword(length_value, useLower, useUpper, useNumbers, useSpecialCharacters);
                generatedPassword.setText(password);

            }
        });
    }

    public String generatePassword(int length, boolean useLower, boolean useUpper, boolean useNumbers, boolean useSymbols) {
        // Argument Validation.
        if (length <= 0) {
            return "";
        }

        // Variables.
        final String lowercase = "abcdefghijklmnopqrstuvwxyz";
        final String uppercase = "ABCDEFGJKLMNPRSTUVWXYZ";
        final String numbers = "0123456789";
        final String symbols = "^$?!@#%&";
        Random random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);


        // Collect the categories to use.
        List<String> charCategories = new ArrayList<>(4);
        if (useLower) {
            charCategories.add(lowercase);
        }
        if (useUpper) {
            charCategories.add(uppercase);
        }
        if (useNumbers) {
            charCategories.add(numbers);
        }
        if (useSymbols) {
            charCategories.add(symbols);
        }

        // Build the password.
        for (int i = 0; i < length; i++) {
            String charCategory = charCategories.get(random.nextInt(charCategories.size()));
            int position = random.nextInt(charCategory.length());
            password.append(charCategory.charAt(position));
        }
        return new String(password);
    }
}