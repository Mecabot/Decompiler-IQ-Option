package com.iqoption.charttools.constructor.a;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.iqoption.charttools.o;
import com.iqoption.charttools.o.d;
import com.iqoption.charttools.o.f;
import com.iqoption.core.ext.a;
import com.iqoption.core.ui.widget.recyclerview.a.b;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, aXE = {"Lcom/iqoption/charttools/constructor/viewholder/ErrorViewHolder;", "Lcom/iqoption/core/ui/widget/recyclerview/viewholder/IQViewHolder;", "", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "bind", "", "item", "techtools_release"})
/* compiled from: ErrorViewHolder.kt */
public final class c extends b<Object> {
    public void bb(Object obj) {
    }

    public c(ViewGroup viewGroup) {
        h.e(viewGroup, "parent");
        super(new TextView(viewGroup.getContext()));
        View view = this.itemView;
        if (view == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
        TextView textView = (TextView) view;
        textView.setLayoutParams(new LayoutParams(-1, -1));
        textView.setGravity(17);
        View view2 = textView;
        int f = a.f(view2, d.dp16);
        textView.setPadding(f, 0, f, 0);
        textView.setText(o.i.we_did_not_get_enough_data_to_display_indicator);
        textView.setTextColor(a.b(view2, com.iqoption.charttools.o.c.grey_blue_50));
        textView.setTextSize(0, a.e(view2, d.sp16));
        textView.setTypeface(a.g(view2, f.medium));
    }
}
