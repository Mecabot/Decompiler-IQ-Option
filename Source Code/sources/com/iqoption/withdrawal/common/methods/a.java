package com.iqoption.withdrawal.common.methods;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.iqoption.dto.Balance;
import com.iqoption.dto.Currencies.ConversionCurrency;
import com.iqoption.dto.entity.position.Order;
import com.iqoption.microservice.withdraw.response.c;
import com.iqoption.microservice.withdraw.response.g;
import com.iqoption.util.l;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\tJ\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0016J'\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010 J\u0006\u0010!\u001a\u00020\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\""}, aXE = {"Lcom/iqoption/withdrawal/common/methods/BalanceHolder;", "", "context", "Landroid/content/Context;", "balance", "Lcom/iqoption/dto/Balance;", "conversion", "Lcom/iqoption/dto/Currencies$ConversionCurrency;", "amountToRefund", "", "(Landroid/content/Context;Lcom/iqoption/dto/Balance;Lcom/iqoption/dto/Currencies$ConversionCurrency;D)V", "getAmountToRefund", "()D", "getBalance", "()Lcom/iqoption/dto/Balance;", "getContext", "()Landroid/content/Context;", "getConversion", "()Lcom/iqoption/dto/Currencies$ConversionCurrency;", "findWithdrawMethodLimitForCurrency", "Lcom/iqoption/microservice/withdraw/response/WithdrawLimit;", "method", "Lcom/iqoption/microservice/withdraw/response/BaseWithdrawMethod;", "formatAmountWithWalletMask", "", "limit", "Lcom/iqoption/withdrawal/common/AmountLimit;", "amount", "getAmountUpperLimit", "commission", "refundAmount", "withMethodLimit", "(DLjava/lang/Double;Lcom/iqoption/microservice/withdraw/response/WithdrawLimit;)Lcom/iqoption/withdrawal/common/AmountLimit;", "getFormattedAmountToRefund", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawMethodsViewModel.kt */
final class a {
    private final Context context;
    private final Balance dQf;
    private final ConversionCurrency dQg;
    private final double dRy;

    public a(Context context, Balance balance, ConversionCurrency conversionCurrency, double d) {
        h.e(context, "context");
        h.e(balance, "balance");
        h.e(conversionCurrency, "conversion");
        this.context = context;
        this.dQf = balance;
        this.dQg = conversionCurrency;
        this.dRy = d;
    }

    public final com.iqoption.withdrawal.common.a c(com.iqoption.microservice.withdraw.response.a aVar) {
        h.e(aVar, b.METHOD);
        Double d = null;
        c cVar = (c) (!(aVar instanceof c) ? null : aVar);
        if (cVar != null) {
            d = Double.valueOf(cVar.atz());
        }
        return a(aVar.atv(), d, d(aVar));
    }

    public final com.iqoption.withdrawal.common.a a(double d, Double d2, g gVar) {
        return com.iqoption.withdrawal.common.b.a(this.dQf.getAmountRequired(), d, this.dQg, d2, gVar);
    }

    public final g d(com.iqoption.microservice.withdraw.response.a aVar) {
        h.e(aVar, b.METHOD);
        if (!(aVar instanceof com.iqoption.microservice.withdraw.response.h)) {
            return null;
        }
        List atx = aVar.atx();
        if (atx == null) {
            return null;
        }
        for (Object next : atx) {
            if (h.E(((g) next).getName(), this.dQg.name)) {
                break;
            }
        }
        Object next2 = null;
        return (g) next2;
    }

    public final String aNP() {
        String e = l.e(this.dQg.mask, Double.valueOf(this.dRy));
        if (e == null) {
            h.aXZ();
        }
        return e;
    }

    public final String a(com.iqoption.withdrawal.common.a aVar) {
        h.e(aVar, Order.LIMIT);
        return M(aVar.getValue());
    }

    public final String M(double d) {
        String e = l.e(this.dQg.mask, Double.valueOf(d));
        h.d(e, "CurrencyUtils.formatedAm…(conversion.mask, amount)");
        return e;
    }
}
