package com.iqoption.portfolio.a;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.view.View;
import com.iqoption.fragment.rightpanel.x;
import com.iqoption.portfolio.component.PortfolioLinearLayoutManager;
import com.iqoption.portfolio.component.b.l;
import com.iqoption.portfolio.component.i;
import com.iqoption.portfolio.component.m;
import com.iqoption.portfolio.f;
import com.iqoption.util.t;
import com.iqoption.x.R;

/* compiled from: PortfolioPendingPositionsHelper */
final class am {
    private ItemAnimator aHy;
    private final RecyclerView bTK;
    private final u dcH;
    private final View dcL;
    private final View dcM;
    private final x dcO;
    private final i ddH;
    private final boolean ddw;
    private t ddy;

    /* compiled from: PortfolioPendingPositionsHelper */
    static final class a {
        private RecyclerView bTK;
        private final u dcH;
        private View dcL;
        private View dcM;
        private m dcP;
        private i ddH;
        private boolean ddw = true;

        public a(u uVar) {
            this.dcH = uVar;
        }

        a g(RecyclerView recyclerView) {
            this.bTK = recyclerView;
            return this;
        }

        a bL(View view) {
            this.dcL = view;
            return this;
        }

        a bM(View view) {
            this.dcM = view;
            return this;
        }

        a a(i iVar) {
            this.ddH = iVar;
            return this;
        }

        a c(m mVar) {
            this.dcP = mVar;
            return this;
        }

        a ej(boolean z) {
            this.ddw = z;
            return this;
        }

        am ayr() {
            return new am(this, null);
        }
    }

    /* synthetic */ am(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    private am(a aVar) {
        this.dcH = aVar.dcH;
        this.bTK = aVar.bTK;
        this.dcL = aVar.dcL;
        this.dcM = aVar.dcM;
        this.ddH = aVar.ddH;
        this.ddw = aVar.ddw;
        this.dcO = new x(0, this.bTK, this.dcL, this.dcM);
        this.bTK.setHasFixedSize(true);
        this.bTK.setLayoutManager(new PortfolioLinearLayoutManager(this.bTK.getContext()));
        this.bTK.addItemDecoration(aVar.dcP);
        this.bTK.setAdapter(this.ddH);
        ItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setChangeDuration(150);
        defaultItemAnimator.setMoveDuration(150);
        this.bTK.setItemAnimator(defaultItemAnimator);
    }

    void iV(final String str) {
        this.ddy = new t(new Runnable() {
            public void run() {
                int height = am.this.bTK.getHeight();
                int childCount = am.this.bTK.getChildCount();
                int i = 0;
                while (i < childCount) {
                    View childAt = am.this.bTK.getChildAt(i);
                    if (am.this.bTK.getChildViewHolder(childAt).getItemId() != r.cZq.dU(str) || childAt.getBottom() <= height) {
                        i++;
                    } else {
                        childCount = childAt.getHeight();
                        if (childCount >= height) {
                            height = childAt.getTop();
                        } else {
                            height = childCount - (height - childAt.getTop());
                        }
                        am.this.bTK.smoothScrollBy(0, height);
                        return;
                    }
                }
            }
        });
        this.ddy.ch(this.bTK.getItemAnimator().getChangeDuration());
    }

    void destroy() {
        if (this.ddy != null) {
            this.ddy.cancel();
        }
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

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005e  */
    void e(com.iqoption.portfolio.f r12) {
        /*
        r11 = this;
        r12 = r12.awa();
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = r12.isEmpty();
        if (r1 == 0) goto L_0x0018;
    L_0x000f:
        r1 = new com.iqoption.portfolio.component.b.b;
        r1.<init>();
        r0.add(r1);
        goto L_0x002a;
    L_0x0018:
        r1 = r11.ddw;
        if (r1 == 0) goto L_0x002a;
    L_0x001c:
        r1 = new com.iqoption.portfolio.a;
        r1.<init>();
        r2 = new com.iqoption.portfolio.component.b.e;
        r2.<init>(r1);
        r0.add(r2);
        goto L_0x002b;
    L_0x002a:
        r1 = 0;
    L_0x002b:
        r2 = r1;
        r1 = 0;
        r12 = r12.iterator();
    L_0x0031:
        r3 = r12.hasNext();
        if (r3 == 0) goto L_0x005c;
    L_0x0037:
        r3 = r12.next();
        r3 = (com.iqoption.portfolio.e) r3;
        r4 = new com.iqoption.portfolio.component.b.l;
        r4.<init>(r3);
        r0.add(r4);
        r3 = r11.dcH;
        r3 = r3.c(r4);
        if (r3 == 0) goto L_0x0054;
    L_0x004d:
        r3 = r4.axa();
        r0.addAll(r3);
    L_0x0054:
        r5 = (double) r1;
        r3 = r4.getInvestment();
        r5 = r5 + r3;
        r1 = (int) r5;
        goto L_0x0031;
    L_0x005c:
        if (r2 == 0) goto L_0x0068;
    L_0x005e:
        r3 = (double) r1;
        r5 = 0;
        r7 = 0;
        r9 = 0;
        r2.a(r3, r5, r7, r9);
    L_0x0068:
        r12 = r11.ddH;
        r12.setItems(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.portfolio.a.am.e(com.iqoption.portfolio.f):void");
    }

    void axV() {
        this.ddH.awF();
    }

    void ayn() {
        if (this.aHy != null) {
            this.bTK.setItemAnimator(this.aHy);
            this.aHy = null;
        }
    }

    void ayo() {
        this.aHy = this.bTK.getItemAnimator();
        this.bTK.setItemAnimator(null);
    }

    void k(String str, String str2, boolean z) {
        this.ddH.av(str, str2);
        if (z) {
            iV(str);
        }
    }

    void b(String str, l lVar, boolean z) {
        if (z) {
            this.ddH.iS(str);
            if (lVar.awY()) {
                iV(str);
                return;
            }
            return;
        }
        this.ddH.iT(str);
    }

    public CharSequence f(f fVar) {
        if (fVar.awa().size() == 0) {
            return this.dcH.dA(R.string.pending);
        }
        return String.format(this.dcH.axx().cZK, new Object[]{Integer.valueOf(r4)});
    }
}
