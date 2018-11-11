package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import androidx.work.e;
import androidx.work.impl.b.j;
import androidx.work.impl.c;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: SystemAlarmScheduler */
public class f implements c {
    private final Context mContext;

    public f(@NonNull Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void a(j... jVarArr) {
        for (j i : jVarArr) {
            i(i);
        }
    }

    public void x(@NonNull String str) {
        this.mContext.startService(b.c(this.mContext, str));
    }

    private void i(@NonNull j jVar) {
        e.b("SystemAlarmScheduler", String.format("Scheduling work with workSpecId %s", new Object[]{jVar.id}), new Throwable[0]);
        this.mContext.startService(b.a(this.mContext, jVar.id));
    }
}
