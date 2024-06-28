package com.mobilesoftware.zekaoyunu.presentation;

import android.os.Bundle;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.mobilesoftware.zekaoyunu.databinding.MainActivityBinding;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private MainActivityBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MainActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        uiSettings();

        initialize();

        bannerLoad();

    }

    private void uiSettings() { getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN); }

    private void initialize() {

        MobileAds.initialize(this, initializationStatus -> { });

    }

    private void bannerLoad() { binding.adBanner.loadAd(new AdRequest.Builder().build()); }

}
