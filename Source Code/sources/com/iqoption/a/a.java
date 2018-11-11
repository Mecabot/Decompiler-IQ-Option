package com.iqoption.a;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.core.data.model.ActiveType;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.util.i;
import com.iqoption.core.util.p;
import com.iqoption.dto.Event;
import com.iqoption.fragment.TabType;
import com.iqoption.fragment.ac;
import com.iqoption.fragment.be;
import com.iqoption.fragment.ck;
import com.iqoption.fragment.rightpanel.ar;
import com.iqoption.util.au;
import com.iqoption.util.bf;
import com.iqoption.util.h;
import com.iqoption.util.q;
import com.iqoption.view.FavoriteVectorSwitchView;
import com.iqoption.x.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* compiled from: AssetAdapter */
public class a extends Adapter implements Filterable {
    private int afA = 1;
    private final com.iqoption.a.b.a afB;
    private ac afC;
    private final d afD = new d() {
        public void a(View view, int i, boolean z) {
            if (i >= 0 && i < a.this.afG.size() && a.this.afG.size() > 0) {
                a aVar = (a) a.this.afG.get(i);
                if (z) {
                    a.this.afE.add(Integer.valueOf(aVar.activeId));
                } else {
                    a.this.afE.remove(Integer.valueOf(aVar.activeId));
                }
                EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "traderoom_add-favorite-asset").setValue(Double.valueOf(z ? 1.0d : 0.0d)).setParameters(i.ZZ().l("active_id", Integer.valueOf(aVar.activeId)).l("instrument_type", aVar.instrumentType).aab()).build());
            }
            a.this.cp(a.this.afA);
        }
    };
    private Set<Integer> afE;
    private ArrayList<a> afF = new ArrayList();
    private ArrayList<a> afG = new ArrayList();
    private Date afH = new Date();
    private String afI = "";
    private final b afJ = new b(this, null);
    private final Ordering<a> afg = new Ordering<a>() {
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            double d = 0.0d;
            double intValue = aVar2.leverage == null ? 0.0d : (double) aVar2.leverage.intValue();
            if (aVar.leverage != null) {
                d = (double) aVar.leverage.intValue();
            }
            return Double.compare(intValue, d);
        }
    };
    private final Ordering<a> afh = new Ordering<a>() {
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            double d = 0.0d;
            double doubleValue = aVar2.afT == null ? 0.0d : aVar2.afT.doubleValue();
            if (aVar.afT != null) {
                d = aVar.afT.doubleValue();
            }
            return Double.compare(doubleValue, d);
        }
    };
    private final Ordering<a> afi = new Ordering<a>() {
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            double d = 0.0d;
            double doubleValue = aVar2.afR == null ? 0.0d : aVar2.afR.doubleValue();
            if (aVar.afR != null) {
                d = aVar.afR.doubleValue();
            }
            return Double.compare(doubleValue, d);
        }
    };
    private final Ordering<a> afj = new Ordering<a>() {
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            double d = 0.0d;
            double doubleValue = aVar2.afS == null ? 0.0d : aVar2.afS.doubleValue();
            if (aVar.afS != null) {
                d = aVar.afS.doubleValue();
            }
            return Double.compare(doubleValue, d);
        }
    };
    private final Ordering<a> afk = new Ordering<a>() {
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return Ints.compare(aVar.commission, aVar2.commission);
        }
    };
    private final Ordering<a> afl = new Ordering<a>() {
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return String.CASE_INSENSITIVE_ORDER.compare(aVar.afO, aVar2.afO);
        }
    };
    private final Ordering<a> afm = new Ordering<a>() {
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return com.google.common.primitives.a.compare(a.this.afE.contains(Integer.valueOf(aVar2.activeId)), a.this.afE.contains(Integer.valueOf(aVar.activeId)));
        }
    };
    private final Ordering<a> afn = new Ordering<a>() {
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return com.google.common.primitives.a.compare(aVar2.isEnabled, aVar.isEnabled);
        }
    };
    private final Ordering<a> afo = this.afm.compound(this.afn).compound(this.afg);
    private final Ordering<a> afp = this.afm.compound(this.afn).compound(this.afg.reverse());
    private final Ordering<a> afq = this.afm.compound(this.afn).compound(this.afh);
    private final Ordering<a> afr = this.afm.compound(this.afn).compound(this.afh.reverse());
    private final Ordering<a> afs = this.afm.compound(this.afn).compound(this.afj);
    private final Ordering<a> aft = this.afm.compound(this.afn).compound(this.afj.reverse());
    private final Ordering<a> afu = this.afm.compound(this.afn).compound(this.afi);
    private final Ordering<a> afv = this.afm.compound(this.afn).compound(this.afi.reverse());
    private final Ordering<a> afw = this.afm.compound(this.afn).compound(this.afk);
    private final Ordering<a> afx = this.afm.compound(this.afn).compound(this.afk.reverse());
    private final Ordering<a> afy = this.afm.compound(this.afn).compound(this.afl);
    private final Ordering<a> afz = this.afm.compound(this.afn).compound(this.afl.reverse());

    /* compiled from: AssetAdapter */
    public static class a {
        public final int activeId;
        public final String afN;
        public final String afO;
        public final long afP;
        public final Double afQ;
        public final Double afR;
        public final Double afS;
        public final Double afT;
        public final int commission;
        public final String image;
        public final InstrumentType instrumentType;
        public final boolean isEnabled;
        public final Integer leverage;
        public final String name;
        public final int precision;
        public final int yield = (100 - this.commission);

        a(com.iqoption.core.microservices.tradingengine.response.active.a aVar, long j, boolean z, String str) {
            this.activeId = aVar.getActiveId();
            this.instrumentType = aVar.getInstrumentType();
            this.image = aVar.getImage();
            this.afN = str;
            this.name = com.iqoption.util.e.a.s(aVar);
            this.afO = com.iqoption.util.e.a.H(aVar);
            this.isEnabled = aVar.ba(j);
            this.afP = aVar.bb(j);
            this.commission = aVar.Xi().intValue();
            this.precision = aVar.getPrecision();
            com.iqoption.app.helpers.a FI = com.iqoption.app.helpers.a.FI();
            com.iqoption.core.microservices.tradingengine.response.b.a a = FI.a(this.instrumentType, this.activeId);
            if (a != null) {
                int[] a2 = ar.a(a.ck(z), this.instrumentType);
                this.leverage = a2.length == 0 ? null : Integer.valueOf(Ints.max(a2));
            } else {
                this.leverage = null;
            }
            com.iqoption.core.microservices.f.a.a.a a3 = FI.a(this.activeId, this.instrumentType);
            if (a3 != null) {
                this.afQ = com.iqoption.core.microservices.f.a.a.a.h(a3.WZ());
                switch (this.instrumentType) {
                    case CFD_INSTRUMENT:
                    case FOREX_INSTRUMENT:
                    case CRYPTO_INSTRUMENT:
                        Double h = com.iqoption.core.microservices.f.a.a.a.h(a3.WW());
                        if (h == null || this.afQ == null) {
                            this.afR = null;
                        } else if (this.leverage == null) {
                            this.afR = au.h(this.afQ, h);
                        } else {
                            this.afR = Double.valueOf(com.iqoption.app.managers.b.d.a(h.doubleValue(), this.afQ.doubleValue(), this.leverage.intValue(), this.instrumentType, this.activeId, this.precision));
                        }
                        this.afS = com.iqoption.core.microservices.f.a.a.a.h(a3.WY());
                        this.afT = com.iqoption.core.microservices.f.a.a.a.h(a3.Xc());
                        return;
                    case FX_INSTRUMENT:
                    case DIGITAL_INSTRUMENT:
                        this.afR = null;
                        this.afT = null;
                        this.afS = com.iqoption.core.microservices.f.a.a.a.h(a3.WY());
                        return;
                    default:
                        this.afR = null;
                        this.afT = null;
                        this.afS = null;
                        return;
                }
            }
            this.afQ = null;
            this.afR = null;
            this.afS = null;
            this.afT = null;
        }
    }

    /* compiled from: AssetAdapter */
    private class b extends Filter {
        /* synthetic */ b(a aVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        private b() {
        }

        protected FilterResults performFiltering(CharSequence charSequence) {
            try {
                Thread.sleep(150);
            } catch (InterruptedException unused) {
                FilterResults filterResults = new FilterResults();
                ArrayList arrayList = new ArrayList();
                if (charSequence.length() == 0) {
                    arrayList.addAll(a.this.afF);
                } else {
                    charSequence = charSequence.toString().toLowerCase().trim();
                    Iterator it = a.this.afF.iterator();
                    while (it.hasNext()) {
                        a aVar = (a) it.next();
                        if (aVar.afO.toLowerCase().trim().contains(charSequence)) {
                            arrayList.add(aVar);
                        }
                    }
                }
                filterResults.values = a.this.e(arrayList);
                filterResults.count = arrayList.size();
                return filterResults;
            }
        }

        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            a.this.afG = (ArrayList) filterResults.values;
            a.this.notifyDataSetChanged();
        }
    }

    /* compiled from: AssetAdapter */
    public interface d {
        void a(View view, int i, boolean z);
    }

    /* compiled from: AssetAdapter */
    private static class c extends ViewHolder implements OnClickListener {
        d afD;
        ImageView afU;
        TextView afV;
        TextView afW;
        View afX;
        View afY;
        TextView afZ;
        View aga;
        View agb;
        ImageView agc;
        FavoriteVectorSwitchView agd;
        com.iqoption.a.b.a listener;

        public void a(a aVar) {
        }

        c(View view, com.iqoption.a.b.a aVar, d dVar) {
            super(view);
            this.listener = aVar;
            this.afD = dVar;
            this.agb = view.findViewById(R.id.itemView);
            this.afU = (ImageView) view.findViewById(R.id.activeIcon);
            this.afV = (TextView) view.findViewById(R.id.activeTitle);
            this.afW = (TextView) view.findViewById(R.id.activeQuote);
            this.afX = view.findViewById(R.id.closedConteiner);
            this.afY = view.findViewById(R.id.paramsContainer);
            this.afZ = (TextView) view.findViewById(R.id.timeValue);
            this.aga = view.findViewById(R.id.timeIcon);
            this.agc = (ImageView) view.findViewById(R.id.flagImage);
            this.agd = (FavoriteVectorSwitchView) view.findViewById(R.id.switcherFavorite);
            this.agd.setOnClickListener(this);
            this.agb.setOnClickListener(this);
        }

        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            if (view.getId() == this.agd.getId()) {
                if (this.afD != null) {
                    this.agd.setSwitched(this.agd.aHX() ^ 1);
                    this.agd.setSelected(this.agd.aHX());
                    this.afD.a(view, adapterPosition, this.agd.aHX());
                }
            } else if (this.listener != null) {
                this.listener.a(view, adapterPosition);
            }
        }
    }

    /* compiled from: AssetAdapter */
    private static class e extends c implements OnClickListener {
        TextView age;
        TextView agf;
        TextView agg;
        private final com.iqoption.util.h.b agh = new com.iqoption.util.h.b() {
            public void f(double d) {
                e.this.agf.setText(p.a(d, "+", 2));
                e.this.agf.setTextColor(ContextCompat.getColor(e.this.agf.getContext(), R.color.green));
            }

            public void g(double d) {
                e.this.agf.setText(p.a(d, "-", 2));
                e.this.agf.setTextColor(ContextCompat.getColor(e.this.agf.getContext(), R.color.red));
            }

            public void h(double d) {
                e.this.agf.setText(p.a(d, "", 2));
            }
        };

        e(View view, com.iqoption.a.b.a aVar, d dVar) {
            super(view, aVar, dVar);
            this.age = (TextView) view.findViewById(R.id.activeSpread);
            this.agf = (TextView) view.findViewById(R.id.activeDiff);
            this.agg = (TextView) view.findViewById(R.id.activeLeverage);
        }

        public void a(a aVar) {
            if (aVar.afR != null) {
                this.age.setText(String.format(Locale.US, "%s%%", new Object[]{q.dY(3).format(aVar.afR)}));
            } else {
                this.age.setText(null);
            }
            if (aVar.afS != null) {
                h.a(aVar.afS.doubleValue(), this.agh);
            } else {
                this.agf.setText(null);
            }
            if (aVar.leverage != null) {
                this.agg.setText(p.ea(aVar.leverage.intValue()));
            } else {
                this.agg.setText(null);
            }
        }
    }

    /* compiled from: AssetAdapter */
    private static class f extends c implements OnClickListener {
        TextView agj;

        f(View view, com.iqoption.a.b.a aVar, d dVar) {
            super(view, aVar, dVar);
            this.agj = (TextView) view.findViewById(R.id.activeYield);
        }

        public void a(a aVar) {
            TextView textView = this.agj;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(aVar.yield);
            stringBuilder.append("%");
            textView.setText(stringBuilder.toString());
        }
    }

    public void AG() {
        af.aR(IQApp.Dk()).f(this.afE);
    }

    public a(com.iqoption.a.b.a aVar) {
        this.afB = aVar;
        this.afE = af.aR(IQApp.Dk()).Ff();
    }

    private List<a> v(Collection<com.iqoption.core.microservices.tradingengine.response.active.a> collection) {
        long Hw = com.iqoption.app.managers.af.Hu().Hw();
        boolean Dh = com.iqoption.app.a.Cw().Dh();
        String tag = this.afC instanceof ck ? ((ck) this.afC).getTag() : null;
        List arrayList = new ArrayList();
        for (com.iqoption.core.microservices.tradingengine.response.active.a aVar : collection) {
            arrayList.add(new a(aVar, Hw, Dh, tag));
        }
        return arrayList;
    }

    private Collection<com.iqoption.core.microservices.tradingengine.response.active.a> a(ac acVar) {
        switch (acVar.aha()) {
            case LOCALE_ASSET_TAB:
                return com.iqoption.app.helpers.a.FI().a(InstrumentType.CFD_INSTRUMENT, ((ck) acVar).getTag());
            case ACTIVE_TAB:
                ActiveType activeType = ((be) acVar).getActiveType();
                switch (activeType) {
                    case TURBO_ACTIVE:
                    case BINARY_ACTIVE:
                        return com.iqoption.app.helpers.a.FI().FN();
                    case BOND_ACTIVE:
                        return com.iqoption.app.helpers.a.FI().a(InstrumentType.CFD_INSTRUMENT, ActiveType.BOND_ACTIVE);
                    case INDEX_ACTIVE:
                        return com.iqoption.app.helpers.a.FI().a(InstrumentType.CFD_INSTRUMENT, ActiveType.INDEX_ACTIVE);
                    case COMMODITY_ACTIVE:
                        return com.iqoption.app.helpers.a.FI().a(InstrumentType.CFD_INSTRUMENT, ActiveType.COMMODITY_ACTIVE);
                    case ETF_ACTIVE:
                        return com.iqoption.app.helpers.a.FI().a(InstrumentType.CFD_INSTRUMENT, ActiveType.ETF_ACTIVE);
                    case STOCK_ACTIVE:
                        return com.iqoption.app.helpers.a.FI().a(InstrumentType.CFD_INSTRUMENT, ActiveType.STOCK_ACTIVE);
                    default:
                        return com.iqoption.app.helpers.a.FI().d(activeType.toInstrumentType());
                }
            default:
                return ImmutableList.sL();
        }
    }

    public void b(ac acVar) {
        if (acVar.aha() != TabType.MORE_TAB) {
            this.afC = acVar;
            this.afF.clear();
            this.afF.addAll(v(a(acVar)));
            this.afG.clear();
            notifyDataSetChanged();
            this.afJ.filter(this.afI);
        }
    }

    public void c(ac acVar) {
        if (acVar.aha() != TabType.MORE_TAB) {
            if (this.afC == null) {
                b(acVar);
            } else {
                this.afF.clear();
                this.afF.addAll(v(a(this.afC)));
                this.afJ.filter(this.afI);
            }
        }
    }

    public int AH() {
        return this.afA;
    }

    public void cp(int i) {
        f(i, true);
    }

    public void f(int i, boolean z) {
        this.afA = i;
        this.afG = e(this.afG);
        if (z) {
            notifyDataSetChanged();
        }
    }

    private ArrayList<a> e(ArrayList<a> arrayList) {
        Comparator comparator;
        switch (this.afA) {
            case 1:
                comparator = this.afy;
                break;
            case 2:
                comparator = this.afz;
                break;
            case 3:
                comparator = this.afw;
                break;
            case 4:
                comparator = this.afx;
                break;
            case 5:
                comparator = this.afs;
                break;
            case 6:
                comparator = this.aft;
                break;
            case 7:
                comparator = this.afu;
                break;
            case 8:
                comparator = this.afv;
                break;
            case 9:
                comparator = this.afq;
                break;
            case 10:
                comparator = this.afr;
                break;
            case 11:
                comparator = this.afo;
                break;
            case 12:
                comparator = this.afp;
                break;
            default:
                comparator = null;
                break;
        }
        Collections.sort(arrayList, comparator);
        return arrayList;
    }

    public long getItemId(int i) {
        a cq = cq(i);
        if (cq == null) {
            return 0;
        }
        return (((long) com.google.common.base.f.hashCode(cq.instrumentType)) << 31) | ((long) cq.activeId);
    }

    public int getItemCount() {
        if (this.afG == null) {
            return 0;
        }
        return AI() ? this.afG.size() + 1 : this.afG.size();
    }

    public final int getItemViewType(int i) {
        if (AI() && i == this.afG.size()) {
            return 3;
        }
        switch (this.afC.aha()) {
            case LOCALE_ASSET_TAB:
                return 1;
            case ACTIVE_TAB:
                switch (((be) this.afC).getActiveType()) {
                    case TURBO_ACTIVE:
                    case BINARY_ACTIVE:
                        return 0;
                    case BOND_ACTIVE:
                    case INDEX_ACTIVE:
                    case COMMODITY_ACTIVE:
                    case ETF_ACTIVE:
                    case STOCK_ACTIVE:
                    case DIGITAL_ACTIVE:
                    case FOREX_ACTIVE:
                    case CRYPTO_ACTIVE:
                    case FX_ACTIVE:
                        return 1;
                }
                break;
        }
        return 2;
    }

    @Nullable
    public a cq(int i) {
        if (i >= this.afG.size()) {
            return null;
        }
        return (a) this.afG.get(i);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 3) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.spread_leverage_notice, viewGroup, false)) {
            };
        }
        switch (i) {
            case 0:
                return new f(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.asset_item, viewGroup, false), this.afB, this.afD);
            case 1:
                return new e(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.spread_asset_item, viewGroup, false), this.afB, this.afD);
            default:
                return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.asset_item, viewGroup, false), this.afB, this.afD);
        }
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        if (!(AI() && i == this.afG.size()) && (viewHolder instanceof c)) {
            c cVar = (c) viewHolder;
            Context context = cVar.itemView.getContext();
            a cq = cq(i);
            if (cq != null) {
                if (!TextUtils.isEmpty(cq.image)) {
                    Picasso.with(context).load(cq.image).into(cVar.afU);
                }
                if (cVar.agc != null) {
                    if (cq.afN != null) {
                        String aA = com.iqoption.core.util.f.bgP.aA(cq.afN);
                        if (TextUtils.isEmpty(aA)) {
                            cVar.agc.setImageDrawable(null);
                        } else {
                            Picasso.with(context).load(aA).into(cVar.agc);
                        }
                    } else {
                        cVar.agc.setImageDrawable(null);
                    }
                }
                cVar.afV.setText(cq.name);
                if (cq.afQ != null) {
                    cVar.afW.setText(q.dY(cq.precision).format(cq.afQ));
                    cVar.afW.setVisibility(0);
                } else {
                    cVar.afW.setVisibility(8);
                }
                long Hw = com.iqoption.app.managers.af.Hu().Hw();
                if (cq.isEnabled) {
                    cVar.a(cq);
                    cVar.afY.setVisibility(0);
                    cVar.afX.setVisibility(8);
                    cVar.itemView.setAlpha(1.0f);
                } else {
                    if (cq.afP == Long.MAX_VALUE) {
                        cVar.afZ.setVisibility(8);
                        cVar.aga.setVisibility(8);
                    } else {
                        cVar.afZ.setText(a(context, cq.afP, Hw));
                        cVar.afZ.setVisibility(0);
                        cVar.aga.setVisibility(0);
                    }
                    cVar.afY.setVisibility(8);
                    cVar.afX.setVisibility(0);
                    cVar.itemView.setAlpha(0.7f);
                }
                boolean contains = this.afE.contains(Integer.valueOf(cq.activeId));
                cVar.agd.setSelected(contains);
                cVar.agd.setSwitched(contains);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("asset adapter = ");
                stringBuilder.append(this.afE.contains(Integer.valueOf(cq.activeId)));
                stringBuilder.append(cq.afO);
                com.iqoption.core.i.d(stringBuilder.toString());
            }
        }
    }

    public String a(Context context, long j, long j2) {
        if (j == Long.MAX_VALUE) {
            return context.getString(R.string.n_a);
        }
        this.afH.setTime(j);
        return bf.t(j2, j);
    }

    private boolean AI() {
        boolean z = false;
        if (this.afC == null) {
            return false;
        }
        switch (this.afC.aha()) {
            case LOCALE_ASSET_TAB:
                if (!(this.afG == null || this.afG.isEmpty())) {
                    z = true;
                }
                return z;
            case ACTIVE_TAB:
                switch (((be) this.afC).getInstrumentType()) {
                    case CFD_INSTRUMENT:
                    case FOREX_INSTRUMENT:
                    case CRYPTO_INSTRUMENT:
                        if (!(this.afG == null || this.afG.isEmpty())) {
                            z = true;
                        }
                        return z;
                    default:
                        return false;
                }
            default:
                return false;
        }
    }

    public void dS(String str) {
        this.afI = str;
        this.afJ.filter(this.afI);
    }

    public Filter getFilter() {
        return this.afJ;
    }
}
