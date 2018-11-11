package com.iqoption.fragment.cashbox.deppage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.a.q;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, aXE = {"setupFragment", "", "Landroid/support/v4/app/FragmentManager;", "supplier", "Lkotlin/Function0;", "Landroid/support/v4/app/Fragment;", "tag", "", "invoke"})
/* compiled from: DepositPageFragment.kt */
final class DepositPageFragment$onViewCreated$1$1 extends Lambda implements q<FragmentManager, a<? extends Fragment>, String, l> {
    public static final DepositPageFragment$onViewCreated$1$1 cyO = new DepositPageFragment$onViewCreated$1$1();

    DepositPageFragment$onViewCreated$1$1() {
        super(3);
    }

    public /* synthetic */ Object c(Object obj, Object obj2, Object obj3) {
        a((FragmentManager) obj, (a) obj2, (String) obj3);
        return l.etX;
    }

    public final void a(FragmentManager fragmentManager, a<? extends Fragment> aVar, String str) {
        h.e(fragmentManager, "$receiver");
        h.e(aVar, "supplier");
        h.e(str, "tag");
        fragmentManager.executePendingTransactions();
        if (fragmentManager.findFragmentByTag(str) == null) {
            fragmentManager.beginTransaction().replace(R.id.pageContentContainer, (Fragment) aVar.invoke(), str).commit();
        }
    }
}
