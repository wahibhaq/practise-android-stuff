package com.practise.androidstuff.dagger;

import com.practise.androidstuff.CurrencyConvertorManager;
import com.practise.androidstuff.network.RetrofitCurrencyConvertorApi;

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
