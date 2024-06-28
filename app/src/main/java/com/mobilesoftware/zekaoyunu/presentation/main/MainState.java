package com.mobilesoftware.zekaoyunu.presentation.main;

import java.io.Serializable;

public class MainState implements Serializable {

    private String levelText = null;

    private String userCoinText = null;

    private MainStateEnums currentDialog = MainStateEnums.EMPTY;

    public MainState() {}

    public MainState(String levelText, String userCoinText) {
        this.levelText = levelText;
        this.userCoinText = userCoinText;
    }

    public MainState(String levelText, String userCoinText, MainStateEnums currentDialog) {
        this.levelText = levelText;
        this.userCoinText = userCoinText;
        this.currentDialog = currentDialog;
    }

    public String getLevelText() { return levelText; }

    public void setLevelText(String levelText) { this.levelText = levelText; }

    public String getUserCoinText() { return userCoinText; }

    public void setUserCoinText(String userCoinText) { this.userCoinText = userCoinText; }

    public MainStateEnums getCurrentDialog() { return currentDialog; }

    public void setCurrentDialog(MainStateEnums currentDialog) { this.currentDialog = currentDialog; }

}
