package com.mobilesoftware.zekaoyunu.presentation.custom;

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
public class CustomViewModel extends ViewModel {

    private final SavedStateHandle savedStateHandle;

    private final Integer EASY_SHOWSPEED = 4; // 1500ms gösterim hızı
    private final Integer MEDIUM_SHOWSPEED = 2; // 1000ms gösterim hızı
    private final Integer HARD_SHOWSPEED = 0; // 500ms gösterim hızı

    private final Integer EASY_SHOWRANGE = 0; // 4 adet gösterim
    private final Integer MEDIUM_SHOWRANGE = 3; // 7 adet gösterim
    private final Integer HARD_SHOWRANGE = 6; // 10 adet gösterim

    @Inject
    public CustomViewModel(SavedStateHandle savedStateHandle) { this.savedStateHandle = savedStateHandle; }

    public MutableLiveData<Boolean> getDifficultyVisibility() { return savedStateHandle.getLiveData("difficultyVisibility", true); }

    public MutableLiveData<Integer> getDifficultyProgress() { return savedStateHandle.getLiveData("difficultyProgress", 0); }

    public MutableLiveData<Boolean> getCustomSwitchChecked() { return savedStateHandle.getLiveData("customSwitch", false); }

    public MutableLiveData<Boolean> getCustomVisibility() { return savedStateHandle.getLiveData("customVisibility", false); }

    public MutableLiveData<Integer> getShowSpeedProgress() { return savedStateHandle.getLiveData("showSpeedProgress", 3); }

    public MutableLiveData<String> getShowSpeedText() { return savedStateHandle.getLiveData("showSpeedText", "1250"); }

    public MutableLiveData<Integer> getShowRangeProgress() { return savedStateHandle.getLiveData("showRangeProgress", 0); }

    public MutableLiveData<String> getShowRangeText() { return savedStateHandle.getLiveData("showRangeText", "4"); }

    public MutableLiveData<GameType> getGameType() { return savedStateHandle.getLiveData("gameType", GameType.COLOR); }

    private final MutableLiveData<GameSettings> _startGameClick = new MutableLiveData<>();

    public LiveData<GameSettings> getStartGameClick() { return _startGameClick; }

    public void changeDifficultyProgress(Integer progress) {

        getDifficultyProgress().setValue(progress); // Difficulty değeri kaydediliyor

        changeStatusForDifficulty(); // Difficulty durumuna göre gösterim hızı/sayısı değiştiriliyor

    }

    public void changeCustomSwitchEnabed(Boolean isChecked) {

        getDifficultyVisibility().setValue(!isChecked); // Switch açık ise; difficulty tarafı kapalı / Switch kapalı ise; difficulty tarafı açık

        getCustomVisibility().setValue(isChecked); // Efektif ayar (manuel gösterim hızı/sayısı) tarafı switch durumuna göre açık veya kapalı

        getCustomSwitchChecked().setValue(isChecked); // Switch durumu kaydediliyor

        changeStatusForDifficulty(); // Difficulty durumuna göre gösterim hızı/sayısı değiştiriliyor

    }

    public void changeStatusForDifficulty() {

        int difficultyProgress = getDifficultyProgress().getValue();

        // Show speed (Gösterim hızı) : Kolay -> 4 (1500ms) / Orta -> 2 (1000ms) / Zor -> 0 (500ms)
        changeShowSpeed(
                (difficultyProgress == 0) ? EASY_SHOWSPEED : (difficultyProgress == 1) ? MEDIUM_SHOWSPEED : HARD_SHOWSPEED
        );

        // Show range (Gösterim sayısı) : Kolay -> 4 (adet) / Orta -> 7 (adet) / Zor -> 10 (adet)
        changeShowRange(
                (difficultyProgress == 0) ? EASY_SHOWRANGE : (difficultyProgress == 1) ? MEDIUM_SHOWRANGE : HARD_SHOWRANGE
        );

    }

    public void changeShowSpeed(Integer progress) {
        getShowSpeedProgress().setValue(progress);
        getShowSpeedText().setValue(String.valueOf(500 + (progress * 250)));
    }

    public void changeShowRange(Integer progress) {
        getShowRangeProgress().setValue(progress);
        getShowRangeText().setValue(String.valueOf(progress + 4));
    }

    public void typeSelected(Boolean isChecked, GameType type) { if (isChecked) getGameType().setValue(type); }

    public void startGameClick() {

        _startGameClick.setValue(

                new GameSettings(
                        GameMode.CUSTOM,
                        getGameType().getValue(),
                        getGameType().getValue() == GameType.RANDOM,
                        1,
                        Integer.parseInt(getShowSpeedText().getValue()),
                        Integer.parseInt(getShowRangeText().getValue())
                )

        );

    }

}
