package com.rinc.bong.rivatorproject.controller.activitys;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.utils.ActionbarCustomUtil;
import com.rinc.bong.rivatorproject.utils.DialogUtill;
import com.rinc.bong.rivatorproject.utils.SnackBarUtill;

/**
 * Created by Bong on 2017-05-24.
 */

public class SignupTermsAgreeActivity extends AppCompatActivity {
    private Intent intent;
    private CheckBox check1;
    private CheckBox check2;
    private CheckBox check3;
    private CheckBox check4;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_terms_agree);
        init();
        setCustomActionbar();
    }

    private void init() {
        intent = getIntent();
        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.check3);
        check4 = findViewById(R.id.check4);
    }
    /*
    *커스텀 액션바
    *setimageview, setbackground 등등 id를 받아온후 사용자 정의로 사용
    */
    private void setCustomActionbar() {
        ActionbarCustomUtil mActionbar = new ActionbarCustomUtil(getApplicationContext(), getSupportActionBar(), R.layout.layout_actionbar_type_cancle, view -> {
            TextView textView = view.findViewById(R.id.title);
            textView.setText("약관 동의");
            ImageButton imageButton = view.findViewById(R.id.btnClose);
            imageButton.setOnClickListener(v -> finish());
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mActionbar.setActionBarElevation(15);
        }
    }

    public void next(View view) {
        String type = intent.getStringExtra("type");
        Intent i;
        if(check1.isChecked() && check2.isChecked() && check3.isChecked() && check4.isChecked()) {
            if (type.equals("student")) {
                i = new Intent(getApplicationContext(), StudentSignUpActivity.class);
            } else {
                i = new Intent(getApplicationContext(), TeacherSignUpActivity.class);
            }
            startActivity(i);
        } else {
            DialogUtill.makeDialogWithPositiveButton("알림","이용 약관에 동의해주세요!", "확인", SignupTermsAgreeActivity.this);
        }

    }

    public void gotoDetail(View view) {
        Intent i = new Intent(getApplicationContext(), SignupTermsDetailActivity.class);
        startActivity(i);
    }
}

