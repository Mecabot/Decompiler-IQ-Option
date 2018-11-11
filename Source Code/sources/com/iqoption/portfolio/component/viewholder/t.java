package com.iqoption.portfolio.component.viewholder;

import android.view.ViewGroup;
import com.iqoption.core.e.c;
import com.iqoption.core.ext.a;
import com.iqoption.d.afd;
import com.iqoption.x.R;
import kotlin.e.d;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078V@VX\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000f"}, aXE = {"Lcom/iqoption/portfolio/component/viewholder/MicroFilterViewHolder;", "Lcom/iqoption/portfolio/component/viewholder/FilterViewHolders;", "Lcom/iqoption/databinding/PortfolioMicroFilterItemBinding;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "<set-?>", "Lcom/iqoption/portfolio/component/data/FilterItem;", "bound", "getBound", "()Lcom/iqoption/portfolio/component/data/FilterItem;", "setBound", "(Lcom/iqoption/portfolio/component/data/FilterItem;)V", "bound$delegate", "Lkotlin/properties/ReadWriteProperty;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: FilterViewHolders.kt */
public final class t extends k<afd> {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(t.class), "bound", "getBound()Lcom/iqoption/portfolio/component/data/FilterItem;"))};
    private final d bXV = c.h(new MicroFilterViewHolder$$special$$inlined$bindable$1(getBinding(), this));

    public void a(com.iqoption.portfolio.component.b.d dVar) {
        h.e(dVar, "<set-?>");
        this.bXV.a(this, apP[0], dVar);
    }

    public com.iqoption.portfolio.component.b.d axv() {
        return (com.iqoption.portfolio.component.b.d) this.bXV.b(this, apP[0]);
    }

    public t(ViewGroup viewGroup) {
        h.e(viewGroup, "parent");
        super(a.a(viewGroup, (int) R.layout.portfolio_micro_filter_item, null, false, 6, null));
    }
}
