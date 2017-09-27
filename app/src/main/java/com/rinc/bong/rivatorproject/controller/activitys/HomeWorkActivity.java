package com.rinc.bong.rivatorproject.controller.activitys;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.controller.adapters.HomeWorkPagerAdapter;
import com.rinc.bong.rivatorproject.utils.ActionbarCustomUtil;

/**
 * Created by Bong on 2017-07-30.
 */

public class HomeWorkActivity extends AppCompatActivity {

    private ActionBar actionBar = null;

    private ViewPager mViewPager = null;

    private TabLayout mTabLayout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework);

        init();
        pagetInit();
        setCustomActionbar();

    }

    private void init() {
        mViewPager = findViewById(R.id.homework_viewpager);
        mTabLayout = findViewById(R.id.homework_tablayout);
    }

    private void pagetInit() {
        HomeWorkPagerAdapter mHomeWorkPagerAdapter = new HomeWorkPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mHomeWorkPagerAdapter);

        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void  setCustomActionbar() {

        ActionbarCustomUtil mActionbar = new ActionbarCustomUtil(getApplicationContext(), getSupportActionBar(), R.layout.custom_action_bar, view -> {

            TextView textView = view.findViewById(R.id.title);
            textView.setText("숙제관리");

            ImageButton imageButton = view.findViewById(R.id.btnBack);
            imageButton.setOnClickListener(v -> finish());

        });

    }



}
