package com.iqoption.withdrawal.common.methods;

import android.app.Application;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Landroid/app/Application;", "invoke"})
/* compiled from: WithdrawMethodsViewModel.kt */
final class WithdrawMethodsViewModel$context$2 extends Lambda implements a<Application> {
    final /* synthetic */ WithdrawMethodsViewModel this$0;

    WithdrawMethodsViewModel$context$2(WithdrawMethodsViewModel withdrawMethodsViewModel) {
        this.this$0 = withdrawMethodsViewModel;
        super(0);
    }

    /* renamed from: aNX */
    public final Application invoke() {
        return this.this$0.getApplication();
    }
}
