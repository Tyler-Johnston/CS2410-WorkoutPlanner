package com.tylerjohnston.workoutapp.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.tylerjohnston.workoutapp.Models.User;

import java.util.List;

@Dao
public interface UserDataAccessObject {

    @Insert
    public long create(User user);

//    @Query("SELECT * FROM 'User'")
//    public List<User> getALl();

    @Query("SELECT * FROM 'User' WHERE id = :id")
    public User getOne(long id);

    @Update
    public void update(User user);

    @Delete
    public void delete(User user);
}
