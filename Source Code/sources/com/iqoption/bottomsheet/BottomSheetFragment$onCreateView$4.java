package com.iqoption.bottomsheet;

import com.iqoption.core.ui.navigation.LifecycleBackListener;
import com.iqoption.core.ui.navigation.a;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, aXE = {"com/iqoption/bottomsheet/BottomSheetFragment$onCreateView$4", "Lcom/iqoption/core/ui/navigation/LifecycleBackListener;", "onBackPressed", "", "dialogs_release"})
/* compiled from: BottomSheetFragment.kt */
public final class BottomSheetFragment$onCreateView$4 extends LifecycleBackListener {
    final /* synthetic */ c this$0;

    BottomSheetFragment$onCreateView$4(c cVar, a aVar) {
        this.this$0 = cVar;
        super(aVar);
    }

    public boolean onBackPressed() {
        this.this$0.JQ();
        return true;
    }
}
