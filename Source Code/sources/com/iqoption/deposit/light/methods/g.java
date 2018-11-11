package com.iqoption.deposit.light.methods;

import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, aXE = {"Lcom/iqoption/deposit/light/methods/OnMethodCallbackLight;", "", "isSelected", "", "payMethod", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "onMethodClicked", "", "deposit_release"})
/* compiled from: MethodLightViewHolder.kt */
public interface g {
    void j(PayMethod payMethod);

    boolean k(PayMethod payMethod);
}
