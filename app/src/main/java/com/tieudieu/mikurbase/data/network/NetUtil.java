package com.tieudieu.mikurbase.data.network;

import android.content.Context;
import android.provider.Settings;

import java.util.Calendar;

/**
 * Created by chienchieu on 17/03/2016.
 */
public class NetUtil {

    /**
     * getTimestamp
     */
    public static long getTimestampInSeconds() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTimeInMillis()/1000;
    }

    /**
     * get ANDROID_ID
     */
    public static String getAndroidId(Context context) {
        String android_id = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        return android_id;
    }
}
