package com.iqoption.deposit.light.methods;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.plus.PlusShare;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0011\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\fHÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\fHÖ\u0001R\u001c\u0010\u0005\u001a\u00020\u00038\u0016X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u001d"}, aXE = {"Lcom/iqoption/deposit/light/methods/MethodTitleAdapterItem;", "Lcom/iqoption/deposit/menu/method/BaseMethodAdapterItem;", "title", "", "(Ljava/lang/String;)V", "id", "id$annotations", "()V", "getId", "()Ljava/lang/String;", "getTitle", "viewType", "", "getViewType", "()I", "component1", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "deposit_release"})
/* compiled from: MethodTitleAdapterItem.kt */
public final class b implements com.iqoption.deposit.menu.method.a {
    public static final Creator CREATOR = new a();
    private final String id = this.title;
    private final String title;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            return new b(parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new b[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Missing block: B:4:0x0010, code:
            if (kotlin.jvm.internal.h.E(r1.title, ((com.iqoption.deposit.light.methods.b) r2).title) != false) goto L_0x0015;
     */
    public boolean equals(java.lang.Object r2) {
        /*
        r1 = this;
        if (r1 == r2) goto L_0x0015;
    L_0x0002:
        r0 = r2 instanceof com.iqoption.deposit.light.methods.b;
        if (r0 == 0) goto L_0x0013;
    L_0x0006:
        r2 = (com.iqoption.deposit.light.methods.b) r2;
        r0 = r1.title;
        r2 = r2.title;
        r2 = kotlin.jvm.internal.h.E(r0, r2);
        if (r2 == 0) goto L_0x0013;
    L_0x0012:
        goto L_0x0015;
    L_0x0013:
        r2 = 0;
        return r2;
    L_0x0015:
        r2 = 1;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.deposit.light.methods.b.equals(java.lang.Object):boolean");
    }

    public int getViewType() {
        return 1;
    }

    public int hashCode() {
        String str = this.title;
        return str != null ? str.hashCode() : 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MethodTitleAdapterItem(title=");
        stringBuilder.append(this.title);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeString(this.title);
    }

    public b(String str) {
        h.e(str, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        this.title = str;
    }

    public final String getTitle() {
        return this.title;
    }

    /* renamed from: getId */
    public String Jf() {
        return this.id;
    }
}
