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
import com.rinc.bong.rivatorproject.controller.adapters.LectureManagementPagerAdapter;

/**
 * Created by bong on 2017-08-05.
 */

public class CourseManagementActivity extends AppCompatActivity {
    private ActionBar actionBar = null;

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
        mViewPager = (ViewPager)findViewById(R.id.lecture_manage_viewpager);
        mTabLayout = (TabLayout)findViewById(R.id.lecture_manage_tablayout);
    }

    private void pagetInit() {
        LectureManagementPagerAdapter mNoticePagerAdapter = new LectureManagementPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mNoticePagerAdapter);

        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void  setCustomActionbar() {
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);

        //ActionBar의 그림자를 제거합니다
        actionBar.setElevation(0);

        //layout을 가지고 와서 actionbar에 포팅을 시킵니다.
        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_action_bar, null);
        TextView textView = (TextView) view.findViewById(R.id.title);
        textView.setText("강좌 관리");
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnBack);
        imageButton.setOnClickListener(v -> {
            finish();
        });
        actionBar.setCustomView(view);

        Toolbar parent = (Toolbar) view.getParent();
        parent.setContentInsetsAbsolute(0,0);


    }
}