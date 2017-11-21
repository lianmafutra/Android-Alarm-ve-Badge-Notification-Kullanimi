package com.bulentsiyah.androidalarmvebadgenotificationkullanimi;

/**
 * Created by Bülent SİYAH on 21.11.2017.
 */


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import me.leolin.shortcutbadger.ShortcutBadger;

public class MyReceiverBadge extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {
        try{
            int badgeCount = 5;
            ShortcutBadger.applyCount(context, badgeCount);


            //silme kodu
           // ShortcutBadger.removeCount(context);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}