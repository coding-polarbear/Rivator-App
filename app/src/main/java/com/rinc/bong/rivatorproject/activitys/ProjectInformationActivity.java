package com.rinc.bong.rivatorproject.activitys;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.adapters.ProjectAdapter;

public class ProjectInformationActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ProjectAdapter projectAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_information);
        setTabLayout();
        setViewPager();
    }
    public void setTabLayout() {
        tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.addTab(tabLayout.newTab().setText("설명"));
        tabLayout.addTab(tabLayout.newTab().setText("팀원 목록"));
    }

    public void setViewPager() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        projectAdapter = new ProjectAdapter(getSupportFragmentManager());
        viewPager.setAdapter(projectAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
