package com.crashlytics.android.answers;

import android.os.Bundle;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.firebase.analytics.FirebaseAnalytics.a;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import io.fabric.sdk.android.c;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: FirebaseAnalyticsEventMapper */
public class r {
    private static final Set<String> sF = new HashSet(Arrays.asList(new String[]{"app_clear_data", "app_exception", "app_remove", "app_upgrade", "app_install", "app_update", "firebase_campaign", "error", "first_open", "first_visit", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "user_engagement", "ad_exposure", "adunit_exposure", "ad_query", "ad_activeview", "ad_impression", "ad_click", "screen_view", "firebase_extra_parameter"}));

    public q c(SessionEvent sessionEvent) {
        boolean z = false;
        Object obj = (!Type.CUSTOM.equals(sessionEvent.sU) || sessionEvent.sW == null) ? null : 1;
        Object obj2 = (!Type.PREDEFINED.equals(sessionEvent.sU) || sessionEvent.sY == null) ? null : 1;
        if (obj == null && obj2 == null) {
            return null;
        }
        Bundle d;
        String d2;
        if (obj2 != null) {
            d = d(sessionEvent);
        } else {
            d = new Bundle();
            if (sessionEvent.sX != null) {
                a(d, sessionEvent.sX);
            }
        }
        if (obj2 != null) {
            String str = (String) sessionEvent.sZ.get(b.SUCCESS);
            if (!(str == null || Boolean.parseBoolean(str))) {
                z = true;
            }
            d2 = d(sessionEvent.sY, z);
        } else {
            d2 = aK(sessionEvent.sW);
        }
        c.aUg().d("Answers", "Logging event into firebase...");
        return new q(d2, d);
    }

    private String aK(String str) {
        if (str == null || str.length() == 0) {
            return "fabric_unnamed_event";
        }
        StringBuilder stringBuilder;
        if (sF.contains(str)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("fabric_");
            stringBuilder.append(str);
            return stringBuilder.toString();
        }
        str = str.replaceAll("[^\\p{Alnum}_]+", "_");
        if (str.startsWith("ga_") || str.startsWith("google_") || str.startsWith("firebase_") || !Character.isLetter(str.charAt(0))) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("fabric_");
            stringBuilder.append(str);
            str = stringBuilder.toString();
        }
        if (str.length() > 40) {
            str = str.substring(0, 40);
        }
        return str;
    }

    private String aL(String str) {
        if (str == null || str.length() == 0) {
            return "fabric_unnamed_parameter";
        }
        str = str.replaceAll("[^\\p{Alnum}_]+", "_");
        if (str.startsWith("ga_") || str.startsWith("google_") || str.startsWith("firebase_") || !Character.isLetter(str.charAt(0))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("fabric_");
            stringBuilder.append(str);
            str = stringBuilder.toString();
        }
        return str.length() > 40 ? str.substring(0, 40) : str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARNING: Missing block: B:43:0x008b, code:
            if (r6.equals("addToCart") != false) goto L_0x00cd;
     */
    private java.lang.String d(java.lang.String r6, boolean r7) {
        /*
        r5 = this;
        r0 = 1;
        r1 = 2;
        r2 = 0;
        r3 = -1;
        if (r7 == 0) goto L_0x0046;
    L_0x0006:
        r7 = r6.hashCode();
        r4 = -902468296; // 0xffffffffca356d38 float:-2972494.0 double:NaN;
        if (r7 == r4) goto L_0x002e;
    L_0x000f:
        r4 = 103149417; // 0x625ef69 float:3.1208942E-35 double:5.09625833E-316;
        if (r7 == r4) goto L_0x0024;
    L_0x0014:
        r4 = 1743324417; // 0x67e90501 float:2.2008074E24 double:8.61316704E-315;
        if (r7 == r4) goto L_0x001a;
    L_0x0019:
        goto L_0x0038;
    L_0x001a:
        r7 = "purchase";
        r7 = r6.equals(r7);
        if (r7 == 0) goto L_0x0038;
    L_0x0022:
        r7 = 0;
        goto L_0x0039;
    L_0x0024:
        r7 = "login";
        r7 = r6.equals(r7);
        if (r7 == 0) goto L_0x0038;
    L_0x002c:
        r7 = 2;
        goto L_0x0039;
    L_0x002e:
        r7 = "signUp";
        r7 = r6.equals(r7);
        if (r7 == 0) goto L_0x0038;
    L_0x0036:
        r7 = 1;
        goto L_0x0039;
    L_0x0038:
        r7 = -1;
    L_0x0039:
        switch(r7) {
            case 0: goto L_0x0043;
            case 1: goto L_0x0040;
            case 2: goto L_0x003d;
            default: goto L_0x003c;
        };
    L_0x003c:
        goto L_0x0046;
    L_0x003d:
        r6 = "failed_login";
        return r6;
    L_0x0040:
        r6 = "failed_sign_up";
        return r6;
    L_0x0043:
        r6 = "failed_ecommerce_purchase";
        return r6;
    L_0x0046:
        r7 = r6.hashCode();
        switch(r7) {
            case -2131650889: goto L_0x00c1;
            case -1183699191: goto L_0x00b6;
            case -938102371: goto L_0x00ac;
            case -906336856: goto L_0x00a2;
            case -902468296: goto L_0x0098;
            case -389087554: goto L_0x008e;
            case 23457852: goto L_0x0085;
            case 103149417: goto L_0x007a;
            case 109400031: goto L_0x0070;
            case 196004670: goto L_0x0065;
            case 1664021448: goto L_0x005a;
            case 1743324417: goto L_0x004f;
            default: goto L_0x004d;
        };
    L_0x004d:
        goto L_0x00cc;
    L_0x004f:
        r7 = "purchase";
        r7 = r6.equals(r7);
        if (r7 == 0) goto L_0x00cc;
    L_0x0057:
        r0 = 0;
        goto L_0x00cd;
    L_0x005a:
        r7 = "startCheckout";
        r7 = r6.equals(r7);
        if (r7 == 0) goto L_0x00cc;
    L_0x0062:
        r0 = 2;
        goto L_0x00cd;
    L_0x0065:
        r7 = "levelStart";
        r7 = r6.equals(r7);
        if (r7 == 0) goto L_0x00cc;
    L_0x006d:
        r0 = 10;
        goto L_0x00cd;
    L_0x0070:
        r7 = "share";
        r7 = r6.equals(r7);
        if (r7 == 0) goto L_0x00cc;
    L_0x0078:
        r0 = 5;
        goto L_0x00cd;
    L_0x007a:
        r7 = "login";
        r7 = r6.equals(r7);
        if (r7 == 0) goto L_0x00cc;
    L_0x0082:
        r0 = 8;
        goto L_0x00cd;
    L_0x0085:
        r7 = "addToCart";
        r7 = r6.equals(r7);
        if (r7 == 0) goto L_0x00cc;
    L_0x008d:
        goto L_0x00cd;
    L_0x008e:
        r7 = "contentView";
        r7 = r6.equals(r7);
        if (r7 == 0) goto L_0x00cc;
    L_0x0096:
        r0 = 3;
        goto L_0x00cd;
    L_0x0098:
        r7 = "signUp";
        r7 = r6.equals(r7);
        if (r7 == 0) goto L_0x00cc;
    L_0x00a0:
        r0 = 7;
        goto L_0x00cd;
    L_0x00a2:
        r7 = "search";
        r7 = r6.equals(r7);
        if (r7 == 0) goto L_0x00cc;
    L_0x00aa:
        r0 = 4;
        goto L_0x00cd;
    L_0x00ac:
        r7 = "rating";
        r7 = r6.equals(r7);
        if (r7 == 0) goto L_0x00cc;
    L_0x00b4:
        r0 = 6;
        goto L_0x00cd;
    L_0x00b6:
        r7 = "invite";
        r7 = r6.equals(r7);
        if (r7 == 0) goto L_0x00cc;
    L_0x00be:
        r0 = 9;
        goto L_0x00cd;
    L_0x00c1:
        r7 = "levelEnd";
        r7 = r6.equals(r7);
        if (r7 == 0) goto L_0x00cc;
    L_0x00c9:
        r0 = 11;
        goto L_0x00cd;
    L_0x00cc:
        r0 = -1;
    L_0x00cd:
        switch(r0) {
            case 0: goto L_0x00f6;
            case 1: goto L_0x00f3;
            case 2: goto L_0x00f0;
            case 3: goto L_0x00ed;
            case 4: goto L_0x00ea;
            case 5: goto L_0x00e7;
            case 6: goto L_0x00e4;
            case 7: goto L_0x00e1;
            case 8: goto L_0x00de;
            case 9: goto L_0x00db;
            case 10: goto L_0x00d8;
            case 11: goto L_0x00d5;
            default: goto L_0x00d0;
        };
    L_0x00d0:
        r6 = r5.aK(r6);
        return r6;
    L_0x00d5:
        r6 = "level_end";
        return r6;
    L_0x00d8:
        r6 = "level_start";
        return r6;
    L_0x00db:
        r6 = "invite";
        return r6;
    L_0x00de:
        r6 = "login";
        return r6;
    L_0x00e1:
        r6 = "sign_up";
        return r6;
    L_0x00e4:
        r6 = "rate_content";
        return r6;
    L_0x00e7:
        r6 = "share";
        return r6;
    L_0x00ea:
        r6 = "search";
        return r6;
    L_0x00ed:
        r6 = "select_content";
        return r6;
    L_0x00f0:
        r6 = "begin_checkout";
        return r6;
    L_0x00f3:
        r6 = "add_to_cart";
        return r6;
    L_0x00f6:
        r6 = "ecommerce_purchase";
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.answers.r.d(java.lang.String, boolean):java.lang.String");
    }

    private Bundle d(SessionEvent sessionEvent) {
        Bundle bundle = new Bundle();
        if (ProductAction.ACTION_PURCHASE.equals(sessionEvent.sY)) {
            a(bundle, b.ITEM_ID, (String) sessionEvent.sZ.get("itemId"));
            a(bundle, b.ITEM_NAME, (String) sessionEvent.sZ.get("itemName"));
            a(bundle, b.ITEM_CATEGORY, (String) sessionEvent.sZ.get("itemType"));
            a(bundle, b.VALUE, m(sessionEvent.sZ.get("itemPrice")));
            a(bundle, b.CURRENCY, (String) sessionEvent.sZ.get(b.CURRENCY));
        } else if ("addToCart".equals(sessionEvent.sY)) {
            a(bundle, b.ITEM_ID, (String) sessionEvent.sZ.get("itemId"));
            a(bundle, b.ITEM_NAME, (String) sessionEvent.sZ.get("itemName"));
            a(bundle, b.ITEM_CATEGORY, (String) sessionEvent.sZ.get("itemType"));
            a(bundle, "price", m(sessionEvent.sZ.get("itemPrice")));
            a(bundle, b.VALUE, m(sessionEvent.sZ.get("itemPrice")));
            a(bundle, b.CURRENCY, (String) sessionEvent.sZ.get(b.CURRENCY));
            bundle.putLong(b.QUANTITY, 1);
        } else if ("startCheckout".equals(sessionEvent.sY)) {
            a(bundle, b.QUANTITY, Long.valueOf((long) ((Integer) sessionEvent.sZ.get("itemCount")).intValue()));
            a(bundle, b.VALUE, m(sessionEvent.sZ.get("totalPrice")));
            a(bundle, b.CURRENCY, (String) sessionEvent.sZ.get(b.CURRENCY));
        } else if ("contentView".equals(sessionEvent.sY)) {
            a(bundle, b.CONTENT_TYPE, (String) sessionEvent.sZ.get("contentType"));
            a(bundle, b.ITEM_ID, (String) sessionEvent.sZ.get("contentId"));
            a(bundle, b.ITEM_NAME, (String) sessionEvent.sZ.get("contentName"));
        } else if ("search".equals(sessionEvent.sY)) {
            a(bundle, b.SEARCH_TERM, (String) sessionEvent.sZ.get(SearchIntents.EXTRA_QUERY));
        } else if (a.SHARE.equals(sessionEvent.sY)) {
            a(bundle, b.METHOD, (String) sessionEvent.sZ.get(b.METHOD));
            a(bundle, b.CONTENT_TYPE, (String) sessionEvent.sZ.get("contentType"));
            a(bundle, b.ITEM_ID, (String) sessionEvent.sZ.get("contentId"));
            a(bundle, b.ITEM_NAME, (String) sessionEvent.sZ.get("contentName"));
        } else if ("rating".equals(sessionEvent.sY)) {
            a(bundle, "rating", String.valueOf(sessionEvent.sZ.get("rating")));
            a(bundle, b.CONTENT_TYPE, (String) sessionEvent.sZ.get("contentType"));
            a(bundle, b.ITEM_ID, (String) sessionEvent.sZ.get("contentId"));
            a(bundle, b.ITEM_NAME, (String) sessionEvent.sZ.get("contentName"));
        } else if ("signUp".equals(sessionEvent.sY)) {
            a(bundle, b.METHOD, (String) sessionEvent.sZ.get(b.METHOD));
        } else if (a.LOGIN.equals(sessionEvent.sY)) {
            a(bundle, b.METHOD, (String) sessionEvent.sZ.get(b.METHOD));
        } else if ("invite".equals(sessionEvent.sY)) {
            a(bundle, b.METHOD, (String) sessionEvent.sZ.get(b.METHOD));
        } else if ("levelStart".equals(sessionEvent.sY)) {
            a(bundle, b.LEVEL_NAME, (String) sessionEvent.sZ.get("levelName"));
        } else if ("levelEnd".equals(sessionEvent.sY)) {
            a(bundle, b.SCORE, l(sessionEvent.sZ.get(b.SCORE)));
            a(bundle, b.LEVEL_NAME, (String) sessionEvent.sZ.get("levelName"));
            a(bundle, b.SUCCESS, aM((String) sessionEvent.sZ.get(b.SUCCESS)));
        }
        a(bundle, sessionEvent.sX);
        return bundle;
    }

    private void a(Bundle bundle, String str, Long l) {
        if (l != null) {
            bundle.putLong(str, l.longValue());
        }
    }

    private void a(Bundle bundle, String str, Integer num) {
        if (num != null) {
            bundle.putInt(str, num.intValue());
        }
    }

    private void a(Bundle bundle, String str, String str2) {
        if (str2 != null) {
            bundle.putString(str, str2);
        }
    }

    private void a(Bundle bundle, String str, Double d) {
        d = l(d);
        if (d != null) {
            bundle.putDouble(str, d.doubleValue());
        }
    }

    private Double l(Object obj) {
        String valueOf = String.valueOf(obj);
        if (valueOf == null) {
            return null;
        }
        return Double.valueOf(valueOf);
    }

    private Integer aM(String str) {
        return str == null ? null : Integer.valueOf(str.equals("true"));
    }

    private Double m(Object obj) {
        Long l = (Long) obj;
        if (l == null) {
            return null;
        }
        return Double.valueOf(new BigDecimal(l.longValue()).divide(a.rN).doubleValue());
    }

    private void a(Bundle bundle, Map<String, Object> map) {
        for (Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            String aL = aL((String) entry.getKey());
            if (value instanceof String) {
                bundle.putString(aL, entry.getValue().toString());
            } else if (value instanceof Double) {
                bundle.putDouble(aL, ((Double) entry.getValue()).doubleValue());
            } else if (value instanceof Long) {
                bundle.putLong(aL, ((Long) entry.getValue()).longValue());
            } else if (value instanceof Integer) {
                bundle.putInt(aL, ((Integer) entry.getValue()).intValue());
            }
        }
    }
}
