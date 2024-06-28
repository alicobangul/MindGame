package com.mobilesoftware.zekaoyunu.presentation.game;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.mobilesoftware.zekaoyunu.domain.enums.game.settings.GameMode;
import com.mobilesoftware.zekaoyunu.domain.model.GameSettings;
import com.mobilesoftware.zekaoyunu.domain.enums.game.settings.GameType;

import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class GameViewModel extends ViewModel {

    private final SavedStateHandle savedStateHandle;

    private final MutableLiveData<Boolean> _argumentError = new MutableLiveData<>(false);

    private GameSettings gameSettings;

    // Oyun hazır olduğunda isContinue true olacak
    // Belki fragment destroy view edilirkende bu destroy edilmeli handler sapıtmasın diye
    // GameFragment açıldığında eğer level modu ise 1 jeton düşmeli

    @Inject
    public GameViewModel(SavedStateHandle savedStateHandle) { this.savedStateHandle = savedStateHandle; }

    public LiveData<Boolean> getArgumentError() { return _argumentError; }

    public GameSettings getSavedGameSettings() { return savedStateHandle.get("gameSettings"); }

    public void setSavedGameSettings(GameSettings gameSettings) { savedStateHandle.set("gameSettings", gameSettings); }

    public Boolean getIsContinue() { return savedStateHandle.getLiveData("isContinue", false).getValue(); }

    public void setIsContinue(Boolean isContinue) { savedStateHandle.getLiveData("isContinue", false).setValue(isContinue); }


    public void checkArgument(@Nullable Bundle argument) {

        if (argument != null && argument.get("gameSettings") != null) {

            gameSettings = (GameSettings) argument.get("gameSettings");

            if (!getIsContinue()) firstOpen();

            else continueGame();

        }

        else _argumentError.setValue(true);

    }

    public void firstOpen() {
        // Oyun ilk defa açılıyor oyunun gösterim hızı ve gösterim sayısı ayarları yapılmalı

        changeGameSettigs();

        createGame();

    }

    public void continueGame() {
        // Oyun ilk defa açılmıyor arka plandan geri geldi
        gameSettings = savedStateHandle.get("gameSettings");

    }

    public void changeGameSettigs() {

        /**
         * Eğer level modu ve custom mod seçili ise:
         * Gösterim hızı : Level 10 ve katları ise 500ms hız, 5 ve katları ise 750ms hız diğerleri ise 1250ms hız
         * Gösterim sayısı: 10 Level ve altında 4, daha sonra her 10 levelde 1 artış.
         * Efektif mod gösterim hızı ve sayısını kendisi seçtiği için ayarlanmıyor.
         */
        if(gameSettings.getGameMode() == GameMode.LEVEL) {

            Integer showSpeed = (gameSettings.getLevel() % 10 == 0) ? 500 : (gameSettings.getLevel() % 5 == 0) ? 750 : 1250;

            Integer showRange = 4 + ( gameSettings.getLevel() / 10 );

            gameSettings.setShowSpeed(showSpeed);

            gameSettings.setShowRange(showRange);

        }

        /**
         * Eğer MainFragment'tan level modu başlatıldıysa veya CustomFragment'tan Random mod seçildi ise alwaysRandom true ayarlandı.
         * alwaysRandom kullanılmaz ise:
         * gameSettings.getGameType() == GameType.RANDOM sadece tek sefer çalışacak ve bir type belirtip sürekli onu kullanacak.
         */
        if (gameSettings.getGameType() == GameType.RANDOM || gameSettings.getAlwaysRandom()) gameSettings.setGameType(GameType.randomType());

    }

    public void createGame() {

        // Burada oyun oluşturdu ne yapacaktık onu yazıyor

    }

}