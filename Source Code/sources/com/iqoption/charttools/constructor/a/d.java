package com.iqoption.charttools.constructor.a;

import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.plus.PlusShare;
import com.iqoption.charttools.constructor.k;
import com.iqoption.charttools.o;
import com.iqoption.core.ui.widget.recyclerview.a.c;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, aXE = {"Lcom/iqoption/charttools/constructor/viewholder/GroupDescriptionViewHolder;", "Lcom/iqoption/core/ui/widget/recyclerview/viewholder/VDBindingHolder;", "Lcom/iqoption/charttools/databinding/IndicatorConstructorGroupDescriptionItemBinding;", "Lcom/iqoption/charttools/constructor/InputGroupDescription;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "bind", "", "item", "techtools_release"})
/* compiled from: GroupDescriptionViewHolder.kt */
public final class d extends c<com.iqoption.charttools.b.i, k> {
    public d(ViewGroup viewGroup) {
        h.e(viewGroup, "parent");
        super(o.h.indicator_constructor_group_description_item, viewGroup);
    }

    public void a(com.iqoption.charttools.b.i iVar, k kVar) {
        h.e(iVar, "$receiver");
        h.e(kVar, "item");
        TextView textView = iVar.axy;
        h.d(textView, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
        textView.setText(kVar.getText());
    }
}
