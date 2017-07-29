package com.rinc.bong.rivatorproject.activitys;

import android.graphics.Color;
import android.support.design.internal.BottomNavigationItemView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.fragments.CurrentLectureFragment;
import com.rinc.bong.rivatorproject.fragments.HomeFragment;
import com.rinc.bong.rivatorproject.fragments.ProfileFragment;
import com.rinc.bong.rivatorproject.fragments.TeacherFragment;

public class HomeActivity extends AppCompatActivity {
    private BottomNavigationViewEx bottomNavigationView;
    private Fragment fragment;
    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //BottomNavigationView 설정
        setBottomNavigationView();
        if(savedInstanceState == null) loadFragment(new HomeFragment());

        //액션바 설정
        setActionBar();
    }

    private void setActionBar() {
        actionBar = getSupportActionBar();
        actionBar.setElevation(0);
        actionBar.setTitle("홈");
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

        //Calendar Button Background setting
        BottomNavigationItemView calendar = (BottomNavigationItemView) bottomNavigationView.findViewById(R.id.btnCalendar);
        calendar.setBackgroundColor(Color.parseColor("#14e4a2"));
        calendar.setIconTintList(getResources().getColorStateList(R.color.calendar_item_state));
        calendar.setTextColor(getResources().getColorStateList(R.color.calendar_item_state));

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu_actionbar,menu);
        return true;
    }
}
