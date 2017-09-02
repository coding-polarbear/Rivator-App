package com.rinc.bong.rivatorproject.utils;

import android.app.Activity;
import android.support.v7.app.AlertDialog;

import com.rinc.bong.rivatorproject.controller.activitys.SignupTermsAgreeActivity;

/**
 * Created by baehyeonbin on 2017. 9. 3..
 */

public class DialogUtill {
    public static void makeDialogWithPositiveButton(String title, String message, String buttonText, Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(buttonText, (dialog, which) -> {});
        AlertDialog dialog = builder.create();
        dialog.show();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(v -> {
            dialog.dismiss();
        });
    }
}
