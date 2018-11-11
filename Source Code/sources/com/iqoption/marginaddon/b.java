package com.iqoption.marginaddon;

import com.iqoption.app.af;
import java.util.List;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0007J\b\u0010\u0010\u001a\u00020\u000fH\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0007J\b\u0010\u0013\u001a\u00020\u000fH\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, aXE = {"Lcom/iqoption/marginaddon/MarginAddOnInfoHelper;", "", "()V", "DEALS_FOR_SHOW", "", "", "preferences", "Lcom/iqoption/app/Preferences;", "kotlin.jvm.PlatformType", "getPreferences", "()Lcom/iqoption/app/Preferences;", "preferences$delegate", "Lkotlin/Lazy;", "getDealsCount", "incrementMarginAddOnDialogShown", "", "incrementOpenedPosition", "isMarginAddOnInfoNeeded", "", "setMarginAddOnWasEnabled", "IqOption-5.5.1_optionXRelease"})
/* compiled from: MarginAddOnInfoHelper.kt */
public final class b {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "preferences", "getPreferences()Lcom/iqoption/app/Preferences;"))};
    private static final List<Integer> cOe = u.W(ai.H(Integer.valueOf(0), Integer.valueOf(5), Integer.valueOf(10), Integer.valueOf(20), Integer.valueOf(35), Integer.valueOf(55)));
    private static final d cOf = g.f(MarginAddOnInfoHelper$preferences$2.cOh);
    public static final b cOg = new b();

    private final af aqJ() {
        d dVar = cOf;
        j jVar = apP[0];
        return (af) dVar.getValue();
    }

    private b() {
    }

    public static final boolean aqK() {
        int aqL = cOg.aqL();
        af aqJ = cOg.aqJ();
        h.d(aqJ, "preferences");
        int Fy = aqJ.Fy();
        com.iqoption.settings.b aDQ = com.iqoption.settings.b.aDQ();
        h.d(aDQ, "SettingsManager.instance()");
        if (aDQ.En()) {
            return false;
        }
        af aqJ2 = cOg.aqJ();
        h.d(aqJ2, "preferences");
        if (!aqJ2.Fv() && Fy < cOe.size() && ((Number) cOe.get(Fy)).intValue() == aqL) {
            return true;
        }
        return false;
    }

    private final int aqL() {
        af aqJ = aqJ();
        h.d(aqJ, "preferences");
        return aqJ.Fw();
    }

    public static final void aqM() {
        cOg.aqJ().Fx();
    }

    public static final void aqN() {
        af aqJ = cOg.aqJ();
        h.d(aqJ, "preferences");
        int Fw = aqJ.Fw();
        af aqJ2 = cOg.aqJ();
        h.d(aqJ2, "preferences");
        aqJ2.cU(Fw + 1);
    }

    public static final void aqO() {
        af aqJ = cOg.aqJ();
        h.d(aqJ, "preferences");
        aqJ.bp(true);
    }
}
