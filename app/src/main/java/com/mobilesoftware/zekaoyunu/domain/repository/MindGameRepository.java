package com.mobilesoftware.zekaoyunu.domain.repository;

import android.content.SharedPreferences;

import com.mobilesoftware.zekaoyunu.domain.enums.ad.AdTarget;
import com.mobilesoftware.zekaoyunu.data.repository.dto.UserData;

public interface MindGameRepository {

    SharedPreferences.Editor getEditor();

    UserData getUserData();

    void upgradeDataForInterstitial(AdTarget adTarget);

    void upgradeDataForReward();

    Integer getLevel();

    void upgradeLevel(Integer count);

    String getLevelText();

    Integer getUserCoin();

    String getUserCoinText();

    void addUserCoin(Integer count);

    void decreaseCoin();

    Integer getUserBonusNewQuestion();

    void addBonusNewQuestion(Integer count);

    Integer getUserBonusHalf();

    void addBonusHalf(Integer count);

    Integer getUserBonusAddTime();

    void addBonusAddTime(Integer count);

    Integer getUserBonusStopTime();

    void addBonusStopTime(Integer count);

}
