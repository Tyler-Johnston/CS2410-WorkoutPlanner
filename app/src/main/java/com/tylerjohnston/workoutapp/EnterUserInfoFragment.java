package com.tylerjohnston.workoutapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.tylerjohnston.workoutapp.ViewModels.PlanViewModel;
import com.tylerjohnston.workoutapp.ViewModels.UserViewModel;
import com.tylerjohnston.workoutapp.databinding.FragmentEnterUserInfoBinding;

import java.util.Locale;

public class EnterUserInfoFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentEnterUserInfoBinding binding = FragmentEnterUserInfoBinding.inflate(inflater, container, false);


        binding.saveUserInfoButton.setOnClickListener(view -> {

            try {

                String name = binding.enterName.getText().toString();
                String gender = binding.enterGender.getText().toString();
                gender = gender.toLowerCase(Locale.ROOT);

                if (!(gender.equals("male") || gender.equals("female"))) {
                    throw new Exception("invalid gender");
                }
                String tempWeight = binding.enterWeight.getText().toString();
                double weight = Double.parseDouble(tempWeight);
                String tempHeight = binding.enterHeight.getText().toString();
                double height = Double.parseDouble(tempHeight);
                String tempAge = binding.enterAge.getText().toString();
                double age = Double.parseDouble(tempAge);
                String tempWorkOutIntensity = binding.enterWorkoutIntensity.getText().toString();
                int workOutIntensity = Integer.parseInt(tempWorkOutIntensity);

                if (workOutIntensity < 1 || workOutIntensity > 4) {
                    throw new Exception("invalid workout intensity");
                }

                binding.userInfoErrorMessage.setText("");

                UserViewModel viewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);
                viewModel.createUser(gender, weight, height, age, workOutIntensity, name);
                getActivity().getSupportFragmentManager().popBackStack();

            } catch (Exception ex) {
                binding.userInfoErrorMessage.setText("Oh no! The information you entered was not valid. Make sure you type exactly \"male\" or \"female\", the workout intensity is within the specified range, and everything else is a number-value.");
            }

        });

        return binding.getRoot();

    }


}
