package com.facebook.marketing.internal;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.FacebookException;
import com.facebook.appevents.codeless.internal.d;
import com.facebook.h;
import com.facebook.internal.w;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ButtonIndexer */
public class a {
    private static final String TAG = a.class.getCanonicalName();
    private Set<a> Hh = new HashSet();
    private HashSet<String> Hi = new HashSet();
    private final Handler zK = new Handler(Looper.getMainLooper());
    private Set<Activity> zL = new HashSet();

    /* compiled from: ButtonIndexer */
    protected static class a implements OnGlobalLayoutListener, OnScrollChangedListener, Runnable {
        public static volatile Set<String> Hl = new HashSet();
        private static volatile float Hm = -1.0f;
        private HashSet<String> Hi;
        private HashMap<String, WeakReference<View>> Hk = new HashMap();
        private final Handler handler;
        private WeakReference<View> zC;
        private final String zS;

        public a(View view, String str, HashSet<String> hashSet, Handler handler) {
            this.zC = new WeakReference(view);
            this.handler = handler;
            this.zS = str;
            this.Hi = hashSet;
            if (Hm < 0.0f) {
                Hm = view.getContext().getResources().getDisplayMetrics().density;
            }
            this.handler.postDelayed(this, 200);
        }

        public void run() {
            e cd = f.cd(h.it());
            if (cd != null && cd.nN()) {
                process();
            }
        }

        public void onGlobalLayout() {
            process();
        }

        public void onScrollChanged() {
            process();
        }

        private void process() {
            View view = (View) this.zC.get();
            if (view != null) {
                p(view);
            }
        }

        public void p(View view) {
            JSONObject a = a(view, -1, this.zS, false);
            if (a != null) {
                c.e(a, this.zS);
            }
            for (Entry entry : this.Hk.entrySet()) {
                a((View) ((WeakReference) entry.getValue()).get(), (String) entry.getKey());
            }
        }

        @Nullable
        public JSONObject a(View view, int i, String str, boolean z) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(".");
            stringBuilder.append(String.valueOf(i));
            String stringBuilder2 = stringBuilder.toString();
            if (view == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                boolean j = d.j(view);
                if (j) {
                    this.Hk.put(stringBuilder2, new WeakReference(view));
                }
                if ((!(view instanceof TextView) && !(view instanceof ImageView)) || (!z && !j)) {
                    JSONArray jSONArray = new JSONArray();
                    if (view instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view;
                        int childCount = viewGroup.getChildCount();
                        for (int i2 = 0; i2 < childCount; i2++) {
                            View childAt = viewGroup.getChildAt(i2);
                            boolean z2 = z || j;
                            JSONObject a = a(childAt, i2, stringBuilder2, z2);
                            if (a != null) {
                                jSONArray.put(a);
                            }
                        }
                    }
                    if (jSONArray.length() > 0) {
                        JSONObject a2 = d.a(view, jSONObject);
                        a2.put("childviews", jSONArray);
                        return a2;
                    }
                    return null;
                } else if (Hl.contains(stringBuilder2)) {
                    return null;
                } else {
                    Hl.add(stringBuilder2);
                    return d.a(view, d.a(view, jSONObject), Hm);
                }
            } catch (Exception e) {
                w.a(a.TAG, e);
            }
        }

        private void a(View view, String str) {
            if (view != null) {
                try {
                    AccessibilityDelegate o = d.o(view);
                    Object obj = null;
                    Object obj2 = o != null ? 1 : null;
                    Object obj3 = (obj2 == null || !(o instanceof com.facebook.appevents.codeless.a.a)) ? null : 1;
                    if (obj3 != null && ((com.facebook.appevents.codeless.a.a) o).kv()) {
                        obj = 1;
                    }
                    if (!this.Hi.contains(str) && (obj2 == null || obj3 == null || obj == null)) {
                        view.setAccessibilityDelegate(b.b(view, str));
                        this.Hi.add(str);
                    }
                } catch (Throwable e) {
                    Log.e(a.TAG, "Failed to attach auto logging event listener.", e);
                }
            }
        }
    }

    public void add(Activity activity) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new FacebookException("Can't add activity to ButtonIndexer on non-UI thread");
        }
        this.zL.add(activity);
        this.Hi.clear();
        startTracking();
    }

    public void g(Activity activity) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new FacebookException("Can't remove activity from ButtonIndexer on non-UI thread");
        }
        this.zL.remove(activity);
        this.Hh.clear();
        this.Hi.clear();
    }

    private void startTracking() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            nK();
        } else {
            this.zK.post(new Runnable() {
                public void run() {
                    a.this.nK();
                }
            });
        }
    }

    private void nK() {
        for (Activity activity : this.zL) {
            this.Hh.add(new a(activity.getWindow().getDecorView().getRootView(), activity.getClass().getSimpleName(), this.Hi, this.zK));
        }
    }
}
