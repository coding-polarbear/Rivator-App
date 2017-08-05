package com.rinc.bong.rivatorproject.activitys;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;

public class CalendarActivity extends AppCompatActivity {
    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        setCustomActionbar();
    }

      /* custom ActionBar
       백그라운드 설정 및 뒤로가기 버튼 달린 커스텀 액션바
     */

    public void  setCustomActionbar() {
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);

        //ActionBar의 그림자를 제거합니다
        actionBar.setElevation(0);

        //layout을 가지고 와서 actionbar에 포팅을 시킵니다.
        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View actionbar = inflater.inflate(R.layout.custom_action_bar, null);
        TextView textView = (TextView) actionbar.findViewById(R.id.title);
        textView.setText("캘린더");
        actionBar.setCustomView(actionbar);

        Toolbar parent = (Toolbar) actionbar.getParent();
        parent.setContentInsetsAbsolute(0,0);
    }
}
