package com.iqoption.app.managers;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.common.base.Suppliers;
import com.google.common.base.j;
import com.google.common.base.n;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.s;
import com.iqoption.app.IQApp;
import com.iqoption.core.i;
import com.iqoption.dto.event.OtnEmissionExecuted;
import com.iqoption.microservice.d.a.e;
import com.iqoption.service.e.g;
import com.iqoption.system.a.h;
import com.iqoption.util.ag;
import com.iqoption.util.l;
import com.iqoption.util.y;
import java.math.BigDecimal;

/* compiled from: OtnManager */
public final class r {
    private static final n<r> Pf = Suppliers.a(s.ajD);
    private static final String TAG = "com.iqoption.app.managers.r";
    private static final j<com.iqoption.microservice.d.a.d> anf = new j<com.iqoption.microservice.d.a.d>() {
        /* renamed from: a */
        public boolean apply(com.iqoption.microservice.d.a.d dVar) {
            return "emission".equalsIgnoreCase(dVar.getType());
        }
    };
    private final d ang = new d(this, null);
    private s<com.iqoption.microservice.d.a.a> anh;
    private s<com.iqoption.microservice.d.a.c> ani;
    private s<e> anj;
    private s<com.iqoption.microservice.d.a.b> ank;
    private com.iqoption.microservice.d.a.a anl;
    private com.iqoption.microservice.d.a.c anm;
    private e ann;
    private com.iqoption.microservice.d.a.b ano;

    /* compiled from: OtnManager */
    public static final class a extends com.iqoption.system.a.c<Boolean> {
        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        private a() {
        }
    }

    /* compiled from: OtnManager */
    public static final class b extends com.iqoption.system.a.c<Boolean> {
        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }

        private b() {
        }
    }

    /* compiled from: OtnManager */
    public static final class c extends com.iqoption.system.a.c<Boolean> {
        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        private c() {
        }
    }

    /* compiled from: OtnManager */
    private final class d extends h {
        private d() {
        }

        /* synthetic */ d(r rVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @com.google.common.b.e
        public void onSocketOpened(g gVar) {
            com.iqoption.core.d.a.aSc.execute(new Runnable() {
                public void run() {
                    r.this.clear();
                    r.this.GU();
                }
            });
        }
    }

    public static r GT() {
        return (r) Pf.get();
    }

    private static void a(com.iqoption.system.a.a aVar) {
        IQApp.Dn().aE(aVar);
    }

    private r() {
    }

    public void initialize() {
        this.ang.register();
    }

    public void onEmissionExecuted(final OtnEmissionExecuted otnEmissionExecuted) {
        com.iqoption.core.d.a.aSc.execute(new Runnable() {
            public void run() {
                r.this.a(otnEmissionExecuted.getTime(), otnEmissionExecuted);
                IQApp.Dn().aE(otnEmissionExecuted);
            }
        });
    }

    private void a(long j, OtnEmissionExecuted otnEmissionExecuted) {
        if (this.anl != null) {
            this.anl.c(this.anl.asO().add(otnEmissionExecuted.getCount()));
            this.anl.l(y.f(this.anl.asP(), Double.valueOf(otnEmissionExecuted.getCommissionVolumeEnrolled())));
            this.anl.k(y.f(this.anl.asQ(), Double.valueOf(otnEmissionExecuted.getTotalCommissionEnrolled())));
        }
        if (this.anm != null) {
            GX();
        }
        if (this.ann != null) {
            com.iqoption.microservice.d.a.d dVar = new com.iqoption.microservice.d.a.d();
            dVar.setType("emission");
            dVar.setTime(j);
            dVar.d(otnEmissionExecuted.getCount());
            this.ann.asU().add(0, dVar);
        }
    }

    private void clear() {
        this.anl = null;
        this.anm = null;
        this.ann = null;
    }

    public void GU() {
        GV();
        GX();
        GZ();
        Hb();
    }

    public void GV() {
        if (!com.iqoption.app.managers.feature.a.HD()) {
            i.d(TAG, "otn feature disable");
        } else if (GW()) {
            i.d(TAG, "balance is fetching already");
        } else {
            this.anh = com.iqoption.microservice.d.a.asM();
            ag.a(this.anh, new com.google.common.util.concurrent.n<com.iqoption.microservice.d.a.a>() {
                /* renamed from: a */
                public void onSuccess(com.iqoption.microservice.d.a.a aVar) {
                    r.this.anl = aVar;
                    r.a(new a().setValue(Boolean.valueOf(true)));
                }

                public void l(@NonNull Throwable th) {
                    i.e(r.TAG, th.getMessage(), th);
                    r.a(new a().setValue(Boolean.valueOf(false)));
                }
            });
        }
    }

    public boolean GW() {
        return (this.anh == null || this.anh.isDone()) ? false : true;
    }

    public void GX() {
        if (!com.iqoption.app.managers.feature.a.HD()) {
            i.d(TAG, "otn feature disable");
        } else if (GY()) {
            i.d(TAG, "emission info is fetching already");
        } else {
            this.ani = com.iqoption.microservice.d.a.asL();
            ag.a(this.ani, new com.google.common.util.concurrent.n<com.iqoption.microservice.d.a.c>() {
                /* renamed from: a */
                public void onSuccess(com.iqoption.microservice.d.a.c cVar) {
                    r.this.anm = cVar;
                    r.a(new b().setValue(Boolean.valueOf(true)));
                }

                public void l(@NonNull Throwable th) {
                    i.e(r.TAG, th.getMessage(), th);
                    r.a(new b().setValue(Boolean.valueOf(false)));
                }
            });
        }
    }

    public boolean GY() {
        return (this.ani == null || this.ani.isDone()) ? false : true;
    }

    public void GZ() {
        if (!com.iqoption.app.managers.feature.a.HD()) {
            i.d(TAG, "otn feature disable");
        } else if (Ha()) {
            i.d(TAG, "operationHistory is fetching already");
        } else {
            this.anj = com.iqoption.microservice.d.a.asK();
            ag.a(this.anj, new com.google.common.util.concurrent.n<e>() {
                /* renamed from: a */
                public void onSuccess(e eVar) {
                    r.this.ann = eVar;
                    r.a(new c().setValue(Boolean.valueOf(true)));
                }

                public void l(@NonNull Throwable th) {
                    i.e(r.TAG, th.getMessage(), th);
                    r.a(new c().setValue(Boolean.valueOf(false)));
                }
            });
        }
    }

    public boolean Ha() {
        return (this.anj == null || this.anj.isDone()) ? false : true;
    }

    public void Hb() {
        if (!com.iqoption.app.managers.feature.a.HD()) {
            i.d(TAG, "otn feature disable");
        } else if (Hc()) {
            i.d(TAG, "emission operationHistory is fetching already");
        } else {
            this.ank = com.iqoption.microservice.d.a.asN();
            ag.a(this.ank, new com.google.common.util.concurrent.n<com.iqoption.microservice.d.a.b>() {
                /* renamed from: a */
                public void onSuccess(com.iqoption.microservice.d.a.b bVar) {
                    r.this.ano = bVar;
                    r.a(new b().setValue(Boolean.valueOf(true)));
                }

                public void l(@NonNull Throwable th) {
                    i.e(r.TAG, th.getMessage(), th);
                    r.a(new b().setValue(Boolean.valueOf(false)));
                }
            });
        }
    }

    public boolean Hc() {
        return (this.ank == null || this.ank.isDone()) ? false : true;
    }

    @Nullable
    public Double m(double d) {
        if (this.anl == null) {
            return null;
        }
        BigDecimal Hd = this.anl.Hd();
        Double asP = this.anl.asP();
        if (BigDecimal.ZERO.equals(Hd) || asP == null) {
            return null;
        }
        return Double.valueOf(Hd.doubleValue() / l.d(asP, Double.valueOf(d)).doubleValue());
    }

    @Nullable
    public BigDecimal Hd() {
        if (this.anl == null) {
            return null;
        }
        return this.anl.Hd();
    }

    @Nullable
    public Double He() {
        if (this.anl == null) {
            return null;
        }
        return this.anl.asP();
    }

    @Nullable
    public Double Hf() {
        if (this.anl == null) {
            return null;
        }
        return this.anl.asQ();
    }

    @Nullable
    public BigDecimal Hg() {
        if (this.anm == null) {
            return null;
        }
        return this.anm.asS();
    }

    @Nullable
    public BigDecimal Hh() {
        if (this.anm == null) {
            return null;
        }
        return this.anm.Hh();
    }

    @Nullable
    public BigDecimal Hi() {
        if (this.anm == null) {
            return null;
        }
        return this.anm.Hi();
    }

    @Nullable
    public BigDecimal Hj() {
        if (this.anm == null) {
            return null;
        }
        return this.anm.Hj();
    }

    @NonNull
    public ImmutableList<com.iqoption.microservice.d.a.d> Hk() {
        if (this.ann == null || this.ann.asU() == null) {
            return ImmutableList.sL();
        }
        return ImmutableList.m(this.ann.asU());
    }

    @NonNull
    public ImmutableList<com.iqoption.microservice.d.a.d> Hl() {
        return com.google.common.collect.i.c(Hk()).c(anf).sA();
    }

    @NonNull
    public ImmutableList<Object> Hm() {
        if (this.ano == null || this.ano.asR() == null) {
            return ImmutableList.sL();
        }
        return ImmutableList.m(this.ano.asR());
    }
}
