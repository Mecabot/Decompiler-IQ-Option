package com.iqoption.core;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.PluralsRes;
import android.support.annotation.StringRes;
import android.widget.Toast;
import com.iqoption.core.connect.e;
import com.iqoption.core.connect.g;
import com.iqoption.core.connect.l;
import com.iqoption.core.ext.a;
import java.util.Arrays;
import java.util.Locale;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0010\u0010(\u001a\u00020)2\b\b\u0001\u0010*\u001a\u00020)\u001a\u0006\u0010+\u001a\u00020,\u001a\u0010\u0010-\u001a\u00020.2\b\b\u0001\u0010*\u001a\u00020)\u001a\u0018\u0010/\u001a\u00020,2\b\b\u0001\u0010*\u001a\u00020)2\u0006\u00100\u001a\u00020)\u001a\u0010\u00101\u001a\u00020,2\b\b\u0001\u0010*\u001a\u00020)\u001a)\u00101\u001a\u00020,2\b\b\u0001\u0010*\u001a\u00020)2\u0012\u00102\u001a\n\u0012\u0006\b\u0001\u0012\u00020403\"\u000204¢\u0006\u0002\u00105\u001a\u0006\u00106\u001a\u000207\u001a\u001a\u00108\u001a\u0002092\b\b\u0001\u0010*\u001a\u00020)2\b\b\u0002\u0010:\u001a\u00020)\u001a\u0018\u00108\u001a\u0002092\u0006\u0010;\u001a\u00020,2\b\b\u0002\u0010:\u001a\u00020)\"\u0011\u0010\u0000\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\"\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\"\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#\"\u0011\u0010$\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006<"}, aXE = {"account", "Lcom/iqoption/core/IQAccount;", "getAccount", "()Lcom/iqoption/core/IQAccount;", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "config", "Lcom/iqoption/core/Config;", "getConfig", "()Lcom/iqoption/core/Config;", "connect", "Lcom/iqoption/core/IQConnect;", "getConnect", "()Lcom/iqoption/core/IQConnect;", "core", "Lcom/iqoption/core/Core;", "getCore", "()Lcom/iqoption/core/Core;", "eventBuilderFactory", "Lcom/iqoption/core/connect/EventBuilderFactory;", "getEventBuilderFactory", "()Lcom/iqoption/core/connect/EventBuilderFactory;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "iqbus", "Lcom/iqoption/core/connect/IQBus;", "getIqbus", "()Lcom/iqoption/core/connect/IQBus;", "requestBuilderFactory", "Lcom/iqoption/core/connect/RequestBuilderFactory;", "getRequestBuilderFactory", "()Lcom/iqoption/core/connect/RequestBuilderFactory;", "timeServer", "Lcom/iqoption/core/TimeServer;", "getTimeServer", "()Lcom/iqoption/core/TimeServer;", "getColor", "", "resId", "getLocale", "", "getPixels", "", "getPlural", "quantity", "getString", "args", "", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "isChineLocale", "", "showGlobalError", "", "duration", "message", "core_release"})
/* compiled from: Global.kt */
public final class f {
    public static final c RQ() {
        return c.aMe.RI();
    }

    public static final b Dp() {
        return RQ().Dp();
    }

    public static final Context RR() {
        return RQ().getContext();
    }

    public static final h Dt() {
        return RQ().Dt();
    }

    public static final g RS() {
        return Dt().DR();
    }

    public static final l DS() {
        return Dt().DS();
    }

    public static final e DT() {
        return Dt().DT();
    }

    public static final g Dr() {
        return RQ().Dr();
    }

    public static final void C(String str, int i) {
        h.e(str, "message");
        Toast.makeText(RR(), str, i).show();
    }

    public static /* synthetic */ void a(int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        ab(i, i2);
    }

    public static final void ab(@StringRes int i, int i2) {
        Toast.makeText(RR(), i, i2).show();
    }

    public static final String getString(@StringRes int i) {
        String string = RR().getString(i);
        h.d(string, "appContext.getString(resId)");
        return string;
    }

    public static final String getString(@StringRes int i, Object... objArr) {
        h.e(objArr, "args");
        String string = RR().getString(i, Arrays.copyOf(objArr, objArr.length));
        h.d(string, "appContext.getString(resId, *args)");
        return string;
    }

    public static final String ac(@PluralsRes int i, int i2) {
        String quantityString = RR().getResources().getQuantityString(i, i2);
        h.d(quantityString, "appContext.resources.get…tyString(resId, quantity)");
        return quantityString;
    }

    public static final int getColor(@ColorRes int i) {
        return a.i(RR(), i);
    }

    /* JADX WARNING: Missing block: B:29:0x0083, code:
            if (r0.equals("in") != false) goto L_0x008e;
     */
    /* JADX WARNING: Missing block: B:31:0x008c, code:
            if (r0.equals("id") != false) goto L_0x008e;
     */
    /* JADX WARNING: Missing block: B:52:?, code:
            return "id_ID";
     */
    public static final java.lang.String getLocale() {
        /*
        r0 = java.util.Locale.getDefault();
        r1 = "Locale.getDefault()";
        kotlin.jvm.internal.h.d(r0, r1);
        r0 = r0.getLanguage();
        if (r0 != 0) goto L_0x0011;
    L_0x000f:
        goto L_0x00b2;
    L_0x0011:
        r1 = r0.hashCode();
        switch(r1) {
            case 3201: goto L_0x00a7;
            case 3246: goto L_0x009c;
            case 3276: goto L_0x0091;
            case 3355: goto L_0x0086;
            case 3365: goto L_0x007d;
            case 3371: goto L_0x0072;
            case 3428: goto L_0x0067;
            case 3588: goto L_0x005c;
            case 3651: goto L_0x0051;
            case 3666: goto L_0x0044;
            case 3700: goto L_0x0036;
            case 3710: goto L_0x0028;
            case 3886: goto L_0x001a;
            default: goto L_0x0018;
        };
    L_0x0018:
        goto L_0x00b2;
    L_0x001a:
        r1 = "zh";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00b2;
    L_0x0023:
        r0 = "zh_CN";
        goto L_0x00b4;
    L_0x0028:
        r1 = "tr";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00b2;
    L_0x0031:
        r0 = "tr_TR";
        goto L_0x00b4;
    L_0x0036:
        r1 = "th";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00b2;
    L_0x003f:
        r0 = "th_TH";
        goto L_0x00b4;
    L_0x0044:
        r1 = "se";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00b2;
    L_0x004c:
        r0 = "sv_SE";
        goto L_0x00b4;
    L_0x0051:
        r1 = "ru";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00b2;
    L_0x0059:
        r0 = "ru_RU";
        goto L_0x00b4;
    L_0x005c:
        r1 = "pt";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00b2;
    L_0x0064:
        r0 = "pt_PT";
        goto L_0x00b4;
    L_0x0067:
        r1 = "ko";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00b2;
    L_0x006f:
        r0 = "ko_KO";
        goto L_0x00b4;
    L_0x0072:
        r1 = "it";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00b2;
    L_0x007a:
        r0 = "it_IT";
        goto L_0x00b4;
    L_0x007d:
        r1 = "in";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00b2;
    L_0x0085:
        goto L_0x008e;
    L_0x0086:
        r1 = "id";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00b2;
    L_0x008e:
        r0 = "id_ID";
        goto L_0x00b4;
    L_0x0091:
        r1 = "fr";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00b2;
    L_0x0099:
        r0 = "fr_FR";
        goto L_0x00b4;
    L_0x009c:
        r1 = "es";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00b2;
    L_0x00a4:
        r0 = "es_ES";
        goto L_0x00b4;
    L_0x00a7:
        r1 = "de";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00b2;
    L_0x00af:
        r0 = "de_DE";
        goto L_0x00b4;
    L_0x00b2:
        r0 = "en_US";
    L_0x00b4:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.f.getLocale():java.lang.String");
    }

    public static final boolean RT() {
        Locale locale = Locale.getDefault();
        h.d(locale, "Locale.getDefault()");
        String language = locale.getLanguage();
        return language != null && language.hashCode() == 3886 && language.equals("zh");
    }
}
