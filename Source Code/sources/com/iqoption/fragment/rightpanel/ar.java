package com.iqoption.fragment.rightpanel;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.microservices.tradingengine.response.b.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R.\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, aXE = {"Lcom/iqoption/fragment/rightpanel/LeverageThresoldUtils;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "THRESOLD_DEFAULT", "", "paramsCache", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getActiveLeverage", "leverage", "instrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "leverageInfo", "Lcom/iqoption/core/microservices/tradingengine/response/leverage/LeverageInfo;", "getThresoldLeverage", "getValue", "", "value", "IqOption-5.5.1_optionXRelease"})
/* compiled from: LeverageThresoldUtils.kt */
public final class ar {
    private static final String TAG = "ar";
    private static final int cHo = Integer.MAX_VALUE;
    private static HashMap<String, Integer> cHp;
    public static final ar cHq = new ar();

    private ar() {
    }

    /* JADX WARNING: Missing block: B:20:0x006d, code:
            if (r5 != null) goto L_0x0076;
     */
    @android.support.annotation.MainThread
    public static final int G(com.iqoption.core.data.model.InstrumentType r5) {
        /*
        r0 = com.iqoption.app.managers.feature.b.HT();
        r1 = "hide-big-leverages";
        r0 = r0.fd(r1);
        if (r5 == 0) goto L_0x0086;
    L_0x000c:
        if (r0 == 0) goto L_0x0086;
    L_0x000e:
        r1 = r0.status;
        if (r1 == 0) goto L_0x0086;
    L_0x0012:
        r1 = r0.status;
        r2 = "disabled";
        r1 = kotlin.jvm.internal.h.E(r1, r2);
        if (r1 != 0) goto L_0x0086;
    L_0x001c:
        r1 = r0.params;
        if (r1 != 0) goto L_0x0021;
    L_0x0020:
        goto L_0x0086;
    L_0x0021:
        r1 = cHp;	 Catch:{ Exception -> 0x007b }
        if (r1 != 0) goto L_0x005f;
    L_0x0025:
        r0 = r0.params;	 Catch:{ Exception -> 0x007b }
        r1 = "feature.params";
        kotlin.jvm.internal.h.d(r0, r1);	 Catch:{ Exception -> 0x007b }
        r1 = com.iqoption.core.c.a.b.class;
        r2 = 2;
        r3 = 0;
        r0 = com.iqoption.core.ext.d.a(r0, r1, r3, r2, r3);	 Catch:{ Exception -> 0x007b }
        r0 = (com.iqoption.core.c.a.b) r0;	 Catch:{ Exception -> 0x007b }
        r1 = new java.util.HashMap;	 Catch:{ Exception -> 0x007b }
        r1.<init>();	 Catch:{ Exception -> 0x007b }
        r2 = r0.Ik();	 Catch:{ Exception -> 0x007b }
        r2 = (java.lang.Iterable) r2;	 Catch:{ Exception -> 0x007b }
        r2 = r2.iterator();	 Catch:{ Exception -> 0x007b }
    L_0x0045:
        r3 = r2.hasNext();	 Catch:{ Exception -> 0x007b }
        if (r3 == 0) goto L_0x005d;
    L_0x004b:
        r3 = r2.next();	 Catch:{ Exception -> 0x007b }
        r3 = (java.lang.String) r3;	 Catch:{ Exception -> 0x007b }
        r4 = r0.Ta();	 Catch:{ Exception -> 0x007b }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x007b }
        r1.put(r3, r4);	 Catch:{ Exception -> 0x007b }
        goto L_0x0045;
    L_0x005d:
        cHp = r1;	 Catch:{ Exception -> 0x007b }
    L_0x005f:
        r0 = cHp;	 Catch:{ Exception -> 0x007b }
        if (r0 == 0) goto L_0x0070;
    L_0x0063:
        r5 = r5.getServerValue();	 Catch:{ Exception -> 0x007b }
        r5 = r0.get(r5);	 Catch:{ Exception -> 0x007b }
        r5 = (java.lang.Integer) r5;	 Catch:{ Exception -> 0x007b }
        if (r5 == 0) goto L_0x0070;
    L_0x006f:
        goto L_0x0076;
    L_0x0070:
        r5 = cHo;	 Catch:{ Exception -> 0x007b }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x007b }
    L_0x0076:
        r5 = r5.intValue();	 Catch:{ Exception -> 0x007b }
        goto L_0x0088;
    L_0x007b:
        r5 = move-exception;
        r0 = TAG;
        r5 = (java.lang.Throwable) r5;
        com.iqoption.core.i.d(r0, r5);
        r5 = cHo;
        goto L_0x0088;
    L_0x0086:
        r5 = cHo;
    L_0x0088:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.fragment.rightpanel.ar.G(com.iqoption.core.data.model.InstrumentType):int");
    }

    public static final int[] a(int[] iArr, InstrumentType instrumentType) {
        h.e(iArr, b.VALUE);
        int G = G(instrumentType);
        if (G == cHo) {
            return iArr;
        }
        List i;
        for (int u = i.u(iArr); u >= 0; u--) {
            if ((iArr[u] > G ? 1 : null) == null) {
                i = i.i(iArr, u + 1);
                break;
            }
        }
        i = m.emptyList();
        return u.N((Collection) i);
    }

    public static final int a(int i, InstrumentType instrumentType, a aVar) {
        return (i >= G(instrumentType) && aVar != null) ? i.r(a(aVar.ck(com.iqoption.app.a.Cw().Dh()), instrumentType)) : i;
    }
}
