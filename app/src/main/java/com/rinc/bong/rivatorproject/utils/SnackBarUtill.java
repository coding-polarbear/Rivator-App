package com.rinc.bong.rivatorproject.utils;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by baehyeonbin on 2017. 8. 22..
 */

public class SnackBarUtill {
    public static void makeSnackBar(View view, String text, int length) {
        Snackbar.make(view, text, length).show();
    }

    public static void makeSnackbarWithFinish(View view, String text, int length, Activity activity) {
        Snackbar.make(view, text, length).show();
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(3000);
                activity.finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
    }
}
