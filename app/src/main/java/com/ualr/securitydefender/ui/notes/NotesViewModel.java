package com.ualr.securitydefender.ui.notes;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ualr.securitydefender.data.NoteEntity;
import com.ualr.securitydefender.data.PasswordEntity;

import java.util.List;

public class NotesViewModel extends ViewModel {

    private MediatorLiveData<List<NoteEntity>> notes = null;
    private MutableLiveData<String> mText;
    private MutableLiveData<List<NoteEntity>> noteEntityList = new MutableLiveData<>();

    public NotesViewModel(@NonNull Application application) {
        super();
    }

    public NotesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notes fragment");
        this.noteEntityList = new MediatorLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
    public MutableLiveData<List<NoteEntity>> getNotes() {
        return this.noteEntityList;
    }
}