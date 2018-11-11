package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import com.facebook.FacebookSdkNotInitializedException;
import com.facebook.h;
import java.util.Collection;
import java.util.List;

/* compiled from: Validate */
public final class x {
    private static final String TAG = "com.facebook.internal.x";

    public static void a(Object obj, String str) {
        if (obj == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Argument '");
            stringBuilder.append(str);
            stringBuilder.append("' cannot be null");
            throw new NullPointerException(stringBuilder.toString());
        }
    }

    public static <T> void a(Collection<T> collection, String str) {
        if (collection.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Container '");
            stringBuilder.append(str);
            stringBuilder.append("' cannot be empty");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public static <T> void b(Collection<T> collection, String str) {
        a((Object) collection, str);
        for (T t : collection) {
            if (t == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Container '");
                stringBuilder.append(str);
                stringBuilder.append("' cannot contain null values");
                throw new NullPointerException(stringBuilder.toString());
            }
        }
    }

    public static <T> void c(Collection<T> collection, String str) {
        b((Collection) collection, str);
        a((Collection) collection, str);
    }

    public static void F(String str, String str2) {
        if (w.bc(str)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Argument '");
            stringBuilder.append(str2);
            stringBuilder.append("' cannot be null or empty");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public static void mC() {
        if (!h.isInitialized()) {
            throw new FacebookSdkNotInitializedException("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
        }
    }

    public static String mD() {
        String it = h.it();
        if (it != null) {
            return it;
        }
        throw new IllegalStateException("No App ID found, please set the App ID.");
    }

    public static String mE() {
        String jc = h.jc();
        if (jc != null) {
            return jc;
        }
        throw new IllegalStateException("No Client Token found, please set the Client Token.");
    }

    public static void b(Context context, boolean z) {
        a((Object) context, "context");
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != -1) {
            return;
        }
        if (z) {
            throw new IllegalStateException("No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.");
        }
        Log.w(TAG, "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.");
    }

    public static void c(Context context, boolean z) {
        a((Object) context, "context");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            ActivityInfo activityInfo;
            try {
                activityInfo = packageManager.getActivityInfo(new ComponentName(context, "com.facebook.FacebookActivity"), 1);
            } catch (NameNotFoundException unused) {
                activityInfo = null;
            }
            if (activityInfo != null) {
                return;
            }
            if (z) {
                throw new IllegalStateException("FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.");
            }
            Log.w(TAG, "FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.");
        }
    }

    public static boolean ak(Context context) {
        a((Object) context, "context");
        PackageManager packageManager = context.getPackageManager();
        List queryIntentActivities;
        if (packageManager != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("fb");
            stringBuilder.append(h.it());
            stringBuilder.append("://authorize");
            intent.setData(Uri.parse(stringBuilder.toString()));
            queryIntentActivities = packageManager.queryIntentActivities(intent, 64);
        } else {
            queryIntentActivities = null;
        }
        boolean z = false;
        if (queryIntentActivities != null) {
            boolean z2 = false;
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (!activityInfo.name.equals("com.facebook.CustomTabActivity") || !activityInfo.packageName.equals(context.getPackageName())) {
                    return false;
                }
                z2 = true;
            }
            z = z2;
        }
        return z;
    }
}
