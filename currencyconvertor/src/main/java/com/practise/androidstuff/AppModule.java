package com.practise.androidstuff;

import android.content.Context;

import com.practise.androidstuff.CCApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final CCApplication ccApplication;

    public AppModule(CCApplication ccApplication) {
        this.ccApplication = ccApplication;
    }

    @Singleton
    @Provides
    CCApplication provideApplication() {
        return ccApplication;
    }

    @Singleton
    @Provides
    Context provideApplicationContext() {
        return ccApplication;
    }

}
