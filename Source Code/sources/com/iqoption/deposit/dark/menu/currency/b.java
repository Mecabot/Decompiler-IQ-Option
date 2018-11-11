package com.iqoption.deposit.dark.menu.currency;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.iqoption.core.e.c;
import com.iqoption.core.ext.g;
import com.iqoption.deposit.a.ak;
import com.iqoption.deposit.menu.method.h;
import kotlin.e.d;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0010"}, aXE = {"Lcom/iqoption/deposit/dark/menu/currency/CurrencyDarkViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iqoption/deposit/databinding/ItemCurrencyBinding;", "clickListener", "Lcom/iqoption/deposit/menu/method/OnCurrencyClickListener;", "(Lcom/iqoption/deposit/databinding/ItemCurrencyBinding;Lcom/iqoption/deposit/menu/method/OnCurrencyClickListener;)V", "<set-?>", "Lcom/iqoption/deposit/menu/currency/CurrencyAdapterItem;", "bound", "getBound", "()Lcom/iqoption/deposit/menu/currency/CurrencyAdapterItem;", "setBound", "(Lcom/iqoption/deposit/menu/currency/CurrencyAdapterItem;)V", "bound$delegate", "Lkotlin/properties/ReadWriteProperty;", "deposit_release"})
/* compiled from: CurrencyDarkViewHolder.kt */
public final class b extends ViewHolder {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "bound", "getBound()Lcom/iqoption/deposit/menu/currency/CurrencyAdapterItem;"))};
    private final d bXV;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class a extends g {
        final /* synthetic */ b bYh;
        final /* synthetic */ h bYi;

        public a(b bVar, h hVar) {
            this.bYh = bVar;
            this.bYi = hVar;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            this.bYi.d(this.bYh.acW().adD());
        }
    }

    public final void a(com.iqoption.deposit.menu.currency.a aVar) {
        kotlin.jvm.internal.h.e(aVar, "<set-?>");
        this.bXV.a(this, apP[0], aVar);
    }

    public final com.iqoption.deposit.menu.currency.a acW() {
        return (com.iqoption.deposit.menu.currency.a) this.bXV.b(this, apP[0]);
    }

    public b(ak akVar, h hVar) {
        kotlin.jvm.internal.h.e(akVar, "binding");
        kotlin.jvm.internal.h.e(hVar, "clickListener");
        super(akVar.getRoot());
        View view = this.itemView;
        kotlin.jvm.internal.h.d(view, "itemView");
        view.setOnClickListener(new a(this, hVar));
        this.bXV = c.h(new CurrencyDarkViewHolder$$special$$inlined$bindable$1(akVar, akVar));
    }
}
