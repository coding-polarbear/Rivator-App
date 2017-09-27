package com.rinc.bong.rivatorproject.controller.activitys;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.controller.adapters.TeacherProfilePagerAdapter;
import com.rinc.bong.rivatorproject.utils.ActionbarCustomUtil;

/**
 * Created by bong on 2017-09-27.
 */

public class TeacherProfileActivity extends AppCompatActivity {
    private ImageButton backBtn = null;
    private TextView title = null;
    private TabLayout tabLayout = null;
    private ViewPager viewPager = null;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_profile);
        init();
        pageInit();
        setCustomActionbar();
        setListener();
    }

    private void pageInit() {
        TeacherProfilePagerAdapter teacherProfileActivity = new TeacherProfilePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(teacherProfileActivity);

        tabLayout.setupWithViewPager(viewPager);
    }

    private void setListener() {
        backBtn.setOnClickListener(view -> onBackPressed());
    }

    private void init() {
        tabLayout = findViewById(R.id.teacher_tab);
        viewPager = findViewById(R.id.teacher_viewpager);



    }

    private void setCustomActionbar() {

        ActionbarCustomUtil mActionbar = new ActionbarCustomUtil(getApplicationContext(), getSupportActionBar(), R.layout.custom_action_bar, view -> {
            backBtn = view.findViewById(R.id.btnBack);
            title = view.findViewById(R.id.title);
            title.setText("강사 프로필");
        });

    }


}
