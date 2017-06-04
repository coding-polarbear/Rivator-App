package com.example.bong.rivatorproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToSignIn(View view) {
    }

    public void goToSignUp(View view) {
        Intent i = new Intent(getApplicationContext(),SelectActivity.class);
        startActivity(i);

    }
}
