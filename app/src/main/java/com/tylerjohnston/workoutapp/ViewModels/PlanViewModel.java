package com.tylerjohnston.workoutapp.ViewModels;

import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.ViewModel;

import com.tylerjohnston.workoutapp.Models.Plan;

public class PlanViewModel extends ViewModel {

    private ObservableArrayList<Plan> plans = new ObservableArrayList<>();

    public ObservableArrayList<Plan> getPlans() {
        return plans;
    }

    public void createPlan(String[] contents) {

        Plan newPlan = new Plan();
        newPlan.Sunday = contents[0];
        newPlan.Monday = contents[1];
        newPlan.Tuesday = contents[2];
        newPlan.Wednesday = contents[3];
        newPlan.Thursday = contents[4];
        newPlan.Friday = contents[5];
        newPlan.Saturday = contents[6];
        newPlan.Title = contents[7];

        String[] week = {"Sunday: ", "Monday: ", "Tuesday: ", "Wednesday: ", "Thursday: ", "Friday: ", "Saturday: "};

        String buildDesc = "";
        for (int i = 0; i < 7; i++) {
            buildDesc = buildDesc + week[i] + contents[i] + "\n";
        }
        newPlan.Description = buildDesc;

        // add to database
        plans.add(newPlan);

    }

    public void deletePlan(int index) {
        plans.remove(plans.get(index));
    }


}
