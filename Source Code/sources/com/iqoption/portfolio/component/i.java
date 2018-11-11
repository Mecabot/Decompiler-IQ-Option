package com.iqoption.portfolio.component;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.iqoption.portfolio.a.r;
import com.iqoption.portfolio.component.b.k;
import com.iqoption.portfolio.component.b.l;
import com.iqoption.portfolio.component.viewholder.ao;
import com.iqoption.util.aw;
import com.iqoption.view.a.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: PendingPositionsAdapter */
public final class i extends Adapter<ao> {
    private static final String TAG = "com.iqoption.portfolio.component.i";
    private RecyclerView ahx;
    private final p<ao, k, r> cYY;
    private final ArrayList<k> cYZ = new ArrayList();
    private final com.iqoption.view.a.b.a clw = new j(this);

    /* compiled from: PendingPositionsAdapter */
    private static final class a {
        int count;
        int startPosition;

        private a() {
        }

        a fR(int i) {
            this.startPosition = i;
            return this;
        }

        a fS(int i) {
            this.count = i;
            return this;
        }
    }

    final /* synthetic */ void bL(long j) {
        if (this.ahx != null) {
            int childCount = this.ahx.getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewHolder childViewHolder = this.ahx.getChildViewHolder(this.ahx.getChildAt(i));
                if (childViewHolder instanceof ao) {
                    ((ao) childViewHolder).axw();
                }
            }
        }
    }

    public i(p<ao, k, r> pVar) {
        this.cYY = pVar;
        setHasStableIds(true);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.ahx = recyclerView;
        b.aIK().a(this.clw);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.ahx = null;
        b.aIK().b(this.clw);
    }

    /* renamed from: Q */
    public ao onCreateViewHolder(ViewGroup viewGroup, int i) {
        return (ao) this.cYY.b(i, viewGroup);
    }

    /* renamed from: a */
    public void onBindViewHolder(ao aoVar, int i) {
        this.cYY.a(aoVar.getItemViewType(), aoVar, fQ(i));
    }

    public int getItemCount() {
        return this.cYZ.size();
    }

    public int getItemViewType(int i) {
        return fQ(i).getViewType();
    }

    public long getItemId(int i) {
        return r.cZq.dU(fQ(i).Ml());
    }

    public k fQ(int i) {
        return (k) this.cYZ.get(i);
    }

    public void setItems(List<k> list) {
        this.cYZ.clear();
        if (list != null) {
            this.cYZ.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void awF() {
        if (this.ahx != null) {
            int childCount = this.ahx.getChildCount();
            fN(childCount);
            for (int i = 0; i < childCount; i++) {
                ((ao) this.ahx.getChildViewHolder(this.ahx.getChildAt(i))).awF();
            }
        }
    }

    private void fN(int i) {
        if (getItemCount() != i && i > 1) {
            List<Integer> arrayList = new ArrayList();
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(Integer.valueOf(this.ahx.getChildAdapterPosition(this.ahx.getChildAt(i2))));
            }
            Collections.sort(arrayList);
            i = getItemCount() - 1;
            List<a> arrayList2 = new ArrayList();
            int i3 = -1;
            for (Integer num : arrayList) {
                if (i3 == -1) {
                    arrayList2.add(new a().fR(0).fS(num.intValue()));
                } else if (num.intValue() - i3 > 1) {
                    arrayList2.add(new a().fR(i3 + 1).fS((num.intValue() - i3) - 1));
                }
                i3 = num.intValue();
            }
            if (!arrayList2.isEmpty()) {
                int intValue = ((Integer) arrayList.get(arrayList.size() - 1)).intValue();
                if (intValue < i) {
                    arrayList2.add(new a().fR(intValue + 1).fS(i - intValue));
                }
            }
            for (a aVar : arrayList2) {
                if (aVar.count > 0) {
                    notifyItemRangeChanged(aVar.startPosition, aVar.count);
                }
            }
        }
    }

    public void iS(String str) {
        int iU = iU(str);
        if (iU != -1) {
            l lVar = (l) this.cYZ.get(iU);
            if (lVar.awY()) {
                notifyItemChanged(iU);
            } else {
                Collection axa = lVar.axa();
                iU++;
                int size = axa.size();
                this.cYZ.addAll(iU, axa);
                notifyItemRangeInserted(iU, size);
            }
        }
    }

    public void iT(String str) {
        int iU = iU(str);
        if (iU != -1) {
            l lVar = (l) this.cYZ.get(iU);
            if (lVar.awY()) {
                notifyItemChanged(iU);
            } else {
                Collection axa = lVar.axa();
                iU++;
                int size = axa.size();
                this.cYZ.removeAll(axa);
                notifyItemRangeRemoved(iU, size);
            }
        }
    }

    public int iU(String str) {
        Iterator it = this.cYZ.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (aw.equals(((k) it.next()).Ml(), str)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void av(String str, String str2) {
        if (!(str2 == null || aw.equals(str2, str))) {
            notifyItemChanged(iU(str2));
        }
        notifyItemChanged(iU(str));
    }
}
