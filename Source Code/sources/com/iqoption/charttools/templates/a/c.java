package com.iqoption.charttools.templates.a;

import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.iqoption.charttools.o.d;
import com.iqoption.charttools.templates.o;
import com.iqoption.core.ext.a;
import com.iqoption.core.ui.widget.recyclerview.a.b;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, aXE = {"Lcom/iqoption/charttools/templates/viewholder/TitleViewHolder;", "Lcom/iqoption/core/ui/widget/recyclerview/viewholder/IQViewHolder;", "Lcom/iqoption/charttools/templates/TitleItem;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "bind", "", "item", "techtools_release"})
/* compiled from: TitleViewHolder.kt */
public final class c extends b<o> {
    public c(ViewGroup viewGroup) {
        h.e(viewGroup, "parent");
        super(new TextView(viewGroup.getContext()));
        View view = this.itemView;
        if (view == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
        TextView textView = (TextView) view;
        View view2 = textView;
        textView.setLayoutParams(new LayoutParams(-1, a.f(view2, d.dp48)));
        int f = a.f(view2, d.dp16);
        textView.setPadding(f, 0, f, 0);
        textView.setGravity(16);
        textView.setTextColor(a.b(view2, com.iqoption.charttools.o.c.grey_blue_70));
        if ((VERSION.SDK_INT >= 21 ? 1 : null) != null) {
            textView.setLetterSpacing(0.01f);
        }
        textView.setTextSize(0, a.e(view2, d.sp16));
    }

    /* renamed from: a */
    public void bb(o oVar) {
        h.e(oVar, "item");
        View view = this.itemView;
        if (view == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
        ((TextView) view).setText(oVar.getText());
    }
}
