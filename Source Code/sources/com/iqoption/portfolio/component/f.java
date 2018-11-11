package com.iqoption.portfolio.component;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.ViewGroup;
import com.iqoption.portfolio.a.o;
import com.iqoption.portfolio.component.b.i;
import com.iqoption.portfolio.component.viewholder.ai;
import com.iqoption.util.aw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: OpenPositionsAdapter */
public final class f extends Adapter<ai> {
    private RecyclerView ahx;
    private final p<ai, com.iqoption.portfolio.component.b.f, n> cYY;
    private final ArrayList<com.iqoption.portfolio.component.b.f> cYZ = new ArrayList();

    /* compiled from: OpenPositionsAdapter */
    private static final class a {
        int count;
        int startPosition;

        private a() {
        }

        a fO(int i) {
            this.startPosition = i;
            return this;
        }

        a fP(int i) {
            this.count = i;
            return this;
        }
    }

    public f(p<ai, com.iqoption.portfolio.component.b.f, n> pVar) {
        this.cYY = pVar;
        setHasStableIds(true);
    }

    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.ahx = recyclerView;
    }

    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.ahx = null;
    }

    @NonNull
    /* renamed from: P */
    public ai onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return (ai) this.cYY.b(i, viewGroup);
    }

    /* renamed from: a */
    public void onBindViewHolder(@NonNull ai aiVar, int i) {
        this.cYY.a(aiVar.getItemViewType(), aiVar, fM(i));
    }

    public int getItemCount() {
        return this.cYZ.size();
    }

    public int getItemViewType(int i) {
        return fM(i).getViewType();
    }

    public long getItemId(int i) {
        return o.cZq.dU(fM(i).Ml());
    }

    public com.iqoption.portfolio.component.b.f fM(int i) {
        return (com.iqoption.portfolio.component.b.f) this.cYZ.get(i);
    }

    public void setItems(List<com.iqoption.portfolio.component.b.f> list) {
        this.cYZ.clear();
        if (list != null) {
            this.cYZ.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void awD() {
        if (this.ahx != null) {
            int childCount = this.ahx.getChildCount();
            fN(childCount);
            for (int i = 0; i < childCount; i++) {
                ((ai) this.ahx.getChildViewHolder(this.ahx.getChildAt(i))).awD();
            }
        }
    }

    public void awE() {
        if (this.ahx != null) {
            int childCount = this.ahx.getChildCount();
            fN(childCount);
            for (int i = 0; i < childCount; i++) {
                ((ai) this.ahx.getChildViewHolder(this.ahx.getChildAt(i))).awE();
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
                    arrayList2.add(new a().fO(0).fP(num.intValue()));
                } else if (num.intValue() - i3 > 1) {
                    arrayList2.add(new a().fO(i3 + 1).fP((num.intValue() - i3) - 1));
                }
                i3 = num.intValue();
            }
            if (!arrayList2.isEmpty()) {
                int intValue = ((Integer) arrayList.get(arrayList.size() - 1)).intValue();
                if (intValue < i) {
                    arrayList2.add(new a().fO(intValue + 1).fP(i - intValue));
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
            i iVar = (i) this.cYZ.get(iU);
            if (iVar.awY()) {
                notifyItemChanged(iU);
            } else {
                Collection awZ = iVar.awZ();
                iU++;
                int size = awZ.size();
                this.cYZ.addAll(iU, awZ);
                notifyItemRangeInserted(iU, size);
            }
        }
    }

    public void iT(String str) {
        int iU = iU(str);
        if (iU != -1) {
            i iVar = (i) this.cYZ.get(iU);
            if (iVar.awY()) {
                notifyItemChanged(iU);
            } else {
                Collection awZ = iVar.awZ();
                iU++;
                int size = awZ.size();
                this.cYZ.removeAll(awZ);
                notifyItemRangeRemoved(iU, size);
            }
        }
    }

    public int iU(String str) {
        Iterator it = this.cYZ.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (aw.equals(((com.iqoption.portfolio.component.b.f) it.next()).Ml(), str)) {
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
