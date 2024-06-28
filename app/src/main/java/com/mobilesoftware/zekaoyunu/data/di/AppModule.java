package com.mobilesoftware.zekaoyunu.data.di;

import android.content.Context;
import android.content.SharedPreferences;
import com.mobilesoftware.zekaoyunu.domain.repository.MindGameRepository;
import com.mobilesoftware.zekaoyunu.data.repository.MindGameRepositoryImpl;
import com.mobilesoftware.zekaoyunu.domain.validator.DataValidator;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Singleton
    @Provides
    public static SharedPreferences injectSharedPreferences(@ApplicationContext Context context) {
        return context.getSharedPreferences("com.mobilesoftware.zekaoyunu", Context.MODE_PRIVATE);
    }

    @Singleton
    @Provides
    public static MindGameRepository injectMindGameRepository(SharedPreferences sharedPreferences) { return new MindGameRepositoryImpl(sharedPreferences); }

    @Singleton
    @Provides
    public static DataValidator injectDataValidator() { return new DataValidator(); }

}
