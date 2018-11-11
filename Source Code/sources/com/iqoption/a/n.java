package com.iqoption.a;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView.ViewHolder;

/* compiled from: ItemBindingViewHolder */
public class n<T extends ViewDataBinding> extends ViewHolder {
    protected final T ahp;
    protected int type;

    n(T t) {
        this(t, -1);
    }

    n(T t, int i) {
        super(t.getRoot());
        this.ahp = t;
        this.type = i;
    }
}
