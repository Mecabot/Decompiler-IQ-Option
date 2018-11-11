package com.iqoption.deposit.light.methods;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.iqoption.core.ui.widget.recyclerview.adapter.a;
import com.iqoption.deposit.a.aq;
import com.iqoption.deposit.a.as;
import com.iqoption.deposit.menu.method.b;
import com.iqoption.deposit.r.g;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, aXE = {"Lcom/iqoption/deposit/light/methods/MethodsLightAdapter;", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/IQAdapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Lcom/iqoption/deposit/menu/method/BaseMethodAdapterItem;", "callback", "Lcom/iqoption/deposit/light/methods/OnMethodCallbackLight;", "(Lcom/iqoption/deposit/light/methods/OnMethodCallbackLight;)V", "getItemViewType", "", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "deposit_release"})
/* compiled from: MethodsLightAdapter.kt */
public final class d extends a<ViewHolder, com.iqoption.deposit.menu.method.a> {
    private final g caU;

    public d(g gVar) {
        h.e(gVar, "callback");
        this.caU = gVar;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        h.e(viewGroup, "parent");
        switch (i) {
            case 0:
                return new a((aq) com.iqoption.core.ext.a.a(viewGroup, g.item_payment_method_light, null, false, 6, null), this.caU);
            case 1:
                return new c((as) com.iqoption.core.ext.a.a(viewGroup, g.item_payment_method_title_light, null, false, 6, null));
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected case ");
                stringBuilder.append(i);
                throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        h.e(viewHolder, "holder");
        com.iqoption.deposit.menu.method.a aVar = (com.iqoption.deposit.menu.method.a) getItem(i);
        switch (aVar.getViewType()) {
            case 0:
                a aVar2 = (a) viewHolder;
                if (aVar == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.iqoption.deposit.menu.method.MethodAdapterItem");
                }
                aVar2.a((b) aVar);
                return;
            case 1:
                c cVar = (c) viewHolder;
                if (aVar == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.iqoption.deposit.light.methods.MethodTitleAdapterItem");
                }
                cVar.a((b) aVar);
                return;
            default:
                return;
        }
    }

    public int getItemViewType(int i) {
        return ((com.iqoption.deposit.menu.method.a) getItem(i)).getViewType();
    }
}
