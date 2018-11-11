package com.iqoption.mobbtech.connect.response.options;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.common.base.e;
import com.google.common.base.f;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;
import com.google.common.primitives.Longs;
import com.google.gson.annotations.SerializedName;
import com.iqoption.core.data.model.ActiveType;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.i;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.dto.entity.result.BuybackResult;
import com.iqoption.util.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* compiled from: ClosedOptionGroup */
public class a implements Parcelable {
    public static final Creator<a> CREATOR = new Creator<a>() {
        /* renamed from: S */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* renamed from: fw */
        public a[] newArray(int i) {
            return new a[i];
        }
    };
    private static final String TAG = "com.iqoption.mobbtech.connect.response.options.a";
    public static final Ordering<a> cWp = new a().compound(new b());
    @SerializedName("option_type")
    private ActiveType aWK;
    @SerializedName("active_id")
    private Integer activeId;
    @SerializedName("amount")
    private Double amount;
    @SerializedName("id")
    private List<Long> cWq;
    private volatile transient ImmutableList<Long> cWr;
    private TreeSet<e> cWs = Sets.f(e.ORDERING);
    @SerializedName("created")
    private Long created;
    @SerializedName("exp_value")
    private Double expValue;
    @SerializedName("expired")
    private Long expired;
    private InstrumentType instrumentType;
    private transient i optionKey;
    private Long userBalanceId;
    @SerializedName("win")
    private String win;
    @SerializedName("win_amount")
    private Double winAmount;

    /* compiled from: ClosedOptionGroup */
    private static class a extends Ordering<a> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: a */
        public int compare(@Nullable a aVar, @Nullable a aVar2) {
            return Longs.compare(aVar.expired.longValue(), aVar2.expired.longValue());
        }
    }

    /* compiled from: ClosedOptionGroup */
    private static class b extends Ordering<a> {
        private b() {
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: a */
        public int compare(@Nullable a aVar, @Nullable a aVar2) {
            return Longs.vq().compare(d.a((Long[]) aVar.cWq.toArray(new Long[0])), d.a((Long[]) aVar2.cWq.toArray(new Long[0])));
        }
    }

    public int describeContents() {
        return 0;
    }

    private a() {
    }

    public static a q(e eVar) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create position: ");
        stringBuilder.append(eVar);
        i.d(str, stringBuilder.toString());
        a aVar = new a();
        aVar.activeId = Integer.valueOf(eVar.getActiveId());
        aVar.aWK = eVar.getActiveType();
        aVar.instrumentType = eVar.getInstrumentType();
        aVar.created = eVar.getCreated();
        aVar.expired = r(eVar);
        aVar.amount = eVar.getCloseInvestSum();
        aVar.expValue = eVar.getExpValue();
        aVar.cWq = new ArrayList();
        aVar.cWq.add(eVar.getId());
        aVar.winAmount = Double.valueOf(eVar.getWinAmount());
        aVar.win = "equal";
        long doubleValue = (long) (aVar.winAmount.doubleValue() * 1000.0d);
        long doubleValue2 = (long) (aVar.amount.doubleValue() * 1000.0d);
        String str2 = doubleValue > doubleValue2 ? "win" : doubleValue < doubleValue2 ? "loose" : "equal";
        aVar.win = str2;
        aVar.cWs.add(eVar);
        return aVar;
    }

    public static a l(Position position) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create position: ");
        stringBuilder.append(position);
        i.d(str, stringBuilder.toString());
        a aVar = new a();
        aVar.activeId = Integer.valueOf(position.getActiveId());
        aVar.created = position.getCreated();
        aVar.expired = r(position);
        aVar.aWK = position.getActiveType();
        aVar.instrumentType = position.getInstrumentType();
        aVar.amount = position.getCloseInvestSum();
        aVar.expValue = position.getExpValue();
        aVar.cWq = new ArrayList();
        aVar.cWq.add(position.getId());
        aVar.winAmount = Double.valueOf(position.getWinAmount());
        aVar.win = "equal";
        long doubleValue = (long) (aVar.winAmount.doubleValue() * 1000.0d);
        long doubleValue2 = (long) (aVar.amount.doubleValue() * 1000.0d);
        String str2 = doubleValue > doubleValue2 ? "win" : doubleValue < doubleValue2 ? "loose" : "equal";
        aVar.win = str2;
        aVar.cWs.add(position);
        return aVar;
    }

    private static Long r(e eVar) {
        com.iqoption.core.microservices.tradingengine.response.active.a a = com.iqoption.app.helpers.a.FI().a(Integer.valueOf(eVar.getActiveId()), eVar.getInstrumentType());
        if (a != null) {
            return Long.valueOf(a.isExpired() ? eVar.getExpired().longValue() : eVar.getClosed());
        }
        switch (eVar.getInstrumentType()) {
            case CFD_INSTRUMENT:
            case FOREX_INSTRUMENT:
            case CRYPTO_INSTRUMENT:
                return Long.valueOf(eVar.getClosed());
            default:
                return eVar.getExpired();
        }
    }

    public static a b(BuybackResult buybackResult) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create group from buybackresult: ");
        stringBuilder.append(buybackResult);
        i.d(str, stringBuilder.toString());
        a aVar = new a();
        aVar.activeId = buybackResult.activeId;
        aVar.created = buybackResult.created;
        aVar.expired = buybackResult.expired;
        aVar.aWK = buybackResult.typeName;
        aVar.instrumentType = buybackResult.typeName.toInstrumentType();
        aVar.amount = buybackResult.sum;
        aVar.expValue = Double.valueOf(((double) buybackResult.expValue.longValue()) * 1.0E-6d);
        aVar.cWq = new ArrayList();
        aVar.cWq.add(buybackResult.optionId);
        aVar.winAmount = buybackResult.winAmount;
        aVar.win = buybackResult.win;
        return aVar;
    }

    /* JADX WARNING: Missing block: B:8:0x0024, code:
            if (com.google.common.base.f.equal(r2.aWK, r3.aWK) != false) goto L_0x0029;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r3 == r2) goto L_0x0029;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.mobbtech.connect.response.options.a;
        if (r0 == 0) goto L_0x0027;
    L_0x0006:
        r0 = r2.activeId;
        r3 = (com.iqoption.mobbtech.connect.response.options.a) r3;
        r1 = r3.activeId;
        r0 = com.google.common.base.f.equal(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x0012:
        r0 = r2.expired;
        r1 = r3.expired;
        r0 = com.google.common.base.f.equal(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x001c:
        r0 = r2.aWK;
        r3 = r3.aWK;
        r3 = com.google.common.base.f.equal(r0, r3);
        if (r3 == 0) goto L_0x0027;
    L_0x0026:
        goto L_0x0029;
    L_0x0027:
        r3 = 0;
        goto L_0x002a;
    L_0x0029:
        r3 = 1;
    L_0x002a:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.mobbtech.connect.response.options.a.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        return f.hashCode(this.activeId, this.expired, this.aWK);
    }

    public synchronized Double getWinAmount() {
        return this.winAmount;
    }

    public synchronized Double getAmount() {
        return this.amount;
    }

    public ActiveType getActiveType() {
        return this.aWK;
    }

    public InstrumentType getInstrumentType() {
        return this.instrumentType != null ? this.instrumentType : this.aWK.toInstrumentType();
    }

    public Long getExpired() {
        return this.expired;
    }

    public synchronized String getWin() {
        long doubleValue = (long) (this.winAmount.doubleValue() * 1000.0d);
        long doubleValue2 = (long) (this.amount.doubleValue() * 1000.0d);
        String str = doubleValue > doubleValue2 ? "win" : doubleValue < doubleValue2 ? "loose" : "equal";
        this.win = str;
        return this.win;
    }

    public String toString() {
        return e.B(this).d("activeId", this.activeId).d("amount", this.amount).d("created", this.created).d("expValue", this.expValue).d(Position.CLOSE_REASON_EXPIRED, this.expired).d("ids", this.cWq).d(Param.TYPE, this.aWK).d("win", this.win).d("winAmount", this.winAmount).toString();
    }

    public ImmutableList<Long> avf() {
        if (this.cWr == null) {
            avg();
        }
        return this.cWr;
    }

    public synchronized void avg() {
        if (this.cWr == null) {
            this.cWr = ImmutableList.m(this.cWq);
        }
    }

    public synchronized void s(e eVar) {
        this.created = Long.valueOf(Math.min(this.created.longValue(), eVar.getCreated().longValue()));
        this.amount = Double.valueOf(this.amount.doubleValue() + eVar.getCloseInvestSum().doubleValue());
        this.cWq.add(eVar.getId());
        Collections.sort(this.cWq);
        this.cWr = null;
        this.winAmount = Double.valueOf(this.winAmount.doubleValue() + eVar.getWinAmount());
        this.win = getWin();
        this.cWs.add(eVar);
    }

    public synchronized void m(Position position) {
        this.created = Long.valueOf(Math.min(this.created.longValue(), position.getCreated().longValue()));
        this.amount = Double.valueOf(this.amount.doubleValue() + position.getCloseInvestSum().doubleValue());
        this.cWq.add(position.getId());
        Collections.sort(this.cWq);
        this.cWr = null;
        this.winAmount = Double.valueOf(this.winAmount.doubleValue() + position.getWinAmount());
        this.win = getWin();
        this.cWs.add(position);
    }

    public synchronized void c(BuybackResult buybackResult) {
        this.created = Long.valueOf(Math.min(this.created.longValue(), buybackResult.created.longValue()));
        this.amount = Double.valueOf(this.amount.doubleValue() + buybackResult.sum.doubleValue());
        this.cWq.add(buybackResult.optionId);
        Collections.sort(this.cWq);
        this.cWr = null;
        this.winAmount = Double.valueOf(this.winAmount.doubleValue() + buybackResult.winAmount.doubleValue());
        this.win = getWin();
    }

    public synchronized Long getCreated() {
        return this.created;
    }

    public Integer getActiveId() {
        return this.activeId;
    }

    public synchronized boolean A(Long l) {
        return this.cWq.contains(l);
    }

    public synchronized int size() {
        return this.cWq.size();
    }

    public ImmutableList<e> avh() {
        return ImmutableList.m(this.cWs);
    }

    public i getOptionKey() {
        if (this.optionKey == null) {
            this.optionKey = b(this);
        }
        return this.optionKey;
    }

    public static i b(a aVar) {
        return new i(aVar.expired, aVar.activeId, aVar.getInstrumentType());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.activeId);
        parcel.writeValue(this.amount);
        parcel.writeValue(this.created);
        parcel.writeValue(this.expValue);
        parcel.writeValue(this.expired);
        parcel.writeList(this.cWq);
        parcel.writeString(ActiveType.serverValue(this.aWK));
        parcel.writeString(InstrumentType.serverValue(this.instrumentType));
        parcel.writeString(this.win);
        parcel.writeValue(this.winAmount);
        parcel.writeValue(this.userBalanceId);
        int size = this.cWs.size();
        parcel.writeInt(size);
        if (size > 0) {
            Iterator it = this.cWs.iterator();
            while (it.hasNext()) {
                parcel.writeParcelable((e) it.next(), i);
            }
        }
    }

    protected a(Parcel parcel) {
        this.activeId = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.amount = (Double) parcel.readValue(Double.class.getClassLoader());
        this.created = (Long) parcel.readValue(Long.class.getClassLoader());
        this.expValue = (Double) parcel.readValue(Double.class.getClassLoader());
        this.expired = (Long) parcel.readValue(Long.class.getClassLoader());
        this.cWq = new ArrayList();
        parcel.readList(this.cWq, Long.class.getClassLoader());
        this.aWK = ActiveType.fromServerValueNullable(parcel.readString());
        this.instrumentType = InstrumentType.fromServerValueNullable(parcel.readString());
        this.win = parcel.readString();
        this.winAmount = (Double) parcel.readValue(Double.class.getClassLoader());
        this.userBalanceId = (Long) parcel.readValue(Long.class.getClassLoader());
        int readInt = parcel.readInt();
        if (readInt > 0) {
            for (int i = 0; i < readInt; i++) {
                this.cWs.add(parcel.readParcelable(e.class.getClassLoader()));
            }
        }
    }
}
