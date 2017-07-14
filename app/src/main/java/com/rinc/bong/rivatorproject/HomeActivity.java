package com.rinc.bong.rivatorproject;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.rinc.bong.rivatorproject.fragments.CurrentLectureFragment;
import com.rinc.bong.rivatorproject.fragments.HomeFragment;
import com.rinc.bong.rivatorproject.fragments.ProfileFragment;
import com.rinc.bong.rivatorproject.fragments.TeacherFragment;

public class HomeActivity extends AppCompatActivity {
    private BottomNavigationViewEx bottomNavigationView;
    private Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setBottomNavigationView();

        if(savedInstanceState == null) loadFragment(new HomeFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            switch(id) {
                case R.id.btnHome:
                    fragment = new HomeFragment();
                    break;
                case R.id.btnTeacher:
                    fragment = new TeacherFragment();
                    break;
                case R.id.btnCalendar:
                    break;
                case R.id.btnCurrentLecture:
                    fragment = new CurrentLectureFragment();
                    break;
                case R.id.btnProfile:
                    fragment = new ProfileFragment();
                    break;
                default:
                    fragment = new HomeFragment();
                    break;
            }

           loadFragment(fragment);
            return true;
        });

    }

    private void loadFragment(Fragment fragment) {
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_container,fragment).commit();
    }
    private void setBottomNavigationView() {
        bottomNavigationView = (BottomNavigationViewEx) findViewById(R.id.bottomNavigation);
        bottomNavigationView.enableAnimation(false);
        bottomNavigationView.enableShiftingMode(false);
        bottomNavigationView.enableItemShiftingMode(false);
    }
}
