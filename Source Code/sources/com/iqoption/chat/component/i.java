package com.iqoption.chat.component;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.iqoption.chat.viewmodel.c;
import com.iqoption.d.cu;
import com.iqoption.x.R;
import java.util.List;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.h;
import kotlin.l;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0015H\u0016R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR0\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, aXE = {"Lcom/iqoption/chat/component/FileItemsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onSelect", "Lkotlin/Function1;", "Lcom/iqoption/chat/viewmodel/FileItem;", "", "(Lkotlin/jvm/functions/Function1;)V", "value", "", "isEmpty", "()Z", "setEmpty", "(Z)V", "", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getItemCount", "", "getItemId", "", "position", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: FileItemsAdapter.kt */
public final class i extends Adapter<ViewHolder> {
    public static final a aDg = new a();
    private final b<c, l> aDe;
    private boolean isEmpty;
    private List<c> nj = m.emptyList();

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, aXE = {"Lcom/iqoption/chat/component/FileItemsAdapter$Companion;", "", "()V", "VIEW_TYPE_EMPTY", "", "VIEW_TYPE_ITEM", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: FileItemsAdapter.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public i(b<? super c, l> bVar) {
        h.e(bVar, "onSelect");
        this.aDe = bVar;
        setHasStableIds(true);
    }

    public final void setItems(List<c> list) {
        h.e(list, FirebaseAnalytics.b.VALUE);
        this.nj = list;
        notifyDataSetChanged();
    }

    public final void ca(boolean z) {
        if (this.isEmpty != z) {
            this.isEmpty = z;
            notifyDataSetChanged();
        }
    }

    public long getItemId(int i) {
        if (this.isEmpty) {
            return 0;
        }
        return ((c) this.nj.get(i)).getId();
    }

    public int getItemViewType(int i) {
        return this.isEmpty ? 1 : 2;
    }

    public int getItemCount() {
        if (this.isEmpty) {
            return 1;
        }
        return this.nj.size();
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        h.e(viewGroup, "parent");
        if (i != 1) {
            return new h((cu) com.iqoption.core.ext.a.a(viewGroup, (int) R.layout.chat_file_picker_item, null, false, 6, null), this.aDe);
        }
        return new g(com.iqoption.core.ext.a.a(viewGroup, (int) R.layout.chat_file_picker_empty_item, null, false, 6, null));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        h.e(viewHolder, "holder");
        if (viewHolder.getItemViewType() == 2) {
            ((h) viewHolder).b((c) this.nj.get(i));
        }
    }
}
