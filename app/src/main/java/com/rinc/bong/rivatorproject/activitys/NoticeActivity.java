package com.rinc.bong.rivatorproject.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.adapters.NoticePagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bong on 2017-07-29.
 */

public class NoticeActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        init();
        pagetInit();

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



}
