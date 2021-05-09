package com.ualr.securitydefender.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PasswordDAO {

    @Query("SELECT * from password")
    LiveData<List<PasswordEntity>> getAllPasswords();

    @Query("SELECT * from password WHERE id = :id")
    LiveData<PasswordEntity> getPassword(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void  addPassword(PasswordEntity passwordEntity);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updatePassword(PasswordEntity passwordEntity);

    @Query("DELETE FROM password")
    void deleteAll();

    @Delete
    void deletePassword(PasswordEntity passwordEntity);
}

