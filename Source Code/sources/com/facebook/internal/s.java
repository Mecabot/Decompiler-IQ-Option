package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.h;
import com.facebook.login.DefaultAudience;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: NativeProtocol */
public final class s {
    private static final List<e> Ee = mg();
    private static final List<e> Ef = mh();
    private static final Map<String, List<e>> Eg = mi();
    private static final AtomicBoolean Eh = new AtomicBoolean(false);
    private static final List<Integer> Ei = Arrays.asList(new Integer[]{Integer.valueOf(20170417), Integer.valueOf(20160327), Integer.valueOf(20141218), Integer.valueOf(20141107), Integer.valueOf(20141028), Integer.valueOf(20141001), Integer.valueOf(20140701), Integer.valueOf(20140324), Integer.valueOf(20140204), Integer.valueOf(20131107), Integer.valueOf(20130618), Integer.valueOf(20130502), Integer.valueOf(20121101)});
    private static final String TAG = "com.facebook.internal.s";

    /* compiled from: NativeProtocol */
    private static abstract class e {
        private TreeSet<Integer> Ej;

        protected abstract String getPackage();

        protected abstract String mn();

        private e() {
        }

        /* synthetic */ e(AnonymousClass1 anonymousClass1) {
            this();
        }

        public TreeSet<Integer> mo() {
            if (this.Ej == null) {
                L(false);
            }
            return this.Ej;
        }

        /* JADX WARNING: Missing block: B:4:0x0005, code:
            if (r0.Ej == null) goto L_0x000a;
     */
        private synchronized void L(boolean r1) {
            /*
            r0 = this;
            monitor-enter(r0);
            if (r1 != 0) goto L_0x000a;
        L_0x0003:
            r1 = r0.Ej;	 Catch:{ all -> 0x0008 }
            if (r1 != 0) goto L_0x0010;
        L_0x0007:
            goto L_0x000a;
        L_0x0008:
            r1 = move-exception;
            goto L_0x0012;
        L_0x000a:
            r1 = com.facebook.internal.s.a(r0);	 Catch:{ all -> 0x0008 }
            r0.Ej = r1;	 Catch:{ all -> 0x0008 }
        L_0x0010:
            monitor-exit(r0);
            return;
        L_0x0012:
            monitor-exit(r0);
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.s.e.L(boolean):void");
        }
    }

    /* compiled from: NativeProtocol */
    public static class f {
        private e Ek;
        private int El;

        public static f a(e eVar, int i) {
            f fVar = new f();
            fVar.Ek = eVar;
            fVar.El = i;
            return fVar;
        }

        public static f mp() {
            f fVar = new f();
            fVar.El = -1;
            return fVar;
        }

        private f() {
        }

        public int getProtocolVersion() {
            return this.El;
        }
    }

    /* compiled from: NativeProtocol */
    private static class a extends e {
        protected String getPackage() {
            return "com.facebook.arstudio.player";
        }

        protected String mn() {
            return null;
        }

        private a() {
            super();
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* compiled from: NativeProtocol */
    private static class b extends e {
        protected String getPackage() {
            return "com.facebook.lite";
        }

        protected String mn() {
            return "com.facebook.lite.platform.LoginGDPDialogActivity";
        }

        private b() {
            super();
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* compiled from: NativeProtocol */
    private static class c extends e {
        protected String getPackage() {
            return "com.facebook.katana";
        }

        protected String mn() {
            return "com.facebook.katana.ProxyAuth";
        }

        private c() {
            super();
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* compiled from: NativeProtocol */
    private static class d extends e {
        protected String getPackage() {
            return "com.facebook.orca";
        }

        protected String mn() {
            return null;
        }

        private d() {
            super();
        }

        /* synthetic */ d(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* compiled from: NativeProtocol */
    private static class g extends e {
        protected String getPackage() {
            return "com.facebook.wakizashi";
        }

        protected String mn() {
            return "com.facebook.katana.ProxyAuth";
        }

        private g() {
            super();
        }

        /* synthetic */ g(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private static List<e> mg() {
        List<e> arrayList = new ArrayList();
        arrayList.add(new c());
        arrayList.add(new g());
        return arrayList;
    }

    private static List<e> mh() {
        List<e> arrayList = new ArrayList(mg());
        arrayList.add(0, new a());
        return arrayList;
    }

    private static Map<String, List<e>> mi() {
        Map<String, List<e>> hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d());
        hashMap.put("com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG", Ee);
        hashMap.put("com.facebook.platform.action.request.FEED_DIALOG", Ee);
        hashMap.put("com.facebook.platform.action.request.LIKE_DIALOG", Ee);
        hashMap.put("com.facebook.platform.action.request.APPINVITES_DIALOG", Ee);
        hashMap.put("com.facebook.platform.action.request.MESSAGE_DIALOG", arrayList);
        hashMap.put("com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG", arrayList);
        hashMap.put("com.facebook.platform.action.request.CAMERA_EFFECT", Ef);
        hashMap.put("com.facebook.platform.action.request.SHARE_STORY", Ee);
        return hashMap;
    }

    static Intent a(Context context, Intent intent, e eVar) {
        if (intent == null) {
            return null;
        }
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        if (resolveActivity != null && i.q(context, resolveActivity.activityInfo.packageName)) {
            return intent;
        }
        return null;
    }

    static Intent b(Context context, Intent intent, e eVar) {
        if (intent == null) {
            return null;
        }
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveService != null && i.q(context, resolveService.serviceInfo.packageName)) {
            return intent;
        }
        return null;
    }

    public static Intent a(Context context, String str, Collection<String> collection, String str2, boolean z, boolean z2, DefaultAudience defaultAudience, String str3, String str4) {
        e bVar = new b();
        return a(context, a(bVar, str, (Collection) collection, str2, z, z2, defaultAudience, str3, str4), bVar);
    }

    private static Intent a(e eVar, String str, Collection<String> collection, String str2, boolean z, boolean z2, DefaultAudience defaultAudience, String str3, String str4) {
        String mn = eVar.mn();
        if (mn == null) {
            return null;
        }
        Intent putExtra = new Intent().setClassName(eVar.getPackage(), mn).putExtra("client_id", str);
        putExtra.putExtra("facebook_sdk_version", h.ja());
        if (!w.c((Collection) collection)) {
            putExtra.putExtra("scope", TextUtils.join(",", collection));
        }
        if (!w.bc(str2)) {
            putExtra.putExtra("e2e", str2);
        }
        putExtra.putExtra("state", str3);
        putExtra.putExtra("response_type", "token,signed_request");
        putExtra.putExtra("return_scopes", "true");
        if (z2) {
            putExtra.putExtra("default_audience", defaultAudience.getNativeProtocolAudience());
        }
        putExtra.putExtra("legacy_override", h.iZ());
        putExtra.putExtra("auth_type", str4);
        return putExtra;
    }

    public static Intent b(Context context, String str, Collection<String> collection, String str2, boolean z, boolean z2, DefaultAudience defaultAudience, String str3, String str4) {
        for (e eVar : Ee) {
            Intent a = a(context, a(eVar, str, (Collection) collection, str2, z, z2, defaultAudience, str3, str4), eVar);
            if (a != null) {
                return a;
            }
        }
        return null;
    }

    public static final int mj() {
        return ((Integer) Ei.get(0)).intValue();
    }

    public static boolean O(int i) {
        return Ei.contains(Integer.valueOf(i)) && i >= 20140701;
    }

    public static Intent a(Intent intent, Bundle bundle, FacebookException facebookException) {
        UUID e = e(intent);
        if (e == null) {
            return null;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", d(intent));
        Bundle bundle2 = new Bundle();
        bundle2.putString("action_id", e.toString());
        if (facebookException != null) {
            bundle2.putBundle("error", d(facebookException));
        }
        intent2.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", bundle2);
        if (bundle != null) {
            intent2.putExtra("com.facebook.platform.protocol.RESULT_ARGS", bundle);
        }
        return intent2;
    }

    public static Intent ab(Context context) {
        for (e eVar : Ee) {
            Intent b = b(context, new Intent("com.facebook.platform.PLATFORM_SERVICE").setPackage(eVar.getPackage()).addCategory("android.intent.category.DEFAULT"), eVar);
            if (b != null) {
                return b;
            }
        }
        return null;
    }

    public static int d(Intent intent) {
        return intent.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0);
    }

    public static UUID e(Intent intent) {
        if (intent == null) {
            return null;
        }
        String string;
        if (O(d(intent))) {
            Bundle bundleExtra = intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
            string = bundleExtra != null ? bundleExtra.getString("action_id") : null;
        } else {
            string = intent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
        }
        if (string != null) {
            UUID fromString;
            try {
                fromString = UUID.fromString(string);
            } catch (IllegalArgumentException unused) {
                fromString = null;
            }
            return fromString;
        }
    }

    public static Bundle f(Intent intent) {
        if (O(d(intent))) {
            return intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
        }
        return null;
    }

    public static Bundle g(Intent intent) {
        if (O(d(intent))) {
            return intent.getBundleExtra("com.facebook.platform.protocol.METHOD_ARGS");
        }
        return intent.getExtras();
    }

    public static Bundle h(Intent intent) {
        int d = d(intent);
        Bundle extras = intent.getExtras();
        return (!O(d) || extras == null) ? extras : extras.getBundle("com.facebook.platform.protocol.RESULT_ARGS");
    }

    public static boolean i(Intent intent) {
        Bundle f = f(intent);
        if (f != null) {
            return f.containsKey("error");
        }
        return intent.hasExtra("com.facebook.platform.status.ERROR_TYPE");
    }

    public static Bundle j(Intent intent) {
        if (!i(intent)) {
            return null;
        }
        Bundle f = f(intent);
        if (f != null) {
            return f.getBundle("error");
        }
        return intent.getExtras();
    }

    public static FacebookException i(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString("error_type");
        if (string == null) {
            string = bundle.getString("com.facebook.platform.status.ERROR_TYPE");
        }
        String string2 = bundle.getString("error_description");
        if (string2 == null) {
            string2 = bundle.getString("com.facebook.platform.status.ERROR_DESCRIPTION");
        }
        if (string == null || !string.equalsIgnoreCase("UserCanceled")) {
            return new FacebookException(string2);
        }
        return new FacebookOperationCanceledException(string2);
    }

    public static Bundle d(FacebookException facebookException) {
        if (facebookException == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("error_description", facebookException.toString());
        if (facebookException instanceof FacebookOperationCanceledException) {
            bundle.putString("error_type", "UserCanceled");
        }
        return bundle;
    }

    public static int P(int i) {
        return a(Ee, new int[]{i}).getProtocolVersion();
    }

    private static f a(List<e> list, int[] iArr) {
        mk();
        if (list == null) {
            return f.mp();
        }
        for (e eVar : list) {
            int a = a(eVar.mo(), mj(), iArr);
            if (a != -1) {
                return f.a(eVar, a);
            }
        }
        return f.mp();
    }

    public static void mk() {
        if (Eh.compareAndSet(false, true)) {
            h.getExecutor().execute(new Runnable() {
                public void run() {
                    try {
                        for (e a : s.Ee) {
                            a.L(true);
                        }
                    } finally {
                        s.Eh.set(false);
                    }
                }
            });
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:? A:{Catch:{ RuntimeException -> 0x003b, all -> 0x0076 }, Splitter: B:15:0x004f, ExcHandler: java.lang.NullPointerException (unused java.lang.NullPointerException)} */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A:{Catch:{ RuntimeException -> 0x003b, all -> 0x0076 }, Splitter: B:15:0x004f, ExcHandler: java.lang.NullPointerException (unused java.lang.NullPointerException)} */
    /* JADX WARNING: Missing block: B:16:?, code:
            android.util.Log.e(TAG, "Failed to query content resolver.");
     */
    private static java.util.TreeSet<java.lang.Integer> a(com.facebook.internal.s.e r8) {
        /*
        r0 = new java.util.TreeSet;
        r0.<init>();
        r1 = com.facebook.h.getApplicationContext();
        r2 = r1.getContentResolver();
        r1 = "version";
        r4 = new java.lang.String[]{r1};
        r3 = b(r8);
        r1 = 0;
        r5 = com.facebook.h.getApplicationContext();	 Catch:{ all -> 0x0076 }
        r5 = r5.getPackageManager();	 Catch:{ all -> 0x0076 }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0076 }
        r6.<init>();	 Catch:{ all -> 0x0076 }
        r8 = r8.getPackage();	 Catch:{ all -> 0x0076 }
        r6.append(r8);	 Catch:{ all -> 0x0076 }
        r8 = ".provider.PlatformProvider";
        r6.append(r8);	 Catch:{ all -> 0x0076 }
        r8 = r6.toString();	 Catch:{ all -> 0x0076 }
        r6 = 0;
        r8 = r5.resolveContentProvider(r8, r6);	 Catch:{ RuntimeException -> 0x003b }
        goto L_0x0044;
    L_0x003b:
        r8 = move-exception;
        r5 = TAG;	 Catch:{ all -> 0x0076 }
        r6 = "Failed to query content resolver.";
        android.util.Log.e(r5, r6, r8);	 Catch:{ all -> 0x0076 }
        r8 = r1;
    L_0x0044:
        if (r8 == 0) goto L_0x0070;
    L_0x0046:
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = r2.query(r3, r4, r5, r6, r7);	 Catch:{ NullPointerException -> 0x004f, NullPointerException -> 0x004f, NullPointerException -> 0x004f }
        r1 = r8;
        goto L_0x0056;
    L_0x004f:
        r8 = TAG;	 Catch:{ all -> 0x0076 }
        r2 = "Failed to query content resolver.";
        android.util.Log.e(r8, r2);	 Catch:{ all -> 0x0076 }
    L_0x0056:
        if (r1 == 0) goto L_0x0070;
    L_0x0058:
        r8 = r1.moveToNext();	 Catch:{ all -> 0x0076 }
        if (r8 == 0) goto L_0x0070;
    L_0x005e:
        r8 = "version";
        r8 = r1.getColumnIndex(r8);	 Catch:{ all -> 0x0076 }
        r8 = r1.getInt(r8);	 Catch:{ all -> 0x0076 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x0076 }
        r0.add(r8);	 Catch:{ all -> 0x0076 }
        goto L_0x0058;
    L_0x0070:
        if (r1 == 0) goto L_0x0075;
    L_0x0072:
        r1.close();
    L_0x0075:
        return r0;
    L_0x0076:
        r8 = move-exception;
        if (r1 == 0) goto L_0x007c;
    L_0x0079:
        r1.close();
    L_0x007c:
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.s.a(com.facebook.internal.s$e):java.util.TreeSet<java.lang.Integer>");
    }

    public static int a(TreeSet<Integer> treeSet, int i, int[] iArr) {
        int length = iArr.length - 1;
        Iterator descendingIterator = treeSet.descendingIterator();
        int i2 = -1;
        int i3 = length;
        length = -1;
        while (descendingIterator.hasNext()) {
            int intValue = ((Integer) descendingIterator.next()).intValue();
            length = Math.max(length, intValue);
            while (i3 >= 0 && iArr[i3] > intValue) {
                i3--;
            }
            if (i3 < 0) {
                return -1;
            }
            if (iArr[i3] == intValue) {
                if (i3 % 2 == 0) {
                    i2 = Math.min(length, i);
                }
                return i2;
            }
        }
        return -1;
    }

    private static Uri b(e eVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("content://");
        stringBuilder.append(eVar.getPackage());
        stringBuilder.append(".provider.PlatformProvider/versions");
        return Uri.parse(stringBuilder.toString());
    }
}
