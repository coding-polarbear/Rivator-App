package com.rinc.bong.rivatorproject.controller.activitys;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.utils.ActionbarCustomUtil;
import com.rinc.bong.rivatorproject.utils.DialogUtill;

public class TeacherSignUpActivity extends AppCompatActivity {
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_sign_up);
        init();
        setCustomActionbar();
    }

    public void back(View view) {
        finish();
    }

    public void next(View view) {
        if(checkBox.isChecked()) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //기존의 액티비티 모든 스택 제거
            startActivity(intent);
        } else {
            DialogUtill.makeDialogWithPositiveButton("알림","이용약관에 동의해주세요!","확인",TeacherSignUpActivity.this);
        }
    }

    private void init() {
        checkBox = (CheckBox) findViewById(R.id.checkBox);
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
