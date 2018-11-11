package com.iqoption.a.a;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.managers.af;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.util.i;
import com.iqoption.dto.Event;
import com.iqoption.dto.entity.expiration.Expiration;
import com.iqoption.view.timer.TimerView;
import com.iqoption.x.R;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;

/* compiled from: ExpirationAdapter */
public class c extends Adapter<ViewHolder> {
    private com.iqoption.a.b.a afB;
    private Set<Long> aiB = Sets.uI();
    private final long aiC;
    private a aiD = new a();
    private ImmutableList<Expiration> aiv = ImmutableList.sL();
    @Nullable
    private RecyclerView aiw;
    private final InstrumentType instrumentType;
    private Interpolator oR = com.iqoption.view.a.a.d.dEM;

    /* compiled from: ExpirationAdapter */
    private static class a implements com.iqoption.view.a.b.a {
        private final WeakReference<c> aiy;

        private a(c cVar) {
            this.aiy = new WeakReference(cVar);
        }

        public void onTick(long j) {
            c cVar = (c) this.aiy.get();
            if (cVar != null && cVar.aiv.size() != 0) {
                Iterator sI = cVar.aiv.iterator();
                while (sI.hasNext()) {
                    Expiration expiration = (Expiration) sI.next();
                    if (!expiration.isSpecial) {
                        if (expiration.expirationsInGroup != null) {
                            for (Expiration b : expiration.expirationsInGroup) {
                                b(cVar, b);
                            }
                        } else {
                            b(cVar, expiration);
                        }
                    }
                }
            }
        }

        private void b(c cVar, Expiration expiration) {
            b a = cVar.Q(expiration.getStableId());
            if (a != null) {
                long longValue = expiration.expValue.longValue() - af.Hu().Hw();
                if (longValue <= cVar.aiC) {
                    a.reset();
                    cVar.dataSetChanged();
                } else {
                    a.i(longValue, cVar.a(expiration));
                }
            }
        }
    }

    /* compiled from: ExpirationAdapter */
    private static class b extends ViewHolder implements OnClickListener {
        TextView aiq;
        TimerView aiz;
        com.iqoption.a.b.a listener;

        b(View view, com.iqoption.a.b.a aVar) {
            super(view);
            this.aiz = (TimerView) view.findViewById(R.id.timerView);
            this.aiq = (TextView) view.findViewById(R.id.time);
            this.itemView.setOnClickListener(this);
            this.listener = aVar;
        }

        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            if (this.listener != null) {
                this.listener.a(view, adapterPosition);
            }
        }

        public void reset() {
            if (this.aiz != null) {
                this.aiz.reset();
            }
        }

        public void i(long j, long j2) {
            if (this.aiz != null) {
                if (this.aiz.getMaxValue() == 0) {
                    this.aiz.setMaxValue(j2);
                }
                this.aiz.cu(j);
            }
        }
    }

    /* compiled from: ExpirationAdapter */
    private static class c extends ViewHolder implements OnClickListener {
        View aiE;
        TextView aig;
        com.iqoption.a.b.a listener;

        c(View view, com.iqoption.a.b.a aVar) {
            super(view);
            this.aig = (TextView) view.findViewById(R.id.name);
            this.aiE = view.findViewById(R.id.arrow);
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

    /* compiled from: ExpirationAdapter */
    private static class d extends ViewHolder implements OnClickListener {
        TextView aiF;
        TextView aig;
        com.iqoption.a.b.a listener;

        d(View view, com.iqoption.a.b.a aVar) {
            super(view);
            this.aiF = (TextView) view.findViewById(R.id.date);
            this.aig = (TextView) view.findViewById(R.id.name);
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

    public c(InstrumentType instrumentType, long j, com.iqoption.a.b.a aVar) {
        this.instrumentType = instrumentType;
        this.aiC = j;
        a(com.iqoption.app.helpers.a.FI().a(Integer.valueOf(com.iqoption.app.managers.tab.a.Il().It()), this.instrumentType));
        if (this.instrumentType != InstrumentType.TURBO_INSTRUMENT) {
            long IA = com.iqoption.app.managers.tab.a.Il().IA();
            Iterator sI = this.aiv.iterator();
            while (sI.hasNext()) {
                Expiration expiration = (Expiration) sI.next();
                if (expiration.expirationsInGroup != null) {
                    for (Expiration expiration2 : expiration.expirationsInGroup) {
                        if (expiration2.expValue.equals(Long.valueOf(IA))) {
                            this.aiB.add(Long.valueOf(expiration.getStableId()));
                            break;
                        }
                    }
                }
            }
        }
        this.afB = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0016 A:{RETURN, Splitter: B:1:0x0002, ExcHandler: java.lang.InterruptedException (unused java.lang.InterruptedException)} */
    /* JADX WARNING: Missing block: B:3:0x0016, code:
            return;
     */
    private void a(com.iqoption.core.microservices.tradingengine.response.active.a r2) {
        /*
        r1 = this;
        if (r2 == 0) goto L_0x0016;
    L_0x0002:
        r0 = com.iqoption.app.managers.a.k.HB();	 Catch:{ InterruptedException -> 0x0016, InterruptedException -> 0x0016 }
        r2 = r0.h(r2);	 Catch:{ InterruptedException -> 0x0016, InterruptedException -> 0x0016 }
        r2 = r2.get();	 Catch:{ InterruptedException -> 0x0016, InterruptedException -> 0x0016 }
        r2 = (java.util.Collection) r2;	 Catch:{ InterruptedException -> 0x0016, InterruptedException -> 0x0016 }
        r2 = com.google.common.collect.ImmutableList.m(r2);	 Catch:{ InterruptedException -> 0x0016, InterruptedException -> 0x0016 }
        r1.aiv = r2;	 Catch:{ InterruptedException -> 0x0016, InterruptedException -> 0x0016 }
    L_0x0016:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.a.a.c.a(com.iqoption.core.microservices.tradingengine.response.active.a):void");
    }

    public void dataSetChanged() {
        a(com.iqoption.app.helpers.a.FI().a(Integer.valueOf(com.iqoption.app.managers.tab.a.Il().It()), this.instrumentType));
        notifyDataSetChanged();
    }

    public void b(Expiration expiration) {
        double d;
        long stableId = expiration.getStableId();
        if (this.aiB.contains(Long.valueOf(stableId))) {
            this.aiB.remove(Long.valueOf(stableId));
            d = 0.0d;
        } else {
            this.aiB.add(Long.valueOf(stableId));
            d = 1.0d;
        }
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "expiration-time_open-set").setValue(Double.valueOf(d)).setParameters(i.ZZ().l("line_type", expiration.title).l("instrument_type", com.iqoption.app.managers.tab.a.Il().Iv()).aab()).build());
        notifyDataSetChanged();
    }

    public int getItemCount() {
        int size = this.aiv.size();
        Iterator sI = this.aiv.iterator();
        while (sI.hasNext()) {
            Expiration expiration = (Expiration) sI.next();
            if (expiration.expirationsInGroup != null && this.aiB.contains(Long.valueOf(expiration.getStableId()))) {
                size += expiration.expirationsInGroup.size();
            }
        }
        return size;
    }

    public int getItemViewType(int i) {
        Expiration cz = cz(i);
        if (cz.expirationsInGroup != null) {
            return 3;
        }
        return cz.isSpecial ? 2 : 1;
    }

    public long getItemId(int i) {
        return cz(i).getStableId();
    }

    public Expiration cz(int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < this.aiv.size(); i3++) {
            Expiration expiration = (Expiration) this.aiv.get(i3);
            if (i2 == i) {
                return expiration;
            }
            if (!this.aiB.contains(Long.valueOf(expiration.getStableId()))) {
                i2++;
            } else if (expiration.expirationsInGroup == null) {
                i2++;
            } else if (expiration.expirationsInGroup.size() + i2 >= i) {
                return (Expiration) expiration.expirationsInGroup.get((i - i2) - 1);
            } else {
                i2 += expiration.expirationsInGroup.size() + 1;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("item not found for pos ");
        stringBuilder.append(i);
        stringBuilder.append(" of ");
        stringBuilder.append(getItemCount());
        throw new RuntimeException(stringBuilder.toString());
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 2) {
            return new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.special_expiration_item, viewGroup, false), this.afB);
        }
        if (i == 3) {
            return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.group_expiration_item, viewGroup, false), this.afB);
        }
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.default_expiration_item, viewGroup, false), this.afB);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Expiration cz = cz(i);
        switch (getItemViewType(i)) {
            case 1:
                a(cz, (b) viewHolder);
                return;
            case 2:
                a(cz, (d) viewHolder);
                return;
            case 3:
                a(cz, (c) viewHolder);
                return;
            default:
                return;
        }
    }

    private void a(Expiration expiration, b bVar) {
        bVar.aiq.setText(expiration.title);
        bVar.i(expiration.expValue.longValue() - af.Hu().Hw(), a(expiration));
        if (expiration.expValue.longValue() == com.iqoption.app.managers.tab.a.Il().IA() && com.iqoption.app.managers.tab.a.Il().Iv().equals(this.instrumentType)) {
            bVar.itemView.setSelected(true);
        } else {
            bVar.itemView.setSelected(false);
        }
    }

    private void a(Expiration expiration, d dVar) {
        dVar.aig.setText(expiration.title);
        dVar.aiF.setText(expiration.date);
        if (expiration.expValue.longValue() == com.iqoption.app.managers.tab.a.Il().IA() && com.iqoption.app.managers.tab.a.Il().Iv().equals(this.instrumentType)) {
            dVar.itemView.setSelected(true);
        } else {
            dVar.itemView.setSelected(false);
        }
        dVar.aig.setSelected(false);
    }

    private void a(Expiration expiration, c cVar) {
        cVar.aig.setText(expiration.title);
        if (this.aiB.contains(Long.valueOf(expiration.getStableId()))) {
            cVar.itemView.setSelected(true);
            cVar.aiE.animate().rotation(270.0f).setInterpolator(this.oR).start();
            return;
        }
        cVar.itemView.setSelected(false);
        cVar.aiE.animate().rotation(90.0f).setInterpolator(this.oR).start();
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.aiw = recyclerView;
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.aiw = null;
    }

    public void onStart() {
        notifyDataSetChanged();
        Ba();
    }

    public void onStop() {
        Bb();
    }

    private void Ba() {
        com.iqoption.view.a.b.aIK().a(this.aiD);
    }

    private void Bb() {
        com.iqoption.view.a.b.aIK().b(this.aiD);
    }

    private long a(Expiration expiration) {
        return (this.aiv == null || this.aiv.size() == 0) ? 0 : ((expiration.expValue.longValue() - ((Expiration) this.aiv.get(0)).expValue.longValue()) + expiration.expInterval.longValue()) + this.aiC;
    }

    @Nullable
    private b Q(long j) {
        if (this.aiw == null) {
            return null;
        }
        ViewHolder findViewHolderForItemId = this.aiw.findViewHolderForItemId(j);
        if (findViewHolderForItemId instanceof b) {
            return (b) findViewHolderForItemId;
        }
        return null;
    }
}
