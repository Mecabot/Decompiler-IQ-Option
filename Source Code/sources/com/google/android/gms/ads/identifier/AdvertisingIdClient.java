package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.zzf;
import com.google.android.gms.internal.zzfp;
import com.google.android.gms.internal.zzfq;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@KeepForSdkWithMembers
public class AdvertisingIdClient {
    private final Context mContext;
    @Nullable
    private com.google.android.gms.common.zza zzams;
    @Nullable
    private zzfp zzamt;
    private boolean zzamu;
    private Object zzamv;
    @Nullable
    private zza zzamw;
    private boolean zzamx;
    private long zzamy;

    public static final class Info {
        private final String zzane;
        private final boolean zzanf;

        public Info(String str, boolean z) {
            this.zzane = str;
            this.zzanf = z;
        }

        public final String getId() {
            return this.zzane;
        }

        public final boolean isLimitAdTrackingEnabled() {
            return this.zzanf;
        }

        public final String toString() {
            String str = this.zzane;
            boolean z = this.zzanf;
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 7);
            stringBuilder.append("{");
            stringBuilder.append(str);
            stringBuilder.append("}");
            stringBuilder.append(z);
            return stringBuilder.toString();
        }
    }

    @Hide
    static class zza extends Thread {
        private WeakReference<AdvertisingIdClient> zzana;
        private long zzanb;
        CountDownLatch zzanc = new CountDownLatch(1);
        boolean zzand = false;

        public zza(AdvertisingIdClient advertisingIdClient, long j) {
            this.zzana = new WeakReference(advertisingIdClient);
            this.zzanb = j;
            start();
        }

        private final void disconnect() {
            AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.zzana.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.zzand = true;
            }
        }

        public final void run() {
            try {
                if (!this.zzanc.await(this.zzanb, TimeUnit.MILLISECONDS)) {
                    disconnect();
                }
            } catch (InterruptedException unused) {
                disconnect();
            }
        }
    }

    @Hide
    public AdvertisingIdClient(Context context) {
        this(context, 30000, false, false);
    }

    @Hide
    public AdvertisingIdClient(Context context, long j, boolean z, boolean z2) {
        this.zzamv = new Object();
        zzbq.checkNotNull(context);
        if (z) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
        }
        this.mContext = context;
        this.zzamu = false;
        this.zzamy = j;
        this.zzamx = z2;
    }

    public static Info getAdvertisingIdInfo(Context context) {
        zzb zzb = new zzb(context);
        boolean z = zzb.getBoolean("gads:ad_id_app_context:enabled", false);
        float f = zzb.getFloat("gads:ad_id_app_context:ping_ratio", 0.0f);
        String string = zzb.getString("gads:ad_id_use_shared_preference:experiment_id", "");
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1, z, zzb.getBoolean("gads:ad_id_use_persistent_service:enabled", false));
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            advertisingIdClient.start(false);
            Info info = advertisingIdClient.getInfo();
            advertisingIdClient.zza(info, z, f, SystemClock.elapsedRealtime() - elapsedRealtime, string, null);
            advertisingIdClient.finish();
            return info;
        } catch (Throwable th) {
            advertisingIdClient.finish();
        }
    }

    @Hide
    public static boolean getIsAdIdFakeForDebugLogging(Context context) {
        zzb zzb = new zzb(context);
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1, zzb.getBoolean("gads:ad_id_app_context:enabled", false), zzb.getBoolean("com.google.android.gms.ads.identifier.service.PERSISTENT_START", false));
        try {
            advertisingIdClient.start(false);
            boolean isAdIdFakeForDebugLogging = advertisingIdClient.getIsAdIdFakeForDebugLogging();
            return isAdIdFakeForDebugLogging;
        } finally {
            advertisingIdClient.finish();
        }
    }

    @Hide
    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    @Hide
    private final void start(boolean z) {
        zzbq.zzgw("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzamu) {
                finish();
            }
            this.zzams = zzc(this.mContext, this.zzamx);
            this.zzamt = zza(this.mContext, this.zzams);
            this.zzamu = true;
            if (z) {
                zzbm();
            }
        }
    }

    @Hide
    private static zzfp zza(Context context, com.google.android.gms.common.zza zza) {
        try {
            return zzfq.zzc(zza.zza(10000, TimeUnit.MILLISECONDS));
        } catch (InterruptedException unused) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            IOException iOException = new IOException(th);
        }
    }

    private final boolean zza(Info info, boolean z, float f, long j, String str, Throwable th) {
        if (Math.random() > ((double) f)) {
            return false;
        }
        Map hashMap = new HashMap();
        hashMap.put("app_context", z ? "1" : "0");
        if (info != null) {
            hashMap.put("limit_ad_tracking", info.isLimitAdTrackingEnabled() ? "1" : "0");
        }
        if (!(info == null || info.getId() == null)) {
            hashMap.put("ad_id_size", Integer.toString(info.getId().length()));
        }
        if (th != null) {
            hashMap.put("error", th.getClass().getName());
        }
        if (!(str == null || str.isEmpty())) {
            hashMap.put("experiment_id", str);
        }
        hashMap.put("tag", "AdvertisingIdClient");
        hashMap.put("time_spent", Long.toString(j));
        new zza(this, hashMap).start();
        return true;
    }

    private final void zzbm() {
        synchronized (this.zzamv) {
            if (this.zzamw != null) {
                this.zzamw.zzanc.countDown();
                this.zzamw.join();
            }
            try {
            } catch (InterruptedException unused) {
                if (this.zzamy > 0) {
                    this.zzamw = new zza(this, this.zzamy);
                }
            }
        }
    }

    private static com.google.android.gms.common.zza zzc(Context context, boolean z) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            int isGooglePlayServicesAvailable = zzf.zzahf().isGooglePlayServicesAvailable(context);
            if (isGooglePlayServicesAvailable == 0 || isGooglePlayServicesAvailable == 2) {
                String str = z ? "com.google.android.gms.ads.identifier.service.PERSISTENT_START" : "com.google.android.gms.ads.identifier.service.START";
                Object zza = new com.google.android.gms.common.zza();
                Intent intent = new Intent(str);
                intent.setPackage("com.google.android.gms");
                try {
                    if (com.google.android.gms.common.stats.zza.zzanm().zza(context, intent, zza, 1)) {
                        return zza;
                    }
                    throw new IOException("Connection failure");
                } catch (Throwable th) {
                    IOException iOException = new IOException(th);
                }
            } else {
                throw new IOException("Google Play services not available");
            }
        } catch (NameNotFoundException unused) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    @Hide
    protected void finalize() {
        finish();
        super.finalize();
    }

    /* JADX WARNING: Missing block: B:18:0x0031, code:
            return;
     */
    @com.google.android.gms.common.internal.Hide
    public void finish() {
        /*
        r3 = this;
        r0 = "Calling this from your main thread can lead to deadlock";
        com.google.android.gms.common.internal.zzbq.zzgw(r0);
        monitor-enter(r3);
        r0 = r3.mContext;	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0030;
    L_0x000a:
        r0 = r3.zzams;	 Catch:{ all -> 0x0032 }
        if (r0 != 0) goto L_0x000f;
    L_0x000e:
        goto L_0x0030;
    L_0x000f:
        r0 = r3.zzamu;	 Catch:{ Throwable -> 0x001e }
        if (r0 == 0) goto L_0x0026;
    L_0x0013:
        com.google.android.gms.common.stats.zza.zzanm();	 Catch:{ Throwable -> 0x001e }
        r0 = r3.mContext;	 Catch:{ Throwable -> 0x001e }
        r1 = r3.zzams;	 Catch:{ Throwable -> 0x001e }
        r0.unbindService(r1);	 Catch:{ Throwable -> 0x001e }
        goto L_0x0026;
    L_0x001e:
        r0 = move-exception;
        r1 = "AdvertisingIdClient";
        r2 = "AdvertisingIdClient unbindService failed.";
        android.util.Log.i(r1, r2, r0);	 Catch:{ all -> 0x0032 }
    L_0x0026:
        r0 = 0;
        r3.zzamu = r0;	 Catch:{ all -> 0x0032 }
        r0 = 0;
        r3.zzamt = r0;	 Catch:{ all -> 0x0032 }
        r3.zzams = r0;	 Catch:{ all -> 0x0032 }
        monitor-exit(r3);	 Catch:{ all -> 0x0032 }
        return;
    L_0x0030:
        monitor-exit(r3);	 Catch:{ all -> 0x0032 }
        return;
    L_0x0032:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0032 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.finish():void");
    }

    @Hide
    public Info getInfo() {
        Info info;
        zzbq.zzgw("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzamu) {
                synchronized (this.zzamv) {
                    if (this.zzamw == null || !this.zzamw.zzand) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    start(false);
                    if (!this.zzamu) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Throwable e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Throwable e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            zzbq.checkNotNull(this.zzams);
            zzbq.checkNotNull(this.zzamt);
            info = new Info(this.zzamt.getId(), this.zzamt.zzb(true));
        }
        zzbm();
        return info;
    }

    @Hide
    public boolean getIsAdIdFakeForDebugLogging() {
        boolean zzbn;
        zzbq.zzgw("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzamu) {
                synchronized (this.zzamv) {
                    if (this.zzamw == null || !this.zzamw.zzand) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    start(false);
                    if (!this.zzamu) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Throwable e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Throwable e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            zzbq.checkNotNull(this.zzams);
            zzbq.checkNotNull(this.zzamt);
            zzbn = this.zzamt.zzbn();
        }
        zzbm();
        return zzbn;
    }

    @Hide
    public void start() {
        start(true);
    }
}
