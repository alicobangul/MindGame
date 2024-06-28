package com.mobilesoftware.zekaoyunu.data.di;

import android.app.Activity;
import com.mobilesoftware.zekaoyunu.domain.repository.MindGameRepository;
import com.mobilesoftware.zekaoyunu.domain.validator.AdValidator;
import com.mobilesoftware.zekaoyunu.util.UserUtil;
import com.mobilesoftware.zekaoyunu.domain.util.AdUtil;
import com.mobilesoftware.zekaoyunu.util.DialogUtil;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.scopes.FragmentScoped;

@Module
@InstallIn(FragmentComponent.class)
public class FragmentModule {

    @FragmentScoped
    @Provides
    public static DialogUtil injectDialogUtil(Activity activity, AdUtil networkUtil) { return new DialogUtil(activity, networkUtil); }

    @FragmentScoped
    @Provides
    public static AdUtil injectAdUtil(Activity activity, MindGameRepository repository, AdValidator adValidator) { return new AdUtil(activity, repository, adValidator); }

    @FragmentScoped
    @Provides
    public static AdValidator injectAdValidator() { return new AdValidator(); }

    @FragmentScoped
    @Provides
    public static UserUtil injectUserUtil(Activity activity) { return new UserUtil(activity); }

}