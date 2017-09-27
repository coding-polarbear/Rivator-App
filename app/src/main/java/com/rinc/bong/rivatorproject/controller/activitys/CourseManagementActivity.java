package com.rinc.bong.rivatorproject.controller.activitys;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.controller.adapters.CourseManagementPagerAdapter;
import com.rinc.bong.rivatorproject.utils.ActionbarCustomUtil;

/**
 * Created by bong on 2017-08-05.
 */

public class CourseManagementActivity extends AppCompatActivity {

    private ViewPager mViewPager = null;

    private TabLayout mTabLayout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_manage);

        init();
        pagetInit();
        setCustomActionbar();

    }

    private void init() {
        mViewPager = findViewById(R.id.lecture_manage_viewpager);
        mTabLayout = findViewById(R.id.lecture_manage_tablayout);
    }

    private void pagetInit() {
        CourseManagementPagerAdapter mNoticePagerAdapter = new CourseManagementPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mNoticePagerAdapter);

        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void  setCustomActionbar() {

        ActionbarCustomUtil mActionbar = new ActionbarCustomUtil(getApplicationContext(), getSupportActionBar(), R.layout.custom_action_bar, view -> {

            TextView textView = view.findViewById(R.id.title);
            textView.setText("강좌 관리");

            ImageButton imageButton = view.findViewById(R.id.btnBack);
            imageButton.setOnClickListener(v -> finish());

        });

    }
}
