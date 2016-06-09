package com.logic.hard.projecthardlogic.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.logic.hard.projecthardlogic.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        getSupportFragmentManager().popBackStackImmediate();
        super.onResume();
    }
}
