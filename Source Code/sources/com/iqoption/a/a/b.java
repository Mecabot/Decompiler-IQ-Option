package com.iqoption.a.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.o;
import com.iqoption.app.managers.a.e;
import com.iqoption.app.managers.a.k;
import com.iqoption.app.managers.tab.a.g;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.dto.entity.expiration.Expiration;
import com.iqoption.util.bf;
import com.iqoption.x.R;

/* compiled from: DigitalExpirationAdapter */
public class b extends Adapter<c> implements com.iqoption.view.stickyheadersrecyclerview.c<b> {
    private com.iqoption.a.b.a afB;
    private ImmutableList<Expiration> aiv = ImmutableList.sL();

    /* compiled from: DigitalExpirationAdapter */
    static class b extends ViewHolder {
        public TextView aiA;

        b(View view) {
            super(view);
            this.aiA = (TextView) view;
        }
    }

    /* compiled from: DigitalExpirationAdapter */
    static class c extends ViewHolder implements OnClickListener {
        TextView aiq;
        com.iqoption.a.b.a listener;

        c(View view, com.iqoption.a.b.a aVar) {
            super(view);
            this.aiq = (TextView) view;
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

    /* compiled from: DigitalExpirationAdapter */
    private static class a extends com.iqoption.system.c.b<b, ImmutableList<Expiration>> {
        public a(b bVar) {
            super((Object) bVar);
        }

        /* renamed from: b */
        public void z(b bVar, ImmutableList<Expiration> immutableList) {
            bVar.aiv = immutableList;
            bVar.notifyDataSetChanged();
        }
    }

    public int aK(Context context) {
        return 0;
    }

    public int getItemViewType(int i) {
        return 0;
    }

    public b(com.iqoption.a.b.a aVar) {
        this.afB = aVar;
        setHasStableIds(true);
        com.iqoption.core.microservices.tradingengine.response.active.a Iw = com.iqoption.app.managers.tab.a.Il().Iw();
        if (Iw != null) {
            o.a(k.HB().h(Iw), new a(this), com.iqoption.core.d.a.aSe);
        }
    }

    private void a(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        if (aVar != null) {
            e n = k.HB().n(aVar.getInstrumentType());
            if (n != null) {
                this.aiv = n.n(aVar);
                notifyDataSetChanged();
            }
        }
    }

    public void dataSetChanged() {
        com.iqoption.core.microservices.tradingengine.response.active.a Iw = com.iqoption.app.managers.tab.a.Il().Iw();
        if (Iw != null) {
            a(com.iqoption.app.helpers.a.FI().a(Integer.valueOf(Iw.getActiveId()), Iw.getInstrumentType()));
        }
    }

    public int getItemCount() {
        return this.aiv.size();
    }

    public long getItemId(int i) {
        return cz(i).getStableId();
    }

    public Expiration cz(int i) {
        return (Expiration) this.aiv.get(i);
    }

    /* renamed from: c */
    public c onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.digital_expiration_item, viewGroup, false), this.afB);
    }

    /* renamed from: a */
    public void onBindViewHolder(c cVar, int i) {
        a(cz(i), cVar);
    }

    private void a(Expiration expiration, c cVar) {
        cVar.aiq.setText(expiration.title);
        g IC = com.iqoption.app.managers.tab.a.Il().IC();
        if (IC != null && expiration.expValue.longValue() == IC.getExpiration() && expiration.getDigitalExpirationPeriod() == IC.IQ()) {
            if (com.iqoption.core.ext.c.b(IC.getInstrumentType(), InstrumentType.DIGITAL_INSTRUMENT, InstrumentType.FX_INSTRUMENT)) {
                cVar.itemView.setSelected(true);
                return;
            }
        }
        cVar.itemView.setSelected(false);
    }

    public long cA(int i) {
        return (long) cz(i).expInterval.hashCode();
    }

    /* renamed from: b */
    public b c(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.header_digital_item, viewGroup, false));
    }

    public void a(b bVar, int i) {
        bVar.aiA.setText(bf.e(bVar.aiA.getContext(), cz(i).getDigitalExpirationPeriod()));
    }
}
