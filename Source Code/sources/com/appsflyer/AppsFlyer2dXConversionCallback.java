package com.appsflyer;

import android.support.v4.app.NotificationCompat;
import java.util.Map;
import org.json.JSONObject;

public class AppsFlyer2dXConversionCallback implements f {
    public native void onAppOpenAttributionNative(Object obj);

    public native void onAttributionFailureNative(Object obj);

    public native void onInstallConversionDataLoadedNative(Object obj);

    public native void onInstallConversionFailureNative(Object obj);

    public void e(Map<String, String> map) {
        onInstallConversionDataLoadedNative(map);
    }

    public void ap(String str) {
        h("onAttributionFailure", str);
    }

    public void f(Map<String, String> map) {
        onAppOpenAttributionNative(map);
    }

    public void aq(String str) {
        h("onInstallConversionFailure", str);
    }

    private void h(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, "failure");
            jSONObject.put("data", str2);
            Object obj = -1;
            int hashCode = str.hashCode();
            if (hashCode != -1390007222) {
                if (hashCode == 1050716216 && str.equals("onInstallConversionFailure")) {
                    obj = null;
                }
            } else if (str.equals("onAttributionFailure")) {
                obj = 1;
            }
            switch (obj) {
                case null:
                    onInstallConversionFailureNative(jSONObject);
                    return;
                case 1:
                    onAttributionFailureNative(jSONObject);
                    break;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
