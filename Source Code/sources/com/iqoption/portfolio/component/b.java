package com.iqoption.portfolio.component;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.google.common.collect.ImmutableList;
import com.iqoption.d.zq;
import com.iqoption.d.zs;
import com.iqoption.portfolio.component.viewholder.e;
import com.iqoption.portfolio.component.viewholder.f;
import com.iqoption.util.i;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ClosedGroupAdapter */
public class b extends Adapter<ViewHolder> {
    private final List<com.iqoption.portfolio.b> aze = new ArrayList();
    private final n cYT;

    public b(n nVar) {
        this.cYT = nVar;
        setHasStableIds(true);
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new e(zq.S(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
        }
        return new f(zs.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false), this.cYT);
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        if (viewHolder.getItemViewType() == 1) {
            ((f) viewHolder).b((com.iqoption.portfolio.b) this.aze.get(i), i != 0 ? (com.iqoption.portfolio.b) this.aze.get(i - 1) : null);
        }
    }

    public int getItemCount() {
        int size = this.aze.size();
        return size != 0 ? size : 1;
    }

    public long getItemId(int i) {
        if (this.aze.size() == 0) {
            return 0;
        }
        return ((com.iqoption.portfolio.b) this.aze.get(i)).getId();
    }

    public int getItemViewType(int i) {
        return (i == 0 && this.aze.isEmpty()) ? 0 : 1;
    }

    public void z(ImmutableList<com.iqoption.portfolio.b> immutableList) {
        this.aze.clear();
        if (!i.H(immutableList)) {
            this.aze.addAll(immutableList);
        }
        notifyDataSetChanged();
    }
}
