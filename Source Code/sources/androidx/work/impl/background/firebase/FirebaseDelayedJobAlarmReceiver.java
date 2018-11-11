package androidx.work.impl.background.firebase;

import android.content.BroadcastReceiver;
import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import androidx.work.e;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.j;
import androidx.work.impl.c;
import androidx.work.impl.g;
import java.util.List;

@RestrictTo({Scope.LIBRARY_GROUP})
public class FirebaseDelayedJobAlarmReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        final PendingResult goAsync = goAsync();
        final String stringExtra = intent.getStringExtra("WORKSPEC_ID");
        final g bz = g.bz();
        if (bz == null) {
            e.e("FirebaseAlarmReceiver", "WorkManager is not initialized properly.  The most likely cause is that you disabled WorkManagerInitializer in your manifest but forgot to call WorkManager#initialize in your Application#onCreate or a ContentProvider.", new Throwable[0]);
            return;
        }
        final WorkDatabase bA = bz.bA();
        new Thread(new Runnable() {
            public void run() {
                j M = bA.bu().M(stringExtra);
                if (M != null) {
                    FirebaseJobScheduler a = FirebaseDelayedJobAlarmReceiver.a(bz);
                    if (a != null) {
                        e.b("FirebaseAlarmReceiver", String.format("Scheduling WorkSpec %s", new Object[]{stringExtra}), new Throwable[0]);
                        a.f(M);
                    } else {
                        e.e("FirebaseAlarmReceiver", "FirebaseJobScheduler not found! Cannot schedule!", new Throwable[0]);
                    }
                } else {
                    e.e("FirebaseAlarmReceiver", "WorkSpec not found! Cannot schedule!", new Throwable[0]);
                }
                goAsync.finish();
            }
        }).start();
    }

    @Nullable
    static FirebaseJobScheduler a(@NonNull g gVar) {
        List bC = gVar.bC();
        if (bC == null || bC.isEmpty()) {
            return null;
        }
        for (int i = 0; i < bC.size(); i++) {
            c cVar = (c) bC.get(i);
            if (FirebaseJobScheduler.class.isAssignableFrom(cVar.getClass())) {
                return (FirebaseJobScheduler) cVar;
            }
        }
        return null;
    }
}
