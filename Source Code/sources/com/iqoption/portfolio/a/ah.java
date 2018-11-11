package com.iqoption.portfolio.a;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import com.google.common.collect.ImmutableList;
import com.iqoption.fragment.rightpanel.x;
import com.iqoption.portfolio.component.PortfolioLinearLayoutManager;
import com.iqoption.portfolio.component.b.e;
import com.iqoption.portfolio.component.b.i;
import com.iqoption.portfolio.component.f;
import com.iqoption.portfolio.component.m;
import com.iqoption.portfolio.d;
import com.iqoption.util.t;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: PortfolioOpenPositionsHelper */
final class ah {
    private final View aGa;
    private ItemAnimator aHy;
    private final RecyclerView bTK;
    private final u dcH;
    private final View dcL;
    private final View dcM;
    private final x dcO;
    private final f ddv;
    private final boolean ddw;
    private final c ddx;
    private t ddy;

    /* compiled from: PortfolioOpenPositionsHelper */
    static final class a {
        private View aGa;
        private RecyclerView bTK;
        private final u dcH;
        private View dcL;
        private View dcM;
        private m dcP;
        private int ddF;
        private b ddG;
        private f ddv;
        private boolean ddw = true;
        private c ddx;

        public a(u uVar) {
            this.dcH = uVar;
        }

        a bI(View view) {
            this.aGa = view;
            return this;
        }

        a bJ(View view) {
            this.dcL = view;
            return this;
        }

        a bK(View view) {
            this.dcM = view;
            return this;
        }

        a f(RecyclerView recyclerView) {
            this.bTK = recyclerView;
            return this;
        }

        a a(f fVar) {
            this.ddv = fVar;
            return this;
        }

        a b(m mVar) {
            this.dcP = mVar;
            return this;
        }

        ah ayp() {
            return new ah(this, null);
        }
    }

    /* compiled from: PortfolioOpenPositionsHelper */
    public interface b {
        void I(float f);
    }

    /* compiled from: PortfolioOpenPositionsHelper */
    public interface c {
        void ayq();

        void onError();

        void onSuccess();
    }

    /* synthetic */ ah(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    private ah(a aVar) {
        this.dcH = aVar.dcH;
        this.aGa = aVar.aGa;
        this.dcL = aVar.dcL;
        this.dcM = aVar.dcM;
        this.bTK = aVar.bTK;
        this.ddv = aVar.ddv;
        this.ddw = aVar.ddw;
        this.ddx = aVar.ddx;
        this.dcO = new x(0, this.aGa, this.dcL, this.dcM);
        LayoutManager portfolioLinearLayoutManager = new PortfolioLinearLayoutManager(this.bTK.getContext());
        this.bTK.setHasFixedSize(true);
        this.bTK.setLayoutManager(portfolioLinearLayoutManager);
        this.bTK.addItemDecoration(aVar.dcP);
        this.bTK.setAdapter(this.ddv);
        ItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setChangeDuration(150);
        defaultItemAnimator.setMoveDuration(150);
        this.bTK.setItemAnimator(defaultItemAnimator);
        if (aVar.ddG != null) {
            final Runnable aiVar = new ai(portfolioLinearLayoutManager, this.bTK.getPaddingTop(), aVar.ddG, aVar.ddF);
            aiVar.getClass();
            portfolioLinearLayoutManager.a(aj.k(aiVar));
            this.bTK.addOnScrollListener(new OnScrollListener() {
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    aiVar.run();
                }
            });
        }
    }

    static final /* synthetic */ void a(PortfolioLinearLayoutManager portfolioLinearLayoutManager, int i, b bVar, int i2) {
        float f = 1.0f;
        if (portfolioLinearLayoutManager.findFirstVisibleItemPosition() == 0) {
            i -= portfolioLinearLayoutManager.findViewByPosition(0).getTop();
            if (i <= i2) {
                f = ((float) i) / ((float) i2);
            }
            bVar.I(f);
            return;
        }
        bVar.I(1.0f);
    }

    private void iV(String str) {
        this.ddy = new t(new ak(this, str));
        this.ddy.ch(this.bTK.getItemAnimator().getChangeDuration());
    }

    final /* synthetic */ void iW(String str) {
        int height = this.bTK.getHeight();
        int childCount = this.bTK.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.bTK.getChildAt(i);
            if (this.bTK.getChildViewHolder(childAt).getItemId() != o.cZq.dU(str) || childAt.getBottom() <= height) {
                i++;
            } else {
                int height2 = childAt.getHeight();
                if (height2 >= height) {
                    height2 = childAt.getTop();
                } else {
                    height2 -= height - childAt.getTop();
                }
                this.bTK.smoothScrollBy(0, height2);
                return;
            }
        }
    }

    void destroy() {
        if (this.ddy != null) {
            this.ddy.cancel();
        }
    }

    void d(com.iqoption.portfolio.f fVar) {
        switch (fVar.getDataState()) {
            case 1:
                this.dcO.L(this.dcM);
                if (this.ddx != null) {
                    this.ddx.ayq();
                    return;
                }
                return;
            case 2:
                this.dcO.L(this.aGa);
                if (this.ddx != null) {
                    this.ddx.onSuccess();
                    return;
                }
                return;
            case 3:
                this.dcO.L(this.dcL);
                if (this.ddx != null) {
                    this.ddx.onError();
                    return;
                }
                return;
            default:
                return;
        }
    }

    void e(com.iqoption.portfolio.f fVar) {
        ImmutableList avY = fVar.avY();
        List arrayList = new ArrayList();
        if (avY.isEmpty()) {
            arrayList.add(new com.iqoption.portfolio.component.b.b());
        } else if (this.ddw) {
            arrayList.add(new e(fVar.awc()));
        }
        Iterator sI = avY.iterator();
        while (sI.hasNext()) {
            i iVar = new i((d) sI.next());
            arrayList.add(iVar);
            if (this.dcH.b(iVar)) {
                arrayList.addAll(iVar.awZ());
            }
        }
        this.ddv.setItems(arrayList);
    }

    void axU() {
        this.ddv.awD();
    }

    void aym() {
        this.ddv.awE();
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
        this.ddv.av(str, str2);
        if (z) {
            iV(str);
        }
    }

    void b(String str, i iVar, boolean z) {
        if (z) {
            this.ddv.iS(str);
            if (iVar.awY()) {
                iV(str);
                return;
            }
            return;
        }
        this.ddv.iT(str);
    }

    public CharSequence f(com.iqoption.portfolio.f fVar) {
        if (com.google.common.collect.i.c(fVar.avY()).b(al.$instance).size() == 0) {
            return this.dcH.dA(R.string.opened);
        }
        return String.format(this.dcH.axx().cZJ, new Object[]{Integer.valueOf(r4)});
    }
}
