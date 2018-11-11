package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobInfo.TriggerContentUri;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.VisibleForTesting;
import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.b;
import androidx.work.e;
import androidx.work.impl.b.j;
import java.util.Iterator;

@RequiresApi(api = 23)
@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: SystemJobInfoConverter */
class a {
    private final ComponentName fD;

    @VisibleForTesting(otherwise = 3)
    a(@NonNull Context context) {
        this.fD = new ComponentName(context.getApplicationContext(), SystemJobService.class);
    }

    JobInfo a(j jVar, int i) {
        b bVar = jVar.gv;
        int c = c(bVar.aH());
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", jVar.id);
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", jVar.isPeriodic());
        Builder extras = new Builder(i, this.fD).setRequiredNetworkType(c).setRequiresCharging(bVar.aI()).setRequiresDeviceIdle(bVar.aJ()).setExtras(persistableBundle);
        if (!bVar.aJ()) {
            extras.setBackoffCriteria(jVar.gy, jVar.gx == BackoffPolicy.LINEAR ? 0 : 1);
        }
        if (!jVar.isPeriodic()) {
            extras.setMinimumLatency(jVar.gs);
        } else if (VERSION.SDK_INT >= 24) {
            extras.setPeriodic(jVar.gt, jVar.gu);
        } else {
            e.b("SystemJobInfoConverter", "Flex duration is currently not supported before API 24. Ignoring.", new Throwable[0]);
            extras.setPeriodic(jVar.gt);
        }
        if (VERSION.SDK_INT >= 24 && bVar.aN()) {
            Iterator it = bVar.aM().iterator();
            while (it.hasNext()) {
                extras.addTriggerContentUri(b((androidx.work.c.a) it.next()));
            }
        }
        extras.setPersisted(false);
        if (VERSION.SDK_INT >= 26) {
            extras.setRequiresBatteryNotLow(bVar.aK());
            extras.setRequiresStorageNotLow(bVar.aL());
        }
        return extras.build();
    }

    @RequiresApi(24)
    private static TriggerContentUri b(androidx.work.c.a aVar) {
        return new TriggerContentUri(aVar.getUri(), aVar.aP());
    }

    static int c(NetworkType networkType) {
        switch (networkType) {
            case NOT_REQUIRED:
                return 0;
            case CONNECTED:
                return 1;
            case UNMETERED:
                return 2;
            case NOT_ROAMING:
                if (VERSION.SDK_INT >= 24) {
                    return 3;
                }
                break;
            case METERED:
                if (VERSION.SDK_INT >= 26) {
                    return 4;
                }
                break;
        }
        e.b("SystemJobInfoConverter", String.format("API version too low. Cannot convert network type value %s", new Object[]{networkType}), new Throwable[0]);
        return 1;
    }
}
