package com.iqoption.a.a;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.o;
import com.iqoption.app.managers.a.k;
import com.iqoption.app.managers.af;
import com.iqoption.app.managers.tab.a.g;
import com.iqoption.dto.entity.expiration.Expiration;
import com.iqoption.view.timer.TimerView;
import com.iqoption.x.R;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* compiled from: CfdExpirationAdapter */
public class a extends Adapter<c> {
    private com.iqoption.a.b.a afB;
    protected ImmutableList<Expiration> aiv = ImmutableList.sL();
    @Nullable
    private RecyclerView aiw;
    private a aix = new a();

    /* compiled from: CfdExpirationAdapter */
    private static class a implements com.iqoption.view.a.b.a {
        private final WeakReference<a> aiy;

        private a(a aVar) {
            this.aiy = new WeakReference(aVar);
        }

        public void onTick(long j) {
            a aVar = (a) this.aiy.get();
            if (aVar != null && aVar.aiv.size() != 0) {
                Iterator sI = aVar.aiv.iterator();
                while (sI.hasNext()) {
                    b(aVar, (Expiration) sI.next());
                }
            }
        }

        private void b(a aVar, Expiration expiration) {
            c a = aVar.P(expiration.getStableId());
            if (a != null) {
                a.i(expiration.expValue.longValue() - af.Hu().Hw(), aVar.a(expiration));
            }
        }
    }

    /* compiled from: CfdExpirationAdapter */
    protected static class c extends ViewHolder implements OnClickListener {
        TextView aiq;
        TimerView aiz;
        com.iqoption.a.b.a listener;

        c(View view, com.iqoption.a.b.a aVar) {
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

        public void i(long j, long j2) {
            if (this.aiz != null) {
                if (this.aiz.getMaxValue() == 0) {
                    this.aiz.setMaxValue(j2);
                }
                this.aiz.cu(j);
            }
        }
    }

    /* compiled from: CfdExpirationAdapter */
    private static class b extends com.iqoption.system.c.b<a, ImmutableList<Expiration>> {
        public b(a aVar) {
            super((Object) aVar);
        }

        /* renamed from: a */
        public void z(a aVar, ImmutableList<Expiration> immutableList) {
            aVar.aiv = immutableList;
            aVar.notifyDataSetChanged();
        }
    }

    public int getItemViewType(int i) {
        return 0;
    }

    public a(com.iqoption.a.b.a aVar) {
        this.afB = aVar;
        setHasStableIds(true);
        dataSetChanged();
    }

    private void a(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        if (aVar != null) {
            o.a(k.HB().h(aVar), new b(this), com.iqoption.core.d.a.aSe);
        }
    }

    public void dataSetChanged() {
        g IC = com.iqoption.app.managers.tab.a.Il().IC();
        if (IC != null) {
            int activeId = IC.getActiveId();
            a(com.iqoption.app.helpers.a.FI().a(Integer.valueOf(activeId), IC.getInstrumentType()));
        }
    }

    public void onStart() {
        notifyDataSetChanged();
        Ba();
    }

    public void onStop() {
        Bb();
    }

    private void Ba() {
        com.iqoption.view.a.b.aIK().a(this.aix);
    }

    private void Bb() {
        com.iqoption.view.a.b.aIK().b(this.aix);
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

    /* renamed from: b */
    public c onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cfd_expiration_item, viewGroup, false), this.afB);
    }

    /* renamed from: a */
    public void onBindViewHolder(c cVar, int i) {
        a(cz(i), cVar);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.aiw = recyclerView;
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.aiw = null;
    }

    @Nullable
    private c P(long j) {
        if (this.aiw == null) {
            return null;
        }
        ViewHolder findViewHolderForItemId = this.aiw.findViewHolderForItemId(j);
        if (findViewHolderForItemId instanceof c) {
            return (c) findViewHolderForItemId;
        }
        return null;
    }

    private void a(Expiration expiration, c cVar) {
        cVar.aiq.setText(expiration.title);
        cVar.i(expiration.expValue.longValue() - af.Hu().Hw(), a(expiration));
        if (expiration.expValue.longValue() == com.iqoption.app.managers.tab.a.Il().IA()) {
            cVar.itemView.setSelected(true);
        } else {
            cVar.itemView.setSelected(false);
        }
    }

    private long a(Expiration expiration) {
        return (this.aiv == null || this.aiv.size() < 2) ? 0 : ((expiration.expValue.longValue() - ((Expiration) this.aiv.get(0)).expValue.longValue()) + ((Expiration) this.aiv.get(1)).expValue.longValue()) - ((Expiration) this.aiv.get(0)).expValue.longValue();
    }
}
