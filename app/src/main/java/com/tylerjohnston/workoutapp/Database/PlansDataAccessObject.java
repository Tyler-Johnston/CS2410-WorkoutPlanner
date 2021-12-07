package com.tylerjohnston.workoutapp.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.tylerjohnston.workoutapp.Models.Plan;

import java.util.List;

@Dao
public interface PlansDataAccessObject {

    @Insert
    public long create(Plan plan);

    @Query("SELECT * FROM `plan`")
    public List<Plan> getALl();

    @Update
    public void update(Plan plan);

    @Delete
    public void delete(Plan plan);

}
