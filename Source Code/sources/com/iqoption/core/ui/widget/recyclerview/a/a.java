package com.iqoption.core.ui.widget.recyclerview.a;

import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u0004B\u0015\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007B\r\u0012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0002\u0010\tJ\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010J\u0019\u0010\r\u001a\u00020\u000e*\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u0011R\u0013\u0010\b\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, aXE = {"Lcom/iqoption/core/ui/widget/recyclerview/viewholder/IQBindingHolder;", "Binding", "Lcom/iqoption/core/ui/widget/binding/IQBinding;", "Item", "Lcom/iqoption/core/ui/widget/recyclerview/viewholder/IQViewHolder;", "factory", "Lcom/iqoption/core/ui/widget/binding/IQBindingFactory;", "(Lcom/iqoption/core/ui/widget/binding/IQBindingFactory;)V", "binding", "(Lcom/iqoption/core/ui/widget/binding/IQBinding;)V", "getBinding", "()Lcom/iqoption/core/ui/widget/binding/IQBinding;", "Lcom/iqoption/core/ui/widget/binding/IQBinding;", "bind", "", "item", "(Ljava/lang/Object;)V", "(Lcom/iqoption/core/ui/widget/binding/IQBinding;Ljava/lang/Object;)V", "core_release"})
/* compiled from: IQBindingHolder.kt */
public abstract class a<Binding extends com.iqoption.core.ui.widget.a.a, Item> extends b<Item> {
    private final Binding bgu;

    public abstract void a(Binding binding, Item item);

    public a(Binding binding) {
        h.e(binding, "binding");
        super(binding.getRoot());
        this.bgu = binding;
    }

    public final Binding ZT() {
        return this.bgu;
    }

    public void bb(Item item) {
        a(this.bgu, item);
    }
}
