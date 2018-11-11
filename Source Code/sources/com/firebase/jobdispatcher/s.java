package com.firebase.jobdispatcher;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Locale;

/* compiled from: JobService */
public abstract class s extends Service {
    private static final Handler Kq = new Handler(Looper.getMainLooper());
    private final SimpleArrayMap<String, a> Kr = new SimpleArrayMap(1);
    private final com.firebase.jobdispatcher.m.a Ks = new com.firebase.jobdispatcher.m.a() {
        public void a(Bundle bundle, l lVar) {
            a D = GooglePlayReceiver.oH().D(bundle);
            if (D == null) {
                Log.wtf("FJD.JobService", "start: unknown invocation provided");
            } else {
                s.this.a(D.oP(), lVar);
            }
        }

        public void a(Bundle bundle, boolean z) {
            a D = GooglePlayReceiver.oH().D(bundle);
            if (D == null) {
                Log.wtf("FJD.JobService", "stop: unknown invocation provided");
            } else {
                s.this.a(D.oP(), z);
            }
        }
    };

    /* compiled from: JobService */
    private static final class a {
        final r Kx;
        final l Ky;

        /* synthetic */ a(r rVar, l lVar, AnonymousClass1 anonymousClass1) {
            this(rVar, lVar);
        }

        private a(r rVar, l lVar) {
            this.Kx = rVar;
            this.Ky = lVar;
        }

        void at(int i) {
            try {
                this.Ky.a(GooglePlayReceiver.oH().e(this.Kx, new Bundle()), i);
            } catch (Throwable e) {
                Log.e("FJD.JobService", "Failed to send result to driver", e);
            }
        }
    }

    @MainThread
    public abstract boolean a(r rVar);

    @MainThread
    public abstract boolean b(r rVar);

    public final void onStart(Intent intent, int i) {
    }

    void a(final r rVar, l lVar) {
        synchronized (this.Kr) {
            if (this.Kr.containsKey(rVar.getTag())) {
                Log.w("FJD.JobService", String.format(Locale.US, "Job with tag = %s was already running.", new Object[]{rVar.getTag()}));
                return;
            }
            this.Kr.put(rVar.getTag(), new a(rVar, lVar, null));
            Kq.post(new Runnable() {
                public void run() {
                    synchronized (s.this.Kr) {
                        if (!s.this.a(rVar)) {
                            a aVar = (a) s.this.Kr.remove(rVar.getTag());
                            if (aVar != null) {
                                aVar.at(0);
                            }
                        }
                    }
                }
            });
        }
    }

    /* JADX WARNING: Missing block: B:9:0x0022, code:
            return;
     */
    void a(final com.firebase.jobdispatcher.r r5, final boolean r6) {
        /*
        r4 = this;
        r0 = r4.Kr;
        monitor-enter(r0);
        r1 = r4.Kr;	 Catch:{ all -> 0x002f }
        r2 = r5.getTag();	 Catch:{ all -> 0x002f }
        r1 = r1.remove(r2);	 Catch:{ all -> 0x002f }
        r1 = (com.firebase.jobdispatcher.s.a) r1;	 Catch:{ all -> 0x002f }
        if (r1 != 0) goto L_0x0023;
    L_0x0011:
        r5 = "FJD.JobService";
        r6 = 3;
        r5 = android.util.Log.isLoggable(r5, r6);	 Catch:{ all -> 0x002f }
        if (r5 == 0) goto L_0x0021;
    L_0x001a:
        r5 = "FJD.JobService";
        r6 = "Provided job has already been executed.";
        android.util.Log.d(r5, r6);	 Catch:{ all -> 0x002f }
    L_0x0021:
        monitor-exit(r0);	 Catch:{ all -> 0x002f }
        return;
    L_0x0023:
        r2 = Kq;	 Catch:{ all -> 0x002f }
        r3 = new com.firebase.jobdispatcher.s$3;	 Catch:{ all -> 0x002f }
        r3.<init>(r5, r6, r1);	 Catch:{ all -> 0x002f }
        r2.post(r3);	 Catch:{ all -> 0x002f }
        monitor-exit(r0);	 Catch:{ all -> 0x002f }
        return;
    L_0x002f:
        r5 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x002f }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.jobdispatcher.s.a(com.firebase.jobdispatcher.r, boolean):void");
    }

    public final void b(@NonNull r rVar, boolean z) {
        if (rVar == null) {
            Log.e("FJD.JobService", "jobFinished called with a null JobParameters");
            return;
        }
        synchronized (this.Kr) {
            a aVar = (a) this.Kr.remove(rVar.getTag());
            if (aVar != null) {
                aVar.at(z);
            }
        }
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        stopSelf(i2);
        return 2;
    }

    @Nullable
    public final IBinder onBind(Intent intent) {
        return this.Ks;
    }

    @MainThread
    public final boolean onUnbind(Intent intent) {
        synchronized (this.Kr) {
            for (int size = this.Kr.size() - 1; size >= 0; size--) {
                a aVar = (a) this.Kr.remove(this.Kr.keyAt(size));
                if (aVar != null) {
                    aVar.at(b(aVar.Kx) ? 1 : 2);
                }
            }
        }
        return super.onUnbind(intent);
    }

    public final void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    protected final void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(fileDescriptor, printWriter, strArr);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public final void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
    }
}
