package com.mobilesoftware.zekaoyunu.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.mobilesoftware.zekaoyunu.R;

public class UserUtil {

    private final Activity activity;

    public UserUtil(Activity activity) {
        this.activity = activity;
    }

    public void visitPlayStore(Boolean isForMoreApp) {

        String uri = (isForMoreApp) ? "market://search?q=pub:BaseSoftware" : "https://play.google.com/store/apps/details?id=com.mobilesoftware.zekaoyunu";

        try {
            Intent task = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            task.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(task);
        }

        catch (ActivityNotFoundException anfe) { Toast.makeText(activity, activity.getString(R.string.unknownError), Toast.LENGTH_SHORT).show(); }

    }

    public void inAppReview() {

        /**
         * Test için ReviewManagerFactory.create(activity) yerine -> new FakeReviewManager(activity) kullan
         * Eğer task sonuçları onSuccess dönüyorsa başarılıdır
         */

        ReviewManager reviewManager = ReviewManagerFactory.create(activity);

        reviewManager
                .requestReviewFlow()
                .addOnCompleteListener(task -> {

                    if(task.isSuccessful()){

                        reviewManager
                                .launchReviewFlow(activity, task.getResult())
                                .addOnCompleteListener(commentTask -> {

                                    if (commentTask.isSuccessful()) Toast.makeText(activity, activity.getString(R.string.thanksForComment),Toast.LENGTH_SHORT).show();

                                    else visitPlayStore(false);

                                });
                    }

                    else visitPlayStore(false);

                });

    }

}
