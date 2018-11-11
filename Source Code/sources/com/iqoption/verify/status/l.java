package com.iqoption.verify.status;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.iqoption.dto.entity.iqbus.VerifyInitResult;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u001fHÖ\u0001J\t\u0010%\u001a\u00020\u0007HÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001fHÖ\u0001R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\n\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006+"}, aXE = {"Lcom/iqoption/verify/status/VerifyState;", "Landroid/os/Parcelable;", "userId", "", "initResult", "Lcom/iqoption/dto/entity/iqbus/VerifyInitResult;", "countryNameIco", "", "completedSide", "Lcom/iqoption/verify/status/CardSide;", "progressSide", "(JLcom/iqoption/dto/entity/iqbus/VerifyInitResult;Ljava/lang/String;Lcom/iqoption/verify/status/CardSide;Lcom/iqoption/verify/status/CardSide;)V", "getCompletedSide", "()Lcom/iqoption/verify/status/CardSide;", "setCompletedSide", "(Lcom/iqoption/verify/status/CardSide;)V", "getCountryNameIco", "()Ljava/lang/String;", "getInitResult", "()Lcom/iqoption/dto/entity/iqbus/VerifyInitResult;", "getProgressSide", "setProgressSide", "getUserId", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "IqOption-5.5.1_optionXRelease"})
/* compiled from: PerformVerifyFragment.kt */
public final class l implements Parcelable {
    public static final Creator CREATOR = new a();
    private CardSide dyA;
    private final VerifyInitResult dyx;
    private final String dyy;
    private CardSide dyz;
    private final long userId;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            return new l(parcel.readLong(), (VerifyInitResult) VerifyInitResult.CREATOR.createFromParcel(parcel), parcel.readString(), (CardSide) Enum.valueOf(CardSide.class, parcel.readString()), (CardSide) Enum.valueOf(CardSide.class, parcel.readString()));
        }

        public final Object[] newArray(int i) {
            return new l[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            return ((this.userId > lVar.userId ? 1 : (this.userId == lVar.userId ? 0 : -1)) == 0 ? 1 : null) != null && h.E(this.dyx, lVar.dyx) && h.E(this.dyy, lVar.dyy) && h.E(this.dyz, lVar.dyz) && h.E(this.dyA, lVar.dyA);
        }
    }

    public int hashCode() {
        long j = this.userId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        VerifyInitResult verifyInitResult = this.dyx;
        int i2 = 0;
        i = (i + (verifyInitResult != null ? verifyInitResult.hashCode() : 0)) * 31;
        String str = this.dyy;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        CardSide cardSide = this.dyz;
        i = (i + (cardSide != null ? cardSide.hashCode() : 0)) * 31;
        cardSide = this.dyA;
        if (cardSide != null) {
            i2 = cardSide.hashCode();
        }
        return i + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VerifyState(userId=");
        stringBuilder.append(this.userId);
        stringBuilder.append(", initResult=");
        stringBuilder.append(this.dyx);
        stringBuilder.append(", countryNameIco=");
        stringBuilder.append(this.dyy);
        stringBuilder.append(", completedSide=");
        stringBuilder.append(this.dyz);
        stringBuilder.append(", progressSide=");
        stringBuilder.append(this.dyA);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeLong(this.userId);
        this.dyx.writeToParcel(parcel, 0);
        parcel.writeString(this.dyy);
        parcel.writeString(this.dyz.name());
        parcel.writeString(this.dyA.name());
    }

    public l(long j, VerifyInitResult verifyInitResult, String str, CardSide cardSide, CardSide cardSide2) {
        h.e(verifyInitResult, "initResult");
        h.e(str, "countryNameIco");
        h.e(cardSide, "completedSide");
        h.e(cardSide2, "progressSide");
        this.userId = j;
        this.dyx = verifyInitResult;
        this.dyy = str;
        this.dyz = cardSide;
        this.dyA = cardSide2;
    }

    public final long getUserId() {
        return this.userId;
    }

    public final VerifyInitResult aHq() {
        return this.dyx;
    }

    public final String aHr() {
        return this.dyy;
    }

    public final CardSide aHs() {
        return this.dyz;
    }

    public final void c(CardSide cardSide) {
        h.e(cardSide, "<set-?>");
        this.dyz = cardSide;
    }

    public final CardSide aHt() {
        return this.dyA;
    }

    public final void d(CardSide cardSide) {
        h.e(cardSide, "<set-?>");
        this.dyA = cardSide;
    }
}
