package com.mobilesoftware.zekaoyunu.presentation.game;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mobilesoftware.zekaoyunu.R;
import com.mobilesoftware.zekaoyunu.databinding.FragmentGameBinding;
;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class GameFragment extends Fragment {

    private FragmentGameBinding binding;

    private GameViewModel gameViewModel;

    private NavController navController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentGameBinding.inflate(inflater);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init();

        observers();

        // Ya geri tuşuna basılırsa ?
    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }

    public void init() {

        gameViewModel = new ViewModelProvider(this).get(GameViewModel.class);

        navController = Navigation.findNavController(binding.getRoot());

//        gameViewModel.checkArgument(getArguments());

    }

    public void observers() {

        gameViewModel.getArgumentError().observe(getViewLifecycleOwner(), isError -> {

            if(isError) navigateToMainOnError();

        });

    }

    public void navigateToMainOnError() {

        Toast.makeText(requireActivity(), requireActivity().getString(R.string.unknownError), Toast.LENGTH_SHORT).show();

        navController.navigate(R.id.action_gameFragment_to_mainFragment);

    }

}