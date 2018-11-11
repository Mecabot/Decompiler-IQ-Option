package com.iqoption.deposit.old;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.iqoption.core.ui.widget.recyclerview.adapter.a;
import com.iqoption.d.wh;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\u0012\u0010\u001a\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, aXE = {"Lcom/iqoption/deposit/old/MethodsOldAdapter;", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/IQAdapter;", "Lcom/iqoption/deposit/old/MethodOldViewHolder;", "Lcom/iqoption/deposit/old/PayMethodItem;", "Landroid/widget/ListAdapter;", "clickListener", "Lcom/iqoption/deposit/old/OnMethodClickListenerOld;", "(Lcom/iqoption/deposit/old/OnMethodClickListenerOld;)V", "areAllItemsEnabled", "", "getCount", "", "getView", "Landroid/view/View;", "position", "convertView", "parent", "Landroid/view/ViewGroup;", "getViewTypeCount", "isEmpty", "isEnabled", "onBindViewHolder", "", "holder", "onCreateViewHolder", "viewType", "registerDataSetObserver", "observer", "Landroid/database/DataSetObserver;", "unregisterDataSetObserver", "IqOption-5.5.1_optionXRelease"})
/* compiled from: MethodsOldAdapter.kt */
public final class b extends a<a, e> implements ListAdapter {
    private final c cbU;

    public boolean areAllItemsEnabled() {
        return true;
    }

    public int getViewTypeCount() {
        return 1;
    }

    public boolean isEnabled(int i) {
        return true;
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public b(c cVar) {
        h.e(cVar, "clickListener");
        this.cbU = cVar;
    }

    /* renamed from: x */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        h.e(viewGroup, "parent");
        return new a((wh) com.iqoption.core.ext.a.a(viewGroup, (int) R.layout.item_payment_method_old, null, false, 6, null), this.cbU, true);
    }

    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        h.e(aVar, "holder");
        aVar.a((e) getItem(i));
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        h.e(viewGroup, "parent");
        Object tag = view != null ? view.getTag() : null;
        if (!(tag instanceof a)) {
            tag = null;
        }
        a aVar = (a) tag;
        if (aVar == null) {
            aVar = onCreateViewHolder(viewGroup, 0);
            View view2 = aVar.getView();
            h.d(view2, "holder.getView()");
            view2.setTag(aVar);
        }
        bindViewHolder(aVar, i);
        View view3 = aVar.getView();
        h.d(view3, "holder.getView()");
        return view3;
    }

    public int getCount() {
        return getItemCount();
    }
}
