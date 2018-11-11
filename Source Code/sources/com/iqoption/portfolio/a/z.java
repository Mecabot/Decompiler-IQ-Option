package com.iqoption.portfolio.a;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.s;
import com.google.common.util.concurrent.y;
import com.iqoption.analytics.k;
import com.iqoption.app.af;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.d.aez;
import com.iqoption.dto.Event;
import com.iqoption.dto.ToastEntity;
import com.iqoption.dto.entity.position.Order;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.dto.entity.result.KycState;
import com.iqoption.dto.event.OtnEmissionExecuted;
import com.iqoption.fragment.base.f;
import com.iqoption.fragment.bf;
import com.iqoption.fragment.leftpanel.LeftPanelViewModel;
import com.iqoption.mobbtech.connect.response.options.e;
import com.iqoption.portfolio.activity.PortfolioActivity;
import com.iqoption.portfolio.component.b.g;
import com.iqoption.portfolio.component.b.i;
import com.iqoption.portfolio.component.b.j;
import com.iqoption.portfolio.component.b.m;
import com.iqoption.portfolio.component.n;
import com.iqoption.portfolio.component.o;
import com.iqoption.portfolio.d;
import com.iqoption.portfolio.h;
import com.iqoption.portfolio.l;
import com.iqoption.service.WebSocketHandler;
import com.iqoption.util.ag;
import com.iqoption.x.R;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

/* compiled from: PortfolioFragment */
public final class z extends f implements com.iqoption.fragment.dialog.c.a, com.iqoption.fragment.dialog.d.a, n, com.iqoption.portfolio.h.b {
    private static WeakReference<z> dcV = new WeakReference(null);
    private com.iqoption.portfolio.f cYB;
    private o cYW;
    private u dcH;
    private final a dcW = new a(this, null);
    private final c dcX = new c(this, null);
    private h dcY;
    private l dcZ;
    private final com.iqoption.portfolio.l.a dda = new com.iqoption.portfolio.l.a() {
        public boolean au(String str, String str2) {
            Iterator sI = z.this.cYB.avY().iterator();
            while (sI.hasNext()) {
                d dVar = (d) sI.next();
                if (com.google.common.base.f.equal(i.b(dVar), str2)) {
                    Iterator sI2 = dVar.avS().iterator();
                    while (sI2.hasNext()) {
                        if (com.google.common.base.f.equal(j.v((e) sI2.next()), str)) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            return false;
        }
    };
    private l ddb;
    private final com.iqoption.portfolio.l.a ddc = new com.iqoption.portfolio.l.a() {
        public boolean au(String str, String str2) {
            Iterator sI = z.this.cYB.awa().iterator();
            while (sI.hasNext()) {
                com.iqoption.portfolio.e eVar = (com.iqoption.portfolio.e) sI.next();
                if (com.google.common.base.f.equal(com.iqoption.portfolio.component.b.l.b(eVar), str2)) {
                    Iterator sI2 = eVar.Gm().iterator();
                    while (sI2.hasNext()) {
                        if (com.google.common.base.f.equal(m.s((Order) sI2.next()), str)) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            return false;
        }
    };
    private com.iqoption.portfolio.m ddd;
    private boolean dde;
    private y<Object> ddf;
    private com.iqoption.portfolio.component.a.b ddg;
    private com.iqoption.portfolio.component.a.c ddh;
    private com.iqoption.portfolio.component.a.e ddi;
    private com.iqoption.portfolio.component.a.a ddj;
    private com.iqoption.portfolio.component.a.d ddk;
    private y ddl;
    private y ddm;
    private com.iqoption.widget.a.a ddn;

    /* compiled from: PortfolioFragment */
    private static final class a extends com.iqoption.system.a.e<z> {
        /* synthetic */ a(z zVar, AnonymousClass1 anonymousClass1) {
            this(zVar);
        }

        private a(z zVar) {
            super(zVar);
        }

        @com.google.common.b.e
        public void onInvestPortfolioInfoShowed(com.iqoption.fragment.bf.a aVar) {
            com.iqoption.core.d.a.aSe.execute(new ac(this, aVar));
        }

        @com.google.common.b.e
        public void onFilterChosen(com.iqoption.portfolio.c cVar) {
            com.iqoption.core.d.a.aSe.execute(new ad(this, cVar));
        }

        @com.google.common.b.e
        public void onEmissionExecuted(OtnEmissionExecuted otnEmissionExecuted) {
            com.iqoption.core.d.a.aSe.execute(new ae(this, otnEmissionExecuted));
        }

        final /* synthetic */ void b(OtnEmissionExecuted otnEmissionExecuted) {
            z zVar = (z) this.drU.get();
            if (zVar != null && zVar.isAdded()) {
                com.iqoption.fragment.dialog.f.a(zVar.zzakw(), zVar.dcH.axL(), zVar.ahQ(), otnEmissionExecuted.getCount().doubleValue(), otnEmissionExecuted.getCommissionVolumeEnrolled(), otnEmissionExecuted.getTotalCommissionEnrolled());
            }
        }
    }

    /* compiled from: PortfolioFragment */
    private static class b extends com.iqoption.system.c.b<z, List<Parcelable>> {
        private final String assetName;
        private final double cnV;
        private final double cnW;
        private final boolean cnX;
        private final g daA;

        b(z zVar, double d, double d2, String str, boolean z, @Nullable g gVar) {
            super((Object) zVar);
            this.cnV = d;
            this.cnW = d2;
            this.assetName = str;
            this.cnX = z;
            this.daA = gVar;
        }

        /* renamed from: a */
        public void z(@NonNull z zVar, List<Parcelable> list) {
            Position position;
            List<Parcelable> list2 = list;
            super.z(zVar, list);
            if (this.daA != null) {
                this.daA.au(false);
            }
            KycState kycState = (KycState) list2.get(0);
            com.iqoption.microservice.a.b.a aVar = (com.iqoption.microservice.a.b.a) list2.get(1);
            com.iqoption.mobbtech.connect.response.e eVar = (com.iqoption.mobbtech.connect.response.e) list2.get(2);
            com.iqoption.withdrawal.crypto.a.a.a.aI(Event.CATEGORY_BUTTON_PRESSED, af.get("portfolio_micro", true) ? "portfolio_withdraw-crypto" : "portfolio_withdraw-crypto-ext").O(this.cnW).ks(this.assetName).Q(eVar.cVJ.doubleValue()).o(this.daA != null ? (Position) this.daA.axk() : null).send();
            FragmentManager d = zVar.ahQ();
            int axL = zVar.dcH.axL();
            double d2 = this.cnV;
            double d3 = this.cnW;
            String str = this.assetName;
            if (this.daA == null) {
                position = null;
            } else {
                position = (Position) this.daA.axk();
            }
            com.iqoption.withdrawal.crypto.a.a(d, axL, kycState, aVar, eVar, d2, d3, str, position, zVar.dcH.axL(), this.cnX);
            zVar.dcH.axN();
        }

        /* renamed from: a */
        public void c(@NonNull z zVar, Throwable th) {
            super.c(zVar, th);
            com.iqoption.core.i.e("PortfolioFragment", "withdrawal initialize error", th);
            if (this.daA != null) {
                this.daA.au(false);
            }
            com.iqoption.app.a.b.aT(zVar.getContext());
            zVar.dcH.axN();
        }
    }

    /* compiled from: PortfolioFragment */
    private static final class c extends com.iqoption.system.a.i<z> {
        /* synthetic */ c(z zVar, AnonymousClass1 anonymousClass1) {
            this(zVar);
        }

        private c(z zVar) {
            super(zVar);
        }

        @com.google.common.b.e
        public void onBalanceChanged(com.iqoption.service.e.c cVar) {
            com.iqoption.core.d.a.aSe.execute(new af(this));
        }

        final /* synthetic */ void ayl() {
            z zVar = (z) this.drU.get();
            if (zVar != null && zVar.isAdded()) {
                zVar.ayh();
            }
        }

        @com.google.common.b.e
        public void onBalanceValueChanged(com.iqoption.service.e.m mVar) {
            com.iqoption.core.d.a.aSe.execute(new ag(this));
        }

        final /* synthetic */ void ayk() {
            z zVar = (z) this.drU.get();
            if (zVar != null && zVar.isAdded()) {
                zVar.ayi();
            }
        }
    }

    public void b(com.iqoption.mobbtech.connect.response.options.b bVar) {
    }

    public void i(m mVar) {
    }

    public static z ge(int i) {
        z zVar = new z();
        zVar.setArguments(new com.iqoption.util.g().O("arg.uiState", i).toBundle());
        return zVar;
    }

    public static void c(AppCompatActivity appCompatActivity) {
        d(appCompatActivity);
        af.i("portfolio_opened", true);
    }

    public static void a(Activity activity, com.iqoption.portfolio.m mVar) {
        Intent intent = new Intent(activity, PortfolioActivity.class);
        intent.addFlags(603979776);
        if (mVar != null) {
            intent.putExtra("com.iqoption.portfolio:portfolioState", mVar);
        }
        activity.startActivity(intent);
    }

    private static void b(Activity activity, com.iqoption.portfolio.m mVar) {
        z zVar = (z) dcV.get();
        if (zVar != null) {
            zVar.a(mVar);
        }
        com.iqoption.util.a.s(activity);
    }

    private static void q(Activity activity) {
        activity.overridePendingTransition(0, R.anim.simple_activity_out);
        com.iqoption.util.a.s(activity);
        af.i("portfolio_opened", false);
    }

    private static void d(AppCompatActivity appCompatActivity) {
        LeftPanelViewModel.l(appCompatActivity).e(com.iqoption.fragment.leftpanel.b.c.cDP);
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return (z && i == 0) ? null : super.onCreateAnimation(i, z, i2);
    }

    private boolean ayf() {
        Bundle arguments = getArguments();
        if (arguments == null || arguments.getInt("arg.uiState", 0) != 1) {
            return false;
        }
        return true;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.dde = bundle == null;
        if (ayf()) {
            dcV = new WeakReference(this);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (ayf() && isRemoving()) {
            af.i("portfolio_opened", false);
        }
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.dcY = h.awd();
        this.cYB = this.dcY.awe();
        this.dcZ = new l(this.dda);
        this.ddb = new l(this.ddc);
        if (bundle != null) {
            this.dcZ.af(bundle.getBundle("key.openSelection"));
            this.ddb.af(bundle.getBundle("key.pendingSelection"));
        }
        this.cYW = new o(getContext());
        ayg();
        if (ayf()) {
            this.dcH = new h(this, layoutInflater, viewGroup);
        } else {
            this.dcH = new b(this, layoutInflater, viewGroup);
        }
        if (bundle != null) {
            Bundle bundle2 = bundle.getBundle("key.delegate");
            if (bundle2 != null) {
                this.dcH.af(bundle2);
            }
        }
        return this.dcH.getView();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.ddd != null) {
            a(this.ddd);
            this.ddd = null;
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.dcH.destroy();
    }

    public void onStart() {
        super.onStart();
        WebSocketHandler.aDm().bE("PortfolioFragment");
        this.dcY.a((com.iqoption.portfolio.h.b) this);
        this.dcW.register();
        this.dcX.register();
        if (!this.dde) {
            this.dcH.axP();
        }
    }

    public void onStop() {
        super.onStop();
        WebSocketHandler.aDm().m("PortfolioFragment", ToastEntity.ACTION_TOAST_DURATION);
        this.dcY.b((com.iqoption.portfolio.h.b) this);
        this.dcW.unregister();
        this.dcX.unregister();
    }

    public void onResume() {
        super.onResume();
        this.dcH.resume();
        this.dde = false;
    }

    public void onPause() {
        super.onPause();
        this.dcH.pause();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBundle("key.openSelection", this.dcZ.awu());
        bundle.putBundle("key.pendingSelection", this.ddb.awu());
        Bundle awu = this.dcH.awu();
        if (awu != null) {
            bundle.putBundle("key.delegate", awu);
        }
    }

    public boolean onBackPressed() {
        if (ayf()) {
            return false;
        }
        close();
        return true;
    }

    public void a(com.iqoption.portfolio.m mVar) {
        if (mVar != null) {
            if (getView() == null) {
                this.ddd = mVar;
                return;
            }
            l lVar = new l(this.dda);
            lVar.af(mVar.aww());
            if (this.dcZ.a(lVar)) {
                this.dcZ.af(mVar.aww());
            } else {
                this.dcZ = lVar;
                this.dcH.axD();
            }
            lVar = new l(this.ddc);
            lVar.af(mVar.awx());
            if (this.ddb.a(lVar)) {
                this.ddb.af(mVar.awx());
            } else {
                this.ddb = lVar;
                this.dcH.axE();
            }
            this.dcH.aj(mVar.awv());
            if (!(mVar.awy() == null || mVar.awz() == null)) {
                w(this.cYB.s(mVar.awy().longValue(), mVar.awz().longValue()));
            }
        }
    }

    public com.iqoption.portfolio.m i(j jVar) {
        com.iqoption.portfolio.m.a aVar = new com.iqoption.portfolio.m.a();
        aVar.ah(this.dcZ.awu()).ai(this.ddb.awu()).ag(this.dcH.awv());
        if (jVar != null) {
            aVar.b(Long.valueOf(jVar.getId()), Long.valueOf(jVar.axl()));
        }
        return aVar.awA();
    }

    public void awo() {
        this.dcH.awo();
    }

    public void awp() {
        this.dcH.axF();
    }

    public void awq() {
        this.dcH.axG();
    }

    public void awr() {
        this.dcH.axH();
    }

    public void aws() {
        this.dcH.axI();
    }

    public com.iqoption.portfolio.f awe() {
        return this.cYB;
    }

    public o axx() {
        return this.cYW;
    }

    public boolean c(i iVar) {
        String Ml = iVar.Ml();
        boolean iQ = this.dcZ.iQ(Ml);
        this.dcH.a(Ml, iVar, iQ);
        return iQ;
    }

    public boolean b(i iVar) {
        return this.dcZ.iO(iVar.Ml());
    }

    public boolean h(j jVar) {
        String Ml = jVar.Ml();
        String awt = this.dcZ.awt();
        boolean iR = this.dcZ.iR(Ml);
        this.dcH.i(Ml, awt, iR);
        return iR;
    }

    public boolean g(j jVar) {
        return this.dcZ.iP(jVar.Ml());
    }

    void ayg() {
        this.ddg = new com.iqoption.portfolio.component.a.b(this);
        this.ddh = new com.iqoption.portfolio.component.a.c(this);
        this.ddi = new com.iqoption.portfolio.component.a.e(this);
        this.ddj = new com.iqoption.portfolio.component.a.a(this);
        this.ddk = new com.iqoption.portfolio.component.a.d(getContext());
    }

    public com.iqoption.portfolio.component.a.b axy() {
        return this.ddg;
    }

    public com.iqoption.portfolio.component.a.c axz() {
        return this.ddh;
    }

    public com.iqoption.portfolio.component.a.e axA() {
        return this.ddi;
    }

    public com.iqoption.portfolio.component.a.a axB() {
        return this.ddj;
    }

    public com.iqoption.portfolio.component.a.d axC() {
        return this.ddk;
    }

    public void o(e eVar) {
        if (this.ddl != null) {
            bN(eVar.getId().longValue());
        }
        this.ddl = null;
    }

    public void air() {
        if (this.ddl != null) {
            this.ddl.h(new Throwable("canceled sell position"));
        }
        this.ddl = null;
    }

    @NonNull
    private FragmentManager ahQ() {
        return requireActivity().getSupportFragmentManager();
    }

    public s<?> f(j jVar) {
        this.ddl = y.wb();
        switch (jVar.axk().getInstrumentType()) {
            case FOREX_INSTRUMENT:
                if (!com.iqoption.settings.b.aDQ().Fq()) {
                    bN(jVar.getId());
                    break;
                }
                com.iqoption.fragment.dialog.d.a(this.dcH.axL(), ahQ(), (com.iqoption.fragment.dialog.d.a) this, jVar.axk());
                break;
            case CRYPTO_INSTRUMENT:
            case CFD_INSTRUMENT:
                com.iqoption.fragment.dialog.d.a(this.dcH.axL(), ahQ(), (com.iqoption.fragment.dialog.d.a) this, jVar.axk());
                break;
            case DIGITAL_INSTRUMENT:
            case FX_INSTRUMENT:
                com.iqoption.portfolio.a avU = jVar.avU();
                if (com.google.common.c.a.c(avU.GN() + avU.getSellPnl(), 0.0d, 0.001d) > 0) {
                    bN(jVar.getId());
                    break;
                }
                com.iqoption.fragment.dialog.a.a(this.dcH.axL(), ahQ(), (com.iqoption.fragment.dialog.d.a) this, jVar.axk());
                break;
            default:
                bN(jVar.getId());
                break;
        }
        return this.ddl;
    }

    private void bN(long j) {
        s bJ = this.dcY.bJ(j);
        if (bJ != null) {
            this.ddl.a(bJ);
            ag.a(bJ, new com.google.common.util.concurrent.n<Object>() {
                public void onSuccess(Object obj) {
                    gg(R.string.your_positioin_has_been_closed);
                    z.this.ddl = null;
                }

                public void l(Throwable th) {
                    gg(R.string.selling_failed_please_try_again_later);
                    z.this.ddl = null;
                }

                private void gg(@StringRes int i) {
                    if (!z.this.ayf()) {
                        g.a(z.this.dcH.axL(), z.this.ahQ(), z.this.getString(i));
                    }
                }
            });
            return;
        }
        this.ddl.h(new Throwable("position in progress"));
    }

    public boolean e(j jVar) {
        return this.dcY.bK(jVar.getId());
    }

    public void d(g gVar) {
        com.iqoption.dialog.c.b.a(ahQ(), this.dcH.axL(), (Position) gVar.axk());
        k.BA();
    }

    public void c(com.iqoption.portfolio.b bVar) {
        InstrumentType instrumentType = bVar.getInstrumentType();
        if (instrumentType != null) {
            switch (instrumentType) {
                case FOREX_INSTRUMENT:
                case CRYPTO_INSTRUMENT:
                case CFD_INSTRUMENT:
                case DIGITAL_INSTRUMENT:
                case FX_INSTRUMENT:
                    com.iqoption.dialog.a.h.a(ahQ(), instrumentType, com.iqoption.util.c.G(bVar.avS()));
                    break;
                case TURBO_INSTRUMENT:
                case BINARY_INSTRUMENT:
                    ImmutableList avR = bVar.avR();
                    long[] jArr = new long[avR.size()];
                    int size = avR.size();
                    for (int i = 0; i < size; i++) {
                        jArr[i] = ((Long) avR.get(i)).longValue();
                    }
                    com.iqoption.dialog.a.h.a(ahQ(), instrumentType, jArr);
                    break;
            }
        }
    }

    public void d(j jVar) {
        if (ayf()) {
            w(jVar.axk());
        } else {
            b(zzakw(), i(jVar));
        }
    }

    private void w(e eVar) {
        if (eVar != null) {
            com.iqoption.app.managers.c.Gn().g(eVar);
        }
    }

    public void c(g gVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("withdraw ");
        stringBuilder.append(gVar);
        com.iqoption.core.i.d("PortfolioFragment", stringBuilder.toString());
        gVar.au(true);
        this.dcH.axN();
        double GN = gVar.avU().GN();
        double axe = gVar.axe();
        String Xg = gVar.Xg();
        ag.b(com.iqoption.withdrawal.crypto.a.d(GN, axe, Xg), new b(this, GN, axe, Xg, false, gVar));
    }

    public void b(g gVar) {
        com.iqoption.dialog.b.a.a(ahQ(), this.dcH.axM(), gVar.getId());
    }

    public s<?> g(Rect rect) {
        bf.a(ahQ(), this.dcH.axL(), rect.right, rect.top);
        this.ddm = y.wb();
        return this.ddm;
    }

    public void reload() {
        com.iqoption.app.managers.c.Gn().update();
    }

    public boolean b(com.iqoption.portfolio.component.b.l lVar) {
        String Ml = lVar.Ml();
        boolean iQ = this.ddb.iQ(Ml);
        this.dcH.a(Ml, lVar, iQ);
        return iQ;
    }

    public boolean c(com.iqoption.portfolio.component.b.l lVar) {
        return this.ddb.iO(lVar.Ml());
    }

    public boolean e(m mVar) {
        String Ml = mVar.Ml();
        String awt = this.ddb.awt();
        boolean iR = this.ddb.iR(Ml);
        this.dcH.j(Ml, awt, iR);
        return iR;
    }

    public boolean f(m mVar) {
        return this.ddb.iP(mVar.Ml());
    }

    public void l(Order order) {
        if (this.ddf != null) {
            t(order);
        }
        this.ddf = null;
    }

    public void m(Order order) {
        if (this.ddf != null) {
            this.ddf.h(new Throwable("cancelled closing order"));
        }
        this.ddf = null;
    }

    public s<?> g(m mVar) {
        this.ddf = y.wb();
        com.iqoption.fragment.dialog.c.a(this.dcH.axL(), ahQ(), this, mVar.axr());
        return this.ddf;
    }

    private void t(Order order) {
        s q = this.dcY.q(order);
        if (q != null) {
            this.ddf.a(q);
            ag.a(q, new com.google.common.util.concurrent.n<Object>() {
                public void onSuccess(Object obj) {
                    z.this.ddf = null;
                }

                public void l(Throwable th) {
                    z.this.ddf = null;
                }
            });
            return;
        }
        this.ddf.h(new Throwable("order is in progress"));
    }

    public boolean h(m mVar) {
        return this.dcY.r(mVar.axr());
    }

    public void j(m mVar) {
        if (ayf()) {
            com.iqoption.core.microservices.tradingengine.response.active.a Jg = mVar.Jg();
            com.iqoption.app.managers.tab.a.Il().d(Jg.getActiveId(), Jg.getInstrumentType());
            com.iqoption.gl.b.aow().glchSelectLimitOrder(mVar.axp(), mVar.isCall());
        }
    }

    private void gf(int i) {
        this.dcY.fJ(i);
        this.dcH.axJ();
    }

    private void ayh() {
        this.cYW.awJ();
        this.dcH.axK();
    }

    private void ayi() {
        this.dcH.axO();
    }

    void close() {
        q(requireActivity());
        k.Bz();
    }

    void expand() {
        a(zzakw(), i(null));
        k.By();
    }

    void ayj() {
        v.a(this.dcH.axM(), ahQ());
        k.Bx();
    }

    void bH(@NonNull View view) {
        if (this.ddn == null) {
            this.ddn = new com.iqoption.widget.a.a();
            aez aez = (aez) DataBindingUtil.inflate(getLayoutInflater(), R.layout.portfolio_filter_options, null, false);
            aez.axw.setAdapter(new com.iqoption.portfolio.component.l(com.iqoption.portfolio.component.b.d.bH(requireContext()), new aa(this), null));
            View root = aez.getRoot();
            com.iqoption.core.ext.a.N(root);
            this.ddn.g(root, root.getMeasuredWidth(), root.getMeasuredHeight());
        }
        if (!this.ddn.isShowing()) {
            this.ddn.L(view);
        }
    }
}
