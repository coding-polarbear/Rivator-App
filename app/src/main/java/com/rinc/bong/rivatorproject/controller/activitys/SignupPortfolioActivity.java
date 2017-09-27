package com.rinc.bong.rivatorproject.controller.activitys;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.utils.ActionbarCustomUtil;

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

        ActionbarCustomUtil mActionbar = new ActionbarCustomUtil(getApplicationContext(), getSupportActionBar(), R.layout.layout_actionbar_type_cancle, view -> {

            TextView textView = view.findViewById(R.id.title);
            textView.setText("포트폴리오");

            //ImageButton 리스너 설정
            ImageButton imageButton = view.findViewById(R.id.btnClose);
            imageButton.setOnClickListener(v -> finish());

        });
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

