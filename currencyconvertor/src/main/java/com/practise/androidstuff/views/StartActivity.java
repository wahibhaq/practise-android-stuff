package com.practise.androidstuff.views;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.practise.androidstuff.CCApplication;
import com.practise.androidstuff.CurrencyConvertorManager;
import com.practise.androidstuff.R;

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
