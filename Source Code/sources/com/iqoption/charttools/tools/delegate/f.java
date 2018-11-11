package com.iqoption.charttools.tools.delegate;

import android.arch.lifecycle.Observer;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.iqoption.charttools.tools.a.d;
import com.iqoption.charttools.tools.data.k;
import com.iqoption.charttools.tools.data.l;
import com.iqoption.core.ext.g;
import com.iqoption.d.aks;
import com.iqoption.x.R;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0006B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0007"}, aXE = {"Lcom/iqoption/charttools/tools/delegate/TemplatesDelegate;", "Lcom/iqoption/charttools/tools/delegate/ContentDelegate;", "Lcom/iqoption/databinding/ToolsContentTemplatesBinding;", "context", "Lcom/iqoption/charttools/tools/delegate/DelegateContext;", "(Lcom/iqoption/charttools/tools/delegate/DelegateContext;)V", "Callback", "IqOption-5.5.1_optionXRelease"})
/* compiled from: TemplatesDelegate.kt */
public final class f extends b<aks> {

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, aXE = {"Lcom/iqoption/charttools/tools/delegate/TemplatesDelegate$Callback;", "", "onOpenTemplateSettings", "", "templateItem", "Lcom/iqoption/charttools/tools/data/TemplateItem;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: TemplatesDelegate.kt */
    public interface b {
        void a(l lVar);
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0007"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release", "com/iqoption/charttools/tools/delegate/TemplatesDelegate$$special$$inlined$setOnDelayedClickListener$1"})
    /* compiled from: AndroidExtensions.kt */
    public static final class a extends g {
        final /* synthetic */ f aCm;
        final /* synthetic */ d aCn;

        public a(f fVar, d dVar) {
            this.aCm = fVar;
            this.aCn = dVar;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            this.aCm.Nz().NA();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, aXE = {"com/iqoption/charttools/tools/delegate/TemplatesDelegate$adapter$1", "Lcom/iqoption/charttools/tools/adapters/TemplatesAdapter$Callbacks;", "onItemClick", "", "item", "Lcom/iqoption/charttools/tools/data/TemplateItem;", "onItemRemoveClick", "onItemSettingsClick", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: TemplatesDelegate.kt */
    public static final class c implements com.iqoption.charttools.tools.a.d.a {
        final /* synthetic */ f aCm;

        c(f fVar) {
            this.aCm = fVar;
        }

        public void d(l lVar) {
            h.e(lVar, "item");
            this.aCm.Nv().b(lVar);
            this.aCm.Nz().onClose();
        }

        public void e(l lVar) {
            h.e(lVar, "item");
            com.iqoption.charttools.model.a.a Oh = lVar.Oh();
            com.iqoption.charttools.tools.d.aAz.aa(Oh.JT().size(), Oh.Kr().size());
            this.aCm.Nz().a(lVar);
        }

        public void f(l lVar) {
            h.e(lVar, "item");
            this.aCm.Nv().c(lVar);
        }
    }

    public f(c cVar) {
        h.e(cVar, "context");
        super(R.layout.tools_content_templates, cVar);
        final d dVar = new d(new c(this));
        Nv().NP().observe(this, new Observer<List<? extends k>>() {
            /* renamed from: L */
            public final void onChanged(List<? extends k> list) {
                if (list != null) {
                    com.iqoption.core.ui.widget.recyclerview.adapter.a aVar = dVar;
                    h.d(list, "it");
                    com.iqoption.core.ui.widget.recyclerview.adapter.a.a(aVar, list, null, 2, null);
                }
            }
        });
        aks aks = (aks) getBinding();
        RecyclerView recyclerView = aks.bTK;
        h.d(recyclerView, "listView");
        recyclerView.setAdapter(dVar);
        aks.bTK.addItemDecoration(Nx());
        TextView textView = aks.bTN;
        h.d(textView, "btnCreateTemplate");
        textView.setOnClickListener(new a(this, dVar));
    }
}
