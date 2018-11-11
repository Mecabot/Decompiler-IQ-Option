package com.iqoption.marginaddon;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import com.iqoption.app.af;
import com.iqoption.settings.b;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011R#\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, aXE = {"Lcom/iqoption/marginaddon/MarginAddOnViewModel;", "Landroid/arch/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "preferences", "Lcom/iqoption/app/Preferences;", "kotlin.jvm.PlatformType", "getPreferences", "()Lcom/iqoption/app/Preferences;", "preferences$delegate", "Lkotlin/Lazy;", "getMarginAddOnDialogShown", "", "isAddOnEnabled", "", "setMarginAddOnEnabled", "", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: MarginAddOnViewModel.kt */
public final class MarginAddOnViewModel extends AndroidViewModel {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(MarginAddOnViewModel.class), "preferences", "getPreferences()Lcom/iqoption/app/Preferences;"))};
    public static final a cOi = new a();
    private final d cOf = g.f(new MarginAddOnViewModel$preferences$2(this));

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/marginaddon/MarginAddOnViewModel$Companion;", "", "()V", "create", "Lcom/iqoption/marginaddon/MarginAddOnViewModel;", "fragment", "Landroid/support/v4/app/Fragment;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: MarginAddOnViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final MarginAddOnViewModel U(Fragment fragment) {
            h.e(fragment, "fragment");
            ViewModel h = ViewModelProviders.d(fragment).h(MarginAddOnViewModel.class);
            h.d(h, "ViewModelProviders.of(fr…dOnViewModel::class.java)");
            return (MarginAddOnViewModel) h;
        }
    }

    private final af aqJ() {
        d dVar = this.cOf;
        j jVar = apP[0];
        return (af) dVar.getValue();
    }

    public MarginAddOnViewModel(Application application) {
        h.e(application, "application");
        super(application);
    }

    public final boolean aqQ() {
        af aqJ = aqJ();
        h.d(aqJ, "preferences");
        return aqJ.En();
    }

    public final void aqR() {
        b aDQ = b.aDQ();
        h.d(aDQ, "SettingsManager.instance()");
        aDQ.aR(true);
    }

    public final int aqS() {
        af aqJ = aqJ();
        h.d(aqJ, "preferences");
        return aqJ.Fy();
    }
}
