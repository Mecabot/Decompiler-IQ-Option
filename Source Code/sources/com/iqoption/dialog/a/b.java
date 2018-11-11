package com.iqoption.dialog.a;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.collect.ImmutableList;
import com.iqoption.core.util.p;
import com.iqoption.d.hp;
import com.iqoption.d.hv;
import com.iqoption.d.hz;
import com.iqoption.d.ib;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.util.l;
import com.iqoption.util.q;
import com.iqoption.x.R;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: CfdComponentFactory */
final class b implements z {
    private final am cgc;
    private final am cgd;
    private final a cge;

    /* compiled from: CfdComponentFactory */
    private static final class c {
        final DecimalFormat cgp;
        final DateFormat cgq = new SimpleDateFormat("dd/MM, HH:mm", Locale.getDefault());
        final DateFormat cgr = new SimpleDateFormat("HH:mm", Locale.getDefault());
        final String cgs = com.iqoption.app.a.Cw().CD();
        @ColorInt
        final int cgt;
        @ColorInt
        final int cgu;
        @ColorInt
        final int cgv;
        @ColorInt
        final int cgw;

        c(Context context, int i) {
            this.cgp = q.I("0", i);
            this.cgt = ContextCompat.getColor(context, R.color.green);
            this.cgu = ContextCompat.getColor(context, R.color.red);
            this.cgv = ContextCompat.getColor(context, R.color.white);
            this.cgw = ContextCompat.getColor(context, R.color.grey_blur_70);
        }
    }

    /* compiled from: CfdComponentFactory */
    private static final class d extends Adapter<e> {
        private final an<e> cgx;
        private final ImmutableList<Position> cgy;

        d(an<e> anVar, ImmutableList<Position> immutableList) {
            this.cgx = anVar;
            this.cgy = immutableList;
        }

        /* renamed from: A */
        public e onCreateViewHolder(ViewGroup viewGroup, int i) {
            return (e) this.cgx.z(viewGroup, i);
        }

        /* renamed from: a */
        public void onBindViewHolder(e eVar, int i) {
            eVar.j((Position) this.cgy.get(i));
        }

        public int getItemCount() {
            return this.cgy.size();
        }
    }

    /* compiled from: CfdComponentFactory */
    private static abstract class e extends ViewHolder {
        final c cgz;

        abstract void j(Position position);

        e(View view, c cVar) {
            super(view);
            this.cgz = cVar;
        }

        static boolean l(long j, long j2) {
            return j / 86400000 == j2 / 86400000;
        }
    }

    /* compiled from: CfdComponentFactory */
    private static class a extends e {
        private final hz cgm;
        private final String cgn;

        a(hz hzVar, c cVar) {
            super(hzVar.getRoot(), cVar);
            this.cgm = hzVar;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(hzVar.getRoot().getResources().getString(R.string.mult).toLowerCase());
            stringBuilder.append(" %s");
            this.cgn = stringBuilder.toString();
        }

        void j(Position position) {
            Double openPriceEnrolled = position.getOpenPriceEnrolled();
            if (openPriceEnrolled != null) {
                this.cgm.brB.setText(this.cgz.cgp.format(openPriceEnrolled));
            } else {
                this.cgm.brB.setText(null);
            }
            openPriceEnrolled = position.getClosePriceEnrolled();
            if (openPriceEnrolled != null) {
                this.cgm.brw.setText(this.cgz.cgp.format(openPriceEnrolled));
            } else {
                this.cgm.brw.setText(null);
            }
            if (Position.isLong(position)) {
                this.cgm.brA.setImageResource(R.drawable.ic_indicator_call_10dp);
            } else {
                this.cgm.brA.setImageResource(R.drawable.ic_indicator_put_10dp);
            }
            long createTime = position.getCreateTime();
            long closeTime = position.getCloseTime();
            DateFormat dateFormat = e.l(createTime, closeTime) ? this.cgz.cgr : this.cgz.cgq;
            this.cgm.brC.setText(dateFormat.format(new Date(createTime)));
            this.cgm.brx.setText(dateFormat.format(new Date(closeTime)));
            this.cgm.bry.setText(String.format(this.cgn, new Object[]{p.ea(position.getLeverage()).toUpperCase()}));
            double doubleValue = position.getCloseInvestSum().doubleValue();
            this.cgm.brp.setText(l.e(this.cgz.cgs, Double.valueOf(doubleValue)));
            double sellPnl = position.getSellPnl();
            doubleValue = (sellPnl / doubleValue) * 100.0d;
            if (sellPnl > 0.0d) {
                this.cgm.bnP.setText(p.gX(l.e(this.cgz.cgs, Double.valueOf(sellPnl))));
                this.cgm.bnP.setTextColor(this.cgz.cgt);
                this.cgm.brz.setText(p.b(Double.valueOf(doubleValue)));
                this.cgm.brz.setTextColor(this.cgz.cgt);
            } else if (sellPnl < 0.0d) {
                this.cgm.bnP.setText(p.gY(l.e(this.cgz.cgs, Double.valueOf(Math.abs(sellPnl)))));
                this.cgm.bnP.setTextColor(this.cgz.cgu);
                this.cgm.brz.setText(p.c(Double.valueOf(Math.abs(doubleValue))));
                this.cgm.brz.setTextColor(this.cgz.cgu);
            } else {
                this.cgm.bnP.setText(l.e(this.cgz.cgs, Double.valueOf(0.0d)));
                this.cgm.bnP.setTextColor(this.cgz.cgv);
                this.cgm.brz.setText(p.o(0.0d));
                this.cgm.brz.setTextColor(this.cgz.cgv);
            }
            CharSequence win = position.getWin();
            if (win != null) {
                Object obj = -1;
                int hashCode = win.hashCode();
                if (hashCode != 117724) {
                    if (hashCode == 103157406 && win.equals("loose")) {
                        obj = null;
                    }
                } else if (win.equals("win")) {
                    obj = 1;
                }
                switch (obj) {
                    case null:
                        this.cgm.brD.setText(R.string.status_lose);
                        this.cgm.brD.setTextColor(this.cgz.cgw);
                        return;
                    case 1:
                        this.cgm.brD.setText(R.string.status_profit);
                        this.cgm.brD.setTextColor(this.cgz.cgv);
                        return;
                    default:
                        this.cgm.brD.setText(win);
                        this.cgm.brD.setTextColor(this.cgz.cgv);
                        return;
                }
            }
            this.cgm.brD.setText(null);
        }
    }

    /* compiled from: CfdComponentFactory */
    private static final class b extends e {
        private final ib cgo;

        b(ib ibVar, c cVar) {
            super(ibVar.getRoot(), cVar);
            this.cgo = ibVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:37:0x0125  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x014e  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0138  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0125  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x014e  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0138  */
        void j(com.iqoption.dto.entity.position.Position r9) {
            /*
            r8 = this;
            r0 = r9.getOpenPriceEnrolled();
            r1 = 0;
            if (r0 == 0) goto L_0x0017;
        L_0x0007:
            r2 = r8.cgo;
            r2 = r2.brB;
            r3 = r8.cgz;
            r3 = r3.cgp;
            r0 = r3.format(r0);
            r2.setText(r0);
            goto L_0x001e;
        L_0x0017:
            r0 = r8.cgo;
            r0 = r0.brB;
            r0.setText(r1);
        L_0x001e:
            r0 = r9.getClosePriceEnrolled();
            if (r0 == 0) goto L_0x0034;
        L_0x0024:
            r2 = r8.cgo;
            r2 = r2.brw;
            r3 = r8.cgz;
            r3 = r3.cgp;
            r0 = r3.format(r0);
            r2.setText(r0);
            goto L_0x003b;
        L_0x0034:
            r0 = r8.cgo;
            r0 = r0.brw;
            r0.setText(r1);
        L_0x003b:
            r0 = com.iqoption.dto.entity.position.Position.isLong(r9);
            if (r0 == 0) goto L_0x004c;
        L_0x0041:
            r0 = r8.cgo;
            r0 = r0.brA;
            r2 = 2131231806; // 0x7f08043e float:1.8079703E38 double:1.0529684187E-314;
            r0.setImageResource(r2);
            goto L_0x0056;
        L_0x004c:
            r0 = r8.cgo;
            r0 = r0.brA;
            r2 = 2131231808; // 0x7f080440 float:1.8079707E38 double:1.0529684197E-314;
            r0.setImageResource(r2);
        L_0x0056:
            r2 = r9.getCreateTime();
            r4 = r9.getCloseTime();
            r0 = com.iqoption.dialog.a.b.e.l(r2, r4);
            if (r0 == 0) goto L_0x0069;
        L_0x0064:
            r0 = r8.cgz;
            r0 = r0.cgr;
            goto L_0x006d;
        L_0x0069:
            r0 = r8.cgz;
            r0 = r0.cgq;
        L_0x006d:
            r6 = r8.cgo;
            r6 = r6.brC;
            r7 = new java.util.Date;
            r7.<init>(r2);
            r2 = r0.format(r7);
            r6.setText(r2);
            r2 = r8.cgo;
            r2 = r2.brx;
            r3 = new java.util.Date;
            r3.<init>(r4);
            r0 = r0.format(r3);
            r2.setText(r0);
            r2 = r9.getSellPnl();
            r0 = r9.getCloseInvestSum();
            r4 = r0.doubleValue();
            r2 = r2 / r4;
            r4 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
            r2 = r2 * r4;
            r4 = 0;
            r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            r6 = -1;
            if (r0 <= 0) goto L_0x00c0;
        L_0x00a5:
            r0 = r8.cgo;
            r0 = r0.brE;
            r2 = java.lang.Double.valueOf(r2);
            r2 = com.iqoption.core.util.p.b(r2);
            r0.setText(r2);
            r0 = r8.cgo;
            r0 = r0.brE;
            r2 = r8.cgz;
            r2 = r2.cgt;
            r0.setTextColor(r2);
            goto L_0x00f5;
        L_0x00c0:
            r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r0 >= 0) goto L_0x00e3;
        L_0x00c4:
            r0 = r8.cgo;
            r0 = r0.brE;
            r2 = java.lang.Math.abs(r2);
            r2 = java.lang.Double.valueOf(r2);
            r2 = com.iqoption.core.util.p.c(r2);
            r0.setText(r2);
            r0 = r8.cgo;
            r0 = r0.brE;
            r2 = r8.cgz;
            r2 = r2.cgu;
            r0.setTextColor(r2);
            goto L_0x00f5;
        L_0x00e3:
            r0 = r8.cgo;
            r0 = r0.brE;
            r2 = com.iqoption.core.util.p.o(r4);
            r0.setText(r2);
            r0 = r8.cgo;
            r0 = r0.brE;
            r0.setTextColor(r6);
        L_0x00f5:
            r0 = r9.getWin();
            r2 = 1;
            r3 = 0;
            if (r0 == 0) goto L_0x0164;
        L_0x00fd:
            r4 = r0.hashCode();
            r5 = 117724; // 0x1cbdc float:1.64966E-40 double:5.81634E-319;
            if (r4 == r5) goto L_0x0116;
        L_0x0106:
            r5 = 103157406; // 0x6260e9e float:3.123187E-35 double:5.09665304E-316;
            if (r4 == r5) goto L_0x010c;
        L_0x010b:
            goto L_0x0121;
        L_0x010c:
            r4 = "loose";
            r4 = r0.equals(r4);
            if (r4 == 0) goto L_0x0121;
        L_0x0114:
            r4 = 0;
            goto L_0x0122;
        L_0x0116:
            r4 = "win";
            r4 = r0.equals(r4);
            if (r4 == 0) goto L_0x0121;
        L_0x011f:
            r4 = 1;
            goto L_0x0122;
        L_0x0121:
            r4 = -1;
        L_0x0122:
            switch(r4) {
                case 0: goto L_0x014e;
                case 1: goto L_0x0138;
                default: goto L_0x0125;
            };
        L_0x0125:
            r4 = r8.cgo;
            r4 = r4.brD;
            r4.setText(r0);
            r0 = r8.cgo;
            r0 = r0.brD;
            r4 = r8.cgz;
            r4 = r4.cgv;
            r0.setTextColor(r4);
            goto L_0x016b;
        L_0x0138:
            r0 = r8.cgo;
            r0 = r0.brD;
            r4 = 2131822362; // 0x7f11071a float:1.9277493E38 double:1.053260192E-314;
            r0.setText(r4);
            r0 = r8.cgo;
            r0 = r0.brD;
            r4 = r8.cgz;
            r4 = r4.cgv;
            r0.setTextColor(r4);
            goto L_0x016b;
        L_0x014e:
            r0 = r8.cgo;
            r0 = r0.brD;
            r4 = 2131822361; // 0x7f110719 float:1.9277491E38 double:1.0532601916E-314;
            r0.setText(r4);
            r0 = r8.cgo;
            r0 = r0.brD;
            r4 = r8.cgz;
            r4 = r4.cgw;
            r0.setTextColor(r4);
            goto L_0x016b;
        L_0x0164:
            r0 = r8.cgo;
            r0 = r0.brD;
            r0.setText(r1);
        L_0x016b:
            r9 = r9.getCloseReason();
            r0 = r9.hashCode();
            switch(r0) {
                case -940242166: goto L_0x01ac;
                case -753660988: goto L_0x01a2;
                case 531759317: goto L_0x0198;
                case 1629890866: goto L_0x018d;
                case 1629890880: goto L_0x0182;
                case 1659842812: goto L_0x0177;
                default: goto L_0x0176;
            };
        L_0x0176:
            goto L_0x01b6;
        L_0x0177:
            r0 = "take_profit";
            r9 = r9.equals(r0);
            if (r9 == 0) goto L_0x01b6;
        L_0x0180:
            r6 = 3;
            goto L_0x01b6;
        L_0x0182:
            r0 = "stop_loss";
            r9 = r9.equals(r0);
            if (r9 == 0) goto L_0x01b6;
        L_0x018b:
            r6 = 1;
            goto L_0x01b6;
        L_0x018d:
            r0 = "stop_lose";
            r9 = r9.equals(r0);
            if (r9 == 0) goto L_0x01b6;
        L_0x0196:
            r6 = 2;
            goto L_0x01b6;
        L_0x0198:
            r0 = "margin_erase";
            r9 = r9.equals(r0);
            if (r9 == 0) goto L_0x01b6;
        L_0x01a0:
            r6 = 0;
            goto L_0x01b6;
        L_0x01a2:
            r0 = "overnight";
            r9 = r9.equals(r0);
            if (r9 == 0) goto L_0x01b6;
        L_0x01aa:
            r6 = 4;
            goto L_0x01b6;
        L_0x01ac:
            r0 = "withdraw";
            r9 = r9.equals(r0);
            if (r9 == 0) goto L_0x01b6;
        L_0x01b5:
            r6 = 5;
        L_0x01b6:
            switch(r6) {
                case 0: goto L_0x01ed;
                case 1: goto L_0x01e2;
                case 2: goto L_0x01e2;
                case 3: goto L_0x01d7;
                case 4: goto L_0x01cc;
                case 5: goto L_0x01c1;
                default: goto L_0x01b9;
            };
        L_0x01b9:
            r9 = r8.cgo;
            r9 = r9.brF;
            r9.setText(r1);
            goto L_0x01f7;
        L_0x01c1:
            r9 = r8.cgo;
            r9 = r9.brF;
            r0 = 2131822789; // 0x7f1108c5 float:1.927836E38 double:1.053260403E-314;
            r9.setText(r0);
            goto L_0x01f7;
        L_0x01cc:
            r9 = r8.cgo;
            r9 = r9.brF;
            r0 = 2131821969; // 0x7f110591 float:1.9276696E38 double:1.053259998E-314;
            r9.setText(r0);
            goto L_0x01f7;
        L_0x01d7:
            r9 = r8.cgo;
            r9 = r9.brF;
            r0 = 2131822410; // 0x7f11074a float:1.927759E38 double:1.053260216E-314;
            r9.setText(r0);
            goto L_0x01f7;
        L_0x01e2:
            r9 = r8.cgo;
            r9 = r9.brF;
            r0 = 2131822371; // 0x7f110723 float:1.9277512E38 double:1.0532601965E-314;
            r9.setText(r0);
            goto L_0x01f7;
        L_0x01ed:
            r9 = r8.cgo;
            r9 = r9.brF;
            r0 = 2131821583; // 0x7f11040f float:1.9275913E38 double:1.053259807E-314;
            r9.setText(r0);
        L_0x01f7:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.dialog.a.b.b.j(com.iqoption.dto.entity.position.Position):void");
        }
    }

    public void a(com.iqoption.dialog.a.a.d dVar, ImmutableList immutableList) {
        aa.a((z) this, dVar, immutableList);
    }

    public com.iqoption.dialog.a.a.d c(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return aa.a((z) this, layoutInflater, viewGroup);
    }

    b(Context context, ImmutableList<Position> immutableList) {
        boolean z = false;
        Position position = (Position) immutableList.get(0);
        if (immutableList.size() > 1) {
            z = true;
        }
        com.iqoption.core.microservices.tradingengine.response.active.a a = com.iqoption.app.helpers.a.FI().a(Integer.valueOf(position.getActiveId()), position.getInstrumentType());
        c cVar = new c(context, a != null ? a.getPrecision() : 4);
        this.cgc = new c(a, position, immutableList, cVar);
        this.cgd = new d(z);
        this.cge = new e(context, z, cVar, immutableList);
    }

    static final /* synthetic */ View a(com.iqoption.core.microservices.tradingengine.response.active.a aVar, Position position, ImmutableList immutableList, c cVar, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        hp o = hp.o(layoutInflater, viewGroup, false);
        if (aVar != null) {
            o.bro.setText(com.iqoption.util.e.a.s(aVar));
        }
        int leverage = position.getLeverage();
        CharSequence ea = p.ea(leverage);
        double d = 0.0d;
        Iterator sI = immutableList.iterator();
        while (sI.hasNext()) {
            Position position2 = (Position) sI.next();
            d += position2.getCloseInvestSum().doubleValue();
            if (position2.getLeverage() != leverage) {
                ea = "—";
            }
        }
        o.brp.setText(l.e(cVar.cgs, Double.valueOf(d)));
        o.brq.setText(ea);
        o.brr.setText(l.e(cVar.cgs, Double.valueOf(d * ((double) leverage))));
        return o.getRoot();
    }

    static final /* synthetic */ View a(boolean z, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        hv r = hv.r(layoutInflater, viewGroup, false);
        if (z) {
            r.brv.setText(R.string.volume);
        } else {
            r.brv.setText(R.string.profit);
        }
        return r.getRoot();
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
}
