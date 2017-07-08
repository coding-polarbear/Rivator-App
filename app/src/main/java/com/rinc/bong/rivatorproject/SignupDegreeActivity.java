package com.rinc.bong.rivatorproject;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Bong on 2017-05-24.
 */

public class SignupDegreeActivity extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_degree);
    }


    /*
    *커스텀 액션바
    *setimageview, setbackground 등등 id를 받아온후 사용자 정의로 사용
    */

    private void setCustomActionbar() {
        ActionBar actionBar = getSupportActionBar();

        //getSupportActionBar().setElevation(0);
        actionBar.setTitle(Html.fromHtml("<font color='#000000'>"+actionBar.getTitle().toString() +"</font>"));
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setTitle("학위");

        View mCustomView = LayoutInflater.from(this).inflate(R.layout.layout_actionbar_type_cancle, null);
        actionBar.setCustomView(mCustomView);

       //레이어 색깔
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT);
        actionBar.setCustomView(mCustomView, params);

    }

    public void back(View view) {
        finish();
    }

    public void next(View view) {
        Intent i = new Intent(getApplicationContext(), SignupPortfolioActivity.class);
        startActivity(i);
    }
}
