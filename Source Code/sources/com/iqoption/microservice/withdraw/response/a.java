package com.iqoption.microservice.withdraw.response;

import android.os.Parcelable;
import java.util.List;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0018\u001a\u00020\u0015H&J\b\u0010\u0019\u001a\u00020\u001aH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, aXE = {"Lcom/iqoption/microservice/withdraw/response/BaseWithdrawMethod;", "Landroid/os/Parcelable;", "commission", "", "getCommission", "()D", "fields", "", "Lcom/iqoption/microservice/withdraw/response/PayoutField;", "getFields", "()Ljava/util/List;", "limits", "Lcom/iqoption/microservice/withdraw/response/WithdrawLimit;", "getLimits", "maxLimit", "Lcom/iqoption/withdrawal/common/AmountLimit;", "getMaxLimit", "()Lcom/iqoption/withdrawal/common/AmountLimit;", "setMaxLimit", "(Lcom/iqoption/withdrawal/common/AmountLimit;)V", "name", "", "getName", "()Ljava/lang/String;", "methodId", "type", "Lcom/iqoption/microservice/withdraw/response/WithdrawMethodType;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawMethod.kt */
public interface a extends Parcelable {
    WithdrawMethodType att();

    String atu();

    double atv();

    List<f> atw();

    List<g> atx();

    com.iqoption.withdrawal.common.a aty();

    String getName();
}
