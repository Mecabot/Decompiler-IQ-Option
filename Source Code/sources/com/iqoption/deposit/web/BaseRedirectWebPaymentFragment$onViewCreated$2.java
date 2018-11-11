package com.iqoption.deposit.web;

import android.webkit.WebView;
import com.iqoption.billing.repository.e;
import com.iqoption.core.ui.navigation.LifecycleBackListener;
import com.iqoption.core.ui.navigation.a;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, aXE = {"com/iqoption/deposit/web/BaseRedirectWebPaymentFragment$onViewCreated$2", "Lcom/iqoption/core/ui/navigation/LifecycleBackListener;", "onBackPressed", "", "deposit_release"})
/* compiled from: BaseRedirectWebPaymentFragment.kt */
public final class BaseRedirectWebPaymentFragment$onViewCreated$2 extends LifecycleBackListener {
    final /* synthetic */ WebView ceK;
    final /* synthetic */ a this$0;

    BaseRedirectWebPaymentFragment$onViewCreated$2(a aVar, WebView webView, a aVar2) {
        this.this$0 = aVar;
        this.ceK = webView;
        super(aVar2);
    }

    public boolean onBackPressed() {
        if (this.ceK.canGoBack()) {
            this.ceK.goBack();
            return true;
        }
        e.ary.JI();
        return false;
    }
}
