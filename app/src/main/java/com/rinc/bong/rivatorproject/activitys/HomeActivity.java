package com.rinc.bong.rivatorproject.activitys;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
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
        bottomNavigationView = (BottomNavigationViewEx) findViewById(R.id.bottomNavigation);
        //BottomNavigationView 설정
        setBottomNavigationView();
        if(savedInstanceState == null) loadFragment(new HomeFragment(0));

        //액션바 설정
        setActionBar();

        //FCM에서 토픽 구독
        FirebaseMessaging.getInstance().subscribeToTopic("news");
        FirebaseInstanceId.getInstance().getToken();
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
            int position = 0;
            switch(id) {
                case R.id.btnHome:
                    position = 0;
                    fragment = new HomeFragment(position);
                    actionBar.setTitle("홈");
                    loadFragment(fragment);
                    break;
                case R.id.btnTeacher:
                    position = 1;
                    fragment = new HomeFragment(position);
                    actionBar.setTitle("강사");
                    loadFragment(fragment);
                    break;
                case R.id.btnCalendar:
                    position = 2;
                    Intent i = new Intent(getApplicationContext(),CalendarActivity.class);
                    startActivity(i);
                    break;
                case R.id.btnCurrentLecture:
                    position = 3;
                    fragment = new HomeFragment(position);
                    actionBar.setTitle("진행중 강좌");
                    loadFragment(fragment);
                    break;
                case R.id.btnProfile:
                    position = 4;
                    fragment = new ProfileFragment();
                    actionBar.setTitle("프로필");
                    loadFragment(fragment);
                    break;
            }
            return true;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu_actionbar,menu);
        return true;
    }
}
