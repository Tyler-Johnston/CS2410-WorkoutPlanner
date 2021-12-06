package com.tylerjohnston.workoutapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.tylerjohnston.workoutapp.Models.User;
import com.tylerjohnston.workoutapp.ViewModels.UserViewModel;
import com.tylerjohnston.workoutapp.databinding.FragmentUserInfoBinding;

public class UserInfoFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentUserInfoBinding binding = FragmentUserInfoBinding.inflate(inflater, container, false);

        UserViewModel viewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);
        User user = viewModel.getUser();


        binding.enterUserInfoButton.setOnClickListener(view -> {

            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_view, EnterUserInfoFragment.class, null)
                    .addToBackStack(null)
                    .commit();
        });

        if (user.isFilled) {
            binding.userName.setText(user.Name);
            binding.calorieDescription.setText("Based on your personal information, you would need to consume " + user.Calories + " calories to maintain your current body weight");

        }

        return binding.getRoot();

    }
}
