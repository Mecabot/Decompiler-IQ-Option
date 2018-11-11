package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzan;
import com.google.android.gms.common.internal.zzbt;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.zzf;
import com.google.android.gms.internal.zzcyj;
import com.google.android.gms.internal.zzcyk;
import com.google.android.gms.internal.zzcyw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public final class zzao implements zzbh {
    private final Context mContext;
    private final zza<? extends zzcyj, zzcyk> zzfth;
    private final Lock zzfwa;
    private final zzr zzfwf;
    private final Map<Api<?>, Boolean> zzfwi;
    private final zzf zzfwk;
    private ConnectionResult zzfwt;
    private final zzbi zzfxd;
    private int zzfxg;
    private int zzfxh = 0;
    private int zzfxi;
    private final Bundle zzfxj = new Bundle();
    private final Set<zzc> zzfxk = new HashSet();
    private zzcyj zzfxl;
    private boolean zzfxm;
    private boolean zzfxn;
    private boolean zzfxo;
    private zzan zzfxp;
    private boolean zzfxq;
    private boolean zzfxr;
    private ArrayList<Future<?>> zzfxs = new ArrayList();

    public zzao(zzbi zzbi, zzr zzr, Map<Api<?>, Boolean> map, zzf zzf, zza<? extends zzcyj, zzcyk> zza, Lock lock, Context context) {
        this.zzfxd = zzbi;
        this.zzfwf = zzr;
        this.zzfwi = map;
        this.zzfwk = zzf;
        this.zzfth = zza;
        this.zzfwa = lock;
        this.mContext = context;
    }

    private final void zza(zzcyw zzcyw) {
        if (zzbs(0)) {
            ConnectionResult zzain = zzcyw.zzain();
            if (zzain.isSuccess()) {
                zzbt zzbfa = zzcyw.zzbfa();
                zzain = zzbfa.zzain();
                if (zzain.isSuccess()) {
                    this.zzfxo = true;
                    this.zzfxp = zzbfa.zzamy();
                    this.zzfxq = zzbfa.zzamz();
                    this.zzfxr = zzbfa.zzana();
                    zzajl();
                    return;
                }
                String valueOf = String.valueOf(zzain);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 48);
                stringBuilder.append("Sign-in succeeded with resolve account failure: ");
                stringBuilder.append(valueOf);
                Log.wtf("GoogleApiClientConnecting", stringBuilder.toString(), new Exception());
                zze(zzain);
            } else if (zzd(zzain)) {
                zzajn();
                zzajl();
            } else {
                zze(zzain);
            }
        }
    }

    private final boolean zzajk() {
        this.zzfxi--;
        if (this.zzfxi > 0) {
            return false;
        }
        ConnectionResult connectionResult;
        if (this.zzfxi < 0) {
            Log.w("GoogleApiClientConnecting", this.zzfxd.zzfvq.zzaju());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            connectionResult = new ConnectionResult(8, null);
        } else if (this.zzfwt == null) {
            return true;
        } else {
            this.zzfxd.zzfzb = this.zzfxg;
            connectionResult = this.zzfwt;
        }
        zze(connectionResult);
        return false;
    }

    private final void zzajl() {
        if (this.zzfxi == 0) {
            if (!this.zzfxn || this.zzfxo) {
                ArrayList arrayList = new ArrayList();
                this.zzfxh = 1;
                this.zzfxi = this.zzfxd.zzfyj.size();
                for (zzc zzc : this.zzfxd.zzfyj.keySet()) {
                    if (!this.zzfxd.zzfyy.containsKey(zzc)) {
                        arrayList.add((zze) this.zzfxd.zzfyj.get(zzc));
                    } else if (zzajk()) {
                        zzajm();
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.zzfxs.add(zzbl.zzajx().submit(new zzau(this, arrayList)));
                }
            }
        }
    }

    private final void zzajm() {
        this.zzfxd.zzajw();
        zzbl.zzajx().execute(new zzap(this));
        if (this.zzfxl != null) {
            if (this.zzfxq) {
                this.zzfxl.zza(this.zzfxp, this.zzfxr);
            }
            zzbk(false);
        }
        for (zzc zzc : this.zzfxd.zzfyy.keySet()) {
            ((zze) this.zzfxd.zzfyj.get(zzc)).disconnect();
        }
        this.zzfxd.zzfzc.zzk(this.zzfxj.isEmpty() ? null : this.zzfxj);
    }

    private final void zzajn() {
        this.zzfxn = false;
        this.zzfxd.zzfvq.zzfyk = Collections.emptySet();
        for (zzc zzc : this.zzfxk) {
            if (!this.zzfxd.zzfyy.containsKey(zzc)) {
                this.zzfxd.zzfyy.put(zzc, new ConnectionResult(17, null));
            }
        }
    }

    private final void zzajo() {
        ArrayList arrayList = this.zzfxs;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((Future) obj).cancel(true);
        }
        this.zzfxs.clear();
    }

    private final Set<Scope> zzajp() {
        if (this.zzfwf == null) {
            return Collections.emptySet();
        }
        Set<Scope> hashSet = new HashSet(this.zzfwf.zzamf());
        Map zzamh = this.zzfwf.zzamh();
        for (Api api : zzamh.keySet()) {
            if (!this.zzfxd.zzfyy.containsKey(api.zzahm())) {
                hashSet.addAll(((zzt) zzamh.get(api)).zzenh);
            }
        }
        return hashSet;
    }

    /* JADX WARNING: Missing block: B:8:0x0022, code:
            if (r7 != null) goto L_0x0024;
     */
    private final void zzb(com.google.android.gms.common.ConnectionResult r5, com.google.android.gms.common.api.Api<?> r6, boolean r7) {
        /*
        r4 = this;
        r0 = r6.zzahk();
        r0 = r0.getPriority();
        r1 = 0;
        r2 = 1;
        if (r7 == 0) goto L_0x0024;
    L_0x000c:
        r7 = r5.hasResolution();
        if (r7 == 0) goto L_0x0014;
    L_0x0012:
        r7 = 1;
        goto L_0x0022;
    L_0x0014:
        r7 = r4.zzfwk;
        r3 = r5.getErrorCode();
        r7 = r7.zzbo(r3);
        if (r7 == 0) goto L_0x0021;
    L_0x0020:
        goto L_0x0012;
    L_0x0021:
        r7 = 0;
    L_0x0022:
        if (r7 == 0) goto L_0x002d;
    L_0x0024:
        r7 = r4.zzfwt;
        if (r7 == 0) goto L_0x002c;
    L_0x0028:
        r7 = r4.zzfxg;
        if (r0 >= r7) goto L_0x002d;
    L_0x002c:
        r1 = 1;
    L_0x002d:
        if (r1 == 0) goto L_0x0033;
    L_0x002f:
        r4.zzfwt = r5;
        r4.zzfxg = r0;
    L_0x0033:
        r7 = r4.zzfxd;
        r7 = r7.zzfyy;
        r6 = r6.zzahm();
        r7.put(r6, r5);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzao.zzb(com.google.android.gms.common.ConnectionResult, com.google.android.gms.common.api.Api, boolean):void");
    }

    private final void zzbk(boolean z) {
        if (this.zzfxl != null) {
            if (this.zzfxl.isConnected() && z) {
                this.zzfxl.zzbet();
            }
            this.zzfxl.disconnect();
            this.zzfxp = null;
        }
    }

    private final boolean zzbs(int i) {
        if (this.zzfxh == i) {
            return true;
        }
        Log.w("GoogleApiClientConnecting", this.zzfxd.zzfvq.zzaju());
        String valueOf = String.valueOf(this);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 23);
        stringBuilder.append("Unexpected callback in ");
        stringBuilder.append(valueOf);
        Log.w("GoogleApiClientConnecting", stringBuilder.toString());
        int i2 = this.zzfxi;
        stringBuilder = new StringBuilder(33);
        stringBuilder.append("mRemainingConnections=");
        stringBuilder.append(i2);
        Log.w("GoogleApiClientConnecting", stringBuilder.toString());
        valueOf = zzbt(this.zzfxh);
        String zzbt = zzbt(i);
        stringBuilder = new StringBuilder((String.valueOf(valueOf).length() + 70) + String.valueOf(zzbt).length());
        stringBuilder.append("GoogleApiClient connecting is in step ");
        stringBuilder.append(valueOf);
        stringBuilder.append(" but received callback for step ");
        stringBuilder.append(zzbt);
        Log.wtf("GoogleApiClientConnecting", stringBuilder.toString(), new Exception());
        zze(new ConnectionResult(8, null));
        return false;
    }

    private static String zzbt(int i) {
        switch (i) {
            case 0:
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            case 1:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    private final boolean zzd(ConnectionResult connectionResult) {
        return this.zzfxm && !connectionResult.hasResolution();
    }

    private final void zze(ConnectionResult connectionResult) {
        zzajo();
        zzbk(connectionResult.hasResolution() ^ 1);
        this.zzfxd.zzg(connectionResult);
        this.zzfxd.zzfzc.zzc(connectionResult);
    }

    public final void begin() {
        this.zzfxd.zzfyy.clear();
        this.zzfxn = false;
        this.zzfwt = null;
        this.zzfxh = 0;
        this.zzfxm = true;
        this.zzfxo = false;
        this.zzfxq = false;
        Map hashMap = new HashMap();
        int i = 0;
        for (Api api : this.zzfwi.keySet()) {
            zze zze = (zze) this.zzfxd.zzfyj.get(api.zzahm());
            i |= api.zzahk().getPriority() == 1 ? 1 : 0;
            boolean booleanValue = ((Boolean) this.zzfwi.get(api)).booleanValue();
            if (zze.zzacc()) {
                this.zzfxn = true;
                if (booleanValue) {
                    this.zzfxk.add(api.zzahm());
                } else {
                    this.zzfxm = false;
                }
            }
            hashMap.put(zze, new zzaq(this, api, booleanValue));
        }
        if (i != 0) {
            this.zzfxn = false;
        }
        if (this.zzfxn) {
            this.zzfwf.zzc(Integer.valueOf(System.identityHashCode(this.zzfxd.zzfvq)));
            OnConnectionFailedListener zzax = new zzax(this, null);
            this.zzfxl = (zzcyj) this.zzfth.zza(this.mContext, this.zzfxd.zzfvq.getLooper(), this.zzfwf, this.zzfwf.zzaml(), zzax, zzax);
        }
        this.zzfxi = this.zzfxd.zzfyj.size();
        this.zzfxs.add(zzbl.zzajx().submit(new zzar(this, hashMap)));
    }

    public final void connect() {
    }

    public final boolean disconnect() {
        zzajo();
        zzbk(true);
        this.zzfxd.zzg(null);
        return true;
    }

    public final void onConnected(Bundle bundle) {
        if (zzbs(1)) {
            if (bundle != null) {
                this.zzfxj.putAll(bundle);
            }
            if (zzajk()) {
                zzajm();
            }
        }
    }

    public final void onConnectionSuspended(int i) {
        zze(new ConnectionResult(8, null));
    }

    public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
        if (zzbs(1)) {
            zzb(connectionResult, api, z);
            if (zzajk()) {
                zzajm();
            }
        }
    }

    public final <A extends zzb, R extends Result, T extends zzm<R, A>> T zzd(T t) {
        this.zzfxd.zzfvq.zzfwo.add(t);
        return t;
    }

    public final <A extends zzb, T extends zzm<? extends Result, A>> T zze(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
