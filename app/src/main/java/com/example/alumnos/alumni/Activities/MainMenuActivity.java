package com.example.alumnos.alumni.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.alumnos.alumni.Api.GlobalRequests;
import com.example.alumnos.alumni.Fragments.Events_fragment;
import com.example.alumnos.alumni.Fragments.Panel_Fragment;
import com.example.alumnos.alumni.Fragments.Profile_Fragment;
import com.example.alumnos.alumni.Fragments.UsersFragment;
import com.example.alumnos.alumni.Models.Event;
import com.example.alumnos.alumni.R;

import java.util.ArrayList;


public class MainMenuActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            boolean fragmentTransaction = false;
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_events:
                    Log.d ( "1:", "ejecutando" );
                    fragment =  new Events_fragment();
                    fragmentTransaction = true;
                    break;
                case R.id.navigation_panel:

                    fragment =  new Panel_Fragment();
                    fragmentTransaction = true;
                    break;
                case R.id.navigation_profile:

                    fragment =  new Profile_Fragment();
                    fragmentTransaction = true;
                    break;

                case R.id.navigation_users:
                    Log.d ( "4:", "Intentando usuarios......" );
                    fragment =  new UsersFragment();
                    fragmentTransaction = true;
                    break;
            }

            if (fragmentTransaction)
            {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, fragment)
                        .commit();
                item.setChecked(true);
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Fragment fragment = null;
        fragment =  new Events_fragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();


        return;

    }



}