package com.iqoption.dialog.b;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.i;
import com.iqoption.d.adc;
import com.iqoption.d.bm;
import com.iqoption.dto.entity.OvernightHistory;
import com.iqoption.dto.entity.OvernightHistory.List;
import com.iqoption.dto.entity.position.PendingOrderWrapper;
import com.iqoption.util.ag;
import com.iqoption.util.bf;
import com.iqoption.util.g;
import com.iqoption.util.l;
import com.iqoption.x.R;
import java.util.Iterator;

/* compiled from: OvernightBottomSheet */
public final class a extends com.iqoption.fragment.base.a {
    private a cjw;
    private String cjx;
    private bm cjy;

    /* compiled from: OvernightBottomSheet */
    private final class a extends Adapter<b> {
        private LayoutInflater aDN;
        private String activeName;
        private ImmutableList<OvernightHistory> cjA;

        private a() {
            this.cjA = ImmutableList.sL();
        }

        /* synthetic */ a(a aVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void n(ImmutableList<OvernightHistory> immutableList) {
            if (immutableList != null) {
                this.cjA = immutableList;
                if (!this.cjA.isEmpty()) {
                    OvernightHistory overnightHistory = (OvernightHistory) this.cjA.get(0);
                    com.iqoption.core.microservices.tradingengine.response.active.a a = com.iqoption.app.helpers.a.FI().a(Integer.valueOf(overnightHistory.activeId), overnightHistory.instrumentType);
                    if (a != null) {
                        this.activeName = com.iqoption.util.e.a.s(a);
                    }
                }
            }
        }

        /* renamed from: C */
        public b onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (this.aDN == null) {
                this.aDN = LayoutInflater.from(viewGroup.getContext());
            }
            return new b(adc.ah(this.aDN, viewGroup, false));
        }

        /* renamed from: a */
        public void onBindViewHolder(b bVar, int i) {
            bVar.a((OvernightHistory) this.cjA.get(i), this.activeName);
        }

        public int getItemCount() {
            return this.cjA.size();
        }

        public long getItemId(int i) {
            return ((OvernightHistory) this.cjA.get(i)).filledAt;
        }
    }

    /* compiled from: OvernightBottomSheet */
    private final class b extends ViewHolder {
        private adc cjB;

        public b(adc adc) {
            super(adc.getRoot());
            this.cjB = adc;
        }

        private void a(OvernightHistory overnightHistory, String str) {
            this.cjB.bAu.setText(str);
            this.cjB.bNU.setText(bf.cZV.format(Long.valueOf(overnightHistory.filledAt)));
            this.cjB.blC.setText(l.e(a.this.cjx, Double.valueOf(overnightHistory.amountDelta)));
        }
    }

    /* compiled from: OvernightBottomSheet */
    private class c extends com.iqoption.system.c.b<a, List> {
        public c(a aVar, Class<List> cls) {
            super(aVar, cls);
        }

        /* renamed from: a */
        public void z(@NonNull a aVar, @NonNull List list) {
            ImmutableList a = i.c((Iterable) list).a(OvernightHistory.SORTING);
            aVar.cjy.bly.setVisibility(8);
            aVar.m(a);
            aVar.cjw.n(a);
            aVar.cjw.notifyDataSetChanged();
        }

        /* renamed from: a */
        public void c(@NonNull a aVar, Throwable th) {
            aVar.cjy.bly.setVisibility(8);
            com.iqoption.app.a.b.FG();
        }
    }

    protected boolean getSkipCollapsed() {
        return false;
    }

    public static void a(FragmentManager fragmentManager, @IdRes int i, long j) {
        a(fragmentManager, i, new g().j("arg.position.id", j).toBundle());
    }

    private static void a(FragmentManager fragmentManager, @IdRes int i, Bundle bundle) {
        if (fragmentManager.findFragmentByTag("OvernightBottomSheet") == null) {
            fragmentManager.beginTransaction().add(i, W(bundle), "OvernightBottomSheet").setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack("OvernightBottomSheet").commit();
        }
    }

    private static a W(Bundle bundle) {
        a aVar = new a();
        aVar.setArguments(bundle);
        return aVar;
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.cjy = bm.e(layoutInflater, viewGroup, false);
        this.cjy.blw.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                a.this.onClose();
            }
        });
        Context context = getContext();
        this.cjx = l.CD();
        LayoutManager linearLayoutManager = new LinearLayoutManager(context);
        ItemDecoration dividerItemDecoration = new DividerItemDecoration(context, linearLayoutManager.getOrientation());
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(context, R.drawable.separator_black));
        this.cjy.axw.setLayoutManager(linearLayoutManager);
        this.cjy.axw.addItemDecoration(dividerItemDecoration);
        this.cjy.axw.setHasFixedSize(true);
        this.cjw = new a(this, null);
        this.cjy.axw.setAdapter(this.cjw);
        return this.cjy.getRoot();
    }

    protected View aeO() {
        return this.cjy.blz;
    }

    protected View aeP() {
        return this.cjy.blp;
    }

    protected int getPeekHeight() {
        return (int) (((float) getResources().getDisplayMetrics().heightPixels) * 0.5625f);
    }

    private void m(ImmutableList<OvernightHistory> immutableList) {
        if (immutableList != null) {
            double d = 0.0d;
            Iterator sI = immutableList.iterator();
            while (sI.hasNext()) {
                d += ((OvernightHistory) sI.next()).amountDelta;
            }
            this.cjy.blC.setText(l.e(this.cjx, Double.valueOf(d)));
        }
    }

    public void onResume() {
        super.onResume();
        ag.b(com.iqoption.mobbtech.connect.request.a.a.b.A(List.class).ga("get-overnight-history").j(PendingOrderWrapper.POSITION_ID, Long.valueOf(getArguments().getLong("arg.position.id"))).Sa(), new c(this, List.class));
    }
}
