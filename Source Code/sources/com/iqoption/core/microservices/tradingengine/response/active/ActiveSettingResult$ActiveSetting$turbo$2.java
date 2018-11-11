package com.iqoption.core.microservices.tradingengine.response.active;

import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.microservices.tradingengine.response.active.e.b;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Lcom/iqoption/core/microservices/tradingengine/response/active/ActiveSettingResult$OptionsMap;", "invoke"})
/* compiled from: ActiveSettingResult.kt */
final class ActiveSettingResult$ActiveSetting$turbo$2 extends Lambda implements a<b> {
    final /* synthetic */ e.a this$0;

    ActiveSettingResult$ActiveSetting$turbo$2(e.a aVar) {
        this.this$0 = aVar;
        super(0);
    }

    /* renamed from: Xo */
    public final b invoke() {
        return this.this$0.a(this.this$0.aYw, InstrumentType.TURBO_INSTRUMENT);
    }
}
