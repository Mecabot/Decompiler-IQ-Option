package com.iqoption.fragment.cashbox.deppage;

import android.widget.Spinner;
import com.google.common.base.f;
import com.iqoption.core.microservices.billing.response.deposit.b;
import com.iqoption.core.microservices.billing.response.deposit.c;
import com.iqoption.fragment.cashbox.d;
import kotlin.i;
import kotlin.jvm.a.q;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, aXE = {"setSelectedCurrency", "", "cashboxCounting", "Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;", "spinner", "Landroid/widget/Spinner;", "adapter", "Lcom/iqoption/fragment/cashbox/DepositCurrencyAdapter;", "invoke"})
/* compiled from: DepositPageFundsFragment.kt */
final class DepositPageFundsFragment$initCurrencies$1 extends Lambda implements q<b, Spinner, d, l> {
    public static final DepositPageFundsFragment$initCurrencies$1 cyV = new DepositPageFundsFragment$initCurrencies$1();

    DepositPageFundsFragment$initCurrencies$1() {
        super(3);
    }

    public /* synthetic */ Object c(Object obj, Object obj2, Object obj3) {
        a((b) obj, (Spinner) obj2, (d) obj3);
        return l.etX;
    }

    public final void a(b bVar, Spinner spinner, d dVar) {
        h.e(bVar, "cashboxCounting");
        h.e(spinner, "spinner");
        h.e(dVar, "adapter");
        c UI = bVar.UI();
        if (UI != null) {
            int count = dVar.getCount();
            for (int i = 0; i < count; i++) {
                if (f.equal(Long.valueOf(dVar.getItem(i).getId()), Long.valueOf(UI.getId()))) {
                    spinner.setSelection(i);
                    return;
                }
            }
        }
    }
}
