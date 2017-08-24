package com.rinc.bong.rivatorproject.controller.activitys;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.controller.adapters.ProjectAdapter;
import com.rinc.bong.rivatorproject.utils.ActionbarCustomUtil;

public class ProjectInformationActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ProjectAdapter projectAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_information);
        init();
        setTabLayout();
        setViewPager();
        setCustomActionbar();
    }

    public void init() {
        mTabLayout = (TabLayout) findViewById(R.id.tab);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
    }
    public void setTabLayout() {
        mTabLayout.addTab(mTabLayout.newTab().setText("설명"));
        mTabLayout.addTab(mTabLayout.newTab().setText("팀원 목록"));
    }

    public void setViewPager() {
        projectAdapter = new ProjectAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(projectAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    /* custom ActionBar
   백그라운드 설정 및 뒤로가기 버튼 달린 커스텀 액션바
 */
    public void  setCustomActionbar() {

        ActionbarCustomUtil mActionbar = new ActionbarCustomUtil(getApplicationContext(), getSupportActionBar(), R.layout.custom_action_bar, view -> {

            TextView textView = (TextView) view.findViewById(R.id.title);
            textView.setText("프로젝트 정보");
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnBack);
            imageButton.setOnClickListener(v -> finish());
        });

    }

}
