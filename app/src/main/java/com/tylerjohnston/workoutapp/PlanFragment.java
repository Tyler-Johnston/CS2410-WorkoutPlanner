package com.tylerjohnston.workoutapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

        binding.createPlanButton.setOnClickListener(view -> {
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_view, CreatePlanFragment.class, null)
                    .addToBackStack(null)
                    .commit();
        });

        binding.viewPlanIdeasButton.setOnClickListener(view -> {
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_view, ViewPlanIdeasFragment.class, null)
                    .addToBackStack(null)
                    .commit();
        });

        PlanViewModel viewModel = new ViewModelProvider(requireActivity()).get(PlanViewModel.class);

        ObservableArrayList<Plan> plans = viewModel.getPlans();
        binding.planRecyclerView.setAdapter(new PlansAdapter(plans));
        binding.planRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));




        return binding.getRoot();

    }
}
