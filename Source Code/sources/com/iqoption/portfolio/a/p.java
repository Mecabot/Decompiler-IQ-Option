package com.iqoption.portfolio.a;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.managers.r;
import com.iqoption.d.acs;
import com.iqoption.d.bk;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.microservice.d.a.d;
import com.iqoption.util.au;
import com.iqoption.util.bf;
import com.iqoption.util.l;
import com.iqoption.x.R;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.List;

/* compiled from: OtnEmissionHistoryBottomSheet */
public final class p extends com.iqoption.fragment.base.a {
    private Builder adT;
    private DateFormat cgq;
    private DecimalFormat crm;
    private bk dcC;
    private com.iqoption.view.a dcD;
    private com.iqoption.view.a dcE;

    /* compiled from: OtnEmissionHistoryBottomSheet */
    private final class a extends Adapter<b> {
        private LayoutInflater aDN;
        private final List<d> cSr;

        private a() {
            this.cSr = r.GT().Hl();
        }

        /* synthetic */ a(p pVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: S */
        public b onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (this.aDN == null) {
                this.aDN = LayoutInflater.from(viewGroup.getContext());
            }
            return new b(acs.ag(this.aDN, viewGroup, false));
        }

        /* renamed from: a */
        public void onBindViewHolder(b bVar, int i) {
            bVar.b((d) this.cSr.get(i));
        }

        public int getItemCount() {
            return this.cSr.size();
        }
    }

    /* compiled from: OtnEmissionHistoryBottomSheet */
    private final class b extends ViewHolder {
        private acs dcG;

        public b(acs acs) {
            super(acs.getRoot());
            this.dcG = acs;
        }

        private void b(d dVar) {
            this.dcG.aiq.setText(p.this.cgq.format(Long.valueOf(dVar.getTime())));
            this.dcG.bnj.setText(com.iqoption.core.util.p.gX(p.this.crm.format(dVar.asT())));
        }
    }

    protected boolean getSkipCollapsed() {
        return false;
    }

    public static void a(@IdRes int i, FragmentManager fragmentManager) {
        if (fragmentManager.findFragmentByTag("OtnEmissionHistoryBottomSheet") == null) {
            fragmentManager.beginTransaction().add(i, new p(), "OtnEmissionHistoryBottomSheet").addToBackStack(null).commit();
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.dcC = bk.d(layoutInflater, viewGroup, false);
        this.adT = Event.Builder(Event.CATEGORY_POPUP_SERVED, "otn_history");
        this.cgq = bf.cgq;
        this.crm = l.aGc();
        this.dcC.blv.setClickable(true);
        this.dcC.blv.setOnTouchListener(q.ckx);
        this.dcC.blt.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                if (p.this.ajS() == 1.0f) {
                    p.this.onClose();
                }
                EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "otn_history-close").build());
            }
        });
        Adapter aVar = new a(this, null);
        this.adT.setValue(Double.valueOf((double) aVar.getItemCount()));
        this.dcC.blu.setHasFixedSize(true);
        this.dcC.blu.setAdapter(aVar);
        this.dcD = new com.iqoption.view.a.a().a(this.dcC.agA).gK(getResources().getDimensionPixelSize(R.dimen.dp56)).aHZ();
        this.dcE = new com.iqoption.view.a.a().a(this.dcC.blt).j(0.0f, 1.0f).aHZ();
        return this.dcC.getRoot();
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.adT != null) {
            EventManager.Bm().a(this.adT.calcDuration().build());
        }
    }

    protected View aeO() {
        return this.dcC.blv;
    }

    protected View aeP() {
        return this.dcC.blp;
    }

    protected int getPeekHeight() {
        return (int) (((float) getResources().getDisplayMetrics().heightPixels) * 0.5625f);
    }

    protected void G(float f) {
        super.G(f);
        this.dcD.M(au.e(f, 0.0f, 1.0f));
        this.dcE.M(au.e(f, 0.5f, 1.0f));
    }

    protected void eM(int i) {
        super.eM(i);
        if (4 == i) {
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_SCROLL, "otn_history-extend").setValue(Double.valueOf(0.0d)).build());
        } else if (3 == i) {
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_SCROLL, "otn_history-extend").setValue(Double.valueOf(1.0d)).build());
        }
    }
}
