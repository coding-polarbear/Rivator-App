package com.rinc.bong.rivatorproject.controller.activitys;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.controller.adapters.CourseAdapter;
import com.rinc.bong.rivatorproject.utils.ActionbarCustomUtil;

public class CourseDetailActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private CourseAdapter courseAdapter;
    private String description = "안녕하십니까, 여러분에게 최상의 강좌를 준비하는 김강사입니다.\n" +
            "저희 강좌는 HTML, CSS와 JQuery를 교육시키기 위해서\n" +
            "여러 웹 표준을 검토해서 준비했습니다.\n" +
            "부디 본 강좌를 들어 여러분의 실력을 증진할 수 있기를 바랍니다. ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        init();
        setTabLayout();
        setViewPager();
        setCustomActionbar();
    }

    private void init() {
        tabLayout = (TabLayout) findViewById(R.id.tab);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

    }

    public void setTabLayout() {
        tabLayout.addTab(tabLayout.newTab().setText("설명"));
        tabLayout.addTab(tabLayout.newTab().setText("팀원 목록"));
    }

    public void setViewPager() {
        courseAdapter = new CourseAdapter(getSupportFragmentManager(), description);
        viewPager.setAdapter(courseAdapter);
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

    /* custom ActionBar
   백그라운드 설정 및 뒤로가기 버튼 달린 커스텀 액션바
 */
    public void  setCustomActionbar() {

        ActionbarCustomUtil mActionbar = new ActionbarCustomUtil(getApplicationContext(), getSupportActionBar(), R.layout.custom_action_bar, view -> {

            TextView textView = (TextView) view.findViewById(R.id.title);
            textView.setText("강좌 정보");
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnBack);
            imageButton.setOnClickListener(v -> finish());
        });

    }
}
