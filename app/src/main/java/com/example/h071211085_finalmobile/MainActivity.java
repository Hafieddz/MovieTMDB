package com.example.h071211085_finalmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentMovie homeFragment = new FragmentMovie();
        Fragment fragment =
                fragmentManager.findFragmentByTag(FragmentMovie.class.getSimpleName());
        if (!(fragment instanceof FragmentMovie)) {
            fragmentManager
                    .beginTransaction()
                    .add(R.id.frame_container, homeFragment,
                            FragmentMovie.class.getSimpleName())
                    .commit();
        }
    }
}