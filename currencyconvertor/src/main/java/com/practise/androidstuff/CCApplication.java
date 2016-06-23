package com.practise.androidstuff;

import android.app.Application;

import com.practise.androidstuff.dagger.AppModule;
import com.practise.androidstuff.dagger.ApplicationComponent;
import com.practise.androidstuff.dagger.DaggerApplicationComponent;
import com.practise.androidstuff.dagger.RetroNetworkModule;

public class CCApplication extends Application {

    private ApplicationComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerApplicationComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public ApplicationComponent getAppComponent() {
        return appComponent;
    }
}
