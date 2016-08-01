package com.practise.androidstuff.network;

import com.practise.androidstuff.managers.ActiveCurrencyConvertorManager;
import com.practise.androidstuff.api.RetrofitCurrencyConvertorApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ManagerModule {

    @Singleton
    @Provides
    ActiveCurrencyConvertorManager provideCurrencyConvertorManager(
            RetrofitCurrencyConvertorApi impl) {
        return new ActiveCurrencyConvertorManager(impl);
    }
}
