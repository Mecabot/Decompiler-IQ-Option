package com.iqoption.fragment.cashbox;

import com.iqoption.app.a;
import com.iqoption.dto.Currencies.ConversionCurrency;
import java.math.BigDecimal;
import java.math.RoundingMode;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\fR\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, aXE = {"Lcom/iqoption/fragment/cashbox/DepositFeatureUtils;", "", "()V", "minDepositFeatureLimitUsd", "", "getMinDepositFeatureLimitUsd", "()Ljava/lang/Double;", "minDepositFeatureLimitUsd$delegate", "Lkotlin/Lazy;", "getMinDepositFeatureLimit", "ticker", "", "(Ljava/lang/String;)Ljava/lang/Double;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: DepositFeatureUtils.kt */
public final class e {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(e.class), "minDepositFeatureLimitUsd", "getMinDepositFeatureLimitUsd()Ljava/lang/Double;"))};
    private static final d cwA = g.f(DepositFeatureUtils$minDepositFeatureLimitUsd$2.cwC);
    public static final e cwB = new e();

    private final Double ake() {
        d dVar = cwA;
        j jVar = apP[0];
        return (Double) dVar.getValue();
    }

    private e() {
    }

    public static final Double hK(String str) {
        h.e(str, "ticker");
        Double ake = cwB.ake();
        Double d = null;
        if (ake == null) {
            return null;
        }
        double doubleValue = ake.doubleValue();
        ConversionCurrency eh = a.Cw().eh(str);
        if (eh != null) {
            BigDecimal valueOf = BigDecimal.valueOf(doubleValue);
            Double d2 = eh.rateUsd;
            h.d(d2, "it.rateUsd");
            d = Double.valueOf(valueOf.divide(BigDecimal.valueOf(d2.doubleValue()), -1, RoundingMode.HALF_UP).doubleValue());
        }
        return d;
    }
}
