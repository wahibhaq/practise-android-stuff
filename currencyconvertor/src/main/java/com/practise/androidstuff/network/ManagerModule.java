package com.practise.androidstuff.network;

import com.practise.androidstuff.managers.CurrencyConvertorManager;
import com.practise.androidstuff.api.RetrofitCurrencyConvertorApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ManagerModule {

    @Singleton
    @Provides
    CurrencyConvertorManager provideCurrencyConvertorManager(
            RetrofitCurrencyConvertorApi impl) {
        return new CurrencyConvertorManager(impl);
    }
}
