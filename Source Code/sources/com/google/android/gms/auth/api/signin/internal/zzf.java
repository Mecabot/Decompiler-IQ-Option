package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzbm;
import com.google.android.gms.internal.zzbhf;

public final class zzf {
    private static zzbhf zzenl = new zzbhf("GoogleSignInCommon", new String[0]);

    @Nullable
    public static GoogleSignInResult getSignInResultFromIntent(Intent intent) {
        if (intent == null || (!intent.hasExtra("googleSignInStatus") && !intent.hasExtra("googleSignInAccount"))) {
            return null;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) intent.getParcelableExtra("googleSignInAccount");
        Status status = (Status) intent.getParcelableExtra("googleSignInStatus");
        if (googleSignInAccount != null) {
            status = Status.zzftq;
        }
        return new GoogleSignInResult(googleSignInAccount, status);
    }

    public static Intent zza(Context context, GoogleSignInOptions googleSignInOptions) {
        zzenl.zzb("getSignInIntent()", new Object[0]);
        Parcelable signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, SignInHubActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("config", signInConfiguration);
        intent.putExtra("config", bundle);
        return intent;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008a  */
    public static com.google.android.gms.common.api.OptionalPendingResult<com.google.android.gms.auth.api.signin.GoogleSignInResult> zza(com.google.android.gms.common.api.GoogleApiClient r5, android.content.Context r6, com.google.android.gms.auth.api.signin.GoogleSignInOptions r7, boolean r8) {
        /*
        r0 = zzenl;
        r1 = "silentSignIn()";
        r2 = 0;
        r3 = new java.lang.Object[r2];
        r0.zzb(r1, r3);
        r0 = zzenl;
        r1 = "getEligibleSavedSignInResult()";
        r3 = new java.lang.Object[r2];
        r0.zzb(r1, r3);
        com.google.android.gms.common.internal.zzbq.checkNotNull(r7);
        r0 = com.google.android.gms.auth.api.signin.internal.zzp.zzbq(r6);
        r0 = r0.zzacq();
        r1 = 0;
        if (r0 == 0) goto L_0x0087;
    L_0x0021:
        r3 = r0.getAccount();
        r4 = r7.getAccount();
        if (r3 != 0) goto L_0x0031;
    L_0x002b:
        if (r4 != 0) goto L_0x002f;
    L_0x002d:
        r3 = 1;
        goto L_0x0035;
    L_0x002f:
        r3 = 0;
        goto L_0x0035;
    L_0x0031:
        r3 = r3.equals(r4);
    L_0x0035:
        if (r3 == 0) goto L_0x0087;
    L_0x0037:
        r3 = r7.zzacj();
        if (r3 != 0) goto L_0x0087;
    L_0x003d:
        r3 = r7.isIdTokenRequested();
        if (r3 == 0) goto L_0x0057;
    L_0x0043:
        r3 = r0.isIdTokenRequested();
        if (r3 == 0) goto L_0x0087;
    L_0x0049:
        r3 = r7.getServerClientId();
        r4 = r0.getServerClientId();
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0087;
    L_0x0057:
        r3 = new java.util.HashSet;
        r0 = r0.zzaci();
        r3.<init>(r0);
        r0 = new java.util.HashSet;
        r4 = r7.zzaci();
        r0.<init>(r4);
        r0 = r3.containsAll(r0);
        if (r0 == 0) goto L_0x0087;
    L_0x006f:
        r0 = com.google.android.gms.auth.api.signin.internal.zzp.zzbq(r6);
        r0 = r0.zzacp();
        if (r0 == 0) goto L_0x0087;
    L_0x0079:
        r3 = r0.zza();
        if (r3 != 0) goto L_0x0087;
    L_0x007f:
        r3 = new com.google.android.gms.auth.api.signin.GoogleSignInResult;
        r4 = com.google.android.gms.common.api.Status.zzftq;
        r3.<init>(r0, r4);
        goto L_0x0088;
    L_0x0087:
        r3 = r1;
    L_0x0088:
        if (r3 == 0) goto L_0x0098;
    L_0x008a:
        r6 = zzenl;
        r7 = "Eligible saved sign in result found";
        r8 = new java.lang.Object[r2];
        r6.zzb(r7, r8);
        r5 = com.google.android.gms.common.api.PendingResults.zzb(r3, r5);
        return r5;
    L_0x0098:
        if (r8 == 0) goto L_0x00aa;
    L_0x009a:
        r6 = new com.google.android.gms.auth.api.signin.GoogleSignInResult;
        r7 = new com.google.android.gms.common.api.Status;
        r8 = 4;
        r7.<init>(r8);
        r6.<init>(r1, r7);
        r5 = com.google.android.gms.common.api.PendingResults.zzb(r6, r5);
        return r5;
    L_0x00aa:
        r8 = zzenl;
        r0 = "trySilentSignIn()";
        r1 = new java.lang.Object[r2];
        r8.zzb(r0, r1);
        r8 = new com.google.android.gms.auth.api.signin.internal.zzg;
        r8.<init>(r5, r6, r7);
        r5 = r5.zzd(r8);
        r6 = new com.google.android.gms.common.api.internal.zzco;
        r6.<init>(r5);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.internal.zzf.zza(com.google.android.gms.common.api.GoogleApiClient, android.content.Context, com.google.android.gms.auth.api.signin.GoogleSignInOptions, boolean):com.google.android.gms.common.api.OptionalPendingResult<com.google.android.gms.auth.api.signin.GoogleSignInResult>");
    }

    public static PendingResult<Status> zza(GoogleApiClient googleApiClient, Context context, boolean z) {
        zzenl.zzb("Signing out", new Object[0]);
        zzbp(context);
        return z ? PendingResults.zza(Status.zzftq, googleApiClient) : googleApiClient.zze(new zzi(googleApiClient));
    }

    public static Intent zzb(Context context, GoogleSignInOptions googleSignInOptions) {
        zzenl.zzb("getFallbackSignInIntent()", new Object[0]);
        Intent zza = zza(context, googleSignInOptions);
        zza.setAction("com.google.android.gms.auth.APPAUTH_SIGN_IN");
        return zza;
    }

    public static PendingResult<Status> zzb(GoogleApiClient googleApiClient, Context context, boolean z) {
        zzenl.zzb("Revoking access", new Object[0]);
        String zzfg = zzaa.zzbs(context).zzfg("refreshToken");
        zzbp(context);
        return z ? zzb.zzfd(zzfg) : googleApiClient.zze(new zzk(googleApiClient));
    }

    private static void zzbp(Context context) {
        zzp.zzbq(context).clear();
        for (GoogleApiClient zzaia : GoogleApiClient.zzahz()) {
            zzaia.zzaia();
        }
        zzbm.zzajz();
    }

    public static Intent zzc(Context context, GoogleSignInOptions googleSignInOptions) {
        zzenl.zzb("getNoImplementationSignInIntent()", new Object[0]);
        Intent zza = zza(context, googleSignInOptions);
        zza.setAction("com.google.android.gms.auth.NO_IMPL");
        return zza;
    }
}
