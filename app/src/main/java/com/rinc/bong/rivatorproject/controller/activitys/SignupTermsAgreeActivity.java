package com.rinc.bong.rivatorproject.controller.activitys;

import android.content.Intent;
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

public class SignupTermsAgreeActivity extends AppCompatActivity {
    private Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_terms_agree);
        intent = getIntent();
        setCustomActionbar();
    }


    /*
    *커스텀 액션바
    *setimageview, setbackground 등등 id를 받아온후 사용자 정의로 사용
    */

    private void setCustomActionbar() {

        ActionbarCustomUtil mActionbar = new ActionbarCustomUtil(getApplicationContext(), getSupportActionBar(), R.layout.layout_actionbar_type_cancle, view -> {

            TextView textView = (TextView) view.findViewById(R.id.title);
            textView.setText("약관 동의");

            ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnClose);
            imageButton.setOnClickListener(v -> finish());

        });

    }

    public void next(View view) {
        String type = intent.getStringExtra("type");
        Intent i;
        if (type.equals("student")) {
            i = new Intent(getApplicationContext(), StudentSignUpActivity.class);
        } else {
            i = new Intent(getApplicationContext(), TeacherSignUpActivity.class);
        }
        startActivity(i);
    }

    public void gotoDetail(View view) {
        Intent i = new Intent(getApplicationContext(), SignupTermsDetailActivity.class);
        startActivity(i);
    }
}

