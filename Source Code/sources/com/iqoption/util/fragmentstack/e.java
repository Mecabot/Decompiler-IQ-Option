package com.iqoption.util.fragmentstack;

import android.support.v4.app.Fragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, aXE = {"Lcom/iqoption/util/fragmentstack/VisibilityAwareFragment;", "Landroid/support/v4/app/Fragment;", "Lcom/iqoption/util/fragmentstack/FragmentVisibilityChangeListener;", "Lcom/iqoption/util/fragmentstack/FragmentVisibilityChangeHolder;", "()V", "listeners", "", "addFragmentVisibilityChangeListener", "", "listener", "onInvisible", "onVisible", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VisibilityAwareFragment.kt */
public class e extends Fragment implements c {
    private HashMap atz;
    private final List<c> ln = new ArrayList();

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    public void a(c cVar) {
        h.e(cVar, "listener");
        this.ln.add(cVar);
    }

    public void aGG() {
        for (c aGG : this.ln) {
            aGG.aGG();
        }
    }

    public void aGH() {
        for (c aGH : this.ln) {
            aGH.aGH();
        }
    }
}
