package com.practise.androidstuff.dagger;

import android.content.Context;

import com.practise.androidstuff.CCApplication;
import com.practise.androidstuff.CurrencyConvertorManager;

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
