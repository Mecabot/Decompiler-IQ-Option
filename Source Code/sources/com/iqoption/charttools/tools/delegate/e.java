package com.iqoption.charttools.tools.delegate;

import android.arch.lifecycle.Observer;
import android.support.v7.widget.RecyclerView;
import com.iqoption.charttools.tools.a.c;
import com.iqoption.charttools.tools.data.j;
import com.iqoption.d.akq;
import com.iqoption.x.R;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, aXE = {"Lcom/iqoption/charttools/tools/delegate/SettingsDelegate;", "Lcom/iqoption/charttools/tools/delegate/ContentDelegate;", "Lcom/iqoption/databinding/ToolsContentSettingsBinding;", "context", "Lcom/iqoption/charttools/tools/delegate/DelegateContext;", "(Lcom/iqoption/charttools/tools/delegate/DelegateContext;)V", "IqOption-5.5.1_optionXRelease"})
/* compiled from: SettingsDelegate.kt */
public final class e extends b<akq> {

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/charttools/tools/delegate/SettingsDelegate$adapter$1", "Lcom/iqoption/charttools/tools/adapters/SettingsAdapter$Callbacks;", "onItemToggled", "", "item", "Lcom/iqoption/charttools/tools/data/SettingItem;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: SettingsDelegate.kt */
    public static final class a implements com.iqoption.charttools.tools.a.c.a {
        final /* synthetic */ e aCl;

        a(e eVar) {
            this.aCl = eVar;
        }

        public void b(j jVar) {
            h.e(jVar, "item");
            this.aCl.Nv().a(jVar);
        }
    }

    public e(c cVar) {
        h.e(cVar, "context");
        super(R.layout.tools_content_settings, cVar);
        final c cVar2 = new c(new a(this));
        Nv().NQ().observe(this, new Observer<List<? extends j>>() {
            /* renamed from: L */
            public final void onChanged(List<j> list) {
                if (list != null) {
                    com.iqoption.core.ui.widget.recyclerview.adapter.a aVar = cVar2;
                    h.d(list, "it");
                    com.iqoption.core.ui.widget.recyclerview.adapter.a.a(aVar, list, null, 2, null);
                }
            }
        });
        akq akq = (akq) getBinding();
        RecyclerView recyclerView = akq.bTK;
        h.d(recyclerView, "listView");
        recyclerView.setAdapter(cVar2);
        akq.bTK.addItemDecoration(Nx());
    }
}
