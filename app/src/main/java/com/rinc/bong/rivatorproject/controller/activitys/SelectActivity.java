package com.rinc.bong.rivatorproject.controller.activitys;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.utils.ActionbarCustomUtil;

public class SelectActivity extends AppCompatActivity {
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        setCustomActionbar();
        imageButton = (ImageButton) getSupportActionBar().getCustomView().findViewById(R.id.btnBack);
        imageButton.setOnClickListener(v -> {
            finish();
        });

    }

    public void goToTeacherSignup(View view) {
        Intent i = new Intent(this, SignupTermsAgreeActivity.class);
        i.putExtra("type", "teacher");
        startActivity(i);
    }

    public void gotoStudentSignUp(View view) {
        Intent i = new Intent(this, SignupTermsAgreeActivity.class);
        i.putExtra("type", "student");
        startActivity(i);
    }

    /* custom ActionBar
       백그라운드 설정 및 뒤로가기 버튼 달린 커스텀 액션바
     */
    public void  setCustomActionbar() {
        ActionbarCustomUtil mActionbar = new ActionbarCustomUtil(getApplicationContext(), getSupportActionBar(), R.layout.custom_action_bar, view -> {
            //title 설정
            TextView textView = (TextView) view.findViewById(R.id.title);
            textView.setText("유형 선택");
        });

    }
}
