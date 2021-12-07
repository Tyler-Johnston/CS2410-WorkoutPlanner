package com.tylerjohnston.workoutapp.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Plan {

    @PrimaryKey(autoGenerate = true)
    public long id;
    @ColumnInfo
    public String Title;
    @ColumnInfo
    public String Sunday;
    @ColumnInfo
    public String Monday;
    @ColumnInfo
    public String Tuesday;
    @ColumnInfo
    public String Wednesday;
    @ColumnInfo
    public String Thursday;
    @ColumnInfo
    public String Friday;
    @ColumnInfo
    public String Saturday;
    @ColumnInfo
    public String Description;

}
