package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class CredentialRequest extends zzbgl {
    public static final Creator<CredentialRequest> CREATOR = new zze();
    @Hide
    private int zzehz;
    private final boolean zzekw;
    private final String[] zzekx;
    private final CredentialPickerConfig zzeky;
    private final CredentialPickerConfig zzekz;
    private final boolean zzela;
    private final String zzelb;
    private final String zzelc;
    private final boolean zzeld;

    public static final class Builder {
        private boolean zzekw;
        private String[] zzekx;
        private CredentialPickerConfig zzeky;
        private CredentialPickerConfig zzekz;
        private boolean zzela = false;
        @Nullable
        private String zzelb = null;
        @Nullable
        private String zzelc;
        private boolean zzeld = false;

        public final CredentialRequest build() {
            if (this.zzekx == null) {
                this.zzekx = new String[0];
            }
            if (this.zzekw || this.zzekx.length != 0) {
                return new CredentialRequest(this);
            }
            throw new IllegalStateException("At least one authentication method must be specified");
        }

        public final Builder setAccountTypes(String... strArr) {
            if (strArr == null) {
                strArr = new String[0];
            }
            this.zzekx = strArr;
            return this;
        }

        public final Builder setCredentialHintPickerConfig(CredentialPickerConfig credentialPickerConfig) {
            this.zzekz = credentialPickerConfig;
            return this;
        }

        public final Builder setCredentialPickerConfig(CredentialPickerConfig credentialPickerConfig) {
            this.zzeky = credentialPickerConfig;
            return this;
        }

        public final Builder setIdTokenNonce(@Nullable String str) {
            this.zzelc = str;
            return this;
        }

        public final Builder setIdTokenRequested(boolean z) {
            this.zzela = z;
            return this;
        }

        public final Builder setPasswordLoginSupported(boolean z) {
            this.zzekw = z;
            return this;
        }

        public final Builder setServerClientId(@Nullable String str) {
            this.zzelb = str;
            return this;
        }

        @Deprecated
        public final Builder setSupportsPasswordLogin(boolean z) {
            return setPasswordLoginSupported(z);
        }
    }

    CredentialRequest(int i, boolean z, String[] strArr, CredentialPickerConfig credentialPickerConfig, CredentialPickerConfig credentialPickerConfig2, boolean z2, String str, String str2, boolean z3) {
        this.zzehz = i;
        this.zzekw = z;
        this.zzekx = (String[]) zzbq.checkNotNull(strArr);
        if (credentialPickerConfig == null) {
            credentialPickerConfig = new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().build();
        }
        this.zzeky = credentialPickerConfig;
        if (credentialPickerConfig2 == null) {
            credentialPickerConfig2 = new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().build();
        }
        this.zzekz = credentialPickerConfig2;
        if (i < 3) {
            this.zzela = true;
            this.zzelb = null;
            this.zzelc = null;
        } else {
            this.zzela = z2;
            this.zzelb = str;
            this.zzelc = str2;
        }
        this.zzeld = z3;
    }

    private CredentialRequest(Builder builder) {
        this(4, builder.zzekw, builder.zzekx, builder.zzeky, builder.zzekz, builder.zzela, builder.zzelb, builder.zzelc, false);
    }

    @NonNull
    public final String[] getAccountTypes() {
        return this.zzekx;
    }

    @NonNull
    public final Set<String> getAccountTypesSet() {
        return new HashSet(Arrays.asList(this.zzekx));
    }

    @NonNull
    public final CredentialPickerConfig getCredentialHintPickerConfig() {
        return this.zzekz;
    }

    @NonNull
    public final CredentialPickerConfig getCredentialPickerConfig() {
        return this.zzeky;
    }

    @Nullable
    public final String getIdTokenNonce() {
        return this.zzelc;
    }

    @Nullable
    public final String getServerClientId() {
        return this.zzelb;
    }

    @Deprecated
    public final boolean getSupportsPasswordLogin() {
        return isPasswordLoginSupported();
    }

    public final boolean isIdTokenRequested() {
        return this.zzela;
    }

    public final boolean isPasswordLoginSupported() {
        return this.zzekw;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 1, isPasswordLoginSupported());
        zzbgo.zza(parcel, 2, getAccountTypes(), false);
        zzbgo.zza(parcel, 3, getCredentialPickerConfig(), i, false);
        zzbgo.zza(parcel, 4, getCredentialHintPickerConfig(), i, false);
        zzbgo.zza(parcel, 5, isIdTokenRequested());
        zzbgo.zza(parcel, 6, getServerClientId(), false);
        zzbgo.zza(parcel, 7, getIdTokenNonce(), false);
        zzbgo.zzc(parcel, 1000, this.zzehz);
        zzbgo.zza(parcel, 8, this.zzeld);
        zzbgo.zzai(parcel, zze);
    }
}
