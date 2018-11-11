package com.iqoption.core.ui.widget.recyclerview.a;

import android.databinding.ViewDataBinding;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.core.ext.a;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\r\u0012\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0002\u0010\u000bJ\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0012J\u0019\u0010\u000f\u001a\u00020\u0010*\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u0013R\u0013\u0010\n\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, aXE = {"Lcom/iqoption/core/ui/widget/recyclerview/viewholder/VDBindingHolder;", "VDBinding", "Landroid/databinding/ViewDataBinding;", "Item", "Lcom/iqoption/core/ui/widget/recyclerview/viewholder/IQViewHolder;", "layout", "", "parent", "Landroid/view/ViewGroup;", "(ILandroid/view/ViewGroup;)V", "binding", "(Landroid/databinding/ViewDataBinding;)V", "getBinding", "()Landroid/databinding/ViewDataBinding;", "Landroid/databinding/ViewDataBinding;", "bind", "", "item", "(Ljava/lang/Object;)V", "(Landroid/databinding/ViewDataBinding;Ljava/lang/Object;)V", "core_release"})
/* compiled from: VDBindingHolder.kt */
public abstract class c<VDBinding extends ViewDataBinding, Item> extends b<Item> {
    private final VDBinding ahp;

    public abstract void a(VDBinding vDBinding, Item item);

    public c(VDBinding vDBinding) {
        h.e(vDBinding, "binding");
        View root = vDBinding.getRoot();
        h.d(root, "binding.root");
        super(root);
        this.ahp = vDBinding;
    }

    public final VDBinding getBinding() {
        return this.ahp;
    }

    public c(int i, ViewGroup viewGroup) {
        h.e(viewGroup, "parent");
        this(a.a(viewGroup, i, null, false, 6, null));
    }

    public void bb(Item item) {
        a(this.ahp, item);
    }
}
