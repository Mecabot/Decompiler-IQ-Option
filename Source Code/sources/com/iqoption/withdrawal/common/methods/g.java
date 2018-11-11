package com.iqoption.withdrawal.common.methods;

import com.iqoption.microservice.withdraw.response.f;
import java.util.Comparator;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0003"}, aXE = {"FIELDS_AMOUNT_COMPARATOR", "Ljava/util/Comparator;", "Lcom/iqoption/microservice/withdraw/response/PayoutField;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawMethodsViewModel.kt */
public final class g {
    private static final Comparator<f> dRR = a.dRS;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "first", "Lcom/iqoption/microservice/withdraw/response/PayoutField;", "kotlin.jvm.PlatformType", "second", "compare"})
    /* compiled from: WithdrawMethodsViewModel.kt */
    static final class a<T> implements Comparator<f> {
        public static final a dRS = new a();

        a() {
        }

        /* renamed from: a */
        public final int compare(f fVar, f fVar2) {
            String str = "amount";
            if (h.E(str, fVar.getName())) {
                return -1;
            }
            return h.E(str, fVar2.getName()) ? 1 : 0;
        }
    }
}
