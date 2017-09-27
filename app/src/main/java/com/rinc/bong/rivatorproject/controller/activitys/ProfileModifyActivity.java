package com.rinc.bong.rivatorproject.controller.activitys;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.beans.Status;
import com.rinc.bong.rivatorproject.beans.Token;
import com.rinc.bong.rivatorproject.beans.User;
import com.rinc.bong.rivatorproject.services.UserService;
import com.rinc.bong.rivatorproject.utils.ActionbarCustomUtil;
import com.rinc.bong.rivatorproject.utils.RetrofitUtil;
import com.rinc.bong.rivatorproject.utils.SnackBarUtill;
import com.rinc.bong.rivatorproject.utils.ToastUtill;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProfileModifyActivity extends AppCompatActivity {

    private TextView modifyPassword = null;
    private TextView modifyUser = null;
    private TextView requestUserPromotion = null;
    private TextView logout = null;
    private TextView addCourse = null;
    private TextView rsecession = null;

    private User user = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_modify);
        init();
        setListener();
        setCustomActionbar();
    }

    private void init() {
        modifyPassword = findViewById(R.id.modifyPassword);
        modifyUser = findViewById(R.id.modifyUser);
        requestUserPromotion = findViewById(R.id.requestUserPromotion);
        logout = findViewById(R.id.logout);
        rsecession = findViewById(R.id.rsecession);
        addCourse = findViewById(R.id.addCourse);
        user = User.last(User.class);
        if(user.getUserType().equals("student")) addCourse.setVisibility(TextView.INVISIBLE);
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
        logout.setOnClickListener(v -> {
            User.deleteAll(User.class);  //Sqlite에 저장한 모든 User 객체 삭제
            Token.deleteAll(Token.class); //Sqlite에 저장한 모든 Token 객체 삭제
            ToastUtill.makeToast(getApplicationContext(), "로그아웃이 완료되었습니다!", Toast.LENGTH_SHORT);
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //기존의 액티비티 모든 스택 제거
            startActivity(intent);
        });
        addCourse.setOnClickListener(v -> {
            if(user.getUserType().equals("teacher")) {
                startActivity(new Intent(ProfileModifyActivity.this, CourseAddActivity.class));
            }
        });
    }

    public void  setCustomActionbar() {
        ActionbarCustomUtil mActionbar = new ActionbarCustomUtil(getApplicationContext(), getSupportActionBar(), R.layout.layout_actionbar_type_back, view -> {
            view.setClickable(false);
            TextView textView = view.findViewById(R.id.title);
            textView.setText("프로필 수정");
            textView.setClickable(false);
            //ImageButton 리스너 설정
            ImageButton imageButton = view.findViewById(R.id.btnBack);
            imageButton.setOnClickListener(v -> finish());
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mActionbar.setActionBarElevation(15);
        }
    }
}
