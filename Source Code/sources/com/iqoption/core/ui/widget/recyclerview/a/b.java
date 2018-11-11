package com.iqoption.core.ui.widget.recyclerview.a;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.google.android.gms.analytics.ecommerce.Promotion;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000bR*\u0010\u0007\u001a\u0004\u0018\u00018\u00002\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000@FX\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0010"}, aXE = {"Lcom/iqoption/core/ui/widget/recyclerview/viewholder/IQViewHolder;", "Item", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "value", "bound", "getBound", "()Ljava/lang/Object;", "setBound", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "bind", "", "item", "core_release"})
/* compiled from: IQViewHolder.kt */
public abstract class b<Item> extends ViewHolder {
    private Item bgv;

    public abstract void bb(Item item);

    public b(View view) {
        h.e(view, Promotion.ACTION_VIEW);
        super(view);
    }

    public final Item ZU() {
        return this.bgv;
    }

    public final void bo(Item item) {
        this.bgv = item;
        if (item != null) {
            bb(item);
        }
    }
}
