package com.rinc.bong.rivatorproject.utils;

import android.app.ActionBar;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by Bong on 2017-08-22.
 */

public class ActionbarCustomUtil {
    private ActionBar actionBar = null;
    private Context context = null;
    private int layout = 0;
    private String actionbarName = null;

    interface OnItemClick{
        void setActionbar(View view);
    }

    public ActionbarCustomUtil(Context context, ActionBar actionBar, int layout) {
        this.context = context;
        this.actionBar = actionBar;
        this.layout = layout;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void  setCustomActionbar() {
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);

        //ActionBar의 그림자를 제거합니다
        actionBar.setElevation(0);

        //layout을 가지고 와서 actionbar에 포팅을 시킵니다.
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(layout, null);
      /*  TextView textView = (TextView) view.findViewById(R.id.title);
        textView.setText("알림");
        ImageButton backButton = (ImageButton) view.findViewById(R.id.btnBack);
        backButton.setOnClickListener(v -> {
            finish();
        });*/

        actionBar.setCustomView(view);
        Toolbar parent = (Toolbar) view.getParent();
        parent.setContentInsetsAbsolute(0,0);

    }
}
