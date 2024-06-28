package com.mobilesoftware.zekaoyunu.domain.model;

import androidx.annotation.Nullable;

import com.mobilesoftware.zekaoyunu.domain.enums.game.settings.GameMode;
import com.mobilesoftware.zekaoyunu.domain.enums.game.settings.GameType;

import java.io.Serializable;

public class GameSettings implements Serializable {

    private GameMode gameMode;

    private @Nullable GameType gameType;

    private final Boolean isAlwaysRandom;

    private Integer level;

    private @Nullable Integer showSpeed;

    private @Nullable Integer showRange;

    public GameSettings(GameMode gameMode, @Nullable GameType gameType, Boolean isAlwaysRandom, Integer level, @Nullable Integer showSpeed, @Nullable Integer showRange) {
        this.gameMode = gameMode;
        this.gameType = gameType;
        this.isAlwaysRandom = isAlwaysRandom;
        this.level = level;
        this.showSpeed = showSpeed;
        this.showRange = showRange;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    @Nullable
    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(@Nullable GameType gameType) {
        this.gameType = gameType;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Nullable
    public Integer getShowSpeed() {
        return showSpeed;
    }

    public void setShowSpeed(@Nullable Integer showSpeed) {
        this.showSpeed = showSpeed;
    }

    @Nullable
    public Integer getShowRange() {
        return showRange;
    }

    public void setShowRange(@Nullable Integer showRange) {
        this.showRange = showRange;
    }

    public Boolean getAlwaysRandom() { return isAlwaysRandom; }

}
