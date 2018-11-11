package com.iqoption.core.data.d;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.iqoption.core.data.d.b.b;
import com.iqoption.core.f.a.a;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u00101\u001a\u000202J\b\u00103\u001a\u000202H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R(\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u001c8F@FX\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u001c8F@FX\u000e¢\u0006\f\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R$\u0010#\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u001c8F@FX\u000e¢\u0006\f\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R$\u0010%\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u001c8F@FX\u000e¢\u0006\f\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R$\u0010'\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u001c8F@FX\u000e¢\u0006\f\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\u000e\u0010)\u001a\u00020*X\u0004¢\u0006\u0002\n\u0000R$\u0010,\u001a\u00020+2\u0006\u0010\u0013\u001a\u00020+8F@FX\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00064"}, aXE = {"Lcom/iqoption/core/data/prefs/UserPrefs;", "Lcom/iqoption/core/manager/LogoutClearList$Clearable;", "()V", "AUTOLOGIN_TOKEN", "", "EMAIL", "FIRST_DO_SELL_EXPERIENCE", "IDENTITY", "IS_HIGH_LOW_CHART", "LOCALIZATION_JSON", "PASSWORD", "PREF_NAME_USER", "REGULATED_STATE_CYSEC", "", "REGULATED_STATE_UNKNOWN", "REGULATION_STATE", "SHOW_LIVE_DEALS", "SHOW_TRADER_MOOD", "USER_ID", "value", "autoLoginToken", "getAutoLoginToken", "()Ljava/lang/String;", "setAutoLoginToken", "(Ljava/lang/String;)V", "identity", "getIdentity", "setIdentity", "", "isFirstDOSellExperience", "()Z", "setFirstDOSellExperience", "(Z)V", "isHighLowChart", "setHighLowChart", "isRegulated", "setRegulated", "isShowLiveDeals", "setShowLiveDeals", "isShowTraderMood", "setShowTraderMood", "prefs", "Lcom/iqoption/core/data/prefs/Prefs;", "", "userId", "getUserId", "()J", "setUserId", "(J)V", "clearLocalizationJson", "", "clearOnLogout", "core_release"})
/* compiled from: UserPrefs.kt */
public final class d implements a {
    public static final d aOE;
    private static final b aOy = b.aOA.gm("IQOptions");

    static {
        d dVar = new d();
        aOE = dVar;
        com.iqoption.core.f.a.a(dVar);
    }

    private d() {
    }

    public void Js() {
        String identity = getIdentity();
        aOy.clear();
        aOy.put("identity", identity);
    }

    public final void SG() {
        aOy.remove("localization_json");
    }

    public final String getIdentity() {
        String a = b.a(aOy, "identity", null, 2, null);
        return a != null ? a : "";
    }

    public final void setIdentity(String str) {
        h.e(str, FirebaseAnalytics.b.VALUE);
        aOy.put("identity", str);
    }

    public final boolean SH() {
        return aOy.n("show_trader_mood", true);
    }

    public final void ce(boolean z) {
        aOy.put("show_trader_mood", z);
    }

    public final boolean SI() {
        return aOy.n("show_live_deals", false);
    }

    public final void cf(boolean z) {
        aOy.put("show_live_deals", z);
    }
}
