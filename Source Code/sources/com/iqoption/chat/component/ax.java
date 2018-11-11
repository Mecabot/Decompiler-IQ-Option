package com.iqoption.chat.component;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView.ViewHolder;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, aXE = {"Lcom/iqoption/chat/component/ViewHolder;", "T", "Landroid/databinding/ViewDataBinding;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "binding", "(Landroid/databinding/ViewDataBinding;)V", "getBinding", "()Landroid/databinding/ViewDataBinding;", "Landroid/databinding/ViewDataBinding;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: MessageViewHolders.kt */
public class ax<T extends ViewDataBinding> extends ViewHolder {
    private final T ahp;

    public ax(T t) {
        h.e(t, "binding");
        super(t.getRoot());
        this.ahp = t;
    }

    public final T getBinding() {
        return this.ahp;
    }
}
