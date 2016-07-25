package com.practise.androidstuff.network;

import com.practise.androidstuff.api.CurrencyConvertorApi;
import com.practise.androidstuff.api.RetrofitCurrencyConvertorApi;

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
