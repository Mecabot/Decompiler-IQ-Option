package com.iqoption.portfolio;

import android.util.Pair;
import com.google.common.b.e;
import com.google.common.base.Suppliers;
import com.google.common.base.n;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;
import com.google.common.primitives.Longs;
import com.google.common.util.concurrent.s;
import com.iqoption.app.IQApp;
import com.iqoption.app.managers.c;
import com.iqoption.app.managers.x;
import com.iqoption.dto.entity.position.Order;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.mobbtech.connect.response.options.OptionEvents;
import com.iqoption.mobbtech.connect.response.options.OptionEvents.g;
import com.iqoption.mobbtech.connect.response.options.OptionEvents.i;
import com.iqoption.mobbtech.connect.response.options.OptionEvents.j;
import com.iqoption.mobbtech.connect.response.options.OptionEvents.k;
import com.iqoption.mobbtech.connect.response.options.OptionEvents.m;
import com.iqoption.mobbtech.connect.response.options.OptionEvents.o;
import com.iqoption.mobbtech.connect.response.options.OptionEvents.p;
import com.iqoption.mobbtech.connect.response.options.OptionEvents.q;
import com.iqoption.system.a.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: PortfolioManager */
public class h implements com.iqoption.view.a.b.a {
    private static final Ordering<d> ORDERING = new Ordering<d>() {
        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            return dVar.avQ() ? dVar2.avQ() ? 0 : -1 : dVar2.avQ() ? 1 : 0;
        }
    }.compound(new Ordering<d>() {
        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            return Longs.compare(dVar2.avV(), dVar.avV());
        }
    }).compound(new Ordering<d>() {
        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            com.iqoption.core.microservices.tradingengine.response.active.a Jg = dVar.Jg();
            com.iqoption.core.microservices.tradingengine.response.active.a Jg2 = dVar2.Jg();
            if (Jg != null && Jg2 != null) {
                return com.iqoption.util.e.a.s(dVar.Jg()).compareToIgnoreCase(com.iqoption.util.e.a.s(dVar2.Jg()));
            }
            int i = Jg == null ? Jg2 != null ? 1 : 0 : -1;
            return i;
        }
    });
    private static final n<h> cGv = Suppliers.a(new n<h>() {
        /* renamed from: awn */
        public h get() {
            return new h();
        }
    });
    private static final Ordering<e> cYA = new Ordering<e>() {
        /* renamed from: a */
        public int compare(e eVar, e eVar2) {
            return Longs.compare(eVar2.avV(), eVar.avV());
        }
    }.compound(new Ordering<e>() {
        /* renamed from: a */
        public int compare(e eVar, e eVar2) {
            return com.iqoption.util.e.a.s(eVar.Jg()).compareToIgnoreCase(com.iqoption.util.e.a.s(eVar2.Jg()));
        }
    });
    private static final Ordering<b> cYz = new Ordering<b>() {
        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            return Longs.compare(bVar2.getCloseTime(), bVar.getCloseTime());
        }
    }.compound(new Ordering<b>() {
        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            com.iqoption.core.microservices.tradingengine.response.active.a Jg = bVar.Jg();
            com.iqoption.core.microservices.tradingengine.response.active.a Jg2 = bVar2.Jg();
            if (Jg != null && Jg2 != null) {
                return com.iqoption.util.e.a.s(bVar.Jg()).compareToIgnoreCase(com.iqoption.util.e.a.s(bVar2.Jg()));
            }
            int i = Jg == null ? Jg2 != null ? 1 : 0 : -1;
            return i;
        }
    });
    private x amI;
    private final f cYB;
    private final Set<Long> cYC;
    private final Map<Long, s> cYD;
    private final List<b> ln;

    /* compiled from: PortfolioManager */
    public interface b {
        void awo();

        void awp();

        void awq();

        void awr();

        void aws();
    }

    /* compiled from: PortfolioManager */
    private final class a extends d {
        private a() {
        }

        /* synthetic */ a(h hVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        private void w(ImmutableList<com.iqoption.mobbtech.connect.response.options.b> immutableList) {
            h.this.aS(immutableList);
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    h.this.awj();
                }
            });
        }

        private void x(ImmutableList<Order> immutableList) {
            h.this.aT(immutableList);
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    h.this.awk();
                }
            });
        }

        private void y(ImmutableList<com.iqoption.mobbtech.connect.response.options.a> immutableList) {
            h.this.aU(immutableList);
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    h.this.awl();
                }
            });
        }

        @e
        public void onOpenOptionGroupsClear(m mVar) {
            w(ImmutableList.sL());
        }

        @e
        public void onOpenOptionGroupOptionRemoved(j jVar) {
            w(jVar.cWE);
        }

        @e
        public void onOpenOptionGroupRemoved(k kVar) {
            w(kVar.cWE);
        }

        @e
        public void onNewOpenOptionGroup(com.iqoption.mobbtech.connect.response.options.OptionEvents.h hVar) {
            w(hVar.cWE);
        }

        @e
        public void onOpenOptionGroupOptionAdded(i iVar) {
            w(iVar.cWE);
        }

        @e
        public void onClosedOptionGroupsClear(com.iqoption.mobbtech.connect.response.options.OptionEvents.b bVar) {
            y(ImmutableList.sL());
        }

        @e
        public void onNewClosedOptionGroup(g gVar) {
            y((ImmutableList) ((Pair) gVar.getValue()).first);
        }

        @e
        public void onReplaceClosedOptionGroup(o oVar) {
            y((ImmutableList) ((Pair) oVar.getValue()).first);
        }

        @e
        public void onClosedOptionGroupOptionAdded(com.iqoption.mobbtech.connect.response.options.OptionEvents.a aVar) {
            y(aVar.cWB);
        }

        @e
        public void onUpdateStarted(q qVar) {
            h.this.cYB.fI(1);
            com.iqoption.core.d.a.aSe.execute(new i(h.this));
        }

        @e
        public void onUpdateStoped(p pVar) {
            if (c.Gn().Gw()) {
                h.this.cYB.fI(3);
                com.iqoption.core.d.a.aSe.execute(new j(h.this));
                return;
            }
            h.this.cYB.fI(2);
            com.iqoption.core.d.a.aSe.execute(new k(h.this));
        }

        @e
        public void onDefferedOrdersChanged(OptionEvents.c cVar) {
            x(c.Gn().Gl());
        }
    }

    /* synthetic */ h(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static h awd() {
        return (h) cGv.get();
    }

    public void fJ(int i) {
        this.cYB.fD(i);
    }

    public s<?> bJ(final long j) {
        s k;
        Iterator sI = this.cYB.avY().iterator();
        com.iqoption.mobbtech.connect.response.options.e eVar = null;
        while (sI.hasNext()) {
            Iterator sI2 = ((d) sI.next()).avS().iterator();
            while (sI2.hasNext()) {
                com.iqoption.mobbtech.connect.response.options.e eVar2 = (com.iqoption.mobbtech.connect.response.options.e) sI2.next();
                if (eVar2.getId().longValue() == j) {
                    eVar = eVar2;
                    continue;
                    break;
                }
            }
            if (eVar != null) {
                break;
            }
        }
        com.google.common.util.concurrent.n anonymousClass11 = new com.google.common.util.concurrent.n<Object>() {
            public void onSuccess(Object obj) {
                h.this.cYC.remove(Long.valueOf(j));
            }

            public void l(Throwable th) {
                h.this.cYC.remove(Long.valueOf(j));
            }
        };
        if (eVar instanceof Position) {
            k = com.iqoption.mobbtech.connect.request.api.a.c.k((Position) eVar);
        } else {
            k = com.iqoption.mobbtech.connect.request.api.a.a.c(IQApp.Dk(), j);
        }
        com.google.common.util.concurrent.o.a(k, anonymousClass11);
        this.cYC.add(Long.valueOf(j));
        return k;
    }

    public boolean bK(long j) {
        return this.cYC.contains(Long.valueOf(j));
    }

    public s q(final Order order) {
        s sVar = (s) this.cYD.get(order.getId());
        if (sVar != null) {
            return sVar;
        }
        sVar = com.iqoption.mobbtech.connect.request.api.a.c.z(order.getId());
        com.google.common.util.concurrent.o.a(sVar, new com.google.common.util.concurrent.n<Object>() {
            public void onSuccess(Object obj) {
                h.this.cYD.remove(order.getId());
            }

            public void l(Throwable th) {
                h.this.cYD.remove(order.getId());
            }
        });
        this.cYD.put(order.getId(), sVar);
        return sVar;
    }

    public boolean r(Order order) {
        s sVar = (s) this.cYD.get(order.getId());
        return (sVar == null || sVar.isCancelled() || sVar.isDone()) ? false : true;
    }

    private h() {
        this.cYC = Sets.uI();
        this.cYD = Maps.us();
        this.ln = new ArrayList();
        this.amI = new x(new com.iqoption.app.managers.x.a() {
            public void GG() {
                com.iqoption.view.a.b.aIK().a(h.this, Integer.valueOf(5));
            }

            public void GH() {
                com.iqoption.view.a.b.aIK().b(h.this);
            }
        });
        this.cYB = new f(0);
        new a(this, null).register();
    }

    public void onTick(long j) {
        this.cYB.awb();
        awi();
    }

    public f awe() {
        if (!this.amI.isStarted()) {
            if (c.Gn().Gv()) {
                this.cYB.fI(1);
            } else if (c.Gn().Gw()) {
                this.cYB.fI(3);
            } else {
                this.cYB.fI(2);
            }
            awf();
            awg();
            awh();
        }
        return this.cYB;
    }

    private void aS(List<com.iqoption.mobbtech.connect.response.options.b> list) {
        this.cYB.t(d.a(list, ORDERING));
        this.cYB.awb();
    }

    private void aT(List<Order> list) {
        this.cYB.v(e.a(list, cYA));
    }

    private void aU(List<com.iqoption.mobbtech.connect.response.options.a> list) {
        this.cYB.u(b.a(list, cYz));
    }

    private void awf() {
        aS(c.Gn().Gp());
    }

    private void awg() {
        aT(c.Gn().Gl());
    }

    private void awh() {
        aU(c.Gn().Go());
    }

    private void awi() {
        for (b awo : this.ln) {
            awo.awo();
        }
    }

    private void awj() {
        for (b awp : this.ln) {
            awp.awp();
        }
    }

    private void awk() {
        for (b awq : this.ln) {
            awq.awq();
        }
    }

    private void awl() {
        for (b awr : this.ln) {
            awr.awr();
        }
    }

    private void awm() {
        for (b aws : this.ln) {
            aws.aws();
        }
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.ln.add(bVar);
        }
        this.amI.start();
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.ln.remove(bVar);
        }
        this.amI.stop();
    }
}
