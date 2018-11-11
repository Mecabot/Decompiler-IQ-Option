package com.iqoption.bottomsheet;

import android.databinding.ViewDataBinding;
import android.view.View;
import android.view.ViewGroup;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0015\u0010\u000f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000eH&¢\u0006\u0002\u0010\u0010R\u001c\u0010\u0005\u001a\u00028\u0000X.¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, aXE = {"Lcom/iqoption/bottomsheet/BindingBottomSheetFragment;", "BindingType", "Landroid/databinding/ViewDataBinding;", "Lcom/iqoption/bottomsheet/BottomSheetFragment;", "()V", "binding", "getBinding", "()Landroid/databinding/ViewDataBinding;", "setBinding", "(Landroid/databinding/ViewDataBinding;)V", "Landroid/databinding/ViewDataBinding;", "provideView", "Landroid/view/View;", "container", "Landroid/view/ViewGroup;", "provideViewBinding", "(Landroid/view/ViewGroup;)Landroid/databinding/ViewDataBinding;", "dialogs_release"})
/* compiled from: BindingBottomSheetFragment.kt */
public abstract class a<BindingType extends ViewDataBinding> extends c {
    protected BindingType ahp;

    public abstract BindingType e(ViewGroup viewGroup);

    protected final BindingType getBinding() {
        BindingType bindingType = this.ahp;
        if (bindingType == null) {
            h.lS("binding");
        }
        return bindingType;
    }

    public View d(ViewGroup viewGroup) {
        h.e(viewGroup, "container");
        this.ahp = e(viewGroup);
        ViewDataBinding viewDataBinding = this.ahp;
        if (viewDataBinding == null) {
            h.lS("binding");
        }
        View root = viewDataBinding.getRoot();
        h.d(root, "binding.root");
        return root;
    }
}
