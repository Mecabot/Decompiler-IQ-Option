package com.iqoption.charttools.tools.delegate;

import android.arch.lifecycle.Lifecycle;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.charttools.tools.ToolsViewModel;
import com.iqoption.charttools.tools.delegate.c.a;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010!\u001a\u00020\"H\u0001R\u001b\u0010\b\u001a\u00028\u00008DX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0012\u0010\r\u001a\u00020\u000eX\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u0012X\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0012\u0010\u0019\u001a\u00020\u001aX\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0012\u0010\u001d\u001a\u00020\u001eX\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, aXE = {"Lcom/iqoption/charttools/tools/delegate/ContentDelegate;", "Binding", "Landroid/databinding/ViewDataBinding;", "Lcom/iqoption/charttools/tools/delegate/DelegateContext;", "layout", "", "context", "(ILcom/iqoption/charttools/tools/delegate/DelegateContext;)V", "binding", "getBinding", "()Landroid/databinding/ViewDataBinding;", "binding$delegate", "Lkotlin/Lazy;", "callbacks", "Lcom/iqoption/charttools/tools/delegate/DelegateContext$Callbacks;", "getCallbacks", "()Lcom/iqoption/charttools/tools/delegate/DelegateContext$Callbacks;", "commonDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getCommonDecoration", "()Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "parentView", "Landroid/view/ViewGroup;", "getParentView", "()Landroid/view/ViewGroup;", "viewModel", "Lcom/iqoption/charttools/tools/ToolsViewModel;", "getViewModel", "()Lcom/iqoption/charttools/tools/ToolsViewModel;", "getLifecycle", "Landroid/arch/lifecycle/Lifecycle;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ContentDelegate.kt */
public abstract class b<Binding extends ViewDataBinding> implements c {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "binding", "getBinding()Landroid/databinding/ViewDataBinding;"))};
    private final d aCc;
    private final /* synthetic */ c aCd;

    public ToolsViewModel Nv() {
        return this.aCd.Nv();
    }

    public ItemDecoration Nx() {
        return this.aCd.Nx();
    }

    public ViewGroup Ny() {
        return this.aCd.Ny();
    }

    public a Nz() {
        return this.aCd.Nz();
    }

    protected final Binding getBinding() {
        d dVar = this.aCc;
        j jVar = apP[0];
        return (ViewDataBinding) dVar.getValue();
    }

    @NonNull
    public Lifecycle getLifecycle() {
        return this.aCd.getLifecycle();
    }

    public b(int i, c cVar) {
        h.e(cVar, "context");
        this.aCd = cVar;
        this.aCc = g.f(new ContentDelegate$binding$2(this, i));
    }

    public final View getContentView() {
        View root = getBinding().getRoot();
        h.d(root, "binding.root");
        return root;
    }
}
