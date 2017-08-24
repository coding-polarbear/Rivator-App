package com.rinc.bong.rivatorproject.controller.activitys;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.utils.ActionbarCustomUtil;
import com.rinc.bong.rivatorproject.utils.SnackBarUtill;

public class LoginActivity extends AppCompatActivity {

    private TextView forgot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setCustomActionbar();
        forgot = (TextView) findViewById(R.id.forgot);
        forgot.setText(Html.fromHtml("<u>계정을 잃어버리셨나요?</u>"));
    }

    public void  setCustomActionbar() {

        ActionbarCustomUtil mActionbar = new ActionbarCustomUtil(getApplicationContext(), getSupportActionBar(), R.layout.layout_actionbar_type_back, view -> {

            TextView textView = (TextView) view.findViewById(R.id.title);
            textView.setText("로그인");

            //ImageButton 리스너 설정
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnBack);
            imageButton.setOnClickListener(v -> finish());

        });

    }

    public void login(View view) {
        SnackBarUtill.makeSnackBar(view, "로그인이 완료되었습니다", Snackbar.LENGTH_LONG);
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(3000);
                Intent i = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();

    }
}
