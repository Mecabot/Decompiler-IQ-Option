package com.iqoption.app.managers;

import android.support.annotation.NonNull;
import android.support.v4.util.LongSparseArray;
import com.google.common.base.Suppliers;
import com.google.common.base.n;
import com.google.common.util.concurrent.s;
import com.iqoption.app.IQApp;
import com.iqoption.core.i;
import com.iqoption.system.a.c;
import com.iqoption.util.ag;
import java.lang.ref.SoftReference;

/* compiled from: OtnLeaderBoardManager */
public final class p {
    private static final n<p> Pf = Suppliers.a(q.ajD);
    private static final String TAG = "com.iqoption.app.managers.p";
    private s<com.iqoption.microservice.c.a.a> anb;
    private SoftReference<LongSparseArray<com.iqoption.microservice.c.a.a>> anc = new SoftReference(null);

    /* compiled from: OtnLeaderBoardManager */
    public static final class a extends c<Boolean> {
        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        private a() {
        }
    }

    public static p GQ() {
        return (p) Pf.get();
    }

    public void ar(final long j) {
        LongSparseArray longSparseArray = (LongSparseArray) this.anc.get();
        if (!(longSparseArray == null || longSparseArray.get(j) == null)) {
            a(new a().setValue(Boolean.valueOf(true)));
        }
        if (GR()) {
            i.d(TAG, "leader board response is fetching");
            return;
        }
        this.anb = com.iqoption.microservice.c.a.bC(j);
        ag.a(this.anb, new com.google.common.util.concurrent.n<com.iqoption.microservice.c.a.a>() {
            /* renamed from: a */
            public void onSuccess(com.iqoption.microservice.c.a.a aVar) {
                LongSparseArray longSparseArray = (LongSparseArray) p.this.anc.get();
                if (longSparseArray == null) {
                    longSparseArray = new LongSparseArray();
                }
                longSparseArray.put(j, aVar);
                p.this.anc = new SoftReference(longSparseArray);
                p.a(new a().setValue(Boolean.valueOf(true)));
            }

            public void l(@NonNull Throwable th) {
                i.e(p.TAG, th.getMessage(), th);
                p.a(new a().setValue(Boolean.valueOf(false)));
            }
        });
    }

    private static void a(com.iqoption.system.a.a aVar) {
        IQApp.Dn().aE(aVar);
    }

    private p() {
    }

    public int as(long j) {
        LongSparseArray longSparseArray = (LongSparseArray) this.anc.get();
        if (longSparseArray == null || longSparseArray.get(j) == null) {
            return 0;
        }
        return ((com.iqoption.microservice.c.a.a) longSparseArray.get(j)).asH().asI();
    }

    public int at(long j) {
        LongSparseArray longSparseArray = (LongSparseArray) this.anc.get();
        if (longSparseArray == null || longSparseArray.get(j) == null) {
            return 0;
        }
        return ((com.iqoption.microservice.c.a.a) longSparseArray.get(j)).asH().asJ();
    }

    private boolean GR() {
        return (this.anb == null || this.anb.isDone()) ? false : true;
    }
}
