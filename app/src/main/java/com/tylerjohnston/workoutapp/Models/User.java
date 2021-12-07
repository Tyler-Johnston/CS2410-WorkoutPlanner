package com.tylerjohnston.workoutapp.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo
    public String Name;
    @ColumnInfo
    public String Gender;
    @ColumnInfo
    public double Weight;
    @ColumnInfo
    public double Age;
    @ColumnInfo
    public double Height;
    @ColumnInfo
    public double Calories;
    @ColumnInfo
    public boolean isFilled;
}
