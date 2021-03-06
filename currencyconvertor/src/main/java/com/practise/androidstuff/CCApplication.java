package com.practise.androidstuff;

import android.app.Application;
import android.content.Context;

public class CCApplication extends Application {

    private ApplicationComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerApplicationComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public ApplicationComponent component() {
        return appComponent;
    }

    public static CCApplication get(Context context) {
        return (CCApplication) context.getApplicationContext();
    }
}
