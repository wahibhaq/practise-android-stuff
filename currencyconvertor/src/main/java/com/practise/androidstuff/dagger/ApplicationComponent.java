package com.practise.androidstuff.dagger;

import com.practise.androidstuff.views.MainFragment;
import com.practise.androidstuff.views.StartActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, RetroNetworkModule.class, ManagerModule.class})
public interface ApplicationComponent {

    void inject(StartActivity startActivity);
    void inject(MainFragment mainFragment);

}
