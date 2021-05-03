package com.ualr.securitydefender.data;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
@androidx.room.Database(version = 1, entities = {PasswordEntity.class, NoteEntity.class}, exportSchema = false)
public abstract class Database extends RoomDatabase {
    private static Database database;
    public static Database getDatabase(Context context) {
      if (database == null){
          database = Room.databaseBuilder(context.getApplicationContext(), Database.class, "Application Database").build();
        }
      return database;
    }
    public static void deleteDatabase(){
        database = null;
    }
}
