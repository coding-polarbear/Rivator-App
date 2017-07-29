package com.rinc.bong.rivatorproject.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.adapters.NoticePagerAdapter;

/**
 * Created by Bong on 2017-07-29.
 */

public class NoticeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        pagetInit();


    }

    private void pagetInit() {
        NoticePagerAdapter mNoticePagerAdapter = new NoticePagerAdapter(getSupportFragmentManager());

    }


}
