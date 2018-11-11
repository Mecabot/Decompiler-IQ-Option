package com.iqoption.app.managers;

import android.content.Context;
import com.facebook.appevents.AppEventsLogger;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.dto.Event;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.mobbtech.connect.request.a.a.a;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* compiled from: TaggingManager */
public class ae {
    private static String anN;

    private static String db(int i) {
        switch (i) {
            case Integer.MIN_VALUE:
                return "twofactor authorization enabled";
            case 2:
                return "interested in special offer";
            case 4:
                return "registered as real";
            case 8:
                return "started tutorial video";
            case 16:
                return "watched tutorial video";
            case 32:
                return "changed chart type";
            case 64:
                return "added technical analysis";
            case 128:
                return "switched to top asset";
            case 256:
                return "tried to change asset";
            case 512:
                return "visited deposit page";
            case 1024:
                return "visited withdrawal page";
            case 2048:
                return "visited education";
            case 4096:
                return "visited tutorial";
            case 8192:
                return "visited faq";
            case 16384:
                return "visited about company";
            case 32768:
                return "changed deal amount manualy";
            case 65536:
                return "used historical prices";
            case 131072:
                return "watched enemy deals";
            case 262144:
                return "shared deal result";
            case 524288:
                return "refreshed demo";
            case 1048576:
                return "native_oneclick_visited";
            case 2097152:
                return "native_oneclick_payed";
            case 4194304:
                return "compact_closeddealpopup_used";
            case 8388608:
                return "tradeindicators_preset_added";
            case 16777216:
                return "open video tutorial";
            case 33554432:
                return "watched one video tutorial";
            case 67108864:
                return "watched all video tutorial";
            case 134217728:
                return "email confirmed";
            case 268435456:
                return "phone confirmed";
            case 536870912:
                return "unlock password added";
            case 1073741824:
                return "touch id enabled";
            default:
                return "";
        }
    }

    private static String dc(int i) {
        return i != 2 ? "" : "sell option used";
    }

    public static boolean b(Context context, int i) {
        return b("tagging_state", context, i);
    }

    private static void c(Context context, int i) {
        c("tagging_state", context, i);
    }

    public static synchronized void d(Context context, int i) {
        synchronized (ae.class) {
            if (b(context, i)) {
                return;
            }
            c(context, i);
            u(context, db(i));
        }
    }

    public static void aU(Context context) {
        if (anN != null) {
            u(context, anN);
            anN = null;
        }
    }

    private static boolean e(Context context, int i) {
        return b("tagging_state2", context, i);
    }

    private static void f(Context context, int i) {
        c("tagging_state2", context, i);
    }

    public static synchronized void g(Context context, int i) {
        synchronized (ae.class) {
            if (e(context, i)) {
                return;
            }
            f(context, i);
            u(context, dc(i));
        }
    }

    private static boolean b(String str, Context context, int i) {
        return (af.aR(context).ew(str) & i) == i;
    }

    private static void c(String str, Context context, int i) {
        af aR = af.aR(context);
        aR.u(str, i | aR.ew(str));
    }

    private static void u(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(Param.TYPE, Integer.valueOf(4));
        hashMap.put("name", str);
        str = IQApp.Dl().getClusterApi();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("api/tag/add");
        new a(RequestManager.b(stringBuilder.toString(), hashMap, context), null, "api/tag/add").auG();
    }

    public static synchronized void h(Context context, int i) {
        synchronized (ae.class) {
            if (b(context, i)) {
                return;
            }
            d(context, i);
            aV(context);
        }
    }

    private static synchronized void aV(Context context) {
        synchronized (ae.class) {
            af aR = af.aR(context);
            long EW = aR.EW();
            long currentTimeMillis = System.currentTimeMillis() - EW;
            int EY = aR.EY() + 1;
            aR.cS(EY);
            if (EW > 0 && currentTimeMillis <= TimeUnit.HOURS.toMillis(24)) {
                switch (EY) {
                    case 1:
                        AppEventsLogger.T(IQApp.Dk()).bq("fb_mobile_add_payment_info");
                        EventManager.Bm().b(Event.Builder(Event.CATEGORY_SYSTEM, "feature_userd_1").build());
                        break;
                    case 2:
                        AppEventsLogger.T(IQApp.Dk()).bq("fb_mobile_add_to_cart");
                        EventManager.Bm().b(Event.Builder(Event.CATEGORY_SYSTEM, "feature_userd_2").build());
                        break;
                    case 3:
                        AppEventsLogger.T(IQApp.Dk()).bq("fb_mobile_add_to_wishlist");
                        EventManager.Bm().b(Event.Builder(Event.CATEGORY_SYSTEM, "feature_userd_3").build());
                        break;
                    case 4:
                        AppEventsLogger.T(IQApp.Dk()).bq("fb_mobile_tutorial_completion");
                        EventManager.Bm().b(Event.Builder(Event.CATEGORY_SYSTEM, "feature_userd_4").build());
                        break;
                    case 5:
                        AppEventsLogger.T(IQApp.Dk()).bq("fb_mobile_initiated_checkout");
                        EventManager.Bm().b(Event.Builder(Event.CATEGORY_SYSTEM, "feature_userd_5").build());
                        break;
                }
            }
        }
    }
}
