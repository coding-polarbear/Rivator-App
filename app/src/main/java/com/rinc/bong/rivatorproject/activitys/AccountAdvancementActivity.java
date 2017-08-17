package com.rinc.bong.rivatorproject.activitys;

import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.adapters.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;


public class AccountAdvancementActivity extends AppCompatActivity {
    private EditText subjectName = null;
    private Spinner category = null;
    private Spinner unitTime = null;
    private EditText request = null;
    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_advancement);
        init();
        setSpinner();
        setCustomActionbar();
    }

    private void init() {
        subjectName = (EditText) findViewById(R.id.subjectName);
        category = (Spinner) findViewById(R.id.category);
        unitTime = (Spinner) findViewById(R.id.unitTime);
        request = (EditText) findViewById(R.id.request);
    }

    private void setSpinner() {
        List<String> categoryList = new ArrayList<String>();
        categoryList.add("분야 선택");
        categoryList.add("테스트1");
        categoryList.add("테스트2");

        List<String> unitTimeList = new ArrayList<>();
        unitTimeList.add("희망 강좌시간");
        unitTimeList.add("테스트1");
        unitTimeList.add("테스트2");

        SpinnerAdapter categoryAdapter = new SpinnerAdapter(getApplicationContext(),R.layout.spinner_item,categoryList);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(categoryAdapter);

        SpinnerAdapter unitTimeAdapter = new SpinnerAdapter(getApplicationContext(),R.layout.spinner_item,unitTimeList);
        unitTimeAdapter.setDropDownViewResource(R.layout.spinner_item);
        unitTime.setAdapter(unitTimeAdapter);
    }

    public void apply(View view) {
        Snackbar.make(view,"계정 승급 신청이 완료되었습니다!",Snackbar.LENGTH_LONG).show();
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
        textView.setText("강사신청");
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
