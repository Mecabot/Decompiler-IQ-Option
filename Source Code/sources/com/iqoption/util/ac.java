package com.iqoption.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.BackStackEntry;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v4.app.FragmentTransaction;
import com.google.common.base.j;
import com.iqoption.core.d.a;
import java.util.ArrayList;

/* compiled from: FragmentUtils */
public final class ac {
    public static final j<Fragment> dvn = ae.$instance;

    static final /* synthetic */ boolean Y(Fragment fragment) {
        return fragment != null && fragment.isAdded();
    }

    public static boolean c(FragmentManager fragmentManager, String str) {
        if (fragmentManager != null && str != null && fragmentManager.getBackStackEntryCount() == 0 && fragmentManager.findFragmentByTag(str) != null) {
            return true;
        }
        if (fragmentManager == null || fragmentManager.getBackStackEntryCount() <= 0 || str == null || !str.equals(fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName())) {
            return false;
        }
        return true;
    }

    @Nullable
    public static Fragment s(FragmentManager fragmentManager) {
        int backStackEntryCount = fragmentManager.getBackStackEntryCount();
        return backStackEntryCount > 0 ? fragmentManager.findFragmentByTag(fragmentManager.getBackStackEntryAt(backStackEntryCount - 1).getName()) : null;
    }

    @Nullable
    public static Fragment t(FragmentManager fragmentManager) {
        int backStackEntryCount = fragmentManager.getBackStackEntryCount();
        return backStackEntryCount > 1 ? fragmentManager.findFragmentByTag(fragmentManager.getBackStackEntryAt(backStackEntryCount - 2).getName()) : null;
    }

    @NonNull
    public static <T> Iterable<T> a(FragmentManager fragmentManager, Class<T> cls) {
        Iterable arrayList = new ArrayList();
        for (Fragment fragment : fragmentManager.getFragments()) {
            if (cls.isInstance(fragment)) {
                arrayList.add(cls.cast(fragment));
            }
        }
        return arrayList;
    }

    public static boolean d(FragmentManager fragmentManager, String str) {
        fragmentManager.executePendingTransactions();
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(str);
        return findFragmentByTag == null || findFragmentByTag.isRemoving();
    }

    public static void u(FragmentManager fragmentManager) {
        e(fragmentManager, null);
    }

    public static void e(FragmentManager fragmentManager, @Nullable String str) {
        if (fragmentManager.getBackStackEntryCount() != 0) {
            int i = 0;
            while (i < fragmentManager.getBackStackEntryCount()) {
                BackStackEntry backStackEntryAt = fragmentManager.getBackStackEntryAt(i);
                if (backStackEntryAt.getName() == null || str == null || !str.equals(backStackEntryAt.getName()) || !a(fragmentManager, str, 0)) {
                    i++;
                } else {
                    return;
                }
            }
            a(fragmentManager, null, 1);
        }
    }

    public static boolean v(@NonNull FragmentManager fragmentManager) {
        return a(fragmentManager, null, 0);
    }

    private static boolean a(@NonNull FragmentManager fragmentManager, String str, int i) {
        try {
            return fragmentManager.b(str, i);
        } catch (IllegalStateException unused) {
            if (!w(fragmentManager)) {
                return false;
            }
            try {
                fragmentManager.executePendingTransactions();
            } catch (IllegalStateException unused2) {
                a.aSe.postDelayed(new ad(fragmentManager, str, i), 0);
            }
            return true;
        }
    }

    private static boolean w(@NonNull FragmentManager fragmentManager) {
        if (fragmentManager.getBackStackEntryCount() == 0) {
            return false;
        }
        BackStackEntry backStackEntryAt = fragmentManager.getBackStackEntryAt(0);
        if (backStackEntryAt != null) {
            Fragment findFragmentByTag = fragmentManager.findFragmentByTag(backStackEntryAt.getName());
            if (findFragmentByTag != null) {
                FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                beginTransaction.remove(findFragmentByTag);
                beginTransaction.commitAllowingStateLoss();
                return true;
            }
        }
        return false;
    }

    public static void a(@NonNull final FragmentManager fragmentManager, @NonNull final kotlin.jvm.a.a<Boolean> aVar, @NonNull final Runnable runnable) {
        fragmentManager.addOnBackStackChangedListener(new OnBackStackChangedListener() {
            public void onBackStackChanged() {
                if (((Boolean) aVar.invoke()).booleanValue()) {
                    runnable.run();
                    fragmentManager.removeOnBackStackChangedListener(this);
                }
            }
        });
    }
}
