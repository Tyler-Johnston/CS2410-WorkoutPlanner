package com.tylerjohnston.workoutapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.tylerjohnston.workoutapp.Models.Plan;
import com.tylerjohnston.workoutapp.ViewModels.PlanViewModel;
import com.tylerjohnston.workoutapp.databinding.FragmentPlanBinding;

public class PlanFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentPlanBinding binding = FragmentPlanBinding.inflate(inflater, container, false);

        PlanViewModel viewModel = new ViewModelProvider(requireActivity()).get(PlanViewModel.class);
        ObservableArrayList<Plan> plans = viewModel.getPlans();

        viewModel.loadPlans();

        binding.planHint.setText("");
        
        binding.createPlanButton.setOnClickListener(view -> {
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_view, CreatePlanFragment.class, null)
                    .addToBackStack(null)
                    .commit();
        });

        binding.removePlanButton.setOnClickListener(view -> {

            try {
                viewModel.deletePlan(0);
            }
            catch(Exception ex) {
            }

            if (plans.size() == 0) {
                binding.planHint.setText("Click the \"+\" icon to generate a new plan\n\nClick the \"-\" icon to remove your current plan upon completion");
            }

        });

        if (plans.size() != 0) {
            binding.planHint.setText("");
        }

        binding.planRecyclerView.setAdapter(new PlansAdapter(plans));
        binding.planRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return binding.getRoot();

    }
}
