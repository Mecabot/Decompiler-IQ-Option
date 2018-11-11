package com.iqoption.deposit.pro;

import android.content.Intent;
import android.os.Bundle;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, aXE = {"<anonymous>", "", "invoke", "()Ljava/lang/Long;"})
/* compiled from: ProDepositActivity.kt */
final class ProDepositActivity$paymentMethodId$2 extends Lambda implements a<Long> {
    final /* synthetic */ b this$0;

    ProDepositActivity$paymentMethodId$2(b bVar) {
        this.this$0 = bVar;
        super(0);
    }

    /* renamed from: aea */
    public final Long invoke() {
        Intent intent = this.this$0.getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null && extras.containsKey("ARG_PAYMENT_METHOD_ID")) {
                return Long.valueOf(this.this$0.getIntent().getLongExtra("ARG_PAYMENT_METHOD_ID", -1));
            }
        }
        return null;
    }
}
