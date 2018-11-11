package com.google.android.youtube.player.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.youtube.player.YouTubeInitializationResult;
import java.util.ArrayList;

public abstract class s<T extends IInterface> implements u {
    private T Lt;
    private ArrayList<com.google.android.youtube.player.internal.u.b> Lu;
    private final ArrayList<b<?>> Lv = new ArrayList();
    private ServiceConnection Lw;
    final Handler a;
    private final Context b;
    private ArrayList<com.google.android.youtube.player.internal.u.a> d;
    private final ArrayList<com.google.android.youtube.player.internal.u.a> e = new ArrayList();
    private boolean f = false;
    private boolean h = false;
    private boolean k = false;

    /* renamed from: com.google.android.youtube.player.internal.s$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[YouTubeInitializationResult.values().length];

        static {
            try {
                a[YouTubeInitializationResult.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    final class a extends Handler {
        a() {
        }

        public final void handleMessage(Message message) {
            if (message.what == 3) {
                s.this.a((YouTubeInitializationResult) message.obj);
            } else if (message.what == 4) {
                synchronized (s.this.d) {
                    if (s.this.k && s.this.f() && s.this.d.contains(message.obj)) {
                        ((com.google.android.youtube.player.internal.u.a) message.obj).a();
                    }
                }
            } else if (message.what == 2 && !s.this.f()) {
            } else {
                if (message.what == 2 || message.what == 1) {
                    ((b) message.obj).a();
                }
            }
        }
    }

    protected abstract class b<TListener> {
        private TListener b;

        public b(TListener tListener) {
            this.b = tListener;
            synchronized (s.this.Lv) {
                s.this.Lv.add(this);
            }
        }

        public final void a() {
            Object obj;
            synchronized (this) {
                obj = this.b;
            }
            a(obj);
        }

        protected abstract void a(TListener tListener);

        public final void b() {
            synchronized (this) {
                this.b = null;
            }
        }
    }

    final class e implements ServiceConnection {
        e() {
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            s.this.h(iBinder);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            s.this.Lt = null;
            s.this.h();
        }
    }

    protected final class c extends b<Boolean> {
        public final YouTubeInitializationResult Ly;
        public final IBinder Lz;

        public c(String str, IBinder iBinder) {
            super(Boolean.valueOf(true));
            this.Ly = s.cB(str);
            this.Lz = iBinder;
        }

        protected final /* synthetic */ void a(Object obj) {
            if (((Boolean) obj) != null) {
                if (AnonymousClass1.a[this.Ly.ordinal()] != 1) {
                    s.this.a(this.Ly);
                    return;
                }
                try {
                    if (s.this.b().equals(this.Lz.getInterfaceDescriptor())) {
                        s.this.Lt = s.this.g(this.Lz);
                        if (s.this.Lt != null) {
                            s.this.g();
                        }
                    }
                } catch (RemoteException unused) {
                    s.this.a();
                    s.this.a(YouTubeInitializationResult.INTERNAL_ERROR);
                }
            }
        }
    }

    protected final class d extends com.google.android.youtube.player.internal.e.a {
        protected d() {
        }

        public final void a(String str, IBinder iBinder) {
            s.this.a.sendMessage(s.this.a.obtainMessage(1, new c(str, iBinder)));
        }
    }

    protected s(Context context, com.google.android.youtube.player.internal.u.a aVar, com.google.android.youtube.player.internal.u.b bVar) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Clients must be created on the UI thread.");
        }
        this.b = (Context) b.u(context);
        this.d = new ArrayList();
        this.d.add(b.u(aVar));
        this.Lu = new ArrayList();
        this.Lu.add(b.u(bVar));
        this.a = new a();
    }

    private void a() {
        if (this.Lw != null) {
            try {
                this.b.unbindService(this.Lw);
            } catch (Throwable e) {
                Log.w("YouTubeClient", "Unexpected error from unbindService()", e);
            }
        }
        this.Lt = null;
        this.Lw = null;
    }

    private static YouTubeInitializationResult cB(String str) {
        try {
            return YouTubeInitializationResult.valueOf(str);
        } catch (IllegalArgumentException unused) {
            return YouTubeInitializationResult.UNKNOWN_ERROR;
        } catch (NullPointerException unused2) {
            return YouTubeInitializationResult.UNKNOWN_ERROR;
        }
    }

    protected final void a(YouTubeInitializationResult youTubeInitializationResult) {
        this.a.removeMessages(4);
        synchronized (this.Lu) {
            this.h = true;
            ArrayList arrayList = this.Lu;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                if (this.k) {
                    if (this.Lu.contains(arrayList.get(i))) {
                        ((com.google.android.youtube.player.internal.u.b) arrayList.get(i)).a(youTubeInitializationResult);
                    }
                    i++;
                } else {
                    return;
                }
            }
            this.h = false;
        }
    }

    protected abstract void a(k kVar, d dVar);

    protected abstract String b();

    public void d() {
        h();
        int i = 0;
        this.k = false;
        synchronized (this.Lv) {
            int size = this.Lv.size();
            while (i < size) {
                ((b) this.Lv.get(i)).b();
                i++;
            }
            this.Lv.clear();
        }
        a();
    }

    public final void e() {
        this.k = true;
        YouTubeInitializationResult as = com.google.android.youtube.player.a.as(this.b);
        if (as != YouTubeInitializationResult.SUCCESS) {
            this.a.sendMessage(this.a.obtainMessage(3, as));
            return;
        }
        Intent intent = new Intent(pl()).setPackage(aa.at(this.b));
        if (this.Lw != null) {
            Log.e("YouTubeClient", "Calling connect() while still connected, missing disconnect().");
            a();
        }
        this.Lw = new e();
        if (!this.b.bindService(intent, this.Lw, 129)) {
            this.a.sendMessage(this.a.obtainMessage(3, YouTubeInitializationResult.ERROR_CONNECTING_TO_SERVICE));
        }
    }

    public final boolean f() {
        return this.Lt != null;
    }

    protected abstract T g(IBinder iBinder);

    protected final void g() {
        synchronized (this.d) {
            boolean z = true;
            b.a(this.f ^ true);
            this.a.removeMessages(4);
            this.f = true;
            if (this.e.size() != 0) {
                z = false;
            }
            b.a(z);
            ArrayList arrayList = this.d;
            int size = arrayList.size();
            for (int i = 0; i < size && this.k && f(); i++) {
                if (!this.e.contains(arrayList.get(i))) {
                    ((com.google.android.youtube.player.internal.u.a) arrayList.get(i)).a();
                }
            }
            this.e.clear();
            this.f = false;
        }
    }

    protected final void h() {
        this.a.removeMessages(4);
        synchronized (this.d) {
            this.f = true;
            ArrayList arrayList = this.d;
            int size = arrayList.size();
            for (int i = 0; i < size && this.k; i++) {
                if (this.d.contains(arrayList.get(i))) {
                    ((com.google.android.youtube.player.internal.u.a) arrayList.get(i)).b();
                }
            }
            this.f = false;
        }
    }

    protected final void h(IBinder iBinder) {
        try {
            a(com.google.android.youtube.player.internal.k.a.d(iBinder), new d());
        } catch (RemoteException unused) {
            Log.w("YouTubeClient", "service died");
        }
    }

    protected final void i() {
        if (!f()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    protected abstract String pl();

    protected final T pm() {
        i();
        return this.Lt;
    }
}
