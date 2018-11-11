package com.iqoption.signals;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.iqoption.core.e.c;
import com.iqoption.d.ajk;
import kotlin.e.d;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000e"}, aXE = {"Lcom/iqoption/signals/SignalTitleViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iqoption/databinding/SignalTitleItemBinding;", "(Lcom/iqoption/databinding/SignalTitleItemBinding;)V", "<set-?>", "Lcom/iqoption/signals/SignalTitleItem;", "bound", "getBound", "()Lcom/iqoption/signals/SignalTitleItem;", "setBound", "(Lcom/iqoption/signals/SignalTitleItem;)V", "bound$delegate", "Lkotlin/properties/ReadWriteProperty;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: SignalTitleViewHolder.kt */
public final class g extends ViewHolder {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "bound", "getBound()Lcom/iqoption/signals/SignalTitleItem;"))};
    private final d bXV;

    public final void a(f fVar) {
        h.e(fVar, "<set-?>");
        this.bXV.a(this, apP[0], fVar);
    }

    public g(ajk ajk) {
        h.e(ajk, "binding");
        super(ajk.getRoot());
        this.bXV = c.h(new SignalTitleViewHolder$$special$$inlined$bindable$1(ajk));
    }
}
