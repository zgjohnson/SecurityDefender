package com.ualr.securitydefender.ui.passwords;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ualr.securitydefender.data.PasswordEntity;
//import com.ualr.securitydefender.data.UserpassGenerator;

import java.util.ArrayList;
import java.util.List;

public class PasswordsViewModel extends ViewModel {
    //holds data for recyclerview
    private static final int NOT_SELECTED = -1;
//    private MediatorLiveData<List<PasswordEntity>> passwords = null;
//    private MutableLiveData<List<PasswordEntity>> passwords = new MutableLiveData<>();
//    private UserpassGenerator passGen = new UserpassGenerator();

    private MutableLiveData<List<PasswordEntity>> passwords = new MutableLiveData<>(new ArrayList<>());

    private MutableLiveData<Integer> selectedIndex = new MutableLiveData<>(NOT_SELECTED);

    public PasswordsViewModel(@NonNull Application application) {
        super();

    }

    public PasswordsViewModel() {

//        List<PasswordEntity> passwords = passGen.generatePasswords(5);

//        this.passwordEntityList.setValue(passwords);


    }



    public void setGeneratedPasswords() {

    }

    public LiveData<Integer> getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(int selected) {
        this.selectedIndex.setValue(selected);
    }

    public MutableLiveData<List<PasswordEntity>> getPasswords() {
        return this.passwords;
    }

    public void setPasswords(List<PasswordEntity> passwordsList) {
        this.passwords.setValue(passwordsList);
    }
}