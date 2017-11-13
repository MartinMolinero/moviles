package com.example.malejmol.dialogues;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;

public class fifthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        final Context context = getApplicationContext();
        int PID = 2345;
        NotificationCompat.Builder notificationBack = new NotificationCompat.Builder(this);
        notificationBack.setSmallIcon(R.mipmap.ic_launcher);
        notificationBack.setContentTitle("Notification from Lab3");
        notificationBack.setContentText("You have to enter a message");
        notificationBack.setAutoCancel(true);
        //I want to reuse previous activity from message
        Intent pendingAction = new Intent(this, fourthActivity.class);
        PendingIntent notifIntent = PendingIntent.getActivity(context, 0, pendingAction, 0);
        //actual part when notification gets action to execute
        notificationBack.setContentIntent(notifIntent);

        NotificationManager firstNotification  = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        firstNotification.notify(PID, notificationBack.build());
        Intent returnIntent = new Intent(context, MainActivity.class);
        startActivity(returnIntent);


    }
}
