package com.iqoption.deposit.menu.currency;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.iqoption.core.microservices.billing.response.deposit.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000bJ*\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0010J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u001f"}, aXE = {"Lcom/iqoption/deposit/menu/currency/CurrencyMenuParams;", "Landroid/os/Parcelable;", "currencies", "", "Lcom/iqoption/core/microservices/billing/response/deposit/CurrencyBilling;", "selectedId", "", "(Ljava/util/List;Ljava/lang/Long;)V", "getCurrencies", "()Ljava/util/List;", "getSelectedId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Long;)Lcom/iqoption/deposit/menu/currency/CurrencyMenuParams;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "deposit_release"})
/* compiled from: CurrencyMenuParams.kt */
public final class b implements Parcelable {
    public static final Creator CREATOR = new a();
    private final List<c> aVv;
    private final Long cbq;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            int readInt = parcel.readInt();
            List arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((c) parcel.readParcelable(b.class.getClassLoader()));
                readInt--;
            }
            return new b(arrayList, parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null);
        }

        public final Object[] newArray(int i) {
            return new b[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Missing block: B:6:0x001a, code:
            if (kotlin.jvm.internal.h.E(r2.cbq, r3.cbq) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.deposit.menu.currency.b;
        if (r0 == 0) goto L_0x001d;
    L_0x0006:
        r3 = (com.iqoption.deposit.menu.currency.b) r3;
        r0 = r2.aVv;
        r1 = r3.aVv;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x001d;
    L_0x0012:
        r0 = r2.cbq;
        r3 = r3.cbq;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.deposit.menu.currency.b.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        List list = this.aVv;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        Long l = this.cbq;
        if (l != null) {
            i = l.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CurrencyMenuParams(currencies=");
        stringBuilder.append(this.aVv);
        stringBuilder.append(", selectedId=");
        stringBuilder.append(this.cbq);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        Collection<c> collection = this.aVv;
        parcel.writeInt(collection.size());
        for (c writeParcelable : collection) {
            parcel.writeParcelable(writeParcelable, i);
        }
        Long l = this.cbq;
        if (l != null) {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
            return;
        }
        parcel.writeInt(0);
    }

    public b(List<c> list, Long l) {
        h.e(list, "currencies");
        this.aVv = list;
        this.cbq = l;
    }

    public final List<c> VF() {
        return this.aVv;
    }

    public final Long adE() {
        return this.cbq;
    }
}
