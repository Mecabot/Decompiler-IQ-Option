package com.facebook.share.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.q;
import com.facebook.internal.s;
import com.facebook.internal.w;
import com.facebook.internal.z;
import com.facebook.share.widget.LikeView.ObjectType;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

@Deprecated
/* compiled from: LikeActionController */
public class b {
    private static com.facebook.internal.m HC = null;
    private static final ConcurrentHashMap<String, b> HD = new ConcurrentHashMap();
    private static z HE = new z(1);
    private static z HF = new z(1);
    private static String HG = null;
    private static boolean HH = false;
    private static volatile int HI = 0;
    private static com.facebook.d HJ = null;
    private static final String TAG = "b";
    private static Handler handler;
    private AppEventsLogger Gy;
    private String HL;
    private ObjectType HO;
    private boolean HP;
    private String HQ;
    private String HS;
    private String HV;
    private String HW;
    private String HX;
    private String HY;
    private boolean HZ;
    private boolean Ia;
    private boolean Ib;
    private Bundle Ic;

    /* compiled from: LikeActionController */
    /* renamed from: com.facebook.share.internal.b$4 */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] Ii = new int[ObjectType.values().length];

        static {
            try {
                Ii[ObjectType.PAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* compiled from: LikeActionController */
    /* renamed from: com.facebook.share.internal.b$5 */
    static class AnonymousClass5 implements Runnable {
        final /* synthetic */ b Ij;

        AnonymousClass5(b bVar) {
            this.Ij = bVar;
        }

        public void run() {
            this.Ij.ob();
        }
    }

    /* compiled from: LikeActionController */
    private static class b implements Runnable {
        private String HL;
        private ObjectType HO;
        private c Iv;

        b(String str, ObjectType objectType, c cVar) {
            this.HL = str;
            this.HO = objectType;
            this.Iv = cVar;
        }

        public void run() {
            b.b(this.HL, this.HO, this.Iv);
        }
    }

    @Deprecated
    /* compiled from: LikeActionController */
    public interface c {
        void a(b bVar, FacebookException facebookException);
    }

    /* compiled from: LikeActionController */
    private static class j implements Runnable {
        private static ArrayList<String> IA = new ArrayList();
        private String IB;
        private boolean IC;

        j(String str, boolean z) {
            this.IB = str;
            this.IC = z;
        }

        public void run() {
            if (this.IB != null) {
                IA.remove(this.IB);
                IA.add(0, this.IB);
            }
            if (this.IC && IA.size() >= 128) {
                while (64 < IA.size()) {
                    b.HD.remove((String) IA.remove(IA.size() - 1));
                }
            }
        }
    }

    /* compiled from: LikeActionController */
    private interface m {
        void onComplete();
    }

    /* compiled from: LikeActionController */
    private interface n {
        void i(com.facebook.k kVar);

        FacebookRequestError jJ();
    }

    /* compiled from: LikeActionController */
    private static class o implements Runnable {
        private String IF;
        private String yB;

        o(String str, String str2) {
            this.yB = str;
            this.IF = str2;
        }

        public void run() {
            b.L(this.yB, this.IF);
        }
    }

    /* compiled from: LikeActionController */
    private abstract class a implements n {
        protected String HL;
        protected ObjectType HO;
        protected FacebookRequestError error;
        private com.facebook.i yo;

        protected abstract void b(com.facebook.l lVar);

        protected a(String str, ObjectType objectType) {
            this.HL = str;
            this.HO = objectType;
        }

        public void i(com.facebook.k kVar) {
            kVar.add(this.yo);
        }

        public FacebookRequestError jJ() {
            return this.error;
        }

        protected void e(com.facebook.i iVar) {
            this.yo = iVar;
            iVar.setVersion(com.facebook.h.iZ());
            iVar.a(new com.facebook.i.b() {
                public void a(com.facebook.l lVar) {
                    a.this.error = lVar.jJ();
                    if (a.this.error != null) {
                        a.this.b(a.this.error);
                    } else {
                        a.this.b(lVar);
                    }
                }
            });
        }

        protected void b(FacebookRequestError facebookRequestError) {
            q.a(LoggingBehavior.REQUESTS, b.TAG, "Error running request for object '%s' with type '%s' : %s", this.HL, this.HO, facebookRequestError);
        }
    }

    /* compiled from: LikeActionController */
    private interface i extends n {
        boolean nX();

        String og();
    }

    /* compiled from: LikeActionController */
    private class d extends a {
        String HQ = b.this.HQ;
        String HS = b.this.HS;
        String Iw = b.this.HV;
        String Ix = b.this.HW;

        d(String str, ObjectType objectType) {
            super(str, objectType);
            Bundle bundle = new Bundle();
            bundle.putString("fields", "engagement.fields(count_string_with_like,count_string_without_like,social_sentence_with_like,social_sentence_without_like)");
            bundle.putString("locale", Locale.getDefault().toString());
            e(new com.facebook.i(com.facebook.a.ik(), str, bundle, HttpMethod.GET));
        }

        protected void b(com.facebook.l lVar) {
            JSONObject c = w.c(lVar.jK(), "engagement");
            if (c != null) {
                this.HQ = c.optString("count_string_with_like", this.HQ);
                this.HS = c.optString("count_string_without_like", this.HS);
                this.Iw = c.optString("social_sentence_with_like", this.Iw);
                this.Ix = c.optString("social_sentence_without_like", this.Ix);
            }
        }

        protected void b(FacebookRequestError facebookRequestError) {
            q.a(LoggingBehavior.REQUESTS, b.TAG, "Error fetching engagement for object '%s' with type '%s' : %s", this.HL, this.HO, facebookRequestError);
            b.this.a("get_engagement", facebookRequestError);
        }
    }

    /* compiled from: LikeActionController */
    private class e extends a {
        String HY;

        e(String str, ObjectType objectType) {
            super(str, objectType);
            Bundle bundle = new Bundle();
            bundle.putString("fields", "og_object.fields(id)");
            bundle.putString("ids", str);
            e(new com.facebook.i(com.facebook.a.ik(), "", bundle, HttpMethod.GET));
        }

        protected void b(FacebookRequestError facebookRequestError) {
            if (facebookRequestError.getErrorMessage().contains("og_object")) {
                this.error = null;
                return;
            }
            q.a(LoggingBehavior.REQUESTS, b.TAG, "Error getting the FB id for object '%s' with type '%s' : %s", this.HL, this.HO, facebookRequestError);
        }

        protected void b(com.facebook.l lVar) {
            JSONObject c = w.c(lVar.jK(), this.HL);
            if (c != null) {
                c = c.optJSONObject("og_object");
                if (c != null) {
                    this.HY = c.optString("id");
                }
            }
        }
    }

    /* compiled from: LikeActionController */
    private class f extends a implements i {
        private final String HL;
        private final ObjectType HO;
        private String HX;
        private boolean Iy = b.this.HP;

        f(String str, ObjectType objectType) {
            super(str, objectType);
            this.HL = str;
            this.HO = objectType;
            Bundle bundle = new Bundle();
            bundle.putString("fields", "id,application");
            bundle.putString("object", this.HL);
            e(new com.facebook.i(com.facebook.a.ik(), "me/og.likes", bundle, HttpMethod.GET));
        }

        protected void b(com.facebook.l lVar) {
            JSONArray d = w.d(lVar.jK(), "data");
            if (d != null) {
                for (int i = 0; i < d.length(); i++) {
                    JSONObject optJSONObject = d.optJSONObject(i);
                    if (optJSONObject != null) {
                        this.Iy = true;
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("application");
                        com.facebook.a ik = com.facebook.a.ik();
                        if (optJSONObject2 != null && com.facebook.a.il() && w.d(ik.it(), optJSONObject2.optString("id"))) {
                            this.HX = optJSONObject.optString("id");
                        }
                    }
                }
            }
        }

        protected void b(FacebookRequestError facebookRequestError) {
            q.a(LoggingBehavior.REQUESTS, b.TAG, "Error fetching like status for object '%s' with type '%s' : %s", this.HL, this.HO, facebookRequestError);
            b.this.a("get_og_object_like", facebookRequestError);
        }

        public boolean nX() {
            return this.Iy;
        }

        public String og() {
            return this.HX;
        }
    }

    /* compiled from: LikeActionController */
    private class g extends a {
        String HY;
        boolean HZ;

        g(String str, ObjectType objectType) {
            super(str, objectType);
            Bundle bundle = new Bundle();
            bundle.putString("fields", "id");
            bundle.putString("ids", str);
            e(new com.facebook.i(com.facebook.a.ik(), "", bundle, HttpMethod.GET));
        }

        protected void b(com.facebook.l lVar) {
            JSONObject c = w.c(lVar.jK(), this.HL);
            if (c != null) {
                this.HY = c.optString("id");
                this.HZ = w.bc(this.HY) ^ 1;
            }
        }

        protected void b(FacebookRequestError facebookRequestError) {
            q.a(LoggingBehavior.REQUESTS, b.TAG, "Error getting the FB id for object '%s' with type '%s' : %s", this.HL, this.HO, facebookRequestError);
        }
    }

    /* compiled from: LikeActionController */
    private class h extends a implements i {
        private boolean Iy = b.this.HP;
        private String Iz;

        public String og() {
            return null;
        }

        h(String str) {
            super(str, ObjectType.PAGE);
            this.Iz = str;
            Bundle bundle = new Bundle();
            bundle.putString("fields", "id");
            com.facebook.a ik = com.facebook.a.ik();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("me/likes/");
            stringBuilder.append(str);
            e(new com.facebook.i(ik, stringBuilder.toString(), bundle, HttpMethod.GET));
        }

        protected void b(com.facebook.l lVar) {
            JSONArray d = w.d(lVar.jK(), "data");
            if (d != null && d.length() > 0) {
                this.Iy = true;
            }
        }

        protected void b(FacebookRequestError facebookRequestError) {
            q.a(LoggingBehavior.REQUESTS, b.TAG, "Error fetching like status for page id '%s': %s", this.Iz, facebookRequestError);
            b.this.a("get_page_like", facebookRequestError);
        }

        public boolean nX() {
            return this.Iy;
        }
    }

    /* compiled from: LikeActionController */
    private class k extends a {
        String HX;

        k(String str, ObjectType objectType) {
            super(str, objectType);
            Bundle bundle = new Bundle();
            bundle.putString("object", str);
            e(new com.facebook.i(com.facebook.a.ik(), "me/og.likes", bundle, HttpMethod.POST));
        }

        protected void b(com.facebook.l lVar) {
            this.HX = w.b(lVar.jK(), "id");
        }

        protected void b(FacebookRequestError facebookRequestError) {
            if (facebookRequestError.getErrorCode() == 3501) {
                this.error = null;
                return;
            }
            q.a(LoggingBehavior.REQUESTS, b.TAG, "Error liking object '%s' with type '%s' : %s", this.HL, this.HO, facebookRequestError);
            b.this.a("publish_like", facebookRequestError);
        }
    }

    /* compiled from: LikeActionController */
    private class l extends a {
        private String HX;

        protected void b(com.facebook.l lVar) {
        }

        l(String str) {
            super(null, null);
            this.HX = str;
            e(new com.facebook.i(com.facebook.a.ik(), str, null, HttpMethod.DELETE));
        }

        protected void b(FacebookRequestError facebookRequestError) {
            q.a(LoggingBehavior.REQUESTS, b.TAG, "Error unliking object with unlike token '%s' : %s", this.HX, facebookRequestError);
            b.this.a("publish_unlike", facebookRequestError);
        }
    }

    @Deprecated
    public boolean nY() {
        return false;
    }

    @Deprecated
    public static boolean b(final int i, final int i2, final Intent intent) {
        if (w.bc(HG)) {
            HG = com.facebook.h.getApplicationContext().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).getString("PENDING_CONTROLLER_KEY", null);
        }
        if (w.bc(HG)) {
            return false;
        }
        a(HG, ObjectType.UNKNOWN, new c() {
            public void a(b bVar, FacebookException facebookException) {
                if (facebookException == null) {
                    bVar.onActivityResult(i, i2, intent);
                } else {
                    w.a(b.TAG, (Exception) facebookException);
                }
            }
        });
        return true;
    }

    @Deprecated
    public static void a(String str, ObjectType objectType, c cVar) {
        if (!HH) {
            nS();
        }
        b ce = ce(str);
        if (ce != null) {
            a(ce, objectType, cVar);
        } else {
            HF.h(new b(str, objectType, cVar));
        }
    }

    private static void a(b bVar, ObjectType objectType, c cVar) {
        FacebookException facebookException;
        ObjectType a = i.a(objectType, bVar.HO);
        if (a == null) {
            facebookException = new FacebookException("Object with id:\"%s\" is already marked as type:\"%s\". Cannot change the type to:\"%s\"", bVar.HL, bVar.HO.toString(), objectType.toString());
            bVar = null;
        } else {
            bVar.HO = a;
            facebookException = null;
        }
        a(cVar, bVar, facebookException);
    }

    private static void b(String str, ObjectType objectType, c cVar) {
        b ce = ce(str);
        if (ce != null) {
            a(ce, objectType, cVar);
            return;
        }
        ce = cf(str);
        if (ce == null) {
            ce = new b(str, objectType);
            a(ce);
        }
        a(str, ce);
        handler.post(new AnonymousClass5(ce));
        a(cVar, ce, null);
    }

    private static synchronized void nS() {
        synchronized (b.class) {
            if (HH) {
                return;
            }
            handler = new Handler(Looper.getMainLooper());
            HI = com.facebook.h.getApplicationContext().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).getInt("OBJECT_SUFFIX", 1);
            HC = new com.facebook.internal.m(TAG, new com.facebook.internal.m.c());
            nT();
            CallbackManagerImpl.a(RequestCodeOffset.Like.toRequestCode(), new com.facebook.internal.CallbackManagerImpl.a() {
                public boolean b(int i, Intent intent) {
                    return b.b(RequestCodeOffset.Like.toRequestCode(), i, intent);
                }
            });
            HH = true;
        }
    }

    private static void a(final c cVar, final b bVar, final FacebookException facebookException) {
        if (cVar != null) {
            handler.post(new Runnable() {
                public void run() {
                    cVar.a(bVar, facebookException);
                }
            });
        }
    }

    private static void nT() {
        HJ = new com.facebook.d() {
            protected void b(com.facebook.a aVar, com.facebook.a aVar2) {
                Context applicationContext = com.facebook.h.getApplicationContext();
                if (aVar2 == null) {
                    b.HI = (b.HI + 1) % 1000;
                    applicationContext.getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).edit().putInt("OBJECT_SUFFIX", b.HI).apply();
                    b.HD.clear();
                    b.HC.clearCache();
                }
                b.a(null, "com.facebook.sdk.LikeActionController.DID_RESET");
            }
        };
    }

    private static void a(String str, b bVar) {
        str = ch(str);
        HE.h(new j(str, true));
        HD.put(str, bVar);
    }

    private static b ce(String str) {
        str = ch(str);
        b bVar = (b) HD.get(str);
        if (bVar != null) {
            HE.h(new j(str, false));
        }
        return bVar;
    }

    private static void a(b bVar) {
        String b = b(bVar);
        String ch = ch(bVar.HL);
        if (!w.bc(b) && !w.bc(ch)) {
            HF.h(new o(ch, b));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002c  */
    private static void L(java.lang.String r2, java.lang.String r3) {
        /*
        r0 = 0;
        r1 = HC;	 Catch:{ IOException -> 0x001c }
        r2 = r1.bI(r2);	 Catch:{ IOException -> 0x001c }
        r3 = r3.getBytes();	 Catch:{ IOException -> 0x0017, all -> 0x0014 }
        r2.write(r3);	 Catch:{ IOException -> 0x0017, all -> 0x0014 }
        if (r2 == 0) goto L_0x0029;
    L_0x0010:
        com.facebook.internal.w.closeQuietly(r2);
        goto L_0x0029;
    L_0x0014:
        r3 = move-exception;
        r0 = r2;
        goto L_0x002a;
    L_0x0017:
        r3 = move-exception;
        r0 = r2;
        goto L_0x001d;
    L_0x001a:
        r3 = move-exception;
        goto L_0x002a;
    L_0x001c:
        r3 = move-exception;
    L_0x001d:
        r2 = TAG;	 Catch:{ all -> 0x001a }
        r1 = "Unable to serialize controller to disk";
        android.util.Log.e(r2, r1, r3);	 Catch:{ all -> 0x001a }
        if (r0 == 0) goto L_0x0029;
    L_0x0026:
        com.facebook.internal.w.closeQuietly(r0);
    L_0x0029:
        return;
    L_0x002a:
        if (r0 == 0) goto L_0x002f;
    L_0x002c:
        com.facebook.internal.w.closeQuietly(r0);
    L_0x002f:
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.b.L(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x003a  */
    /* JADX WARNING: Missing block: B:10:0x001f, code:
            if (r5 != null) goto L_0x0021;
     */
    /* JADX WARNING: Missing block: B:11:0x0021, code:
            com.facebook.internal.w.closeQuietly(r5);
     */
    /* JADX WARNING: Missing block: B:18:0x0033, code:
            if (r5 != null) goto L_0x0021;
     */
    /* JADX WARNING: Missing block: B:19:0x0036, code:
            return r0;
     */
    private static com.facebook.share.internal.b cf(java.lang.String r5) {
        /*
        r0 = 0;
        r5 = ch(r5);	 Catch:{ IOException -> 0x002a, all -> 0x0025 }
        r1 = HC;	 Catch:{ IOException -> 0x002a, all -> 0x0025 }
        r5 = r1.bH(r5);	 Catch:{ IOException -> 0x002a, all -> 0x0025 }
        if (r5 == 0) goto L_0x001f;
    L_0x000d:
        r1 = com.facebook.internal.w.c(r5);	 Catch:{ IOException -> 0x001d }
        r2 = com.facebook.internal.w.bc(r1);	 Catch:{ IOException -> 0x001d }
        if (r2 != 0) goto L_0x001f;
    L_0x0017:
        r1 = cg(r1);	 Catch:{ IOException -> 0x001d }
        r0 = r1;
        goto L_0x001f;
    L_0x001d:
        r1 = move-exception;
        goto L_0x002c;
    L_0x001f:
        if (r5 == 0) goto L_0x0036;
    L_0x0021:
        com.facebook.internal.w.closeQuietly(r5);
        goto L_0x0036;
    L_0x0025:
        r5 = move-exception;
        r4 = r0;
        r0 = r5;
        r5 = r4;
        goto L_0x0038;
    L_0x002a:
        r1 = move-exception;
        r5 = r0;
    L_0x002c:
        r2 = TAG;	 Catch:{ all -> 0x0037 }
        r3 = "Unable to deserialize controller from disk";
        android.util.Log.e(r2, r3, r1);	 Catch:{ all -> 0x0037 }
        if (r5 == 0) goto L_0x0036;
    L_0x0035:
        goto L_0x0021;
    L_0x0036:
        return r0;
    L_0x0037:
        r0 = move-exception;
    L_0x0038:
        if (r5 == 0) goto L_0x003d;
    L_0x003a:
        com.facebook.internal.w.closeQuietly(r5);
    L_0x003d:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.b.cf(java.lang.String):com.facebook.share.internal.b");
    }

    private static b cg(String str) {
        b bVar = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("com.facebook.share.internal.LikeActionController.version", -1) != 3) {
                return null;
            }
            b bVar2 = new b(jSONObject.getString("object_id"), ObjectType.fromInt(jSONObject.optInt("object_type", ObjectType.UNKNOWN.getValue())));
            bVar2.HQ = jSONObject.optString("like_count_string_with_like", null);
            bVar2.HS = jSONObject.optString("like_count_string_without_like", null);
            bVar2.HV = jSONObject.optString("social_sentence_with_like", null);
            bVar2.HW = jSONObject.optString("social_sentence_without_like", null);
            bVar2.HP = jSONObject.optBoolean("is_object_liked");
            bVar2.HX = jSONObject.optString("unlike_token", null);
            JSONObject optJSONObject = jSONObject.optJSONObject("facebook_dialog_analytics_bundle");
            if (optJSONObject != null) {
                bVar2.Ic = com.facebook.internal.d.g(optJSONObject);
            }
            bVar = bVar2;
            return bVar;
        } catch (Throwable e) {
            Log.e(TAG, "Unable to deserialize controller from JSON", e);
        }
    }

    private static String b(b bVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("com.facebook.share.internal.LikeActionController.version", 3);
            jSONObject.put("object_id", bVar.HL);
            jSONObject.put("object_type", bVar.HO.getValue());
            jSONObject.put("like_count_string_with_like", bVar.HQ);
            jSONObject.put("like_count_string_without_like", bVar.HS);
            jSONObject.put("social_sentence_with_like", bVar.HV);
            jSONObject.put("social_sentence_without_like", bVar.HW);
            jSONObject.put("is_object_liked", bVar.HP);
            jSONObject.put("unlike_token", bVar.HX);
            if (bVar.Ic != null) {
                JSONObject g = com.facebook.internal.d.g(bVar.Ic);
                if (g != null) {
                    jSONObject.put("facebook_dialog_analytics_bundle", g);
                }
            }
            return jSONObject.toString();
        } catch (Throwable e) {
            Log.e(TAG, "Unable to serialize controller to JSON", e);
            return null;
        }
    }

    private static String ch(String str) {
        String token = com.facebook.a.il() ? com.facebook.a.ik().getToken() : null;
        if (token != null) {
            token = w.bN(token);
        }
        return String.format(Locale.ROOT, "%s|%s|com.fb.sdk.like|%d", new Object[]{str, w.C(token, ""), Integer.valueOf(HI)});
    }

    private static void a(b bVar, String str) {
        a(bVar, str, null);
    }

    private static void a(b bVar, String str, Bundle bundle) {
        Intent intent = new Intent(str);
        if (bVar != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("com.facebook.sdk.LikeActionController.OBJECT_ID", bVar.nU());
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        LocalBroadcastManager.getInstance(com.facebook.h.getApplicationContext()).sendBroadcast(intent);
    }

    private b(String str, ObjectType objectType) {
        this.HL = str;
        this.HO = objectType;
    }

    @Deprecated
    public String nU() {
        return this.HL;
    }

    @Deprecated
    public String nV() {
        return this.HP ? this.HQ : this.HS;
    }

    @Deprecated
    public String nW() {
        return this.HP ? this.HV : this.HW;
    }

    @Deprecated
    public boolean nX() {
        return this.HP;
    }

    @Deprecated
    public void a(Activity activity, com.facebook.internal.n nVar, Bundle bundle) {
        boolean z = true;
        boolean z2 = this.HP ^ true;
        if (oa()) {
            T(z2);
            if (this.Ib) {
                nZ().a("fb_like_control_did_undo_quickly", null, bundle);
                return;
            } else if (!a(z2, bundle)) {
                if (z2) {
                    z = false;
                }
                T(z);
                b(activity, nVar, bundle);
                return;
            } else {
                return;
            }
        }
        b(activity, nVar, bundle);
    }

    private AppEventsLogger nZ() {
        if (this.Gy == null) {
            this.Gy = AppEventsLogger.T(com.facebook.h.getApplicationContext());
        }
        return this.Gy;
    }

    private boolean a(boolean z, Bundle bundle) {
        if (oa()) {
            if (z) {
                s(bundle);
                return true;
            } else if (!w.bc(this.HX)) {
                t(bundle);
                return true;
            }
        }
        return false;
    }

    private void S(boolean z) {
        T(z);
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.platform.status.ERROR_DESCRIPTION", "Unable to publish the like/unlike action");
        a(this, "com.facebook.sdk.LikeActionController.DID_ERROR", bundle);
    }

    private void T(boolean z) {
        a(z, this.HQ, this.HS, this.HV, this.HW, this.HX);
    }

    private void a(boolean z, String str, String str2, String str3, String str4, String str5) {
        Object C = w.C(str, null);
        Object C2 = w.C(str2, null);
        Object C3 = w.C(str3, null);
        Object C4 = w.C(str4, null);
        Object C5 = w.C(str5, null);
        Object obj = (z == this.HP && w.d(C, this.HQ) && w.d(C2, this.HS) && w.d(C3, this.HV) && w.d(C4, this.HW) && w.d(C5, this.HX)) ? null : 1;
        if (obj != null) {
            this.HP = z;
            this.HQ = C;
            this.HS = C2;
            this.HV = C3;
            this.HW = C4;
            this.HX = C5;
            a(this);
            a(this, "com.facebook.sdk.LikeActionController.UPDATED");
        }
    }

    private void b(Activity activity, com.facebook.internal.n nVar, Bundle bundle) {
        String str;
        if (e.oj()) {
            str = "fb_like_control_did_present_dialog";
        } else if (e.ok()) {
            str = "fb_like_control_did_present_fallback_dialog";
        } else {
            c("present_dialog", bundle);
            w.E(TAG, "Cannot show the Like Dialog on this device.");
            a(null, "com.facebook.sdk.LikeActionController.UPDATED");
            str = null;
        }
        if (str != null) {
            if (this.HO != null) {
                str = this.HO.toString();
            } else {
                str = ObjectType.UNKNOWN.toString();
            }
            d oi = new com.facebook.share.internal.d.a().cj(this.HL).ck(str).oi();
            if (nVar != null) {
                new e(nVar).a(oi);
            } else {
                new e(activity).a(oi);
            }
            r(bundle);
            nZ().a("fb_like_control_did_present_dialog", null, bundle);
        }
    }

    private void onActivityResult(int i, int i2, Intent intent) {
        i.a(i, i2, intent, q(this.Ic));
        clearState();
    }

    private h q(final Bundle bundle) {
        return new h(null) {
            public void a(com.facebook.internal.a aVar, Bundle bundle) {
                if (bundle != null && bundle.containsKey("object_is_liked")) {
                    String string;
                    String str;
                    String string2;
                    String str2;
                    String string3;
                    boolean z = bundle.getBoolean("object_is_liked");
                    String d = b.this.HQ;
                    String e = b.this.HS;
                    if (bundle.containsKey("like_count_string")) {
                        string = bundle.getString("like_count_string");
                        str = string;
                    } else {
                        string = d;
                        str = e;
                    }
                    d = b.this.HV;
                    e = b.this.HW;
                    if (bundle.containsKey("social_sentence")) {
                        string2 = bundle.getString("social_sentence");
                        str2 = string2;
                    } else {
                        string2 = d;
                        str2 = e;
                    }
                    if (bundle.containsKey("object_is_liked")) {
                        string3 = bundle.getString("unlike_token");
                    } else {
                        string3 = b.this.HX;
                    }
                    String str3 = string3;
                    bundle = bundle == null ? new Bundle() : bundle;
                    bundle.putString("call_id", aVar.lv().toString());
                    b.this.nZ().a("fb_like_control_dialog_did_succeed", null, bundle);
                    b.this.a(z, string, str, string2, str2, str3);
                }
            }

            public void a(com.facebook.internal.a aVar, FacebookException facebookException) {
                q.a(LoggingBehavior.REQUESTS, b.TAG, "Like Dialog failed with error : %s", facebookException);
                Bundle bundle = bundle == null ? new Bundle() : bundle;
                bundle.putString("call_id", aVar.lv().toString());
                b.this.c("present_dialog", bundle);
                b.a(b.this, "com.facebook.sdk.LikeActionController.DID_ERROR", s.d(facebookException));
            }

            public void b(com.facebook.internal.a aVar) {
                a(aVar, new FacebookOperationCanceledException());
            }
        };
    }

    private void r(Bundle bundle) {
        ci(this.HL);
        this.Ic = bundle;
        a(this);
    }

    private void clearState() {
        this.Ic = null;
        ci(null);
    }

    private static void ci(String str) {
        HG = str;
        com.facebook.h.getApplicationContext().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).edit().putString("PENDING_CONTROLLER_KEY", HG).apply();
    }

    private boolean oa() {
        com.facebook.a ik = com.facebook.a.ik();
        return (this.HZ || this.HY == null || !com.facebook.a.il() || ik.ip() == null || !ik.ip().contains("publish_actions")) ? false : true;
    }

    private void s(final Bundle bundle) {
        this.Ib = true;
        a(new m() {
            public void onComplete() {
                if (w.bc(b.this.HY)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("com.facebook.platform.status.ERROR_DESCRIPTION", "Invalid Object Id");
                    b.a(b.this, "com.facebook.sdk.LikeActionController.DID_ERROR", bundle);
                    return;
                }
                com.facebook.k kVar = new com.facebook.k();
                final k kVar2 = new k(b.this.HY, b.this.HO);
                kVar2.i(kVar);
                kVar.a(new com.facebook.k.a() {
                    public void a(com.facebook.k kVar) {
                        b.this.Ib = false;
                        if (kVar2.jJ() != null) {
                            b.this.S(false);
                            return;
                        }
                        b.this.HX = w.C(kVar2.HX, null);
                        b.this.Ia = true;
                        b.this.nZ().a("fb_like_control_did_like", null, bundle);
                        b.this.u(bundle);
                    }
                });
                kVar.jr();
            }
        });
    }

    private void t(final Bundle bundle) {
        this.Ib = true;
        com.facebook.k kVar = new com.facebook.k();
        final l lVar = new l(this.HX);
        lVar.i(kVar);
        kVar.a(new com.facebook.k.a() {
            public void a(com.facebook.k kVar) {
                b.this.Ib = false;
                if (lVar.jJ() != null) {
                    b.this.S(true);
                    return;
                }
                b.this.HX = null;
                b.this.Ia = false;
                b.this.nZ().a("fb_like_control_did_unlike", null, bundle);
                b.this.u(bundle);
            }
        });
        kVar.jr();
    }

    private void ob() {
        if (com.facebook.a.il()) {
            a(new m() {
                public void onComplete() {
                    i fVar;
                    if (AnonymousClass4.Ii[b.this.HO.ordinal()] != 1) {
                        fVar = new f(b.this.HY, b.this.HO);
                    } else {
                        fVar = new h(b.this.HY);
                    }
                    final d dVar = new d(b.this.HY, b.this.HO);
                    com.facebook.k kVar = new com.facebook.k();
                    fVar.i(kVar);
                    dVar.i(kVar);
                    kVar.a(new com.facebook.k.a() {
                        public void a(com.facebook.k kVar) {
                            if (fVar.jJ() == null && dVar.jJ() == null) {
                                b.this.a(fVar.nX(), dVar.HQ, dVar.HS, dVar.Iw, dVar.Ix, fVar.og());
                                return;
                            }
                            q.a(LoggingBehavior.REQUESTS, b.TAG, "Unable to refresh like state for id: '%s'", b.this.HL);
                        }
                    });
                    kVar.jr();
                }
            });
        } else {
            oc();
        }
    }

    private void oc() {
        f fVar = new f(com.facebook.h.getApplicationContext(), com.facebook.h.it(), this.HL);
        if (fVar.start()) {
            fVar.a(new com.facebook.internal.t.a() {
                public void l(Bundle bundle) {
                    if (bundle != null && bundle.containsKey("com.facebook.platform.extra.OBJECT_IS_LIKED")) {
                        String string;
                        String string2;
                        boolean z = bundle.getBoolean("com.facebook.platform.extra.OBJECT_IS_LIKED");
                        if (bundle.containsKey("com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE")) {
                            string = bundle.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE");
                        } else {
                            string = b.this.HQ;
                        }
                        String str = string;
                        if (bundle.containsKey("com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE")) {
                            string = bundle.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE");
                        } else {
                            string = b.this.HS;
                        }
                        String str2 = string;
                        if (bundle.containsKey("com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE")) {
                            string = bundle.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE");
                        } else {
                            string = b.this.HV;
                        }
                        String str3 = string;
                        if (bundle.containsKey("com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE")) {
                            string = bundle.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE");
                        } else {
                            string = b.this.HW;
                        }
                        String str4 = string;
                        if (bundle.containsKey("com.facebook.platform.extra.UNLIKE_TOKEN")) {
                            string2 = bundle.getString("com.facebook.platform.extra.UNLIKE_TOKEN");
                        } else {
                            string2 = b.this.HX;
                        }
                        b.this.a(z, str, str2, str3, str4, string2);
                    }
                }
            });
        }
    }

    private void u(Bundle bundle) {
        if (this.HP != this.Ia && !a(this.HP, bundle)) {
            S(this.HP ^ 1);
        }
    }

    private void a(final m mVar) {
        if (w.bc(this.HY)) {
            final e eVar = new e(this.HL, this.HO);
            final g gVar = new g(this.HL, this.HO);
            com.facebook.k kVar = new com.facebook.k();
            eVar.i(kVar);
            gVar.i(kVar);
            kVar.a(new com.facebook.k.a() {
                public void a(com.facebook.k kVar) {
                    b.this.HY = eVar.HY;
                    if (w.bc(b.this.HY)) {
                        b.this.HY = gVar.HY;
                        b.this.HZ = gVar.HZ;
                    }
                    if (w.bc(b.this.HY)) {
                        FacebookRequestError jJ;
                        q.a(LoggingBehavior.DEVELOPER_ERRORS, b.TAG, "Unable to verify the FB id for '%s'. Verify that it is a valid FB object or page", b.this.HL);
                        b bVar = b.this;
                        String str = "get_verified_id";
                        if (gVar.jJ() != null) {
                            jJ = gVar.jJ();
                        } else {
                            jJ = eVar.jJ();
                        }
                        bVar.a(str, jJ);
                    }
                    if (mVar != null) {
                        mVar.onComplete();
                    }
                }
            });
            kVar.jr();
            return;
        }
        if (mVar != null) {
            mVar.onComplete();
        }
    }

    private void c(String str, Bundle bundle) {
        Bundle bundle2 = new Bundle(bundle);
        bundle2.putString("object_id", this.HL);
        bundle2.putString("object_type", this.HO.toString());
        bundle2.putString("current_action", str);
        nZ().a("fb_like_control_error", null, bundle2);
    }

    private void a(String str, FacebookRequestError facebookRequestError) {
        Bundle bundle = new Bundle();
        if (facebookRequestError != null) {
            JSONObject iU = facebookRequestError.iU();
            if (iU != null) {
                bundle.putString("error", iU.toString());
            }
        }
        c(str, bundle);
    }
}
