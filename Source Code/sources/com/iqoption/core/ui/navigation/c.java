package com.iqoption.core.ui.navigation;

import android.os.Bundle;
import android.view.View;
import com.iqoption.core.ext.a;
import com.iqoption.core.ui.fragment.b;
import java.util.HashMap;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH&J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, aXE = {"Lcom/iqoption/core/ui/navigation/BaseSlotNavigatorFragment;", "Lcom/iqoption/core/ui/fragment/IQFragment;", "()V", "<set-?>", "Lcom/iqoption/core/ui/navigation/SlotNavigator;", "navigator", "getNavigator", "()Lcom/iqoption/core/ui/navigation/SlotNavigator;", "setNavigator", "(Lcom/iqoption/core/ui/navigation/SlotNavigator;)V", "getContainerId", "", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "core_release"})
/* compiled from: BaseSlotNavigatorFragment.kt */
public abstract class c extends b {
    private HashMap atz;
    private i bbG;

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public abstract int YO();

    public View dj(int i) {
        if (this.atz == null) {
            this.atz = new HashMap();
        }
        View view = (View) this.atz.get(Integer.valueOf(i));
        if (view == null) {
            view = getView();
            if (view == null) {
                return null;
            }
            view = view.findViewById(i);
            this.atz.put(Integer.valueOf(i), view);
        }
        return view;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    protected final i YN() {
        i iVar = this.bbG;
        if (iVar == null) {
            h.lS("navigator");
        }
        return iVar;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.bbG = new i(a.m(this), a.q(this), YO());
    }
}
