package com.iqoption.core.ui.navigation;

import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.core.ext.a;
import com.iqoption.core.ui.fragment.b;
import java.util.HashMap;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0011H&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@BX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, aXE = {"Lcom/iqoption/core/ui/navigation/BaseSlotStackNavigatorFragment;", "Lcom/iqoption/core/ui/fragment/IQFragment;", "()V", "<set-?>", "Lcom/iqoption/core/ui/navigation/SlotNavigator;", "slotNavigator", "getSlotNavigator", "()Lcom/iqoption/core/ui/navigation/SlotNavigator;", "setSlotNavigator", "(Lcom/iqoption/core/ui/navigation/SlotNavigator;)V", "Lcom/iqoption/core/ui/navigation/StackNavigator;", "stackNavigator", "getStackNavigator", "()Lcom/iqoption/core/ui/navigation/StackNavigator;", "setStackNavigator", "(Lcom/iqoption/core/ui/navigation/StackNavigator;)V", "getSlotContainerId", "", "getStackContainerId", "getStackInitialEntry", "Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "core_release"})
/* compiled from: BaseSlotStackNavigatorFragment.kt */
public abstract class d extends b {
    private HashMap atz;
    private j bbH;
    private i bbI;

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public abstract int YQ();

    public abstract h YR();

    public abstract int YS();

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

    protected final j YP() {
        j jVar = this.bbH;
        if (jVar == null) {
            h.lS("stackNavigator");
        }
        return jVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Lifecycle lifecycle = getLifecycle();
        FragmentActivity n = a.n(this);
        if (n == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.iqoption.core.ui.navigation.BackController");
        }
        lifecycle.a(new BaseSlotStackNavigatorFragment$onCreate$1(this, (a) n));
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.bbH = new j(a.m(this), a.q(this), YQ());
        this.bbI = new i(a.m(this), a.q(this), YS());
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        if (bundle == null) {
            h YR = YR();
            if (YR != null) {
                j jVar = this.bbH;
                if (jVar == null) {
                    h.lS("stackNavigator");
                }
                if (!jVar.b(YR)) {
                    jVar = this.bbH;
                    if (jVar == null) {
                        h.lS("stackNavigator");
                    }
                    jVar.a(YR, true);
                }
            }
        }
    }
}
