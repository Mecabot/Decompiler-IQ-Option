package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zzf;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzd<T extends IInterface> {
    @Hide
    private static String[] zzgfi = new String[]{"service_esmobile", "service_googleme"};
    private final Context mContext;
    final Handler mHandler;
    private final Object mLock;
    private final Looper zzalj;
    private final zzf zzfwk;
    private int zzgen;
    private long zzgeo;
    private long zzgep;
    private int zzgeq;
    private long zzger;
    private zzam zzges;
    private final zzag zzget;
    private final Object zzgeu;
    private zzay zzgev;
    protected zzj zzgew;
    private T zzgex;
    private final ArrayList<zzi<?>> zzgey;
    private zzl zzgez;
    private int zzgfa;
    private final zzf zzgfb;
    private final zzg zzgfc;
    private final int zzgfd;
    private final String zzgfe;
    private ConnectionResult zzgff;
    private boolean zzgfg;
    protected AtomicInteger zzgfh;

    protected zzd(Context context, Looper looper, int i, zzf zzf, zzg zzg, String str) {
        this(context, looper, zzag.zzcp(context), zzf.zzahf(), i, (zzf) zzbq.checkNotNull(zzf), (zzg) zzbq.checkNotNull(zzg), null);
    }

    protected zzd(Context context, Looper looper, zzag zzag, zzf zzf, int i, zzf zzf2, zzg zzg, String str) {
        this.mLock = new Object();
        this.zzgeu = new Object();
        this.zzgey = new ArrayList();
        this.zzgfa = 1;
        this.zzgff = null;
        this.zzgfg = false;
        this.zzgfh = new AtomicInteger(0);
        this.mContext = (Context) zzbq.checkNotNull(context, "Context must not be null");
        this.zzalj = (Looper) zzbq.checkNotNull(looper, "Looper must not be null");
        this.zzget = (zzag) zzbq.checkNotNull(zzag, "Supervisor must not be null");
        this.zzfwk = (zzf) zzbq.checkNotNull(zzf, "API availability must not be null");
        this.mHandler = new zzh(this, looper);
        this.zzgfd = i;
        this.zzgfb = zzf2;
        this.zzgfc = zzg;
        this.zzgfe = str;
    }

    private final void zza(int i, T t) {
        boolean z = true;
        if ((i == 4 ? 1 : null) != (t != null ? 1 : null)) {
            z = false;
        }
        zzbq.checkArgument(z);
        synchronized (this.mLock) {
            this.zzgfa = i;
            this.zzgex = t;
            zzb(i, t);
            switch (i) {
                case 1:
                    if (this.zzgez != null) {
                        this.zzget.zza(zzhm(), zzalq(), 129, this.zzgez, zzalr());
                        this.zzgez = null;
                        break;
                    }
                    break;
                case 2:
                case 3:
                    String zzamx;
                    if (!(this.zzgez == null || this.zzges == null)) {
                        zzamx = this.zzges.zzamx();
                        String packageName = this.zzges.getPackageName();
                        StringBuilder stringBuilder = new StringBuilder((String.valueOf(zzamx).length() + 70) + String.valueOf(packageName).length());
                        stringBuilder.append("Calling connect() while still connected, missing disconnect() for ");
                        stringBuilder.append(zzamx);
                        stringBuilder.append(" on ");
                        stringBuilder.append(packageName);
                        Log.e("GmsClient", stringBuilder.toString());
                        this.zzget.zza(this.zzges.zzamx(), this.zzges.getPackageName(), this.zzges.zzamu(), this.zzgez, zzalr());
                        this.zzgfh.incrementAndGet();
                    }
                    this.zzgez = new zzl(this, this.zzgfh.get());
                    this.zzges = new zzam(zzalq(), zzhm(), false, 129);
                    if (!this.zzget.zza(new zzah(this.zzges.zzamx(), this.zzges.getPackageName(), this.zzges.zzamu()), this.zzgez, zzalr())) {
                        zzamx = this.zzges.zzamx();
                        String packageName2 = this.zzges.getPackageName();
                        StringBuilder stringBuilder2 = new StringBuilder((String.valueOf(zzamx).length() + 34) + String.valueOf(packageName2).length());
                        stringBuilder2.append("unable to connect to service: ");
                        stringBuilder2.append(zzamx);
                        stringBuilder2.append(" on ");
                        stringBuilder2.append(packageName2);
                        Log.e("GmsClient", stringBuilder2.toString());
                        zza(16, null, this.zzgfh.get());
                        break;
                    }
                    break;
                case 4:
                    zza((IInterface) t);
                    break;
            }
        }
    }

    private final boolean zza(int i, int i2, T t) {
        synchronized (this.mLock) {
            if (this.zzgfa != i) {
                return false;
            }
            zza(i2, (IInterface) t);
            return true;
        }
    }

    @Nullable
    @Hide
    private final String zzalr() {
        return this.zzgfe == null ? this.mContext.getClass().getName() : this.zzgfe;
    }

    @Hide
    private final boolean zzalt() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzgfa == 3;
        }
        return z;
    }

    private final boolean zzalz() {
        if (this.zzgfg || TextUtils.isEmpty(zzhn()) || TextUtils.isEmpty(null)) {
            return false;
        }
        try {
            Class.forName(zzhn());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Hide
    private final void zzce(int i) {
        if (zzalt()) {
            i = 5;
            this.zzgfg = true;
        } else {
            i = 4;
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(i, this.zzgfh.get(), 16));
    }

    public void disconnect() {
        this.zzgfh.incrementAndGet();
        synchronized (this.zzgey) {
            int size = this.zzgey.size();
            for (int i = 0; i < size; i++) {
                ((zzi) this.zzgey.get(i)).removeListener();
            }
            this.zzgey.clear();
        }
        synchronized (this.zzgeu) {
            this.zzgev = null;
        }
        zza(1, null);
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        IInterface iInterface;
        zzay zzay;
        String str2;
        PrintWriter append;
        long j;
        String format;
        StringBuilder stringBuilder;
        synchronized (this.mLock) {
            i = this.zzgfa;
            iInterface = this.zzgex;
        }
        synchronized (this.zzgeu) {
            zzay = this.zzgev;
        }
        printWriter.append(str).append("mConnectState=");
        switch (i) {
            case 1:
                str2 = "DISCONNECTED";
                break;
            case 2:
                str2 = "REMOTE_CONNECTING";
                break;
            case 3:
                str2 = "LOCAL_CONNECTING";
                break;
            case 4:
                str2 = "CONNECTED";
                break;
            case 5:
                str2 = "DISCONNECTING";
                break;
            default:
                str2 = "UNKNOWN";
                break;
        }
        printWriter.print(str2);
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.append("null");
        } else {
            printWriter.append(zzhn()).append("@").append(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (zzay == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(zzay.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzgep > 0) {
            append = printWriter.append(str).append("lastConnectedTime=");
            j = this.zzgep;
            format = simpleDateFormat.format(new Date(this.zzgep));
            stringBuilder = new StringBuilder(String.valueOf(format).length() + 21);
            stringBuilder.append(j);
            stringBuilder.append(" ");
            stringBuilder.append(format);
            append.println(stringBuilder.toString());
        }
        if (this.zzgeo > 0) {
            CharSequence charSequence;
            printWriter.append(str).append("lastSuspendedCause=");
            switch (this.zzgen) {
                case 1:
                    charSequence = "CAUSE_SERVICE_DISCONNECTED";
                    break;
                case 2:
                    charSequence = "CAUSE_NETWORK_LOST";
                    break;
                default:
                    charSequence = String.valueOf(this.zzgen);
                    break;
            }
            printWriter.append(charSequence);
            append = printWriter.append(" lastSuspendedTime=");
            j = this.zzgeo;
            format = simpleDateFormat.format(new Date(this.zzgeo));
            stringBuilder = new StringBuilder(String.valueOf(format).length() + 21);
            stringBuilder.append(j);
            stringBuilder.append(" ");
            stringBuilder.append(format);
            append.println(stringBuilder.toString());
        }
        if (this.zzger > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(this.zzgeq));
            PrintWriter append2 = printWriter.append(" lastFailedTime=");
            long j2 = this.zzger;
            String format2 = simpleDateFormat.format(new Date(this.zzger));
            StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(format2).length() + 21);
            stringBuilder2.append(j2);
            stringBuilder2.append(" ");
            stringBuilder2.append(format2);
            append2.println(stringBuilder2.toString());
        }
    }

    public Account getAccount() {
        return null;
    }

    @Hide
    public final Context getContext() {
        return this.mContext;
    }

    @Hide
    public final Looper getLooper() {
        return this.zzalj;
    }

    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public final boolean isConnected() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzgfa == 4;
        }
        return z;
    }

    public final boolean isConnecting() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzgfa == 2 || this.zzgfa == 3;
        }
        return z;
    }

    @CallSuper
    protected void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzgeq = connectionResult.getErrorCode();
        this.zzger = System.currentTimeMillis();
    }

    @CallSuper
    protected void onConnectionSuspended(int i) {
        this.zzgen = i;
        this.zzgeo = System.currentTimeMillis();
    }

    @Hide
    protected final void zza(int i, @Nullable Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(7, i2, -1, new zzo(this, i, null)));
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i2, -1, new zzn(this, i, iBinder, bundle)));
    }

    @CallSuper
    protected void zza(@NonNull T t) {
        this.zzgep = System.currentTimeMillis();
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0080 A:{Splitter: B:16:0x005c, ExcHandler: android.os.RemoteException (r4_6 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:30:0x0080, code:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:31:0x0081, code:
            android.util.Log.w("GmsClient", "IGmsServiceBroker.getService failed", r4);
            zza(8, null, null, r3.zzgfh.get());
     */
    /* JADX WARNING: Missing block: B:32:0x0094, code:
            return;
     */
    @android.support.annotation.WorkerThread
    @com.google.android.gms.common.internal.Hide
    public final void zza(com.google.android.gms.common.internal.zzan r4, java.util.Set<com.google.android.gms.common.api.Scope> r5) {
        /*
        r3 = this;
        r0 = r3.zzabt();
        r1 = new com.google.android.gms.common.internal.zzz;
        r2 = r3.zzgfd;
        r1.<init>(r2);
        r2 = r3.mContext;
        r2 = r2.getPackageName();
        r1.zzggd = r2;
        r1.zzggg = r0;
        if (r5 == 0) goto L_0x0025;
    L_0x0017:
        r0 = r5.size();
        r0 = new com.google.android.gms.common.api.Scope[r0];
        r5 = r5.toArray(r0);
        r5 = (com.google.android.gms.common.api.Scope[]) r5;
        r1.zzggf = r5;
    L_0x0025:
        r5 = r3.zzacc();
        if (r5 == 0) goto L_0x004a;
    L_0x002b:
        r5 = r3.getAccount();
        if (r5 == 0) goto L_0x0036;
    L_0x0031:
        r5 = r3.getAccount();
        goto L_0x003f;
    L_0x0036:
        r5 = new android.accounts.Account;
        r0 = "<<default account>>";
        r2 = "com.google";
        r5.<init>(r0, r2);
    L_0x003f:
        r1.zzggh = r5;
        if (r4 == 0) goto L_0x0056;
    L_0x0043:
        r4 = r4.asBinder();
        r1.zzgge = r4;
        goto L_0x0056;
    L_0x004a:
        r4 = r3.zzalx();
        if (r4 == 0) goto L_0x0056;
    L_0x0050:
        r4 = r3.getAccount();
        r1.zzggh = r4;
    L_0x0056:
        r4 = r3.zzalu();
        r1.zzggi = r4;
        r4 = r3.zzgeu;	 Catch:{ DeadObjectException -> 0x0097, SecurityException -> 0x0095, RemoteException -> 0x0080, RemoteException -> 0x0080 }
        monitor-enter(r4);	 Catch:{ DeadObjectException -> 0x0097, SecurityException -> 0x0095, RemoteException -> 0x0080, RemoteException -> 0x0080 }
        r5 = r3.zzgev;	 Catch:{ all -> 0x007d }
        if (r5 == 0) goto L_0x0074;
    L_0x0063:
        r5 = r3.zzgev;	 Catch:{ all -> 0x007d }
        r0 = new com.google.android.gms.common.internal.zzk;	 Catch:{ all -> 0x007d }
        r2 = r3.zzgfh;	 Catch:{ all -> 0x007d }
        r2 = r2.get();	 Catch:{ all -> 0x007d }
        r0.<init>(r3, r2);	 Catch:{ all -> 0x007d }
        r5.zza(r0, r1);	 Catch:{ all -> 0x007d }
        goto L_0x007b;
    L_0x0074:
        r5 = "GmsClient";
        r0 = "mServiceBroker is null, client disconnected";
        android.util.Log.w(r5, r0);	 Catch:{ all -> 0x007d }
    L_0x007b:
        monitor-exit(r4);	 Catch:{ all -> 0x007d }
        return;
    L_0x007d:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x007d }
        throw r5;	 Catch:{ DeadObjectException -> 0x0097, SecurityException -> 0x0095, RemoteException -> 0x0080, RemoteException -> 0x0080 }
    L_0x0080:
        r4 = move-exception;
        r5 = "GmsClient";
        r0 = "IGmsServiceBroker.getService failed";
        android.util.Log.w(r5, r0, r4);
        r4 = 8;
        r5 = r3.zzgfh;
        r5 = r5.get();
        r0 = 0;
        r3.zza(r4, r0, r0, r5);
        return;
    L_0x0095:
        r4 = move-exception;
        throw r4;
    L_0x0097:
        r4 = move-exception;
        r5 = "GmsClient";
        r0 = "IGmsServiceBroker.getService failed";
        android.util.Log.w(r5, r0, r4);
        r4 = 1;
        r3.zzcd(r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzd.zza(com.google.android.gms.common.internal.zzan, java.util.Set):void");
    }

    public void zza(@NonNull zzj zzj) {
        this.zzgew = (zzj) zzbq.checkNotNull(zzj, "Connection progress callbacks cannot be null.");
        zza(2, null);
    }

    protected final void zza(@NonNull zzj zzj, int i, @Nullable PendingIntent pendingIntent) {
        this.zzgew = (zzj) zzbq.checkNotNull(zzj, "Connection progress callbacks cannot be null.");
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.zzgfh.get(), i, pendingIntent));
    }

    public void zza(@NonNull zzp zzp) {
        zzp.zzako();
    }

    @Hide
    protected Bundle zzabt() {
        return new Bundle();
    }

    public boolean zzacc() {
        return false;
    }

    public boolean zzacn() {
        return false;
    }

    public Bundle zzagp() {
        return null;
    }

    public boolean zzahn() {
        return true;
    }

    @Nullable
    public final IBinder zzaho() {
        synchronized (this.zzgeu) {
            if (this.zzgev == null) {
                return null;
            }
            IBinder asBinder = this.zzgev.asBinder();
            return asBinder;
        }
    }

    @Hide
    public final String zzahp() {
        if (isConnected() && this.zzges != null) {
            return this.zzges.getPackageName();
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    @Hide
    protected String zzalq() {
        return "com.google.android.gms";
    }

    public final void zzals() {
        int isGooglePlayServicesAvailable = this.zzfwk.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable != 0) {
            zza(1, null);
            zza(new zzm(this), isGooglePlayServicesAvailable, null);
            return;
        }
        zza(new zzm(this));
    }

    public zzc[] zzalu() {
        return new zzc[0];
    }

    @Hide
    protected final void zzalv() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    @Hide
    public final T zzalw() {
        T t;
        synchronized (this.mLock) {
            if (this.zzgfa == 5) {
                throw new DeadObjectException();
            }
            zzalv();
            zzbq.zza(this.zzgex != null, (Object) "Client is connected but service is null");
            t = this.zzgex;
        }
        return t;
    }

    public boolean zzalx() {
        return false;
    }

    protected Set<Scope> zzaly() {
        return Collections.EMPTY_SET;
    }

    void zzb(int i, T t) {
    }

    @Hide
    public final void zzcd(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(6, this.zzgfh.get(), i));
    }

    @Nullable
    @Hide
    protected abstract T zzd(IBinder iBinder);

    @Hide
    @NonNull
    protected abstract String zzhm();

    @Hide
    @NonNull
    protected abstract String zzhn();
}
