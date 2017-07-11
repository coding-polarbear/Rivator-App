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
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Bong on 2017-05-24.
 */

public class SignupPortfolioActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_portfolio);
        setCustomActionbar();
    }


    /*
    *커스텀 액션바
    *setimageview, setbackground 등등 id를 받아온후 사용자 정의로 사용
    */

    private void setCustomActionbar() {
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        View mCustomView = LayoutInflater.from(this).inflate(R.layout.layout_actionbar_type_cancle, null);

        //title 설정
        TextView textView = (TextView) mCustomView.findViewById(R.id.title);
        textView.setText("포트폴리오");

        //ImageButton 리스너 설정
        ImageButton imageButton = (ImageButton) mCustomView.findViewById(R.id.btnClose);
        imageButton.setOnClickListener(v -> {
            finish();
        });
        actionBar.setCustomView(mCustomView);

        //레이어 색깔
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT);
        actionBar.setCustomView(mCustomView, params);

    }

    public void back(View view) {
        finish();
    }

    public void finishSignUp(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}

