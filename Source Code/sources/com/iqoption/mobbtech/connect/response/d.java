package com.iqoption.mobbtech.connect.response;

import android.support.v4.util.Pools.SynchronizedPool;
import com.google.common.base.f;
import com.google.gson.annotations.SerializedName;
import com.iqoption.app.managers.af;
import com.iqoption.core.data.model.ActiveType;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.dto.ChartTimeInterval;
import com.iqoption.mobbtech.connect.response.options.e;
import com.iqoption.util.i;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: BuyBackQuote */
public class d extends b {
    private static final String TAG = "com.iqoption.mobbtech.connect.response.d";
    private static final SynchronizedPool<a> sPool = new SynchronizedPool(50);
    @SerializedName("active")
    public Integer activeId;
    @SerializedName("instant")
    public Long cVA;
    @SerializedName("periods")
    public ArrayList<b> cVB;
    @SerializedName("expiration")
    public Long expiration;

    /* compiled from: BuyBackQuote */
    public static class a {
        public Integer activeId;
        public Long expiration;

        public a(Integer num, Long l) {
            this.activeId = num;
            this.expiration = l;
        }

        /* JADX WARNING: Missing block: B:6:0x001a, code:
            if (com.google.common.base.f.equal(r2.expiration, r3.expiration) != false) goto L_0x001f;
     */
        public boolean equals(java.lang.Object r3) {
            /*
            r2 = this;
            if (r3 == r2) goto L_0x001f;
        L_0x0002:
            r0 = r3 instanceof com.iqoption.mobbtech.connect.response.d.a;
            if (r0 == 0) goto L_0x001d;
        L_0x0006:
            r0 = r2.activeId;
            r3 = (com.iqoption.mobbtech.connect.response.d.a) r3;
            r1 = r3.activeId;
            r0 = com.google.common.base.f.equal(r0, r1);
            if (r0 == 0) goto L_0x001d;
        L_0x0012:
            r0 = r2.expiration;
            r3 = r3.expiration;
            r3 = com.google.common.base.f.equal(r0, r3);
            if (r3 == 0) goto L_0x001d;
        L_0x001c:
            goto L_0x001f;
        L_0x001d:
            r3 = 0;
            goto L_0x0020;
        L_0x001f:
            r3 = 1;
        L_0x0020:
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.mobbtech.connect.response.d.a.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            return f.hashCode(this.expiration, this.activeId);
        }

        public void recycle() {
            d.sPool.release(this);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Key{activeId=");
            stringBuilder.append(this.activeId);
            stringBuilder.append(", expiration=");
            stringBuilder.append(this.expiration);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    /* compiled from: BuyBackQuote */
    public static class b {
        @SerializedName("period")
        public Integer cVC;
        @SerializedName("values")
        public d cVD;
    }

    /* compiled from: BuyBackQuote */
    public static class c {
        @SerializedName("levels")
        public ArrayList<Double> cVE;
        @SerializedName("percents")
        public ArrayList<Double> cVF;
    }

    /* compiled from: BuyBackQuote */
    public static class d {
        @SerializedName("put")
        public c cVG;
        @SerializedName("call")
        public c cVH;
    }

    private int ax(int i, int i2) {
        return i < 0 ? 0 : i >= i2 ? i - 1 : i;
    }

    private int d(ActiveType activeType) {
        if (activeType == null) {
            return -1;
        }
        switch (activeType) {
            case TURBO_ACTIVE:
                return 60;
            case BINARY_ACTIVE:
                return ChartTimeInterval.CANDLE_15m;
            default:
                return -1;
        }
    }

    private b p(e eVar) {
        int d = d(eVar.getActiveType());
        Iterator it = this.cVB.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (d == bVar.cVC.intValue()) {
                return bVar;
            }
        }
        return null;
    }

    private int a(Double d, ArrayList<Double> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (d.doubleValue() < ((Double) arrayList.get(i)).doubleValue()) {
                return i - 1;
            }
        }
        return size - 1;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BuyBackQuote{activeId=");
        stringBuilder.append(this.activeId);
        stringBuilder.append(", expiration=");
        stringBuilder.append(this.expiration);
        stringBuilder.append(", instant=");
        stringBuilder.append(this.cVA);
        stringBuilder.append(", periods=");
        stringBuilder.append(this.cVB);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public Double a(e eVar, double d, double d2) {
        if (i.H(this.cVB) || eVar.getValue() == null) {
            return null;
        }
        b p = p(eVar);
        if (p == null || p.cVD == null) {
            return null;
        }
        Double value = eVar.getValue();
        c cVar = eVar.isCall() ? p.cVD.cVH : p.cVD.cVG;
        if (cVar == null || i.H(cVar.cVE) || i.H(cVar.cVF)) {
            return null;
        }
        Double d3 = (Double) cVar.cVF.get(ax(a(value, cVar.cVE), cVar.cVF.size()));
        if (d3 == null) {
            return null;
        }
        return Double.valueOf((d2 * d3.doubleValue()) / 100.0d);
    }

    public boolean q(long j, InstrumentType instrumentType) {
        long Hw = af.Hu().Hw();
        return (j * 1000) - Hw > M(instrumentType) && Hw - (this.cVA.longValue() * 1000) < 3000;
    }

    private long M(InstrumentType instrumentType) {
        switch (instrumentType) {
            case TURBO_INSTRUMENT:
                return 15000;
            case BINARY_INSTRUMENT:
                return 120000;
            default:
                return 0;
        }
    }

    public static a b(d dVar) {
        return new a(dVar.activeId, dVar.expiration);
    }

    public static a e(com.iqoption.mobbtech.connect.response.options.i iVar) {
        return a(iVar.getActiveId(), iVar.avm());
    }

    public static a c(d dVar) {
        return a(dVar.activeId, dVar.expiration);
    }

    public static a a(Integer num, Long l) {
        a aVar = (a) sPool.acquire();
        if (aVar == null) {
            return new a(num, l);
        }
        aVar.activeId = num;
        aVar.expiration = l;
        return aVar;
    }
}
