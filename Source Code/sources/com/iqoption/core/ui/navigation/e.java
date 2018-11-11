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

@i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH&J\n\u0010\f\u001a\u0004\u0018\u00010\rH&J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001a"}, aXE = {"Lcom/iqoption/core/ui/navigation/BaseStackNavigatorFragment;", "Lcom/iqoption/core/ui/fragment/IQFragment;", "()V", "<set-?>", "Lcom/iqoption/core/ui/navigation/StackNavigator;", "navigator", "getNavigator", "()Lcom/iqoption/core/ui/navigation/StackNavigator;", "setNavigator", "(Lcom/iqoption/core/ui/navigation/StackNavigator;)V", "getContainerId", "", "getInitialEntry", "Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "handleBack", "", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "core_release"})
/* compiled from: BaseStackNavigatorFragment.kt */
public abstract class e extends b {
    private HashMap atz;
    private j bbK;

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public abstract int YO();

    public abstract h YU();

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

    public boolean handleBack() {
        return false;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    /* renamed from: YT */
    protected final j b() {
        j jVar = this.bbK;
        if (jVar == null) {
            h.lS("navigator");
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
        lifecycle.a(new BaseStackNavigatorFragment$onCreate$1(this, (a) n));
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.bbK = new j(a.m(this), a.q(this), YO());
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        if (bundle == null) {
            h YU = YU();
            if (YU != null) {
                j jVar = this.bbK;
                if (jVar == null) {
                    h.lS("navigator");
                }
                if (!jVar.b(YU)) {
                    jVar = this.bbK;
                    if (jVar == null) {
                        h.lS("navigator");
                    }
                    jVar.a(YU, true);
                }
            }
        }
    }
}
