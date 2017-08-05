package com.rinc.bong.rivatorproject.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.rinc.bong.rivatorproject.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void goToHome(View view) {
        Intent i = new Intent(getApplicationContext(),HomeActivity.class);
        startActivity(i);
    }
}
