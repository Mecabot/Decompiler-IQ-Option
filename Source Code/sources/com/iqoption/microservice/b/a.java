package com.iqoption.microservice.b;

import com.google.common.util.concurrent.s;
import com.iqoption.core.connect.k;
import com.iqoption.dto.entity.position.Order;
import com.iqoption.mobbtech.connect.request.a.a.b;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, aXE = {"Lcom/iqoption/microservice/operation/OperationRequests;", "", "()V", "DATE_PARAM_MAX", "", "DATE_PARAM_MIN", "DEFAULT_LIMIT", "", "OPERATION_PARAM", "STATUS_PARAM", "platforms", "", "getTransactions", "Lcom/google/common/util/concurrent/ListenableFuture;", "Lcom/iqoption/microservice/operation/TransactionResponse;", "paramMap", "", "offset", "limit", "IqOption-5.5.1_optionXRelease"})
/* compiled from: OperationRequests.kt */
public final class a {
    private static final List<Integer> cRN = m.listOf(Integer.valueOf(2), Integer.valueOf(17), Integer.valueOf(12), Integer.valueOf(3), Integer.valueOf(9), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9), Integer.valueOf(11));
    public static final a cRO = new a();

    private a() {
    }

    public static /* bridge */ /* synthetic */ s a(a aVar, Map map, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 100;
        }
        return aVar.a(map, i, i2);
    }

    public final s<c> a(Map<String, ? extends Object> map, int i, int i2) {
        h.e(map, "paramMap");
        k gb = b.A(c.class).ga("get-transactions").j("offset", Integer.valueOf(i)).j(Order.LIMIT, Integer.valueOf(i2)).j("platforms", cRN).gb("1.0");
        for (Entry entry : map.entrySet()) {
            gb.j((String) entry.getKey(), entry.getValue());
        }
        return gb.Sa();
    }
}
