package com.rinc.bong.rivatorproject.controller.activitys;

import android.app.Dialog;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.beans.Status;
import com.rinc.bong.rivatorproject.beans.User;
import com.rinc.bong.rivatorproject.retrofitBean.UpdatePw;
import com.rinc.bong.rivatorproject.services.UserService;
import com.rinc.bong.rivatorproject.utils.ActionbarCustomUtil;
import com.rinc.bong.rivatorproject.utils.DialogUtill;
import com.rinc.bong.rivatorproject.utils.RetrofitUtil;
import com.rinc.bong.rivatorproject.utils.SnackBarUtill;
import com.rinc.bong.rivatorproject.utils.ToastUtill;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PasswordModifyActivity extends AppCompatActivity {

    private EditText password1;
    private EditText password2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_modify);
        setCustomActionbar();
        init();
    }

    private void init() {
        password1 = (EditText) findViewById(R.id.password1);
        password2 = (EditText) findViewById(R.id.password2);
    }

    public void  setCustomActionbar() {

        ActionbarCustomUtil mActionbar = new ActionbarCustomUtil(getApplicationContext(), getSupportActionBar(), R.layout.layout_actionbar_type_back, view -> {

            view.setClickable(false);

            TextView textView = (TextView) view.findViewById(R.id.title);
            textView.setText("패스워드 변경");
            textView.setClickable(false);

            //ImageButton 리스너 설정
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnBack);
            imageButton.setOnClickListener(v -> finish());
        });

    }

    public void modifyPassword(View view) {
        String pw1 = password1.getText().toString();
        String pw2 = password2.getText().toString();
        if(pw1.equals(pw2)) {
            User user = User.last(User.class);
            user.setUserPw(pw1);
            UserService userService = RetrofitUtil.getLoginRetrofit().create(UserService.class);
            UpdatePw updatePw = new UpdatePw(pw1);
            Call<Status> call = userService.updatePassword(updatePw);
            call.enqueue(new Callback<Status>() {
                @Override
                public void onResponse(Call<Status> call, Response<Status> response) {
                    Result result = response.body().getResult();
                    if(result.getSuccess().equals("200")) {
                        ToastUtill.makeToast(PasswordModifyActivity.this, result.getMessage(), Toast.LENGTH_LONG);
                        finish();
                    } else {
                        SnackBarUtill.makeSnackBar(view, result.getMessage(), Snackbar.LENGTH_LONG);
                    }
                }

                @Override
                public void onFailure(Call<Status> call, Throwable t) {
                    SnackBarUtill.makeSnackBar(view, "알 수 없는 오류가 발생하였습니다.", Snackbar.LENGTH_LONG);
                }
            });
        } else {
            DialogUtill.makeDialogWithPositiveButton("알림","비밀번호가 일치하지 않습니다", "확인", PasswordModifyActivity.this);
        }
        SnackBarUtill.makeSnackBar(view, "비밀번호가 변경되었습니다",Snackbar.LENGTH_LONG);
        //스낵바가 다 보여지고 나면 액티비티 종료
       Thread t = new Thread(() -> {
            try {
                Thread.sleep(3000);
                finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
    }
}
