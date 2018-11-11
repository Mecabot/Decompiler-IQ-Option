package com.facebook.appevents;

import android.preference.PreferenceManager;
import android.util.Log;
import com.facebook.h;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: UserDataStore */
public class g {
    private static final String TAG = "g";
    private static volatile boolean initialized = false;
    private static ReentrantReadWriteLock yV = new ReentrantReadWriteLock();
    private static String zy;

    public static void jW() {
        if (!initialized) {
            AppEventsLogger.kp().execute(new Runnable() {
                public void run() {
                    g.jY();
                }
            });
        }
    }

    public static String ks() {
        if (!initialized) {
            Log.w(TAG, "initStore should have been called before calling setUserID");
            jY();
        }
        yV.readLock().lock();
        try {
            String str = zy;
            return str;
        } finally {
            yV.readLock().unlock();
        }
    }

    private static void jY() {
        if (!initialized) {
            yV.writeLock().lock();
            try {
                if (!initialized) {
                    zy = PreferenceManager.getDefaultSharedPreferences(h.getApplicationContext()).getString("com.facebook.appevents.UserDataStore.userData", null);
                    initialized = true;
                    yV.writeLock().unlock();
                }
            } finally {
                yV.writeLock().unlock();
            }
        }
    }
}
