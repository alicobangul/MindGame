package com.mobilesoftware.zekaoyunu.domain.validator;

import com.mobilesoftware.zekaoyunu.domain.enums.ad.AdTarget;
import com.mobilesoftware.zekaoyunu.data.repository.dto.UserData;

public class AdValidator {

    private final int COIN_LIMIT = 5; // Geçiş reklamı izleyerek jeton alabilmek için jeton sayısı bu limitin altında olmalı [Reklam spam]
    private final int BONUS_LIMIT = 5; // Geçiş reklamı izleyerek bonus alabilmek için bonus sayısı bu limitin altında olmalı [Reklam spam]

    private final int ALLITEM_COIN_LIMIT = 10; // Ödüllü reklam izleyerek jeton alabilmek için jeton sayısı bu limitin altında olmalı
    private final int ALLITEM_BONUS_LIMIT = 10; // Ödüllü reklam izleyerek bonus alabilmek için bonus sayısı bu limitin altında olmalı

    public AdValidator() { }

    // Jeton 5 ten az ise satın alma izni var
    public boolean coinValidator(Integer userCoin) { return userCoin < COIN_LIMIT; }

    // Yeni soru bonusu 10'dan az ise satın alma izni var
    public boolean bonusNewQuestionValidator(Integer bonusNewQuestion) { return bonusNewQuestion < BONUS_LIMIT; }

    // Yarı yarıya bonusu 10'dan az ise satın alma izni var
    public boolean bonusHalfValidator(Integer bonusHalf) { return bonusHalf < BONUS_LIMIT; }

    // Süre ekle bonusu 10'dan az ise satın alma izni var
    public boolean bonusAddTimeValidator(Integer bonusAddTime) { return bonusAddTime < BONUS_LIMIT; }

    // Süreyi durdur bonusu 10'dan az ise satın alma izni var
    public boolean bonusStopTimeValidator(Integer bonusStopTime) { return bonusStopTime < BONUS_LIMIT; }

    // İstenen bonus türüne göre izin kontrol ediliyor
    public boolean interstitialAdPermission(AdTarget adTarget, UserData userData) {

        return switch (adTarget) {
            case ADDCOIN -> coinValidator(userData.getUserCoin());
            case BONUSNEWQUESTION -> bonusNewQuestionValidator(userData.getBonusNewQuestion());
            case BONUSHALF -> bonusHalfValidator(userData.getBonusHalf());
            case BONUSADDTIME -> bonusAddTimeValidator(userData.getBonusAddTime());
            case BONUSSTOPTIME -> bonusStopTimeValidator(userData.getBonusStopTime());
        };

    }

    // Rewarded Ad için kontroller yapılıyor
    public boolean rewardedAdPermission(UserData userData) {

        return userData.getUserCoin() < ALLITEM_COIN_LIMIT ||
                userData.getBonusNewQuestion() < ALLITEM_BONUS_LIMIT ||
                userData.getBonusHalf() < ALLITEM_BONUS_LIMIT ||
                userData.getBonusAddTime() < ALLITEM_BONUS_LIMIT ||
                userData.getBonusStopTime() < ALLITEM_BONUS_LIMIT;

    }

}
