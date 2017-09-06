package com.rinc.bong.rivatorproject.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by baehy on 2017. 9. 5..
 */

public class ToastUtill {
    public static void makeToast(Context context, String message, int time) {
        Toast.makeText(context, message, time).show();
    }
}
