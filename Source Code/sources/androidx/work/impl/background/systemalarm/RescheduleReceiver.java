package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import androidx.work.e;
import androidx.work.impl.g;

public class RescheduleReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (VERSION.SDK_INT >= 23) {
            g bz = g.bz();
            if (bz == null) {
                e.e("RescheduleReceiver", "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", new Throwable[0]);
                return;
            } else {
                bz.a(goAsync());
                return;
            }
        }
        context.startService(b.g(context));
    }
}
