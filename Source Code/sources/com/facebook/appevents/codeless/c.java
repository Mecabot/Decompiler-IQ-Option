package com.facebook.appevents.codeless;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.codeless.internal.d;
import com.facebook.h;
import com.facebook.i;
import com.facebook.internal.o;
import com.facebook.internal.q;
import com.facebook.internal.w;
import com.facebook.l;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ViewIndexer */
public class c {
    private static final String TAG = c.class.getCanonicalName();
    private final Handler zK = new Handler(Looper.getMainLooper());
    private WeakReference<Activity> zT;
    private Timer zU;
    private String zV = null;

    /* compiled from: ViewIndexer */
    private static class a implements Callable<String> {
        private WeakReference<View> zC;

        public a(View view) {
            this.zC = new WeakReference(view);
        }

        /* renamed from: kA */
        public String call() {
            View view = (View) this.zC.get();
            if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
                return "";
            }
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.RGB_565);
            view.draw(new Canvas(createBitmap));
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(CompressFormat.JPEG, 10, byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        }
    }

    public c(Activity activity) {
        this.zT = new WeakReference(activity);
    }

    public void schedule() {
        final Activity activity = (Activity) this.zT.get();
        if (activity != null) {
            final String simpleName = activity.getClass().getSimpleName();
            h.it();
            final TimerTask anonymousClass1 = new TimerTask() {
                public void run() {
                    try {
                        JSONObject jSONObject;
                        View rootView = activity.getWindow().getDecorView().getRootView();
                        if (!com.facebook.appevents.internal.a.kL()) {
                            return;
                        }
                        if (o.md()) {
                            com.facebook.appevents.codeless.internal.c.kG();
                            return;
                        }
                        Object futureTask = new FutureTask(new a(rootView));
                        c.this.zK.post(futureTask);
                        String str = "";
                        try {
                            futureTask = (String) futureTask.get(1, TimeUnit.SECONDS);
                        } catch (Throwable e) {
                            Log.e(c.TAG, "Failed to take screenshot.", e);
                            futureTask = str;
                        }
                        jSONObject = new JSONObject();
                        jSONObject.put("screenname", simpleName);
                        jSONObject.put("screenshot", futureTask);
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(d.h(rootView));
                        jSONObject.put(Promotion.ACTION_VIEW, jSONArray);
                        try {
                        } catch (JSONException unused) {
                            Log.e(c.TAG, "Failed to create JSONObject");
                        }
                        c.this.u(jSONObject.toString(), simpleName);
                    } catch (Throwable e2) {
                        Log.e(c.TAG, "UI Component tree indexing failure!", e2);
                    }
                }
            };
            h.getExecutor().execute(new Runnable() {
                public void run() {
                    try {
                        if (c.this.zU != null) {
                            c.this.zU.cancel();
                        }
                        c.this.zV = null;
                        c.this.zU = new Timer();
                        c.this.zU.scheduleAtFixedRate(anonymousClass1, 0, 1000);
                    } catch (Throwable e) {
                        Log.e(c.TAG, "Error scheduling indexing job", e);
                    }
                }
            });
        }
    }

    public void kz() {
        if (!(((Activity) this.zT.get()) == null || this.zU == null)) {
            try {
                this.zU.cancel();
                this.zU = null;
            } catch (Throwable e) {
                Log.e(TAG, "Error unscheduling indexing job", e);
            }
        }
    }

    private void u(final String str, String str2) {
        h.getExecutor().execute(new Runnable() {
            public void run() {
                String it = h.it();
                String bN = w.bN(str);
                com.facebook.a ik = com.facebook.a.ik();
                if (bN == null || !bN.equals(c.this.zV)) {
                    i a = c.a(str, ik, it, "app_indexing");
                    if (a != null) {
                        l jq = a.jq();
                        try {
                            JSONObject jK = jq.jK();
                            if (jK != null) {
                                if (jK.has(b.SUCCESS) && jK.getString(b.SUCCESS) == "true") {
                                    q.a(LoggingBehavior.APP_EVENTS, c.TAG, "Successfully send UI component tree to server");
                                    c.this.zV = bN;
                                }
                                if (jK.has("is_app_indexing_enabled")) {
                                    com.facebook.appevents.internal.a.c(Boolean.valueOf(jK.getBoolean("is_app_indexing_enabled")));
                                }
                            } else {
                                bN = c.TAG;
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Error sending UI component tree to Facebook: ");
                                stringBuilder.append(jq.jJ());
                                Log.e(bN, stringBuilder.toString());
                            }
                        } catch (Throwable e) {
                            Log.e(c.TAG, "Error decoding server response.", e);
                        }
                    }
                }
            }
        });
    }

    @Nullable
    public static i a(String str, com.facebook.a aVar, String str2, String str3) {
        if (str == null) {
            return null;
        }
        i a = i.a(aVar, String.format(Locale.US, "%s/app_indexing", new Object[]{str2}), null, null);
        Bundle jn = a.jn();
        if (jn == null) {
            jn = new Bundle();
        }
        jn.putString("tree", str);
        jn.putString("app_version", com.facebook.appevents.internal.b.kY());
        jn.putString("platform", "android");
        jn.putString("request_type", str3);
        if (str3.equals("app_indexing")) {
            jn.putString("device_session_id", com.facebook.appevents.internal.a.kK());
        }
        a.setParameters(jn);
        a.a(new i.b() {
            public void a(l lVar) {
                q.a(LoggingBehavior.APP_EVENTS, c.TAG, "App index sent to FB!");
            }
        });
        return a;
    }
}
