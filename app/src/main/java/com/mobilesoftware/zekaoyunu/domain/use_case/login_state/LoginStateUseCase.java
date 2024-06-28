package com.mobilesoftware.zekaoyunu.domain.use_case.login_state;

import com.mobilesoftware.zekaoyunu.domain.repository.MindGameRepository;
import com.mobilesoftware.zekaoyunu.presentation.main.MainState;
import com.mobilesoftware.zekaoyunu.presentation.main.MainStateEnums;

import javax.inject.Inject;

import dagger.hilt.android.scopes.ViewModelScoped;

@ViewModelScoped
public class LoginStateUseCase {

    private final MindGameRepository repository;

    @Inject
    public LoginStateUseCase(MindGameRepository repository) { this.repository = repository; }

    public MainState execute() {

        return new MainState(
                repository.getLevelText(),
                repository.getUserCoinText(),
                MainStateEnums.EMPTY
        );

    }
}
