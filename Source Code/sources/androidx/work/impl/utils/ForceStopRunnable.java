package androidx.work.impl.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.VisibleForTesting;
import android.support.v4.app.NotificationCompat;
import androidx.work.e;
import androidx.work.impl.g;
import java.util.concurrent.TimeUnit;

@RestrictTo({Scope.LIBRARY_GROUP})
public class ForceStopRunnable implements Runnable {
    private static final long gX = TimeUnit.DAYS.toMillis(3650);
    private final g fu;
    private final Context mContext;

    @RestrictTo({Scope.LIBRARY_GROUP})
    public static class BroadcastReceiver extends android.content.BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                if ("ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                    e.a("ForceStopRunnable$Rcvr", "Rescheduling alarm that keeps track of force-stops.", new Throwable[0]);
                    ForceStopRunnable.k(context);
                }
            }
        }
    }

    public ForceStopRunnable(@NonNull Context context, @NonNull g gVar) {
        this.mContext = context.getApplicationContext();
        this.fu = gVar;
    }

    public void run() {
        if (cC()) {
            e.b("ForceStopRunnable", "Rescheduling Workers.", new Throwable[0]);
            this.fu.bG();
            this.fu.bF().u(false);
        } else if (cB()) {
            e.b("ForceStopRunnable", "Application was force-stopped, rescheduling.", new Throwable[0]);
            this.fu.bG();
        }
        this.fu.bH();
    }

    @VisibleForTesting
    public boolean cB() {
        if (a(this.mContext, 536870912) != null) {
            return false;
        }
        k(this.mContext);
        return true;
    }

    @VisibleForTesting
    boolean cC() {
        return this.fu.bF().cF();
    }

    private static PendingIntent a(Context context, int i) {
        return PendingIntent.getBroadcast(context, -1, j(context), i);
    }

    @VisibleForTesting
    static Intent j(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return intent;
    }

    static void k(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent a = a(context, 134217728);
        long currentTimeMillis = System.currentTimeMillis() + gX;
        if (alarmManager == null) {
            return;
        }
        if (VERSION.SDK_INT >= 19) {
            alarmManager.setExact(0, currentTimeMillis, a);
        } else {
            alarmManager.set(0, currentTimeMillis, a);
        }
    }
}
