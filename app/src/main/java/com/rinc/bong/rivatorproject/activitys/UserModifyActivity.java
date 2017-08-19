package com.rinc.bong.rivatorproject.activitys;

import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.adapters.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

public class UserModifyActivity extends AppCompatActivity {
    private ActionBar actionBar;
    private Spinner citySpinner = null;
    private Spinner districtSpinner = null;
    private Spinner townSpinner = null;
    private Spinner subjectSpinner = null;
    private List<String> cityList;
    private List<String> districtList;
    private List<String> townList;
    private List<String> subjectList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_modify);
        init();
        setDummyData();
        setSpinner();
        setCustomActionbar();
    }

    private void init() {
        citySpinner = (Spinner) findViewById(R.id.citySpinner);
        districtSpinner = (Spinner) findViewById(R.id.districSpinner);
        townSpinner = (Spinner) findViewById(R.id.townSpinner);
        subjectSpinner = (Spinner) findViewById(R.id.subjectSpinner);
    }

    private void setDummyData() {
        cityList = new ArrayList<>();
        cityList.add("시");
        cityList.add("서울");
        cityList.add("인천");
        cityList.add("시흥");
        cityList.add("하남");

        districtList = new ArrayList<>();
        districtList.add("구/군");
        districtList.add("마포구");
        districtList.add("서대문구");
        districtList.add("은평구");
        districtList.add("중구");

        townList = new ArrayList<>();
        townList.add("동/읍/면");
        townList.add("홍제동");
        townList.add("홍은동");
        townList.add("북가좌동");
        townList.add("남가좌동");

        subjectList = new ArrayList<>();
        subjectList.add("선택해주십시오");
        subjectList.add("C언어");
        subjectList.add("JAVA");
        subjectList.add("유니티");
        subjectList.add("안드로이드 앱개발");
        subjectList.add("웹 프로그래밍");
    }
    private void setSpinner() {
        SpinnerAdapter cityAdapter = new SpinnerAdapter(getApplicationContext(),R.layout.sign_up_spinner_item,cityList);
        SpinnerAdapter districtAdapter = new SpinnerAdapter(getApplicationContext(),R.layout.sign_up_spinner_item,districtList);
        SpinnerAdapter townAdapter = new SpinnerAdapter(getApplicationContext(),R.layout.sign_up_spinner_item,townList);
        SpinnerAdapter subjectAdapter = new SpinnerAdapter(getApplicationContext(),R.layout.sign_up_spinner_item,subjectList);

        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        townAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        citySpinner.setAdapter(cityAdapter);
        districtSpinner.setAdapter(districtAdapter);
        townSpinner.setAdapter(townAdapter);
        subjectSpinner.setAdapter(subjectAdapter);
    }

    public void modifyUser(View view) {
        Snackbar.make(view,"계정 정보 변경이 완료되었습니다.",Snackbar.LENGTH_LONG).show();
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

    public void  setCustomActionbar() {
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);

        //layout을 가지고 와서 actionbar에 포팅을 시킵니다.
        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.layout_actionbar_type_back, null);
        customView.setClickable(false);
        TextView textView = (TextView) customView.findViewById(R.id.title);
        textView.setText("계정정보 수정");
        textView.setClickable(false);

        //ImageButton 리스너 설정
        ImageButton imageButton = (ImageButton) customView.findViewById(R.id.btnBack);
        imageButton.setOnClickListener(v -> {
            finish();
        });
        actionBar.setCustomView(customView);

        Toolbar parent = (Toolbar) customView.getParent();
        parent.setContentInsetsAbsolute(0,0);
    }
}
