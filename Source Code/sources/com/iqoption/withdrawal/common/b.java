package com.iqoption.withdrawal.common;

import com.iqoption.dto.Currencies.ConversionCurrency;
import com.iqoption.microservice.withdraw.response.g;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u001a9\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, aXE = {"convertAmount", "", "amount", "conversionCurrency", "Lcom/iqoption/dto/Currencies$ConversionCurrency;", "getAmountLowerLimit", "Lcom/iqoption/withdrawal/common/AmountLimit;", "withdrawMethodLimit", "Lcom/iqoption/microservice/withdraw/response/WithdrawLimit;", "getAmountUpperLimit", "walletAmount", "commission", "fiatConversion", "refundAmount", "(DDLcom/iqoption/dto/Currencies$ConversionCurrency;Ljava/lang/Double;Lcom/iqoption/microservice/withdraw/response/WithdrawLimit;)Lcom/iqoption/withdrawal/common/AmountLimit;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: AmountLimits.kt */
public final class b {

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, aXE = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    /* compiled from: Comparisons.kt */
    public static final class a<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return b.c(Double.valueOf(((a) t).getValue()), Double.valueOf(((a) t2).getValue()));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, aXE = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    /* compiled from: Comparisons.kt */
    public static final class b<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return b.c(Double.valueOf(((a) t).getValue()), Double.valueOf(((a) t2).getValue()));
        }
    }

    public static final a a(double d, double d2, ConversionCurrency conversionCurrency, Double d3, g gVar) {
        List arrayList = new ArrayList();
        double d4 = (double) 0;
        if (d2 > d4 && conversionCurrency != null) {
            d2 = b(d2, conversionCurrency);
        }
        arrayList.add(new a(Math.max(0.0d, d - d2), LimitType.WALLET_AMOUNT, LimitDirection.UPPER));
        if (d3 != null) {
            arrayList.add(new a(d3.doubleValue(), LimitType.CARD_REFUND_LIMIT, LimitDirection.UPPER));
        }
        if (gVar != null) {
            d = gVar.getMax();
            if (d > d4) {
                arrayList.add(new a(d, LimitType.WITHDRAW_METHOD_LIMIT, LimitDirection.UPPER));
            }
        }
        if (arrayList.size() > 1) {
            q.a(arrayList, new b());
        }
        return (a) u.bU(arrayList);
    }

    public static final a a(g gVar) {
        List arrayList = new ArrayList();
        if (gVar != null) {
            arrayList.add(new a(gVar.getMin(), LimitType.WITHDRAW_METHOD_LIMIT, LimitDirection.LOWER));
        } else {
            arrayList.add(new a(0.0d, LimitType.WITHDRAW_METHOD_LIMIT, LimitDirection.LOWER));
        }
        if (arrayList.size() > 1) {
            q.a(arrayList, new a());
        }
        return (a) u.bW(arrayList);
    }

    public static final double b(double d, ConversionCurrency conversionCurrency) {
        if (conversionCurrency == null) {
            return d;
        }
        BigDecimal valueOf = BigDecimal.valueOf(d);
        Double d2 = conversionCurrency.rateUsd;
        h.d(d2, "conversionCurrency.rateUsd");
        return valueOf.divide(BigDecimal.valueOf(d2.doubleValue()), 2, RoundingMode.UP).doubleValue();
    }
}
