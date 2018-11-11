package com.iqoption.deposit.dark;

import android.view.View;
import com.iqoption.core.f;
import com.iqoption.core.ui.navigation.j;
import com.iqoption.deposit.c.c;
import com.iqoption.deposit.menu.method.d;
import com.iqoption.deposit.menu.method.e;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "invoke"})
/* compiled from: DepositFragment.kt */
final class DepositFragment$payMethodClickListener$1 extends Lambda implements b<View, l> {
    final /* synthetic */ b this$0;

    DepositFragment$payMethodClickListener$1(b bVar) {
        this.this$0 = bVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        H((View) obj);
        return l.etX;
    }

    public final void H(View view) {
        h.e(view, "<anonymous parameter 0>");
        com.iqoption.core.microservices.billing.response.deposit.b c = this.this$0.aTd;
        if (c != null) {
            j.b(com.iqoption.deposit.navigator.b.cbG.G(this.this$0), d.cbx.a(new e(c.UG(), c.UH(), this.this$0.abQ(), this.this$0.bXu)), false, 2, null);
            view = this.this$0.getView();
            if (view != null) {
                view = view.findFocus();
                if (view != null) {
                    view.clearFocus();
                }
            }
            f.RQ().Ds().c("deposit-page_deposit-method", 0.0d, c.ceC.aeh());
        }
    }
}
