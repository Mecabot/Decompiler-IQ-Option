package com.iqoption.core.ui.navigation;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import kotlin.jvm.internal.h;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, aXE = {"Lcom/iqoption/core/ui/navigation/SlotNavigator;", "", "context", "Landroid/content/Context;", "fm", "Landroid/support/v4/app/FragmentManager;", "container", "", "(Landroid/content/Context;Landroid/support/v4/app/FragmentManager;I)V", "getContainer", "()I", "getContext", "()Landroid/content/Context;", "getFm", "()Landroid/support/v4/app/FragmentManager;", "swap", "", "entry", "Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "core_release"})
/* compiled from: SlotNavigator.kt */
public final class i {
    private final FragmentManager bbS;
    private final int container;
    private final Context context;

    public i(Context context, FragmentManager fragmentManager, @IdRes int i) {
        h.e(context, "context");
        h.e(fragmentManager, "fm");
        this.context = context;
        this.bbS = fragmentManager;
        this.container = i;
    }

    public final void a(h hVar) {
        h.e(hVar, "entry");
        Fragment findFragmentById = this.bbS.findFragmentById(this.container);
        if (findFragmentById == null || !findFragmentById.isAdded() || !h.E(findFragmentById.getTag(), hVar.getName())) {
            FragmentManager fragmentManager = this.bbS;
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            h.d(beginTransaction, "ft");
            Object obj = null;
            Object obj2 = (hVar.YV() == -1 || hVar.YW() == -1) ? null : 1;
            if (obj2 != null) {
                if (!(hVar.YX() == -1 || hVar.YY() == -1)) {
                    obj = 1;
                }
                if (obj != null) {
                    beginTransaction.setCustomAnimations(hVar.YV(), hVar.YW(), hVar.YX(), hVar.YY());
                } else {
                    beginTransaction.setCustomAnimations(hVar.YV(), hVar.YW());
                }
            }
            beginTransaction.replace(this.container, hVar.bf(this.context), hVar.getName());
            beginTransaction.commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
        }
    }
}
