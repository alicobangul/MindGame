package com.mobilesoftware.zekaoyunu.domain.use_case.create_levelmode;

import com.mobilesoftware.zekaoyunu.domain.enums.game.settings.GameMode;
import com.mobilesoftware.zekaoyunu.domain.enums.game.settings.GameType;
import com.mobilesoftware.zekaoyunu.domain.model.GameSettings;
import com.mobilesoftware.zekaoyunu.domain.repository.MindGameRepository;
import javax.inject.Inject;

import dagger.hilt.android.scopes.ViewModelScoped;

@ViewModelScoped
public class CreateLevelModeUseCase {

    private final MindGameRepository repository;

    @Inject
    public CreateLevelModeUseCase(MindGameRepository repository) { this.repository = repository; }

    public GameSettings execute() {

        return new GameSettings(
                GameMode.LEVEL,
                GameType.RANDOM,
                true,
                repository.getLevel(),
                null,
                null);

    }

}
