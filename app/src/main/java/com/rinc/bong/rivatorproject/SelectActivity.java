package com.rinc.bong.rivatorproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
    }

    public void goToTeacherSignup(View view) {
        Intent i = new Intent(this, TeacherSignUpActivity.class);
        startActivity(i);
    }
}
