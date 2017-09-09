package com.rinc.bong.rivatorproject.controller.activitys;

import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.User;
import com.rinc.bong.rivatorproject.utils.SnackBarUtill;
import com.rinc.bong.rivatorproject.utils.ToastUtill;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        try {
            User user = User.last(User.class);
            if (user != null)
                goToMain();
            else
                SnackBarUtill.makeSnackBar(getWindow().getDecorView().getRootView(),"로그인 또는 회원가입을 진행해주세요!", Snackbar.LENGTH_LONG);
        } catch(SQLiteException e) {
             SnackBarUtill.makeSnackBar(getWindow().getDecorView().getRootView(),"로그인 또는 회원가입을 진행해주세요!", Snackbar.LENGTH_LONG);
        }
    }

    public void goToSignIn(View view) {
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(i);
    }

    public void goToSignUp(View view) {
        Intent i = new Intent(getApplicationContext(),SelectActivity.class);
        startActivity(i);
    }

    public void goToMain() {
        ToastUtill.makeToast(getApplicationContext(), "로그인에 성공하였습니다!", Toast.LENGTH_SHORT);
        Intent i = new Intent(getApplicationContext(),HomeActivity.class);
        startActivity(i);
    }
}
