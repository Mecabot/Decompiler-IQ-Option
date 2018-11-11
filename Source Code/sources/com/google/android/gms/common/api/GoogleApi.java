package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.internal.zzah;
import com.google.android.gms.common.api.internal.zzbm;
import com.google.android.gms.common.api.internal.zzbo;
import com.google.android.gms.common.api.internal.zzbw;
import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.common.api.internal.zzck;
import com.google.android.gms.common.api.internal.zzcm;
import com.google.android.gms.common.api.internal.zzcq;
import com.google.android.gms.common.api.internal.zzcv;
import com.google.android.gms.common.api.internal.zzda;
import com.google.android.gms.common.api.internal.zzde;
import com.google.android.gms.common.api.internal.zzdo;
import com.google.android.gms.common.api.internal.zzg;
import com.google.android.gms.common.api.internal.zzh;
import com.google.android.gms.common.api.internal.zzm;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public class GoogleApi<O extends ApiOptions> {
    private final Context mContext;
    private final int mId;
    private final Looper zzalj;
    private final Api<O> zzfop;
    private final O zzfsm;
    private final zzh<O> zzfsn;
    private final GoogleApiClient zzfso;
    private final zzda zzfsp;
    @Hide
    protected final zzbm zzfsq;

    @Hide
    public static class zza {
        public static final zza zzfsr = new zzd().zzahy();
        public final zzda zzfss;
        public final Looper zzfst;

        private zza(zzda zzda, Account account, Looper looper) {
            this.zzfss = zzda;
            this.zzfst = looper;
        }

        /* synthetic */ zza(zzda zzda, Account account, Looper looper, zzc zzc) {
            this(zzda, null, looper);
        }
    }

    @Hide
    @MainThread
    public GoogleApi(@NonNull Activity activity, Api<O> api, O o, zza zza) {
        zzbq.checkNotNull(activity, "Null activity is not permitted.");
        zzbq.checkNotNull(api, "Api must not be null.");
        zzbq.checkNotNull(zza, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.mContext = activity.getApplicationContext();
        this.zzfop = api;
        this.zzfsm = o;
        this.zzalj = zza.zzfst;
        this.zzfsn = zzh.zza(this.zzfop, this.zzfsm);
        this.zzfso = new zzbw(this);
        this.zzfsq = zzbm.zzck(this.mContext);
        this.mId = this.zzfsq.zzaka();
        this.zzfsp = zza.zzfss;
        zzah.zza(activity, this.zzfsq, this.zzfsn);
        this.zzfsq.zza(this);
    }

    @Hide
    @Deprecated
    public GoogleApi(@NonNull Activity activity, Api<O> api, O o, zzda zzda) {
        this(activity, (Api) api, (ApiOptions) o, new zzd().zza(zzda).zza(activity.getMainLooper()).zzahy());
    }

    @Hide
    protected GoogleApi(@NonNull Context context, Api<O> api, Looper looper) {
        zzbq.checkNotNull(context, "Null context is not permitted.");
        zzbq.checkNotNull(api, "Api must not be null.");
        zzbq.checkNotNull(looper, "Looper must not be null.");
        this.mContext = context.getApplicationContext();
        this.zzfop = api;
        this.zzfsm = null;
        this.zzalj = looper;
        this.zzfsn = zzh.zzb(api);
        this.zzfso = new zzbw(this);
        this.zzfsq = zzbm.zzck(this.mContext);
        this.mId = this.zzfsq.zzaka();
        this.zzfsp = new zzg();
    }

    @Hide
    @Deprecated
    public GoogleApi(@NonNull Context context, Api<O> api, O o, Looper looper, zzda zzda) {
        this(context, (Api) api, null, new zzd().zza(looper).zza(zzda).zzahy());
    }

    @Hide
    public GoogleApi(@NonNull Context context, Api<O> api, O o, zza zza) {
        zzbq.checkNotNull(context, "Null context is not permitted.");
        zzbq.checkNotNull(api, "Api must not be null.");
        zzbq.checkNotNull(zza, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.mContext = context.getApplicationContext();
        this.zzfop = api;
        this.zzfsm = o;
        this.zzalj = zza.zzfst;
        this.zzfsn = zzh.zza(this.zzfop, this.zzfsm);
        this.zzfso = new zzbw(this);
        this.zzfsq = zzbm.zzck(this.mContext);
        this.mId = this.zzfsq.zzaka();
        this.zzfsp = zza.zzfss;
        this.zzfsq.zza(this);
    }

    @Hide
    @Deprecated
    public GoogleApi(@NonNull Context context, Api<O> api, O o, zzda zzda) {
        this(context, (Api) api, (ApiOptions) o, new zzd().zza(zzda).zzahy());
    }

    private final <A extends zzb, T extends zzm<? extends Result, A>> T zza(int i, @NonNull T t) {
        t.zzaiq();
        this.zzfsq.zza(this, i, (zzm) t);
        return t;
    }

    private final <TResult, A extends zzb> Task<TResult> zza(int i, @NonNull zzde<A, TResult> zzde) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zzfsq.zza(this, i, zzde, taskCompletionSource, this.zzfsp);
        return taskCompletionSource.getTask();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0034  */
    @com.google.android.gms.common.internal.Hide
    private final com.google.android.gms.common.internal.zzs zzahx() {
        /*
        r2 = this;
        r0 = new com.google.android.gms.common.internal.zzs;
        r0.<init>();
        r1 = r2.zzfsm;
        r1 = r1 instanceof com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions;
        if (r1 == 0) goto L_0x001a;
    L_0x000b:
        r1 = r2.zzfsm;
        r1 = (com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions) r1;
        r1 = r1.getGoogleSignInAccount();
        if (r1 == 0) goto L_0x001a;
    L_0x0015:
        r1 = r1.getAccount();
        goto L_0x002a;
    L_0x001a:
        r1 = r2.zzfsm;
        r1 = r1 instanceof com.google.android.gms.common.api.Api.ApiOptions.HasAccountOptions;
        if (r1 == 0) goto L_0x0029;
    L_0x0020:
        r1 = r2.zzfsm;
        r1 = (com.google.android.gms.common.api.Api.ApiOptions.HasAccountOptions) r1;
        r1 = r1.getAccount();
        goto L_0x002a;
    L_0x0029:
        r1 = 0;
    L_0x002a:
        r0 = r0.zze(r1);
        r1 = r2.zzfsm;
        r1 = r1 instanceof com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions;
        if (r1 == 0) goto L_0x0043;
    L_0x0034:
        r1 = r2.zzfsm;
        r1 = (com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions) r1;
        r1 = r1.getGoogleSignInAccount();
        if (r1 == 0) goto L_0x0043;
    L_0x003e:
        r1 = r1.zzacf();
        goto L_0x0047;
    L_0x0043:
        r1 = java.util.Collections.emptySet();
    L_0x0047:
        r0 = r0.zze(r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.GoogleApi.zzahx():com.google.android.gms.common.internal.zzs");
    }

    @Hide
    public final Context getApplicationContext() {
        return this.mContext;
    }

    @Hide
    public final int getInstanceId() {
        return this.mId;
    }

    @Hide
    public final Looper getLooper() {
        return this.zzalj;
    }

    @WorkerThread
    @Hide
    public zze zza(Looper looper, zzbo<O> zzbo) {
        return this.zzfop.zzahl().zza(this.mContext, looper, zzahx().zzgo(this.mContext.getPackageName()).zzgp(this.mContext.getClass().getName()).zzamn(), this.zzfsm, zzbo, zzbo);
    }

    @Hide
    public final <L> zzci<L> zza(@NonNull L l, String str) {
        return zzcm.zzb(l, this.zzalj, str);
    }

    @Hide
    public zzcv zza(Context context, Handler handler) {
        return new zzcv(context, handler, zzahx().zzamn());
    }

    @Hide
    public final <A extends zzb, T extends zzm<? extends Result, A>> T zza(@NonNull T t) {
        return zza(0, (zzm) t);
    }

    @Hide
    public final Task<Boolean> zza(@NonNull zzck<?> zzck) {
        zzbq.checkNotNull(zzck, "Listener key cannot be null.");
        return this.zzfsq.zza(this, (zzck) zzck);
    }

    @Hide
    public final <A extends zzb, T extends zzcq<A, ?>, U extends zzdo<A, ?>> Task<Void> zza(@NonNull T t, U u) {
        zzbq.checkNotNull(t);
        zzbq.checkNotNull(u);
        zzbq.checkNotNull(t.zzakx(), "Listener has already been released.");
        zzbq.checkNotNull(u.zzakx(), "Listener has already been released.");
        zzbq.checkArgument(t.zzakx().equals(u.zzakx()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        return this.zzfsq.zza(this, (zzcq) t, (zzdo) u);
    }

    @Hide
    public final <TResult, A extends zzb> Task<TResult> zza(zzde<A, TResult> zzde) {
        return zza(0, (zzde) zzde);
    }

    @Hide
    public final Api<O> zzaht() {
        return this.zzfop;
    }

    @Hide
    public final O zzahu() {
        return this.zzfsm;
    }

    @Hide
    public final zzh<O> zzahv() {
        return this.zzfsn;
    }

    @Hide
    public final GoogleApiClient zzahw() {
        return this.zzfso;
    }

    @Hide
    public final <A extends zzb, T extends zzm<? extends Result, A>> T zzb(@NonNull T t) {
        return zza(1, (zzm) t);
    }

    @Hide
    public final <TResult, A extends zzb> Task<TResult> zzb(zzde<A, TResult> zzde) {
        return zza(1, (zzde) zzde);
    }

    @Hide
    public final <A extends zzb, T extends zzm<? extends Result, A>> T zzc(@NonNull T t) {
        return zza(2, (zzm) t);
    }
}
