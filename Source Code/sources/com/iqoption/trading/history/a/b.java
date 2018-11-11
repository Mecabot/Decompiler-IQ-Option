package com.iqoption.trading.history.a;

import android.support.v7.util.AsyncListUtil;
import android.support.v7.util.AsyncListUtil.DataCallback;
import android.support.v7.util.AsyncListUtil.ViewCallback;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.ViewGroup;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.d.fm;
import com.iqoption.trading.history.b.c;

/* compiled from: PortfolioClosedListAdapter */
public class b extends Adapter<a> {
    private final RecyclerView ahx;
    private final long cSy;
    private final long cUZ;
    private final c dsB;
    private final a dsC;
    private final InstrumentType[] dsF;
    private final int[] dsG;
    private final long dsH;
    private volatile c dsI;
    private final DataCallback<com.iqoption.trading.history.b.b> dsJ = new DataCallback<com.iqoption.trading.history.b.b>() {
        public int getMaxCachedTiles() {
            return 150;
        }

        public int refreshData() {
            return b.this.dsI == null ? 0 : b.this.dsI.total;
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0078 A:{RETURN, Splitter: B:3:0x0009, ExcHandler: java.lang.InterruptedException (unused java.lang.InterruptedException)} */
        /* JADX WARNING: Missing block: B:20:0x0078, code:
            return;
     */
        /* renamed from: a */
        public void fillData(com.iqoption.trading.history.b.b[] r13, int r14, int r15) {
            /*
            r12 = this;
            r0 = com.iqoption.trading.history.a.b.this;
            r0 = r0.dsN;
            if (r0 == 0) goto L_0x0009;
        L_0x0008:
            return;
        L_0x0009:
            r0 = com.iqoption.trading.history.a.b.this;	 Catch:{ InterruptedException -> 0x0078, InterruptedException -> 0x0078 }
            r0 = r0.dsI;	 Catch:{ InterruptedException -> 0x0078, InterruptedException -> 0x0078 }
            if (r0 == 0) goto L_0x0078;
        L_0x0011:
            r0 = com.iqoption.trading.history.a.b.this;	 Catch:{ InterruptedException -> 0x0078, InterruptedException -> 0x0078 }
            r0 = r0.dsI;	 Catch:{ InterruptedException -> 0x0078, InterruptedException -> 0x0078 }
            r0 = r0.offset;	 Catch:{ InterruptedException -> 0x0078, InterruptedException -> 0x0078 }
            if (r14 < r0) goto L_0x0025;
        L_0x001b:
            r0 = com.iqoption.trading.history.a.b.this;	 Catch:{ InterruptedException -> 0x0078, InterruptedException -> 0x0078 }
            r0 = r0.dsI;	 Catch:{ InterruptedException -> 0x0078, InterruptedException -> 0x0078 }
            r0 = r0.limit;	 Catch:{ InterruptedException -> 0x0078, InterruptedException -> 0x0078 }
            if (r15 <= r0) goto L_0x0054;
        L_0x0025:
            r0 = com.iqoption.trading.history.a.b.this;	 Catch:{ InterruptedException -> 0x0078, InterruptedException -> 0x0078 }
            r1 = com.iqoption.trading.history.a.b.this;	 Catch:{ InterruptedException -> 0x0078, InterruptedException -> 0x0078 }
            r2 = r1.cUZ;	 Catch:{ InterruptedException -> 0x0078, InterruptedException -> 0x0078 }
            r1 = com.iqoption.trading.history.a.b.this;	 Catch:{ InterruptedException -> 0x0078, InterruptedException -> 0x0078 }
            r4 = r1.dsF;	 Catch:{ InterruptedException -> 0x0078, InterruptedException -> 0x0078 }
            r1 = com.iqoption.trading.history.a.b.this;	 Catch:{ InterruptedException -> 0x0078, InterruptedException -> 0x0078 }
            r5 = r1.dsG;	 Catch:{ InterruptedException -> 0x0078, InterruptedException -> 0x0078 }
            r1 = com.iqoption.trading.history.a.b.this;	 Catch:{ InterruptedException -> 0x0078, InterruptedException -> 0x0078 }
            r6 = r1.dsH;	 Catch:{ InterruptedException -> 0x0078, InterruptedException -> 0x0078 }
            r1 = com.iqoption.trading.history.a.b.this;	 Catch:{ InterruptedException -> 0x0078, InterruptedException -> 0x0078 }
            r8 = r1.cSy;	 Catch:{ InterruptedException -> 0x0078, InterruptedException -> 0x0078 }
            r10 = r15;
            r11 = r14;
            r14 = com.iqoption.mobbtech.connect.request.api.f.a(r2, r4, r5, r6, r8, r10, r11);	 Catch:{ InterruptedException -> 0x0078, InterruptedException -> 0x0078 }
            r14 = r14.get();	 Catch:{ InterruptedException -> 0x0078, InterruptedException -> 0x0078 }
            r14 = (com.iqoption.trading.history.b.c) r14;	 Catch:{ InterruptedException -> 0x0078, InterruptedException -> 0x0078 }
            r0.dsI = r14;	 Catch:{ InterruptedException -> 0x0078, InterruptedException -> 0x0078 }
        L_0x0054:
            r14 = com.iqoption.trading.history.a.b.this;	 Catch:{ InterruptedException -> 0x0078, InterruptedException -> 0x0078 }
            r14 = r14.dsI;	 Catch:{ InterruptedException -> 0x0078, InterruptedException -> 0x0078 }
            r14 = r14.dsW;	 Catch:{ InterruptedException -> 0x0078, InterruptedException -> 0x0078 }
            r0 = com.iqoption.util.i.H(r14);	 Catch:{ InterruptedException -> 0x0078, InterruptedException -> 0x0078 }
            if (r0 != 0) goto L_0x0077;
        L_0x0062:
            r0 = r14.size();	 Catch:{ InterruptedException -> 0x0078, InterruptedException -> 0x0078 }
            if (r0 >= r15) goto L_0x0069;
        L_0x0068:
            goto L_0x0077;
        L_0x0069:
            r0 = 0;
        L_0x006a:
            if (r0 >= r15) goto L_0x0078;
        L_0x006c:
            r1 = r14.get(r0);	 Catch:{ InterruptedException -> 0x0078, InterruptedException -> 0x0078 }
            r1 = (com.iqoption.trading.history.b.b) r1;	 Catch:{ InterruptedException -> 0x0078, InterruptedException -> 0x0078 }
            r13[r0] = r1;	 Catch:{ InterruptedException -> 0x0078, InterruptedException -> 0x0078 }
            r0 = r0 + 1;
            goto L_0x006a;
        L_0x0077:
            return;
        L_0x0078:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.trading.history.a.b.1.a(com.iqoption.trading.history.b.b[], int, int):void");
        }
    };
    private final ViewCallback dsK = new ViewCallback() {
        public void getItemRangeInto(int[] iArr) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) b.this.ahx.getLayoutManager();
            iArr[0] = linearLayoutManager.findFirstVisibleItemPosition();
            iArr[1] = linearLayoutManager.findLastVisibleItemPosition();
            if (iArr[0] == -1 && iArr[1] == -1) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
        }

        public void onDataRefresh() {
            b.this.notifyDataSetChanged();
        }

        public void onItemLoaded(int i) {
            b.this.notifyItemChanged(i);
        }
    };
    private final OnScrollListener dsL = new OnScrollListener() {
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (b.this.dsM != null) {
                b.this.dsM.onRangeChanged();
            }
        }
    };
    private final AsyncListUtil<com.iqoption.trading.history.b.b> dsM = new AsyncListUtil(com.iqoption.trading.history.b.b.class, 50, this.dsJ, this.dsK);
    private volatile boolean dsN = true;

    /* compiled from: PortfolioClosedListAdapter */
    public interface a {
        void a(com.iqoption.trading.history.b.b bVar);
    }

    public void a(c cVar) {
        this.dsI = cVar;
        this.dsM.refresh();
    }

    public b(a aVar, c cVar, RecyclerView recyclerView, long j, InstrumentType[] instrumentTypeArr, int[] iArr, long j2, long j3) {
        this.dsC = aVar;
        this.dsB = cVar;
        this.cUZ = j;
        this.dsH = j2;
        this.cSy = j3;
        this.dsF = instrumentTypeArr;
        this.dsG = iArr;
        this.ahx = recyclerView;
    }

    /* renamed from: W */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(fm.i(this.dsB.layoutInflater, viewGroup, false), this.dsC, this.dsB);
    }

    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        aVar.a((com.iqoption.trading.history.b.b) this.dsM.getItem(i), i != 0 ? (com.iqoption.trading.history.b.b) this.dsM.getItem(i - 1) : null);
    }

    public int getItemCount() {
        return this.dsM.getItemCount();
    }

    public void onStop() {
        this.dsN = true;
        this.ahx.removeOnScrollListener(this.dsL);
    }

    public void onStart() {
        this.dsN = false;
        this.ahx.addOnScrollListener(this.dsL);
    }
}
