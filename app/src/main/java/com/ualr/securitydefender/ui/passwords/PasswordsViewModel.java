package com.ualr.securitydefender.ui.passwords;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import com.ualr.securitydefender.data.Database;
import com.ualr.securitydefender.data.PasswordDAO;
import com.ualr.securitydefender.data.PasswordEntity;
import com.ualr.securitydefender.data.Repository;
//import com.ualr.securitydefender.data.UserpassGenerator;

import java.util.ArrayList;
import java.util.List;

public class PasswordsViewModel extends ViewModel {
    //holds data for recyclerview
    private Repository repository;

    private static final int NOT_SELECTED = -1;
    private int passwordIndex = NOT_SELECTED;

//    private MediatorLiveData<List<PasswordEntity>> passwords = null;
//    private MutableLiveData<List<PasswordEntity>> passwords = new MutableLiveData<>();
//    private UserpassGenerator passGen = new UserpassGenerator();

    private MutableLiveData<List<PasswordEntity>> passwords = new MutableLiveData<>(new ArrayList<>());

    private MutableLiveData<Integer> selectedIndex = new MutableLiveData<>(NOT_SELECTED);

    public PasswordsViewModel(@NonNull Application application) {
        super();
        //repository = new Repository(application);
        //passwords = repository.getAllPasswords();
    }

    public PasswordsViewModel() {}
    public void setGeneratedPasswords() {}

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

    public void selectPasswordAtPos(int pos) {
        List<PasswordEntity> passwordList = passwords.getValue();
        if (passwordIndex != NOT_SELECTED) {
            passwordList.get(passwordIndex).setSelected(false);
        }
        passwordList.get(pos).toggleSelection();
        passwords.setValue(passwordList);
    }

    public void insert(PasswordEntity passwordEntity){
        repository.addPassword(passwordEntity);
    }

    public void update(PasswordEntity passwordEntity){
        repository.updatePassword((passwordEntity));
    }

    public void delete(PasswordEntity passwordEntity){
        repository.deletePassword(passwordEntity);
    }
}