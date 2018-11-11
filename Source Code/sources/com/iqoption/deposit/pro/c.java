package com.iqoption.deposit.pro;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.iqoption.chat.ChatActivity;
import com.iqoption.core.ui.navigation.h;
import com.iqoption.deposit.navigator.b;
import com.iqoption.dto.ChartTimeInterval;
import com.iqoption.dto.entity.Feature;
import com.iqoption.microservice.chat.ChatRoomType;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J\u001c\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fH\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u0016H\u0016J\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0013J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\b\u0010 \u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\u0004H\u0016J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0004H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R/\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\b\u001a\u0004\b\u0012\u0010\u0013¨\u0006%"}, aXE = {"Lcom/iqoption/deposit/pro/ProDepositNavigatorFragment;", "Lcom/iqoption/deposit/navigator/DepositNavigatorFragment;", "()V", "darkDeposit", "", "getDarkDeposit", "()Z", "darkDeposit$delegate", "Lkotlin/Lazy;", "defaultPreset", "Ljava/util/ArrayList;", "Lcom/iqoption/core/features/limit/CurrencyValue;", "Lkotlin/collections/ArrayList;", "getDefaultPreset", "()Ljava/util/ArrayList;", "defaultPreset$delegate", "paymentMethodId", "", "getPaymentMethodId", "()Ljava/lang/Long;", "paymentMethodId$delegate", "close", "", "isDepSucceed", "getDepositPreset", "getListener", "Lcom/iqoption/deposit/pro/OnDepositCloseListener;", "hidePresetsByFeature", "isDarkDeposit", "isKycLimitEnabled", "openSupport", "shouldSelectFirstMethod", "shouldShowKycAfterDep", "shouldShowKycBeforeDep", "showKycBeforeDep", "particularMethodBlocked", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ProDepositNavigatorFragment.kt */
public final class c extends b {
    private static final String TAG = "com.iqoption.deposit.pro.c";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(c.class), "darkDeposit", "getDarkDeposit()Z")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(c.class), "paymentMethodId", "getPaymentMethodId()Ljava/lang/Long;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(c.class), "defaultPreset", "getDefaultPreset()Ljava/util/ArrayList;"))};
    public static final a cco = new a();
    private HashMap atz;
    private final d bXy = g.f(new ProDepositNavigatorFragment$defaultPreset$2(this));
    private final d ccl = g.f(new ProDepositNavigatorFragment$paymentMethodId$2(this));
    private final d ccn = g.f(new ProDepositNavigatorFragment$darkDeposit$2(this));

    @i(aXC = {1, 1, 11}, aXD = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J9\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, aXE = {"Lcom/iqoption/deposit/pro/ProDepositNavigatorFragment$Companion;", "", "()V", "ARG_DARK_DEPOSIT", "", "ARG_DEFAULT_PRESET", "ARG_PAYMENT_METHOD_ID", "TAG", "getTAG", "()Ljava/lang/String;", "createNavigatorEntry", "Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "darkDeposit", "", "paymentMethodId", "", "defaultPreset", "Ljava/util/ArrayList;", "Lcom/iqoption/core/features/limit/CurrencyValue;", "Lkotlin/collections/ArrayList;", "(ZLjava/lang/Long;Ljava/util/ArrayList;)Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ProDepositNavigatorFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return c.TAG;
        }

        public final h a(boolean z, Long l, ArrayList<com.iqoption.core.c.c.a> arrayList) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("ARG_DARK_DEPOSIT", z);
            if (l != null) {
                bundle.putLong("ARG_PAYMENT_METHOD_ID", l.longValue());
            }
            bundle.putParcelableArrayList("ARG_DEFAULT_PRESET", arrayList);
            return new h(Ll(), c.class, bundle, 0, 0, 0, 0, ChartTimeInterval.CANDLE_2m, null);
        }
    }

    private final Long aaB() {
        d dVar = this.ccl;
        j jVar = apP[1];
        return (Long) dVar.getValue();
    }

    private final ArrayList<com.iqoption.core.c.c.a> aaD() {
        d dVar = this.bXy;
        j jVar = apP[2];
        return (ArrayList) dVar.getValue();
    }

    private final boolean aeb() {
        d dVar = this.ccn;
        j jVar = apP[0];
        return ((Boolean) dVar.getValue()).booleanValue();
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public View dj(int i) {
        if (this.atz == null) {
            this.atz = new HashMap();
        }
        View view = (View) this.atz.get(Integer.valueOf(i));
        if (view == null) {
            view = getView();
            if (view == null) {
                return null;
            }
            view = view.findViewById(i);
            this.atz.put(Integer.valueOf(i), view);
        }
        return view;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    static {
        if (c.class.getName() == null) {
            kotlin.jvm.internal.h.aXZ();
        }
    }

    public ArrayList<com.iqoption.core.c.c.a> adP() {
        return aaD();
    }

    public void abB() {
        ChatActivity.aCF.a(com.iqoption.core.ext.a.m(this), null, ChatRoomType.SUPPORT);
    }

    public void close(boolean z) {
        z = z && aec();
        a aed = aed();
        if (aed != null) {
            aed.cA(z);
        }
    }

    /* JADX WARNING: Missing block: B:3:0x000e, code:
            if (r0 != null) goto L_0x0013;
     */
    public boolean adp() {
        /*
        r3 = this;
        r0 = com.iqoption.app.managers.feature.b.HT();
        r1 = "experimental-deposit-page";
        r0 = r0.fd(r1);
        if (r0 == 0) goto L_0x0011;
    L_0x000c:
        r0 = r0.status;
        if (r0 == 0) goto L_0x0011;
    L_0x0010:
        goto L_0x0013;
    L_0x0011:
        r0 = "disabled";
    L_0x0013:
        r1 = r0.hashCode();
        r2 = 1;
        switch(r1) {
            case -2059248520: goto L_0x0033;
            case -1619565966: goto L_0x0029;
            case -1605018400: goto L_0x0026;
            case 1275752347: goto L_0x0023;
            case 1631266500: goto L_0x001c;
            default: goto L_0x001b;
        };
    L_0x001b:
        goto L_0x0043;
    L_0x001c:
        r1 = "light-landscape";
    L_0x001e:
        r0 = r0.equals(r1);
        goto L_0x0043;
    L_0x0023:
        r1 = "dark-show-presets";
        goto L_0x001e;
    L_0x0026:
        r1 = "dark-hide-presets";
        goto L_0x001e;
    L_0x0029:
        r1 = "light-portrait";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0043;
    L_0x0031:
        r2 = 0;
        goto L_0x0043;
    L_0x0033:
        r1 = "light-both-mode";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0043;
    L_0x003b:
        r0 = com.iqoption.core.ext.a.m(r3);
        r2 = com.iqoption.core.util.q.bj(r0);
    L_0x0043:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.deposit.pro.c.adp():boolean");
    }

    public boolean abQ() {
        com.iqoption.app.a Cw = com.iqoption.app.a.Cw();
        if (com.iqoption.app.managers.feature.a.eW("kyc-deposit-limit") && Cw.Dh()) {
            kotlin.jvm.internal.h.d(Cw, "account");
            if (!Cw.isVerified()) {
                return true;
            }
        }
        return false;
    }

    public boolean acp() {
        com.iqoption.app.a aL = com.iqoption.app.a.aL((Context) zzakw());
        Feature fd = com.iqoption.app.managers.feature.b.HT().fd("kyc-show-after-registration");
        return com.iqoption.core.ext.c.b(fd != null ? fd.status : null, "enabled-before-dep", "enabled", "enabled-without-skip") && aL.Dh() && !aL.CZ() && !aL.akD;
    }

    public void cw(boolean z) {
        a aed = aed();
        if (aed != null) {
            aed.cw(z);
        }
    }

    public boolean aec() {
        boolean z = false;
        if (!isAdded()) {
            return false;
        }
        com.iqoption.app.a aL = com.iqoption.app.a.aL(com.iqoption.core.ext.a.m(this));
        if ((aL.akz && !aL.akD) || !(!aL.akB || aL.akI || aL.akF)) {
            z = true;
        }
        return z;
    }

    public boolean adO() {
        Feature fd = com.iqoption.app.managers.feature.b.HT().fd("experimental-deposit-page");
        return kotlin.jvm.internal.h.E(fd != null ? fd.status : null, "dark-hide-presets");
    }

    private final a aed() {
        FragmentActivity activity = zzakw();
        if (!(activity instanceof a)) {
            activity = null;
        }
        return (a) activity;
    }

    public boolean aci() {
        return aeb();
    }

    public Long adQ() {
        return aaB();
    }
}
