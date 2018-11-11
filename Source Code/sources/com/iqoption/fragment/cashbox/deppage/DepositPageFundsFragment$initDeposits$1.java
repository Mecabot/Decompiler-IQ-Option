package com.iqoption.fragment.cashbox.deppage;

import android.support.v7.widget.AppCompatSpinner2;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.core.microservices.billing.response.deposit.b;
import com.iqoption.core.microservices.billing.response.deposit.c;
import com.iqoption.core.microservices.billing.response.deposit.g;
import com.iqoption.d.gt;
import com.iqoption.fragment.cashbox.f;
import kotlin.i;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"onSuccess", "", "Lcom/iqoption/fragment/cashbox/deppage/DepositPageFundsFragment;", "cashboxCounting", "Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;", "invoke"})
/* compiled from: DepositPageFundsFragment.kt */
final class DepositPageFundsFragment$initDeposits$1 extends Lambda implements m<d, b, l> {
    public static final DepositPageFundsFragment$initDeposits$1 czc = new DepositPageFundsFragment$initDeposits$1();

    DepositPageFundsFragment$initDeposits$1() {
        super(2);
    }

    public /* synthetic */ Object B(Object obj, Object obj2) {
        b((d) obj, (b) obj2);
        return l.etX;
    }

    public final void b(d dVar, b bVar) {
        d dVar2 = dVar;
        h.e(dVar2, "$receiver");
        b bVar2 = bVar;
        h.e(bVar2, "cashboxCounting");
        if (dVar.isAdded()) {
            gt b = d.b(dVar);
            c UI = bVar.UI();
            double g = dVar.akM();
            if (UI == null) {
                h.aXZ();
            }
            Math.min(Math.max(g, UI.UM()), UI.UN());
            f fVar = r2;
            f fVar2 = new f(dVar.getContext(), bVar2, b.bpl, b.bqm, b.bqe, b.bpI, b.bpo, b.bql, b.bpn, b.bpg, null, bVar.UK(), bVar.UL(), b.bqn);
            dVar2.cxy = fVar;
            AppCompatSpinner2 appCompatSpinner2 = b.bpX;
            h.d(appCompatSpinner2, "paymentMethodSpinner");
            PayMethod payMethod = (PayMethod) appCompatSpinner2.getSelectedItem();
            if (payMethod != null) {
                g a = dVar2.bn(payMethod.UQ());
                f a2 = dVar.cxy;
                if (!(a == null || a2 == null)) {
                    a2.a(a);
                }
            }
            d.cyS.a(payMethod, dVar2);
        }
    }
}
