package com.iqoption.deposit.light.constructor.selector.integer;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.iqoption.core.e.c;
import com.iqoption.core.ext.g;
import com.iqoption.deposit.a.ai;
import kotlin.e.d;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0010"}, aXE = {"Lcom/iqoption/deposit/light/constructor/selector/integer/SelectorIntegerLightViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iqoption/deposit/databinding/ItemConstructorSpinnerLightBinding;", "itemSelectListener", "Lcom/iqoption/deposit/constructor/selector/integer/OnIntegerItemSelectListener;", "(Lcom/iqoption/deposit/databinding/ItemConstructorSpinnerLightBinding;Lcom/iqoption/deposit/constructor/selector/integer/OnIntegerItemSelectListener;)V", "<set-?>", "Lcom/iqoption/deposit/constructor/selector/integer/SelectorIntegerAdapterItem;", "bound", "getBound", "()Lcom/iqoption/deposit/constructor/selector/integer/SelectorIntegerAdapterItem;", "setBound", "(Lcom/iqoption/deposit/constructor/selector/integer/SelectorIntegerAdapterItem;)V", "bound$delegate", "Lkotlin/properties/ReadWriteProperty;", "deposit_release"})
/* compiled from: SelectorIntegerLightViewHolder.kt */
public final class b extends ViewHolder {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "bound", "getBound()Lcom/iqoption/deposit/constructor/selector/integer/SelectorIntegerAdapterItem;"))};
    private final d bXV;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class a extends g {
        final /* synthetic */ com.iqoption.deposit.constructor.selector.integer.a bXX;
        final /* synthetic */ b caK;

        public a(b bVar, com.iqoption.deposit.constructor.selector.integer.a aVar) {
            this.caK = bVar;
            this.bXX = aVar;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            this.bXX.c(this.caK.acQ());
        }
    }

    public final com.iqoption.deposit.constructor.selector.integer.b acQ() {
        return (com.iqoption.deposit.constructor.selector.integer.b) this.bXV.b(this, apP[0]);
    }

    public final void d(com.iqoption.deposit.constructor.selector.integer.b bVar) {
        h.e(bVar, "<set-?>");
        this.bXV.a(this, apP[0], bVar);
    }

    public b(ai aiVar, com.iqoption.deposit.constructor.selector.integer.a aVar) {
        h.e(aiVar, "binding");
        h.e(aVar, "itemSelectListener");
        super(aiVar.getRoot());
        View view = this.itemView;
        h.d(view, "itemView");
        view.setOnClickListener(new a(this, aVar));
        this.bXV = c.h(new SelectorIntegerLightViewHolder$$special$$inlined$bindable$1(aiVar, aiVar));
    }
}
