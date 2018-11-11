package com.jumio.analytics;

import android.graphics.PointF;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import java.util.UUID;

public class MobileEvents {
    public static final int EVENTTYPE_ANDROID_LIFECYCLE = 303;
    public static final int EVENTTYPE_CUSTOMALERT = 311;
    public static final int EVENTTYPE_EMRTD = 308;
    public static final int EVENTTYPE_EXCEPTION = 305;
    public static final int EVENTTYPE_GENERIC = 0;
    public static final int EVENTTYPE_LIFENESS_INFO = 312;
    public static final int EVENTTYPE_MOBILE_DEVICE_INFO = 307;
    public static final int EVENTTYPE_NETWORKCALL = 309;
    public static final int EVENTTYPE_PAGEVIEW = 300;
    public static final int EVENTTYPE_RAW_TOUCH = 304;
    public static final int EVENTTYPE_SDKLIFECYCLE = 302;
    public static final int EVENTTYPE_SDKPARAMETERS = 306;
    public static final int EVENTTYPE_USERACTION = 301;
    private static Screen currentScreen;

    public static AnalyticsEvent pageView(UUID uuid, Screen screen, @Nullable MetaInfo metaInfo) {
        currentScreen = screen;
        return new AnalyticsEvent(300, uuid, screen.toString(), metaInfo);
    }

    public static AnalyticsEvent sdkLifecycle(UUID uuid, DismissType dismissType) {
        return new AnalyticsEvent(EVENTTYPE_SDKLIFECYCLE, uuid, dismissType.toString(), null);
    }

    public static AnalyticsEvent userAction(UUID uuid, @Nullable Screen screen, UserAction userAction) {
        MetaInfo metaInfo = new MetaInfo();
        addViewNameToMetaIfAvailable(metaInfo, screen);
        return new AnalyticsEvent(EVENTTYPE_USERACTION, uuid, userAction.toString(), metaInfo);
    }

    public static AnalyticsEvent userAction(UUID uuid, @Nullable Screen screen, UserAction userAction, String str) {
        MetaInfo metaInfo = new MetaInfo();
        addViewNameToMetaIfAvailable(metaInfo, screen);
        if (str != null) {
            metaInfo.put("additionalData", str);
        }
        return new AnalyticsEvent(EVENTTYPE_USERACTION, uuid, userAction.toString(), metaInfo);
    }

    private static void addViewNameToMetaIfAvailable(MetaInfo metaInfo, Screen screen) {
        if (screen == null) {
            screen = currentScreen;
        }
        if (screen != null) {
            metaInfo.put(Promotion.ACTION_VIEW, screen.toString());
        }
    }

    public static AnalyticsEvent userAction(UUID uuid, @Nullable Screen screen, UserAction userAction, MetaInfo metaInfo) {
        if (screen == null) {
            screen = currentScreen;
        }
        if (screen != null) {
            metaInfo.put(Promotion.ACTION_VIEW, screen.toString());
        }
        return new AnalyticsEvent(EVENTTYPE_USERACTION, uuid, userAction.toString(), metaInfo);
    }

    public static AnalyticsEvent sdkParameters(UUID uuid, MetaInfo metaInfo) {
        return new AnalyticsEvent(EVENTTYPE_SDKPARAMETERS, uuid, "noValue", metaInfo);
    }

    public static AnalyticsEvent mobileDeviceInformation(UUID uuid, String str, String str2, boolean z, boolean z2) {
        String valueOf = String.valueOf(VERSION.SDK_INT);
        String str3 = Build.MANUFACTURER;
        String str4 = Build.MODEL;
        MetaInfo metaInfo = new MetaInfo();
        metaInfo.put("sdk-version", str);
        metaInfo.put("os", "Android");
        metaInfo.put("os-version", valueOf);
        metaInfo.put("manufacturer", str3);
        metaInfo.put("model", str4);
        metaInfo.put("hasDeviceNFC", Boolean.valueOf(z));
        metaInfo.put("wasNFCenabled", Boolean.valueOf(z2));
        if (str2 != null) {
            metaInfo.put("network", str2);
        }
        return new AnalyticsEvent(307, uuid, "noValue", metaInfo);
    }

    public static AnalyticsEvent emrtd(UUID uuid, int i, boolean z, String str, String str2) {
        MetaInfo metaInfo = new MetaInfo();
        metaInfo.put("numCscaFound", String.valueOf(i));
        metaInfo.put("hasUsedEMRTD", String.valueOf(z));
        metaInfo.put("scanreference", str);
        if (str2 != null && str2.length() > 0) {
            metaInfo.put("error", str2);
        }
        return new AnalyticsEvent(308, uuid, "emrtd", metaInfo);
    }

    public static AnalyticsEvent exception(UUID uuid, Exception exception) {
        Writer stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        return new AnalyticsEvent(EVENTTYPE_EXCEPTION, uuid, stringWriter.toString(), null);
    }

    public static AnalyticsEvent customAlert(UUID uuid, String str, MetaInfo metaInfo) {
        return new AnalyticsEvent(EVENTTYPE_CUSTOMALERT, uuid, str, metaInfo);
    }

    public static AnalyticsEvent liveness(UUID uuid, String str, MetaInfo metaInfo) {
        return new AnalyticsEvent(EVENTTYPE_LIFENESS_INFO, uuid, str, metaInfo);
    }

    public static AnalyticsEvent rawTouch(UUID uuid, List<PointF> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (PointF pointF : list) {
            stringBuilder.append(String.format("%.2f:%.2f", new Object[]{Float.valueOf(pointF.x), Float.valueOf(pointF.y)}));
            stringBuilder.append(",");
        }
        return new AnalyticsEvent(EVENTTYPE_RAW_TOUCH, uuid, stringBuilder.toString(), null);
    }

    public static AnalyticsEvent networkRequest(UUID uuid, String str, int i, String str2, long j) {
        MetaInfo metaInfo = new MetaInfo();
        metaInfo.put("http", String.valueOf(i));
        metaInfo.put("message", str2);
        metaInfo.put("roundtrip", String.valueOf(j));
        return new AnalyticsEvent(EVENTTYPE_NETWORKCALL, uuid, str, metaInfo);
    }
}
