package com.mobilesoftware.zekaoyunu.data.repository;

import android.content.SharedPreferences;
import com.mobilesoftware.zekaoyunu.domain.enums.ad.AdTarget;
import com.mobilesoftware.zekaoyunu.data.repository.dto.UserData;
import com.mobilesoftware.zekaoyunu.domain.repository.MindGameRepository;
import javax.inject.Inject;

public class MindGameRepositoryImpl implements MindGameRepository {

    final SharedPreferences sharedPreferences;

    final String USER_LEVEL = "USER_LEVEL";
    final String USER_COIN = "USER_COIN";
    final String USER_BONUS_NEWQUESTION = "USER_BONUS_NEWQUESTION";
    final String USER_BONUS_HALF = "USER_BONUS_HALF";
    final String USER_BONUS_ADDTIME = "USER_BONUS_ADDTIME";
    final String USER_BONUS_STOPTIME = "USER_BONUS_STOPTIME";

    final int INTERSTITIAL_COIN = 1; // 1 jeton verilecek [Interstitial Ad Ödülü]
    final int INTERSTITIAL_BONUS_NEWQUESTION = 1; // 1 bonus verilecek [Interstitial Ad Ödülü]
    final int INTERSTITIAL_BONUS_HALF = 1; // 1 bonus verilecek [Interstitial Ad Ödülü]
    final int INTERSTITIAL_BONUS_ADDTIME = 1; // 1 bonus verilecek [Interstitial Ad Ödülü]
    final int INTERSTITIAL_BONUS_STOPTIME = 1; // 1 bonus verilecek [Interstitial Ad Ödülü]

    final int REWARD_COIN = 5; // 5 jeton verilecek [Rewarded Ad Ödülü]
    final int REWARD_BONUS_NEWQUESTION = 5; // 5 Bonus verilecek [Rewarded Ad Ödülü]
    final int REWARD_BONUS_HALF = 5; // 5 Bonus verilecek [Rewarded Ad Ödülü]
    final int REWARD_BONUS_ADDTIME = 5; // 5 Bonus verilecek [Rewarded Ad Ödülü]
    final int REWARD_BONUS_STOPTIME = 5; // 5 Bonus verilecek [Rewarded Ad Ödülü]

    @Inject
    public MindGameRepositoryImpl(SharedPreferences sharedPreferences) { this.sharedPreferences = sharedPreferences; }

    @Override
    public SharedPreferences.Editor getEditor() { return sharedPreferences.edit(); }


    @Override
    public UserData getUserData() {

        return new UserData(
                getLevel(),
                getUserCoin(),
                getUserBonusNewQuestion(),
                getUserBonusHalf(),
                getUserBonusAddTime(),
                getUserBonusStopTime()
        );
    }

    @Override
    public void upgradeDataForInterstitial(AdTarget adTarget) {

        switch (adTarget) {
            case ADDCOIN:
                addUserCoin(INTERSTITIAL_COIN);
                break;
            case BONUSNEWQUESTION:
                addBonusNewQuestion(INTERSTITIAL_BONUS_NEWQUESTION);
                break;
            case BONUSHALF:
                addBonusHalf(INTERSTITIAL_BONUS_HALF);
                break;
            case BONUSADDTIME:
                addBonusAddTime(INTERSTITIAL_BONUS_ADDTIME);
                break;
            case BONUSSTOPTIME:
                addBonusStopTime(INTERSTITIAL_BONUS_STOPTIME);
                break;
        }

    }

    @Override
    public void upgradeDataForReward() {

        addUserCoin(REWARD_COIN);
        addBonusNewQuestion(REWARD_BONUS_NEWQUESTION);
        addBonusHalf(REWARD_BONUS_HALF);
        addBonusAddTime(REWARD_BONUS_ADDTIME);
        addBonusStopTime(REWARD_BONUS_STOPTIME);
    }

    @Override
    public Integer getLevel() { return sharedPreferences.getInt(USER_LEVEL,1); }

    @Override
    public void upgradeLevel(Integer count) { getEditor().putInt(USER_LEVEL, getLevel() + count).apply(); }

    @Override
    public String getLevelText() { return getLevel().toString(); }



    @Override
    public Integer getUserCoin() { return sharedPreferences.getInt(USER_COIN, 3); }

    @Override
    public String getUserCoinText() { return getUserCoin().toString(); }

    @Override
    public void addUserCoin(Integer count) { getEditor().putInt(USER_COIN, getUserCoin() + count).apply(); }

    @Override
    public void decreaseCoin() { getEditor().putInt(USER_COIN, getUserCoin() - 1).apply(); }



    @Override
    public Integer getUserBonusNewQuestion() { return sharedPreferences.getInt(USER_BONUS_NEWQUESTION, 1); }

    @Override
    public void addBonusNewQuestion(Integer count) { getEditor().putInt(USER_BONUS_NEWQUESTION, getUserBonusNewQuestion() + count).apply(); }



    @Override
    public Integer getUserBonusHalf() { return sharedPreferences.getInt(USER_BONUS_HALF, 1); }

    @Override
    public void addBonusHalf(Integer count) { getEditor().putInt(USER_BONUS_HALF, getUserBonusHalf() + count).apply(); }



    @Override
    public Integer getUserBonusAddTime() { return sharedPreferences.getInt(USER_BONUS_ADDTIME, 1); }

    @Override
    public void addBonusAddTime(Integer count) { getEditor().putInt(USER_BONUS_ADDTIME, getUserBonusAddTime() + count).apply(); }



    @Override
    public Integer getUserBonusStopTime() { return sharedPreferences.getInt(USER_BONUS_STOPTIME, 1); }

    @Override
    public void addBonusStopTime(Integer count) { getEditor().putInt(USER_BONUS_STOPTIME, getUserBonusStopTime() + count).apply(); }

}
