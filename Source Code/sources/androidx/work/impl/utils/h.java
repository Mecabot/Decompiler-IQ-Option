package androidx.work.impl.utils;

import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import androidx.work.State;
import androidx.work.e;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.k;
import androidx.work.impl.g;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: StopWorkRunnable */
public class h implements Runnable {
    private String eM;
    private g eo;

    public h(g gVar, String str) {
        this.eo = gVar;
        this.eM = str;
    }

    public void run() {
        WorkDatabase bA = this.eo.bA();
        k bu = bA.bu();
        bA.beginTransaction();
        try {
            if (bu.Q(this.eM) == State.RUNNING) {
                bu.a(State.ENQUEUED, this.eM);
            }
            boolean r = this.eo.bD().r(this.eM);
            e.b("StopWorkRunnable", String.format("StopWorkRunnable for %s; Processor.stopWork = %s", new Object[]{this.eM, Boolean.valueOf(r)}), new Throwable[0]);
            bA.setTransactionSuccessful();
        } finally {
            bA.endTransaction();
        }
    }
}
