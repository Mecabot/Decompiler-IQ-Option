package com.iqoption.deposit;

import com.iqoption.core.microservices.billing.response.deposit.d;
import com.iqoption.core.util.c;
import java.math.BigDecimal;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0001¨\u0006\u0006"}, aXE = {"formatDeposit", "", "Lcom/iqoption/core/microservices/billing/response/deposit/Deposit;", "hasSameAmount", "", "amount", "deposit_release"})
/* compiled from: DepositExtesions.kt */
public final class h {
    public static final String a(d dVar) {
        kotlin.jvm.internal.h.e(dVar, "$receiver");
        return c.a(new BigDecimal(dVar.UO()), 0, null, true, false, null, 19, null);
    }

    public static final boolean a(d dVar, String str) {
        kotlin.jvm.internal.h.e(dVar, "$receiver");
        kotlin.jvm.internal.h.e(str, "amount");
        return kotlin.jvm.internal.h.E(a(dVar), str);
    }
}
