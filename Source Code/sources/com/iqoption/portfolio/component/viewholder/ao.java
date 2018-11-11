package com.iqoption.portfolio.component.viewholder;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.google.common.util.concurrent.s;
import com.iqoption.portfolio.a.r;
import com.iqoption.portfolio.component.a.a;
import com.iqoption.portfolio.component.a.b;
import com.iqoption.portfolio.component.a.c;
import com.iqoption.portfolio.component.a.d;
import com.iqoption.portfolio.component.a.e;
import com.iqoption.portfolio.component.b.l;
import com.iqoption.portfolio.component.b.m;
import com.iqoption.portfolio.component.o;

/* compiled from: PendingPositionViewHolder */
public abstract class ao extends ViewHolder implements r {
    private final r dcj;

    public abstract void awF();

    public void axw() {
    }

    public ao(View view, r rVar) {
        super(view);
        this.dcj = rVar;
    }

    public o axx() {
        return this.dcj.axx();
    }

    public boolean b(l lVar) {
        return this.dcj.b(lVar);
    }

    public boolean c(l lVar) {
        return this.dcj.c(lVar);
    }

    public b axy() {
        return this.dcj.axy();
    }

    public boolean e(m mVar) {
        return this.dcj.e(mVar);
    }

    public c axz() {
        return this.dcj.axz();
    }

    public boolean f(m mVar) {
        return this.dcj.f(mVar);
    }

    public e axA() {
        return this.dcj.axA();
    }

    public a axB() {
        return this.dcj.axB();
    }

    public s<?> g(m mVar) {
        return this.dcj.g(mVar);
    }

    public d axC() {
        return this.dcj.axC();
    }

    public boolean h(m mVar) {
        return this.dcj.h(mVar);
    }

    public void i(m mVar) {
        this.dcj.i(mVar);
    }

    public void j(m mVar) {
        this.dcj.j(mVar);
    }
}
