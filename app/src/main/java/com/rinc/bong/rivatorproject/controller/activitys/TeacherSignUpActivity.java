package com.rinc.bong.rivatorproject.controller.activitys;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.utils.ActionbarCustomUtil;

public class TeacherSignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_sign_up);
        setCustomActionbar();
    }

    public void back(View view) {
        finish();
    }

    public void next(View view) {
        Intent i = new Intent(getApplicationContext(), SignupDegreeActivity.class);
        startActivity(i);
    }

    private void setCustomActionbar() {

            ActionbarCustomUtil mActionbar = new ActionbarCustomUtil(getApplicationContext(), getSupportActionBar(), R.layout.layout_actionbar_type_cancle, view -> {

                TextView textView = (TextView) view.findViewById(R.id.title);
                textView.setText("프로필 작성");

                ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnClose);
                imageButton.setOnClickListener( v-> finish());

            });

    }
}
