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
import com.rinc.bong.rivatorproject.controller.adapters.NoticePagerAdapter;
import com.rinc.bong.rivatorproject.utils.ActionbarCustomUtil;

/**
 * Created by Bong on 2017-07-29.
 */

public class NoticeActivity extends AppCompatActivity {


    private ViewPager mViewPager = null;

    private TabLayout mTabLayout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        init();
        pagetInit();
        setCustomActionbar();

    }

    private void init() {
        mViewPager = (ViewPager)findViewById(R.id.notice_viewpager);
        mTabLayout = (TabLayout)findViewById(R.id.notice_tablayout);
    }

    private void pagetInit() {
        NoticePagerAdapter mNoticePagerAdapter = new NoticePagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mNoticePagerAdapter);

        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void  setCustomActionbar() {

        ActionbarCustomUtil mActionbar = new ActionbarCustomUtil(getApplicationContext(), getSupportActionBar(), R.layout.custom_action_bar, view -> {

            TextView textView = (TextView) view.findViewById(R.id.title);
            textView.setText("알림");
            ImageButton backButton = (ImageButton) view.findViewById(R.id.btnBack);
            backButton.setOnClickListener(v -> finish());

        });

    }



}
