package com.iqoption.asset.mediators;

import com.iqoption.core.microservices.f.a.a.a.c;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, aXE = {"<anonymous>", "", "invoke", "()Ljava/lang/Double;"})
/* compiled from: AssetDisplayData.kt */
final class AssetDisplayData$spreadPercent$2 extends Lambda implements a<Double> {
    final /* synthetic */ a this$0;

    AssetDisplayData$spreadPercent$2(a aVar) {
        this.this$0 = aVar;
        super(0);
    }

    /* renamed from: Ji */
    public final Double invoke() {
        com.iqoption.core.microservices.f.a.a.a Jh = this.this$0.Jh();
        c WW = Jh.WW();
        if (WW == null) {
            h.aXZ();
        }
        Double value = WW.getValue();
        c WZ = Jh.WZ();
        if (WZ == null) {
            h.aXZ();
        }
        Double value2 = WZ.getValue();
        return (value == null || value2 == null) ? null : Double.valueOf((value.doubleValue() * 100.0d) / value2.doubleValue());
    }
}
