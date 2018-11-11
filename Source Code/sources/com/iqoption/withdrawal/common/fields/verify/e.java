package com.iqoption.withdrawal.common.fields.verify;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.measurement.AppMeasurement.Param;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, aXE = {"Lcom/iqoption/withdrawal/common/fields/verify/Warning;", "Lcom/iqoption/withdrawal/common/fields/verify/VerificationWarning;", "type", "Lcom/iqoption/withdrawal/common/fields/verify/VerificationWarningType;", "(Lcom/iqoption/withdrawal/common/fields/verify/VerificationWarningType;)V", "getType", "()Lcom/iqoption/withdrawal/common/fields/verify/VerificationWarningType;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VerificationWarnings.kt */
public final class e implements d {
    public static final Creator CREATOR = new a();
    private final VerificationWarningType dQB;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            return new e((VerificationWarningType) Enum.valueOf(VerificationWarningType.class, parcel.readString()));
        }

        public final Object[] newArray(int i) {
            return new e[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Missing block: B:4:0x0010, code:
            if (kotlin.jvm.internal.h.E(r1.dQB, ((com.iqoption.withdrawal.common.fields.verify.e) r2).dQB) != false) goto L_0x0015;
     */
    public boolean equals(java.lang.Object r2) {
        /*
        r1 = this;
        if (r1 == r2) goto L_0x0015;
    L_0x0002:
        r0 = r2 instanceof com.iqoption.withdrawal.common.fields.verify.e;
        if (r0 == 0) goto L_0x0013;
    L_0x0006:
        r2 = (com.iqoption.withdrawal.common.fields.verify.e) r2;
        r0 = r1.dQB;
        r2 = r2.dQB;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.withdrawal.common.fields.verify.e.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        VerificationWarningType verificationWarningType = this.dQB;
        return verificationWarningType != null ? verificationWarningType.hashCode() : 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Warning(type=");
        stringBuilder.append(this.dQB);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeString(this.dQB.name());
    }

    public e(VerificationWarningType verificationWarningType) {
        h.e(verificationWarningType, Param.TYPE);
        this.dQB = verificationWarningType;
    }

    public VerificationWarningType aNr() {
        return this.dQB;
    }
}
