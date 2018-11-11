package com.iqoption.portfolio.a;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.common.collect.ImmutableList;
import com.iqoption.app.IQApp;
import com.iqoption.d.aej;
import com.iqoption.d.afn;
import com.iqoption.d.afp;
import com.iqoption.portfolio.component.a;
import com.iqoption.portfolio.component.b.l;
import com.iqoption.portfolio.component.f;
import com.iqoption.portfolio.component.g;
import com.iqoption.portfolio.component.i;
import com.iqoption.portfolio.component.k;
import com.iqoption.portfolio.component.m;
import com.iqoption.portfolio.g.c;
import com.iqoption.x.R;

/* compiled from: MacroPortfolioDelegate */
public final class b extends u {
    private static final String TAG = "com.iqoption.portfolio.a.b";
    private final aej dcn;
    private final s dco = new a(this).l(this.dcn.bAZ).m(this.dcn.bns).n(this.dcn.agQ).axY();
    private final ah dcp;
    private final am dcq;

    void axH() {
    }

    int axL() {
        return R.id.dialogLayer;
    }

    int axM() {
        return R.id.otherLayer;
    }

    b(z zVar, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(zVar);
        this.dcn = (aej) DataBindingUtil.inflate(layoutInflater, R.layout.portfolio_delegate_macro, viewGroup, false);
        m mVar = new m(ef(R.dimen.dp10));
        afn d = afn.d(layoutInflater);
        d.bMf.setOnClickListener(new c(this));
        this.dcp = new a(this).bI(d.axw).bJ(d.bMg).bK(d.Hw).f(d.axw).a(new f(new g(this))).b(mVar).ayp();
        afp e = afp.e(layoutInflater);
        d.bMf.setOnClickListener(new d(this));
        this.dcq = new a(this).bM(e.Hw).bL(e.bMg).g(e.axw).a(new i(new k(this))).c(mVar).ayr();
        this.dcn.bPJ.setupWithViewPager(this.dcn.bmI);
        this.dcn.bmI.setAdapter(new a(new e(this), ImmutableList.o(d, e)));
        this.dcn.bmI.addOnPageChangeListener(new OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                if (i == 0) {
                    b.this.dco.ei(true);
                    com.iqoption.analytics.k.Bv();
                } else if (i == 1) {
                    b.this.dco.ei(false);
                    com.iqoption.analytics.k.BB();
                }
            }
        });
        this.dcn.awN.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                b.this.ayb();
            }
        });
        OnClickListener fVar = new f(this);
        this.dcn.agA.setOnClickListener(fVar);
        this.dcn.bAZ.setOnClickListener(fVar);
        axT();
        axQ();
        axR();
        axU();
        axV();
        awf();
        awg();
        axS();
    }

    final /* synthetic */ CharSequence gc(int i) {
        if (i == 0) {
            return this.dcp.f(awe());
        }
        return i == 1 ? this.dcq.f(awe()) : null;
    }

    View getView() {
        return this.dcn.getRoot();
    }

    void destroy() {
        this.dcp.destroy();
        IQApp.Dn().aE(new c());
    }

    void awo() {
        axT();
        axU();
        axV();
    }

    void axD() {
        axT();
        axQ();
        awf();
    }

    void axE() {
        axQ();
        awg();
    }

    void axF() {
        axT();
        axQ();
        awf();
    }

    void axG() {
        axQ();
        awg();
    }

    void axI() {
        axR();
    }

    void axJ() {
        axT();
        axQ();
        awf();
        awg();
        axS();
    }

    void axK() {
        axT();
        awf();
        awg();
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
        int i = bundle.getInt("sharedKey.page");
        ViewPager viewPager = this.dcn.bmI;
        if (i > 1) {
            i = 1;
        }
        viewPager.setCurrentItem(i);
    }

    void axN() {
        this.dcp.aym();
    }

    void axO() {
        awf();
    }

    void axP() {
        axR();
        awf();
        awg();
        axT();
        axU();
        axV();
        axS();
    }

    private void axQ() {
        PagerAdapter adapter = this.dcn.bmI.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    private void axR() {
        this.dcp.d(awe());
        this.dcq.d(awe());
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

    private void axT() {
        this.dco.c(awe());
    }

    private void axU() {
        this.dcp.axU();
    }

    private void axV() {
        this.dcq.axV();
    }
}
