package com.mobilesoftware.zekaoyunu.domain.use_case.levelgame_permission;

import com.mobilesoftware.zekaoyunu.domain.repository.MindGameRepository;

import javax.inject.Inject;

import dagger.hilt.android.scopes.ViewModelScoped;

@ViewModelScoped
public class LevelGamePermissionUseCase {

    private final MindGameRepository repository;

    @Inject
    public LevelGamePermissionUseCase(MindGameRepository repository) { this.repository = repository; }

    public boolean execute() { return repository.getUserCoin() > 0; }

}
