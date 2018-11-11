package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;

public final class HintRequest extends zzbgl implements ReflectedParcelable {
    public static final Creator<HintRequest> CREATOR = new zzh();
    private int zzehz;
    private final String[] zzekx;
    private final boolean zzela;
    private final String zzelb;
    private final String zzelc;
    private final CredentialPickerConfig zzele;
    private final boolean zzelf;
    private final boolean zzelg;

    public static final class Builder {
        private String[] zzekx;
        private boolean zzela = false;
        private String zzelb;
        private String zzelc;
        private CredentialPickerConfig zzele = new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().build();
        private boolean zzelf;
        private boolean zzelg;

        public final HintRequest build() {
            if (this.zzekx == null) {
                this.zzekx = new String[0];
            }
            if (this.zzelf || this.zzelg || this.zzekx.length != 0) {
                return new HintRequest(this);
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

        public final Builder setEmailAddressIdentifierSupported(boolean z) {
            this.zzelf = z;
            return this;
        }

        public final Builder setHintPickerConfig(@NonNull CredentialPickerConfig credentialPickerConfig) {
            this.zzele = (CredentialPickerConfig) zzbq.checkNotNull(credentialPickerConfig);
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

        public final Builder setPhoneNumberIdentifierSupported(boolean z) {
            this.zzelg = z;
            return this;
        }

        public final Builder setServerClientId(@Nullable String str) {
            this.zzelb = str;
            return this;
        }
    }

    HintRequest(int i, CredentialPickerConfig credentialPickerConfig, boolean z, boolean z2, String[] strArr, boolean z3, String str, String str2) {
        this.zzehz = i;
        this.zzele = (CredentialPickerConfig) zzbq.checkNotNull(credentialPickerConfig);
        this.zzelf = z;
        this.zzelg = z2;
        this.zzekx = (String[]) zzbq.checkNotNull(strArr);
        if (this.zzehz < 2) {
            this.zzela = true;
            this.zzelb = null;
            this.zzelc = null;
            return;
        }
        this.zzela = z3;
        this.zzelb = str;
        this.zzelc = str2;
    }

    private HintRequest(Builder builder) {
        this(2, builder.zzele, builder.zzelf, builder.zzelg, builder.zzekx, builder.zzela, builder.zzelb, builder.zzelc);
    }

    @NonNull
    public final String[] getAccountTypes() {
        return this.zzekx;
    }

    @NonNull
    public final CredentialPickerConfig getHintPickerConfig() {
        return this.zzele;
    }

    @Nullable
    public final String getIdTokenNonce() {
        return this.zzelc;
    }

    @Nullable
    public final String getServerClientId() {
        return this.zzelb;
    }

    public final boolean isEmailAddressIdentifierSupported() {
        return this.zzelf;
    }

    public final boolean isIdTokenRequested() {
        return this.zzela;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 1, getHintPickerConfig(), i, false);
        zzbgo.zza(parcel, 2, isEmailAddressIdentifierSupported());
        zzbgo.zza(parcel, 3, this.zzelg);
        zzbgo.zza(parcel, 4, getAccountTypes(), false);
        zzbgo.zza(parcel, 5, isIdTokenRequested());
        zzbgo.zza(parcel, 6, getServerClientId(), false);
        zzbgo.zza(parcel, 7, getIdTokenNonce(), false);
        zzbgo.zzc(parcel, 1000, this.zzehz);
        zzbgo.zzai(parcel, zze);
    }
}
