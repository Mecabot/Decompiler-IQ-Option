package com.iqoption.util.fragmentstack;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import com.iqoption.x.R;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\bJ\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\fH\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, aXE = {"Lcom/iqoption/util/fragmentstack/ActiveFragmentStackChangeListener;", "Landroid/support/v4/app/FragmentManager$OnBackStackChangedListener;", "fragmentManager", "Landroid/support/v4/app/FragmentManager;", "(Landroid/support/v4/app/FragmentManager;)V", "fragmentListenerMap", "Ljava/util/WeakHashMap;", "Landroid/support/v4/app/Fragment;", "Lcom/iqoption/util/fragmentstack/FragmentVisibilityChangeListener;", "getFragmentManager", "()Landroid/support/v4/app/FragmentManager;", "addFragmentVisibilityChangeListener", "", "fragment", "listener", "notifyInvisible", "notifyVisible", "onBackStackChanged", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ActiveFragmentStackChangeListener.kt */
public final class a implements OnBackStackChangedListener {
    private final FragmentManager cKu;
    private final WeakHashMap<Fragment, c> dwS = new WeakHashMap();

    public a(FragmentManager fragmentManager) {
        h.e(fragmentManager, "fragmentManager");
        this.cKu = fragmentManager;
    }

    public void onBackStackChanged() {
        Fragment findFragmentById = this.cKu.findFragmentById(R.id.fragmentContainer);
        if (findFragmentById != null) {
            List<Fragment> fragments = this.cKu.getFragments();
            fragments.remove(findFragmentById);
            h.d(fragments, "fragments");
            for (Fragment fragment : fragments) {
                h.d(fragment, "it");
                aa(fragment);
            }
            Z(findFragmentById);
        }
    }

    public final void a(Fragment fragment, c cVar) {
        h.e(fragment, "fragment");
        h.e(cVar, "listener");
        this.dwS.put(fragment, cVar);
    }

    private final void Z(Fragment fragment) {
        if (fragment instanceof c) {
            ((c) fragment).aGG();
        }
        c cVar = (c) this.dwS.get(fragment);
        if (cVar != null) {
            cVar.aGG();
        }
    }

    private final void aa(Fragment fragment) {
        if (fragment instanceof c) {
            ((c) fragment).aGH();
        }
        c cVar = (c) this.dwS.get(fragment);
        if (cVar != null) {
            cVar.aGH();
        }
    }
}
