//package com.tylerjohnston.workoutapp;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.fragment.app.Fragment;
//import androidx.lifecycle.ViewModelProvider;
//
//import com.tylerjohnston.workoutapp.ViewModels.PlanViewModel;
//import com.tylerjohnston.workoutapp.databinding.FragmentRemovePlanBinding;
//
//public class RemovePlanFragment extends Fragment {
//
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        FragmentRemovePlanBinding binding = FragmentRemovePlanBinding.inflate(inflater, container, false);
//        PlanViewModel viewModel = new ViewModelProvider(requireActivity()).get(PlanViewModel.class);
//
//        binding.saveRemovedPlan.setOnClickListener(view -> {
//
//            try {
//                String planIDToRemove = binding.removePlanEditText.getText().toString();
//                viewModel.deletePlan(Integer.valueOf(planIDToRemove));
//            }
//            catch(Exception ex) {
//            }
//            getActivity().getSupportFragmentManager().popBackStack();
//
//        });
//        return binding.getRoot();
//
//    }
//
//}
