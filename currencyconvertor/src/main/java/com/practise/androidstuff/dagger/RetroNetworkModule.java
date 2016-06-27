package com.practise.androidstuff.dagger;

import com.practise.androidstuff.network.CurrencyConvertorApi;
import com.practise.androidstuff.network.RetrofitCurrencyConvertorApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = ApiNetworkModule.class)
public class RetroNetworkModule {

    @Singleton
    @Provides
    CurrencyConvertorApi provideCurrencyConvertorApi(RetrofitCurrencyConvertorApi impl) {
        return impl;
    }
}
