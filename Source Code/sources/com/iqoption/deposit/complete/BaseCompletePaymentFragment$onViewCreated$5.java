package com.iqoption.deposit.complete;

import com.iqoption.core.ui.navigation.LifecycleBackListener;
import com.iqoption.core.ui.navigation.a;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, aXE = {"com/iqoption/deposit/complete/BaseCompletePaymentFragment$onViewCreated$5", "Lcom/iqoption/core/ui/navigation/LifecycleBackListener;", "onBackPressed", "", "deposit_release"})
/* compiled from: BaseCompletePaymentFragment.kt */
public final class BaseCompletePaymentFragment$onViewCreated$5 extends LifecycleBackListener {
    final /* synthetic */ a this$0;

    BaseCompletePaymentFragment$onViewCreated$5(a aVar, a aVar2) {
        this.this$0 = aVar;
        super(aVar2);
    }

    public boolean onBackPressed() {
        this.this$0.close();
        return true;
    }
}
