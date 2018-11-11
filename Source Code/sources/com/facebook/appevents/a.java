package com.facebook.appevents;

import android.preference.PreferenceManager;
import android.util.Log;
import com.facebook.h;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: AnalyticsUserIDStore */
class a {
    private static final String TAG = "a";
    private static volatile boolean initialized = false;
    private static ReentrantReadWriteLock yV = new ReentrantReadWriteLock();
    private static String yW;

    a() {
    }

    public static void jW() {
        if (!initialized) {
            AppEventsLogger.kp().execute(new Runnable() {
                public void run() {
                    a.jY();
                }
            });
        }
    }

    public static String jX() {
        if (!initialized) {
            Log.w(TAG, "initStore should have been called before calling setUserID");
            jY();
        }
        yV.readLock().lock();
        try {
            String str = yW;
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
                    yW = PreferenceManager.getDefaultSharedPreferences(h.getApplicationContext()).getString("com.facebook.appevents.AnalyticsUserIDStore.userID", null);
                    initialized = true;
                    yV.writeLock().unlock();
                }
            } finally {
                yV.writeLock().unlock();
            }
        }
    }
}
