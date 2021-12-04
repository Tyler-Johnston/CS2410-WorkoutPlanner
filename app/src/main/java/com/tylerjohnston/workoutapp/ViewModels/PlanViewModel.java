package com.tylerjohnston.workoutapp.ViewModels;

import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.ViewModel;

import com.tylerjohnston.workoutapp.Models.Plan;

public class PlanViewModel extends ViewModel {

    // Nov 19th lecture

    private ObservableArrayList<Plan> plans = new ObservableArrayList<>();

    public ObservableArrayList<Plan> getPlans() {
        return plans;
    }

    public void createPlan(String[] contents) {

        Plan newPlan = new Plan();
        newPlan.Monday = contents[0];
        newPlan.Tuesday = contents[1];
        newPlan.Wednesday = contents[2];
        newPlan.Thursday = contents[3];
        newPlan.Friday = contents[4];
        newPlan.Saturday = contents[5];
        newPlan.Sunday = contents[6];
        newPlan.Title = contents[7];

        String[] week = {"Monday: ", "Tuesday: ", "Wednesday: ", "Thursday: ", "Friday: ", "Saturday: ", "Sunday: "};

        String buildDesc = "";
        for (int i = 0; i < 7; i++) {
            buildDesc = buildDesc + week[i] + contents[i] + "\n";
        }
        newPlan.Description = buildDesc;

        // add to data base
        plans.add(newPlan);

    }

    public void deletePlan(Plan plan) {

    }

    public void updatePlan(Plan plan, String newContent) {

    }


}
