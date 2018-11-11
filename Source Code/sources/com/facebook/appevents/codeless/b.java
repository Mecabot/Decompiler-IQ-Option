package com.facebook.appevents.codeless;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.facebook.FacebookException;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.PathComponent;
import com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType;
import com.facebook.appevents.codeless.internal.d;
import com.facebook.h;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.l;
import com.facebook.internal.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: CodelessMatcher */
public class b {
    private static final String TAG = b.class.getCanonicalName();
    private final Handler zK = new Handler(Looper.getMainLooper());
    private Set<Activity> zL = new HashSet();
    private Set<b> zM = new HashSet();
    private HashMap<String, String> zN = new HashMap();

    /* compiled from: CodelessMatcher */
    public static class a {
        private WeakReference<View> zP;
        private String zQ;

        public a(View view, String str) {
            this.zP = new WeakReference(view);
            this.zQ = str;
        }

        @Nullable
        public View getView() {
            return this.zP == null ? null : (View) this.zP.get();
        }

        public String kx() {
            return this.zQ;
        }
    }

    /* compiled from: CodelessMatcher */
    protected static class b implements OnGlobalLayoutListener, OnScrollChangedListener, Runnable {
        private final Handler handler;
        private WeakReference<View> zC;
        private HashMap<String, String> zN;
        @Nullable
        private List<EventBinding> zR;
        private final String zS;

        public b(View view, Handler handler, HashMap<String, String> hashMap, String str) {
            this.zC = new WeakReference(view);
            this.handler = handler;
            this.zN = hashMap;
            this.zS = str;
            this.handler.postDelayed(this, 200);
        }

        public void run() {
            l bF = FetchedAppSettingsManager.bF(h.it());
            if (bF != null && bF.lK()) {
                this.zR = EventBinding.c(bF.lM());
                if (this.zR != null) {
                    View view = (View) this.zC.get();
                    if (view != null) {
                        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                        if (viewTreeObserver.isAlive()) {
                            viewTreeObserver.addOnGlobalLayoutListener(this);
                            viewTreeObserver.addOnScrollChangedListener(this);
                        }
                        ky();
                    }
                }
            }
        }

        public void onGlobalLayout() {
            ky();
        }

        public void onScrollChanged() {
            ky();
        }

        private void ky() {
            if (this.zR != null && this.zC.get() != null) {
                for (int i = 0; i < this.zR.size(); i++) {
                    a((EventBinding) this.zR.get(i), (View) this.zC.get());
                }
            }
        }

        public void a(EventBinding eventBinding, View view) {
            if (eventBinding != null && view != null) {
                if (TextUtils.isEmpty(eventBinding.kF()) || eventBinding.kF().equals(this.zS)) {
                    List kC = eventBinding.kC();
                    if (kC.size() <= 25) {
                        for (a a : a(eventBinding, view, kC, 0, -1, this.zS)) {
                            a(a, view, eventBinding);
                        }
                    }
                }
            }
        }

        public static List<a> a(EventBinding eventBinding, View view, List<PathComponent> list, int i, int i2, String str) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(".");
            stringBuilder.append(String.valueOf(i2));
            str = stringBuilder.toString();
            List<a> arrayList = new ArrayList();
            if (view == null) {
                return arrayList;
            }
            List a;
            int i3;
            if (i >= list.size()) {
                arrayList.add(new a(view, str));
            } else {
                PathComponent pathComponent = (PathComponent) list.get(i);
                if (pathComponent.className.equals("..")) {
                    ViewParent parent = view.getParent();
                    if (parent instanceof ViewGroup) {
                        a = a((ViewGroup) parent);
                        i2 = a.size();
                        for (i3 = 0; i3 < i2; i3++) {
                            arrayList.addAll(a(eventBinding, (View) a.get(i3), list, i + 1, i3, str));
                        }
                    }
                    return arrayList;
                } else if (pathComponent.className.equals(".")) {
                    arrayList.add(new a(view, str));
                    return arrayList;
                } else if (!a(view, pathComponent, i2)) {
                    return arrayList;
                } else {
                    if (i == list.size() - 1) {
                        arrayList.add(new a(view, str));
                    }
                }
            }
            if (view instanceof ViewGroup) {
                a = a((ViewGroup) view);
                i2 = a.size();
                for (i3 = 0; i3 < i2; i3++) {
                    arrayList.addAll(a(eventBinding, (View) a.get(i3), list, i + 1, i3, str));
                }
            }
            return arrayList;
        }

        private static boolean a(View view, PathComponent pathComponent, int i) {
            if (pathComponent.index != -1 && i != pathComponent.index) {
                return false;
            }
            if (!view.getClass().getCanonicalName().equals(pathComponent.className)) {
                if (!pathComponent.className.matches(".*android\\..*")) {
                    return false;
                }
                String[] split = pathComponent.className.split("\\.");
                if (split.length <= 0) {
                    return false;
                }
                if (!view.getClass().getSimpleName().equals(split[split.length - 1])) {
                    return false;
                }
            }
            if ((pathComponent.Ai & MatchBitmaskType.ID.getValue()) > 0 && pathComponent.id != view.getId()) {
                return false;
            }
            if ((pathComponent.Ai & MatchBitmaskType.TEXT.getValue()) > 0 && !pathComponent.text.equals(d.l(view))) {
                return false;
            }
            if ((pathComponent.Ai & MatchBitmaskType.DESCRIPTION.getValue()) > 0) {
                Object obj;
                String str = pathComponent.description;
                if (view.getContentDescription() == null) {
                    obj = "";
                } else {
                    obj = String.valueOf(view.getContentDescription());
                }
                if (!str.equals(obj)) {
                    return false;
                }
            }
            if ((pathComponent.Ai & MatchBitmaskType.HINT.getValue()) > 0 && !pathComponent.Ah.equals(d.m(view))) {
                return false;
            }
            if ((pathComponent.Ai & MatchBitmaskType.TAG.getValue()) > 0) {
                Object obj2;
                String str2 = pathComponent.tag;
                if (view.getTag() == null) {
                    obj2 = "";
                } else {
                    obj2 = String.valueOf(view.getTag());
                }
                if (!str2.equals(obj2)) {
                    return false;
                }
            }
            return true;
        }

        private static List<View> a(ViewGroup viewGroup) {
            List<View> arrayList = new ArrayList();
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    arrayList.add(childAt);
                }
            }
            return arrayList;
        }

        private void a(a aVar, View view, EventBinding eventBinding) {
            if (eventBinding != null) {
                try {
                    View view2 = aVar.getView();
                    if (view2 != null) {
                        String kx = aVar.kx();
                        AccessibilityDelegate o = d.o(view2);
                        Object obj = null;
                        Object obj2 = o != null ? 1 : null;
                        Object obj3 = (obj2 == null || !(o instanceof com.facebook.appevents.codeless.a.a)) ? null : 1;
                        if (obj3 != null && ((com.facebook.appevents.codeless.a.a) o).ku()) {
                            obj = 1;
                        }
                        if (!this.zN.containsKey(kx) && (obj2 == null || obj3 == null || obj == null)) {
                            view2.setAccessibilityDelegate(a.a(eventBinding, view, view2));
                            this.zN.put(kx, eventBinding.gF());
                        }
                    }
                } catch (Throwable e) {
                    Log.e(b.TAG, "Failed to attach auto logging event listener.", e);
                }
            }
        }
    }

    public void add(Activity activity) {
        if (!o.md()) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                throw new FacebookException("Can't add activity to CodelessMatcher on non-UI thread");
            }
            this.zL.add(activity);
            this.zN.clear();
            startTracking();
        }
    }

    public void g(Activity activity) {
        if (!o.md()) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                throw new FacebookException("Can't remove activity from CodelessMatcher on non-UI thread");
            }
            this.zL.remove(activity);
            this.zM.clear();
            this.zN.clear();
        }
    }

    public static Bundle b(EventBinding eventBinding, View view, View view2) {
        Bundle bundle = new Bundle();
        if (eventBinding == null) {
            return bundle;
        }
        List<com.facebook.appevents.codeless.internal.a> kD = eventBinding.kD();
        if (kD != null) {
            for (com.facebook.appevents.codeless.internal.a aVar : kD) {
                if (aVar.value != null && aVar.value.length() > 0) {
                    bundle.putString(aVar.name, aVar.value);
                } else if (aVar.Ae.size() > 0) {
                    List a;
                    if (aVar.Ag.equals("relative")) {
                        a = b.a(eventBinding, view2, aVar.Ae, 0, -1, view2.getClass().getSimpleName());
                    } else {
                        a = b.a(eventBinding, view, aVar.Ae, 0, -1, view.getClass().getSimpleName());
                    }
                    for (a aVar2 : a) {
                        if (aVar2.getView() != null) {
                            String l = d.l(aVar2.getView());
                            if (l.length() > 0) {
                                bundle.putString(aVar.name, l);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return bundle;
    }

    private void startTracking() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            kw();
        } else {
            this.zK.post(new Runnable() {
                public void run() {
                    b.this.kw();
                }
            });
        }
    }

    private void kw() {
        for (Activity activity : this.zL) {
            this.zM.add(new b(activity.getWindow().getDecorView().getRootView(), this.zK, this.zN, activity.getClass().getSimpleName()));
        }
    }
}
