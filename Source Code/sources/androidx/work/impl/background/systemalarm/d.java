package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.os.PowerManager.WakeLock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.WorkerThread;
import androidx.work.e;
import androidx.work.impl.a;
import androidx.work.impl.a.c;
import androidx.work.impl.b.j;
import androidx.work.impl.utils.i;
import java.util.Collections;
import java.util.List;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: DelayMetCommandHandler */
public class d implements a, c, a {
    private final String eM;
    private final androidx.work.impl.a.d fk = new androidx.work.impl.a.d(this.mContext, this);
    private final e fo;
    private boolean fq = false;
    @Nullable
    private WakeLock fr;
    private boolean fs = false;
    private final Context mContext;
    private final Object mLock = new Object();
    private final int mStartId;

    d(@NonNull Context context, int i, @NonNull String str, @NonNull e eVar) {
        this.mContext = context;
        this.mStartId = i;
        this.fo = eVar;
        this.eM = str;
    }

    public void h(@NonNull List<String> list) {
        e.b("DelayMetCommandHandler", String.format("onAllConstraintsMet for %s", new Object[]{this.eM}), new Throwable[0]);
        if (this.fo.bD().q(this.eM)) {
            this.fo.bW().a(this.eM, 600000, this);
        } else {
            bV();
        }
    }

    public void a(@NonNull String str, boolean z, boolean z2) {
        e.b("DelayMetCommandHandler", String.format("onExecuted %s, %s, %s", new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}), new Throwable[0]);
        bV();
        if (this.fs) {
            this.fo.d(new a(this.fo, b.f(this.mContext), this.mStartId));
        }
    }

    public void C(@NonNull String str) {
        e.b("DelayMetCommandHandler", String.format("Exceeded time limits on execution for %s", new Object[]{str}), new Throwable[0]);
        bU();
    }

    public void i(@NonNull List<String> list) {
        bU();
    }

    @WorkerThread
    void bT() {
        this.fr = i.d(this.mContext, String.format("%s (%s)", new Object[]{this.eM, Integer.valueOf(this.mStartId)}));
        e.b("DelayMetCommandHandler", String.format("Acquiring wakelock %s for WorkSpec %s", new Object[]{this.fr, this.eM}), new Throwable[0]);
        this.fr.acquire();
        j M = this.fo.bX().bA().bu().M(this.eM);
        this.fs = M.cu();
        if (this.fs) {
            this.fk.j(Collections.singletonList(M));
            return;
        }
        e.b("DelayMetCommandHandler", String.format("No constraints for %s", new Object[]{this.eM}), new Throwable[0]);
        h(Collections.singletonList(this.eM));
    }

    private void bU() {
        synchronized (this.mLock) {
            if (this.fq) {
                e.b("DelayMetCommandHandler", String.format("Already stopped work for %s", new Object[]{this.eM}), new Throwable[0]);
            } else {
                e.b("DelayMetCommandHandler", String.format("Stopping work for workspec %s", new Object[]{this.eM}), new Throwable[0]);
                this.fo.d(new a(this.fo, b.c(this.mContext, this.eM), this.mStartId));
                if (this.fo.bD().u(this.eM)) {
                    e.b("DelayMetCommandHandler", String.format("WorkSpec %s needs to be rescheduled", new Object[]{this.eM}), new Throwable[0]);
                    this.fo.d(new a(this.fo, b.a(this.mContext, this.eM), this.mStartId));
                } else {
                    e.b("DelayMetCommandHandler", String.format("Processor does not have WorkSpec %s. No need to reschedule ", new Object[]{this.eM}), new Throwable[0]);
                }
                this.fq = true;
            }
        }
    }

    private void bV() {
        synchronized (this.mLock) {
            this.fo.bW().E(this.eM);
            if (this.fr != null && this.fr.isHeld()) {
                e.b("DelayMetCommandHandler", String.format("Releasing wakelock %s for WorkSpec %s", new Object[]{this.fr, this.eM}), new Throwable[0]);
                this.fr.release();
            }
        }
    }
}
