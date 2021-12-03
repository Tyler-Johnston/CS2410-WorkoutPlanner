package com.tylerjohnston.workoutapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import com.tylerjohnston.workoutapp.databinding.FragmentUserInfoBinding;

public class UserInfoFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentUserInfoBinding binding = FragmentUserInfoBinding.inflate(inflater, container, false);

        return binding.getRoot();

    }
}
