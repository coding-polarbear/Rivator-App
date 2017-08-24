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


public class ProfileModifyActivity extends AppCompatActivity {

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

        ActionbarCustomUtil mActionbar = new ActionbarCustomUtil(getApplicationContext(), getSupportActionBar(), R.layout.layout_actionbar_type_back, view -> {

            view.setClickable(false);

            TextView textView = (TextView) view.findViewById(R.id.title);
            textView.setText("계정설정");
            textView.setClickable(false);

            //ImageButton 리스너 설정
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnBack);
            imageButton.setOnClickListener(v -> finish());
        });

    }
}
