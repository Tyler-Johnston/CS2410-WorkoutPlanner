package com.tylerjohnston.workoutapp.ViewModels;

import androidx.lifecycle.ViewModel;

import com.tylerjohnston.workoutapp.Models.User;

public class UserViewModel extends ViewModel {

    private User user = new User();

    public UserViewModel() {
        user.isFilled = false;
    }

    public void createUser(String gender, double weight, double height, double age, int workoutIntensity, String name) {


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

    }

    public User getUser() {
        return user;
    }

}
