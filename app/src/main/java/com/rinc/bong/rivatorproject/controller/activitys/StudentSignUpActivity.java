package com.rinc.bong.rivatorproject.controller.activitys;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.controller.adapters.SpinnerAdapter;
import com.rinc.bong.rivatorproject.utils.ActionbarCustomUtil;

import java.util.ArrayList;
import java.util.List;

public class StudentSignUpActivity extends AppCompatActivity {

    private Spinner citySpinner;
    private Spinner districtSpinner;
    private Spinner townSpinner;
    private Spinner subjectSpinner;

    private List<String> cityList;
    private List<String> districtList;
    private List<String> townList;
    private List<String> subjectList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_sign_up);
        setCustomActionbar();
        init();
        setDummyData();
        setSpinner();
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

    public void back(View view) {
        finish();
    }

    public void next(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //기존의 액티비티 모든 스택 제거
        startActivity(intent);
    }

    private void setCustomActionbar() {

        ActionbarCustomUtil mActionbar = new ActionbarCustomUtil(getApplicationContext(), getSupportActionBar(), R.layout.layout_actionbar_type_cancle, view -> {

            TextView textView = (TextView) view.findViewById(R.id.title);
            textView.setText("프로필 작성");

            ImageButton imageButton = (ImageButton) view.findViewById(R.id.btnClose);
            imageButton.setOnClickListener( v-> finish());

        });

    }
}
