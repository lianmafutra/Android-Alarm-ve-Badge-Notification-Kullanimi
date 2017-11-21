package com.bulentsiyah.androidalarmvebadgenotificationkullanimi;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Calendar;

import me.leolin.shortcutbadger.ShortcutBadger;

public class MainActivity extends AppCompatActivity {

    public static int alarmRequest=21;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ShortcutBadger.removeCount(getApplicationContext());
    }

    public void btn_ELAPSED_REALTIME_WAKEUP(View v){
        Intent myIntent = new Intent(getApplicationContext(), MyReceiverBadge.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), alarmRequest, myIntent,0);

        //cancelAlarmIfExists(getApplicationContext(),alarmRequest,myIntent);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 30);

        AlarmManager alarmManager = (AlarmManager) getApplicationContext().getSystemService(ALARM_SERVICE);
        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                AlarmManager.INTERVAL_FIFTEEN_MINUTES,
                AlarmManager.INTERVAL_FIFTEEN_MINUTES, pendingIntent);

    }

    public void btn_RTC_WAKEUP(View v){
        Intent myIntent = new Intent(getApplicationContext(), MyReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), alarmRequest, myIntent,0);

        //cancelAlarmIfExists(getApplicationContext(),alarmRequest,myIntent);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 30);

        AlarmManager alarmManager = (AlarmManager) getApplicationContext().getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

    }

    public void cancelAlarmIfExists(Context mContext, int requestCode, Intent intent){
        try{
            PendingIntent pendingIntent = PendingIntent.getBroadcast(mContext, requestCode, intent,0);
            AlarmManager alarmManager=(AlarmManager)mContext.getSystemService(ALARM_SERVICE);
            alarmManager.cancel(pendingIntent);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
