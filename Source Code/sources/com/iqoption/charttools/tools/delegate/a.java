package com.iqoption.charttools.tools.delegate;

import android.animation.TimeInterpolator;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.support.transition.AutoTransition;
import android.support.transition.TransitionManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.iqoption.charttools.model.indicator.h;
import com.iqoption.core.ext.g;
import com.iqoption.d.akm;
import com.iqoption.x.R;
import java.util.List;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, aXE = {"Lcom/iqoption/charttools/tools/delegate/ActiveToolsDelegate;", "Lcom/iqoption/charttools/tools/delegate/ContentDelegate;", "Lcom/iqoption/databinding/ToolsContentActiveToolsBinding;", "context", "Lcom/iqoption/charttools/tools/delegate/DelegateContext;", "(Lcom/iqoption/charttools/tools/delegate/DelegateContext;)V", "clearAllTransition", "Landroid/support/transition/AutoTransition;", "Callback", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ActiveToolsDelegate.kt */
public final class a extends b<akm> {
    private final AutoTransition aBY;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, aXE = {"Lcom/iqoption/charttools/tools/delegate/ActiveToolsDelegate$Callback;", "", "onOpenIndicatorSettings", "", "indicator", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "onOpenTemplateActivity", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ActiveToolsDelegate.kt */
    public interface b {
        void NA();

        void k(h hVar);
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, aXE = {"<anonymous>", "", "clearAllMode", "", "onChanged", "(Ljava/lang/Boolean;)V"})
    /* compiled from: ActiveToolsDelegate.kt */
    /* renamed from: com.iqoption.charttools.tools.delegate.a$2 */
    static final class AnonymousClass2<T> implements Observer<Boolean> {
        final /* synthetic */ a aBZ;

        AnonymousClass2(a aVar) {
            this.aBZ = aVar;
        }

        /* renamed from: k */
        public final void onChanged(Boolean bool) {
            if (bool != null) {
                TransitionManager.beginDelayedTransition(((akm) this.aBZ.getBinding()).bTL, this.aBZ.aBY);
                kotlin.jvm.internal.h.d(bool, "it");
                TextView textView;
                if (bool.booleanValue()) {
                    textView = ((akm) this.aBZ.getBinding()).agA;
                    kotlin.jvm.internal.h.d(textView, "binding.title");
                    com.iqoption.core.ext.a.hide(textView);
                    textView = ((akm) this.aBZ.getBinding()).bTI;
                    kotlin.jvm.internal.h.d(textView, "binding.btnClearAll");
                    com.iqoption.core.ext.a.hide(textView);
                    textView = ((akm) this.aBZ.getBinding()).brN;
                    kotlin.jvm.internal.h.d(textView, "binding.btnConfirm");
                    com.iqoption.core.ext.a.L(textView);
                    textView = ((akm) this.aBZ.getBinding()).blE;
                    kotlin.jvm.internal.h.d(textView, "binding.btnCancel");
                    com.iqoption.core.ext.a.L(textView);
                    return;
                }
                textView = ((akm) this.aBZ.getBinding()).agA;
                kotlin.jvm.internal.h.d(textView, "binding.title");
                com.iqoption.core.ext.a.L(textView);
                textView = ((akm) this.aBZ.getBinding()).bTI;
                kotlin.jvm.internal.h.d(textView, "binding.btnClearAll");
                com.iqoption.core.ext.a.L(textView);
                textView = ((akm) this.aBZ.getBinding()).brN;
                kotlin.jvm.internal.h.d(textView, "binding.btnConfirm");
                com.iqoption.core.ext.a.hide(textView);
                textView = ((akm) this.aBZ.getBinding()).blE;
                kotlin.jvm.internal.h.d(textView, "binding.btnCancel");
                com.iqoption.core.ext.a.hide(textView);
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/charttools/tools/delegate/ActiveToolsDelegate$3$clickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ActiveToolsDelegate.kt */
    public static final class a extends g {
        final /* synthetic */ a aBZ;
        final /* synthetic */ com.iqoption.charttools.tools.a.a aCa;

        a(a aVar, com.iqoption.charttools.tools.a.a aVar2) {
            this.aBZ = aVar;
            this.aCa = aVar2;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            int id = view.getId();
            if (id == R.id.btnCancel) {
                this.aBZ.Nv().NX();
            } else if (id == R.id.btnClearAll) {
                this.aBZ.Nv().NW();
            } else if (id == R.id.btnConfirm) {
                this.aBZ.Nv().NV();
            } else if (id == R.id.btnSaveAsTemplate) {
                this.aBZ.Nz().NA();
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, aXE = {"com/iqoption/charttools/tools/delegate/ActiveToolsDelegate$adapter$1", "Lcom/iqoption/charttools/tools/adapters/ActiveIndicatorsAdapter$Callbacks;", "onItemClick", "", "indicator", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "onItemRemoveClick", "onItemSettingsClick", "onItemToggleVisibilityClick", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ActiveToolsDelegate.kt */
    public static final class c implements com.iqoption.charttools.tools.a.a.a {
        final /* synthetic */ a aBZ;

        c(a aVar) {
            this.aBZ = aVar;
        }

        public void q(h hVar) {
            kotlin.jvm.internal.h.e(hVar, "indicator");
            if (this.aBZ.Nv().n(hVar)) {
                this.aBZ.Nz().onClose();
            }
        }

        public void r(h hVar) {
            kotlin.jvm.internal.h.e(hVar, "indicator");
            this.aBZ.Nv().m(hVar);
        }

        public void s(h hVar) {
            kotlin.jvm.internal.h.e(hVar, "indicator");
            this.aBZ.Nz().k(hVar);
        }

        public void t(h hVar) {
            kotlin.jvm.internal.h.e(hVar, "indicator");
            this.aBZ.Nv().l(hVar);
        }
    }

    public a(c cVar) {
        kotlin.jvm.internal.h.e(cVar, "context");
        super(R.layout.tools_content_active_tools, cVar);
        AutoTransition autoTransition = new AutoTransition();
        autoTransition.setDuration(200);
        autoTransition.setInterpolator((TimeInterpolator) com.iqoption.core.graphics.animation.i.TI());
        autoTransition.setOrdering(0);
        this.aBY = autoTransition;
        final com.iqoption.charttools.tools.a.a aVar = new com.iqoption.charttools.tools.a.a(new c(this));
        LifecycleOwner lifecycleOwner = this;
        Nv().NN().observe(lifecycleOwner, new Observer<List<? extends com.iqoption.charttools.tools.data.a>>() {
            /* renamed from: L */
            public final void onChanged(List<com.iqoption.charttools.tools.data.a> list) {
                if (list != null) {
                    com.iqoption.core.ui.widget.recyclerview.adapter.a aVar = aVar;
                    kotlin.jvm.internal.h.d(list, "it");
                    com.iqoption.core.ui.widget.recyclerview.adapter.a.a(aVar, list, null, 2, null);
                }
            }
        });
        Nv().NO().observe(lifecycleOwner, new AnonymousClass2(this));
        akm akm = (akm) getBinding();
        RecyclerView recyclerView = akm.bTK;
        kotlin.jvm.internal.h.d(recyclerView, "listView");
        recyclerView.setAdapter(aVar);
        akm.bTK.addItemDecoration(Nx());
        OnClickListener aVar2 = new a(this, aVar);
        akm.bTI.setOnClickListener(aVar2);
        akm.blE.setOnClickListener(aVar2);
        akm.brN.setOnClickListener(aVar2);
        if (com.iqoption.app.managers.feature.a.eW("templates")) {
            akm.bTJ.setOnClickListener(aVar2);
            return;
        }
        TextView textView = akm.bTJ;
        kotlin.jvm.internal.h.d(textView, "btnSaveAsTemplate");
        com.iqoption.core.ext.a.M(textView);
    }
}
