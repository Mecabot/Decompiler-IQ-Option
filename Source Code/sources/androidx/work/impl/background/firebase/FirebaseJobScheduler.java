package androidx.work.impl.background.firebase;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.app.NotificationCompat;
import androidx.work.impl.b.j;
import androidx.work.impl.c;
import com.firebase.jobdispatcher.e;
import com.firebase.jobdispatcher.n;

@RestrictTo({Scope.LIBRARY_GROUP})
public class FirebaseJobScheduler implements c {
    private final e fe;
    private final a fg;
    private androidx.work.impl.utils.c fh;
    private AlarmManager fi;
    private final Context mAppContext;

    public void a(j... jVarArr) {
        for (j jVar : jVarArr) {
            if (jVar.ct() > System.currentTimeMillis()) {
                g(jVar);
            } else {
                f(jVar);
            }
        }
    }

    public void x(@NonNull String str) {
        this.fe.cr(str);
    }

    void f(j jVar) {
        n a = this.fg.a(jVar);
        androidx.work.e.b("FirebaseJobScheduler", String.format("Scheduling work now, ID: %s", new Object[]{jVar.id}), new Throwable[0]);
        if (this.fe.a(a) != 0) {
            androidx.work.e.e("FirebaseJobScheduler", String.format("Schedule failed. Result = %s", new Object[]{Integer.valueOf(this.fe.a(a))}), new Throwable[0]);
        }
    }

    private void g(j jVar) {
        if (this.fi == null) {
            this.fi = (AlarmManager) this.mAppContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
        }
        if (this.fh == null) {
            this.fh = new androidx.work.impl.utils.c(this.mAppContext);
        }
        androidx.work.e.b("FirebaseJobScheduler", String.format("Scheduling work later, ID: %s", new Object[]{jVar.id}), new Throwable[0]);
        PendingIntent h = h(jVar);
        long ct = jVar.ct();
        if (VERSION.SDK_INT >= 19) {
            this.fi.setExact(0, ct, h);
        } else {
            this.fi.set(0, ct, h);
        }
    }

    private PendingIntent h(j jVar) {
        Intent intent = new Intent(this.mAppContext, FirebaseDelayedJobAlarmReceiver.class);
        intent.putExtra("WORKSPEC_ID", jVar.id);
        return PendingIntent.getBroadcast(this.mAppContext, this.fh.cD(), intent, 0);
    }
}
