package com.mobilesoftware.zekaoyunu.presentation.question;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mobilesoftware.zekaoyunu.databinding.FragmentQuestionBinding;
import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class QuestionFragment extends Fragment{

    private FragmentQuestionBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentQuestionBinding.inflate(inflater);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }
}