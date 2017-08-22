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


public class ProfileModifyActivity extends AppCompatActivity {
    private ActionBar actionBar = null;
    private TextView modifyPassword = null;
    private TextView modifyUser = null;
    private TextView requestUserPromotion = null;
    private TextView logout = null;
    private TextView rsecession = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_modify);
        init();
        setListener();
        setCustomActionbar();
    }

    private void init() {
        modifyPassword = (TextView) findViewById(R.id.modifyPassword);
        modifyUser = (TextView) findViewById(R.id.modifyUser);
        requestUserPromotion = (TextView) findViewById(R.id.requestUserPromotion);
        logout = (TextView) findViewById(R.id.logout);
        rsecession = (TextView) findViewById(R.id.rsecession);
    }


    private void setListener() {
        modifyPassword.setOnClickListener(v -> {
            startActivity(new Intent(ProfileModifyActivity.this, PasswordModifyActivity.class));
        });
        requestUserPromotion.setOnClickListener(v -> {
            startActivity(new Intent(ProfileModifyActivity.this, AccountAdvancementActivity.class));
        });
        modifyUser.setOnClickListener(v -> {
            startActivity(new Intent(ProfileModifyActivity.this, UserModifyActivity.class));
        });
    }
    public void  setCustomActionbar() {
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);

        //layout을 가지고 와서 actionbar에 포팅을 시킵니다.
        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.layout_actionbar_type_back, null);
        customView.setClickable(false);
        TextView textView = (TextView) customView.findViewById(R.id.title);
        textView.setText("계정설정");
        textView.setClickable(false);

        //ImageButton 리스너 설정
        ImageButton imageButton = (ImageButton) customView.findViewById(R.id.btnBack);
        imageButton.setOnClickListener(v -> {
            finish();
        });
        actionBar.setCustomView(customView);

        Toolbar parent = (Toolbar) customView.getParent();
        parent.setContentInsetsAbsolute(0,0);
    }
}
