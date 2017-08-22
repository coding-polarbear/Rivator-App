package com.rinc.bong.rivatorproject.utils;

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
}
