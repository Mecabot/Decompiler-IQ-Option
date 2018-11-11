package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class CredentialPickerConfig extends zzbgl implements ReflectedParcelable {
    public static final Creator<CredentialPickerConfig> CREATOR = new zzc();
    private final boolean mShowCancelButton;
    @Hide
    private int zzehz;
    private final boolean zzeks;
    @Deprecated
    private final boolean zzekt;
    private final int zzeku;

    public static class Builder {
        private boolean mShowCancelButton = true;
        private boolean zzeks = false;
        private int zzekv = 1;

        public CredentialPickerConfig build() {
            return new CredentialPickerConfig(this);
        }

        @Deprecated
        public Builder setForNewAccount(boolean z) {
            this.zzekv = z ? 3 : 1;
            return this;
        }

        public Builder setPrompt(int i) {
            this.zzekv = i;
            return this;
        }

        public Builder setShowAddAccountButton(boolean z) {
            this.zzeks = z;
            return this;
        }

        public Builder setShowCancelButton(boolean z) {
            this.mShowCancelButton = z;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Prompt {
        public static final int CONTINUE = 1;
        public static final int SIGN_IN = 2;
        public static final int SIGN_UP = 3;
    }

    CredentialPickerConfig(int i, boolean z, boolean z2, boolean z3, int i2) {
        this.zzehz = i;
        this.zzeks = z;
        this.mShowCancelButton = z2;
        z = true;
        if (i < 2) {
            int i3;
            this.zzekt = z3;
            if (z3) {
                i3 = 3;
            }
            this.zzeku = i3;
            return;
        }
        if (i2 != 3) {
            z = false;
        }
        this.zzekt = z;
        this.zzeku = i2;
    }

    private CredentialPickerConfig(Builder builder) {
        this(2, builder.zzeks, builder.mShowCancelButton, false, builder.zzekv);
    }

    @Deprecated
    public final boolean isForNewAccount() {
        return this.zzeku == 3;
    }

    public final boolean shouldShowAddAccountButton() {
        return this.zzeks;
    }

    public final boolean shouldShowCancelButton() {
        return this.mShowCancelButton;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 1, shouldShowAddAccountButton());
        zzbgo.zza(parcel, 2, shouldShowCancelButton());
        zzbgo.zza(parcel, 3, isForNewAccount());
        zzbgo.zzc(parcel, 4, this.zzeku);
        zzbgo.zzc(parcel, 1000, this.zzehz);
        zzbgo.zzai(parcel, i);
    }
}
