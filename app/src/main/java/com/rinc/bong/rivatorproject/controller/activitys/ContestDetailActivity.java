package com.rinc.bong.rivatorproject.controller.activitys;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.Contest;
import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.controller.adapters.ContestDetailPagerAdapter;
import com.rinc.bong.rivatorproject.retrofitBean.ContestGet;
import com.rinc.bong.rivatorproject.services.ContestService;
import com.rinc.bong.rivatorproject.utils.ActionbarCustomUtil;
import com.rinc.bong.rivatorproject.utils.RetrofitUtil;
import com.rinc.bong.rivatorproject.utils.SnackBarUtill;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContestDetailActivity extends AppCompatActivity {
    private int contestKey;
    private Contest contest;

    private ImageView imageView;
    private TextView title;
    private TextView organizer;
    private TextView categoryName;
    private TextView prizeNum;
    private TabLayout tab;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contest_detail);
        init();
        setTabLayout();
        loadData();
        setCustomActionbar();
    }

    private void init() {
        contestKey = getIntent().getExtras().getInt("contestKey");
        imageView = (ImageView) findViewById(R.id.imageView);
        title = (TextView) findViewById(R.id.title);
        organizer = (TextView) findViewById(R.id.organizer);
        categoryName = (TextView) findViewById(R.id.categoryName);
        prizeNum = (TextView) findViewById(R.id.prizeNum);
        tab = (TabLayout) findViewById(R.id.tab);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }

    public void setTabLayout() {
        tab.addTab(tab.newTab().setText("설명"));
        tab.addTab(tab.newTab().setText("출품 부문"));
        tab.addTab(tab.newTab().setText("접수 방법"));
        tab.addTab(tab.newTab().setText("심사 기준"));
        tab.addTab(tab.newTab().setText("시상 내역"));
    }

    private void loadData() {
        ContestService contestService = RetrofitUtil.retrofit.create(ContestService.class);
        Call<ContestGet> call = contestService.getContest(contestKey);
        call.enqueue(new Callback<ContestGet>() {
            @Override
            public void onResponse(Call<ContestGet> call, Response<ContestGet> response) {
                Result result = response.body().getResult();
                if(result.getSuccess().equals("200")) {
                    contest = response.body().getContest();
                    title.setText(contest.getTitle());
                    organizer.setText(contest.getUser().getUserName());
                    categoryName.setText(contest.getCategory());
                    prizeNum.setText(contest.getPrizeNum()+"팀");
                    Glide.with(getApplicationContext()).load("http://n0rr.iptime.org:7001/contests/"+contestKey+"/contest-image.jpg").centerCrop().into(imageView);
                    setViewPager();
                } else {
                    SnackBarUtill.makeSnackBar(getWindow().getDecorView().getRootView(), result.getMessage(), Snackbar.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<ContestGet> call, Throwable t) {
                SnackBarUtill.makeSnackBar(getWindow().getDecorView().getRootView(),"알 수 없는 오류가 발생했습니다!",Snackbar.LENGTH_SHORT);
            }
        });
    }

    private void setViewPager() {
        ContestDetailPagerAdapter adapter = new ContestDetailPagerAdapter(getSupportFragmentManager(),getApplicationContext(), contest);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));
        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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

    public void  setCustomActionbar() {

        ActionbarCustomUtil mActionbar = new ActionbarCustomUtil(getApplicationContext(), getSupportActionBar(), R.layout.custom_action_bar, view -> {

            TextView textView = (TextView) view.findViewById(R.id.title);
            textView.setText("콘테스트 정보");
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnBack);
            imageButton.setOnClickListener(v -> finish());
        });

    }
}
