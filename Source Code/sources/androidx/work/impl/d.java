package androidx.work.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import androidx.work.a;
import androidx.work.impl.b.j;
import androidx.work.impl.b.k;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.background.systemalarm.f;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.background.systemjob.b;
import androidx.work.impl.utils.e;
import java.util.List;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: Schedulers */
public class d {
    public static void a(@NonNull a aVar, @NonNull WorkDatabase workDatabase, List<c> list) {
        if (list != null && list.size() != 0) {
            k bu = workDatabase.bu();
            workDatabase.beginTransaction();
            try {
                List<j> l = bu.l(aVar.aE());
                if (l != null && l.size() > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (j jVar : l) {
                        bu.c(jVar.id, currentTimeMillis);
                    }
                }
                workDatabase.setTransactionSuccessful();
                if (l != null && l.size() > 0) {
                    j[] jVarArr = (j[]) l.toArray(new j[0]);
                    for (c a : list) {
                        a.a(jVarArr);
                    }
                }
            } finally {
                workDatabase.endTransaction();
            }
        }
    }

    @SuppressLint({"NewApi"})
    @NonNull
    static c a(@NonNull Context context, @NonNull g gVar) {
        c bVar;
        boolean z;
        boolean z2 = false;
        if (VERSION.SDK_INT >= 23) {
            bVar = new b(context, gVar);
            e.a(context, SystemJobService.class, true);
            androidx.work.e.b("Schedulers", "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
            z = false;
        } else {
            try {
                bVar = e(context);
                try {
                    androidx.work.e.b("Schedulers", "Created FirebaseJobScheduler", new Throwable[0]);
                    z = true;
                } catch (Exception unused) {
                    z = true;
                    bVar = new f(context);
                    androidx.work.e.b("Schedulers", "Created SystemAlarmScheduler", new Throwable[0]);
                    z2 = true;
                    e.a(context, Class.forName("androidx.work.impl.background.firebase.FirebaseJobService"), z);
                }
            } catch (Exception unused2) {
                z = false;
                bVar = new f(context);
                androidx.work.e.b("Schedulers", "Created SystemAlarmScheduler", new Throwable[0]);
                z2 = true;
                e.a(context, Class.forName("androidx.work.impl.background.firebase.FirebaseJobService"), z);
            }
        }
        try {
            e.a(context, Class.forName("androidx.work.impl.background.firebase.FirebaseJobService"), z);
        } catch (ClassNotFoundException unused3) {
            e.a(context, SystemAlarmService.class, z2);
            return bVar;
        }
    }

    @NonNull
    private static c e(@NonNull Context context) {
        return (c) Class.forName("androidx.work.impl.background.firebase.FirebaseJobScheduler").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
    }
}
