package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;

public final class CredentialsOptions extends AuthCredentialsOptions {
    public static final CredentialsOptions DEFAULT = ((CredentialsOptions) new Builder().zzabx());

    public static final class Builder extends com.google.android.gms.auth.api.Auth.AuthCredentialsOptions.Builder {
        /* renamed from: build */
        public final CredentialsOptions zzabx() {
            return new CredentialsOptions(this, null);
        }

        public final Builder forceEnableSaveDialog() {
            this.zzeiw = Boolean.valueOf(true);
            return this;
        }
    }

    private CredentialsOptions(Builder builder) {
        super(builder);
    }

    /* synthetic */ CredentialsOptions(Builder builder, zzf zzf) {
        this(builder);
    }
}
