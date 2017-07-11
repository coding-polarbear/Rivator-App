package com.rinc.bong.rivatorproject;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

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
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);

        View mCustomView = LayoutInflater.from(this).inflate(R.layout.layout_actionbar_type_cancle, null);
        TextView textView = (TextView) mCustomView.findViewById(R.id.title);
        textView.setText("프로필 작성");

        ImageButton imageButton = (ImageButton) mCustomView.findViewById(R.id.btnClose);
        imageButton.setOnClickListener( v-> {
            finish();
        });
        actionBar.setCustomView(mCustomView);
    }
}
