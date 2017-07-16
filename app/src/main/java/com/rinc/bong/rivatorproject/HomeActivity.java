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
    private Fragment fragment;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setBottomNavigationView();
        setCustomActionbar();
        if(savedInstanceState == null) loadFragment(new HomeFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            switch(id) {
                case R.id.btnHome:
                    fragment = new HomeFragment();
                    textView.setText("홈");
                    break;
                case R.id.btnTeacher:
                    fragment = new TeacherFragment();
                    textView.setText("강사");
                    break;
                case R.id.btnCalendar:
                    break;
                case R.id.btnCurrentLecture:
                    fragment = new CurrentLectureFragment();
                    textView.setText("진행중 강좌");
                    break;
                case R.id.btnProfile:
                    fragment = new ProfileFragment();
                    textView.setText("프로필");
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

    public void  setCustomActionbar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);

        //ActionBar의 그림자를 제거합니다
        actionBar.setElevation(0);

        //layout을 가지고 와서 actionbar에 포팅을 시킵니다.
        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View actionbar = inflater.inflate(R.layout.layout_main_actionbar, null);
        textView = (TextView) actionbar.findViewById(R.id.title);
        textView.setText("홈");
        actionBar.setCustomView(actionbar);

        Toolbar parent = (Toolbar) actionbar.getParent();
        parent.setContentInsetsAbsolute(0,0);


    }
}
