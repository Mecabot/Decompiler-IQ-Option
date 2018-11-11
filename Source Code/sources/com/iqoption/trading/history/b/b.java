package com.iqoption.trading.history.b;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.common.base.e;
import com.google.common.c.a;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import com.google.gson.annotations.SerializedName;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.ext.c;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.util.au;

/* compiled from: Portfolio */
public class b implements Parcelable {
    public static final Creator<b> CREATOR = new Creator<b>() {
        /* renamed from: Z */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* renamed from: gA */
        public b[] newArray(int i) {
            return new b[i];
        }
    };
    @SerializedName("active_id")
    public int activeId;
    @SerializedName("invest")
    public double amZ;
    @SerializedName("close_time")
    private long cYc;
    @SerializedName("close_reason")
    public String closeReason;
    @SerializedName("user_balance_id")
    public long dsQ;
    @SerializedName("open_time")
    private long dsR;
    @SerializedName("open_quote")
    public double dsS;
    @SerializedName("close_quote")
    public double dsT;
    @SerializedName("close_profit")
    private double dsU;
    @SerializedName("raw_event")
    public a dsV;
    @SerializedName("id")
    public long id;
    @SerializedName("instrument_type")
    public InstrumentType instrumentType;
    @SerializedName("status")
    public String status;

    public int describeContents() {
        return 0;
    }

    public long axd() {
        return this.dsR * 1000;
    }

    public long getCloseTime() {
        return this.cYc * 1000;
    }

    public double aEO() {
        return this.dsU;
    }

    public double aEP() {
        return this.dsU - this.amZ;
    }

    public double aEQ() {
        return (aEP() / this.amZ) * 100.0d;
    }

    public Integer aEM() {
        return (this.dsV == null || this.dsV.aEM() == null || this.dsV.aEM().intValue() <= 1) ? null : this.dsV.aEM();
    }

    public boolean isCall() {
        if (this.dsV == null) {
            return true;
        }
        return this.dsV.isCall();
    }

    public Double getSwap() {
        Double swap = this.dsV == null ? null : this.dsV.getSwap();
        if (swap == null || a.b(0.0d, swap.doubleValue(), 0.001d)) {
            return null;
        }
        return swap;
    }

    public Double getCommission() {
        Double commission = this.dsV == null ? null : this.dsV.getCommission();
        if (commission == null) {
            return null;
        }
        double c = au.c(commission.doubleValue(), 2);
        if (a.b(0.0d, c, 0.001d)) {
            return null;
        }
        return Double.valueOf(c);
    }

    public Double aER() {
        Object countRealized = this.dsV == null ? null : this.dsV.getCountRealized();
        Object count = this.dsV == null ? null : this.dsV.getCount();
        if (countRealized == null && count == null) {
            return null;
        }
        return Double.valueOf(Math.abs(((Double) e.h(count, Double.valueOf(0.0d))).doubleValue()) + Math.abs(((Double) e.h(countRealized, Double.valueOf(0.0d))).doubleValue()));
    }

    public Double aEN() {
        return this.dsV == null ? null : this.dsV.aEN();
    }

    public boolean axg() {
        return c.b(this.instrumentType, InstrumentType.FX_INSTRUMENT, InstrumentType.DIGITAL_INSTRUMENT);
    }

    @Nullable
    public com.iqoption.core.microservices.tradingengine.response.active.a Jg() {
        return com.iqoption.app.helpers.a.FI().a(Integer.valueOf(this.activeId), this.instrumentType);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this.id != ((b) obj).id) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (((Longs.hashCode(this.id) * 31) + Ints.hashCode(this.activeId)) * 31) + this.instrumentType.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.id);
        parcel.writeInt(this.activeId);
        parcel.writeString(InstrumentType.serverValue(this.instrumentType));
        parcel.writeString(this.status);
        parcel.writeLong(this.dsR);
        parcel.writeDouble(this.dsS);
        parcel.writeDouble(this.amZ);
        parcel.writeDouble(this.dsT);
        parcel.writeString(this.closeReason);
        parcel.writeLong(this.cYc);
        parcel.writeDouble(this.dsU);
        parcel.writeParcelable(this.dsV, i);
    }

    protected b(Parcel parcel) {
        this.id = parcel.readLong();
        this.activeId = parcel.readInt();
        this.instrumentType = InstrumentType.fromServerValueNullable(parcel.readString());
        this.status = parcel.readString();
        this.dsR = parcel.readLong();
        this.dsS = parcel.readDouble();
        this.amZ = parcel.readDouble();
        this.dsT = parcel.readDouble();
        this.closeReason = parcel.readString();
        this.cYc = parcel.readLong();
        this.dsU = parcel.readDouble();
        this.dsV = (a) parcel.readParcelable(Position.class.getClassLoader());
    }
}
