package com.mobilesoftware.zekaoyunu.presentation.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.mobilesoftware.zekaoyunu.data.repository.dto.UserData;
import com.mobilesoftware.zekaoyunu.domain.model.GameSettings;
import com.mobilesoftware.zekaoyunu.domain.use_case.create_levelmode.CreateLevelModeUseCase;
import com.mobilesoftware.zekaoyunu.domain.use_case.get_userdata.GetUserDataUseCase;
import com.mobilesoftware.zekaoyunu.domain.use_case.levelgame_permission.LevelGamePermissionUseCase;
import com.mobilesoftware.zekaoyunu.domain.use_case.login_state.LoginStateUseCase;
import java.util.Objects;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends ViewModel {

    private final SavedStateHandle savedStateHandle;

    private final LoginStateUseCase loginStateUseCase;

    private final GetUserDataUseCase getUserDataUseCase;

    private final CreateLevelModeUseCase createLevelModeUseCase;

    private final LevelGamePermissionUseCase levelGamePermissionUseCase;


    @Inject
    public MainViewModel(
            SavedStateHandle savedStateHandle,
            LoginStateUseCase loginStateUseCase,
            GetUserDataUseCase getUserDataUseCase,
            CreateLevelModeUseCase createLevelModeUseCase,
            LevelGamePermissionUseCase levelGamePermissionUseCase
    ) {
        this.savedStateHandle = savedStateHandle;
        this.loginStateUseCase = loginStateUseCase;
        this.getUserDataUseCase = getUserDataUseCase;
        this.createLevelModeUseCase = createLevelModeUseCase;
        this.levelGamePermissionUseCase = levelGamePermissionUseCase;
    }

    public MutableLiveData<MainState> getState() { return savedStateHandle.getLiveData("mainState", new MainState()); }

    public void init() {

        // Mevcut state yoksa: UserData alınarak giriş ekranı için default bir state oluşturuluyor
        if (getState().getValue().getLevelText() == null) updateState(loginStateUseCase.execute());

    }

    private void updateState(MainState state) { savedStateHandle.set("mainState", state); }

    public void updateStateForDialog(MainStateEnums currentDialog) {

        updateState(
                new MainState(
                        Objects.requireNonNull(getState().getValue()).getLevelText(),
                        Objects.requireNonNull(getState().getValue()).getUserCoinText(),
                        currentDialog
                )
        );

    }

    public void getUserData() {

        UserData userData = getUserDataUseCase.execute();

        MainState newStateWithData = new MainState(
                String.valueOf(userData.getLevel()),
                String.valueOf(userData.getUserCoin())
        );

        updateState(newStateWithData);

    }

    public void startGameClicked() {

        if (levelGamePermissionUseCase.execute()) updateStateForDialog(MainStateEnums.LEVELGAMEDIALOG);

        else {
            updateStateForDialog(MainStateEnums.COINERRORHANDLING);
            updateStateForDialog(MainStateEnums.SHOPDIALOG);
        }

    }

    public void customClicked() { updateStateForDialog(MainStateEnums.CHANGESCREENFORCUSTOM); }

    public GameSettings getLevelGameModel() { return createLevelModeUseCase.execute(); }

}
