package com.rinc.bong.rivatorproject.controller.activitys;

import android.support.design.widget.Snackbar;
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
import com.rinc.bong.rivatorproject.utils.SnackBarUtill;

public class PasswordModifyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_modify);
        setCustomActionbar();
    }

    public void  setCustomActionbar() {

        ActionbarCustomUtil mActionbar = new ActionbarCustomUtil(getApplicationContext(), getSupportActionBar(), R.layout.layout_actionbar_type_back, view -> {

            view.setClickable(false);

            TextView textView = (TextView) view.findViewById(R.id.title);
            textView.setText("패스워드 변경");
            textView.setClickable(false);

            //ImageButton 리스너 설정
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnBack);
            imageButton.setOnClickListener(v -> finish());
        });

    }

    public void modifyPassword(View view) {
        SnackBarUtill.makeSnackBar(view, "비밀번호가 변경되었습니다",Snackbar.LENGTH_LONG);
        //스낵바가 다 보여지고 나면 액티비티 종료
       Thread t = new Thread(() -> {
            try {
                Thread.sleep(3000);
                finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
    }
}
