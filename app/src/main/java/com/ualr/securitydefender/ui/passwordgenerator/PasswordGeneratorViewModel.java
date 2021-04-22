package com.ualr.securitydefender.ui.passwordgenerator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PasswordGeneratorViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PasswordGeneratorViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}