package com.iqoption.deposit.menu.method;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.core.microservices.billing.response.deposit.e;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\t\u0010\u001e\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0016HÖ\u0001J\t\u0010#\u001a\u00020\bHÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0016HÖ\u0001R\u001c\u0010\n\u001a\u00020\b8\u0016X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006)"}, aXE = {"Lcom/iqoption/deposit/menu/method/MethodAdapterItem;", "Lcom/iqoption/deposit/menu/method/BaseMethodAdapterItem;", "payMethod", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "isKycLimitEnabled", "", "isSelected", "timeDescription", "", "(Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;ZZLjava/lang/String;)V", "id", "id$annotations", "()V", "getId", "()Ljava/lang/String;", "()Z", "setSelected", "(Z)V", "getPayMethod", "()Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "getTimeDescription", "viewType", "", "getViewType", "()I", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "deposit_release"})
/* compiled from: MethodAdapterItem.kt */
public final class b implements a {
    public static final Creator CREATOR = new a();
    private final PayMethod bVQ;
    private final boolean cbu;
    private final String cbv;
    private final String id;
    private boolean isSelected;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            PayMethod payMethod = (PayMethod) parcel.readParcelable(b.class.getClassLoader());
            boolean z = false;
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                z = true;
            }
            return new b(payMethod, z2, z, parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new b[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (h.E(this.bVQ, bVar.bVQ)) {
                if ((this.cbu == bVar.cbu ? 1 : null) != null) {
                    return (this.isSelected == bVar.isSelected ? 1 : null) != null && h.E(this.cbv, bVar.cbv);
                }
            }
        }
    }

    public int getViewType() {
        return 0;
    }

    public int hashCode() {
        PayMethod payMethod = this.bVQ;
        int i = 0;
        int hashCode = (payMethod != null ? payMethod.hashCode() : 0) * 31;
        int i2 = this.cbu;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.isSelected;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        String str = this.cbv;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MethodAdapterItem(payMethod=");
        stringBuilder.append(this.bVQ);
        stringBuilder.append(", isKycLimitEnabled=");
        stringBuilder.append(this.cbu);
        stringBuilder.append(", isSelected=");
        stringBuilder.append(this.isSelected);
        stringBuilder.append(", timeDescription=");
        stringBuilder.append(this.cbv);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeParcelable(this.bVQ, i);
        parcel.writeInt(this.cbu);
        parcel.writeInt(this.isSelected);
        parcel.writeString(this.cbv);
    }

    public b(PayMethod payMethod, boolean z, boolean z2, String str) {
        h.e(payMethod, "payMethod");
        this.bVQ = payMethod;
        this.cbu = z;
        this.isSelected = z2;
        this.cbv = str;
        this.id = e.e(this.bVQ);
    }

    public final PayMethod aaT() {
        return this.bVQ;
    }

    public final boolean abQ() {
        return this.cbu;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public /* synthetic */ b(PayMethod payMethod, boolean z, boolean z2, String str, int i, f fVar) {
        if ((i & 8) != 0) {
            str = (String) null;
        }
        this(payMethod, z, z2, str);
    }

    public final String adF() {
        return this.cbv;
    }

    /* renamed from: getId */
    public String Jf() {
        return this.id;
    }
}
