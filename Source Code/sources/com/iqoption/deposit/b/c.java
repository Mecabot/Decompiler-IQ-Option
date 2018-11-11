package com.iqoption.deposit.b;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.iqoption.core.ui.widget.recyclerview.adapter.a.d;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0002HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006$"}, aXE = {"Lcom/iqoption/deposit/presets/PresetItem;", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/Identifiable;", "", "Landroid/os/Parcelable;", "deposit", "Lcom/iqoption/core/microservices/billing/response/deposit/Deposit;", "currency", "Lcom/iqoption/core/microservices/billing/response/deposit/CurrencyBilling;", "selected", "", "(Lcom/iqoption/core/microservices/billing/response/deposit/Deposit;Lcom/iqoption/core/microservices/billing/response/deposit/CurrencyBilling;Z)V", "getCurrency", "()Lcom/iqoption/core/microservices/billing/response/deposit/CurrencyBilling;", "getDeposit", "()Lcom/iqoption/core/microservices/billing/response/deposit/Deposit;", "id", "getId", "()Ljava/lang/String;", "getSelected", "()Z", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "deposit_release"})
/* compiled from: PresetItem.kt */
public final class c implements Parcelable, d<String> {
    public static final Creator CREATOR = new a();
    private final com.iqoption.core.microservices.billing.response.deposit.c bVE;
    private final com.iqoption.core.microservices.billing.response.deposit.d cch;
    private final boolean selected;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            return new c((com.iqoption.core.microservices.billing.response.deposit.d) parcel.readParcelable(c.class.getClassLoader()), (com.iqoption.core.microservices.billing.response.deposit.c) parcel.readParcelable(c.class.getClassLoader()), parcel.readInt() != 0);
        }

        public final Object[] newArray(int i) {
            return new c[i];
        }
    }

    public static /* bridge */ /* synthetic */ c a(c cVar, com.iqoption.core.microservices.billing.response.deposit.d dVar, com.iqoption.core.microservices.billing.response.deposit.c cVar2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            dVar = cVar.cch;
        }
        if ((i & 2) != 0) {
            cVar2 = cVar.bVE;
        }
        if ((i & 4) != 0) {
            z = cVar.selected;
        }
        return cVar.a(dVar, cVar2, z);
    }

    public final c a(com.iqoption.core.microservices.billing.response.deposit.d dVar, com.iqoption.core.microservices.billing.response.deposit.c cVar, boolean z) {
        h.e(dVar, "deposit");
        h.e(cVar, b.CURRENCY);
        return new c(dVar, cVar, z);
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
            if (h.E(this.cch, cVar.cch) && h.E(this.bVE, cVar.bVE)) {
                if ((this.selected == cVar.selected ? 1 : null) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        com.iqoption.core.microservices.billing.response.deposit.d dVar = this.cch;
        int i = 0;
        int hashCode = (dVar != null ? dVar.hashCode() : 0) * 31;
        com.iqoption.core.microservices.billing.response.deposit.c cVar = this.bVE;
        if (cVar != null) {
            i = cVar.hashCode();
        }
        hashCode = (hashCode + i) * 31;
        i = this.selected;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PresetItem(deposit=");
        stringBuilder.append(this.cch);
        stringBuilder.append(", currency=");
        stringBuilder.append(this.bVE);
        stringBuilder.append(", selected=");
        stringBuilder.append(this.selected);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeParcelable(this.cch, i);
        parcel.writeParcelable(this.bVE, i);
        parcel.writeInt(this.selected);
    }

    public c(com.iqoption.core.microservices.billing.response.deposit.d dVar, com.iqoption.core.microservices.billing.response.deposit.c cVar, boolean z) {
        h.e(dVar, "deposit");
        h.e(cVar, b.CURRENCY);
        this.cch = dVar;
        this.bVE = cVar;
        this.selected = z;
    }

    public final com.iqoption.core.microservices.billing.response.deposit.d adX() {
        return this.cch;
    }

    public final com.iqoption.core.microservices.billing.response.deposit.c aaH() {
        return this.bVE;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    /* renamed from: getId */
    public String Jf() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.bVE.getId());
        stringBuilder.append(' ');
        stringBuilder.append(com.iqoption.core.ext.c.b(this.cch.UO(), 2));
        return stringBuilder.toString();
    }
}
