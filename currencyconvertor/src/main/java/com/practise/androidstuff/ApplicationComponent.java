package com.practise.androidstuff;

import com.practise.androidstuff.network.ManagerModule;
import com.practise.androidstuff.network.RetroNetworkModule;
import com.practise.androidstuff.ui.fragments.BaseFragment;
import com.practise.androidstuff.ui.fragments.MainFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, RetroNetworkModule.class, ManagerModule.class})
public interface ApplicationComponent {

    void inject(BaseFragment baseFragment);
    void inject(MainFragment mainFragment);
}
