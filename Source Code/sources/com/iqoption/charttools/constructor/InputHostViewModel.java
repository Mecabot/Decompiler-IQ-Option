package com.iqoption.charttools.constructor;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProvider.Factory;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import com.iqoption.charttools.model.indicator.constructor.b;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0011\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, aXE = {"Lcom/iqoption/charttools/constructor/InputHostViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "item", "Lcom/iqoption/charttools/constructor/InputHost;", "parent", "Lcom/iqoption/charttools/constructor/IndicatorSettingsViewModel;", "destroy", "", "getItems", "", "Lcom/iqoption/charttools/model/indicator/constructor/FigureHost;", "()[Lcom/iqoption/charttools/model/indicator/constructor/FigureHost;", "getTitle", "", "init", "viewModel", "select", "host", "Companion", "techtools_release"})
/* compiled from: InputHostViewModel.kt */
public final class InputHostViewModel extends ViewModel {
    public static final a auD = new a();
    private IndicatorSettingsViewModel auB;
    private m auC;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/charttools/constructor/InputHostViewModel$Companion;", "", "()V", "get", "Lcom/iqoption/charttools/constructor/InputHostViewModel;", "f", "Landroid/support/v4/app/Fragment;", "techtools_release"})
    /* compiled from: InputHostViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final InputHostViewModel f(Fragment fragment) {
            h.e(fragment, "f");
            Factory factory = (Factory) null;
            ViewModelProvider d = ViewModelProviders.d(fragment);
            h.d(d, "ViewModelProviders.of(f)");
            ViewModel h = d.h(InputHostViewModel.class);
            h.d(h, "if (factory != null) {\n …f(f)\n    }[T::class.java]");
            return (InputHostViewModel) h;
        }
    }

    public final void a(IndicatorSettingsViewModel indicatorSettingsViewModel, m mVar) {
        h.e(indicatorSettingsViewModel, "viewModel");
        h.e(mVar, "item");
        this.auB = indicatorSettingsViewModel;
        this.auC = mVar;
    }

    public final String getTitle() {
        m mVar = this.auC;
        String label = mVar != null ? mVar.getLabel() : null;
        return label != null ? label : "";
    }

    public final b[] Lm() {
        m mVar = this.auC;
        if (mVar != null) {
            b[] Li = mVar.Li();
            if (Li != null) {
                return Li;
            }
        }
        return new b[0];
    }

    public final void c(b bVar) {
        h.e(bVar, "host");
        IndicatorSettingsViewModel indicatorSettingsViewModel = this.auB;
        m mVar = this.auC;
        if (indicatorSettingsViewModel != null && mVar != null) {
            indicatorSettingsViewModel.b(new m(mVar, bVar));
        }
    }

    public final void destroy() {
        IndicatorSettingsViewModel indicatorSettingsViewModel = this.auB;
        if (indicatorSettingsViewModel != null) {
            indicatorSettingsViewModel.KU();
        }
    }
}
