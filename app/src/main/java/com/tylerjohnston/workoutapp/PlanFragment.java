package com.tylerjohnston.workoutapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.tylerjohnston.workoutapp.databinding.FragmentPlanBinding;

public class PlanFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentPlanBinding binding = FragmentPlanBinding.inflate(inflater, container, false);

        return binding.getRoot();

    }
}
