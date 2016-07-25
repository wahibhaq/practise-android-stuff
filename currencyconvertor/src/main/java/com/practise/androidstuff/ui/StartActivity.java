package com.practise.androidstuff.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.practise.androidstuff.CCApplication;
import com.practise.androidstuff.R;
import com.practise.androidstuff.managers.CurrencyConvertorManager;

import javax.inject.Inject;

public class StartActivity extends AppCompatActivity {

    @Inject
    CurrencyConvertorManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CCApplication.get(this).component().inject(this);

        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            manager.showWhenReady(this);
        }
    }
}
