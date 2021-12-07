package com.tylerjohnston.workoutapp.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.tylerjohnston.workoutapp.Models.Plan;

@Database(entities = {Plan.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract PlansDataAccessObject getPlansDao();

}
