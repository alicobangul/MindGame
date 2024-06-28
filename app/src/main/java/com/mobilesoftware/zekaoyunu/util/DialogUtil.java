package com.mobilesoftware.zekaoyunu.util;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup;
import android.widget.Toast;
import com.mobilesoftware.zekaoyunu.R;
import com.mobilesoftware.zekaoyunu.databinding.DialogLevelgameBinding;
import com.mobilesoftware.zekaoyunu.databinding.DialogMoreAppBinding;
import com.mobilesoftware.zekaoyunu.databinding.DialogShopBinding;
import com.mobilesoftware.zekaoyunu.databinding.DialogUserCommentBinding;
import com.mobilesoftware.zekaoyunu.domain.util.AdUtil;

import io.reactivex.subjects.BehaviorSubject;

public class DialogUtil {

    private final Activity activity;

    private final AdUtil adUtil;

    private final Dialog dialog;

    private final BehaviorSubject<Boolean> behaviorShop = BehaviorSubject.createDefault(false);
    private final BehaviorSubject<Boolean> behaviorStartGame = BehaviorSubject.createDefault(false);
    private final BehaviorSubject<Boolean> behaviorMoreApp = BehaviorSubject.createDefault(false);
    private final BehaviorSubject<Boolean> behaviorComment = BehaviorSubject.createDefault(false);

    public DialogUtil(Activity activity, AdUtil adUtil) {

        this.activity = activity;
        this.adUtil = adUtil;

        dialog = new Dialog(activity);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

    }

    public void onDestroy() { adUtil.onDestroy(); }

    public BehaviorSubject<Boolean> getBehaviorShop() { return behaviorShop; }

    public BehaviorSubject<Boolean> getBehaviorStartGame() { return behaviorStartGame; }

    public BehaviorSubject<Boolean> getBehaviorMoreApp() { return behaviorMoreApp; }

    public BehaviorSubject<Boolean> getBehaviorComment() { return behaviorComment; }

    public void showCoinWarning() { Toast.makeText(activity, activity.getString(R.string.buyCoinForGame), Toast.LENGTH_SHORT).show(); }

    public void showShopDialog() {

        DialogShopBinding shopBinding = DialogShopBinding.inflate(activity.getLayoutInflater());

        shopBinding.setAdUtil(adUtil);

        shopBinding.btnOkey.setOnClickListener(v -> {
            behaviorShop.onNext(true);
            dialog.dismiss();
        });

        dialog.setContentView(shopBinding.getRoot());
        dialog.show();

    }

    public void showLevelGameDialog() {

        DialogLevelgameBinding levelgameBinding = DialogLevelgameBinding.inflate(activity.getLayoutInflater());

        levelgameBinding.btnOkey.setOnClickListener(v -> {
            behaviorStartGame.onNext(true);
            dialog.dismiss();
        });

        levelgameBinding.btnCancel.setOnClickListener(v -> dialog.dismiss());

        dialog.setContentView(levelgameBinding.getRoot());
        dialog.show();

    }

    public void showMoreAppDialog() {

        DialogMoreAppBinding moreAppBinding = DialogMoreAppBinding.inflate(activity.getLayoutInflater());

        moreAppBinding.btnOkey.setOnClickListener(v -> {
            behaviorMoreApp.onNext(true);
            dialog.dismiss();
        });

        moreAppBinding.btnCancel.setOnClickListener(v -> dialog.dismiss());

        dialog.setContentView(moreAppBinding.getRoot());
        dialog.show();

    }

    public void showCommentDialog() {

        DialogUserCommentBinding userCommentBinding = DialogUserCommentBinding.inflate(activity.getLayoutInflater());

        userCommentBinding.btnOkey.setOnClickListener(v -> {
            behaviorComment.onNext(true);
            dialog.dismiss();
        });

        userCommentBinding.btnCancel.setOnClickListener(v -> dialog.dismiss());

        dialog.setContentView(userCommentBinding.getRoot());
        dialog.show();

    }

}
