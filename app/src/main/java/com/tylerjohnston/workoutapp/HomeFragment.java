package com.tylerjohnston.workoutapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.tylerjohnston.workoutapp.Models.Plan;
import com.tylerjohnston.workoutapp.ViewModels.PlanViewModel;
import com.tylerjohnston.workoutapp.databinding.FragmentHomeBinding;
import java.util.Calendar;

public class HomeFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentHomeBinding binding = FragmentHomeBinding.inflate(inflater, container, false);

        PlanViewModel viewModel = new ViewModelProvider(requireActivity()).get(PlanViewModel.class);
        ObservableArrayList<Plan> plans = viewModel.getPlans();

        Calendar calendar = Calendar.getInstance();
        int dayNumber = calendar.get(Calendar.DAY_OF_WEEK);

        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        String dayOfWeek = week[dayNumber-1];
        binding.welcomeMessage.setText("" + dayOfWeek + ": ");

        if (plans.size() != 0) {
            if (dayOfWeek.equals("Sunday")) {
                if (!plans.get(0).Sunday.equals("")) {
                    binding.todaysTasks.setText(plans.get(0).Sunday);
                }
            }
            else if (dayOfWeek.equals("Monday")) {
                if (!plans.get(0).Monday.equals("")) {
                    binding.todaysTasks.setText(plans.get(0).Monday);
                }
            }
            else if (dayOfWeek.equals("Tuesday")) {
                if (!plans.get(0).Tuesday.equals("")) {
                    binding.todaysTasks.setText(plans.get(0).Tuesday);
                }
            }
            else if (dayOfWeek.equals("Wednesday")) {
                if (!plans.get(0).Wednesday.equals("")) {
                    binding.todaysTasks.setText(plans.get(0).Wednesday);
                }
            }
            else if (dayOfWeek.equals("Thursday")) {
                if (!plans.get(0).Thursday.equals("")) {
                    binding.todaysTasks.setText(plans.get(0).Thursday);
                }
            }
            else if (dayOfWeek.equals("Friday")) {
                if (!plans.get(0).Friday.equals("")) {
                    binding.todaysTasks.setText(plans.get(0).Friday);
                }
            }
            else if (dayOfWeek.equals("Saturday")) {
                if (!plans.get(0).Saturday.equals("")) {
                    binding.todaysTasks.setText(plans.get(0).Saturday);
                }
            }
        }

        return binding.getRoot();

    }



}
