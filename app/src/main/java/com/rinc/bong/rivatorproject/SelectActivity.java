package com.rinc.bong.rivatorproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Arrays;
import java.util.List;

public class SelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
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
}
