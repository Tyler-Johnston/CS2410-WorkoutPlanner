package com.tylerjohnston.workoutapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.tylerjohnston.workoutapp.ViewModels.PlanViewModel;
import com.tylerjohnston.workoutapp.databinding.FragmentCreatePlanBinding;

public class CreatePlanFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentCreatePlanBinding binding = FragmentCreatePlanBinding.inflate(inflater, container, false);

        PlanViewModel viewModel = new ViewModelProvider(requireActivity()).get(PlanViewModel.class);
        binding.savePlan.setOnClickListener(view -> {

            binding.errorMessage.setText("");

            String title = binding.Title.getText().toString();
            String sunday = binding.SundayPlan.getText().toString();
            String monday = binding.MondayPlan.getText().toString();
            String tuesday = binding.TuesdayPlan.getText().toString();
            String wednesday = binding.WednesdayPlan.getText().toString();
            String thursday = binding.ThursdayPlan.getText().toString();
            String friday = binding.FridayPlan.getText().toString();
            String saturday = binding.SaturdayPlan.getText().toString();

            String[] contents = {sunday, monday, tuesday, wednesday, thursday, friday, saturday, title};

            if (title.equals("")) {
                binding.errorMessage.setText("Please enter a title for your plan");
            }
            else {
                viewModel.createPlan(contents);
                getActivity().getSupportFragmentManager().popBackStack();
            }

        });

        return binding.getRoot();

    }

}
