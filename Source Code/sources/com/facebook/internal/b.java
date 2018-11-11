package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.support.annotation.Nullable;
import com.facebook.FacebookException;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: AttributionIdentifiers */
public class b {
    private static b Ca;
    private static final String TAG = b.class.getCanonicalName();
    private String BC;
    private String BK;
    private String BP;
    private boolean BU;
    private long BX;

    /* compiled from: AttributionIdentifiers */
    private static final class a implements IInterface {
        private IBinder Cb;

        a(IBinder iBinder) {
            this.Cb = iBinder;
        }

        public IBinder asBinder() {
            return this.Cb;
        }

        public String lA() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.Cb.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                return readString;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean lz() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z = true;
                obtain.writeInt(1);
                this.Cb.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                obtain2.recycle();
                obtain.recycle();
                return z;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    /* compiled from: AttributionIdentifiers */
    private static final class b implements ServiceConnection {
        private AtomicBoolean Cc;
        private final BlockingQueue<IBinder> Cd;

        public void onServiceDisconnected(ComponentName componentName) {
        }

        private b() {
            this.Cc = new AtomicBoolean(false);
            this.Cd = new LinkedBlockingDeque();
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder != null) {
                try {
                    this.Cd.put(iBinder);
                } catch (InterruptedException unused) {
                }
            }
        }

        public IBinder getBinder() {
            if (!this.Cc.compareAndSet(true, true)) {
                return (IBinder) this.Cd.take();
            }
            throw new IllegalStateException("Binder already consumed");
        }
    }

    private static b V(Context context) {
        b W = W(context);
        if (W != null) {
            return W;
        }
        W = X(context);
        return W == null ? new b() : W;
    }

    private static b W(Context context) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new FacebookException("getAndroidId cannot be called on the main thread.");
            }
            Method a = w.a("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", Context.class);
            if (a == null) {
                return null;
            }
            Object a2 = w.a(null, a, context);
            if (!(a2 instanceof Integer) || ((Integer) a2).intValue() != 0) {
                return null;
            }
            a = w.a("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", Context.class);
            if (a == null) {
                return null;
            }
            Object a3 = w.a(null, a, context);
            if (a3 == null) {
                return null;
            }
            a = w.a(a3.getClass(), "getId", new Class[0]);
            Method a4 = w.a(a3.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
            if (a == null || a4 == null) {
                return null;
            }
            b bVar = new b();
            bVar.BK = (String) w.a(a3, a, new Object[0]);
            bVar.BU = ((Boolean) w.a(a3, a4, new Object[0])).booleanValue();
            return bVar;
        } catch (Exception e) {
            w.a("android_id", e);
            return null;
        }
    }

    private static b X(Context context) {
        ServiceConnection bVar = new b();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        b bVar2 = true;
        if (context.bindService(intent, bVar, 1)) {
            try {
                a aVar = new a(bVar.getBinder());
                bVar2 = new b();
                bVar2.BK = aVar.lA();
                bVar2.BU = aVar.lz();
                return bVar2;
            } catch (Exception e) {
                bVar2 = "android_id";
                w.a((String) bVar2, e);
            } finally {
                context.unbindService(bVar);
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0067 A:{Catch:{ Exception -> 0x00d5, all -> 0x00d3 }} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0070 A:{Catch:{ Exception -> 0x00d5, all -> 0x00d3 }} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006b A:{Catch:{ Exception -> 0x00d5, all -> 0x00d3 }} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00fb  */
    public static com.facebook.internal.b Y(android.content.Context r12) {
        /*
        r0 = android.os.Looper.myLooper();
        r1 = android.os.Looper.getMainLooper();
        if (r0 != r1) goto L_0x0011;
    L_0x000a:
        r0 = TAG;
        r1 = "getAttributionIdentifiers should not be called from the main thread";
        android.util.Log.e(r0, r1);
    L_0x0011:
        r0 = Ca;
        if (r0 == 0) goto L_0x0029;
    L_0x0015:
        r0 = java.lang.System.currentTimeMillis();
        r2 = Ca;
        r2 = r2.BX;
        r4 = r0 - r2;
        r0 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r2 >= 0) goto L_0x0029;
    L_0x0026:
        r12 = Ca;
        return r12;
    L_0x0029:
        r0 = V(r12);
        r1 = 0;
        r2 = "aid";
        r3 = "androidid";
        r4 = "limit_tracking";
        r7 = new java.lang.String[]{r2, r3, r4};	 Catch:{ Exception -> 0x00d5, all -> 0x00d3 }
        r2 = r12.getPackageManager();	 Catch:{ Exception -> 0x00d5, all -> 0x00d3 }
        r3 = "com.facebook.katana.provider.AttributionIdProvider";
        r4 = 0;
        r2 = r2.resolveContentProvider(r3, r4);	 Catch:{ Exception -> 0x00d5, all -> 0x00d3 }
        if (r2 == 0) goto L_0x004d;
    L_0x0045:
        r2 = "content://com.facebook.katana.provider.AttributionIdProvider";
        r2 = android.net.Uri.parse(r2);	 Catch:{ Exception -> 0x00d5, all -> 0x00d3 }
    L_0x004b:
        r6 = r2;
        goto L_0x0061;
    L_0x004d:
        r2 = r12.getPackageManager();	 Catch:{ Exception -> 0x00d5, all -> 0x00d3 }
        r3 = "com.facebook.wakizashi.provider.AttributionIdProvider";
        r2 = r2.resolveContentProvider(r3, r4);	 Catch:{ Exception -> 0x00d5, all -> 0x00d3 }
        if (r2 == 0) goto L_0x0060;
    L_0x0059:
        r2 = "content://com.facebook.wakizashi.provider.AttributionIdProvider";
        r2 = android.net.Uri.parse(r2);	 Catch:{ Exception -> 0x00d5, all -> 0x00d3 }
        goto L_0x004b;
    L_0x0060:
        r6 = r1;
    L_0x0061:
        r2 = Z(r12);	 Catch:{ Exception -> 0x00d5, all -> 0x00d3 }
        if (r2 == 0) goto L_0x0069;
    L_0x0067:
        r0.BP = r2;	 Catch:{ Exception -> 0x00d5, all -> 0x00d3 }
    L_0x0069:
        if (r6 != 0) goto L_0x0070;
    L_0x006b:
        r12 = a(r0);	 Catch:{ Exception -> 0x00d5, all -> 0x00d3 }
        return r12;
    L_0x0070:
        r5 = r12.getContentResolver();	 Catch:{ Exception -> 0x00d5, all -> 0x00d3 }
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r12 = r5.query(r6, r7, r8, r9, r10);	 Catch:{ Exception -> 0x00d5, all -> 0x00d3 }
        if (r12 == 0) goto L_0x00c9;
    L_0x007d:
        r2 = r12.moveToFirst();	 Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
        if (r2 != 0) goto L_0x0084;
    L_0x0083:
        goto L_0x00c9;
    L_0x0084:
        r2 = "aid";
        r2 = r12.getColumnIndex(r2);	 Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
        r3 = "androidid";
        r3 = r12.getColumnIndex(r3);	 Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
        r4 = "limit_tracking";
        r4 = r12.getColumnIndex(r4);	 Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
        r2 = r12.getString(r2);	 Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
        r0.BC = r2;	 Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
        if (r3 <= 0) goto L_0x00b6;
    L_0x009e:
        if (r4 <= 0) goto L_0x00b6;
    L_0x00a0:
        r2 = r0.lx();	 Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
        if (r2 != 0) goto L_0x00b6;
    L_0x00a6:
        r2 = r12.getString(r3);	 Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
        r0.BK = r2;	 Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
        r2 = r12.getString(r4);	 Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
        r2 = java.lang.Boolean.parseBoolean(r2);	 Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
        r0.BU = r2;	 Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
    L_0x00b6:
        if (r12 == 0) goto L_0x00bb;
    L_0x00b8:
        r12.close();
    L_0x00bb:
        r12 = a(r0);
        return r12;
    L_0x00c0:
        r0 = move-exception;
        r1 = r12;
        r12 = r0;
        goto L_0x00f9;
    L_0x00c4:
        r0 = move-exception;
        r11 = r0;
        r0 = r12;
        r12 = r11;
        goto L_0x00d7;
    L_0x00c9:
        r0 = a(r0);	 Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
        if (r12 == 0) goto L_0x00d2;
    L_0x00cf:
        r12.close();
    L_0x00d2:
        return r0;
    L_0x00d3:
        r12 = move-exception;
        goto L_0x00f9;
    L_0x00d5:
        r12 = move-exception;
        r0 = r1;
    L_0x00d7:
        r2 = TAG;	 Catch:{ all -> 0x00f7 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00f7 }
        r3.<init>();	 Catch:{ all -> 0x00f7 }
        r4 = "Caught unexpected exception in getAttributionId(): ";
        r3.append(r4);	 Catch:{ all -> 0x00f7 }
        r12 = r12.toString();	 Catch:{ all -> 0x00f7 }
        r3.append(r12);	 Catch:{ all -> 0x00f7 }
        r12 = r3.toString();	 Catch:{ all -> 0x00f7 }
        com.facebook.internal.w.E(r2, r12);	 Catch:{ all -> 0x00f7 }
        if (r0 == 0) goto L_0x00f6;
    L_0x00f3:
        r0.close();
    L_0x00f6:
        return r1;
    L_0x00f7:
        r12 = move-exception;
        r1 = r0;
    L_0x00f9:
        if (r1 == 0) goto L_0x00fe;
    L_0x00fb:
        r1.close();
    L_0x00fe:
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.b.Y(android.content.Context):com.facebook.internal.b");
    }

    private static b a(b bVar) {
        bVar.BX = System.currentTimeMillis();
        Ca = bVar;
        return bVar;
    }

    public String lw() {
        return this.BC;
    }

    public String lx() {
        return this.BK;
    }

    public String ly() {
        return this.BP;
    }

    public boolean lz() {
        return this.BU;
    }

    @Nullable
    private static String Z(Context context) {
        PackageManager packageManager = context.getPackageManager();
        return packageManager != null ? packageManager.getInstallerPackageName(context.getPackageName()) : null;
    }
}
