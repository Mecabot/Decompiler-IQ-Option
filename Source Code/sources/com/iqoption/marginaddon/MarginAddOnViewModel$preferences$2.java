package com.iqoption.marginaddon;

import android.content.Context;
import com.iqoption.app.af;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, aXE = {"<anonymous>", "Lcom/iqoption/app/Preferences;", "kotlin.jvm.PlatformType", "invoke"})
/* compiled from: MarginAddOnViewModel.kt */
final class MarginAddOnViewModel$preferences$2 extends Lambda implements a<af> {
    final /* synthetic */ MarginAddOnViewModel this$0;

    MarginAddOnViewModel$preferences$2(MarginAddOnViewModel marginAddOnViewModel) {
        this.this$0 = marginAddOnViewModel;
        super(0);
    }

    /* renamed from: aqP */
    public final af invoke() {
        return af.aR((Context) this.this$0.getApplication());
    }
}
