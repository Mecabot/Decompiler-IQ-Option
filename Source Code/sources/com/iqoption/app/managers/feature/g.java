package com.iqoption.app.managers.feature;

import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\n\u0010\tR\u0011\u0010\u000b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, aXE = {"Lcom/iqoption/app/managers/feature/SpotSettings;", "", "spotInstrumentFeatureName", "", "isSpotSwitcherStateOn", "Lkotlin/Function0;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "isShowSpotSwitcherFeatureEnabled", "()Z", "isSpotEnabled", "isSpotFeatureEnabled", "()Lkotlin/jvm/functions/Function0;", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: SpotSettings.kt */
public final class g {
    private static final g aoE = new g("", SpotSettings$Companion$NO_SPOT$1.aoG);
    public static final a aoF = new a();
    private final String aoC;
    private final kotlin.jvm.a.a<Boolean> aoD;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/app/managers/feature/SpotSettings$Companion;", "", "()V", "NO_SPOT", "Lcom/iqoption/app/managers/feature/SpotSettings;", "getNO_SPOT", "()Lcom/iqoption/app/managers/feature/SpotSettings;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: SpotSettings.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final g Ih() {
            return g.aoE;
        }
    }

    public g(String str, kotlin.jvm.a.a<Boolean> aVar) {
        h.e(str, "spotInstrumentFeatureName");
        h.e(aVar, "isSpotSwitcherStateOn");
        this.aoC = str;
        this.aoD = aVar;
    }

    public final boolean Id() {
        return (((CharSequence) this.aoC).length() > 0 ? 1 : null) != null && a.eW(this.aoC);
    }

    public final boolean Ie() {
        return (((CharSequence) this.aoC).length() > 0 ? 1 : null) != null && h.E("enabled-on", a.eY(this.aoC));
    }

    public final boolean If() {
        if (!Id()) {
            return false;
        }
        if (Ie()) {
            return ((Boolean) this.aoD.invoke()).booleanValue();
        }
        return true;
    }
}
