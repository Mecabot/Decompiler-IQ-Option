package com.iqoption.withdrawal.crypto;

import android.os.Parcelable;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import com.google.common.util.concurrent.g;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.app.IQApp;
import com.iqoption.core.i;
import com.iqoption.dto.Currencies;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.dto.entity.result.KycState;
import com.iqoption.kyc.c;
import com.iqoption.kyc.f;
import com.iqoption.mobbtech.connect.request.api.b;
import com.iqoption.mobbtech.connect.response.e;
import com.iqoption.util.l;
import com.iqoption.util.q;
import com.iqoption.withdrawal.crypto.fragment.WithdrawalCryptoPagerFragment;
import com.iqoption.withdrawal.crypto.kyc.KycWithdrawalStatus;
import java.text.DecimalFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: WithdrawalCryptoUtil */
public final class a {
    public static final Pattern dRT = Pattern.compile("^(bitcoin:)?([13][a-km-zA-HJ-NP-Z0-9]{25,34})(.*)?$");
    public static final Pattern dRU = Pattern.compile("^(0x)?[0-9a-fA-F]{40}$");
    public static final Pattern dRV = Pattern.compile("^(iban:)?(XE){1}(.{18}|.{32}|.{33})$");

    public static KycWithdrawalStatus a(KycState kycState, com.iqoption.microservice.a.b.a aVar) {
        if (new c(IQApp.Dk(), kycState).Dh() && kycState.status.intValue() == 3) {
            return KycWithdrawalStatus.Done;
        }
        if (!kycState.isRegulatedUser.booleanValue() && kycState.status.intValue() == 3 && aVar.cRL) {
            return KycWithdrawalStatus.Done;
        }
        if (kycState.status.intValue() != 3 && !kycState.isProfileFilled.booleanValue()) {
            return KycWithdrawalStatus.NotFilled;
        }
        if ("NOT_UPLOADED".equals(aVar.cRM)) {
            return KycWithdrawalStatus.DocumentsNotUploaded;
        }
        if ("INITIATED".equals(aVar.cRM)) {
            return KycWithdrawalStatus.UploadIsNotFinishingByUser;
        }
        if ("VERIFYING".equals(aVar.cRM)) {
            return KycWithdrawalStatus.DocumentOnVerification;
        }
        if ("DECLINED".equals(aVar.cRM)) {
            return KycWithdrawalStatus.DocumentsIsDeclined;
        }
        if ("APPROVED".equals(aVar.cRM)) {
            return KycWithdrawalStatus.Done;
        }
        String str = WithdrawalCryptoPagerFragment.TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unknown kyc documentsStatus ");
        stringBuilder.append(aVar.cRM);
        i.e(str, stringBuilder.toString());
        return KycWithdrawalStatus.NotFilled;
    }

    public static double b(e eVar) {
        return eVar == null ? Double.MAX_VALUE : eVar.cVK.doubleValue();
    }

    public static double N(double d) {
        return q.j(d, 2);
    }

    public static boolean aF(String str, String str2) {
        boolean z = false;
        if (str == null) {
            return false;
        }
        Object obj = -1;
        int hashCode = str2.hashCode();
        if (hashCode != 66097) {
            if (hashCode == 78601 && str2.equals(Currencies.OTN_CURRENCY)) {
                obj = 1;
            }
        } else if (str2.equals(Currencies.BTC_CURRENCY)) {
            obj = null;
        }
        switch (obj) {
            case null:
                return dRT.matcher(str).matches();
            case 1:
                if (dRU.matcher(str).matches() || dRV.matcher(str).matches()) {
                    z = true;
                }
                return z;
            default:
                return str.isEmpty() ^ true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0028 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0028 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0029  */
    public static java.lang.String aG(java.lang.String r3, java.lang.String r4) {
        /*
        r0 = r4.hashCode();
        r1 = 66097; // 0x10231 float:9.2622E-41 double:3.26563E-319;
        if (r0 == r1) goto L_0x0019;
    L_0x0009:
        r1 = 78601; // 0x13309 float:1.10143E-40 double:3.8834E-319;
        if (r0 == r1) goto L_0x000f;
    L_0x000e:
        goto L_0x0023;
    L_0x000f:
        r0 = "OTN";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x0023;
    L_0x0017:
        r4 = 1;
        goto L_0x0024;
    L_0x0019:
        r0 = "BTC";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x0023;
    L_0x0021:
        r4 = 0;
        goto L_0x0024;
    L_0x0023:
        r4 = -1;
    L_0x0024:
        r0 = 2;
        switch(r4) {
            case 0: goto L_0x005b;
            case 1: goto L_0x0029;
            default: goto L_0x0028;
        };
    L_0x0028:
        return r3;
    L_0x0029:
        r4 = dRV;
        r4 = r4.matcher(r3);
        r1 = r4.matches();
        if (r1 == 0) goto L_0x0075;
    L_0x0035:
        r1 = r4.groupCount();
        if (r1 < r0) goto L_0x0075;
    L_0x003b:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
    L_0x0040:
        r1 = r4.groupCount();
        if (r0 >= r1) goto L_0x0056;
    L_0x0046:
        r1 = r4.group(r0);
        r2 = android.text.TextUtils.isEmpty(r1);
        if (r2 != 0) goto L_0x0053;
    L_0x0050:
        r3.append(r1);
    L_0x0053:
        r0 = r0 + 1;
        goto L_0x0040;
    L_0x0056:
        r3 = r3.toString();
        return r3;
    L_0x005b:
        r4 = dRT;
        r4 = r4.matcher(r3);
        r1 = r4.matches();
        if (r1 == 0) goto L_0x0075;
    L_0x0067:
        r3 = r4.groupCount();
        if (r3 < r0) goto L_0x0072;
    L_0x006d:
        r3 = r4.group(r0);
        goto L_0x0074;
    L_0x0072:
        r3 = "";
    L_0x0074:
        return r3;
    L_0x0075:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.withdrawal.crypto.a.aG(java.lang.String, java.lang.String):java.lang.String");
    }

    public static String aH(String str, String str2) {
        Object obj = (str2.hashCode() == 66097 && str2.equals(Currencies.BTC_CURRENCY)) ? null : -1;
        if (obj != null) {
            return str;
        }
        Matcher matcher = dRT.matcher(str);
        if (!matcher.matches()) {
            return str;
        }
        if (matcher.groupCount() >= 3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String) com.google.common.base.e.h(matcher.group(1), ""));
            stringBuilder.append((String) com.google.common.base.e.h(matcher.group(2), ""));
            str = stringBuilder.toString();
        }
        return str;
    }

    @NonNull
    public static s<List<Parcelable>> d(double d, double d2, String str) {
        s aoR = new f(IQApp.Dk()).aoR();
        s eb = com.iqoption.microservice.a.a.eb(false);
        com.iqoption.mobbtech.connect.response.a.a.ava().onStart();
        final double d3 = d;
        final double d4 = d2;
        final String str2 = str;
        s a = o.a(com.iqoption.mobbtech.connect.response.a.a.ava().iM("PortfolioFragment"), new g<com.iqoption.core.microservices.billing.response.b.a, e>() {
            /* renamed from: d */
            public s<e> aP(com.iqoption.core.microservices.billing.response.b.a aVar) {
                return b.a(aVar.getHost(), aVar.Uy(), d3, d4, str2);
            }
        });
        return o.a(aoR, eb, a);
    }

    public static void a(FragmentManager fragmentManager, int i, KycState kycState, com.iqoption.microservice.a.b.a aVar, e eVar, double d, double d2, String str, Position position, @IdRes int i2, boolean z) {
        fragmentManager.beginTransaction().add(i, WithdrawalCryptoPagerFragment.a(kycState, aVar, eVar, d, d2, str, position, i2, z), WithdrawalCryptoPagerFragment.TAG).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack(WithdrawalCryptoPagerFragment.TAG).commitAllowingStateLoss();
        fragmentManager.executePendingTransactions();
    }

    public static boolean aNZ() {
        String eY = com.iqoption.app.managers.feature.b.HT().eY("crypto-withdraw");
        return "enabled_show_3ds".equals(eY) || "enabled_hide_3ds".equals(eY);
    }

    public static boolean aOa() {
        return "enabled_show_3ds".equals(com.iqoption.app.managers.feature.b.HT().eY("crypto-withdraw"));
    }

    public static DecimalFormat kr(String str) {
        if (TextUtils.isEmpty(str)) {
            return q.dX(6);
        }
        return q.dX(l.g(com.iqoption.app.a.Cw().eh(str)));
    }
}
