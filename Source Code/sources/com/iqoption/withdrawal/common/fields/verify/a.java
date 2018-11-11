package com.iqoption.withdrawal.common.fields.verify;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.iqoption.mobbtech.connect.response.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001a"}, aXE = {"Lcom/iqoption/withdrawal/common/fields/verify/CardsWarning;", "Lcom/iqoption/withdrawal/common/fields/verify/VerificationWarning;", "cards", "", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "(Ljava/util/List;)V", "getCards", "()Ljava/util/List;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "type", "Lcom/iqoption/withdrawal/common/fields/verify/VerificationWarningType;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VerificationWarnings.kt */
public final class a implements d {
    public static final Creator CREATOR = new a();
    private final List<q> cTu;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            int readInt = parcel.readInt();
            List arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((q) q.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new a(arrayList);
        }

        public final Object[] newArray(int i) {
            return new a[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Missing block: B:4:0x0010, code:
            if (kotlin.jvm.internal.h.E(r1.cTu, ((com.iqoption.withdrawal.common.fields.verify.a) r2).cTu) != false) goto L_0x0015;
     */
    public boolean equals(java.lang.Object r2) {
        /*
        r1 = this;
        if (r1 == r2) goto L_0x0015;
    L_0x0002:
        r0 = r2 instanceof com.iqoption.withdrawal.common.fields.verify.a;
        if (r0 == 0) goto L_0x0013;
    L_0x0006:
        r2 = (com.iqoption.withdrawal.common.fields.verify.a) r2;
        r0 = r1.cTu;
        r2 = r2.cTu;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.withdrawal.common.fields.verify.a.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        List list = this.cTu;
        return list != null ? list.hashCode() : 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CardsWarning(cards=");
        stringBuilder.append(this.cTu);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        Collection<q> collection = this.cTu;
        parcel.writeInt(collection.size());
        for (q writeToParcel : collection) {
            writeToParcel.writeToParcel(parcel, 0);
        }
    }

    public a(List<q> list) {
        h.e(list, "cards");
        this.cTu = list;
    }

    public final List<q> atB() {
        return this.cTu;
    }

    public VerificationWarningType aNr() {
        return VerificationWarningType.CARDS_WARNING;
    }
}
