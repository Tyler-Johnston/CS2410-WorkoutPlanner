package com.tylerjohnston.workoutapp.ViewModels;

import android.app.Application;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import com.tylerjohnston.workoutapp.Database.AppDatabase;
import com.tylerjohnston.workoutapp.Database.UserDatabase;
import com.tylerjohnston.workoutapp.Models.User;

public class UserViewModel extends AndroidViewModel {

    private User user = new User();

    private UserDatabase db;
    private Handler handler;

    public UserViewModel(@NonNull Application application) {
        super(application);
        user.isFilled = false;
        db = Room.databaseBuilder(application, UserDatabase.class, "userdb").build();
        handler = new Handler();
    }

    public void createUser(String gender, double weight, double height, double age, int workoutIntensity, String name) {

        new Thread(() -> {

            double offset;
            double BMR;
            double requiredCalories;

            if (workoutIntensity == 1) {
                offset = 1.2;
            } else if (workoutIntensity == 2) {
                offset = 1.4;
            } else if (workoutIntensity == 3) {
                offset = 1.6;
            } else {
                offset = 1.75;
            }

            if (gender.equals("male")) {
                BMR = (10*weight) + (6.25*height) - (5*age) + 5;
            } else {
                BMR = (10*weight) + (6.25*height) - (5*age) - 161;
            }

            requiredCalories = Math.round(BMR * offset);
            user.Gender = gender;
            user.Weight = weight;
            user.Height = height;
            user.Age = age;
            user.Name = name;
            user.isFilled = true;
            user.Calories = requiredCalories;
            user.id = db.getUserDao().create(user);

        }).start();
    }

    public User getUser() {
        return user;
    }

}
