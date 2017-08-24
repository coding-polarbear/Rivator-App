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

public class SignupDegreeActivity extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_degree);
        setCustomActionbar();
    }

    private void setCustomActionbar() {

        ActionbarCustomUtil mActionbar = new ActionbarCustomUtil(getApplicationContext(), getSupportActionBar(), R.layout.layout_actionbar_type_cancle, view -> {
            //title 설정
            TextView textView = (TextView) view.findViewById(R.id.title);
            textView.setText("학위");

            //ImageButton 리스너 설정
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnClose);
            imageButton.setOnClickListener(v -> {
                finish();
            });
        });

    }

    public void back(View view) {
        finish();
    }

    public void next(View view) {
        Intent i = new Intent(getApplicationContext(), SignupPortfolioActivity.class);
        startActivity(i);
    }
}
