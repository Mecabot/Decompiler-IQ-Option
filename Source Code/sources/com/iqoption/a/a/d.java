package com.iqoption.a.a;

import android.databinding.DataBindingUtil;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.o;
import com.iqoption.app.IQApp;
import com.iqoption.app.managers.a.e;
import com.iqoption.app.managers.a.k;
import com.iqoption.app.managers.tab.a.g;
import com.iqoption.app.managers.y;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.util.p;
import com.iqoption.d.ajs;
import com.iqoption.d.vf;
import com.iqoption.dto.entity.strike.Quote;
import com.iqoption.dto.entity.strike.Strike;
import com.iqoption.util.l;
import com.iqoption.x.R;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: StrikeAdapter */
public class d extends Adapter<ViewHolder> {
    private final com.iqoption.a.b.a afB;
    @ColorInt
    private final int ahi;
    @ColorInt
    private final int aiG;
    private final b aiH;
    private com.iqoption.h.a.a aiI;
    private com.iqoption.core.microservices.tradingengine.response.active.a aiJ;
    private ImmutableList<Strike> aiK = ImmutableList.sL();
    private InstrumentType instrumentType;

    /* compiled from: StrikeAdapter */
    public interface b {
        void Bc();
    }

    /* compiled from: StrikeAdapter */
    public class a extends ViewHolder implements OnClickListener {
        final vf aiL;
        final com.iqoption.a.b.a listener;

        a(vf vfVar, com.iqoption.a.b.a aVar) {
            super(vfVar.getRoot());
            this.aiL = vfVar;
            this.itemView.setOnClickListener(this);
            this.listener = aVar;
        }

        void b(Strike strike) {
            String format = d.this.aiI.format(strike.getValue().doubleValue());
            CharSequence spannableString = new SpannableString(format);
            spannableString.setSpan(new ForegroundColorSpan(d.this.aiG), 0, format.length() - 3, 33);
            spannableString.setSpan(new ForegroundColorSpan(d.this.ahi), format.length() - 3, format.length(), 33);
            this.aiL.bHQ.setText(spannableString);
            Quote c = com.iqoption.app.managers.c.Gn().c(strike.call.id, strike.optionType);
            if (!strike.call.isEnabled.booleanValue() || c == null || c.askPrice == null) {
                this.aiL.bHO.setVisibility(4);
                this.aiL.bHO.setText("");
            } else {
                this.aiL.bHO.setVisibility(0);
                this.aiL.bHO.setText(d.this.aiI.format(c.askPrice.doubleValue()));
            }
            c = com.iqoption.app.managers.c.Gn().c(strike.put.id, strike.optionType);
            if (!strike.put.isEnabled.booleanValue() || c == null || c.askPrice == null) {
                this.aiL.bHP.setVisibility(4);
                this.aiL.bHP.setText("");
            } else {
                this.aiL.bHP.setVisibility(0);
                this.aiL.bHP.setText(d.this.aiI.format(c.askPrice.doubleValue()));
            }
            Strike Ix = com.iqoption.app.managers.tab.a.Il().Ix();
            if (Ix == null || !strike.equals(Ix)) {
                this.itemView.setSelected(false);
            } else {
                this.itemView.setSelected(true);
            }
        }

        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            if (this.listener != null) {
                this.listener.a(view, adapterPosition);
            }
        }
    }

    /* compiled from: StrikeAdapter */
    public static class d extends ViewHolder implements OnClickListener {
        final ajs aiN;
        final com.iqoption.a.b.a listener;

        d(ajs ajs, com.iqoption.a.b.a aVar) {
            super(ajs.getRoot());
            this.aiN = ajs;
            this.itemView.setOnClickListener(this);
            this.listener = aVar;
        }

        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            if (this.listener != null) {
                this.listener.a(view, adapterPosition);
            }
        }
    }

    /* compiled from: StrikeAdapter */
    private static class c extends com.iqoption.system.c.b<d, ConcurrentHashMap<String, Strike>> {
        public c(d dVar) {
            super((Object) dVar);
        }

        /* renamed from: a */
        public void z(d dVar, ConcurrentHashMap<String, Strike> concurrentHashMap) {
            Collection f = Sets.f(Strike.ORDERING.reverse());
            f.addAll(concurrentHashMap.values());
            dVar.aiK = ImmutableList.m(f);
            dVar.notifyDataSetChanged();
            dVar.aiH.Bc();
        }

        public void l(Throwable th) {
            super.l(th);
        }
    }

    public d(com.iqoption.a.b.a aVar, b bVar) {
        this.afB = aVar;
        this.aiH = bVar;
        this.aiJ = com.iqoption.app.managers.tab.a.Il().Iw();
        this.aiG = ContextCompat.getColor(IQApp.Dk(), R.color.grey_blur_70);
        this.ahi = ContextCompat.getColor(IQApp.Dk(), R.color.white_70);
        this.aiI = new com.iqoption.h.a.a(this.aiJ == null ? 6 : this.aiJ.getPrecision());
        setHasStableIds(true);
    }

    public void dataSetChanged() {
        g IC = com.iqoption.app.managers.tab.a.Il().IC();
        this.aiJ = com.iqoption.app.managers.tab.a.Il().Iw();
        if (this.aiJ != null && IC != null) {
            this.aiK = ImmutableList.sL();
            this.instrumentType = this.aiJ.getInstrumentType();
            cB(this.aiJ.getPrecision());
            notifyDataSetChanged();
            e n = k.HB().n(this.instrumentType);
            if (n != null) {
                o.a(n.a(Integer.valueOf(this.aiJ.getActiveId()), this.aiJ.getInstrumentType(), this.aiJ.Xf(), Long.valueOf(IC.getExpiration()), Long.valueOf(IC.IQ()), false), new c(this), com.iqoption.core.d.a.aSe);
            }
        }
    }

    private void cB(int i) {
        this.aiI.gC(i);
    }

    public int a(Strike strike) {
        if (!(this.aiK == null || strike == null)) {
            int i = 0;
            Iterator sI = this.aiK.iterator();
            while (sI.hasNext()) {
                if (((Strike) sI.next()).equals(strike)) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    public void onStart() {
        if (this.aiJ == null) {
            this.aiJ = com.iqoption.app.managers.tab.a.Il().Iw();
        }
        if (this.aiJ != null) {
            y.a(true, this.aiJ.getActiveId(), this.aiJ.Xf(), this.aiJ.getInstrumentType());
        }
    }

    public void onStop() {
        if (this.aiJ != null) {
            y.a(false, this.aiJ.getActiveId(), this.aiJ.Xf(), this.aiJ.getInstrumentType());
        }
    }

    public int getItemCount() {
        return this.aiK.size();
    }

    public long getItemId(int i) {
        return cC(i).getStableId();
    }

    public Strike cC(int i) {
        return (Strike) this.aiK.get(i);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.instrumentType == InstrumentType.FX_INSTRUMENT) {
            return new a((vf) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.fx_strike_item, viewGroup, false), this.afB);
        }
        return new d((ajs) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.strike_item, viewGroup, false), this.afB);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Strike cC = cC(i);
        if (this.instrumentType == InstrumentType.FX_INSTRUMENT) {
            ((a) viewHolder).b(cC);
        } else {
            a(cC, (d) viewHolder);
        }
    }

    private void a(Strike strike, d dVar) {
        String format = this.aiI.format(strike.getValue().doubleValue());
        CharSequence spannableString = new SpannableString(format);
        spannableString.setSpan(new ForegroundColorSpan(this.aiG), 0, format.length() - 3, 33);
        spannableString.setSpan(new ForegroundColorSpan(this.ahi), format.length() - 3, format.length(), 33);
        dVar.aiN.bHQ.setText(spannableString);
        format = l.CD();
        Double aGa = l.aGa();
        Quote c = com.iqoption.app.managers.c.Gn().c(strike.call.id, strike.optionType);
        if (!strike.call.isEnabled.booleanValue() || c == null || c.askPrice == null) {
            dVar.aiN.bHO.setVisibility(4);
            dVar.aiN.bHO.setText("");
            dVar.aiN.bTA.setText("");
        } else {
            dVar.aiN.bHO.setVisibility(0);
            dVar.aiN.bTA.setText(l.a(aGa, format, c.askPrice));
            dVar.aiN.bHO.setText(p.o((double) c.getProfitPercent()));
        }
        c = com.iqoption.app.managers.c.Gn().c(strike.put.id, strike.optionType);
        if (!strike.put.isEnabled.booleanValue() || c == null || c.askPrice == null) {
            dVar.aiN.bHP.setVisibility(4);
            dVar.aiN.bHP.setText("");
            dVar.aiN.bTB.setText("");
        } else {
            dVar.aiN.bHP.setVisibility(0);
            dVar.aiN.bTB.setText(l.a(aGa, format, c.askPrice));
            dVar.aiN.bHP.setText(p.o((double) c.getProfitPercent()));
        }
        Strike Ix = com.iqoption.app.managers.tab.a.Il().Ix();
        if (Ix == null || !strike.equals(Ix)) {
            dVar.itemView.setSelected(false);
        } else {
            dVar.itemView.setSelected(true);
        }
    }
}
