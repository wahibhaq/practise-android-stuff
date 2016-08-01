package com.practise.androidstuff.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.practise.androidstuff.CCApplication;
import com.practise.androidstuff.R;
import com.practise.androidstuff.managers.ActiveCurrencyConvertorManager;
import com.practise.androidstuff.ui.fragments.MainFragment;

import javax.inject.Inject;

public class StartActivity extends AppCompatActivity {

    @Inject
    ActiveCurrencyConvertorManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CCApplication.get(this).component().inject(this);

        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            if(manager.setup()) {
                MainFragment fragment = MainFragment.newInstance(manager.getOfferedCurrencyList());
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.content_frame, fragment)
                        .commit();
            }
        }
    }
}
