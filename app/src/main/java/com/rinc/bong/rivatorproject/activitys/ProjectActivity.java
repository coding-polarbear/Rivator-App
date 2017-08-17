package com.rinc.bong.rivatorproject.activitys;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.adapters.NoticePagerAdapter;
import com.rinc.bong.rivatorproject.adapters.ProjectPagerAdapter;

/**
 * Created by Bong on 2017-07-30.
 */

public class ProjectActivity extends AppCompatActivity {

    private ActionBar actionBar = null;

    private ViewPager mViewPager = null;

    private TabLayout mTabLayout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        init();
        pagetInit();
        setCustomActionbar();

    }

    private void init() {
        mViewPager = (ViewPager)findViewById(R.id.project_viewpager);
        mTabLayout = (TabLayout)findViewById(R.id.project_tablayout);
    }

    private void pagetInit() {
        ProjectPagerAdapter mProjectPagerAdapter = new ProjectPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mProjectPagerAdapter);

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
        View actionbar = inflater.inflate(R.layout.custom_action_bar, null);
        TextView textView = (TextView) actionbar.findViewById(R.id.title);
        textView.setText("프로젝트");
        actionBar.setCustomView(actionbar);

        Toolbar parent = (Toolbar) actionbar.getParent();
        parent.setContentInsetsAbsolute(0,0);


    }



}