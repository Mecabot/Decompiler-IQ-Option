package com.iqoption.portfolio.a;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.view.View;
import com.google.common.util.concurrent.s;
import com.iqoption.portfolio.component.a.a;
import com.iqoption.portfolio.component.a.b;
import com.iqoption.portfolio.component.a.c;
import com.iqoption.portfolio.component.a.d;
import com.iqoption.portfolio.component.a.e;
import com.iqoption.portfolio.component.b.g;
import com.iqoption.portfolio.component.b.i;
import com.iqoption.portfolio.component.b.j;
import com.iqoption.portfolio.component.b.l;
import com.iqoption.portfolio.component.b.m;
import com.iqoption.portfolio.component.n;
import com.iqoption.portfolio.component.o;
import com.iqoption.portfolio.f;

/* compiled from: PortfolioDelegate */
abstract class u implements n {
    private final z dcQ;

    abstract void a(String str, i iVar, boolean z);

    abstract void a(String str, l lVar, boolean z);

    void af(@NonNull Bundle bundle) {
    }

    abstract void aj(Bundle bundle);

    abstract void awo();

    Bundle awu() {
        return null;
    }

    abstract Bundle awv();

    abstract void axD();

    abstract void axE();

    abstract void axF();

    abstract void axG();

    abstract void axH();

    abstract void axI();

    abstract void axJ();

    abstract void axK();

    abstract int axL();

    abstract int axM();

    abstract void axN();

    abstract void axO();

    abstract void axP();

    abstract void destroy();

    abstract View getView();

    abstract void i(String str, String str2, boolean z);

    abstract void j(String str, String str2, boolean z);

    void pause() {
    }

    void resume() {
    }

    u(z zVar) {
        this.dcQ = zVar;
    }

    public o axx() {
        return this.dcQ.axx();
    }

    public b axy() {
        return this.dcQ.axy();
    }

    public boolean b(l lVar) {
        return this.dcQ.b(lVar);
    }

    public f awe() {
        return this.dcQ.awe();
    }

    public c axz() {
        return this.dcQ.axz();
    }

    public boolean c(i iVar) {
        return this.dcQ.c(iVar);
    }

    public boolean c(l lVar) {
        return this.dcQ.c(lVar);
    }

    public e axA() {
        return this.dcQ.axA();
    }

    public void c(com.iqoption.portfolio.b bVar) {
        this.dcQ.c(bVar);
    }

    public boolean b(i iVar) {
        return this.dcQ.b(iVar);
    }

    public boolean e(m mVar) {
        return this.dcQ.e(mVar);
    }

    public a axB() {
        return this.dcQ.axB();
    }

    public boolean h(j jVar) {
        return this.dcQ.h(jVar);
    }

    /* renamed from: reload */
    public void bz() {
        this.dcQ.reload();
    }

    public d axC() {
        return this.dcQ.axC();
    }

    public boolean f(m mVar) {
        return this.dcQ.f(mVar);
    }

    public boolean g(j jVar) {
        return this.dcQ.g(jVar);
    }

    public s<?> g(m mVar) {
        return this.dcQ.g(mVar);
    }

    public s<?> f(j jVar) {
        return this.dcQ.f(jVar);
    }

    public boolean h(m mVar) {
        return this.dcQ.h(mVar);
    }

    public boolean e(j jVar) {
        return this.dcQ.e(jVar);
    }

    public void i(m mVar) {
        this.dcQ.i(mVar);
    }

    public void d(g gVar) {
        this.dcQ.d(gVar);
    }

    public void j(m mVar) {
        this.dcQ.j(mVar);
    }

    public void d(j jVar) {
        this.dcQ.d(jVar);
    }

    public void c(g gVar) {
        this.dcQ.c(gVar);
    }

    public void b(g gVar) {
        this.dcQ.b(gVar);
    }

    public s<?> g(Rect rect) {
        return this.dcQ.g(rect);
    }

    protected final void ayb() {
        this.dcQ.close();
    }

    /* renamed from: ayc */
    protected final void bC() {
        this.dcQ.expand();
    }

    /* renamed from: ayd */
    protected final void bw() {
        this.dcQ.ayj();
    }

    protected final void bG(@NonNull View view) {
        this.dcQ.bH(view);
    }

    protected final int ef(@DimenRes int i) {
        return this.dcQ.getResources().getDimensionPixelSize(i);
    }

    protected final CharSequence dA(@StringRes int i) {
        return this.dcQ.getString(i);
    }
}
