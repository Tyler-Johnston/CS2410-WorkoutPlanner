package com.tylerjohnston.workoutapp.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.tylerjohnston.workoutapp.Models.User;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDataAccessObject getUserDao();
}
