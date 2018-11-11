package androidx.work.impl.background.systemalarm;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import androidx.work.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: WorkTimer */
class g {
    private final ScheduledExecutorService fA = Executors.newSingleThreadScheduledExecutor();
    final Map<String, b> fB = new HashMap();
    final Map<String, a> fC = new HashMap();
    final Object mLock = new Object();

    /* compiled from: WorkTimer */
    interface a {
        void C(@NonNull String str);
    }

    /* compiled from: WorkTimer */
    static class b implements Runnable {
        private final String eM;
        private final g ft;

        b(@NonNull g gVar, @NonNull String str) {
            this.ft = gVar;
            this.eM = str;
        }

        public void run() {
            synchronized (this.ft.mLock) {
                if (this.ft.fB.containsKey(this.eM)) {
                    this.ft.fB.remove(this.eM);
                    a aVar = (a) this.ft.fC.remove(this.eM);
                    if (aVar != null) {
                        aVar.C(this.eM);
                    }
                } else {
                    e.b("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", new Object[]{this.eM}), new Throwable[0]);
                }
            }
        }
    }

    g() {
    }

    void a(@NonNull String str, long j, @NonNull a aVar) {
        synchronized (this.mLock) {
            e.b("WorkTimer", String.format("Starting timer for %s", new Object[]{str}), new Throwable[0]);
            E(str);
            Runnable bVar = new b(this, str);
            this.fB.put(str, bVar);
            this.fC.put(str, aVar);
            this.fA.schedule(bVar, j, TimeUnit.MILLISECONDS);
        }
    }

    void E(@NonNull String str) {
        synchronized (this.mLock) {
            if (this.fB.containsKey(str)) {
                e.b("WorkTimer", String.format("Stopping timer for %s", new Object[]{str}), new Throwable[0]);
                this.fB.remove(str);
                this.fC.remove(str);
            }
        }
    }
}
