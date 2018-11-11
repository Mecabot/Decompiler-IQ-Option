package com.facebook.a.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdManager.RegistrationListener;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import com.facebook.h;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.w;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.b;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DeviceRequestsHelper */
public class a {
    private static HashMap<String, RegistrationListener> Bu = new HashMap();
    private static final String TAG = a.class.getCanonicalName();

    public static String lt() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device", Build.DEVICE);
            jSONObject.put("model", Build.MODEL);
        } catch (JSONException unused) {
            return jSONObject.toString();
        }
    }

    public static boolean bx(String str) {
        return isAvailable() ? bA(str) : false;
    }

    public static boolean isAvailable() {
        return VERSION.SDK_INT >= 16 && FetchedAppSettingsManager.bF(h.it()).lI().contains(SmartLoginOption.Enabled);
    }

    public static Bitmap by(String str) {
        Map enumMap = new EnumMap(EncodeHintType.class);
        enumMap.put(EncodeHintType.MARGIN, Integer.valueOf(2));
        Bitmap createBitmap;
        try {
            b a = new com.google.zxing.b().a(str, BarcodeFormat.QR_CODE, 200, 200, enumMap);
            int height = a.getHeight();
            int width = a.getWidth();
            int[] iArr = new int[(height * width)];
            for (int i = 0; i < height; i++) {
                int i2 = i * width;
                for (int i3 = 0; i3 < width; i3++) {
                    iArr[i2 + i3] = a.L(i3, i) ? ViewCompat.MEASURED_STATE_MASK : -1;
                }
            }
            createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
            try {
                createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
            } catch (WriterException unused) {
                return createBitmap;
            }
        } catch (WriterException unused2) {
            createBitmap = null;
        }
    }

    public static void bz(String str) {
        bB(str);
    }

    @TargetApi(16)
    private static boolean bA(final String str) {
        if (Bu.containsKey(str)) {
            return true;
        }
        String replace = h.ja().replace('.', '|');
        r3 = new Object[3];
        r3[1] = String.format("%s-%s", new Object[]{"android", replace});
        r3[2] = str;
        replace = String.format("%s_%s_%s", r3);
        NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
        nsdServiceInfo.setServiceType("_fb._tcp.");
        nsdServiceInfo.setServiceName(replace);
        nsdServiceInfo.setPort(80);
        NsdManager nsdManager = (NsdManager) h.getApplicationContext().getSystemService("servicediscovery");
        RegistrationListener anonymousClass1 = new RegistrationListener() {
            public void onServiceUnregistered(NsdServiceInfo nsdServiceInfo) {
            }

            public void onUnregistrationFailed(NsdServiceInfo nsdServiceInfo, int i) {
            }

            public void onServiceRegistered(NsdServiceInfo nsdServiceInfo) {
                if (!replace.equals(nsdServiceInfo.getServiceName())) {
                    a.bz(str);
                }
            }

            public void onRegistrationFailed(NsdServiceInfo nsdServiceInfo, int i) {
                a.bz(str);
            }
        };
        Bu.put(str, anonymousClass1);
        nsdManager.registerService(nsdServiceInfo, 1, anonymousClass1);
        return true;
    }

    @TargetApi(16)
    private static void bB(String str) {
        RegistrationListener registrationListener = (RegistrationListener) Bu.get(str);
        if (registrationListener != null) {
            try {
                ((NsdManager) h.getApplicationContext().getSystemService("servicediscovery")).unregisterService(registrationListener);
            } catch (Exception e) {
                w.a(TAG, e);
            }
            Bu.remove(str);
        }
    }
}
