package com.iqoption.deposit;

import android.app.Activity;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.iqoption.core.f;
import com.iqoption.deposit.dark.DarkDepositActivity;
import com.iqoption.deposit.light.LightDepositActivity;
import com.iqoption.dto.entity.Feature;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.h;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007JA\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0005H\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, aXE = {"Lcom/iqoption/deposit/DepositFactory;", "", "()V", "paramsCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/iqoption/core/features/deposit/DefaultPresetParams;", "getDefaultPreset", "Ljava/util/ArrayList;", "Lcom/iqoption/core/features/limit/CurrencyValue;", "Lkotlin/collections/ArrayList;", "getDepositScreenType", "Lcom/iqoption/deposit/DepositScreenType;", "start3DsDeposit", "", "activity", "Landroid/app/Activity;", "startActivity", "currency", "isReturnToParent", "", "isNewUser", "paymentId", "", "(Landroid/app/Activity;Ljava/lang/String;ZZLjava/lang/Long;)V", "startCryptoDeposit", "IqOption-5.5.1_optionXRelease"})
/* compiled from: DepositFactory.kt */
public final class i {
    private static final ConcurrentHashMap<String, com.iqoption.core.c.b.a> bVr = new ConcurrentHashMap();
    public static final i bVs = new i();

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/ext/GsonExtensionsKt$parseGson$$inlined$typeOf$4"})
    /* compiled from: GsonExtensions.kt */
    public static final class a extends TypeToken<com.iqoption.core.c.b.a> {
    }

    public static final void a(Activity activity, String str, boolean z, boolean z2) {
        a(activity, str, z, z2, null, 16, null);
    }

    private i() {
    }

    public static /* bridge */ /* synthetic */ void a(Activity activity, String str, boolean z, boolean z2, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            str = (String) null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        if ((i & 16) != 0) {
            l = (Long) null;
        }
        a(activity, str, z, z2, l);
    }

    public static final void a(Activity activity, String str, boolean z, boolean z2, Long l) {
        h.e(activity, "activity");
        ArrayList aaD = bVs.aaD();
        switch (j.aoS[bVs.aaC().ordinal()]) {
            case 1:
                DarkDepositActivity.bXm.a(activity, aaD, z, l);
                return;
            case 2:
                LightDepositActivity.caA.a(activity, aaD, z, l);
                return;
            default:
                DepositActivity.a(activity, aaD, str, z, z2, l);
                return;
        }
    }

    public static final void o(Activity activity) {
        h.e(activity, "activity");
        ArrayList aaD = bVs.aaD();
        switch (j.auk[bVs.aaC().ordinal()]) {
            case 1:
                com.iqoption.deposit.dark.DarkDepositActivity.a.a(DarkDepositActivity.bXm, activity, aaD, false, null, 12, null);
                return;
            case 2:
                com.iqoption.deposit.light.LightDepositActivity.a.a(LightDepositActivity.caA, activity, aaD, false, null, 12, null);
                return;
            default:
                DepositActivity.a(activity, aaD, null);
                return;
        }
    }

    public static final void c(Activity activity, String str) {
        h.e(activity, "activity");
        h.e(str, b.CURRENCY);
        ArrayList aaD = bVs.aaD();
        switch (j.auV[bVs.aaC().ordinal()]) {
            case 1:
                com.iqoption.deposit.dark.DarkDepositActivity.a.a(DarkDepositActivity.bXm, activity, aaD, false, null, 12, null);
                return;
            case 2:
                com.iqoption.deposit.light.LightDepositActivity.a.a(LightDepositActivity.caA, activity, aaD, false, null, 12, null);
                return;
            default:
                DepositActivity.a(activity, str, null);
                return;
        }
    }

    /* JADX WARNING: Missing block: B:3:0x000e, code:
            if (r0 != null) goto L_0x0013;
     */
    /* JADX WARNING: Missing block: B:8:0x0021, code:
            if (r0.equals("light-landscape") != false) goto L_0x0049;
     */
    /* JADX WARNING: Missing block: B:10:0x002a, code:
            if (r0.equals("dark-show-presets") != false) goto L_0x0035;
     */
    /* JADX WARNING: Missing block: B:12:0x0033, code:
            if (r0.equals("dark-hide-presets") != false) goto L_0x0035;
     */
    /* JADX WARNING: Missing block: B:15:0x003e, code:
            if (r0.equals("light-portrait") != false) goto L_0x0049;
     */
    /* JADX WARNING: Missing block: B:17:0x0047, code:
            if (r0.equals("light-both-mode") != false) goto L_0x0049;
     */
    /* JADX WARNING: Missing block: B:20:?, code:
            return com.iqoption.deposit.DepositScreenType.OLD_LANDSCAPE;
     */
    /* JADX WARNING: Missing block: B:21:?, code:
            return com.iqoption.deposit.DepositScreenType.DARK_PORTRAIT;
     */
    /* JADX WARNING: Missing block: B:22:?, code:
            return com.iqoption.deposit.DepositScreenType.LIGHT;
     */
    private final com.iqoption.deposit.DepositScreenType aaC() {
        /*
        r2 = this;
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
        switch(r1) {
            case -2059248520: goto L_0x0041;
            case -1619565966: goto L_0x0038;
            case -1605018400: goto L_0x002d;
            case 1275752347: goto L_0x0024;
            case 1631266500: goto L_0x001b;
            default: goto L_0x001a;
        };
    L_0x001a:
        goto L_0x004c;
    L_0x001b:
        r1 = "light-landscape";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x004c;
    L_0x0023:
        goto L_0x0049;
    L_0x0024:
        r1 = "dark-show-presets";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x004c;
    L_0x002c:
        goto L_0x0035;
    L_0x002d:
        r1 = "dark-hide-presets";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x004c;
    L_0x0035:
        r0 = com.iqoption.deposit.DepositScreenType.DARK_PORTRAIT;
        goto L_0x004e;
    L_0x0038:
        r1 = "light-portrait";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x004c;
    L_0x0040:
        goto L_0x0049;
    L_0x0041:
        r1 = "light-both-mode";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x004c;
    L_0x0049:
        r0 = com.iqoption.deposit.DepositScreenType.LIGHT;
        goto L_0x004e;
    L_0x004c:
        r0 = com.iqoption.deposit.DepositScreenType.OLD_LANDSCAPE;
    L_0x004e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.deposit.i.aaC():com.iqoption.deposit.DepositScreenType");
    }

    private final ArrayList<com.iqoption.core.c.c.a> aaD() {
        Feature fd = com.iqoption.app.managers.feature.b.HT().fd("default-preset");
        if (fd == null) {
            return null;
        }
        try {
            JsonElement jsonElement = fd.params;
            String jsonElement2 = jsonElement.toString();
            com.iqoption.core.c.b.a aVar = (com.iqoption.core.c.b.a) bVr.get(jsonElement2);
            if (aVar == null) {
                h.d(jsonElement, "params");
                Gson Dq = f.RQ().Dq();
                Type type = new a().getType();
                h.d(type, "object : TypeToken<T>() {}.type");
                aVar = (com.iqoption.core.c.b.a) Dq.fromJson(jsonElement, type);
                Map map = bVr;
                h.d(jsonElement2, "key");
                map.put(jsonElement2, aVar);
            }
            for (Object next : aVar.SZ()) {
                if (h.E(((com.iqoption.core.c.c.b) next).Tc(), fd.status)) {
                    break;
                }
            }
            Object next2 = null;
            com.iqoption.core.c.c.b bVar = (com.iqoption.core.c.c.b) next2;
            return bVar != null ? bVar.Td() : null;
        } catch (Exception unused) {
            return null;
        }
    }
}
