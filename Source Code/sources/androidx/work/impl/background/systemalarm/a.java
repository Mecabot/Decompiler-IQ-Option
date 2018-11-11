package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.app.NotificationCompat;
import androidx.work.impl.b.d;
import androidx.work.impl.b.e;
import androidx.work.impl.g;
import androidx.work.impl.utils.c;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: Alarms */
class a {
    public static void a(@NonNull Context context, @NonNull g gVar, @NonNull String str, long j) {
        e bx = gVar.bA().bx();
        d K = bx.K(str);
        if (K != null) {
            a(context, str, K.gh);
            a(context, str, K.gh, j);
            return;
        }
        int cE = new c(context).cE();
        bx.a(new d(str, cE));
        a(context, str, cE, j);
    }

    public static void a(@NonNull Context context, @NonNull g gVar, @NonNull String str) {
        e bx = gVar.bA().bx();
        d K = bx.K(str);
        if (K != null) {
            a(context, str, K.gh);
            androidx.work.e.b("Alarms", String.format("Removing SystemIdInfo for workSpecId (%s)", new Object[]{str}), new Throwable[0]);
            bx.L(str);
        }
    }

    private static void a(@NonNull Context context, @NonNull String str, int i) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent service = PendingIntent.getService(context, i, b.b(context, str), 536870912);
        if (service != null && alarmManager != null) {
            androidx.work.e.b("Alarms", String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", new Object[]{str, Integer.valueOf(i)}), new Throwable[0]);
            alarmManager.cancel(service);
        }
    }

    private static void a(@NonNull Context context, @NonNull String str, int i, long j) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent service = PendingIntent.getService(context, i, b.b(context, str), 1073741824);
        if (alarmManager == null) {
            return;
        }
        if (VERSION.SDK_INT >= 19) {
            alarmManager.setExact(0, j, service);
        } else {
            alarmManager.set(0, j, service);
        }
    }
}
