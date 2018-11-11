package com.iqoption.fragment.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.common.b.e;
import com.google.common.base.d;
import com.google.common.base.j;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import com.google.common.collect.ac;
import com.google.common.collect.s;
import com.google.common.util.concurrent.n;
import com.google.common.util.concurrent.o;
import com.iqoption.app.IQApp;
import com.iqoption.app.helpers.p;
import com.iqoption.app.managers.af;
import com.iqoption.core.i;
import com.iqoption.dto.ToastEntity;
import com.iqoption.dto.entity.Feature;
import com.iqoption.dto.entity.iqbus.SignalLegacy;
import com.iqoption.dto.entity.iqbus.SignalLegacy.SignalCreatedEvent;
import com.iqoption.dto.entity.iqbus.SignalLegacy.SignalsEvent;
import com.iqoption.mobbtech.connect.request.api.f;
import com.iqoption.service.e.g;
import com.iqoption.system.a.h;
import com.iqoption.util.ag;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Deprecated
/* compiled from: SignalManager */
public class b {
    private static final String TAG = "com.iqoption.fragment.b.b";
    public static final ImmutableSet<Integer> cHQ = ImmutableSet.a(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9));
    public static final String[] cHR = new String[]{"Daily Rise/Fall", "Sharp Jump", "52-Week Max Update", "52-Week Min Update", "52-Week Max Breaking", "52-Week Min Breaking", "4-Week Max Update", "4-Week Min Update", "4-Week Max Breaking", "4-Week Min Breaking", "Price movement"};
    @SuppressLint({"StaticFieldLeak"})
    private static volatile b cHY;
    private volatile boolean HH;
    private volatile boolean cCF;
    private a cHS = new a(this, null);
    private Set<SignalLegacy> cHT = aog();
    private Set<SignalLegacy> cHU = aog();
    private ac<Integer, SignalLegacy> cHV = aoh();
    private final d<SignalLegacy, com.iqoption.a.p.b> cHW = new d<SignalLegacy, com.iqoption.a.p.b>() {
        /* renamed from: d */
        public com.iqoption.a.p.b apply(SignalLegacy signalLegacy) {
            return new com.iqoption.a.p.b(IQApp.Dk().getApplicationContext(), signalLegacy);
        }
    };
    private com.google.common.cache.b<Long, Long> cHX = CacheBuilder.qh().A(1000).a(1, TimeUnit.MINUTES).qw();
    private volatile boolean cHZ;
    @Nullable
    private ScheduledExecutorService singleThreadExecutor;

    /* compiled from: SignalManager */
    private class b implements n<SignalLegacy[]> {
        private b() {
        }

        /* synthetic */ b(b bVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: c */
        public void onSuccess(SignalLegacy[] signalLegacyArr) {
            if (b.this.cCF) {
                b.this.a(signalLegacyArr);
            }
        }

        public void l(Throwable th) {
            i.e(b.TAG, "unable to get signals", th);
        }
    }

    /* compiled from: SignalManager */
    private class a extends h {
        private a() {
        }

        /* synthetic */ a(b bVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @e
        public void onOpenWebSocket(g gVar) {
            i.d(b.TAG, "event=WebSocketEvents.OpenWebSocket");
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    b.this.reconnect();
                }
            });
        }

        @e
        public void onSignalsEvent(SignalsEvent signalsEvent) {
            i.d(b.TAG, "SignalsEvent");
            if (b.this.cCF && b.this.singleThreadExecutor != null) {
                final SignalLegacy[] signalLegacyArr = (SignalLegacy[]) signalsEvent.getValue();
                b.this.singleThreadExecutor.execute(new Runnable() {
                    public void run() {
                        b.this.a(signalLegacyArr);
                    }
                });
            }
        }

        @e
        public void onSignalCreatedEvent(SignalCreatedEvent signalCreatedEvent) {
            i.d(b.TAG, "onSignalCreatedEvent");
            if (b.this.cCF && b.this.singleThreadExecutor != null) {
                final SignalLegacy signalLegacy = (SignalLegacy) signalCreatedEvent.getValue();
                b.this.singleThreadExecutor.execute(new Runnable() {
                    public void run() {
                        b.this.a(new SignalLegacy[]{signalLegacy});
                    }
                });
            }
        }
    }

    public void br(Context context) {
    }

    public void onStop() {
    }

    private Set<SignalLegacy> aog() {
        return Sets.uJ();
    }

    @NonNull
    private ac<Integer, SignalLegacy> aoh() {
        return Multimaps.a(HashMultimap.sG());
    }

    public static b aoi() {
        if (cHY == null) {
            synchronized (com.iqoption.mobbtech.connect.response.a.a.class) {
                if (cHY == null) {
                    cHY = new b();
                }
            }
        }
        return cHY;
    }

    private b() {
    }

    public ImmutableList<SignalLegacy> d(boolean z, int i) {
        Collection sortedCopy;
        if (i == 10) {
            if (this.cHT.isEmpty()) {
                if (this.cCF && !this.HH) {
                    dF(false);
                }
                return ImmutableList.sL();
            }
            if (z) {
                sortedCopy = SignalLegacy.ORDERING_BY_TIME_CREATED.reverse().sortedCopy(s.a(this.cHT, SignalLegacy.isAvailable));
            } else {
                sortedCopy = SignalLegacy.ORDERING_BY_TIME_CREATED.reverse().sortedCopy(this.cHT);
            }
            return ImmutableList.m(sortedCopy);
        } else if (this.cHV.isEmpty()) {
            i.d(TAG, "no signals. request signals from beginning");
            if (!this.HH) {
                bx(-1);
            }
            return ImmutableList.sL();
        } else {
            Iterable X = this.cHV.X(Integer.valueOf(i));
            if (X == null) {
                return ImmutableList.sL();
            }
            if (z) {
                sortedCopy = SignalLegacy.ORDERING_BY_TIME_CREATED.reverse().sortedCopy(s.a(X, SignalLegacy.isAvailable));
            } else {
                sortedCopy = SignalLegacy.ORDERING_BY_TIME_CREATED.reverse().sortedCopy(X);
            }
            return ImmutableList.m(sortedCopy);
        }
    }

    private void aoj() {
        f.auy();
        int Gd = p.Gd();
        if (Gd > 0) {
            f.fr(Gd);
        }
    }

    private void dF(boolean z) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("initSignals forceInit=");
        stringBuilder.append(z);
        i.v(str, stringBuilder.toString());
        if (!this.cHZ || z) {
            this.HH = false;
            this.cHZ = true;
            com.google.common.util.concurrent.s a = ag.a(new com.google.common.base.n<com.google.common.util.concurrent.s<SignalLegacy[]>>() {
                /* renamed from: Qu */
                public com.google.common.util.concurrent.s<SignalLegacy[]> get() {
                    if (p.isEnabled()) {
                        return f.a(-1, true, p.Gd());
                    }
                    return o.aR(new SignalLegacy[0]);
                }
            }, "GET_HF_SIGNALS");
            o.a(a, new b(this, null), this.singleThreadExecutor);
            a = o.a(a, new com.google.common.util.concurrent.g<SignalLegacy[], SignalLegacy[]>() {
                /* renamed from: b */
                public com.google.common.util.concurrent.s<SignalLegacy[]> aP(SignalLegacy[] signalLegacyArr) {
                    return ag.a(new com.google.common.base.n<com.google.common.util.concurrent.s<SignalLegacy[]>>() {
                        /* renamed from: Qu */
                        public com.google.common.util.concurrent.s<SignalLegacy[]> get() {
                            return f.c(-1, false);
                        }
                    }, "GET_SIGNALS");
                }
            });
            o.a(a, new n<SignalLegacy[]>() {
                /* renamed from: c */
                public void onSuccess(SignalLegacy[] signalLegacyArr) {
                    b.this.HH = true;
                    b.this.cHZ = false;
                }

                public void l(Throwable th) {
                    b.this.HH = false;
                    b.this.cHZ = false;
                }
            });
            o.a(a, new b(this, null), this.singleThreadExecutor);
            return;
        }
        i.d(TAG, "initSignals is in progress already");
    }

    private boolean bx(long j) {
        if (!this.cCF) {
            i.e(TAG, "signal manager is not started");
            return false;
        } else if (this.singleThreadExecutor == null) {
            return false;
        } else {
            String str;
            StringBuilder stringBuilder;
            if (this.cHX.I(Long.valueOf(j)) != null) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("requestSignals, skip request (already requested) for timestamp=");
                stringBuilder.append(j);
                i.d(str, stringBuilder.toString());
                return false;
            }
            str = TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("requestSignals, timestamp=");
            stringBuilder.append(j);
            i.d(str, stringBuilder.toString());
            this.cHX.put(Long.valueOf(j), Long.valueOf(j));
            o.a(f.c(j, false), new b(this, null), this.singleThreadExecutor);
            return true;
        }
    }

    public static boolean bs(Context context) {
        Feature fd = com.iqoption.app.managers.feature.b.HT().fd("price-movements");
        return fd != null && ("enabled".equals(fd.status) || "push-auto-subscribe".equals(fd.status));
    }

    public static boolean c(SignalLegacy signalLegacy) {
        boolean z = true;
        if (SystemClock.elapsedRealtime() > 900000) {
            return true;
        }
        long Hw = (af.Hu().Hw() - 1800000) / 1000;
        if (signalLegacy.finish_time == null || signalLegacy.finish_time.longValue() < Hw) {
            z = false;
        }
        return z;
    }

    private void reconnect() {
        i.v(TAG, "reconnect");
        Context applicationContext = IQApp.Dk().getApplicationContext();
        if (bs(applicationContext)) {
            if (this.cCF) {
                aoj();
                dF(true);
            } else {
                br(applicationContext);
            }
            return;
        }
        i.d(TAG, "price movements is disabled");
        if (this.cCF) {
            onStop();
        }
    }

    private void a(SignalLegacy[] signalLegacyArr) {
        if (this.cCF) {
            SignalLegacy signalLegacy;
            Collection leastOf;
            com.google.common.collect.ImmutableSet.a ts = ImmutableSet.ts();
            for (int length = signalLegacyArr.length - 1; length >= 0; length--) {
                signalLegacy = signalLegacyArr[length];
                if (signalLegacy.type == null) {
                    String str = TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("signal has not type. ");
                    stringBuilder.append(signalLegacy);
                    i.e(str, stringBuilder.toString());
                } else {
                    ts.ae(signalLegacy.type);
                    if (signalLegacy.type.intValue() != 10) {
                        if (!this.cHU.add(signalLegacy)) {
                            this.cHU.remove(signalLegacy);
                            this.cHU.add(signalLegacy);
                        }
                        if (!this.cHV.j(signalLegacy.type, signalLegacy)) {
                            this.cHV.remove(signalLegacy.type, signalLegacy);
                            this.cHV.j(signalLegacy.type, signalLegacy);
                        }
                    } else if (!this.cHT.add(signalLegacy)) {
                        this.cHT.remove(signalLegacy);
                        this.cHT.add(signalLegacy);
                    }
                }
            }
            ImmutableSet tt = ts.tt();
            if (this.cHU.size() > ToastEntity.ALERT_TOAST_DURATION) {
                i.v(TAG, "Shrink signal list");
                leastOf = SignalLegacy.ORDERING_BY_TIME_CREATED.reverse().leastOf(this.cHU, 5000);
                Set aog = aog();
                aog.addAll(leastOf);
                this.cHU = aog;
            }
            for (SignalLegacy signalLegacy2 : this.cHU) {
                ac aoh = aoh();
                aoh.j(signalLegacy2.type, signalLegacy2);
                this.cHV = aoh;
            }
            if (tt.contains(Integer.valueOf(10))) {
                final long Hw = (af.Hu().Hw() - 1200000) / 1000;
                leastOf = SignalLegacy.ORDERING_BY_TIME_CREATED.reverse().leastOf(s.a(this.cHT, new j<SignalLegacy>() {
                    public boolean apply(SignalLegacy signalLegacy) {
                        return signalLegacy.created.longValue() >= Hw;
                    }
                }), 10);
                this.cHT.clear();
                this.cHT.addAll(leastOf);
            }
            if (signalLegacyArr.length > 0 && (tt.contains(Integer.valueOf(0)) || tt.contains(Integer.valueOf(1)) || tt.contains(Integer.valueOf(10)))) {
                IQApp.Dn().aE(new com.iqoption.fragment.b.c.b(tt, signalLegacyArr));
            }
        }
    }
}
