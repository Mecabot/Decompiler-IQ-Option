package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager.WakeLock;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import androidx.work.impl.g;
import androidx.work.impl.utils.i;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: SystemAlarmDispatcher */
public class e implements androidx.work.impl.a {
    private final Handler ak;
    private final androidx.work.impl.b eF;
    private final g ft;
    private final g fu;
    final b fv;
    final List<Intent> fw;
    private final ExecutorService fx;
    @Nullable
    private c fy;
    final Context mContext;

    /* compiled from: SystemAlarmDispatcher */
    static class a implements Runnable {
        private final e fo;
        private final Intent mIntent;
        private final int mStartId;

        a(@NonNull e eVar, @NonNull Intent intent, int i) {
            this.fo = eVar;
            this.mIntent = intent;
            this.mStartId = i;
        }

        public void run() {
            this.fo.a(this.mIntent, this.mStartId);
        }
    }

    /* compiled from: SystemAlarmDispatcher */
    static class b implements Runnable {
        private final e fo;

        b(@NonNull e eVar) {
            this.fo = eVar;
        }

        public void run() {
            this.fo.bY();
        }
    }

    /* compiled from: SystemAlarmDispatcher */
    interface c {
        void cb();
    }

    e(@NonNull Context context) {
        this(context, null, null);
    }

    @VisibleForTesting
    e(@NonNull Context context, @Nullable androidx.work.impl.b bVar, @Nullable g gVar) {
        this.mContext = context.getApplicationContext();
        this.fv = new b(this.mContext);
        this.ft = new g();
        if (gVar == null) {
            gVar = g.bz();
        }
        this.fu = gVar;
        if (bVar == null) {
            bVar = this.fu.bD();
        }
        this.eF = bVar;
        this.eF.a(this);
        this.fw = new ArrayList();
        this.ak = new Handler(Looper.getMainLooper());
        this.fx = Executors.newSingleThreadExecutor();
    }

    void onDestroy() {
        this.eF.b(this);
        this.fy = null;
    }

    public void a(@NonNull String str, boolean z, boolean z2) {
        d(new a(this, b.a(this.mContext, str, z, z2), 0));
    }

    @MainThread
    public boolean a(@NonNull Intent intent, int i) {
        ca();
        CharSequence action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            androidx.work.e.d("SystemAlarmDispatcher", "Unknown command. Ignoring", new Throwable[0]);
            return false;
        } else if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && D("ACTION_CONSTRAINTS_CHANGED")) {
            return false;
        } else {
            intent.putExtra("KEY_START_ID", i);
            synchronized (this.fw) {
                this.fw.add(intent);
            }
            bZ();
            return true;
        }
    }

    void a(@NonNull c cVar) {
        if (this.fy != null) {
            androidx.work.e.e("SystemAlarmDispatcher", "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            this.fy = cVar;
        }
    }

    androidx.work.impl.b bD() {
        return this.eF;
    }

    g bW() {
        return this.ft;
    }

    g bX() {
        return this.fu;
    }

    void d(@NonNull Runnable runnable) {
        this.ak.post(runnable);
    }

    @MainThread
    void bY() {
        ca();
        synchronized (this.fw) {
            if (!this.fv.bR() && this.fw.isEmpty()) {
                androidx.work.e.b("SystemAlarmDispatcher", "No more commands & intents.", new Throwable[0]);
                if (this.fy != null) {
                    this.fy.cb();
                }
            }
        }
    }

    @MainThread
    private void bZ() {
        ca();
        WakeLock d = i.d(this.mContext, "ProcessCommand");
        try {
            d.acquire();
            this.fx.submit(new Runnable() {
                public void run() {
                    Intent intent;
                    synchronized (e.this.fw) {
                        intent = (Intent) e.this.fw.get(0);
                    }
                    if (intent != null) {
                        String action = intent.getAction();
                        androidx.work.e.b("SystemAlarmDispatcher", String.format("Processing command %s, %s", new Object[]{intent, Integer.valueOf(intent.getIntExtra("KEY_START_ID", 0))}), new Throwable[0]);
                        WakeLock d = i.d(e.this.mContext, String.format("%s (%s)", new Object[]{action, Integer.valueOf(r3)}));
                        try {
                            androidx.work.e.b("SystemAlarmDispatcher", String.format("Acquiring operation wake lock (%s) %s", new Object[]{action, d}), new Throwable[0]);
                            d.acquire();
                            e.this.fv.a(intent, r3, e.this);
                            synchronized (e.this.fw) {
                                e.this.fw.remove(0);
                            }
                            androidx.work.e.b("SystemAlarmDispatcher", String.format("Releasing operation wake lock (%s) %s", new Object[]{action, d}), new Throwable[0]);
                            d.release();
                            e.this.d(new b(e.this));
                        } catch (Throwable th) {
                            synchronized (e.this.fw) {
                                e.this.fw.remove(0);
                                androidx.work.e.b("SystemAlarmDispatcher", String.format("Releasing operation wake lock (%s) %s", new Object[]{action, d}), new Throwable[0]);
                                d.release();
                                e.this.d(new b(e.this));
                            }
                        }
                    }
                }
            });
        } finally {
            d.release();
        }
    }

    @MainThread
    private boolean D(@NonNull String str) {
        ca();
        synchronized (this.fw) {
            for (Intent action : this.fw) {
                if (str.equals(action.getAction())) {
                    return true;
                }
            }
            return false;
        }
    }

    private void ca() {
        if (this.ak.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }
}
