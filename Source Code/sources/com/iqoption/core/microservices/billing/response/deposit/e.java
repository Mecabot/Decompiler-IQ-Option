package com.iqoption.core.microservices.billing.response.deposit;

import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\n\u0010\u0006\u001a\u00020\u0002*\u00020\u0007\u001a\n\u0010\b\u001a\u00020\t*\u00020\u0007\u001a\n\u0010\n\u001a\u00020\t*\u00020\u0007\u001a\n\u0010\u000b\u001a\u00020\t*\u00020\u0007\u001a\n\u0010\f\u001a\u00020\t*\u00020\u0007\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, aXE = {"ADD_NEW_CARD_METHODS", "", "", "CARD_UI_METHODS", "HIDDEN_CARD_SCAN_METHODS", "HIDDEN_HOLDER_METHODS", "getUniqueId", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "isNewCard", "", "shouldHideCardHolder", "shouldHideCardScan", "shouldShowCardUi", "core_release"})
/* compiled from: PayMethodExtensions.kt */
public final class e {
    private static final List<String> aTF = l.cr("bank_card");
    private static final List<String> aTG = m.listOf("bank_card", "astropay_card");
    private static final List<String> aTH = l.cr("astropay_card");
    private static final List<String> aTI = l.cr("astropay_card");

    public static final boolean a(PayMethod payMethod) {
        h.e(payMethod, "$receiver");
        return (payMethod instanceof g) && u.b((Iterable) aTF, (Object) ((g) payMethod).UZ());
    }

    public static final boolean b(PayMethod payMethod) {
        h.e(payMethod, "$receiver");
        return (payMethod instanceof g) && u.b((Iterable) aTG, (Object) ((g) payMethod).UZ());
    }

    public static final boolean c(PayMethod payMethod) {
        h.e(payMethod, "$receiver");
        return (payMethod instanceof g) && u.b((Iterable) aTH, (Object) ((g) payMethod).UZ());
    }

    public static final boolean d(PayMethod payMethod) {
        h.e(payMethod, "$receiver");
        return (payMethod instanceof g) && u.b((Iterable) aTI, (Object) ((g) payMethod).UZ());
    }

    public static final String e(PayMethod payMethod) {
        h.e(payMethod, "$receiver");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(payMethod.UQ());
        stringBuilder.append(':');
        stringBuilder.append(payMethod.UR());
        return stringBuilder.toString();
    }
}
