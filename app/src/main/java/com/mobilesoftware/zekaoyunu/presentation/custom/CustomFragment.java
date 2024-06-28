package com.mobilesoftware.zekaoyunu.presentation.custom;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mobilesoftware.zekaoyunu.R;
import com.mobilesoftware.zekaoyunu.databinding.FragmentCustomBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CustomFragment extends Fragment {

    private FragmentCustomBinding binding;

    private CustomViewModel customViewModel;

    private NavController navController;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentCustomBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init();

        observers();

    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }

    public void init() {

        customViewModel = new ViewModelProvider(this).get(CustomViewModel.class);

        navController = Navigation.findNavController(binding.getRoot());

        binding.setCustomViewModel(customViewModel);

        binding.setLifecycleOwner(this);

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {

            @Override
            public void handleOnBackPressed() { navController.navigate(R.id.action_customFragment_to_mainFragment); }

        });

    }

    public void observers() {

        customViewModel.getStartGameClick().observe(getViewLifecycleOwner(), gameSettings -> {

            NavDirections action = CustomFragmentDirections.actionCustomFragmentToGameFragment(gameSettings);
            navController.navigate(action);

        });

    }

}