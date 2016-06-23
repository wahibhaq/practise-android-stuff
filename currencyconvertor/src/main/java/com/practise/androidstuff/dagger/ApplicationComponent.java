package com.practise.androidstuff.dagger;

import dagger.Component;

@Component(modules = {AppModule.class, ApiNetworkModule.class, RetroNetworkModule.class})
public interface ApplicationComponent {

    //inject fragment here


}
