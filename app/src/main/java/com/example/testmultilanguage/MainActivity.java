package com.example.testmultilanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.testmultilanguage.fragment.MainFragment;
import com.example.testmultilanguage.fragment.MapFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Add Fragment to Activity

        getSupportActionBar().hide(); // hide the title bar

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentMainFragment, new MainFragment())
                    .commit();
        }
    }
}
