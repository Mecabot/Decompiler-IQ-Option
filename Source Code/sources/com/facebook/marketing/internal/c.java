package com.facebook.marketing.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.facebook.a;
import com.facebook.appevents.codeless.internal.d;
import com.facebook.h;
import com.facebook.i;
import com.facebook.internal.w;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.plus.PlusShare;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ButtonIndexingLogger */
public class c {
    private static volatile Set<String> Hl = new HashSet();
    private static volatile Set<String> Hr = new HashSet();
    private static final String TAG = c.class.getCanonicalName();

    private static JSONObject a(View view, String str, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            String[] split = str.split("\\.", -1);
            int length = split.length - 1;
            View view2 = view;
            while (view2 != null) {
                Object obj;
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("classname", view2.getClass().getCanonicalName());
                jSONObject2.put(b.INDEX, split[length]);
                jSONObject2.put("id", view2.getId());
                jSONObject2.put("text", d.l(view2));
                jSONObject2.put("tag", view2.getTag() == null ? "" : String.valueOf(view2.getTag()));
                String str2 = PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION;
                if (view2.getContentDescription() == null) {
                    obj = "";
                } else {
                    obj = String.valueOf(view2.getContentDescription());
                }
                jSONObject2.put(str2, obj);
                jSONArray.put(jSONObject2);
                view2 = d.f(view2);
                length--;
            }
            JSONArray jSONArray2 = new JSONArray();
            for (int length2 = jSONArray.length() - 1; length2 >= 0; length2--) {
                jSONArray2.put(jSONArray.get(length2));
            }
            jSONObject.put("path", jSONArray2);
            jSONObject.put("is_from_click", z);
            if (view instanceof ImageView) {
                Bitmap bitmap = ((BitmapDrawable) ((ImageView) view).getDrawable()).getBitmap();
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                jSONObject.put("image", Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
            }
            return jSONObject;
        } catch (Throwable e) {
            Log.e(TAG, "Log button indexing error", e);
            return new JSONObject();
        }
    }

    private static void d(Context context, String str, String str2) {
        com.facebook.internal.b Y = com.facebook.internal.b.Y(context);
        if (Y != null && Y.lx() != null) {
            String lx = Y.lx();
            String kY = com.facebook.appevents.internal.b.kY();
            Bundle bundle = new Bundle();
            try {
                bundle.putString("app_version", kY);
                bundle.putString("device_id", lx);
                bundle.putString("indexed_button_list", str);
                i a = i.a(null, String.format(Locale.US, "%s/button_indexing", new Object[]{str2}), null, null);
                a.setParameters(bundle);
                a.jq();
            } catch (Throwable e) {
                Log.e(TAG, "failed to send button indexing request", e);
            }
        }
    }

    public static void a(String str, View view, String str2, Context context) {
        if (!Hr.contains(str2)) {
            Hr.add(str2);
            if (a(view, str2, true).length() > 0) {
                d(context, new JSONArray(Arrays.asList(new String[]{a(view, str2, true).toString()})).toString(), str);
            }
        }
    }

    public static void e(final JSONObject jSONObject, final String str) {
        h.getExecutor().execute(new Runnable() {
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    String it = h.it();
                    a ik = a.ik();
                    jSONObject.put("screenname", str);
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject);
                    jSONObject.put(Promotion.ACTION_VIEW, jSONArray);
                    i a = com.facebook.appevents.codeless.c.a(jSONObject.toString(), ik, it, "button_sampling");
                    if (a != null) {
                        a.jq();
                    }
                } catch (Exception e) {
                    w.a(c.TAG, e);
                }
            }
        });
    }
}
