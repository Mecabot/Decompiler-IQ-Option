package com.iqoption.feed.feedlist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.feed.b.c;
import com.iqoption.feed.feedlist.TagLayout.b;
import com.iqoption.feed.feedlist.a.f;
import com.iqoption.feed.feedlist.b.e;
import com.iqoption.feed.feedlist.b.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: FeedAdapter */
public class d extends Adapter<i> {
    private final c cmD;
    private f cmE;
    private g cmF;
    private final a cmv;
    private final List<e> nj = new ArrayList();

    /* compiled from: FeedAdapter */
    public interface a extends b {
        void a(View view, e eVar);

        void f(com.iqoption.core.microservices.feed.response.a aVar);

        void g(@NonNull com.iqoption.core.microservices.feed.response.a aVar);

        boolean h(e eVar);
    }

    public d(c cVar, a aVar) {
        this.cmv = aVar;
        setHasStableIds(true);
        this.cmD = cVar;
    }

    @NonNull
    /* renamed from: D */
    public i onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return this.cmF.E(viewGroup, i);
    }

    /* renamed from: a */
    public void onBindViewHolder(@NonNull i iVar, int i) {
        this.cmE.a(iVar, (e) this.nj.get(i), getItemViewType(i));
    }

    public int getItemCount() {
        return this.nj.size();
    }

    public int getItemViewType(int i) {
        com.iqoption.core.microservices.feed.response.a ags = ((e) this.nj.get(i)).ags();
        String type = ags.getType();
        if ("video".equals(type)) {
            return "YouTube".equals(ags.getSource()) ? 1 : 2;
        } else {
            if ("tweet".equals(type)) {
                return 4;
            }
            return "article".equals(type) ? 3 : -1;
        }
    }

    public long getItemId(int i) {
        return (long) ((e) this.nj.get(i)).ags().getId();
    }

    public void cN(boolean z) {
        if (z) {
            this.cmE = new com.iqoption.feed.feedlist.a.d();
            this.cmF = new f(this.cmD, this.cmv);
            return;
        }
        this.cmE = new e();
        this.cmF = new h(this.cmD, this.cmv);
    }

    public void setItems(List<com.iqoption.core.microservices.feed.response.a> list) {
        this.nj.clear();
        this.nj.addAll(az(list));
        notifyDataSetChanged();
    }

    public void ay(List<com.iqoption.core.microservices.feed.response.a> list) {
        int size = this.nj.size();
        this.nj.addAll(az(list));
        notifyItemRangeInserted(size, list.size());
    }

    @NonNull
    private List<e> az(@NonNull List<com.iqoption.core.microservices.feed.response.a> list) {
        List<e> arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new e((com.iqoption.core.microservices.feed.response.a) list.get(i)));
        }
        return arrayList;
    }

    public int j(e eVar) {
        int indexOf = this.nj.indexOf(eVar);
        if (indexOf != -1) {
            this.nj.remove(eVar);
            notifyItemRemoved(indexOf);
        }
        return indexOf;
    }

    public void a(e eVar, int i) {
        if (i >= this.nj.size()) {
            this.nj.add(eVar);
            notifyItemInserted(this.nj.size() - 1);
            return;
        }
        this.nj.add(i, eVar);
        notifyItemInserted(i);
    }

    public void z(Map<Integer, com.iqoption.core.microservices.feed.response.d> map) {
        for (int i = 0; i < this.nj.size(); i++) {
            com.iqoption.core.microservices.feed.response.a ags = ((e) this.nj.get(i)).ags();
            com.iqoption.core.microservices.feed.response.d dVar = (com.iqoption.core.microservices.feed.response.d) map.get(Integer.valueOf(ags.getId()));
            if (dVar != null) {
                com.iqoption.feed.a.cle.a(ags, dVar);
                notifyItemChanged(i);
            }
        }
    }

    public void k(e eVar) {
        int indexOf = this.nj.indexOf(eVar);
        if (indexOf != -1) {
            notifyItemChanged(indexOf);
        }
    }
}
