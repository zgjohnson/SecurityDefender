package com.ualr.securitydefender.data;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Repository {
    private PasswordDAO passwordDAO;
    private NoteDAO noteDAO;
    private LiveData<List<PasswordEntity>> allPasswords;
    private LiveData<List<NoteEntity>> allNotes;

    public Repository(Application application) {
        Database database = Database.getDatabase(application);
        noteDAO = database.noteDAO();
        passwordDAO = database.passwordDAO();
        allNotes = noteDAO.getAllNotes();
        allPasswords = passwordDAO.getAllPasswords();
    }

    public void addPassword(PasswordEntity passwordEntity){
        new InsertPasswordAsyncTask(passwordDAO).execute(passwordEntity);

    }

    public void updatePassword(PasswordEntity passwordEntity){
        new UpdatePasswordAsyncTask(passwordDAO).execute(passwordEntity);

    }

    public void deletePassword(PasswordEntity passwordEntity){
        new DeletePasswordAsyncTask(passwordDAO).execute(passwordEntity);

    }

    public LiveData<List<PasswordEntity>> getAllPasswords(){
        return allPasswords;
    }

    private static class InsertPasswordAsyncTask extends AsyncTask<PasswordEntity, Void, Void> {
        private PasswordDAO passwordDAO;

        private InsertPasswordAsyncTask(PasswordDAO passwordDAO){
            this.passwordDAO = passwordDAO;
        }

        @Override
        protected Void doInBackground(PasswordEntity... passwordEntities) {
            passwordDAO.addPassword(passwordEntities[0]);
            return null;
        }
    }
    private static class UpdatePasswordAsyncTask extends AsyncTask<PasswordEntity, Void, Void> {
        private PasswordDAO passwordDAO;

        private UpdatePasswordAsyncTask(PasswordDAO passwordDAO){
            this.passwordDAO = passwordDAO;
        }

        @Override
        protected Void doInBackground(PasswordEntity... passwordEntities) {
            passwordDAO.updatePassword(passwordEntities[0]);
            return null;
        }
    }
    private static class DeletePasswordAsyncTask extends AsyncTask<PasswordEntity, Void, Void> {
        private PasswordDAO passwordDAO;

        private DeletePasswordAsyncTask(PasswordDAO passwordDAO){
            this.passwordDAO = passwordDAO;
        }

        @Override
        protected Void doInBackground(PasswordEntity... passwordEntities) {
            passwordDAO.deletePassword(passwordEntities[0]);
            return null;
        }
    }

    public void addNote(NoteEntity noteEntity){
        new InsertNoteAsyncTask(noteDAO).execute(noteEntity);

    }
    public void updateNote(NoteEntity noteEntity){
        new UpdateNoteAsyncTask(noteDAO).execute(noteEntity);

    }
    public void deleteNote(NoteEntity noteEntity){
        new DeleteNoteAsyncTask(noteDAO).execute(noteEntity);

    }

    public LiveData<List<NoteEntity>> getAllNotes(){
        return allNotes;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<NoteEntity, Void, Void> {
        private NoteDAO noteDAO;

        private InsertNoteAsyncTask(NoteDAO noteDAO){
            this.noteDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(NoteEntity... noteEntities) {
            noteDAO.addNote(noteEntities[0]);
            return null;
        }
    }
    private static class UpdateNoteAsyncTask extends AsyncTask<NoteEntity, Void, Void> {
        private NoteDAO noteDAO;

        private UpdateNoteAsyncTask(NoteDAO noteDAO){
            this.noteDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(NoteEntity... noteEntities) {
            noteDAO.addNote(noteEntities[0]);
            return null;
        }
    }
    private static class DeleteNoteAsyncTask extends AsyncTask<NoteEntity, Void, Void> {
        private NoteDAO noteDAO;

        private DeleteNoteAsyncTask(NoteDAO noteDAO){
            this.noteDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(NoteEntity... noteEntities) {
            noteDAO.addNote(noteEntities[0]);
            return null;
        }
    }

}
