package com.iqoption.portfolio.a;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.common.collect.ImmutableList;
import com.iqoption.analytics.k;
import com.iqoption.app.IQApp;
import com.iqoption.d.aam;
import com.iqoption.d.aao;
import com.iqoption.d.aaq;
import com.iqoption.d.ael;
import com.iqoption.portfolio.component.a;
import com.iqoption.portfolio.component.b.l;
import com.iqoption.portfolio.component.c;
import com.iqoption.portfolio.component.d;
import com.iqoption.portfolio.component.e;
import com.iqoption.portfolio.component.f;
import com.iqoption.portfolio.component.i;
import com.iqoption.portfolio.component.m;
import com.iqoption.portfolio.g;
import com.iqoption.portfolio.g.b;
import com.iqoption.x.R;

/* compiled from: MicroPortfolioDelegate */
public final class h extends u {
    private final s dco = new a(this).l(this.dcx.bAZ).axY();
    private final ah dcp;
    private final am dcq;
    private final ael dcx;
    private final t dcy;
    private final e dcz;

    private void axW() {
    }

    int axL() {
        return R.id.fragment;
    }

    int axM() {
        return R.id.other_fragment;
    }

    h(z zVar, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(zVar);
        this.dcx = (ael) DataBindingUtil.inflate(layoutInflater, R.layout.portfolio_delegate_micro, viewGroup, false);
        OnClickListener iVar = new i(this);
        this.dcx.agA.setOnClickListener(iVar);
        this.dcx.bAZ.setOnClickListener(iVar);
        this.dcx.axz.setOnClickListener(new j(this));
        m mVar = new m(ef(R.dimen.dp6));
        aao b = aao.b(layoutInflater);
        this.dcz = new e(zVar.requireContext(), axx(), awe(), axB());
        b.bMf.setOnClickListener(new k(this));
        this.dcp = new a(this).bI(b.axw).bJ(b.bMg).bK(b.Hw).f(b.axw).a(new f(new c(this))).b(mVar).ayp();
        aaq c = aaq.c(layoutInflater);
        c.bMf.setOnClickListener(new l(this));
        this.dcq = new a(this).bM(c.Hw).bL(c.bMg).g(c.axw).a(new i(new d(this))).c(mVar).ej(false).ayr();
        aam a = aam.a(layoutInflater);
        a.bMf.setOnClickListener(new m(this));
        this.dcy = new a(this).bF(a.Hw).bE(a.bMg).e(a.axw).a(mVar).aya();
        this.dcx.bPJ.setupWithViewPager(this.dcx.bmI);
        this.dcx.bmI.setOffscreenPageLimit(2);
        this.dcx.bmI.setAdapter(new a(new n(this), ImmutableList.a(b, c, a)));
        this.dcx.bmI.addOnPageChangeListener(new OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                switch (i) {
                    case 0:
                        k.Bv();
                        return;
                    case 1:
                        k.BB();
                        return;
                    case 2:
                        k.Bw();
                        return;
                    default:
                        return;
                }
            }
        });
        axW();
        axX();
        axS();
        axQ();
        axR();
        axU();
        axV();
        awf();
        awg();
        awh();
        IQApp.Dn().aE(new b());
    }

    final /* synthetic */ void bD(View view) {
        bG(this.dcx.agA);
    }

    final /* synthetic */ CharSequence gd(int i) {
        switch (i) {
            case 0:
                return this.dcp.f(awe());
            case 1:
                return this.dcq.f(awe());
            case 2:
                return this.dcy.axZ();
            default:
                return null;
        }
    }

    View getView() {
        return this.dcx.getRoot();
    }

    void resume() {
        super.resume();
        this.dcp.ayn();
        this.dcq.ayn();
    }

    void pause() {
        super.pause();
        this.dcp.ayo();
        this.dcq.ayo();
    }

    void destroy() {
        this.dcp.destroy();
        this.dcq.destroy();
        IQApp.Dn().aE(new g.a());
    }

    void awo() {
        axX();
        axU();
        axV();
    }

    void axD() {
        awf();
    }

    void axE() {
        awg();
    }

    void axF() {
        axW();
        axX();
        axQ();
        awf();
    }

    void axG() {
        axW();
        axQ();
        awg();
    }

    void axH() {
        axQ();
        awh();
    }

    void axI() {
        axR();
    }

    void axJ() {
        axW();
        axX();
        axS();
        axQ();
        awf();
        awg();
        awh();
    }

    void axK() {
        axW();
        axX();
        axU();
        axV();
        awf();
        awg();
        awh();
    }

    void a(String str, com.iqoption.portfolio.component.b.i iVar, boolean z) {
        this.dcp.b(str, iVar, z);
    }

    void i(String str, String str2, boolean z) {
        this.dcp.k(str, str2, z);
    }

    void a(String str, l lVar, boolean z) {
        this.dcq.b(str, lVar, z);
    }

    void j(String str, String str2, boolean z) {
        this.dcq.k(str, str2, z);
    }

    Bundle awv() {
        return new com.iqoption.util.g().toBundle();
    }

    void aj(Bundle bundle) {
        this.dcx.bmI.setCurrentItem(bundle.getInt("sharedKey.page"));
    }

    void axN() {
        this.dcp.aym();
    }

    void axO() {
        axW();
    }

    void axP() {
        axR();
        axX();
        axW();
        axS();
        axQ();
        axU();
        axV();
        awf();
        awg();
        awh();
    }

    private void axR() {
        this.dcp.d(awe());
        this.dcq.d(awe());
        this.dcy.d(awe());
    }

    private void awf() {
        this.dcp.e(awe());
    }

    private void awg() {
        this.dcq.e(awe());
    }

    private void axS() {
        this.dco.b(awe());
    }

    private void axX() {
        this.dcz.awC();
    }

    private void axU() {
        this.dcp.axU();
    }

    private void axV() {
        this.dcq.axV();
    }

    private void awh() {
        this.dcy.e(awe());
    }

    private void axQ() {
        PagerAdapter adapter = this.dcx.bmI.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}
