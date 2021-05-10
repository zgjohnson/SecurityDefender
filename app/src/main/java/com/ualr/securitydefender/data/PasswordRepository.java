package com.ualr.securitydefender.data;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class PasswordRepository {
    private PasswordDAO passwordDAO;

    private LiveData<List<PasswordEntity>> allPasswords;


    public PasswordRepository(Application application) {
        Database database = Database.getDatabase(application);

        passwordDAO = database.passwordDAO();

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


}
