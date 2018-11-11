package com.iqoption.portfolio.component.viewholder;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.iqoption.portfolio.component.n;
import com.iqoption.portfolio.component.o;

/* compiled from: OpenPositionViewHolder */
public abstract class ai extends ViewHolder {
    protected n dcb;

    public abstract void awD();

    public abstract void awE();

    public ai(View view, n nVar) {
        super(view);
        this.dcb = nVar;
    }

    protected final o axx() {
        return this.dcb.axx();
    }
}
