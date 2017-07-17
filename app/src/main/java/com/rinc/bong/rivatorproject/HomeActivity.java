package com.rinc.bong.rivatorproject;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.rinc.bong.rivatorproject.fragments.CurrentLectureFragment;
import com.rinc.bong.rivatorproject.fragments.HomeFragment;
import com.rinc.bong.rivatorproject.fragments.ProfileFragment;
import com.rinc.bong.rivatorproject.fragments.TeacherFragment;

public class HomeActivity extends AppCompatActivity {
    private BottomNavigationViewEx bottomNavigationView;
    private Fragment fragment; //액티비티 전체에서 사용되는 프래그먼트 변수
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setBottomNavigationView();
        if(savedInstanceState == null) loadFragment(new HomeFragment());
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("홈");
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            switch(id) {
                case R.id.btnHome:
                    fragment = new HomeFragment();
                    actionBar.setTitle("홈");
                    break;
                case R.id.btnTeacher:
                    fragment = new TeacherFragment();
                    actionBar.setTitle("강사");
                    break;
                case R.id.btnCalendar:
                    break;
                case R.id.btnCurrentLecture:
                    fragment = new CurrentLectureFragment();
                    actionBar.setTitle("진행중 강좌");
                    break;
                case R.id.btnProfile:
                    fragment = new ProfileFragment();
                    actionBar.setTitle("프로필");
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu_actionbar,menu);
        return true;
    }
}
