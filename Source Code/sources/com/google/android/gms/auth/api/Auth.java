package com.google.android.gms.auth.api;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzd;
import com.google.android.gms.auth.api.signin.internal.zze;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzawb;
import com.google.android.gms.internal.zzawc;
import com.google.android.gms.internal.zzawd;
import com.google.android.gms.internal.zzawz;
import com.google.android.gms.internal.zzaxi;
import com.google.android.gms.internal.zzayh;

public final class Auth {
    public static final Api<AuthCredentialsOptions> CREDENTIALS_API = new Api("Auth.CREDENTIALS_API", zzein, zzeik);
    public static final CredentialsApi CredentialsApi = new zzawz();
    public static final Api<GoogleSignInOptions> GOOGLE_SIGN_IN_API = new Api("Auth.GOOGLE_SIGN_IN_API", zzeip, zzeim);
    public static final GoogleSignInApi GoogleSignInApi = new zzd();
    @Hide
    @KeepForSdk
    public static final Api<zzf> PROXY_API = zzd.API;
    @Hide
    @KeepForSdk
    public static final ProxyApi ProxyApi = new zzayh();
    @Hide
    public static final zzf<zzaxi> zzeik = new zzf();
    @Hide
    private static zzf<zzawd> zzeil = new zzf();
    @Hide
    public static final zzf<zze> zzeim = new zzf();
    private static final zza<zzaxi, AuthCredentialsOptions> zzein = new zza();
    private static final zza<zzawd, NoOptions> zzeio = new zzb();
    private static final zza<zze, GoogleSignInOptions> zzeip = new zzc();
    @Hide
    private static Api<NoOptions> zzeiq = new Api("Auth.ACCOUNT_STATUS_API", zzeio, zzeil);
    @Hide
    private static zzawb zzeir = new zzawc();

    @Deprecated
    public static class AuthCredentialsOptions implements Optional {
        @Hide
        private static AuthCredentialsOptions zzeis = new Builder().zzabx();
        private final String zzeit = null;
        private final PasswordSpecification zzeiu;
        private final boolean zzeiv;

        @Deprecated
        public static class Builder {
            @Hide
            @NonNull
            protected PasswordSpecification zzeiu = PasswordSpecification.zzeli;
            @Hide
            protected Boolean zzeiw = Boolean.valueOf(false);

            public Builder forceEnableSaveDialog() {
                this.zzeiw = Boolean.valueOf(true);
                return this;
            }

            @Hide
            public AuthCredentialsOptions zzabx() {
                return new AuthCredentialsOptions(this);
            }
        }

        @Hide
        public AuthCredentialsOptions(Builder builder) {
            this.zzeiu = builder.zzeiu;
            this.zzeiv = builder.zzeiw.booleanValue();
        }

        @Hide
        public final Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", null);
            bundle.putParcelable("password_specification", this.zzeiu);
            bundle.putBoolean("force_save_dialog", this.zzeiv);
            return bundle;
        }

        @Hide
        public final PasswordSpecification zzabw() {
            return this.zzeiu;
        }
    }

    @Hide
    private Auth() {
    }
}
