package com.practise.androidstuff;

import com.practise.androidstuff.ui.StartActivity;
import com.practise.androidstuff.ui.fragments.MainFragment;
import com.practise.androidstuff.network.ManagerModule;
import com.practise.androidstuff.network.RetroNetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, RetroNetworkModule.class, ManagerModule.class})
public interface ApplicationComponent {

    void inject(StartActivity startActivity);
    void inject(MainFragment mainFragment);

}
