package com.mobilesoftware.zekaoyunu.domain.util;

import android.app.Activity;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.mobilesoftware.zekaoyunu.R;
import com.mobilesoftware.zekaoyunu.domain.enums.ad.AdTarget;
import com.mobilesoftware.zekaoyunu.domain.repository.MindGameRepository;
import com.mobilesoftware.zekaoyunu.domain.validator.AdValidator;
import com.mobilesoftware.zekaoyunu.domain.enums.ad.AdStatus;

public class AdUtil {

    private final Activity activity;

    private final MindGameRepository repository;

    private final AdValidator adValidator;


    private final FullScreenContentCallback interstitialCallback;

    private AdStatus interstitialAdStatus = AdStatus.NOTEXIST;

    private AdTarget interstitialAdTarget = AdTarget.ADDCOIN;

    private InterstitialAd interstitialAd = null;


    private final FullScreenContentCallback rewardedCallback;

    private AdStatus rewardedAdStatus = AdStatus.NOTEXIST;

    private RewardedAd rewardedAd = null;

    public AdUtil(Activity activity, MindGameRepository repository, AdValidator adValidator) {

        this.activity = activity;
        this.repository = repository;
        this.adValidator = adValidator;

        interstitialCallback = new FullScreenContentCallback() {
            @Override
            public void onAdDismissedFullScreenContent() {
                super.onAdDismissedFullScreenContent();
                interstitialAd = null;
                interstitialAdStatus = AdStatus.NOTEXIST;
            }

            @Override
            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                super.onAdFailedToShowFullScreenContent(adError);
                interstitialAd = null;
                interstitialAdStatus = AdStatus.NOTEXIST;
            }

            @Override
            public void onAdImpression() {
                super.onAdImpression();
                repository.upgradeDataForInterstitial(interstitialAdTarget);
                infoForAd(R.string.coinOrBonusComplete);

            }
        };

        rewardedCallback = new FullScreenContentCallback() {
            @Override
            public void onAdDismissedFullScreenContent() {
                super.onAdDismissedFullScreenContent();
                rewardedAd = null;
                rewardedAdStatus = AdStatus.NOTEXIST;
            }

            @Override
            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                super.onAdFailedToShowFullScreenContent(adError);
                rewardedAd = null;
                rewardedAdStatus = AdStatus.NOTEXIST;
            }

        };

    }

    public void onDestroy() {
        interstitialAd = null;
        rewardedAd = null;
    }

    public void infoForAd(Integer info) { Toast.makeText(activity, activity.getString(info), Toast.LENGTH_SHORT).show(); }

    public void loadInterstitial() {

        interstitialAdStatus = AdStatus.LOADING;

        InterstitialAd.load(
                activity,
                activity.getString(R.string.INTERSTITIALTEST),
                new AdRequest.Builder().build(),
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        infoForAd(R.string.adLoadingError);
                        interstitialAdStatus = AdStatus.NOTEXIST;
                        interstitialAd = null;
                    }

                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd ad) {
                        super.onAdLoaded(ad);
                        infoForAd(R.string.adLoadingComplete);
                        interstitialAdStatus = AdStatus.AVAILABLE;
                        interstitialAd = ad;
                        interstitialAd.setFullScreenContentCallback(interstitialCallback);
                    }
                });

    }

    public void loadRewarded() {

        rewardedAdStatus = AdStatus.LOADING;

        RewardedAd.load(activity,
                activity.getString(R.string.REWARDEDTEST),
                new AdRequest.Builder().build(),
                new RewardedAdLoadCallback() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        infoForAd(R.string.adLoadingError);
                        rewardedAdStatus = AdStatus.NOTEXIST;
                        rewardedAd = null;
                    }

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd ad) {
                        super.onAdLoaded(rewardedAd);
                        infoForAd(R.string.adLoadingComplete);
                        rewardedAdStatus = AdStatus.AVAILABLE;
                        rewardedAd = ad;
                        rewardedAd.setFullScreenContentCallback(rewardedCallback);
                    }
                });

    }

    public void showInterstitial(AdTarget target) {

        boolean adPermission = adValidator.interstitialAdPermission(target, repository.getUserData());

        interstitialAdTarget = target;

        if (adPermission) {

            if (interstitialAd != null) interstitialAd.show(activity);

            else {

                if (interstitialAdStatus == AdStatus.AVAILABLE || interstitialAdStatus == AdStatus.NOTEXIST) {
                    interstitialAdStatus = AdStatus.NOTEXIST;
                    infoForAd(R.string.adLoading);
                    loadInterstitial();
                }

            }

        }

        else infoForAd(R.string.available);

    }

    public void showRewarded() {

        boolean adPermission = adValidator.rewardedAdPermission(repository.getUserData());

        if (adPermission) {

            if (rewardedAd != null) {

                rewardedAd.show(activity, rewardItem -> {

                    repository.upgradeDataForReward();

                    infoForAd(R.string.coinOrBonusComplete);

                });

            }

            else {

                if (rewardedAdStatus == AdStatus.AVAILABLE || rewardedAdStatus == AdStatus.NOTEXIST) {
                    rewardedAdStatus = AdStatus.NOTEXIST;
                    infoForAd(R.string.adLoading);
                    loadRewarded();
                }

            }

        }

        else infoForAd(R.string.available);

    }

}
