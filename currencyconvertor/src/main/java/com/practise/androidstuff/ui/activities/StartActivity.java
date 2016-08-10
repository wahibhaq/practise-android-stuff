package com.practise.androidstuff.ui.activities;

import android.os.Bundle;

import com.practise.androidstuff.R;
import com.practise.androidstuff.ui.fragments.MainFragment;

public class StartActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
                getFragmentManager().beginTransaction()
                        .add(R.id.content_frame, MainFragment.newInstance())
                        .commit();
        }
    }
}
