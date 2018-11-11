package com.iqoption.core.ui.widget.recyclerview.adapter;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.iqoption.core.ui.widget.recyclerview.adapter.a.c;
import com.iqoption.core.ui.widget.recyclerview.adapter.a.d;
import java.util.List;
import kotlin.i;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u001e*\b\b\u0000\u0010\u0001*\u00020\u0002*\f\b\u0001\u0010\u0003*\u0006\u0012\u0002\b\u00030\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\nH\u0014J\u0013\u0010\u0012\u001a\u00028\u00012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\bJ@\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\b2(\b\u0002\u0010\u001b\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001cH\u0007J\u0014\u0010\u001d\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\bR\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R!\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, aXE = {"Lcom/iqoption/core/ui/widget/recyclerview/adapter/IQAdapter;", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Item", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/Identifiable;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "()V", "data", "", "diffCallback", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/DiffCallback;", "getDiffCallback", "()Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/DiffCallback;", "diffCallback$delegate", "Lkotlin/Lazy;", "diffRequest", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/DiffRequest;", "createDiffCallback", "getItem", "position", "", "(I)Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/Identifiable;", "getItemCount", "getItems", "setItems", "", "newItems", "onSet", "Lkotlin/Function2;", "setItemsBlocking", "Companion", "core_release"})
/* compiled from: IQAdapter.kt */
public abstract class a<VH extends ViewHolder, Item extends d<?>> extends Adapter<VH> {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "diffCallback", "getDiffCallback()Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/DiffCallback;"))};
    public static final a bgj = new a();
    private volatile List<? extends Item> aXq = m.emptyList();
    private com.iqoption.core.ui.widget.recyclerview.adapter.a.b<Item> bgh;
    private final kotlin.d bgi = g.f(new IQAdapter$diffCallback$2(this));

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0005¨\u0006\u0007"}, aXE = {"Lcom/iqoption/core/ui/widget/recyclerview/adapter/IQAdapter$Companion;", "", "()V", "unsupportedViewType", "", "viewType", "", "core_release"})
    /* compiled from: IQAdapter.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\f\b\u0001\u0010\u0004*\u0006\u0012\u0002\b\u00030\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Item", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/Identifiable;", "run"})
    /* compiled from: IQAdapter.kt */
    static final class b implements Runnable {
        final /* synthetic */ com.iqoption.core.ui.widget.recyclerview.adapter.a.b bgk;
        final /* synthetic */ m bgl;
        final /* synthetic */ a this$0;

        b(a aVar, com.iqoption.core.ui.widget.recyclerview.adapter.a.b bVar, m mVar) {
            this.this$0 = aVar;
            this.bgk = bVar;
            this.bgl = mVar;
        }

        public final void run() {
            final c a = this.bgk.a(this.this$0.ZM());
            com.iqoption.core.h.i.Yp().q(new Runnable(this) {
                final /* synthetic */ b bgm;

                public final void run() {
                    if (h.E(this.bgm.this$0.bgh, a.ZR())) {
                        this.bgm.this$0.aXq = a.ZR().ZQ();
                        a.ZS().dispatchUpdatesTo((Adapter) this.bgm.this$0);
                        m mVar = this.bgm.bgl;
                        if (mVar != null) {
                            l lVar = (l) mVar.B(a.ZR().ZP(), this.bgm.this$0.aXq);
                        }
                    }
                }
            });
        }
    }

    private final com.iqoption.core.ui.widget.recyclerview.adapter.a.a<Item> ZM() {
        kotlin.d dVar = this.bgi;
        j jVar = apP[0];
        return (com.iqoption.core.ui.widget.recyclerview.adapter.a.a) dVar.getValue();
    }

    public final void setItems(List<? extends Item> list) {
        a(this, list, null, 2, null);
    }

    public final Item dW(int i) {
        return (d) this.aXq.get(i);
    }

    public final List<Item> getItems() {
        return this.aXq;
    }

    public static /* synthetic */ void a(a aVar, List list, m mVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setItems");
        }
        if ((i & 2) != 0) {
            mVar = (m) null;
        }
        aVar.a(list, mVar);
    }

    public final void a(List<? extends Item> list, m<? super List<? extends Item>, ? super List<? extends Item>, l> mVar) {
        h.e(list, "newItems");
        com.iqoption.core.ui.widget.recyclerview.adapter.a.b bVar = new com.iqoption.core.ui.widget.recyclerview.adapter.a.b(this.aXq, list);
        this.bgh = bVar;
        com.iqoption.core.h.i.Yq().q(new b(this, bVar, mVar));
    }

    public final void ap(List<? extends Item> list) {
        h.e(list, "newItems");
        c a = new com.iqoption.core.ui.widget.recyclerview.adapter.a.b(this.aXq, list).a(ZM());
        this.aXq = a.ZR().ZQ();
        a.ZS().dispatchUpdatesTo((Adapter) this);
    }

    public int getItemCount() {
        return this.aXq.size();
    }

    protected com.iqoption.core.ui.widget.recyclerview.adapter.a.a<Item> ZN() {
        return new com.iqoption.core.ui.widget.recyclerview.adapter.a.a();
    }
}
