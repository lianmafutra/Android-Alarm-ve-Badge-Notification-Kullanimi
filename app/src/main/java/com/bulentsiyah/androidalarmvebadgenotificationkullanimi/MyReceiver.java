package com.bulentsiyah.androidalarmvebadgenotificationkullanimi;

/**
 * Created by Bülent SİYAH on 21.11.2017.
 */


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {
        try{
            Utils.generateNotification(context);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}