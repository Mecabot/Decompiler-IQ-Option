package a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.plus.PlusShare;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: MeasurementEvent */
public class b {
    private Bundle args;
    private Context iG;
    private String name;

    static void a(Context context, String str, Intent intent, Map<String, String> map) {
        Bundle bundle = new Bundle();
        if (intent != null) {
            Bundle c = a.c(intent);
            if (c != null) {
                bundle = a(context, str, c, intent);
            } else {
                Uri data = intent.getData();
                if (data != null) {
                    bundle.putString("intentData", data.toString());
                }
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    for (String str2 : extras.keySet()) {
                        bundle.putString(str2, j(extras.get(str2)));
                    }
                }
            }
        }
        if (map != null) {
            for (String str3 : map.keySet()) {
                bundle.putString(str3, (String) map.get(str3));
            }
        }
        new b(context, str, bundle).cR();
    }

    private b(Context context, String str, Bundle bundle) {
        this.iG = context.getApplicationContext();
        this.name = str;
        this.args = bundle;
    }

    private void cR() {
        if (this.name == null) {
            Log.d(getClass().getName(), "Event name is required");
        }
        try {
            Class cls = Class.forName("android.support.v4.content.LocalBroadcastManager");
            Method method = cls.getMethod("getInstance", new Class[]{Context.class});
            Method method2 = cls.getMethod("sendBroadcast", new Class[]{Intent.class});
            Object invoke = method.invoke(null, new Object[]{this.iG});
            Intent intent = new Intent("com.parse.bolts.measurement_event");
            intent.putExtra("event_name", this.name);
            intent.putExtra("event_args", this.args);
            method2.invoke(invoke, new Object[]{intent});
        } catch (Exception unused) {
            Log.d(getClass().getName(), "LocalBroadcastManager in android support library is required to raise bolts event.");
        }
    }

    private static Bundle a(Context context, String str, Bundle bundle, Intent intent) {
        Bundle bundle2 = new Bundle();
        ComponentName resolveActivity = intent.resolveActivity(context.getPackageManager());
        if (resolveActivity != null) {
            bundle2.putString("class", resolveActivity.getShortClassName());
        }
        if ("al_nav_out".equals(str)) {
            if (resolveActivity != null) {
                bundle2.putString("package", resolveActivity.getPackageName());
            }
            if (intent.getData() != null) {
                bundle2.putString("outputURL", intent.getData().toString());
            }
            if (intent.getScheme() != null) {
                bundle2.putString("outputURLScheme", intent.getScheme());
            }
        } else if ("al_nav_in".equals(str)) {
            if (intent.getData() != null) {
                bundle2.putString("inputURL", intent.getData().toString());
            }
            if (intent.getScheme() != null) {
                bundle2.putString("inputURLScheme", intent.getScheme());
            }
        }
        for (String str2 : bundle.keySet()) {
            Object obj = bundle.get(str2);
            if (obj instanceof Bundle) {
                Bundle bundle3 = (Bundle) obj;
                for (String str3 : bundle3.keySet()) {
                    String j = j(bundle3.get(str3));
                    if (str2.equals("referer_app_link")) {
                        if (str3.equalsIgnoreCase(PlusShare.KEY_CALL_TO_ACTION_URL)) {
                            bundle2.putString("refererURL", j);
                        } else if (str3.equalsIgnoreCase("app_name")) {
                            bundle2.putString("refererAppName", j);
                        } else if (str3.equalsIgnoreCase("package")) {
                            bundle2.putString("sourceApplication", j);
                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str2);
                    stringBuilder.append("/");
                    stringBuilder.append(str3);
                    bundle2.putString(stringBuilder.toString(), j);
                }
            } else {
                String j2 = j(obj);
                if (str2.equals("target_url")) {
                    Uri parse = Uri.parse(j2);
                    bundle2.putString("targetURL", parse.toString());
                    bundle2.putString("targetURLHost", parse.getHost());
                } else {
                    bundle2.putString(str2, j2);
                }
            }
        }
        return bundle2;
    }

    private static String j(Object obj) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof JSONArray) || (obj instanceof JSONObject)) {
            return obj.toString();
        }
        try {
            if (obj instanceof Collection) {
                return new JSONArray((Collection) obj).toString();
            }
            if (obj instanceof Map) {
                return new JSONObject((Map) obj).toString();
            }
            return obj.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
