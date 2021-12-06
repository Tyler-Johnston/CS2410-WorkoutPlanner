package com.tylerjohnston.workoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import androidx.fragment.app.Fragment;

import com.tylerjohnston.workoutapp.databinding.FragmentCalendarBinding;

public class CalendarFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentCalendarBinding binding = FragmentCalendarBinding.inflate(inflater, container, false);

        return binding.getRoot();

    }
}
