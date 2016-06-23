package com.practise.androidstuff.dagger;

import com.practise.androidstuff.network.CurrencyConvertorApi;
import com.practise.androidstuff.network.RetrofitCurrencyConvertorApi;

import dagger.Module;

@Module(includes = ApiNetworkModule.class)
public class RetroNetworkModule {

    CurrencyConvertorApi provideConvertorApi(RetrofitCurrencyConvertorApi implementation) {
        return implementation;
    }
}
