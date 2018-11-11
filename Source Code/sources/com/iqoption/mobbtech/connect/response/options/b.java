package com.iqoption.mobbtech.connect.response.options;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.d;
import com.google.common.base.f;
import com.google.common.collect.ImmutableList;
import com.iqoption.core.d.a;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.dto.entity.position.Position;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: OpenOptionGroup */
public class b implements Parcelable {
    public static final Creator<b> CREATOR = new Creator<b>() {
        /* renamed from: T */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* renamed from: fx */
        public b[] newArray(int i) {
            return new b[i];
        }
    };
    private static final String TAG = "com.iqoption.mobbtech.connect.response.options.b";
    public static d<b, Integer> cWt = d.$instance;
    public Integer activeId;
    private long cWu;
    private Double cWv;
    private final transient com.iqoption.util.b.b<e> cWw;
    private volatile transient ImmutableList<e> cWx;
    private transient int cWy;
    private Long created;
    public Long expTime;
    public Double expValue;
    private int id;
    public InstrumentType instrumentType;
    private volatile i optionKey;
    private Double profitAmount;
    private Double sum;
    private String type;
    public Long userBalanceId;

    public int describeContents() {
        return 0;
    }

    private b() {
        this.cWw = new com.iqoption.util.b.b(e.ORDERING);
        this.cWy = 0;
    }

    public b(e eVar) {
        this.cWw = new com.iqoption.util.b.b(e.ORDERING);
        this.cWy = 0;
        this.id = eVar.getGroupId();
        this.cWu = (long) f.hashCode(Long.valueOf(eVar.getStableId()), Integer.valueOf(this.id));
        this.cWw.add(eVar);
        this.expValue = eVar.getExpValue();
        this.expTime = eVar.getExpired();
        this.activeId = Integer.valueOf(eVar.getActiveId());
        this.instrumentType = eVar.getInstrumentType();
        this.profitAmount = eVar.getCurrentProfitAmount();
        this.sum = eVar.getInvestSum();
        this.cWv = eVar.getTotalSum();
        this.created = eVar.getCreated();
        this.userBalanceId = eVar.getUserBalanceId();
        this.type = eVar.getType();
    }

    public b avi() {
        return new b(this);
    }

    private b(b bVar) {
        this.cWw = new com.iqoption.util.b.b(e.ORDERING);
        this.cWy = 0;
        this.id = bVar.id;
        this.cWu = bVar.cWu;
        this.expTime = bVar.expTime;
        this.expValue = bVar.expValue;
        this.activeId = bVar.activeId;
        this.instrumentType = bVar.instrumentType;
        this.profitAmount = bVar.profitAmount;
        this.sum = bVar.sum;
        this.cWv = bVar.cWv;
        this.created = bVar.created;
        this.userBalanceId = bVar.userBalanceId;
        this.optionKey = bVar.optionKey;
        this.type = bVar.type;
        this.cWw.addAll(bVar.avh());
    }

    public synchronized b bH(long j) {
        Iterator it = this.cWw.iterator();
        while (it.hasNext()) {
            e eVar = (e) ((Entry) it.next()).getKey();
            if (eVar.getExpirationPeriod() != j) {
                it.remove();
                this.sum = Double.valueOf(this.sum.doubleValue() - Math.max(0.0d, eVar.getInvestSum().doubleValue()));
                this.cWv = Double.valueOf(this.cWv.doubleValue() - Math.max(0.0d, eVar.getTotalSum().doubleValue()));
                this.cWx = null;
            }
        }
        if (this.cWw.isEmpty()) {
            return null;
        }
        return this;
    }

    public synchronized b n(Position position) {
        if (this.cWw.get(position) == null) {
            return null;
        }
        this.cWw.clear();
        this.cWw.add(position);
        this.sum = Double.valueOf(Math.max(0.0d, position.getInvestSum().doubleValue()));
        this.cWv = Double.valueOf(Math.max(0.0d, position.getTotalSum().doubleValue()));
        this.cWx = null;
        return this;
    }

    public synchronized void s(e eVar) {
        if (t(eVar)) {
            e eVar2 = (e) this.cWw.add(eVar);
            if (eVar2 != null) {
                this.sum = Double.valueOf(this.sum.doubleValue() + (eVar.getInvestSum().doubleValue() - eVar2.getInvestSum().doubleValue()));
                this.cWv = Double.valueOf(this.cWv.doubleValue() + (eVar.getTotalSum().doubleValue() - eVar2.getTotalSum().doubleValue()));
            } else {
                this.sum = Double.valueOf(this.sum.doubleValue() + eVar.getInvestSum().doubleValue());
                this.cWv = Double.valueOf(this.cWv.doubleValue() + eVar.getTotalSum().doubleValue());
            }
            this.cWx = null;
        }
    }

    public void avj() {
        a.aSc.execute(new c(this, ImmutableList.m(this.cWw.aGI())));
    }

    private boolean t(e eVar) {
        e eVar2 = (e) this.cWw.get(eVar);
        boolean z = true;
        if (eVar2 == null) {
            return true;
        }
        if (eVar2.getIndex() > eVar.getIndex()) {
            z = false;
        }
        return z;
    }

    public ImmutableList<e> avh() {
        if (this.cWx == null) {
            avg();
        }
        return this.cWx;
    }

    public synchronized void avg() {
        if (this.cWx == null) {
            this.cWx = ImmutableList.m(this.cWw.aGI());
        }
    }

    public synchronized int getSize() {
        return this.cWw.size();
    }

    public synchronized boolean isEmpty() {
        return this.cWw.isEmpty();
    }

    /* JADX WARNING: Missing block: B:10:0x0077, code:
            return null;
     */
    @android.support.annotation.Nullable
    public synchronized com.iqoption.mobbtech.connect.response.options.e bI(long r9) {
        /*
        r8 = this;
        monitor-enter(r8);
        r0 = r8.cWw;	 Catch:{ all -> 0x0078 }
        r0 = r0.aGI();	 Catch:{ all -> 0x0078 }
        r0 = com.google.common.collect.i.c(r0);	 Catch:{ all -> 0x0078 }
        r9 = java.lang.Long.valueOf(r9);	 Catch:{ all -> 0x0078 }
        r9 = com.google.common.base.Predicates.G(r9);	 Catch:{ all -> 0x0078 }
        r10 = com.iqoption.mobbtech.connect.response.options.e.getId;	 Catch:{ all -> 0x0078 }
        r9 = com.google.common.base.Predicates.a(r9, r10);	 Catch:{ all -> 0x0078 }
        r9 = r0.e(r9);	 Catch:{ all -> 0x0078 }
        r10 = r9.isPresent();	 Catch:{ all -> 0x0078 }
        r0 = 0;
        if (r10 == 0) goto L_0x0076;
    L_0x0024:
        r10 = r8.cWw;	 Catch:{ all -> 0x0078 }
        r1 = r9.get();	 Catch:{ all -> 0x0078 }
        r10 = r10.remove(r1);	 Catch:{ all -> 0x0078 }
        if (r10 == 0) goto L_0x0076;
    L_0x0030:
        r10 = r9.get();	 Catch:{ all -> 0x0078 }
        r10 = (com.iqoption.mobbtech.connect.response.options.e) r10;	 Catch:{ all -> 0x0078 }
        r1 = r8.sum;	 Catch:{ all -> 0x0078 }
        r1 = r1.doubleValue();	 Catch:{ all -> 0x0078 }
        r3 = r10.getInvestSum();	 Catch:{ all -> 0x0078 }
        r3 = r3.doubleValue();	 Catch:{ all -> 0x0078 }
        r5 = 0;
        r3 = java.lang.Math.max(r5, r3);	 Catch:{ all -> 0x0078 }
        r7 = 0;
        r1 = r1 - r3;
        r1 = java.lang.Double.valueOf(r1);	 Catch:{ all -> 0x0078 }
        r8.sum = r1;	 Catch:{ all -> 0x0078 }
        r1 = r8.cWv;	 Catch:{ all -> 0x0078 }
        r1 = r1.doubleValue();	 Catch:{ all -> 0x0078 }
        r10 = r10.getTotalSum();	 Catch:{ all -> 0x0078 }
        r3 = r10.doubleValue();	 Catch:{ all -> 0x0078 }
        r3 = java.lang.Math.max(r5, r3);	 Catch:{ all -> 0x0078 }
        r10 = 0;
        r1 = r1 - r3;
        r10 = java.lang.Double.valueOf(r1);	 Catch:{ all -> 0x0078 }
        r8.cWv = r10;	 Catch:{ all -> 0x0078 }
        r8.cWx = r0;	 Catch:{ all -> 0x0078 }
        r9 = r9.get();	 Catch:{ all -> 0x0078 }
        r9 = (com.iqoption.mobbtech.connect.response.options.e) r9;	 Catch:{ all -> 0x0078 }
        monitor-exit(r8);
        return r9;
    L_0x0076:
        monitor-exit(r8);
        return r0;
    L_0x0078:
        r9 = move-exception;
        monitor-exit(r8);
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.mobbtech.connect.response.options.b.bI(long):com.iqoption.mobbtech.connect.response.options.e");
    }

    public synchronized double getWinAmount() {
        double d;
        d = 0.0d;
        for (e winAmount : this.cWw.aGI()) {
            d += winAmount.getWinAmount();
        }
        return d;
    }

    public i getOptionKey() {
        if (this.optionKey == null) {
            synchronized (this) {
                if (this.optionKey == null) {
                    this.optionKey = c(this);
                }
            }
        }
        return this.optionKey;
    }

    public synchronized Double avk() {
        Double valueOf = Double.valueOf(0.0d);
        for (e currentProfitAmount : this.cWw.aGI()) {
            valueOf = Double.valueOf(valueOf.doubleValue() + currentProfitAmount.getCurrentProfitAmount().doubleValue());
        }
        this.profitAmount = valueOf;
        return this.profitAmount;
    }

    public synchronized Double getInvestSum() {
        return this.sum;
    }

    public synchronized Long getCreated() {
        return this.created;
    }

    public synchronized long getCancelTimeLeft(long j) {
        return this.cWw.isEmpty() ? 0 : ((e) this.cWw.first()).getCancelTimeLeft(j);
    }

    public synchronized boolean isCancelable(long j) {
        for (e isCancelable : this.cWw.aGI()) {
            if (!isCancelable.isCancelable(j)) {
                return false;
            }
        }
        return true;
    }

    public synchronized Double calculateBuybackAmountWithCancelable(long j) {
        Double d;
        d = null;
        for (e calculateBuybackAmountWithCancelable : this.cWw.aGI()) {
            Double calculateBuybackAmountWithCancelable2 = calculateBuybackAmountWithCancelable.calculateBuybackAmountWithCancelable(j);
            if (calculateBuybackAmountWithCancelable2 != null) {
                d = Double.valueOf(d == null ? calculateBuybackAmountWithCancelable2.doubleValue() : d.doubleValue() + calculateBuybackAmountWithCancelable2.doubleValue());
            }
        }
        return d;
    }

    public synchronized double avl() {
        double d;
        d = 0.0d;
        for (e selfMarginCall : this.cWw.aGI()) {
            d += selfMarginCall.getSelfMarginCall();
        }
        return d;
    }

    public synchronized double getSellPnl() {
        double d;
        d = 0.0d;
        for (e sellPnl : this.cWw.aGI()) {
            d += sellPnl.getSellPnl();
        }
        return d;
    }

    public synchronized int size() {
        return this.cWw.size();
    }

    public int hashCode() {
        return this.id;
    }

    public boolean equals(Object obj) {
        return (obj instanceof b) && ((b) obj).id == this.id;
    }

    public synchronized void F(Collection<e> collection) {
        this.cWw.clear();
        if (collection != null) {
            this.cWw.addAll(collection);
        }
    }

    public static i c(b bVar) {
        return new i(bVar.expTime, bVar.activeId, bVar.instrumentType);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeLong(this.cWu);
        parcel.writeValue(this.userBalanceId);
        parcel.writeValue(this.activeId);
        parcel.writeValue(this.expTime);
        parcel.writeValue(this.expValue);
        parcel.writeString(InstrumentType.serverValue(this.instrumentType));
        parcel.writeValue(this.profitAmount);
        parcel.writeValue(this.sum);
        parcel.writeValue(this.cWv);
        parcel.writeValue(this.created);
        int size = this.cWw.size();
        parcel.writeInt(size);
        if (size > 0) {
            for (e writeParcelable : this.cWw.aGI()) {
                parcel.writeParcelable(writeParcelable, i);
            }
        }
        parcel.writeParcelable(this.optionKey, i);
        parcel.writeString(this.type);
    }

    protected b(Parcel parcel) {
        this.cWw = new com.iqoption.util.b.b(e.ORDERING);
        int i = 0;
        this.cWy = 0;
        this.id = parcel.readInt();
        this.cWu = parcel.readLong();
        this.userBalanceId = (Long) parcel.readValue(Long.class.getClassLoader());
        this.activeId = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.expTime = (Long) parcel.readValue(Long.class.getClassLoader());
        this.expValue = (Double) parcel.readValue(Double.class.getClassLoader());
        this.instrumentType = InstrumentType.fromServerValueNullable(parcel.readString());
        this.profitAmount = (Double) parcel.readValue(Double.class.getClassLoader());
        this.sum = (Double) parcel.readValue(Double.class.getClassLoader());
        this.cWv = (Double) parcel.readValue(Double.class.getClassLoader());
        this.created = (Long) parcel.readValue(Long.class.getClassLoader());
        int readInt = parcel.readInt();
        if (readInt > 0) {
            while (i < readInt) {
                this.cWw.add(parcel.readParcelable(e.class.getClassLoader()));
                i++;
            }
        }
        this.optionKey = (i) parcel.readParcelable(i.class.getClassLoader());
        this.type = parcel.readString();
    }
}
