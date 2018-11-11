package com.iqoption.dialog.a;

import android.content.Context;
import android.graphics.PointF;
import android.support.annotation.ColorInt;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.d.hr;
import com.iqoption.d.ht;
import com.iqoption.d.hx;
import com.iqoption.d.id;
import com.iqoption.dto.Point;
import com.iqoption.util.bf;
import com.iqoption.util.bg;
import com.iqoption.util.l;
import com.iqoption.x.R;
import java.util.Iterator;

/* compiled from: OptionComponentFactory */
final class ab implements z {
    private static final Ordering<com.iqoption.mobbtech.connect.response.options.e> cgV = Ordering.from(ai.$instance);
    private am<com.iqoption.dialog.a.a.d> cgW;
    private c cgX;
    private com.iqoption.dialog.a.a.d.a cgY;
    private final boolean cgZ;
    private final am cgc;
    private final am cgd;
    private final a cge;
    private final b cha;
    private final Context context;

    /* compiled from: OptionComponentFactory */
    class a {
        private float chf = 0.0f;
        private float chg = this.chf;
        private float chh = ((float) this.chj.rate);
        private float chi = this.chh;
        final /* synthetic */ Point chj;

        a(Point point) {
            this.chj = point;
        }

        private void b(PointF pointF) {
            if (pointF.x < this.chf) {
                this.chf = pointF.x;
            } else if (pointF.x > this.chg) {
                this.chg = pointF.x;
            }
            if (pointF.y < this.chh) {
                this.chh = pointF.y;
            } else if (pointF.y > this.chi) {
                this.chi = pointF.y;
            }
        }
    }

    /* compiled from: OptionComponentFactory */
    private static final class b {
        final com.iqoption.h.a.a aiI;
        final String cgs = com.iqoption.app.a.Cw().CD();
        @ColorInt
        final int cgv;
        @ColorInt
        final int cgw;
        final String chl;

        b(Context context, int i) {
            this.aiI = new com.iqoption.h.a.a(i);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("%.");
            stringBuilder.append(i);
            stringBuilder.append("f");
            this.chl = stringBuilder.toString();
            this.cgv = ContextCompat.getColor(context, R.color.white);
            this.cgw = ContextCompat.getColor(context, R.color.grey_blur_70);
        }
    }

    /* compiled from: OptionComponentFactory */
    private interface c {
        void b(@NonNull com.iqoption.dialog.a.a.d dVar, @NonNull ImmutableList<Point> immutableList);
    }

    /* compiled from: OptionComponentFactory */
    private static final class d extends Adapter<e> {
        private final b cha;
        private final ImmutableList<? extends com.iqoption.mobbtech.connect.response.options.e> chm;

        d(ImmutableList<? extends com.iqoption.mobbtech.connect.response.options.e> immutableList, b bVar) {
            this.chm = immutableList;
            this.cha = bVar;
        }

        /* renamed from: B */
        public e onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new e(id.v(LayoutInflater.from(viewGroup.getContext()), viewGroup, false), this.cha);
        }

        /* renamed from: a */
        public void onBindViewHolder(e eVar, int i) {
            eVar.m((com.iqoption.mobbtech.connect.response.options.e) this.chm.get(i));
        }

        public int getItemCount() {
            return this.chm.size();
        }
    }

    /* compiled from: OptionComponentFactory */
    private static final class e extends ViewHolder {
        private final b cha;
        private final id chn;

        e(id idVar, b bVar) {
            super(idVar.getRoot());
            this.chn = idVar;
            this.cha = bVar;
        }

        void m(com.iqoption.mobbtech.connect.response.options.e eVar) {
            Double value = eVar.getValue();
            if (value != null) {
                this.chn.brI.setText(this.cha.aiI.format(value.doubleValue()));
            } else {
                this.chn.brI.setText(null);
            }
            if (NotificationCompat.CATEGORY_CALL.equalsIgnoreCase(eVar.getDir())) {
                this.chn.brG.setImageResource(R.drawable.ic_indicator_call_10dp);
            } else {
                this.chn.brG.setImageResource(R.drawable.ic_indicator_put_10dp);
            }
            value = eVar.getInvestSum();
            if (value != null) {
                this.chn.brH.setText(l.e(this.cha.cgs, value));
            } else {
                this.chn.brH.setText(null);
            }
            double winAmount = eVar.getWinAmount();
            this.chn.bnJ.setText(l.e(this.cha.cgs, Double.valueOf(eVar.getWinAmount())));
            if (winAmount > 0.0d) {
                this.chn.bnJ.setTextColor(this.cha.cgv);
            } else {
                this.chn.bnJ.setTextColor(this.cha.cgw);
            }
            CharSequence closeStatus = eVar.getCloseStatus();
            if (closeStatus != null) {
                Object obj = -1;
                int hashCode = closeStatus.hashCode();
                if (hashCode != 117724) {
                    if (hashCode == 103157406 && closeStatus.equals("loose")) {
                        obj = null;
                    }
                } else if (closeStatus.equals("win")) {
                    obj = 1;
                }
                switch (obj) {
                    case null:
                        this.chn.brD.setText(R.string.status_lose);
                        this.chn.brD.setTextColor(this.cha.cgw);
                        return;
                    case 1:
                        this.chn.brD.setText(R.string.status_profit);
                        this.chn.brD.setTextColor(this.cha.cgv);
                        return;
                    default:
                        this.chn.brD.setText(closeStatus);
                        this.chn.brD.setTextColor(this.cha.cgv);
                        return;
                }
            }
            this.chn.brD.setText(null);
        }
    }

    ab(Context context, ImmutableList<com.iqoption.mobbtech.connect.response.options.e> immutableList) {
        this.context = context;
        boolean z = false;
        com.iqoption.mobbtech.connect.response.options.e eVar = (com.iqoption.mobbtech.connect.response.options.e) immutableList.get(0);
        if (eVar.getInstrumentType() == InstrumentType.DIGITAL_INSTRUMENT) {
            z = true;
        }
        this.cgZ = z;
        com.iqoption.core.microservices.tradingengine.response.active.a a = com.iqoption.app.helpers.a.FI().a(Integer.valueOf(eVar.getActiveId()), eVar.getInstrumentType());
        this.cha = new b(context, a != null ? a.getPrecision() : 4);
        this.cgc = new ac(this, a, immutableList, eVar);
        if (this.cgZ) {
            this.cgY = new com.iqoption.dialog.a.a.b.a(context, this.cha.chl);
        } else {
            this.cgY = new com.iqoption.dialog.a.a.a.a(context, this.cha.chl);
        }
        this.cgW = new ad(this, context);
        this.cgX = new ae(this, immutableList);
        this.cgd = new af(this);
        this.cge = new ag(this, immutableList);
    }

    final /* synthetic */ View a(com.iqoption.core.microservices.tradingengine.response.active.a aVar, ImmutableList immutableList, com.iqoption.mobbtech.connect.response.options.e eVar, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        hr p = hr.p(layoutInflater, viewGroup, false);
        if (aVar != null) {
            p.bro.setText(com.iqoption.util.e.a.s(aVar));
        }
        double d = 0.0d;
        Iterator sI = immutableList.iterator();
        while (sI.hasNext()) {
            d += ((com.iqoption.mobbtech.connect.response.options.e) sI.next()).getInvestSum().doubleValue();
        }
        p.bru.setText(l.e(this.cha.cgs, Double.valueOf(d)));
        p.brt.setText(String.valueOf(immutableList.size()));
        p.brs.setText(bf.c(eVar.getExpired().longValue(), 1));
        if (this.cgZ) {
            bg.setDrawableLeft(p.brs, AppCompatResources.getDrawable(context, R.drawable.ic_flag_new));
        }
        return p.getRoot();
    }

    final /* synthetic */ View e(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (this.cgZ) {
            return hx.s(layoutInflater, viewGroup, false).getRoot();
        }
        return ht.q(layoutInflater, viewGroup, false).getRoot();
    }

    @NonNull
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return this.cgc.d(layoutInflater, viewGroup);
    }

    @NonNull
    public View b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return this.cgd.d(layoutInflater, viewGroup);
    }

    @NonNull
    public Adapter aeF() {
        return this.cge.aeE();
    }

    @Nullable
    public com.iqoption.dialog.a.a.d c(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return this.cgW != null ? (com.iqoption.dialog.a.a.d) this.cgW.d(layoutInflater, viewGroup) : null;
    }

    private int ef(@DimenRes int i) {
        return this.context.getResources().getDimensionPixelSize(i);
    }

    public void a(@NonNull com.iqoption.dialog.a.a.d dVar, @NonNull ImmutableList<Point> immutableList) {
        this.cgX.b(dVar, immutableList);
    }
}
