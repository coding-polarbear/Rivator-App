package com.rinc.bong.rivatorproject.controller.activitys;

import android.content.Intent;
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
        logout.setOnClickListener(v -> {
            UserService userService = RetrofitUtil.retrofit.create(UserService.class);
            Call<Status> resultCall = userService.logout();
            resultCall.enqueue(new Callback<Status>() {
                @Override
                public void onResponse(Call<Status> call, Response<Status> response) {
                    Result result = response.body().getResult();
                    Log.d("test", result.toString());
                    if(result.getSuccess().equals("200")) {
                        ToastUtill.makeToast(ProfileModifyActivity.this, result.getMessage(), Toast.LENGTH_LONG);
                        User.deleteAll(User.class);
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //기존의 액티비티 모든 스택 제거
                        startActivity(intent);
                    } else {
                        SnackBarUtill.makeSnackBar(v, result.getMessage(), Snackbar.LENGTH_LONG);
                    }
                }

                @Override
                public void onFailure(Call<Status> call, Throwable t) {
                    SnackBarUtill.makeSnackBar(v, "알 수 없는 오류가 발생하였습니다",Snackbar.LENGTH_LONG);
                }
            });
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
