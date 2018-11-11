package com.iqoption.portfolio.component;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.iqoption.portfolio.a.an;

/* compiled from: ViewHolderCreatorBinder */
public abstract class p<VH extends ViewHolder, I, Context extends an> {
    private final Context dae;

    abstract void a(int i, VH vh, I i2);

    abstract VH b(int i, ViewGroup viewGroup);

    public p(Context context) {
        this.dae = context;
    }

    protected final Context awL() {
        return this.dae;
    }

    protected final LayoutInflater getLayoutInflater() {
        return this.dae.axx().layoutInflater;
    }
}
