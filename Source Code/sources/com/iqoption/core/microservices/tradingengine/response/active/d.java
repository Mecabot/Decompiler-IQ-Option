package com.iqoption.core.microservices.tradingengine.response.active;

import com.iqoption.core.ext.c;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0003\u001a\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0003\u001a\n\u0010\u0007\u001a\u00020\u0005*\u00020\u0003\u001a\n\u0010\b\u001a\u00020\u0005*\u00020\u0003\u001a\n\u0010\t\u001a\u00020\n*\u00020\u0003¨\u0006\u000b"}, aXE = {"isEnabledNow", "", "active", "Lcom/iqoption/core/microservices/tradingengine/response/active/Active;", "getName", "", "getNameForSort", "getShortName", "getTickerName", "nextScheduleForNow", "", "core_release"})
/* compiled from: ActiveExtentions.kt */
public final class d {
    public static final String s(a aVar) {
        String Xr;
        h.e(aVar, "$receiver");
        if (aVar instanceof h) {
            Xr = ((h) aVar).Xr();
        } else if (aVar instanceof k) {
            Xr = ((k) aVar).Xg();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected case ");
            stringBuilder.append(aVar);
            throw new IllegalStateException(stringBuilder.toString());
        }
        return c.a(Xr, null, 1, null);
    }
}
