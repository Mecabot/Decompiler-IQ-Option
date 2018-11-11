package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzae;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.zzf;
import com.google.android.gms.internal.zzbgs;
import com.google.android.gms.internal.zzcyj;
import com.google.android.gms.internal.zzcyk;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class zzba extends GoogleApiClient implements zzcd {
    private final Context mContext;
    private final Looper zzalj;
    private final int zzfte;
    private final GoogleApiAvailability zzftg;
    private zza<? extends zzcyj, zzcyk> zzfth;
    private boolean zzftk;
    private final Lock zzfwa;
    private zzr zzfwf;
    private Map<Api<?>, Boolean> zzfwi;
    final Queue<zzm<?, ?>> zzfwo = new LinkedList();
    private final zzae zzfyc;
    private zzcc zzfyd = null;
    private volatile boolean zzfye;
    private long zzfyf = 120000;
    private long zzfyg = 5000;
    private final zzbf zzfyh;
    private zzbx zzfyi;
    final Map<zzc<?>, zze> zzfyj;
    Set<Scope> zzfyk = new HashSet();
    private final zzcm zzfyl = new zzcm();
    private final ArrayList<zzt> zzfym;
    private Integer zzfyn = null;
    Set<zzdh> zzfyo = null;
    final zzdk zzfyp;
    private final zzaf zzfyq = new zzbb(this);

    public zzba(Context context, Lock lock, Looper looper, zzr zzr, GoogleApiAvailability googleApiAvailability, zza<? extends zzcyj, zzcyk> zza, Map<Api<?>, Boolean> map, List<ConnectionCallbacks> list, List<OnConnectionFailedListener> list2, Map<zzc<?>, zze> map2, int i, int i2, ArrayList<zzt> arrayList, boolean z) {
        Looper looper2 = looper;
        this.mContext = context;
        this.zzfwa = lock;
        this.zzftk = false;
        this.zzfyc = new zzae(looper2, this.zzfyq);
        this.zzalj = looper2;
        this.zzfyh = new zzbf(this, looper2);
        this.zzftg = googleApiAvailability;
        this.zzfte = i;
        if (this.zzfte >= 0) {
            this.zzfyn = Integer.valueOf(i2);
        }
        this.zzfwi = map;
        this.zzfyj = map2;
        this.zzfym = arrayList;
        this.zzfyp = new zzdk(this.zzfyj);
        for (ConnectionCallbacks registerConnectionCallbacks : list) {
            this.zzfyc.registerConnectionCallbacks(registerConnectionCallbacks);
        }
        for (OnConnectionFailedListener registerConnectionFailedListener : list2) {
            this.zzfyc.registerConnectionFailedListener(registerConnectionFailedListener);
        }
        this.zzfwf = zzr;
        this.zzfth = zza;
    }

    private final void resume() {
        this.zzfwa.lock();
        try {
            if (this.zzfye) {
                zzajq();
            }
            this.zzfwa.unlock();
        } catch (Throwable th) {
            this.zzfwa.unlock();
        }
    }

    public static int zza(Iterable<zze> iterable, boolean z) {
        Object obj = null;
        Object obj2 = null;
        for (zze zze : iterable) {
            if (zze.zzacc()) {
                obj = 1;
            }
            if (zze.zzacn()) {
                obj2 = 1;
            }
        }
        return obj != null ? (obj2 == null || !z) ? 1 : 2 : 3;
    }

    private final void zza(GoogleApiClient googleApiClient, zzdb zzdb, boolean z) {
        zzbgs.zzgif.zzd(googleApiClient).setResultCallback(new zzbe(this, zzdb, z, googleApiClient));
    }

    private final void zzajq() {
        this.zzfyc.zzamt();
        this.zzfyd.connect();
    }

    private final void zzajr() {
        this.zzfwa.lock();
        try {
            if (zzajs()) {
                zzajq();
            }
            this.zzfwa.unlock();
        } catch (Throwable th) {
            this.zzfwa.unlock();
        }
    }

    private final void zzbu(int i) {
        if (this.zzfyn == null) {
            this.zzfyn = Integer.valueOf(i);
        } else if (this.zzfyn.intValue() != i) {
            String zzbv = zzbv(i);
            String zzbv2 = zzbv(this.zzfyn.intValue());
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(zzbv).length() + 51) + String.valueOf(zzbv2).length());
            stringBuilder.append("Cannot use sign-in mode: ");
            stringBuilder.append(zzbv);
            stringBuilder.append(". Mode was already set to ");
            stringBuilder.append(zzbv2);
            throw new IllegalStateException(stringBuilder.toString());
        }
        if (this.zzfyd == null) {
            Object obj = null;
            Object obj2 = null;
            for (zze zze : this.zzfyj.values()) {
                if (zze.zzacc()) {
                    obj = 1;
                }
                if (zze.zzacn()) {
                    obj2 = 1;
                }
            }
            switch (this.zzfyn.intValue()) {
                case 1:
                    if (obj == null) {
                        throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                    } else if (obj2 != null) {
                        throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                    }
                    break;
                case 2:
                    if (obj != null) {
                        if (this.zzftk) {
                            this.zzfyd = new zzaa(this.mContext, this.zzfwa, this.zzalj, this.zzftg, this.zzfyj, this.zzfwf, this.zzfwi, this.zzfth, this.zzfym, this, true);
                            return;
                        }
                        this.zzfyd = zzv.zza(this.mContext, this, this.zzfwa, this.zzalj, this.zzftg, this.zzfyj, this.zzfwf, this.zzfwi, this.zzfth, this.zzfym);
                        return;
                    }
                    break;
            }
            if (this.zzftk && obj2 == null) {
                this.zzfyd = new zzaa(this.mContext, this.zzfwa, this.zzalj, this.zzftg, this.zzfyj, this.zzfwf, this.zzfwi, this.zzfth, this.zzfym, this, false);
                return;
            }
            this.zzfyd = new zzbi(this.mContext, this, this.zzfwa, this.zzalj, this.zzftg, this.zzfyj, this.zzfwf, this.zzfwi, this.zzfth, this.zzfym, this);
        }
    }

    private static String zzbv(int i) {
        switch (i) {
            case 1:
                return "SIGN_IN_MODE_REQUIRED";
            case 2:
                return "SIGN_IN_MODE_OPTIONAL";
            case 3:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    public final ConnectionResult blockingConnect() {
        boolean z = true;
        zzbq.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "blockingConnect must not be called on the UI thread");
        this.zzfwa.lock();
        try {
            if (this.zzfte >= 0) {
                if (this.zzfyn == null) {
                    z = false;
                }
                zzbq.zza(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.zzfyn == null) {
                this.zzfyn = Integer.valueOf(zza(this.zzfyj.values(), false));
            } else if (this.zzfyn.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zzbu(this.zzfyn.intValue());
            this.zzfyc.zzamt();
            ConnectionResult blockingConnect = this.zzfyd.blockingConnect();
            return blockingConnect;
        } finally {
            this.zzfwa.unlock();
        }
    }

    public final ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit) {
        zzbq.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "blockingConnect must not be called on the UI thread");
        zzbq.checkNotNull(timeUnit, "TimeUnit must not be null");
        this.zzfwa.lock();
        try {
            if (this.zzfyn == null) {
                this.zzfyn = Integer.valueOf(zza(this.zzfyj.values(), false));
            } else if (this.zzfyn.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zzbu(this.zzfyn.intValue());
            this.zzfyc.zzamt();
            ConnectionResult blockingConnect = this.zzfyd.blockingConnect(j, timeUnit);
            return blockingConnect;
        } finally {
            this.zzfwa.unlock();
        }
    }

    public final PendingResult<Status> clearDefaultAccountAndReconnect() {
        zzbq.zza(isConnected(), (Object) "GoogleApiClient is not connected yet.");
        zzbq.zza(this.zzfyn.intValue() != 2, (Object) "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        PendingResult<Status> zzdb = new zzdb((GoogleApiClient) this);
        if (this.zzfyj.containsKey(zzbgs.zzegu)) {
            zza(this, zzdb, false);
            return zzdb;
        }
        AtomicReference atomicReference = new AtomicReference();
        GoogleApiClient build = new Builder(this.mContext).addApi(zzbgs.API).addConnectionCallbacks(new zzbc(this, atomicReference, zzdb)).addOnConnectionFailedListener(new zzbd(this, zzdb)).setHandler(this.zzfyh).build();
        atomicReference.set(build);
        build.connect();
        return zzdb;
    }

    public final void connect() {
        this.zzfwa.lock();
        try {
            boolean z = false;
            if (this.zzfte >= 0) {
                if (this.zzfyn != null) {
                    z = true;
                }
                zzbq.zza(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.zzfyn == null) {
                this.zzfyn = Integer.valueOf(zza(this.zzfyj.values(), false));
            } else if (this.zzfyn.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            connect(this.zzfyn.intValue());
        } finally {
            this.zzfwa.unlock();
        }
    }

    public final void connect(int i) {
        this.zzfwa.lock();
        boolean z = true;
        if (!(i == 3 || i == 1 || i == 2)) {
            z = false;
        }
        try {
            StringBuilder stringBuilder = new StringBuilder(33);
            stringBuilder.append("Illegal sign-in mode: ");
            stringBuilder.append(i);
            zzbq.checkArgument(z, stringBuilder.toString());
            zzbu(i);
            zzajq();
        } finally {
            this.zzfwa.unlock();
        }
    }

    public final void disconnect() {
        this.zzfwa.lock();
        try {
            this.zzfyp.release();
            if (this.zzfyd != null) {
                this.zzfyd.disconnect();
            }
            this.zzfyl.release();
            for (zzm zzm : this.zzfwo) {
                zzm.zza(null);
                zzm.cancel();
            }
            this.zzfwo.clear();
            if (this.zzfyd != null) {
                zzajs();
                this.zzfyc.zzams();
            }
            this.zzfwa.unlock();
        } catch (Throwable th) {
            this.zzfwa.unlock();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.mContext);
        printWriter.append(str).append("mResuming=").print(this.zzfye);
        printWriter.append(" mWorkQueue.size()=").print(this.zzfwo.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.zzfyp.zzgbs.size());
        if (this.zzfyd != null) {
            this.zzfyd.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @NonNull
    public final ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        this.zzfwa.lock();
        try {
            if (!isConnected() && !this.zzfye) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            } else if (this.zzfyj.containsKey(api.zzahm())) {
                ConnectionResult connectionResult = this.zzfyd.getConnectionResult(api);
                if (connectionResult == null) {
                    ConnectionResult connectionResult2;
                    if (this.zzfye) {
                        connectionResult2 = ConnectionResult.zzfqt;
                    } else {
                        Log.w("GoogleApiClientImpl", zzaju());
                        Log.wtf("GoogleApiClientImpl", String.valueOf(api.getName()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map"), new Exception());
                        connectionResult2 = new ConnectionResult(8, null);
                    }
                    this.zzfwa.unlock();
                    return connectionResult2;
                }
                this.zzfwa.unlock();
                return connectionResult;
            } else {
                throw new IllegalArgumentException(String.valueOf(api.getName()).concat(" was never registered with GoogleApiClient"));
            }
        } catch (Throwable th) {
            this.zzfwa.unlock();
        }
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.zzalj;
    }

    public final boolean hasConnectedApi(@NonNull Api<?> api) {
        if (!isConnected()) {
            return false;
        }
        zze zze = (zze) this.zzfyj.get(api.zzahm());
        return zze != null && zze.isConnected();
    }

    public final boolean isConnected() {
        return this.zzfyd != null && this.zzfyd.isConnected();
    }

    public final boolean isConnecting() {
        return this.zzfyd != null && this.zzfyd.isConnecting();
    }

    public final boolean isConnectionCallbacksRegistered(@NonNull ConnectionCallbacks connectionCallbacks) {
        return this.zzfyc.isConnectionCallbacksRegistered(connectionCallbacks);
    }

    public final boolean isConnectionFailedListenerRegistered(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
        return this.zzfyc.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    public final void reconnect() {
        disconnect();
        connect();
    }

    public final void registerConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks) {
        this.zzfyc.registerConnectionCallbacks(connectionCallbacks);
    }

    public final void registerConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
        this.zzfyc.registerConnectionFailedListener(onConnectionFailedListener);
    }

    public final void stopAutoManage(@NonNull FragmentActivity fragmentActivity) {
        zzce zzce = new zzce(fragmentActivity);
        if (this.zzfte >= 0) {
            zzi.zza(zzce).zzbq(this.zzfte);
            return;
        }
        throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
    }

    public final void unregisterConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks) {
        this.zzfyc.unregisterConnectionCallbacks(connectionCallbacks);
    }

    public final void unregisterConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
        this.zzfyc.unregisterConnectionFailedListener(onConnectionFailedListener);
    }

    @NonNull
    public final <C extends zze> C zza(@NonNull zzc<C> zzc) {
        zze zze = (zze) this.zzfyj.get(zzc);
        zzbq.checkNotNull(zze, "Appropriate Api was not requested.");
        return zze;
    }

    public final void zza(zzdh zzdh) {
        this.zzfwa.lock();
        try {
            if (this.zzfyo == null) {
                this.zzfyo = new HashSet();
            }
            this.zzfyo.add(zzdh);
        } finally {
            this.zzfwa.unlock();
        }
    }

    public final boolean zza(@NonNull Api<?> api) {
        return this.zzfyj.containsKey(api.zzahm());
    }

    public final boolean zza(zzcu zzcu) {
        return this.zzfyd != null && this.zzfyd.zza(zzcu);
    }

    public final void zzaia() {
        if (this.zzfyd != null) {
            this.zzfyd.zzaia();
        }
    }

    final boolean zzajs() {
        if (!this.zzfye) {
            return false;
        }
        this.zzfye = false;
        this.zzfyh.removeMessages(2);
        this.zzfyh.removeMessages(1);
        if (this.zzfyi != null) {
            this.zzfyi.unregister();
            this.zzfyi = null;
        }
        return true;
    }

    final boolean zzajt() {
        this.zzfwa.lock();
        try {
            if (this.zzfyo == null) {
                return false;
            }
            boolean isEmpty = this.zzfyo.isEmpty() ^ 1;
            this.zzfwa.unlock();
            return isEmpty;
        } finally {
            this.zzfwa.unlock();
        }
    }

    final String zzaju() {
        Writer stringWriter = new StringWriter();
        dump("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    public final void zzb(zzdh zzdh) {
        this.zzfwa.lock();
        try {
            String str;
            String str2;
            Throwable exception;
            if (this.zzfyo == null) {
                str = "GoogleApiClientImpl";
                str2 = "Attempted to remove pending transform when no transforms are registered.";
                exception = new Exception();
            } else if (this.zzfyo.remove(zzdh)) {
                if (!zzajt()) {
                    this.zzfyd.zzais();
                }
                this.zzfwa.unlock();
            } else {
                str = "GoogleApiClientImpl";
                str2 = "Failed to remove pending transform - this may lead to memory leaks!";
                exception = new Exception();
            }
            Log.wtf(str, str2, exception);
            this.zzfwa.unlock();
        } catch (Throwable th) {
            this.zzfwa.unlock();
        }
    }

    public final void zzc(ConnectionResult connectionResult) {
        if (!zzf.zzd(this.mContext, connectionResult.getErrorCode())) {
            zzajs();
        }
        if (!this.zzfye) {
            this.zzfyc.zzk(connectionResult);
            this.zzfyc.zzams();
        }
    }

    public final <A extends zzb, R extends Result, T extends zzm<R, A>> T zzd(@NonNull T t) {
        zzbq.checkArgument(t.zzahm() != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        boolean containsKey = this.zzfyj.containsKey(t.zzahm());
        String name = t.zzaht() != null ? t.zzaht().getName() : "the API";
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(name).length() + 65);
        stringBuilder.append("GoogleApiClient is not configured to use ");
        stringBuilder.append(name);
        stringBuilder.append(" required for this call.");
        zzbq.checkArgument(containsKey, stringBuilder.toString());
        this.zzfwa.lock();
        try {
            if (this.zzfyd == null) {
                this.zzfwo.add(t);
            } else {
                t = this.zzfyd.zzd(t);
            }
            this.zzfwa.unlock();
            return t;
        } catch (Throwable th) {
            this.zzfwa.unlock();
        }
    }

    public final <A extends zzb, T extends zzm<? extends Result, A>> T zze(@NonNull T t) {
        zzbq.checkArgument(t.zzahm() != null, "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.zzfyj.containsKey(t.zzahm());
        String name = t.zzaht() != null ? t.zzaht().getName() : "the API";
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(name).length() + 65);
        stringBuilder.append("GoogleApiClient is not configured to use ");
        stringBuilder.append(name);
        stringBuilder.append(" required for this call.");
        zzbq.checkArgument(containsKey, stringBuilder.toString());
        this.zzfwa.lock();
        try {
            if (this.zzfyd == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (this.zzfye) {
                this.zzfwo.add(t);
                while (!this.zzfwo.isEmpty()) {
                    zzm zzm = (zzm) this.zzfwo.remove();
                    this.zzfyp.zzb(zzm);
                    zzm.zzu(Status.zzfts);
                }
            } else {
                t = this.zzfyd.zze(t);
            }
            this.zzfwa.unlock();
            return t;
        } catch (Throwable th) {
            this.zzfwa.unlock();
        }
    }

    public final void zzf(int i, boolean z) {
        if (!(i != 1 || z || this.zzfye)) {
            this.zzfye = true;
            if (this.zzfyi == null) {
                this.zzfyi = GoogleApiAvailability.zza(this.mContext.getApplicationContext(), new zzbg(this));
            }
            this.zzfyh.sendMessageDelayed(this.zzfyh.obtainMessage(1), this.zzfyf);
            this.zzfyh.sendMessageDelayed(this.zzfyh.obtainMessage(2), this.zzfyg);
        }
        this.zzfyp.zzald();
        this.zzfyc.zzcf(i);
        this.zzfyc.zzams();
        if (i == 2) {
            zzajq();
        }
    }

    public final void zzk(Bundle bundle) {
        while (!this.zzfwo.isEmpty()) {
            zze((zzm) this.zzfwo.remove());
        }
        this.zzfyc.zzl(bundle);
    }

    public final <L> zzci<L> zzt(@NonNull L l) {
        this.zzfwa.lock();
        try {
            zzci<L> zza = this.zzfyl.zza(l, this.zzalj, "NO_TYPE");
            return zza;
        } finally {
            this.zzfwa.unlock();
        }
    }
}
