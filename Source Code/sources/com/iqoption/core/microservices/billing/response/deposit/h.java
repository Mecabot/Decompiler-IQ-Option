package com.iqoption.core.microservices.billing.response.deposit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.common.base.j;
import com.google.gson.annotations.SerializedName;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod.PayMethodType;
import kotlin.TypeCastException;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000fJ\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0006\u0010\u001a\u001a\u00020\u0006J\u0006\u0010\u001b\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u0019J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\r\u0010\u001f\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u0003H\u0016J\b\u0010\"\u001a\u00020\u0003H\u0016J\b\u0010#\u001a\u00020$H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010%\u001a\u00020\nH\u0016J\u0006\u0010&\u001a\u00020\nJ\u0019\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0019HÖ\u0001R\u0012\u0010\r\u001a\u0004\u0018\u00010\u00068\u0002X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0002X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00038\u0002X\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013¨\u0006-"}, aXE = {"Lcom/iqoption/core/microservices/billing/response/deposit/UserCard;", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "paymentMethodId", "", "cardId", "cardNumber", "", "cardIcon", "iconUrl", "isDefault3ds", "", "kycRestricted", "paymentMethod3dsId", "_cardHolder", "expiryDate", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getCardIcon", "()Ljava/lang/String;", "getCardId", "()J", "getCardNumber", "Ljava/lang/Boolean;", "Ljava/lang/Long;", "getPaymentMethodId", "describeContents", "", "getCardHolder", "getExpiryMonth", "getExpiryYear", "getImageUrl", "getName", "getPayCardId", "()Ljava/lang/Long;", "getPayMethodId", "getPaymentMethod3dsId", "getType", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod$PayMethodType;", "isKycRestricted", "isValidDate", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "core_release"})
/* compiled from: UserCard.kt */
public final class h implements PayMethod {
    public static final Creator CREATOR = new c();
    public static final j<h> aTY = b.aUa;
    public static final a aTZ = new a();
    @SerializedName("card_icon")
    private final String aTO;
    @SerializedName("kyc_restricted")
    private final Boolean aTP;
    @SerializedName("payment_method_id")
    private final long aTT;
    @SerializedName("card_id")
    private final long aTU;
    @SerializedName("default_3ds")
    private final Boolean aTV;
    @SerializedName("payment_method_3ds_id")
    private final Long aTW;
    @SerializedName("card_holder")
    private final String aTX;
    @SerializedName("card_number")
    private final String cardNumber;
    @SerializedName("expiry_date")
    private final String expiryDate;
    @SerializedName("icon_url")
    private final String iconUrl;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, aXE = {"Lcom/iqoption/core/microservices/billing/response/deposit/UserCard$Companion;", "", "()V", "hasPaymentMethod3dsId", "Lcom/google/common/base/Predicate;", "Lcom/iqoption/core/microservices/billing/response/deposit/UserCard;", "core_release"})
    /* compiled from: UserCard.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11})
    public static class c implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Boolean valueOf2;
            kotlin.jvm.internal.h.e(parcel, "in");
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
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
            return new h(readLong, readLong2, readString, readString2, readString3, valueOf, valueOf2, parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new h[i];
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "card", "Lcom/iqoption/core/microservices/billing/response/deposit/UserCard;", "apply"})
    /* compiled from: UserCard.kt */
    static final class b<T> implements j<h> {
        public static final b aUa = new b();

        b() {
        }

        /* renamed from: a */
        public final boolean apply(h hVar) {
            if (hVar == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            return hVar.UW() != -1;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        kotlin.jvm.internal.h.e(parcel, "parcel");
        parcel.writeLong(this.aTT);
        parcel.writeLong(this.aTU);
        parcel.writeString(this.cardNumber);
        parcel.writeString(this.aTO);
        parcel.writeString(this.iconUrl);
        Boolean bool = this.aTV;
        if (bool != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue());
        } else {
            parcel.writeInt(0);
        }
        bool = this.aTP;
        if (bool != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue());
        } else {
            parcel.writeInt(0);
        }
        Long l = this.aTW;
        if (l != null) {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.aTX);
        parcel.writeString(this.expiryDate);
    }

    public h(long j, long j2, String str, String str2, String str3, Boolean bool, Boolean bool2, Long l, String str4, String str5) {
        kotlin.jvm.internal.h.e(str, "cardNumber");
        kotlin.jvm.internal.h.e(str2, "cardIcon");
        kotlin.jvm.internal.h.e(str3, "iconUrl");
        this.aTT = j;
        this.aTU = j2;
        this.cardNumber = str;
        this.aTO = str2;
        this.iconUrl = str3;
        this.aTV = bool;
        this.aTP = bool2;
        this.aTW = l;
        this.aTX = str4;
        this.expiryDate = str5;
    }

    public final long Vf() {
        return this.aTU;
    }

    public final String Vg() {
        return this.cardNumber;
    }

    public final int Vc() {
        if (this.expiryDate == null || v.a((CharSequence) this.expiryDate, '/', 0, false, 6, null) == -1) {
            return -1;
        }
        Integer valueOf;
        try {
            int a = v.a((CharSequence) this.expiryDate, '/', 0, false, 6, null);
            String str = this.expiryDate;
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String substring = str.substring(0, a);
            kotlin.jvm.internal.h.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            valueOf = Integer.valueOf(substring);
            kotlin.jvm.internal.h.d(valueOf, "Integer.valueOf(expiryDate.substring(0, indexOf))");
            return valueOf.intValue();
        } catch (Exception unused) {
            valueOf = Integer.valueOf(-1);
        }
    }

    public final int Vd() {
        if (!(this.expiryDate == null || v.a((CharSequence) this.expiryDate, '/', 0, false, 6, null) == -1)) {
            try {
                int a = v.a((CharSequence) this.expiryDate, '/', 0, false, 6, null);
                int length = this.expiryDate.length();
                a++;
                if (a < length) {
                    String str = this.expiryDate;
                    if (str == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    String substring = str.substring(a, length);
                    kotlin.jvm.internal.h.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Integer valueOf = Integer.valueOf(substring);
                    kotlin.jvm.internal.h.d(valueOf, "Integer.valueOf(expiryDa…ing(indexOf + 1, length))");
                    return valueOf.intValue();
                }
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    public final String Ve() {
        String str = this.aTX;
        return str != null ? str : "";
    }

    public long UQ() {
        return this.aTT;
    }

    public Long UR() {
        return Long.valueOf(this.aTU);
    }

    public String getName() {
        return this.cardNumber;
    }

    public String US() {
        return TextUtils.isEmpty((CharSequence) this.iconUrl) ? this.aTO : this.iconUrl;
    }

    public PayMethodType UT() {
        return PayMethodType.UserCard;
    }

    public boolean UU() {
        return this.aTP != null && this.aTP.booleanValue();
    }

    public boolean UV() {
        Boolean bool = this.aTV;
        return bool != null ? bool.booleanValue() : false;
    }

    public long UW() {
        Long l = this.aTW;
        return l != null ? l.longValue() : -1;
    }
}
