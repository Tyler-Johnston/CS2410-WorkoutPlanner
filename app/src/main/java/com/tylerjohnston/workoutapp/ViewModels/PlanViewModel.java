package com.tylerjohnston.workoutapp.ViewModels;

import android.app.Application;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.tylerjohnston.workoutapp.Database.AppDatabase;
import com.tylerjohnston.workoutapp.Models.Plan;

import java.util.List;

public class PlanViewModel extends AndroidViewModel {

    private ObservableArrayList<Plan> plans = new ObservableArrayList<>();
    private boolean loaded = false;

    private AppDatabase db;
    private Handler handler;

    public PlanViewModel(@NonNull Application application) {
        super(application);
        db = Room.databaseBuilder(application, AppDatabase.class, "plansdb").build();
        handler = new Handler();
    }

    public ObservableArrayList<Plan> getPlans() {
        return plans;
    }

    public void loadPlans() {

        if (!loaded) {
            loaded = true;
            new Thread(() -> {
                List<Plan> planList = db.getPlansDao().getALl();
                handler.post(() -> {
                    plans.addAll(planList);
                });

            }).start();
        }
    }

    public void createPlan(String[] contents) {

        new Thread(() -> {

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
                if (!contents[i].equals("")) {
                    buildDesc = buildDesc + week[i] + contents[i] + "\n";
                }
            }
            newPlan.Description = buildDesc;
            newPlan.id = db.getPlansDao().create(newPlan);

            handler.post(() -> {
                plans.add(newPlan);
            });
        }).start();
    }

    public void deletePlan(int index) {

        new Thread(() -> {

            db.getPlansDao().delete(plans.get(index));
            handler.post(() -> {
                plans.remove(plans.get(index));
            });
        }).start();
    }

}
