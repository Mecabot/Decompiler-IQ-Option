package com.iqoption.deposit.light.c;

import android.view.ViewGroup;
import com.iqoption.core.ui.widget.recyclerview.adapter.a;
import com.iqoption.deposit.a.aw;
import com.iqoption.deposit.r.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, aXE = {"Lcom/iqoption/deposit/light/presets/PresetsLightAdapter;", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/IQAdapter;", "Lcom/iqoption/deposit/light/presets/PresetLightViewHolder;", "Lcom/iqoption/deposit/presets/PresetItem;", "listener", "Lcom/iqoption/deposit/light/presets/OnPresetLightClickListener;", "(Lcom/iqoption/deposit/light/presets/OnPresetLightClickListener;)V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelection", "selectedAmount", "", "deposit_release"})
/* compiled from: PresetsLightAdapter.kt */
public final class c extends a<b, com.iqoption.deposit.b.c> {
    private final a cbn;

    public c(a aVar) {
        h.e(aVar, "listener");
        this.cbn = aVar;
    }

    /* renamed from: v */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        h.e(viewGroup, "parent");
        return new b((aw) com.iqoption.core.ext.a.a(viewGroup, g.item_preset_light, null, false, 6, null), this.cbn);
    }

    /* renamed from: a */
    public void onBindViewHolder(b bVar, int i) {
        h.e(bVar, "holder");
        bVar.b((com.iqoption.deposit.b.c) getItem(i));
    }

    public final void setSelection(String str) {
        Iterable<Object> items = getItems();
        Collection arrayList = new ArrayList(n.e(items, 10));
        for (Object obj : items) {
            Object obj2;
            boolean z = str != null && com.iqoption.deposit.h.a(obj2.adX(), str);
            if (z != obj2.getSelected()) {
                obj2 = com.iqoption.deposit.b.c.a(obj2, null, null, z, 3, null);
            }
            arrayList.add(obj2);
        }
        ap((List) arrayList);
    }
}
