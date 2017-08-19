package com.rinc.bong.rivatorproject.FCMServices;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.activitys.NoticeActivity;

/**
 * Created by baehyeonbin on 2017. 8. 20..
 */

public class RivatorFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG="FirebaseMessageService";

    //앱이 실행중일때 알림 띄우기 (foreground)
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String messageBody = remoteMessage.getData().get("message");
        String title = remoteMessage.getData().get("title");
        sendNotification(messageBody, title);
    }

    //알림 띄우기
    private void sendNotification(String messageBody,String title) {
        Intent intent = new Intent(this,NoticeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /*request code*/, intent, PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificationBuilder.build());
    }
}
