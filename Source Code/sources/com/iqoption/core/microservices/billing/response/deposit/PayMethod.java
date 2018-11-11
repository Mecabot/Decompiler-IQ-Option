package com.iqoption.core.microservices.billing.response.deposit;

import android.os.Parcelable;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u000fJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\rH&¨\u0006\u0010"}, aXE = {"Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "Landroid/os/Parcelable;", "getImageUrl", "", "getName", "getPayCardId", "", "()Ljava/lang/Long;", "getPayMethodId", "getPaymentMethod3dsId", "getType", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod$PayMethodType;", "isDefault3ds", "", "isKycRestricted", "PayMethodType", "core_release"})
/* compiled from: PayMethod.kt */
public interface PayMethod extends Parcelable {

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, aXE = {"Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod$PayMethodType;", "", "(Ljava/lang/String;I)V", "UserCard", "PaymentMethod", "core_release"})
    /* compiled from: PayMethod.kt */
    public enum PayMethodType {
        UserCard,
        PaymentMethod
    }

    long UQ();

    Long UR();

    String US();

    PayMethodType UT();

    boolean UU();

    boolean UV();

    long UW();

    String getName();
}
