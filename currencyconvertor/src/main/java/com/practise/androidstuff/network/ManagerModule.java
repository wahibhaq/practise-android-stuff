package com.practise.androidstuff.network;

import com.practise.androidstuff.api.CurrencyConvertorApi;
import com.practise.androidstuff.managers.ActiveCurrencyConvertorManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ManagerModule {

    @Singleton
    @Provides
    ActiveCurrencyConvertorManager provideCurrencyConvertorManager(
            CurrencyConvertorApi impl) {
        return new ActiveCurrencyConvertorManager(impl);
    }
}
