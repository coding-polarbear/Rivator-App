package com.rinc.bong.rivatorproject.controller.activitys;

import android.content.Intent;
import android.graphics.Color;
import android.speech.RecognizerIntent;
import android.support.design.internal.BottomNavigationItemView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.controller.fragments.HomeFragment;
import com.rinc.bong.rivatorproject.controller.fragments.ProfileFragment;
import com.rinc.bong.rivatorproject.utils.ActionbarCustomUtil;

import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity {

    private BottomNavigationViewEx bottomNavigationView;
    private Fragment fragment;
    private ActionBar actionBar;
    private ImageButton searchButton;
    private TextView actionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        setCustomActionbar();
        setBottomNavigationView();
        if (savedInstanceState == null) loadFragment(new HomeFragment(0));

        //액션바 설정

        //FCM에서 토픽 구독
        setListener();
        FirebaseMessaging.getInstance().subscribeToTopic("news");
        FirebaseInstanceId.getInstance().getToken();
    }

    private void setListener() {
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SearchViewActivity.class
                ));
            }
        });
    }




    private void init() {
        bottomNavigationView = findViewById(R.id.bottomNavigation);
    }


    private void loadFragment(Fragment fragment) {
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_container, fragment).commit();
    }

    private void setBottomNavigationView() {
        bottomNavigationView.enableAnimation(false);
        bottomNavigationView.enableShiftingMode(false);
        bottomNavigationView.enableItemShiftingMode(false);

        //Calendar Button Background setting
        BottomNavigationItemView calendar = bottomNavigationView.findViewById(R.id.btnCalendar);
        calendar.setBackgroundColor(Color.parseColor("#14e4a2"));
        calendar.setIconTintList(getResources().getColorStateList(R.color.calendar_item_state));
        calendar.setTextColor(getResources().getColorStateList(R.color.calendar_item_state));

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            int position = 0;
            switch (id) {
                case R.id.btnHome:
                    position = 0;
                    fragment = new HomeFragment(position);
                    actionText.setText("홈");
                    loadFragment(fragment);
                    break;
                case R.id.btnTeacher:
                    position = 1;
                    fragment = new HomeFragment(position);
                    actionText.setText("강사");
                    loadFragment(fragment);
                    break;
                case R.id.btnCalendar:
                    position = 2;
                    Intent i = new Intent(getApplicationContext(), CalendarActivity.class);
                    startActivity(i);
                    break;
                case R.id.btnCurrentLecture:
                    position = 3;
                    fragment = new HomeFragment(position);
                    actionText.setText("진행중 강좌");
                    loadFragment(fragment);
                    break;
                case R.id.btnProfile:
                    position = 4;
                    fragment = new ProfileFragment();
                    actionText.setText("프로필");
                    loadFragment(fragment);
                    break;
            }
            return true;
        });
    }

    private void  setCustomActionbar() {

        ActionbarCustomUtil mActionbar = new ActionbarCustomUtil(getApplicationContext(), getSupportActionBar(), R.layout.layout_actionbar_type_search, view -> {
            searchButton = view.findViewById(R.id.BtnSearch);
            actionText = view.findViewById(R.id.home_title);
            actionText.setText("홈");
        });

    }


}
