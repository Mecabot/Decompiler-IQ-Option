package com.iqoption.core.microservices.feed.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.iqoption.core.data.model.InstrumentType;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 *2\u00020\u0001:\u0001*B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\u0006\u0010\u001f\u001a\u00020 J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\u0006\u0010\"\u001a\u00020\u0014J\t\u0010#\u001a\u00020\u0007HÖ\u0001J\u0006\u0010$\u001a\u00020\u0014J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006+"}, aXE = {"Lcom/iqoption/core/microservices/feed/response/FeedButton;", "Landroid/os/Parcelable;", "instrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "assetId", "", "asset", "", "actionText", "action", "(Lcom/iqoption/core/data/model/InstrumentType;ILjava/lang/String;Ljava/lang/String;I)V", "getAction", "()I", "getActionText", "()Ljava/lang/String;", "getAsset", "getAssetId", "getInstrumentType", "()Lcom/iqoption/core/data/model/InstrumentType;", "buy", "", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", "", "getId", "", "hashCode", "sell", "toString", "trade", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "core_release"})
/* compiled from: FeedResponses.kt */
public final class c implements Parcelable {
    public static final Creator CREATOR = new b();
    public static final a aWc = new a();
    @SerializedName("asset_id")
    private final int aWa;
    @SerializedName("asset")
    private final String aWb;
    @SerializedName("action")
    private final int action;
    @SerializedName("action_text")
    private final String actionText;
    @SerializedName("instrument_type")
    private final InstrumentType instrumentType;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, aXE = {"Lcom/iqoption/core/microservices/feed/response/FeedButton$Companion;", "", "()V", "BUY", "", "SELL", "TRADE", "core_release"})
    /* compiled from: FeedResponses.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11})
    public static class b implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            return new c((InstrumentType) Enum.valueOf(InstrumentType.class, parcel.readString()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt());
        }

        public final Object[] newArray(int i) {
            return new c[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (h.E(this.instrumentType, cVar.instrumentType)) {
                if ((this.aWa == cVar.aWa ? 1 : null) != null && h.E(this.aWb, cVar.aWb) && h.E(this.actionText, cVar.actionText)) {
                    if ((this.action == cVar.action ? 1 : null) != null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        InstrumentType instrumentType = this.instrumentType;
        int i = 0;
        int hashCode = (((instrumentType != null ? instrumentType.hashCode() : 0) * 31) + this.aWa) * 31;
        String str = this.aWb;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.actionText;
        if (str != null) {
            i = str.hashCode();
        }
        return ((hashCode + i) * 31) + this.action;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FeedButton(instrumentType=");
        stringBuilder.append(this.instrumentType);
        stringBuilder.append(", assetId=");
        stringBuilder.append(this.aWa);
        stringBuilder.append(", asset=");
        stringBuilder.append(this.aWb);
        stringBuilder.append(", actionText=");
        stringBuilder.append(this.actionText);
        stringBuilder.append(", action=");
        stringBuilder.append(this.action);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeString(this.instrumentType.name());
        parcel.writeInt(this.aWa);
        parcel.writeString(this.aWb);
        parcel.writeString(this.actionText);
        parcel.writeInt(this.action);
    }

    public c(InstrumentType instrumentType, int i, String str, String str2, int i2) {
        h.e(instrumentType, "instrumentType");
        h.e(str, "asset");
        h.e(str2, "actionText");
        this.instrumentType = instrumentType;
        this.aWa = i;
        this.aWb = str;
        this.actionText = str2;
        this.action = i2;
    }

    public final InstrumentType getInstrumentType() {
        return this.instrumentType;
    }

    public final int VU() {
        return this.aWa;
    }

    public final int getAction() {
        return this.action;
    }
}
