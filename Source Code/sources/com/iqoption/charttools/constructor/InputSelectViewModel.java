package com.iqoption.charttools.constructor;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProvider.Factory;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0011\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u000bJ\u0016\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, aXE = {"Lcom/iqoption/charttools/constructor/InputSelectViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "item", "Lcom/iqoption/charttools/constructor/InputSelect;", "parent", "Lcom/iqoption/charttools/constructor/IndicatorSettingsViewModel;", "destroy", "", "getItems", "", "", "()[Ljava/lang/String;", "getTitle", "init", "viewModel", "select", "option", "Companion", "techtools_release"})
/* compiled from: InputSelectViewModel.kt */
public final class InputSelectViewModel extends ViewModel {
    public static final a auQ = new a();
    private IndicatorSettingsViewModel auB;
    private s auP;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/charttools/constructor/InputSelectViewModel$Companion;", "", "()V", "get", "Lcom/iqoption/charttools/constructor/InputSelectViewModel;", "f", "Landroid/support/v4/app/Fragment;", "techtools_release"})
    /* compiled from: InputSelectViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final InputSelectViewModel g(Fragment fragment) {
            h.e(fragment, "f");
            Factory factory = (Factory) null;
            ViewModelProvider d = ViewModelProviders.d(fragment);
            h.d(d, "ViewModelProviders.of(f)");
            ViewModel h = d.h(InputSelectViewModel.class);
            h.d(h, "if (factory != null) {\n …f(f)\n    }[T::class.java]");
            return (InputSelectViewModel) h;
        }
    }

    public final void a(IndicatorSettingsViewModel indicatorSettingsViewModel, s sVar) {
        h.e(indicatorSettingsViewModel, "viewModel");
        h.e(sVar, "item");
        this.auB = indicatorSettingsViewModel;
        this.auP = sVar;
    }

    public final String getTitle() {
        s sVar = this.auP;
        String label = sVar != null ? sVar.getLabel() : null;
        return label != null ? label : "";
    }

    public final String[] getItems() {
        s sVar = this.auP;
        if (sVar != null) {
            String[] options = sVar.getOptions();
            if (options != null) {
                return options;
            }
        }
        return new String[0];
    }

    public final void select(String str) {
        h.e(str, "option");
        IndicatorSettingsViewModel indicatorSettingsViewModel = this.auB;
        s sVar = this.auP;
        if (indicatorSettingsViewModel != null && sVar != null) {
            indicatorSettingsViewModel.b(new s(sVar, i.indexOf(sVar.getOptions(), str)));
        }
    }

    public final void destroy() {
        IndicatorSettingsViewModel indicatorSettingsViewModel = this.auB;
        if (indicatorSettingsViewModel != null) {
            indicatorSettingsViewModel.KS();
        }
    }
}
