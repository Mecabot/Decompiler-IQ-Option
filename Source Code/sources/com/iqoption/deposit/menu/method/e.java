package com.iqoption.deposit.menu.method;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.iqoption.core.microservices.billing.response.deposit.g;
import com.iqoption.core.microservices.billing.response.deposit.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\nHÆ\u0003JA\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001d\u001a\u00020\nHÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006#"}, aXE = {"Lcom/iqoption/deposit/menu/method/MethodMenuParams;", "Landroid/os/Parcelable;", "userCards", "", "Lcom/iqoption/core/microservices/billing/response/deposit/UserCard;", "paymentMethods", "Lcom/iqoption/core/microservices/billing/response/deposit/PaymentMethod;", "isKycLimitEnabled", "", "selectedItemId", "", "(Ljava/util/List;Ljava/util/List;ZLjava/lang/String;)V", "()Z", "getPaymentMethods", "()Ljava/util/List;", "getSelectedItemId", "()Ljava/lang/String;", "getUserCards", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "deposit_release"})
/* compiled from: MethodMenuParams.kt */
public final class e implements Parcelable {
    public static final Creator CREATOR = new a();
    private final String caX;
    private final boolean cbu;
    private final List<h> cby;
    private final List<g> cbz;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            int readInt;
            List arrayList;
            kotlin.jvm.internal.h.e(parcel, "in");
            if (parcel.readInt() != 0) {
                readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((h) parcel.readParcelable(e.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            readInt = parcel.readInt();
            List arrayList2 = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList2.add((g) parcel.readParcelable(e.class.getClassLoader()));
                readInt--;
            }
            return new e(arrayList, arrayList2, parcel.readInt() != 0, parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new e[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (kotlin.jvm.internal.h.E(this.cby, eVar.cby) && kotlin.jvm.internal.h.E(this.cbz, eVar.cbz)) {
                return (this.cbu == eVar.cbu ? 1 : null) != null && kotlin.jvm.internal.h.E(this.caX, eVar.caX);
            }
        }
    }

    public int hashCode() {
        List list = this.cby;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List list2 = this.cbz;
        hashCode = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        int i2 = this.cbu;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        String str = this.caX;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MethodMenuParams(userCards=");
        stringBuilder.append(this.cby);
        stringBuilder.append(", paymentMethods=");
        stringBuilder.append(this.cbz);
        stringBuilder.append(", isKycLimitEnabled=");
        stringBuilder.append(this.cbu);
        stringBuilder.append(", selectedItemId=");
        stringBuilder.append(this.caX);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        kotlin.jvm.internal.h.e(parcel, "parcel");
        Collection<h> collection = this.cby;
        if (collection != null) {
            parcel.writeInt(1);
            parcel.writeInt(collection.size());
            for (h writeParcelable : collection) {
                parcel.writeParcelable(writeParcelable, i);
            }
        } else {
            parcel.writeInt(0);
        }
        Collection<g> collection2 = this.cbz;
        parcel.writeInt(collection2.size());
        for (g writeParcelable2 : collection2) {
            parcel.writeParcelable(writeParcelable2, i);
        }
        parcel.writeInt(this.cbu);
        parcel.writeString(this.caX);
    }

    public e(List<h> list, List<g> list2, boolean z, String str) {
        kotlin.jvm.internal.h.e(list2, "paymentMethods");
        this.cby = list;
        this.cbz = list2;
        this.cbu = z;
        this.caX = str;
    }

    public final List<h> adI() {
        return this.cby;
    }

    public final List<g> adJ() {
        return this.cbz;
    }

    public final boolean abQ() {
        return this.cbu;
    }

    public final String adK() {
        return this.caX;
    }
}
