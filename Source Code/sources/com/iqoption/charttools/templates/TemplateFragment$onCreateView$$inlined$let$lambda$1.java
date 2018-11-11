package com.iqoption.charttools.templates;

import com.iqoption.core.ui.navigation.LifecycleBackListener;
import com.iqoption.core.ui.navigation.a;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, aXE = {"com/iqoption/charttools/templates/TemplateFragment$onCreateView$2$1", "Lcom/iqoption/core/ui/navigation/LifecycleBackListener;", "onBackPressed", "", "techtools_release"})
/* compiled from: TemplateFragment.kt */
public final class TemplateFragment$onCreateView$$inlined$let$lambda$1 extends LifecycleBackListener {
    final /* synthetic */ i azt;
    final /* synthetic */ a azx;

    TemplateFragment$onCreateView$$inlined$let$lambda$1(a aVar, a aVar2, i iVar) {
        this.azx = aVar;
        this.azt = iVar;
        super(aVar2);
    }

    public boolean onBackPressed() {
        return this.azt.getChildFragmentManager().popBackStackImmediate();
    }
}
