package com.firebase.jobdispatcher;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.firebase.jobdispatcher.u.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* compiled from: DefaultJobValidator */
public class b implements v {
    private final Context context;

    public b(Context context) {
        this.context = context;
    }

    private static int v(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        bundle.writeToParcel(obtain, 0);
        int dataSize = obtain.dataSize();
        obtain.recycle();
        return dataSize;
    }

    @Nullable
    private static List<String> b(@Nullable List<String> list, @Nullable List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        list.addAll(list2);
        return list;
    }

    @Nullable
    private static List<String> a(@Nullable List<String> list, String str) {
        if (str == null) {
            return list;
        }
        if (list == null) {
            return cq(str);
        }
        Collections.addAll(list, new String[]{str});
        return list;
    }

    @Nullable
    private static List<String> a(boolean z, List<String> list, String str) {
        return z ? a(list, str) : list;
    }

    @Nullable
    @CallSuper
    public List<String> c(r rVar) {
        List b = b(b(null, a(rVar.oL())), a(rVar.oJ()));
        if (rVar.oM() && rVar.oL() == y.KT) {
            b = a(b, "ImmediateTriggers can't be used with recurring jobs");
        }
        b = b(b, x(rVar.getExtras()));
        if (rVar.getLifetime() > 1) {
            b = b(b, w(rVar.getExtras()));
        }
        return b(b(b, cp(rVar.getTag())), co(rVar.oN()));
    }

    @Nullable
    @CallSuper
    public List<String> a(u uVar) {
        return (uVar == y.KT || (uVar instanceof com.firebase.jobdispatcher.u.b) || (uVar instanceof a)) ? null : cq("Unknown trigger provided");
    }

    @Nullable
    @CallSuper
    public List<String> a(x xVar) {
        int oU = xVar.oU();
        int oV = xVar.oV();
        int oW = xVar.oW();
        boolean z = false;
        boolean z2 = (oU == 1 || oU == 2) ? false : true;
        List a = a(300 > oW, a(oW < oV, a(z2, null, "Unknown retry policy provided"), "Maximum backoff must be greater than or equal to initial backoff"), "Maximum backoff must be greater than 300s (5 minutes)");
        if (oV < 30) {
            z = true;
        }
        return a(z, a, "Initial backoff must be at least 30s");
    }

    @Nullable
    private static List<String> w(Bundle bundle) {
        List<String> list = null;
        if (bundle != null) {
            for (String c : bundle.keySet()) {
                list = a(list, c(bundle, c));
            }
        }
        return list;
    }

    @Nullable
    private static List<String> x(Bundle bundle) {
        if (bundle == null || v(bundle) <= 10240) {
            return null;
        }
        return cq(String.format(Locale.US, "Extras too large: %d bytes is > the max (%d bytes)", new Object[]{Integer.valueOf(v(bundle)), Integer.valueOf(10240)}));
    }

    @Nullable
    private static String c(Bundle bundle, String str) {
        Object obj = bundle.get(str);
        String str2 = null;
        if (obj == null || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof String) || (obj instanceof Boolean)) {
            return null;
        }
        Locale locale = Locale.US;
        String str3 = "Received value of type '%s' for key '%s', but only the following extra parameter types are supported: Integer, Long, Double, String, and Boolean";
        Object[] objArr = new Object[2];
        if (obj != null) {
            str2 = obj.getClass();
        }
        objArr[0] = str2;
        objArr[1] = str;
        return String.format(locale, str3, objArr);
    }

    @VisibleForTesting
    List<String> co(String str) {
        if (str == null || str.isEmpty()) {
            return cq("Service can't be empty");
        }
        if (this.context == null) {
            return cq("Context is null, can't query PackageManager");
        }
        PackageManager packageManager = this.context.getPackageManager();
        if (packageManager == null) {
            return cq("PackageManager is null, can't validate service");
        }
        Intent intent = new Intent("com.firebase.jobdispatcher.ACTION_EXECUTE");
        intent.setClassName(this.context, str);
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        StringBuilder stringBuilder;
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Couldn't find a registered service with the name ");
            stringBuilder.append(str);
            stringBuilder.append(". Is it declared in the manifest with the right intent-filter? If not, the job won't be started.");
            Log.e("FJD.GooglePlayReceiver", stringBuilder.toString());
            return null;
        }
        for (ResolveInfo resolveInfo : queryIntentServices) {
            if (resolveInfo.serviceInfo != null && resolveInfo.serviceInfo.enabled) {
                return null;
            }
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" is disabled.");
        return cq(stringBuilder.toString());
    }

    private static List<String> cp(String str) {
        if (str == null) {
            return cq("Tag can't be null");
        }
        return str.length() > 100 ? cq("Tag must be shorter than 100") : null;
    }

    @NonNull
    private static List<String> cq(String str) {
        List arrayList = new ArrayList();
        arrayList.add(str);
        return arrayList;
    }
}
