package com.iqoption.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.v;
import com.iqoption.analytics.s;
import com.iqoption.app.managers.af;
import com.iqoption.core.data.model.ActiveType;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.d.ui;
import com.iqoption.d.wj;
import com.iqoption.dto.Event.Builder;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.signals.SignalsViewModel;
import com.iqoption.util.ag;
import com.iqoption.util.au;
import com.iqoption.util.bg;
import com.iqoption.x.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* compiled from: WelcomeTrendingFragment */
public class fc extends com.iqoption.fragment.base.b {
    private Builder adT;
    private SignalsViewModel ctt;
    private final f ctu = new f(this);
    v ctv = MoreExecutors.a(Executors.newSingleThreadScheduledExecutor());
    private int ctw = 0;
    private ui ctx;
    private final Object lock = new Object();

    /* compiled from: WelcomeTrendingFragment */
    private final class a {
        public com.iqoption.core.microservices.tradingengine.response.active.a aiJ;
        public com.iqoption.signals.c ctA;

        public a(com.iqoption.signals.c cVar) {
            this.aiJ = cVar.Jg();
            this.ctA = cVar;
        }
    }

    /* compiled from: WelcomeTrendingFragment */
    private final class b {
        public com.iqoption.core.microservices.tradingengine.response.active.a aiJ;
        public com.iqoption.core.microservices.f.a.a.a ctC;

        public b(com.iqoption.core.microservices.tradingengine.response.active.a aVar, com.iqoption.core.microservices.f.a.a.a aVar2) {
            this.aiJ = aVar;
            this.ctC = aVar2;
        }
    }

    /* compiled from: WelcomeTrendingFragment */
    private interface p {
        void a(com.iqoption.signals.c cVar);

        void f(int i, InstrumentType instrumentType);
    }

    /* compiled from: WelcomeTrendingFragment */
    private abstract class i extends Adapter<j> {
        protected LayoutInflater aDN;
        protected final p ctG;
        RecyclerView mRecyclerView;

        protected abstract Callable aiZ();

        protected abstract void da(boolean z);

        public i(p pVar) {
            this.ctG = pVar;
            setHasStableIds(true);
        }

        /* renamed from: I */
        public j onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (this.aDN == null) {
                this.aDN = LayoutInflater.from(viewGroup.getContext());
            }
            return new j(wj.M(this.aDN, viewGroup, false), this.ctG);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
            this.mRecyclerView = recyclerView;
        }

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
            super.onDetachedFromRecyclerView(recyclerView);
            this.mRecyclerView = null;
        }

        boolean isDetached() {
            return this.mRecyclerView == null || !this.mRecyclerView.isAttachedToWindow();
        }
    }

    /* compiled from: WelcomeTrendingFragment */
    private final class j extends ViewHolder {
        private com.iqoption.core.microservices.tradingengine.response.active.a aiJ;
        private com.iqoption.signals.c ctA;
        private p ctG;
        private wj ctH;

        public j(wj wjVar, p pVar) {
            super(wjVar.getRoot());
            this.ctH = wjVar;
            this.ctG = pVar;
            this.itemView.setOnClickListener(new com.iqoption.view.d.b(fc.this) {
                public void q(View view) {
                    if (j.this.getAdapterPosition() != -1 && j.this.ctG != null) {
                        if (j.this.ctA != null) {
                            j.this.ctG.a(j.this.ctA);
                        } else if (j.this.aiJ != null) {
                            j.this.ctG.f(j.this.aiJ.getActiveId(), j.this.aiJ.getInstrumentType());
                        }
                    }
                }
            });
        }

        private final Context t(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
            this.aiJ = aVar;
            Context context = this.ctH.getRoot().getContext();
            if (!TextUtils.isEmpty(aVar.getImage())) {
                Picasso.with(context).load(aVar.getImage()).into(this.ctH.bkT);
            }
            this.ctH.bAu.setText(com.iqoption.util.e.a.s(aVar));
            this.ctH.bkV.setText(com.iqoption.util.e.a.O(aVar.getInstrumentType()));
            return context;
        }

        private void u(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
            t(aVar);
            this.ctH.bJv.setText(com.iqoption.core.util.p.o((double) (100 - aVar.Xi().intValue())));
        }

        private void a(com.iqoption.core.microservices.tradingengine.response.active.a aVar, Double d, boolean z) {
            Context t = t(aVar);
            this.ctH.bJv.setText(com.iqoption.core.util.p.a(d.doubleValue(), com.iqoption.util.l.b(d), 2, true));
            if (d.doubleValue() > 0.01d) {
                this.ctH.bJv.setTextColor(ContextCompat.getColor(t, R.color.green));
            } else if (d.doubleValue() < -0.01d) {
                this.ctH.bJv.setTextColor(ContextCompat.getColor(t, R.color.red));
            } else {
                this.ctH.bJv.setTextColor(ContextCompat.getColor(t, R.color.white));
            }
        }

        private void a(b bVar) {
            t(bVar.aiJ);
        }

        private void a(com.iqoption.core.microservices.tradingengine.response.active.a aVar, @Nullable Double d) {
            CharSequence charSequence;
            Context t = t(aVar);
            TextView textView = this.ctH.bJv;
            if (d == null) {
                charSequence = "";
            } else {
                charSequence = String.format(Locale.US, "%s%%", new Object[]{com.iqoption.util.q.dY(3).format(d)});
            }
            textView.setText(charSequence);
            this.ctH.bJv.setTextColor(ContextCompat.getColor(t, R.color.grey_blur_70));
        }

        public void a(a aVar) {
            Context t = t(aVar.aiJ);
            this.ctA = aVar.ctA;
            if (this.ctA.aDZ()) {
                this.ctH.bJv.setTextColor(ContextCompat.getColor(t, R.color.green));
            } else {
                this.ctH.bJv.setTextColor(ContextCompat.getColor(t, R.color.red));
            }
            String[] split = this.ctA.getValue().split(" ");
            if (split.length >= 3) {
                this.ctH.bJv.setText(split[0]);
                TextView textView = this.ctH.bkV;
                CharSequence stringBuilder = new StringBuilder(split[1]);
                stringBuilder.append(' ');
                stringBuilder.append(split[2]);
                stringBuilder.append(' ');
                stringBuilder.append(split[3]);
                textView.setText(stringBuilder);
            }
        }
    }

    /* compiled from: WelcomeTrendingFragment */
    private class o implements p {
        private final int ctN;

        public o(int i) {
            this.ctN = i;
        }

        public void f(int i, InstrumentType instrumentType) {
            fc.this.aN();
            com.iqoption.app.managers.tab.a.Il().d(i, instrumentType);
            s.a((double) this.ctN, i);
        }

        public void a(com.iqoption.signals.c cVar) {
            fc.this.aN();
            s.a((double) this.ctN, cVar.Jg().getActiveId());
        }
    }

    /* compiled from: WelcomeTrendingFragment */
    private abstract class c extends i {
        protected ImmutableList<b> ctD = ImmutableList.sL();

        public c(p pVar) {
            super(pVar);
        }

        public int getItemCount() {
            int size = this.ctD.size();
            return size > 5 ? 5 : size;
        }

        public long getItemId(int i) {
            com.iqoption.core.microservices.tradingengine.response.active.a aVar = ((b) this.ctD.get(i)).aiJ;
            if (aVar == null) {
                return 0;
            }
            return (((long) com.google.common.base.f.hashCode(aVar.getInstrumentType())) << 31) | ((long) aVar.getActiveId());
        }
    }

    /* compiled from: WelcomeTrendingFragment */
    private final class d extends i {
        private ImmutableList<com.iqoption.core.microservices.tradingengine.response.active.a> ctD = ImmutableList.sL();

        public d(p pVar) {
            super(pVar);
            fc.this.a(aiZ(), new e(this));
        }

        protected Callable aiZ() {
            return fh.alb;
        }

        /* renamed from: a */
        public void onBindViewHolder(j jVar, int i) {
            jVar.u((com.iqoption.core.microservices.tradingengine.response.active.a) this.ctD.get(i));
        }

        public int getItemCount() {
            int size = this.ctD.size();
            return size > 5 ? 5 : size;
        }

        protected void da(boolean z) {
            if (z) {
                fc.this.ctx.bGG.setVisibility(0);
                fc.this.ctx.bGH.setVisibility(0);
                return;
            }
            fc.this.ctx.bGG.setVisibility(8);
            fc.this.ctx.bGH.setVisibility(8);
        }
    }

    /* compiled from: WelcomeTrendingFragment */
    private static final class e extends com.iqoption.system.c.b<d, ImmutableList<com.iqoption.core.microservices.tradingengine.response.active.a>> {
        public e(d dVar) {
            super((Object) dVar);
        }

        /* renamed from: b */
        public void z(@NonNull d dVar, @NonNull ImmutableList<com.iqoption.core.microservices.tradingengine.response.active.a> immutableList) {
            super.z(dVar, immutableList);
            if (!dVar.isDetached()) {
                dVar.da(immutableList.isEmpty() ^ 1);
                int size = dVar.ctD.size();
                dVar.ctD = immutableList;
                dVar.notifyDataSetChanged();
                if (size == 0) {
                    dVar.mRecyclerView.scheduleLayoutAnimation();
                }
            }
        }

        /* renamed from: a */
        public void c(@NonNull d dVar, Throwable th) {
            super.c(dVar, th);
            dVar.da(false);
        }
    }

    /* compiled from: WelcomeTrendingFragment */
    private class f extends com.iqoption.system.a.e<fc> {
        public f(fc fcVar) {
            super(fcVar);
        }
    }

    /* compiled from: WelcomeTrendingFragment */
    private final class g extends i {
        private ImmutableList<com.iqoption.signals.a> ahR = ImmutableList.sL();
        protected ImmutableList<a> ctD = ImmutableList.sL();

        public int getItemCount() {
            return this.ctD.size();
        }

        public long getItemId(int i) {
            com.iqoption.core.microservices.tradingengine.response.active.a aVar = ((a) this.ctD.get(i)).aiJ;
            if (aVar == null) {
                return 0;
            }
            return (((long) com.google.common.base.f.hashCode(aVar.getInstrumentType())) << 31) | ((long) aVar.getActiveId());
        }

        public g(p pVar) {
            super(pVar);
            fc.this.ctt.Qs().observe(fc.this, new fj(this, fc.this.ctt.Qs()));
        }

        protected Callable aiZ() {
            return new fk(this);
        }

        final /* synthetic */ Object ajb() {
            return com.google.common.collect.i.c(this.ahR).b(new fl(this)).c(new fm(af.Hu().Hw())).sA();
        }

        final /* synthetic */ a a(com.iqoption.signals.a aVar) {
            return (aVar == null || !(aVar instanceof com.iqoption.signals.c)) ? null : new a((com.iqoption.signals.c) aVar);
        }

        /* renamed from: a */
        public void onBindViewHolder(j jVar, int i) {
            jVar.a((a) this.ctD.get(i));
        }

        protected void da(boolean z) {
            if (z) {
                fc.this.ctx.bGI.setVisibility(0);
                fc.this.ctx.bGJ.setVisibility(0);
                return;
            }
            fc.this.ctx.bGI.setVisibility(8);
            fc.this.ctx.bGJ.setVisibility(8);
        }
    }

    /* compiled from: WelcomeTrendingFragment */
    private static final class h extends com.iqoption.system.c.b<g, ImmutableList<a>> {
        public h(g gVar) {
            super((Object) gVar);
        }

        /* renamed from: a */
        public void z(@NonNull g gVar, @NonNull ImmutableList<a> immutableList) {
            super.z(gVar, immutableList);
            if (!gVar.isDetached()) {
                gVar.da(immutableList.isEmpty() ^ 1);
                int size = gVar.ctD.size();
                gVar.ctD = immutableList;
                gVar.notifyDataSetChanged();
                if (size == 0) {
                    gVar.mRecyclerView.scheduleLayoutAnimation();
                }
            }
        }

        /* renamed from: a */
        public void c(@NonNull g gVar, Throwable th) {
            super.c(gVar, th);
            gVar.da(false);
        }
    }

    /* compiled from: WelcomeTrendingFragment */
    private static final class l extends com.iqoption.system.c.b<k, ImmutableList<b>> {
        public l(k kVar) {
            super((Object) kVar);
        }

        /* renamed from: a */
        public void z(@NonNull k kVar, @NonNull ImmutableList<b> immutableList) {
            super.z(kVar, immutableList);
            if (!kVar.isDetached()) {
                kVar.da(immutableList.isEmpty() ^ 1);
                int size = kVar.ctD.size();
                kVar.ctD = immutableList;
                kVar.notifyDataSetChanged();
                if (size == 0) {
                    kVar.mRecyclerView.scheduleLayoutAnimation();
                }
            }
        }

        /* renamed from: a */
        public void c(@NonNull k kVar, Throwable th) {
            super.c(kVar, th);
            kVar.da(false);
        }
    }

    /* compiled from: WelcomeTrendingFragment */
    private static final class n extends com.iqoption.system.c.b<m, ImmutableList<b>> {
        public n(m mVar) {
            super((Object) mVar);
        }

        /* renamed from: i */
        public void onSuccess(ImmutableList<b> immutableList) {
            super.onSuccess(immutableList);
        }

        /* renamed from: a */
        public void z(@NonNull m mVar, @NonNull ImmutableList<b> immutableList) {
            super.z(mVar, immutableList);
            if (!mVar.isDetached()) {
                mVar.da(immutableList.isEmpty() ^ 1);
                int size = mVar.ctD.size();
                mVar.ctD = immutableList;
                mVar.notifyDataSetChanged();
                if (size == 0) {
                    mVar.mRecyclerView.scheduleLayoutAnimation();
                }
            }
        }

        /* renamed from: a */
        public void c(@NonNull m mVar, Throwable th) {
            super.c(mVar, th);
            mVar.da(false);
        }
    }

    /* compiled from: WelcomeTrendingFragment */
    private static final class r extends com.iqoption.system.c.b<q, ImmutableList<b>> {
        public r(q qVar) {
            super((Object) qVar);
        }

        /* renamed from: a */
        public void z(@NonNull q qVar, @NonNull ImmutableList<b> immutableList) {
            super.z(qVar, immutableList);
            if (!qVar.isDetached()) {
                qVar.da(immutableList.isEmpty() ^ 1);
                int size = qVar.ctD.size();
                qVar.ctD = immutableList;
                qVar.notifyDataSetChanged();
                if (size == 0) {
                    qVar.mRecyclerView.scheduleLayoutAnimation();
                }
            }
        }

        /* renamed from: a */
        public void c(@NonNull q qVar, Throwable th) {
            super.c(qVar, th);
            qVar.da(false);
        }
    }

    /* compiled from: WelcomeTrendingFragment */
    private final class k extends c {
        public k(p pVar) {
            super(pVar);
            fc.this.a(aiZ(), new l(this));
        }

        protected Callable aiZ() {
            return new fn(this);
        }

        final /* synthetic */ Object ajc() {
            com.iqoption.app.helpers.a FI = com.iqoption.app.helpers.a.FI();
            long Hw = af.Hu().Hw();
            Iterable arrayList = new ArrayList();
            Comparator comparator = fo.$instance;
            com.google.common.base.j fpVar = new fp(Hw);
            com.google.common.base.d fqVar = new fq(this, FI);
            ImmutableList sL = ImmutableList.sL();
            if (com.iqoption.app.managers.feature.a.HL()) {
                sL = com.google.common.collect.i.c(FI.j(InstrumentType.FOREX_INSTRUMENT).entrySet()).b(fqVar).c(fpVar).a(comparator);
            }
            ImmutableList sL2 = ImmutableList.sL();
            if (com.iqoption.app.managers.feature.a.HM()) {
                sL2 = com.google.common.collect.i.c(FI.j(InstrumentType.CRYPTO_INSTRUMENT).entrySet()).b(fqVar).c(fpVar).a(comparator);
            }
            ImmutableList sL3 = ImmutableList.sL();
            if (com.iqoption.app.managers.feature.a.HK()) {
                sL3 = com.google.common.collect.i.c(FI.j(InstrumentType.CFD_INSTRUMENT).entrySet()).b(fqVar).c(fpVar).a(comparator);
            }
            com.iqoption.util.i.a(5, (List) arrayList, sL2, sL3, sL);
            return com.google.common.collect.i.c(arrayList).a(comparator).sJ();
        }

        /* renamed from: a */
        public void onBindViewHolder(j jVar, int i) {
            b bVar = (b) this.ctD.get(i);
            jVar.a(bVar.aiJ, au.h(com.iqoption.core.microservices.f.a.a.a.c(bVar.ctC), com.iqoption.core.microservices.f.a.a.a.aYn.a(bVar.ctC)));
        }

        protected void da(boolean z) {
            if (z) {
                fc.this.ctx.bGL.setVisibility(0);
                fc.this.ctx.bGM.setVisibility(0);
                return;
            }
            fc.this.ctx.bGL.setVisibility(8);
            fc.this.ctx.bGM.setVisibility(8);
        }
    }

    /* compiled from: WelcomeTrendingFragment */
    private final class m extends c {
        public m(p pVar) {
            super(pVar);
            fc.this.a(aiZ(), new n(this));
        }

        protected Callable aiZ() {
            return new fr(this);
        }

        final /* synthetic */ Object ajd() {
            com.iqoption.app.helpers.a FI = com.iqoption.app.helpers.a.FI();
            long Hw = af.Hu().Hw();
            Iterable arrayList = new ArrayList();
            Comparator comparator = fs.$instance;
            com.google.common.base.j ftVar = new ft(Hw);
            com.google.common.base.d fuVar = new fu(this, FI);
            ImmutableList sL = ImmutableList.sL();
            if (com.iqoption.app.managers.feature.a.HL()) {
                sL = com.google.common.collect.i.c(FI.j(InstrumentType.FOREX_INSTRUMENT).entrySet()).b(fuVar).c(ftVar).a(comparator);
            }
            ImmutableList sL2 = ImmutableList.sL();
            if (com.iqoption.app.managers.feature.a.HM()) {
                sL2 = com.google.common.collect.i.c(FI.j(InstrumentType.CRYPTO_INSTRUMENT).entrySet()).b(fuVar).c(ftVar).a(comparator);
            }
            ImmutableList sL3 = ImmutableList.sL();
            if (com.iqoption.app.managers.feature.a.HK()) {
                sL3 = com.google.common.collect.i.c(FI.j(InstrumentType.CFD_INSTRUMENT).entrySet()).b(fuVar).c(ftVar).a(comparator);
            }
            ImmutableList sL4 = ImmutableList.sL();
            if (com.iqoption.app.managers.feature.a.HH()) {
                sL4 = com.google.common.collect.i.c(FI.j(InstrumentType.DIGITAL_INSTRUMENT).entrySet()).b(fuVar).c(ftVar).a(comparator);
            }
            ImmutableList sL5 = ImmutableList.sL();
            if (com.iqoption.app.managers.feature.a.HI()) {
                sL4 = com.google.common.collect.i.c(FI.c(ActiveType.FX_ACTIVE).entrySet()).b(fuVar).c(ftVar).a(comparator);
            }
            com.iqoption.util.i.a(5, (List) arrayList, sL2, sL4, sL, sL3, sL5);
            return com.google.common.collect.i.c(arrayList).a(comparator).sJ();
        }

        /* renamed from: a */
        public void onBindViewHolder(j jVar, int i) {
            jVar.a((b) this.ctD.get(i));
        }

        protected void da(boolean z) {
            if (z) {
                fc.this.ctx.bGN.setVisibility(0);
                fc.this.ctx.bGO.setVisibility(0);
                return;
            }
            fc.this.ctx.bGN.setVisibility(8);
            fc.this.ctx.bGO.setVisibility(8);
        }
    }

    /* compiled from: WelcomeTrendingFragment */
    private final class q extends c {
        private final boolean ctO;

        public q(p pVar, boolean z) {
            super(pVar);
            this.ctO = z;
            fc.this.a(aiZ(), new r(this));
        }

        /* renamed from: a */
        public void onBindViewHolder(j jVar, int i) {
            b bVar = (b) this.ctD.get(i);
            jVar.a(bVar.aiJ, com.iqoption.core.microservices.f.a.a.a.b(bVar.ctC), this.ctO);
        }

        protected Callable aiZ() {
            return new fv(this);
        }

        final /* synthetic */ Object aje() {
            long Hw = af.Hu().Hw();
            com.iqoption.app.helpers.a FI = com.iqoption.app.helpers.a.FI();
            Iterable arrayList = new ArrayList();
            com.google.common.base.j fwVar = new fw(Hw);
            Comparator fxVar = new fx(this);
            com.google.common.base.d fyVar = new fy(this, FI);
            ImmutableList sL = ImmutableList.sL();
            if (com.iqoption.app.managers.feature.a.HL()) {
                sL = com.google.common.collect.i.c(FI.j(InstrumentType.FOREX_INSTRUMENT).entrySet()).b(fyVar).c(fwVar).a(fxVar);
            }
            ImmutableList sL2 = ImmutableList.sL();
            if (com.iqoption.app.managers.feature.a.HM()) {
                sL2 = com.google.common.collect.i.c(FI.j(InstrumentType.CRYPTO_INSTRUMENT).entrySet()).b(fyVar).c(fwVar).a(fxVar);
            }
            ImmutableList sL3 = ImmutableList.sL();
            if (com.iqoption.app.managers.feature.a.HK()) {
                sL3 = com.google.common.collect.i.c(FI.j(InstrumentType.CFD_INSTRUMENT).entrySet()).b(fyVar).c(fwVar).a(fxVar);
            }
            com.iqoption.util.i.a(5, (List) arrayList, sL2, sL3, sL);
            return com.google.common.collect.i.c(arrayList).a(fxVar).sJ();
        }

        protected void da(boolean z) {
            if (z) {
                if (this.ctO) {
                    fc.this.ctx.bGR.setVisibility(0);
                    fc.this.ctx.bGS.setVisibility(0);
                    return;
                }
                fc.this.ctx.bGT.setVisibility(0);
                fc.this.ctx.bGU.setVisibility(0);
            } else if (this.ctO) {
                fc.this.ctx.bGR.setVisibility(8);
                fc.this.ctx.bGS.setVisibility(8);
            } else {
                fc.this.ctx.bGT.setVisibility(8);
                fc.this.ctx.bGU.setVisibility(8);
            }
        }
    }

    public long getAnimationDuration() {
        return 300;
    }

    private static fc aiO() {
        fc fcVar = new fc();
        fcVar.setArguments(new Bundle());
        return fcVar;
    }

    public static void c(@NonNull FragmentActivity fragmentActivity, @NonNull FragmentManager fragmentManager) {
        if (com.iqoption.app.af.DX().Ev() && aiQ() && com.iqoption.app.managers.feature.a.eW("popup-trending-now") && fragmentManager.findFragmentByTag("WelcomeTrendingFragment") == null) {
            a(fragmentActivity, fragmentManager);
        }
    }

    private static void a(@NonNull FragmentActivity fragmentActivity, @NonNull FragmentManager fragmentManager) {
        PopupViewModel.j(fragmentActivity).a(new fd(fragmentManager), "WelcomeTrendingFragment");
    }

    private static void e(@NonNull FragmentManager fragmentManager) {
        if (fragmentManager.findFragmentByTag("WelcomeTrendingFragment") == null) {
            fragmentManager.beginTransaction().add(R.id.fragment, aiO(), "WelcomeTrendingFragment").addToBackStack("WelcomeTrendingFragment").commitAllowingStateLoss();
            com.iqoption.app.af.setLong("last_time_showed_trending_today_screen", System.currentTimeMillis());
        }
    }

    private static long aiP() {
        return TimeUnit.HOURS.toMillis(12);
    }

    private static boolean aiQ() {
        return System.currentTimeMillis() - com.iqoption.app.af.getLong("last_time_showed_trending_today_screen") > aiP();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ctx = (ui) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_welcome_trending, viewGroup, false);
        this.ctt = SignalsViewModel.A(zzakw());
        this.ctx.btH.setOnClickListener(new fe(this));
        this.ctx.bGP.setOnScrollChangedListener(new fg(new com.iqoption.util.p(ff.alc)));
        this.adT = s.Cf();
        aiR();
        aiS();
        aiT();
        aiU();
        aiV();
        aiW();
        return this.ctx.getRoot();
    }

    final /* synthetic */ void aU(View view) {
        aN();
        s.Cg();
    }

    public void onDestroyView() {
        super.onDestroyView();
        synchronized (this.lock) {
            this.ctv.shutdownNow();
        }
        this.ctx.bGG.setAdapter(null);
        s.d(this.adT);
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    private void aiR() {
        if (com.iqoption.app.managers.feature.a.HJ()) {
            Adapter dVar = new d(new o(0));
            this.ctx.bGG.setHasFixedSize(true);
            this.ctx.bGG.setAdapter(dVar);
            this.ctx.bGG.scheduleLayoutAnimation();
            return;
        }
        this.ctx.bGH.setVisibility(8);
        this.ctx.bGG.setVisibility(8);
    }

    private void aiS() {
        Adapter mVar = new m(new o(1));
        this.ctx.bGN.setHasFixedSize(true);
        this.ctx.bGN.setAdapter(mVar);
    }

    private void aiT() {
        Adapter qVar = new q(new o(2), true);
        this.ctx.bGR.setHasFixedSize(true);
        this.ctx.bGR.setAdapter(qVar);
    }

    private void aiU() {
        Adapter qVar = new q(new o(3), false);
        this.ctx.bGT.setHasFixedSize(true);
        this.ctx.bGT.setAdapter(qVar);
    }

    private void aiV() {
        Adapter kVar = new k(new o(4));
        this.ctx.bGL.setHasFixedSize(true);
        this.ctx.bGL.setAdapter(kVar);
    }

    private void aiW() {
        Adapter gVar = new g(new o(5));
        this.ctx.bGI.setHasFixedSize(true);
        this.ctx.bGI.setAdapter(gVar);
    }

    public boolean onClose() {
        requireFragmentManager().popBackStack();
        PopupViewModel.j(requireActivity()).hO("WelcomeTrendingFragment");
        return true;
    }

    public void ND() {
        aiY();
        Animator c = com.iqoption.view.a.a.a.c(this.ctx.blc, bg.getColor(R.color.transparent), bg.getColor(R.color.bg_second_level_50));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ctx.bGK, View.TRANSLATION_Y, new float[]{(float) this.ctx.bGK.getHeight(), 0.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        com.iqoption.util.b.a(animatorSet, getAnimationDuration());
        animatorSet.setInterpolator(com.iqoption.view.a.a.d.dEM);
        animatorSet.playTogether(new Animator[]{c, ofFloat});
        animatorSet.start();
    }

    public void NE() {
        aiX();
        Animator c = com.iqoption.view.a.a.a.c(this.ctx.blc, bg.getColor(R.color.bg_second_level_50), bg.getColor(R.color.transparent));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ctx.bGK, View.TRANSLATION_Y, new float[]{(float) this.ctx.bGK.getHeight()});
        AnimatorSet animatorSet = new AnimatorSet();
        com.iqoption.util.b.a(animatorSet, getAnimationDuration());
        animatorSet.setInterpolator(com.iqoption.view.a.a.d.dEM);
        animatorSet.playTogether(new Animator[]{c, ofFloat});
        animatorSet.start();
    }

    private void aiX() {
        cr ajW = ajW();
        if (ajW != null) {
            ajW.h("WelcomeTrendingFragment", getAnimationDuration());
        }
    }

    private void aiY() {
        cr ajW = ajW();
        if (ajW != null) {
            ajW.i("WelcomeTrendingFragment", getAnimationDuration());
        }
    }

    private void a(Callable callable, com.google.common.util.concurrent.n nVar) {
        a(callable, nVar, getAnimationDuration() + 16);
    }

    private void a(Callable callable, com.google.common.util.concurrent.n nVar, long j) {
        synchronized (this.lock) {
            ag.b(this.ctv.a(callable, j + ((long) (this.ctw * 100)), TimeUnit.MILLISECONDS), nVar);
            this.ctw++;
        }
    }
}
