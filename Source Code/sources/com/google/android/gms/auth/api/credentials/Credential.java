package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Credential extends zzbgl implements ReflectedParcelable {
    public static final Creator<Credential> CREATOR = new zza();
    public static final String EXTRA_KEY = "com.google.android.gms.credentials.Credential";
    @Nullable
    private final String mName;
    private final String zzbzd;
    @Nullable
    private final String zzekb;
    @Nullable
    private final Uri zzekl;
    private final List<IdToken> zzekm;
    @Nullable
    private final String zzekn;
    @Nullable
    private final String zzeko;
    @Nullable
    private final String zzekp;
    @Nullable
    private final String zzekq;
    @Nullable
    private final String zzekr;

    public static class Builder {
        private String mName;
        private final String zzbzd;
        private String zzekb;
        private Uri zzekl;
        private List<IdToken> zzekm;
        private String zzekn;
        private String zzeko;
        private String zzekp;
        private String zzekq;
        private String zzekr;

        public Builder(Credential credential) {
            this.zzbzd = credential.zzbzd;
            this.mName = credential.mName;
            this.zzekl = credential.zzekl;
            this.zzekm = credential.zzekm;
            this.zzekn = credential.zzekn;
            this.zzekb = credential.zzekb;
            this.zzeko = credential.zzeko;
            this.zzekp = credential.zzekp;
            this.zzekq = credential.zzekq;
            this.zzekr = credential.zzekr;
        }

        public Builder(String str) {
            this.zzbzd = str;
        }

        public Credential build() {
            return new Credential(this.zzbzd, this.mName, this.zzekl, this.zzekm, this.zzekn, this.zzekb, this.zzeko, this.zzekp, this.zzekq, this.zzekr);
        }

        public Builder setAccountType(String str) {
            this.zzekb = str;
            return this;
        }

        public Builder setName(String str) {
            this.mName = str;
            return this;
        }

        public Builder setPassword(String str) {
            this.zzekn = str;
            return this;
        }

        public Builder setProfilePictureUri(Uri uri) {
            this.zzekl = uri;
            return this;
        }
    }

    @Hide
    Credential(String str, String str2, Uri uri, List<IdToken> list, String str3, String str4, String str5, String str6, String str7, String str8) {
        str = ((String) zzbq.checkNotNull(str, "credential identifier cannot be null")).trim();
        zzbq.zzh(str, "credential identifier cannot be empty");
        if (str3 == null || !TextUtils.isEmpty(str3)) {
            if (str4 != null) {
                boolean z = false;
                if (!TextUtils.isEmpty(str4)) {
                    Uri parse = Uri.parse(str4);
                    if (parse.isAbsolute() && parse.isHierarchical() && !TextUtils.isEmpty(parse.getScheme()) && !TextUtils.isEmpty(parse.getAuthority()) && ("http".equalsIgnoreCase(parse.getScheme()) || "https".equalsIgnoreCase(parse.getScheme()))) {
                        z = true;
                    }
                }
                if (!Boolean.valueOf(z).booleanValue()) {
                    throw new IllegalArgumentException("Account type must be a valid Http/Https URI");
                }
            }
            if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
                if (str2 != null && TextUtils.isEmpty(str2.trim())) {
                    str2 = null;
                }
                this.mName = str2;
                this.zzekl = uri;
                this.zzekm = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
                this.zzbzd = str;
                this.zzekn = str3;
                this.zzekb = str4;
                this.zzeko = str5;
                this.zzekp = str6;
                this.zzekq = str7;
                this.zzekr = str8;
                return;
            }
            throw new IllegalArgumentException("Password and AccountType are mutually exclusive");
        }
        throw new IllegalArgumentException("Password must not be empty if set");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        return TextUtils.equals(this.zzbzd, credential.zzbzd) && TextUtils.equals(this.mName, credential.mName) && zzbg.equal(this.zzekl, credential.zzekl) && TextUtils.equals(this.zzekn, credential.zzekn) && TextUtils.equals(this.zzekb, credential.zzekb) && TextUtils.equals(this.zzeko, credential.zzeko);
    }

    @Nullable
    public String getAccountType() {
        return this.zzekb;
    }

    @Nullable
    public String getFamilyName() {
        return this.zzekr;
    }

    @Nullable
    public String getGeneratedPassword() {
        return this.zzeko;
    }

    @Nullable
    public String getGivenName() {
        return this.zzekq;
    }

    public String getId() {
        return this.zzbzd;
    }

    public List<IdToken> getIdTokens() {
        return this.zzekm;
    }

    @Nullable
    public String getName() {
        return this.mName;
    }

    @Nullable
    public String getPassword() {
        return this.zzekn;
    }

    @Nullable
    public Uri getProfilePictureUri() {
        return this.zzekl;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzbzd, this.mName, this.zzekl, this.zzekn, this.zzekb, this.zzeko});
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 1, getId(), false);
        zzbgo.zza(parcel, 2, getName(), false);
        zzbgo.zza(parcel, 3, getProfilePictureUri(), i, false);
        zzbgo.zzc(parcel, 4, getIdTokens(), false);
        zzbgo.zza(parcel, 5, getPassword(), false);
        zzbgo.zza(parcel, 6, getAccountType(), false);
        zzbgo.zza(parcel, 7, getGeneratedPassword(), false);
        zzbgo.zza(parcel, 8, this.zzekp, false);
        zzbgo.zza(parcel, 9, getGivenName(), false);
        zzbgo.zza(parcel, 10, getFamilyName(), false);
        zzbgo.zzai(parcel, zze);
    }
}
