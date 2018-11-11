package com.iqoption.core.microservices.billing.response.deposit;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod.PayMethodType;
import com.iqoption.core.microservices.billing.response.extraparams.e;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001HB\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012¢\u0006\u0002\u0010\u0014J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\rHÂ\u0003¢\u0006\u0002\u0010%J\u000b\u0010&\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0017\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÂ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÂ\u0003J\t\u0010.\u001a\u00020\u0005HÂ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\rHÂ\u0003¢\u0006\u0002\u0010%J¢\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u00101J\t\u00102\u001a\u000203HÖ\u0001J\u0013\u00104\u001a\u00020\r2\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\b\u00107\u001a\u00020\u0005H\u0016J\b\u00108\u001a\u00020\u0005H\u0016J\n\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010;\u001a\u00020\u0003H\u0016J\b\u0010<\u001a\u00020\u0003H\u0016J\b\u0010=\u001a\u00020>H\u0016J\t\u0010?\u001a\u000203HÖ\u0001J\b\u0010@\u001a\u00020\rH\u0016J\b\u0010A\u001a\u00020\rH\u0016J\t\u0010B\u001a\u00020\u0005HÖ\u0001J\u0019\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u000203HÖ\u0001R\u0010\u0010\u0004\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0012\u0010\n\u001a\u0004\u0018\u00010\u00058\u0002X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u000b\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\f\u001a\u0004\u0018\u00010\r8\u0002X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R$\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001a¨\u0006I"}, aXE = {"Lcom/iqoption/core/microservices/billing/response/deposit/PaymentMethod;", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "id", "", "_name", "", "cashboxCssClass", "paySystem", "cardId", "cardNumber", "cardIcon", "iconUrl", "kycRestricted", "", "canProcessCardApi", "extraParams", "Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParams;", "limits", "Ljava/util/HashMap;", "Lcom/iqoption/core/microservices/billing/response/deposit/PaymentMethod$Limit;", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParams;Ljava/util/HashMap;)V", "Ljava/lang/Boolean;", "getCardId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCardNumber", "()Ljava/lang/String;", "getCashboxCssClass", "getExtraParams", "()Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParams;", "getId", "()J", "getLimits", "()Ljava/util/HashMap;", "getPaySystem", "component1", "component10", "()Ljava/lang/Boolean;", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParams;Ljava/util/HashMap;)Lcom/iqoption/core/microservices/billing/response/deposit/PaymentMethod;", "describeContents", "", "equals", "other", "", "getImageUrl", "getName", "getPayCardId", "", "getPayMethodId", "getPaymentMethod3dsId", "getType", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod$PayMethodType;", "hashCode", "isDefault3ds", "isKycRestricted", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Limit", "core_release"})
/* compiled from: PaymentMethod.kt */
public final class g implements PayMethod {
    public static final Creator CREATOR = new a();
    @SerializedName("name")
    private final String _name;
    @SerializedName("cashbox_css_class")
    private final String aTL;
    @SerializedName("pay_system")
    private final String aTM;
    @SerializedName("card_id")
    private final Long aTN;
    @SerializedName("card_icon")
    private final String aTO;
    @SerializedName("kyc_restricted")
    private final Boolean aTP;
    @SerializedName("can_process_card_api")
    private final Boolean aTQ;
    @SerializedName("extra_params")
    private final e aTR;
    @SerializedName("limits")
    private final HashMap<String, b> aTS;
    @SerializedName("card_number")
    private final String cardNumber;
    @SerializedName("icon_url")
    private final String iconUrl;
    @SerializedName("id")
    private final long id;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Boolean valueOf2;
            Parcel parcel2 = parcel;
            h.e(parcel2, "in");
            long readLong = parcel.readLong();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            Map map = null;
            Long valueOf3 = parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null;
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            boolean z = false;
            if (parcel.readInt() != 0) {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                valueOf = null;
            }
            if (parcel.readInt() != 0) {
                if (parcel.readInt() != 0) {
                    z = true;
                }
                valueOf2 = Boolean.valueOf(z);
            } else {
                valueOf2 = null;
            }
            e eVar = parcel.readInt() != 0 ? (e) e.CREATOR.createFromParcel(parcel2) : null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                map = new HashMap(readInt);
                while (readInt != 0) {
                    e eVar2 = eVar;
                    Boolean bool = valueOf2;
                    map.put(parcel.readString(), (b) b.CREATOR.createFromParcel(parcel2));
                    readInt--;
                    eVar = eVar2;
                    valueOf2 = bool;
                }
            }
            return new g(readLong, readString, readString2, readString3, valueOf3, readString4, readString5, readString6, valueOf, valueOf2, eVar, map);
        }

        public final Object[] newArray(int i) {
            return new g[i];
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0010J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0012HÖ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u001f"}, aXE = {"Lcom/iqoption/core/microservices/billing/response/deposit/PaymentMethod$Limit;", "Landroid/os/Parcelable;", "min", "", "max", "(Ljava/lang/Double;Ljava/lang/Double;)V", "getMax", "()Ljava/lang/Double;", "setMax", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getMin", "setMin", "component1", "component2", "copy", "(Ljava/lang/Double;Ljava/lang/Double;)Lcom/iqoption/core/microservices/billing/response/deposit/PaymentMethod$Limit;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "core_release"})
    /* compiled from: PaymentMethod.kt */
    public static final class b implements Parcelable {
        public static final Creator CREATOR = new a();
        private Double ayX;
        private Double ayY;

        @i(aXC = {1, 1, 11})
        public static class a implements Creator {
            public final Object createFromParcel(Parcel parcel) {
                h.e(parcel, "in");
                Double d = null;
                Double valueOf = parcel.readInt() != 0 ? Double.valueOf(parcel.readDouble()) : null;
                if (parcel.readInt() != 0) {
                    d = Double.valueOf(parcel.readDouble());
                }
                return new b(valueOf, d);
            }

            public final Object[] newArray(int i) {
                return new b[i];
            }
        }

        public b() {
            this(null, null, 3, null);
        }

        public int describeContents() {
            return 0;
        }

        /* JADX WARNING: Missing block: B:6:0x001a, code:
            if (kotlin.jvm.internal.h.E(r2.ayY, r3.ayY) != false) goto L_0x001f;
     */
        public boolean equals(java.lang.Object r3) {
            /*
            r2 = this;
            if (r2 == r3) goto L_0x001f;
        L_0x0002:
            r0 = r3 instanceof com.iqoption.core.microservices.billing.response.deposit.g.b;
            if (r0 == 0) goto L_0x001d;
        L_0x0006:
            r3 = (com.iqoption.core.microservices.billing.response.deposit.g.b) r3;
            r0 = r2.ayX;
            r1 = r3.ayX;
            r0 = kotlin.jvm.internal.h.E(r0, r1);
            if (r0 == 0) goto L_0x001d;
        L_0x0012:
            r0 = r2.ayY;
            r3 = r3.ayY;
            r3 = kotlin.jvm.internal.h.E(r0, r3);
            if (r3 == 0) goto L_0x001d;
        L_0x001c:
            goto L_0x001f;
        L_0x001d:
            r3 = 0;
            return r3;
        L_0x001f:
            r3 = 1;
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.billing.response.deposit.g.b.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            Double d = this.ayX;
            int i = 0;
            int hashCode = (d != null ? d.hashCode() : 0) * 31;
            Double d2 = this.ayY;
            if (d2 != null) {
                i = d2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Limit(min=");
            stringBuilder.append(this.ayX);
            stringBuilder.append(", max=");
            stringBuilder.append(this.ayY);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            h.e(parcel, "parcel");
            Double d = this.ayX;
            if (d != null) {
                parcel.writeInt(1);
                parcel.writeDouble(d.doubleValue());
            } else {
                parcel.writeInt(0);
            }
            d = this.ayY;
            if (d != null) {
                parcel.writeInt(1);
                parcel.writeDouble(d.doubleValue());
                return;
            }
            parcel.writeInt(0);
        }

        public b(Double d, Double d2) {
            this.ayX = d;
            this.ayY = d2;
        }

        public /* synthetic */ b(Double d, Double d2, int i, f fVar) {
            if ((i & 1) != 0) {
                d = (Double) null;
            }
            if ((i & 2) != 0) {
                d2 = (Double) null;
            }
            this(d, d2);
        }

        public final Double MA() {
            return this.ayY;
        }

        public final Double Mz() {
            return this.ayX;
        }
    }

    public boolean UV() {
        return false;
    }

    public long UW() {
        return -1;
    }

    public Void UX() {
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return ((this.id > gVar.id ? 1 : (this.id == gVar.id ? 0 : -1)) == 0 ? 1 : null) != null && h.E(this._name, gVar._name) && h.E(this.aTL, gVar.aTL) && h.E(this.aTM, gVar.aTM) && h.E(this.aTN, gVar.aTN) && h.E(this.cardNumber, gVar.cardNumber) && h.E(this.aTO, gVar.aTO) && h.E(this.iconUrl, gVar.iconUrl) && h.E(this.aTP, gVar.aTP) && h.E(this.aTQ, gVar.aTQ) && h.E(this.aTR, gVar.aTR) && h.E(this.aTS, gVar.aTS);
        }
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this._name;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.aTL;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.aTM;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        Long l = this.aTN;
        i = (i + (l != null ? l.hashCode() : 0)) * 31;
        str = this.cardNumber;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.aTO;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.iconUrl;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        Boolean bool = this.aTP;
        i = (i + (bool != null ? bool.hashCode() : 0)) * 31;
        bool = this.aTQ;
        i = (i + (bool != null ? bool.hashCode() : 0)) * 31;
        e eVar = this.aTR;
        i = (i + (eVar != null ? eVar.hashCode() : 0)) * 31;
        HashMap hashMap = this.aTS;
        if (hashMap != null) {
            i2 = hashMap.hashCode();
        }
        return i + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PaymentMethod(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", _name=");
        stringBuilder.append(this._name);
        stringBuilder.append(", cashboxCssClass=");
        stringBuilder.append(this.aTL);
        stringBuilder.append(", paySystem=");
        stringBuilder.append(this.aTM);
        stringBuilder.append(", cardId=");
        stringBuilder.append(this.aTN);
        stringBuilder.append(", cardNumber=");
        stringBuilder.append(this.cardNumber);
        stringBuilder.append(", cardIcon=");
        stringBuilder.append(this.aTO);
        stringBuilder.append(", iconUrl=");
        stringBuilder.append(this.iconUrl);
        stringBuilder.append(", kycRestricted=");
        stringBuilder.append(this.aTP);
        stringBuilder.append(", canProcessCardApi=");
        stringBuilder.append(this.aTQ);
        stringBuilder.append(", extraParams=");
        stringBuilder.append(this.aTR);
        stringBuilder.append(", limits=");
        stringBuilder.append(this.aTS);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeLong(this.id);
        parcel.writeString(this._name);
        parcel.writeString(this.aTL);
        parcel.writeString(this.aTM);
        Long l = this.aTN;
        if (l != null) {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.cardNumber);
        parcel.writeString(this.aTO);
        parcel.writeString(this.iconUrl);
        Boolean bool = this.aTP;
        if (bool != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue());
        } else {
            parcel.writeInt(0);
        }
        bool = this.aTQ;
        if (bool != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue());
        } else {
            parcel.writeInt(0);
        }
        Parcelable parcelable = this.aTR;
        if (parcelable != null) {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Map map = this.aTS;
        if (map != null) {
            parcel.writeInt(1);
            parcel.writeInt(map.size());
            for (Entry next : map.entrySet()) {
                parcel.writeString((String) next.getKey());
                ((b) next.getValue()).writeToParcel(parcel, 0);
            }
            return;
        }
        parcel.writeInt(0);
    }

    public g(long j, String str, String str2, String str3, Long l, String str4, String str5, String str6, Boolean bool, Boolean bool2, e eVar, HashMap<String, b> hashMap) {
        h.e(str, "_name");
        h.e(str2, "cashboxCssClass");
        h.e(str6, "iconUrl");
        this.id = j;
        this._name = str;
        this.aTL = str2;
        this.aTM = str3;
        this.aTN = l;
        this.cardNumber = str4;
        this.aTO = str5;
        this.iconUrl = str6;
        this.aTP = bool;
        this.aTQ = bool2;
        this.aTR = eVar;
        this.aTS = hashMap;
    }

    public /* synthetic */ Long UR() {
        return (Long) UX();
    }

    public final long getId() {
        return this.id;
    }

    public final String UY() {
        return this.aTL;
    }

    public final String UZ() {
        return this.aTM;
    }

    public final e Va() {
        return this.aTR;
    }

    public final HashMap<String, b> Vb() {
        return this.aTS;
    }

    public String getName() {
        return this._name;
    }

    public long UQ() {
        return this.id;
    }

    public String US() {
        if (TextUtils.isEmpty(this.iconUrl)) {
            return this.aTO != null ? this.aTO : "";
        } else {
            return this.iconUrl;
        }
    }

    public PayMethodType UT() {
        return PayMethodType.PaymentMethod;
    }

    public boolean UU() {
        return this.aTP != null && this.aTP.booleanValue();
    }
}
