package com.rinc.bong.rivatorproject.controller.activitys;

import android.content.Intent;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.beans.Token;
import com.rinc.bong.rivatorproject.beans.User;
import com.rinc.bong.rivatorproject.retrofitBean.UserLogin;
import com.rinc.bong.rivatorproject.services.UserService;
import com.rinc.bong.rivatorproject.utils.ActionbarCustomUtil;
import com.rinc.bong.rivatorproject.utils.RetrofitUtil;
import com.rinc.bong.rivatorproject.utils.SnackBarUtill;
import com.rinc.bong.rivatorproject.utils.ToastUtill;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText editId;
    private EditText password;
    private TextView forgot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        setCustomActionbar();
    }

    private void init() {
        editId = (EditText) findViewById(R.id.id);
        password = (EditText) findViewById(R.id.password);
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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mActionbar.setActionBarElevation(15);
        }

    }

    public void login(View view) {
        UserService userService = RetrofitUtil.retrofit.create(UserService.class);
        String id = editId.getText().toString();
        String pw = password.getText().toString();
        Call<UserLogin> loginCall = userService.login(id,pw);
        loginCall.enqueue(new Callback<UserLogin>() {
            @Override
            public void onResponse(Call<UserLogin> call, Response<UserLogin> response) {
                Result result = response.body().getResult();
                View view = getWindow().getDecorView().getRootView();
                if(result.getSuccess().equals("200")) {
                    ToastUtill.makeToast(getApplicationContext(),result.getMessage(),Toast.LENGTH_LONG);

                    //유저 객체를 sqlite에 저장
                    User user = response.body().getUser();
                    Log.d("user",user.toString());
                    user.save();

                    //토큰을 sqlite에 저장
                    Token token = response.body().getToken();
                    Log.d("Token : ", token.toString());
                    token.save();
                    Intent i = new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(i);
                } else {
                    SnackBarUtill.makeSnackBar(view, result.getMessage(), Snackbar.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<UserLogin> call, Throwable t) {
                SnackBarUtill.makeSnackBar(view, "로그인에 실패하였습니다.", Snackbar.LENGTH_LONG);
            }
        });


    }
}
