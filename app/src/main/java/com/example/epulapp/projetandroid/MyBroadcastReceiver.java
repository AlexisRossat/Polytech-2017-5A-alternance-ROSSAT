package com.example.epulapp.projetandroid;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import static android.provider.Settings.Global.getString;

/**
 * Created by Epulapp on 29/11/2017.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("DEBUG_PROJET", "Broadcast recu");

        NotificationManager mNotification = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.ic_volume_up)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!");

        mNotification.notify(111, mBuilder.build());
    }
}
