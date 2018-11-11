package com.iqoption.core.ui.navigation;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u0011\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0017\u001a\u00020\u0014J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0014J\u0018\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u001c\u0010\u001c\u001a\u00020\u0010*\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0014H\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001f"}, aXE = {"Lcom/iqoption/core/ui/navigation/StackNavigator;", "", "context", "Landroid/content/Context;", "fm", "Landroid/support/v4/app/FragmentManager;", "container", "", "(Landroid/content/Context;Landroid/support/v4/app/FragmentManager;I)V", "getContainer", "()I", "getContext", "()Landroid/content/Context;", "getFm", "()Landroid/support/v4/app/FragmentManager;", "add", "", "entry", "Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "isRoot", "", "contains", "exists", "pop", "tag", "", "isInclusive", "replace", "setupNavAction", "Landroid/support/v4/app/FragmentTransaction;", "addToBackStack", "core_release"})
/* compiled from: StackNavigator.kt */
public final class j {
    private final FragmentManager bbS;
    private final int container;
    private final Context context;

    public j(Context context, FragmentManager fragmentManager, @IdRes int i) {
        h.e(context, "context");
        h.e(fragmentManager, "fm");
        this.context = context;
        this.bbS = fragmentManager;
        this.container = i;
    }

    public static /* bridge */ /* synthetic */ void a(j jVar, h hVar, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        jVar.a(hVar, z);
    }

    public final void a(h hVar, boolean z) {
        h.e(hVar, "entry");
        FragmentManager fragmentManager = this.bbS;
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        h.d(beginTransaction, "ft");
        a(beginTransaction, hVar, z ^ 1);
        beginTransaction.replace(this.container, hVar.bf(this.context), hVar.getName());
        beginTransaction.commitAllowingStateLoss();
        fragmentManager.executePendingTransactions();
    }

    public static /* bridge */ /* synthetic */ void b(j jVar, h hVar, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        jVar.b(hVar, z);
    }

    public final void b(h hVar, boolean z) {
        h.e(hVar, "entry");
        FragmentManager fragmentManager = this.bbS;
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        h.d(beginTransaction, "ft");
        a(beginTransaction, hVar, z ^ 1);
        beginTransaction.add(this.container, hVar.bf(this.context), hVar.getName());
        beginTransaction.commitAllowingStateLoss();
        fragmentManager.executePendingTransactions();
    }

    public final boolean pop() {
        return this.bbS.popBackStackImmediate();
    }

    private final void a(FragmentTransaction fragmentTransaction, h hVar, boolean z) {
        if (z) {
            fragmentTransaction.addToBackStack(hVar.getName());
        }
        Object obj = null;
        Object obj2 = (hVar.YV() == -1 || hVar.YW() == -1) ? null : 1;
        if (obj2 != null) {
            if (!(hVar.YX() == -1 || hVar.YY() == -1)) {
                obj = 1;
            }
            if (obj != null) {
                fragmentTransaction.setCustomAnimations(hVar.YV(), hVar.YW(), hVar.YX(), hVar.YY());
            } else {
                fragmentTransaction.setCustomAnimations(hVar.YV(), hVar.YW());
            }
        }
    }

    public final boolean b(h hVar) {
        h.e(hVar, "entry");
        Fragment findFragmentByTag = this.bbS.findFragmentByTag(hVar.getName());
        return findFragmentByTag != null && findFragmentByTag.isAdded();
    }
}
