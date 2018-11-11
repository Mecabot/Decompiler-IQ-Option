package com.iqoption.deposit.b;

import android.view.ViewGroup;
import com.iqoption.deposit.a.au;
import com.iqoption.deposit.a.ay;
import com.iqoption.deposit.r.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00142\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u001c\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u001c\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, aXE = {"Lcom/iqoption/deposit/presets/PresetsAdapter;", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/IQAdapter;", "Lcom/iqoption/deposit/presets/BasePresetViewHolder;", "Lcom/iqoption/deposit/presets/PresetItem;", "listener", "Lcom/iqoption/deposit/presets/OnPresetClickListener;", "(Lcom/iqoption/deposit/presets/OnPresetClickListener;)V", "getItemViewType", "", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelection", "selectedAmount", "", "Companion", "deposit_release"})
/* compiled from: PresetsAdapter.kt */
public final class f extends com.iqoption.core.ui.widget.recyclerview.adapter.a<a<?>, c> {
    public static final a ccj = new a();
    private final b cci;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, aXE = {"Lcom/iqoption/deposit/presets/PresetsAdapter$Companion;", "", "()V", "VIEW_TYPE_NORMAL", "", "VIEW_TYPE_WITH_BADGE", "deposit_release"})
    /* compiled from: PresetsAdapter.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public f(b bVar) {
        h.e(bVar, "listener");
        this.cci = bVar;
    }

    /* renamed from: y */
    public a<?> onCreateViewHolder(ViewGroup viewGroup, int i) {
        h.e(viewGroup, "parent");
        switch (i) {
            case 0:
                return new d((au) com.iqoption.core.ext.a.a(viewGroup, g.item_preset, null, false, 6, null), this.cci);
            case 1:
                return new e((ay) com.iqoption.core.ext.a.a(viewGroup, g.item_preset_with_badge, null, false, 6, null), this.cci);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected case ");
                stringBuilder.append(i);
                throw new IllegalStateException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    public void onBindViewHolder(a<?> aVar, int i) {
        h.e(aVar, "holder");
        aVar.b((c) getItem(i));
    }

    public int getItemViewType(int i) {
        String UP = ((c) getItem(i)).adX().UP();
        return (UP != null && UP.hashCode() == 116765 && UP.equals("vip")) ? 1 : 0;
    }

    public final void setSelection(String str) {
        Iterable<Object> items = getItems();
        Collection arrayList = new ArrayList(n.e(items, 10));
        for (Object obj : items) {
            Object obj2;
            boolean z = str != null && com.iqoption.deposit.h.a(obj2.adX(), str);
            if (z != obj2.getSelected()) {
                obj2 = c.a(obj2, null, null, z, 3, null);
            }
            arrayList.add(obj2);
        }
        ap((List) arrayList);
    }
}
