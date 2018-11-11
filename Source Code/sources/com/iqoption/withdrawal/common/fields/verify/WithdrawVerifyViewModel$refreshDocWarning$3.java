package com.iqoption.withdrawal.common.fields.verify;

import android.arch.lifecycle.MutableLiveData;
import com.iqoption.microservice.a.b.a;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/microservice/kyc/response/KycDocumentsStatus;", "invoke"})
/* compiled from: WithdrawVerifyViewModel.kt */
final class WithdrawVerifyViewModel$refreshDocWarning$3 extends Lambda implements b<a, l> {
    final /* synthetic */ MutableLiveData $liveData;

    WithdrawVerifyViewModel$refreshDocWarning$3(MutableLiveData mutableLiveData) {
        this.$liveData = mutableLiveData;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        a((a) obj);
        return l.etX;
    }

    public final void a(a aVar) {
        Object eVar;
        String str = aVar != null ? aVar.cRM : null;
        if (str == null || (str.hashCode() == 1967871671 && str.equals("APPROVED"))) {
            eVar = new e(VerificationWarningType.NONE);
        } else {
            String str2 = aVar.cRM;
            h.d(str2, "it.documentsState");
            eVar = new c(str2);
        }
        this.$liveData.postValue(eVar);
    }
}
