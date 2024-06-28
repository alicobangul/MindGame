package com.mobilesoftware.zekaoyunu.data.repository.dto;

public class UserData {

    private final int level;

    private final int userCoin;

    private final int bonusNewQuestion;

    private final int bonusHalf;

    private final int bonusAddTime;

    private final int bonusStopTime;

    public UserData(int level, int userCoin, int bonusNewQuestion, int bonusHalf, int bonusAddTime, int bonusStopTime) {
        this.level = level;
        this.userCoin = userCoin;
        this.bonusNewQuestion = bonusNewQuestion;
        this.bonusHalf = bonusHalf;
        this.bonusAddTime = bonusAddTime;
        this.bonusStopTime = bonusStopTime;
    }

    public int getLevel() { return level; }

    public int getUserCoin() {return userCoin;}

    public int getBonusNewQuestion() {return bonusNewQuestion;}

    public int getBonusHalf() {return bonusHalf;}

    public int getBonusAddTime() {return bonusAddTime;}

    public int getBonusStopTime() {return bonusStopTime;}

}
