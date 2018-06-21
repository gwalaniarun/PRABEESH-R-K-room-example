package com.gwalani.room1;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static MyAppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "user.db")
               .build();


        if (findViewById(R.id.frame_layout) != null) {
            if (savedInstanceState != null) {

                return;

            }
        }

        fragmentManager.beginTransaction().add(R.id.frame_layout, new HomeFragment()).commit();


    }
}
