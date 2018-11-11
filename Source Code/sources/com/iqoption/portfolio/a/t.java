package com.iqoption.portfolio.a;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.view.View;
import com.iqoption.fragment.rightpanel.x;
import com.iqoption.portfolio.component.PortfolioLinearLayoutManager;
import com.iqoption.portfolio.component.b;
import com.iqoption.portfolio.component.m;
import com.iqoption.portfolio.f;
import com.iqoption.x.R;

/* compiled from: PortfolioClosedPositionsHelper */
final class t {
    private final RecyclerView bTK;
    private final u dcH;
    private final View dcL;
    private final View dcM;
    private final b dcN;
    private final x dcO;

    /* compiled from: PortfolioClosedPositionsHelper */
    static final class a {
        private RecyclerView bTK;
        private final u dcH;
        private View dcL;
        private View dcM;
        private m dcP;

        public a(u uVar) {
            this.dcH = uVar;
        }

        a bE(View view) {
            this.dcL = view;
            return this;
        }

        a bF(View view) {
            this.dcM = view;
            return this;
        }

        a e(RecyclerView recyclerView) {
            this.bTK = recyclerView;
            return this;
        }

        a a(m mVar) {
            this.dcP = mVar;
            return this;
        }

        t aya() {
            return new t(this);
        }
    }

    private t(a aVar) {
        this.dcH = aVar.dcH;
        this.dcL = aVar.dcL;
        this.dcM = aVar.dcM;
        this.bTK = aVar.bTK;
        this.dcO = new x(0, this.bTK, this.dcL, this.dcM);
        this.bTK.setHasFixedSize(true);
        this.bTK.setLayoutManager(new PortfolioLinearLayoutManager(this.bTK.getContext()));
        this.bTK.addItemDecoration(aVar.dcP);
        RecyclerView recyclerView = this.bTK;
        Adapter bVar = new b(this.dcH);
        this.dcN = bVar;
        recyclerView.setAdapter(bVar);
        ItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setChangeDuration(150);
        defaultItemAnimator.setMoveDuration(150);
        this.bTK.setItemAnimator(defaultItemAnimator);
    }

    void d(f fVar) {
        switch (fVar.getDataState()) {
            case 1:
                this.dcO.L(this.dcM);
                return;
            case 2:
                this.dcO.L(this.bTK);
                return;
            case 3:
                this.dcO.L(this.dcL);
                return;
            default:
                return;
        }
    }

    void e(f fVar) {
        this.dcN.z(fVar.avZ());
    }

    public CharSequence axZ() {
        return this.dcH.dA(R.string.closed);
    }
}
