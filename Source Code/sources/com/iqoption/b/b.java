package com.iqoption.b;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.appsflyer.f;
import com.google.common.util.concurrent.y;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.core.i;
import com.iqoption.core.util.p;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import java.util.Map;

/* compiled from: AppsFlyerListener */
public class b implements f {
    private final y<a> apJ;
    private final Builder apK = Event.Builder(Event.CATEGORY_SYSTEM, "appsflyer_install");
    private final Runnable apL = new c(this);

    /* compiled from: AppsFlyerListener */
    public static class a {
        public boolean apN;
        public Event apO;

        public a(boolean z, Event event) {
            this.apN = z;
            this.apO = event;
        }
    }

    public void aq(String str) {
    }

    public void f(Map<String, String> map) {
    }

    public b(y yVar) {
        this.apJ = yVar;
        com.iqoption.core.d.a.aSe.postDelayed(this.apL, 20000);
    }

    final /* synthetic */ void Jd() {
        this.apJ.P(new a(false, this.apK.calcDuration().setValue(Double.valueOf(0.0d)).build()));
    }

    public void e(Map<String, String> map) {
        d(IQApp.Dk(), map);
        t(map);
        if (this.apJ.P(new a(true, this.apK.calcDuration().setValue(Double.valueOf(1.0d)).build()))) {
            com.iqoption.core.d.a.aSe.removeCallbacks(this.apL);
        }
    }

    public void ap(String str) {
        this.apJ.P(new a(false, this.apK.calcDuration().setValue(Double.valueOf(0.0d)).build()));
    }

    private static void d(Context context, Map<String, String> map) {
        boolean z;
        String str = (String) map.get("pid");
        if (p.isEmpty(str)) {
            str = (String) map.get("media_source");
            if (TextUtils.isEmpty(str)) {
                str = (String) map.get("agency");
            }
        }
        if (p.isEmpty(str)) {
            str = "organic";
            z = false;
        } else {
            z = str.matches("\\d+");
        }
        String str2 = (String) map.get("c");
        if (p.isEmpty(str2)) {
            str2 = (String) map.get(com.google.firebase.analytics.FirebaseAnalytics.b.CAMPAIGN);
        }
        if (p.isEmpty(str2)) {
            str2 = "organic";
        }
        Integer fk = fk(str2);
        boolean matches = str2.matches("\\d+");
        String str3 = (String) map.get("Adset");
        if (p.isEmpty(str3)) {
            str3 = (String) map.get("adset");
        }
        String num = !TextUtils.isEmpty("") ? "" : z ? str : fk != null ? fk.toString() : (str.equalsIgnoreCase("tencentgdt_int") && matches) ? "139" : str.equalsIgnoreCase("twitter") ? "171" : (str.equalsIgnoreCase("googleadwordsoptimizer_int") && matches) ? "166" : (str.contains("googleadwords_int") && matches) ? "38933" : "606";
        if (!z) {
            StringBuilder stringBuilder;
            StringBuilder stringBuilder2;
            if (str.equalsIgnoreCase("tencentgdt_int") && matches) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("mob_tencentgdt_");
                stringBuilder.append(str2);
                str2 = stringBuilder.toString();
                if (!p.isEmpty(str3)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str2);
                    stringBuilder.append("_");
                    stringBuilder.append(str3);
                    str2 = stringBuilder.toString();
                }
            } else if (str.equalsIgnoreCase("twitter")) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str);
                stringBuilder2.append("_");
                stringBuilder2.append(str2);
                str2 = stringBuilder2.toString();
                if (!p.isEmpty(str3)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str2);
                    stringBuilder.append("_");
                    stringBuilder.append(str3);
                    str2 = stringBuilder.toString();
                }
            } else if (str.equalsIgnoreCase("googleadwordsoptimizer_int") && matches) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("adwords_");
                stringBuilder.append(str2);
                str2 = stringBuilder.toString();
                if (!p.isEmpty(str3)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str2);
                    stringBuilder.append("_");
                    stringBuilder.append(str3);
                    str2 = stringBuilder.toString();
                }
            } else if (str.contains("googleadwords_int") && matches) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("mob_googleadwords_int_");
                stringBuilder.append(str2);
                str2 = stringBuilder.toString();
                if (!p.isEmpty(str3)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str2);
                    stringBuilder.append("_");
                    stringBuilder.append(str3);
                    str2 = stringBuilder.toString();
                }
            } else {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("mob_");
                stringBuilder2.append(str);
                stringBuilder2.append("_");
                stringBuilder2.append(str2);
                str2 = stringBuilder2.toString();
                if (!p.isEmpty(str3)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str2);
                    stringBuilder.append("_");
                    stringBuilder.append(str3);
                    str2 = stringBuilder.toString();
                }
            }
        }
        str = str2.replace(" ", "_").replaceAll("[^A-Za-z0-9 _-]", "");
        af aR = af.aR(context);
        aR.ex(num);
        aR.ey(str);
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("AppsFlyer aff = ");
        stringBuilder3.append(num);
        i.d(stringBuilder3.toString());
    }

    private static void t(@Nullable Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AppsFlyer parseDeferredDeepLink = ");
        stringBuilder.append(map);
        i.d(stringBuilder.toString());
        if (map != null && Boolean.TRUE.toString().equals(map.get("is_first_launch"))) {
            String str = (String) map.get("af_dp");
            if (str != null) {
                try {
                    a.apE = Uri.parse(str);
                } catch (Exception unused) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Unable to parse deferred deep link: ");
                    stringBuilder.append(str);
                    i.w(stringBuilder.toString());
                }
            }
        }
    }

    private static Integer fk(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        char[] toCharArray = str.toCharArray();
        int length = toCharArray.length;
        Object obj = null;
        int i = 0;
        while (i < length) {
            char c = toCharArray[i];
            if (Character.isDigit(c)) {
                stringBuilder.append(c);
                i++;
            } else {
                if (c == '_') {
                    obj = 1;
                } else {
                    stringBuilder = null;
                }
                if (stringBuilder != null || stringBuilder.length() <= 0 || obj == null) {
                    return null;
                }
                try {
                    return Integer.valueOf(Integer.parseInt(stringBuilder.toString()));
                } catch (NumberFormatException unused) {
                    return null;
                }
            }
        }
        if (stringBuilder != null) {
        }
        return null;
    }
}
