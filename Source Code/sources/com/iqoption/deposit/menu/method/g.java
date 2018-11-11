package com.iqoption.deposit.menu.method;

import android.view.ViewGroup;
import com.iqoption.core.ui.widget.recyclerview.adapter.a;
import com.iqoption.deposit.a.ao;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, aXE = {"Lcom/iqoption/deposit/menu/method/MethodsAdapter;", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/IQAdapter;", "Lcom/iqoption/deposit/menu/method/MethodViewHolder;", "Lcom/iqoption/deposit/menu/method/MethodAdapterItem;", "clickListener", "Lcom/iqoption/deposit/menu/method/OnMethodClickListener;", "(Lcom/iqoption/deposit/menu/method/OnMethodClickListener;)V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "deposit_release"})
/* compiled from: MethodsAdapter.kt */
public final class g extends a<f, b> {
    private final i cbC;

    public g(i iVar) {
        h.e(iVar, "clickListener");
        this.cbC = iVar;
    }

    /* renamed from: w */
    public f onCreateViewHolder(ViewGroup viewGroup, int i) {
        h.e(viewGroup, "parent");
        return new f((ao) com.iqoption.core.ext.a.a(viewGroup, com.iqoption.deposit.r.g.item_payment_method, null, false, 6, null), this.cbC);
    }

    /* renamed from: a */
    public void onBindViewHolder(f fVar, int i) {
        h.e(fVar, "holder");
        fVar.a((b) getItem(i));
    }
}
