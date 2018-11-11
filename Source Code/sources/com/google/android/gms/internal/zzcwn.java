package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.Person.AgeRange;
import com.google.android.gms.plus.model.people.Person.Cover;
import com.google.android.gms.plus.model.people.Person.Cover.CoverInfo;
import com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto;
import com.google.android.gms.plus.model.people.Person.Image;
import com.google.android.gms.plus.model.people.Person.Name;
import com.google.android.gms.plus.model.people.Person.Organizations;
import com.google.android.gms.plus.model.people.Person.PlacesLived;
import com.google.android.gms.plus.model.people.Person.Urls;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Hide
public final class zzcwn extends zzbhs implements Person {
    public static final Creator<zzcwn> CREATOR = new zzcwo();
    private static final HashMap<String, zzbhq<?, ?>> zzejp;
    private String zzag;
    private int zzbhm;
    private String zzbzd;
    private String zzdxa;
    private int zzehz;
    private Set<Integer> zzejq;
    private String zzemi;
    private String zzkil;
    private zza zzkim;
    private String zzkin;
    private String zzkio;
    private int zzkip;
    private zzb zzkiq;
    private String zzkir;
    private zzc zzkis;
    private boolean zzkit;
    private zzd zzkiu;
    private String zzkiv;
    private int zzkiw;
    private List<zze> zzkix;
    private List<zzf> zzkiy;
    private int zzkiz;
    private int zzkja;
    private String zzkjb;
    private List<zzg> zzkjc;
    private boolean zzkjd;

    @Hide
    public static final class zza extends zzbhs implements AgeRange {
        public static final Creator<zza> CREATOR = new zzcwp();
        private static final HashMap<String, zzbhq<?, ?>> zzejp;
        private int zzehz;
        private Set<Integer> zzejq;
        private int zzkje;
        private int zzkjf;

        static {
            HashMap hashMap = new HashMap();
            zzejp = hashMap;
            hashMap.put("max", zzbhq.zzj("max", 2));
            zzejp.put("min", zzbhq.zzj("min", 3));
        }

        public zza() {
            this.zzehz = 1;
            this.zzejq = new HashSet();
        }

        zza(Set<Integer> set, int i, int i2, int i3) {
            this.zzejq = set;
            this.zzehz = i;
            this.zzkje = i2;
            this.zzkjf = i3;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zza zza = (zza) obj;
            for (zzbhq zzbhq : zzejp.values()) {
                if (zza(zzbhq)) {
                    if (!zza.zza(zzbhq) || !zzb(zzbhq).equals(zza.zzb(zzbhq))) {
                        return false;
                    }
                } else if (zza.zza(zzbhq)) {
                    return false;
                }
            }
            return true;
        }

        public final /* bridge */ /* synthetic */ Object freeze() {
            if (this != null) {
                return this;
            }
            throw null;
        }

        public final int getMax() {
            return this.zzkje;
        }

        public final int getMin() {
            return this.zzkjf;
        }

        public final boolean hasMax() {
            return this.zzejq.contains(Integer.valueOf(2));
        }

        public final boolean hasMin() {
            return this.zzejq.contains(Integer.valueOf(3));
        }

        public final int hashCode() {
            int i = 0;
            for (zzbhq zzbhq : zzejp.values()) {
                if (zza(zzbhq)) {
                    i = (i + zzbhq.zzane()) + zzb(zzbhq).hashCode();
                }
            }
            return i;
        }

        public final boolean isDataValid() {
            return true;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            i = zzbgo.zze(parcel);
            Set set = this.zzejq;
            if (set.contains(Integer.valueOf(1))) {
                zzbgo.zzc(parcel, 1, this.zzehz);
            }
            if (set.contains(Integer.valueOf(2))) {
                zzbgo.zzc(parcel, 2, this.zzkje);
            }
            if (set.contains(Integer.valueOf(3))) {
                zzbgo.zzc(parcel, 3, this.zzkjf);
            }
            zzbgo.zzai(parcel, i);
        }

        protected final boolean zza(zzbhq zzbhq) {
            return this.zzejq.contains(Integer.valueOf(zzbhq.zzane()));
        }

        public final /* synthetic */ Map zzabz() {
            return zzejp;
        }

        protected final Object zzb(zzbhq zzbhq) {
            int i;
            switch (zzbhq.zzane()) {
                case 2:
                    i = this.zzkje;
                    break;
                case 3:
                    i = this.zzkjf;
                    break;
                default:
                    i = zzbhq.zzane();
                    StringBuilder stringBuilder = new StringBuilder(38);
                    stringBuilder.append("Unknown safe parcelable id=");
                    stringBuilder.append(i);
                    throw new IllegalStateException(stringBuilder.toString());
            }
            return Integer.valueOf(i);
        }
    }

    @Hide
    public static final class zzb extends zzbhs implements Cover {
        public static final Creator<zzb> CREATOR = new zzcwq();
        private static final HashMap<String, zzbhq<?, ?>> zzejp;
        private int zzehz;
        private Set<Integer> zzejq;
        private zza zzkjg;
        private zzb zzkjh;
        private int zzkji;

        @Hide
        public static final class zza extends zzbhs implements CoverInfo {
            public static final Creator<zza> CREATOR = new zzcwr();
            private static final HashMap<String, zzbhq<?, ?>> zzejp;
            private int zzehz;
            private Set<Integer> zzejq;
            private int zzkjj;
            private int zzkjk;

            static {
                HashMap hashMap = new HashMap();
                zzejp = hashMap;
                hashMap.put("leftImageOffset", zzbhq.zzj("leftImageOffset", 2));
                zzejp.put("topImageOffset", zzbhq.zzj("topImageOffset", 3));
            }

            public zza() {
                this.zzehz = 1;
                this.zzejq = new HashSet();
            }

            zza(Set<Integer> set, int i, int i2, int i3) {
                this.zzejq = set;
                this.zzehz = i;
                this.zzkjj = i2;
                this.zzkjk = i3;
            }

            public final boolean equals(Object obj) {
                if (!(obj instanceof zza)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                zza zza = (zza) obj;
                for (zzbhq zzbhq : zzejp.values()) {
                    if (zza(zzbhq)) {
                        if (!zza.zza(zzbhq) || !zzb(zzbhq).equals(zza.zzb(zzbhq))) {
                            return false;
                        }
                    } else if (zza.zza(zzbhq)) {
                        return false;
                    }
                }
                return true;
            }

            public final /* bridge */ /* synthetic */ Object freeze() {
                if (this != null) {
                    return this;
                }
                throw null;
            }

            public final int getLeftImageOffset() {
                return this.zzkjj;
            }

            public final int getTopImageOffset() {
                return this.zzkjk;
            }

            public final boolean hasLeftImageOffset() {
                return this.zzejq.contains(Integer.valueOf(2));
            }

            public final boolean hasTopImageOffset() {
                return this.zzejq.contains(Integer.valueOf(3));
            }

            public final int hashCode() {
                int i = 0;
                for (zzbhq zzbhq : zzejp.values()) {
                    if (zza(zzbhq)) {
                        i = (i + zzbhq.zzane()) + zzb(zzbhq).hashCode();
                    }
                }
                return i;
            }

            public final boolean isDataValid() {
                return true;
            }

            public final void writeToParcel(Parcel parcel, int i) {
                i = zzbgo.zze(parcel);
                Set set = this.zzejq;
                if (set.contains(Integer.valueOf(1))) {
                    zzbgo.zzc(parcel, 1, this.zzehz);
                }
                if (set.contains(Integer.valueOf(2))) {
                    zzbgo.zzc(parcel, 2, this.zzkjj);
                }
                if (set.contains(Integer.valueOf(3))) {
                    zzbgo.zzc(parcel, 3, this.zzkjk);
                }
                zzbgo.zzai(parcel, i);
            }

            protected final boolean zza(zzbhq zzbhq) {
                return this.zzejq.contains(Integer.valueOf(zzbhq.zzane()));
            }

            public final /* synthetic */ Map zzabz() {
                return zzejp;
            }

            protected final Object zzb(zzbhq zzbhq) {
                int i;
                switch (zzbhq.zzane()) {
                    case 2:
                        i = this.zzkjj;
                        break;
                    case 3:
                        i = this.zzkjk;
                        break;
                    default:
                        i = zzbhq.zzane();
                        StringBuilder stringBuilder = new StringBuilder(38);
                        stringBuilder.append("Unknown safe parcelable id=");
                        stringBuilder.append(i);
                        throw new IllegalStateException(stringBuilder.toString());
                }
                return Integer.valueOf(i);
            }
        }

        @Hide
        public static final class zzb extends zzbhs implements CoverPhoto {
            public static final Creator<zzb> CREATOR = new zzcws();
            private static final HashMap<String, zzbhq<?, ?>> zzejp;
            private String zzag;
            private int zzalt;
            private int zzalu;
            private int zzehz;
            private Set<Integer> zzejq;

            static {
                HashMap hashMap = new HashMap();
                zzejp = hashMap;
                hashMap.put("height", zzbhq.zzj("height", 2));
                zzejp.put(PlusShare.KEY_CALL_TO_ACTION_URL, zzbhq.zzl(PlusShare.KEY_CALL_TO_ACTION_URL, 3));
                zzejp.put("width", zzbhq.zzj("width", 4));
            }

            public zzb() {
                this.zzehz = 1;
                this.zzejq = new HashSet();
            }

            zzb(Set<Integer> set, int i, int i2, String str, int i3) {
                this.zzejq = set;
                this.zzehz = i;
                this.zzalu = i2;
                this.zzag = str;
                this.zzalt = i3;
            }

            public final boolean equals(Object obj) {
                if (!(obj instanceof zzb)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                zzb zzb = (zzb) obj;
                for (zzbhq zzbhq : zzejp.values()) {
                    if (zza(zzbhq)) {
                        if (!zzb.zza(zzbhq) || !zzb(zzbhq).equals(zzb.zzb(zzbhq))) {
                            return false;
                        }
                    } else if (zzb.zza(zzbhq)) {
                        return false;
                    }
                }
                return true;
            }

            public final /* bridge */ /* synthetic */ Object freeze() {
                if (this != null) {
                    return this;
                }
                throw null;
            }

            public final int getHeight() {
                return this.zzalu;
            }

            public final String getUrl() {
                return this.zzag;
            }

            public final int getWidth() {
                return this.zzalt;
            }

            public final boolean hasHeight() {
                return this.zzejq.contains(Integer.valueOf(2));
            }

            public final boolean hasUrl() {
                return this.zzejq.contains(Integer.valueOf(3));
            }

            public final boolean hasWidth() {
                return this.zzejq.contains(Integer.valueOf(4));
            }

            public final int hashCode() {
                int i = 0;
                for (zzbhq zzbhq : zzejp.values()) {
                    if (zza(zzbhq)) {
                        i = (i + zzbhq.zzane()) + zzb(zzbhq).hashCode();
                    }
                }
                return i;
            }

            public final boolean isDataValid() {
                return true;
            }

            public final void writeToParcel(Parcel parcel, int i) {
                i = zzbgo.zze(parcel);
                Set set = this.zzejq;
                if (set.contains(Integer.valueOf(1))) {
                    zzbgo.zzc(parcel, 1, this.zzehz);
                }
                if (set.contains(Integer.valueOf(2))) {
                    zzbgo.zzc(parcel, 2, this.zzalu);
                }
                if (set.contains(Integer.valueOf(3))) {
                    zzbgo.zza(parcel, 3, this.zzag, true);
                }
                if (set.contains(Integer.valueOf(4))) {
                    zzbgo.zzc(parcel, 4, this.zzalt);
                }
                zzbgo.zzai(parcel, i);
            }

            protected final boolean zza(zzbhq zzbhq) {
                return this.zzejq.contains(Integer.valueOf(zzbhq.zzane()));
            }

            public final /* synthetic */ Map zzabz() {
                return zzejp;
            }

            protected final Object zzb(zzbhq zzbhq) {
                int i;
                switch (zzbhq.zzane()) {
                    case 2:
                        i = this.zzalu;
                        break;
                    case 3:
                        return this.zzag;
                    case 4:
                        i = this.zzalt;
                        break;
                    default:
                        i = zzbhq.zzane();
                        StringBuilder stringBuilder = new StringBuilder(38);
                        stringBuilder.append("Unknown safe parcelable id=");
                        stringBuilder.append(i);
                        throw new IllegalStateException(stringBuilder.toString());
                }
                return Integer.valueOf(i);
            }
        }

        static {
            HashMap hashMap = new HashMap();
            zzejp = hashMap;
            hashMap.put("coverInfo", zzbhq.zza("coverInfo", 2, zza.class));
            zzejp.put("coverPhoto", zzbhq.zza("coverPhoto", 3, zzb.class));
            zzejp.put("layout", zzbhq.zza("layout", 4, new zzbhl().zzi("banner", 0), false));
        }

        public zzb() {
            this.zzehz = 1;
            this.zzejq = new HashSet();
        }

        zzb(Set<Integer> set, int i, zza zza, zzb zzb, int i2) {
            this.zzejq = set;
            this.zzehz = i;
            this.zzkjg = zza;
            this.zzkjh = zzb;
            this.zzkji = i2;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zzb)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzb zzb = (zzb) obj;
            for (zzbhq zzbhq : zzejp.values()) {
                if (zza(zzbhq)) {
                    if (!zzb.zza(zzbhq) || !zzb(zzbhq).equals(zzb.zzb(zzbhq))) {
                        return false;
                    }
                } else if (zzb.zza(zzbhq)) {
                    return false;
                }
            }
            return true;
        }

        public final /* bridge */ /* synthetic */ Object freeze() {
            if (this != null) {
                return this;
            }
            throw null;
        }

        public final CoverInfo getCoverInfo() {
            return this.zzkjg;
        }

        public final CoverPhoto getCoverPhoto() {
            return this.zzkjh;
        }

        public final int getLayout() {
            return this.zzkji;
        }

        public final boolean hasCoverInfo() {
            return this.zzejq.contains(Integer.valueOf(2));
        }

        public final boolean hasCoverPhoto() {
            return this.zzejq.contains(Integer.valueOf(3));
        }

        public final boolean hasLayout() {
            return this.zzejq.contains(Integer.valueOf(4));
        }

        public final int hashCode() {
            int i = 0;
            for (zzbhq zzbhq : zzejp.values()) {
                if (zza(zzbhq)) {
                    i = (i + zzbhq.zzane()) + zzb(zzbhq).hashCode();
                }
            }
            return i;
        }

        public final boolean isDataValid() {
            return true;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            int zze = zzbgo.zze(parcel);
            Set set = this.zzejq;
            if (set.contains(Integer.valueOf(1))) {
                zzbgo.zzc(parcel, 1, this.zzehz);
            }
            if (set.contains(Integer.valueOf(2))) {
                zzbgo.zza(parcel, 2, this.zzkjg, i, true);
            }
            if (set.contains(Integer.valueOf(3))) {
                zzbgo.zza(parcel, 3, this.zzkjh, i, true);
            }
            if (set.contains(Integer.valueOf(4))) {
                zzbgo.zzc(parcel, 4, this.zzkji);
            }
            zzbgo.zzai(parcel, zze);
        }

        protected final boolean zza(zzbhq zzbhq) {
            return this.zzejq.contains(Integer.valueOf(zzbhq.zzane()));
        }

        public final /* synthetic */ Map zzabz() {
            return zzejp;
        }

        protected final Object zzb(zzbhq zzbhq) {
            switch (zzbhq.zzane()) {
                case 2:
                    return this.zzkjg;
                case 3:
                    return this.zzkjh;
                case 4:
                    return Integer.valueOf(this.zzkji);
                default:
                    int zzane = zzbhq.zzane();
                    StringBuilder stringBuilder = new StringBuilder(38);
                    stringBuilder.append("Unknown safe parcelable id=");
                    stringBuilder.append(zzane);
                    throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }

    @Hide
    public static final class zzc extends zzbhs implements Image {
        public static final Creator<zzc> CREATOR = new zzcwt();
        private static final HashMap<String, zzbhq<?, ?>> zzejp;
        private String zzag;
        private int zzehz;
        private Set<Integer> zzejq;

        static {
            HashMap hashMap = new HashMap();
            zzejp = hashMap;
            hashMap.put(PlusShare.KEY_CALL_TO_ACTION_URL, zzbhq.zzl(PlusShare.KEY_CALL_TO_ACTION_URL, 2));
        }

        public zzc() {
            this.zzehz = 1;
            this.zzejq = new HashSet();
        }

        public zzc(String str) {
            this.zzejq = new HashSet();
            this.zzehz = 1;
            this.zzag = str;
            this.zzejq.add(Integer.valueOf(2));
        }

        zzc(Set<Integer> set, int i, String str) {
            this.zzejq = set;
            this.zzehz = i;
            this.zzag = str;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zzc)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzc zzc = (zzc) obj;
            for (zzbhq zzbhq : zzejp.values()) {
                if (zza(zzbhq)) {
                    if (!zzc.zza(zzbhq) || !zzb(zzbhq).equals(zzc.zzb(zzbhq))) {
                        return false;
                    }
                } else if (zzc.zza(zzbhq)) {
                    return false;
                }
            }
            return true;
        }

        public final /* bridge */ /* synthetic */ Object freeze() {
            if (this != null) {
                return this;
            }
            throw null;
        }

        public final String getUrl() {
            return this.zzag;
        }

        public final boolean hasUrl() {
            return this.zzejq.contains(Integer.valueOf(2));
        }

        public final int hashCode() {
            int i = 0;
            for (zzbhq zzbhq : zzejp.values()) {
                if (zza(zzbhq)) {
                    i = (i + zzbhq.zzane()) + zzb(zzbhq).hashCode();
                }
            }
            return i;
        }

        public final boolean isDataValid() {
            return true;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            i = zzbgo.zze(parcel);
            Set set = this.zzejq;
            if (set.contains(Integer.valueOf(1))) {
                zzbgo.zzc(parcel, 1, this.zzehz);
            }
            if (set.contains(Integer.valueOf(2))) {
                zzbgo.zza(parcel, 2, this.zzag, true);
            }
            zzbgo.zzai(parcel, i);
        }

        protected final boolean zza(zzbhq zzbhq) {
            return this.zzejq.contains(Integer.valueOf(zzbhq.zzane()));
        }

        public final /* synthetic */ Map zzabz() {
            return zzejp;
        }

        protected final Object zzb(zzbhq zzbhq) {
            if (zzbhq.zzane() == 2) {
                return this.zzag;
            }
            int zzane = zzbhq.zzane();
            StringBuilder stringBuilder = new StringBuilder(38);
            stringBuilder.append("Unknown safe parcelable id=");
            stringBuilder.append(zzane);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    @Hide
    public static final class zzd extends zzbhs implements Name {
        public static final Creator<zzd> CREATOR = new zzcwu();
        private static final HashMap<String, zzbhq<?, ?>> zzejp;
        private int zzehz;
        private Set<Integer> zzejq;
        private String zzekq;
        private String zzekr;
        private String zzkjl;
        private String zzkjm;
        private String zzkjn;
        private String zzkjo;

        static {
            HashMap hashMap = new HashMap();
            zzejp = hashMap;
            hashMap.put("familyName", zzbhq.zzl("familyName", 2));
            zzejp.put("formatted", zzbhq.zzl("formatted", 3));
            zzejp.put("givenName", zzbhq.zzl("givenName", 4));
            zzejp.put("honorificPrefix", zzbhq.zzl("honorificPrefix", 5));
            zzejp.put("honorificSuffix", zzbhq.zzl("honorificSuffix", 6));
            zzejp.put("middleName", zzbhq.zzl("middleName", 7));
        }

        public zzd() {
            this.zzehz = 1;
            this.zzejq = new HashSet();
        }

        zzd(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, String str6) {
            this.zzejq = set;
            this.zzehz = i;
            this.zzekr = str;
            this.zzkjl = str2;
            this.zzekq = str3;
            this.zzkjm = str4;
            this.zzkjn = str5;
            this.zzkjo = str6;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zzd)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzd zzd = (zzd) obj;
            for (zzbhq zzbhq : zzejp.values()) {
                if (zza(zzbhq)) {
                    if (!zzd.zza(zzbhq) || !zzb(zzbhq).equals(zzd.zzb(zzbhq))) {
                        return false;
                    }
                } else if (zzd.zza(zzbhq)) {
                    return false;
                }
            }
            return true;
        }

        public final /* bridge */ /* synthetic */ Object freeze() {
            if (this != null) {
                return this;
            }
            throw null;
        }

        public final String getFamilyName() {
            return this.zzekr;
        }

        public final String getFormatted() {
            return this.zzkjl;
        }

        public final String getGivenName() {
            return this.zzekq;
        }

        public final String getHonorificPrefix() {
            return this.zzkjm;
        }

        public final String getHonorificSuffix() {
            return this.zzkjn;
        }

        public final String getMiddleName() {
            return this.zzkjo;
        }

        public final boolean hasFamilyName() {
            return this.zzejq.contains(Integer.valueOf(2));
        }

        public final boolean hasFormatted() {
            return this.zzejq.contains(Integer.valueOf(3));
        }

        public final boolean hasGivenName() {
            return this.zzejq.contains(Integer.valueOf(4));
        }

        public final boolean hasHonorificPrefix() {
            return this.zzejq.contains(Integer.valueOf(5));
        }

        public final boolean hasHonorificSuffix() {
            return this.zzejq.contains(Integer.valueOf(6));
        }

        public final boolean hasMiddleName() {
            return this.zzejq.contains(Integer.valueOf(7));
        }

        public final int hashCode() {
            int i = 0;
            for (zzbhq zzbhq : zzejp.values()) {
                if (zza(zzbhq)) {
                    i = (i + zzbhq.zzane()) + zzb(zzbhq).hashCode();
                }
            }
            return i;
        }

        public final boolean isDataValid() {
            return true;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            i = zzbgo.zze(parcel);
            Set set = this.zzejq;
            if (set.contains(Integer.valueOf(1))) {
                zzbgo.zzc(parcel, 1, this.zzehz);
            }
            if (set.contains(Integer.valueOf(2))) {
                zzbgo.zza(parcel, 2, this.zzekr, true);
            }
            if (set.contains(Integer.valueOf(3))) {
                zzbgo.zza(parcel, 3, this.zzkjl, true);
            }
            if (set.contains(Integer.valueOf(4))) {
                zzbgo.zza(parcel, 4, this.zzekq, true);
            }
            if (set.contains(Integer.valueOf(5))) {
                zzbgo.zza(parcel, 5, this.zzkjm, true);
            }
            if (set.contains(Integer.valueOf(6))) {
                zzbgo.zza(parcel, 6, this.zzkjn, true);
            }
            if (set.contains(Integer.valueOf(7))) {
                zzbgo.zza(parcel, 7, this.zzkjo, true);
            }
            zzbgo.zzai(parcel, i);
        }

        protected final boolean zza(zzbhq zzbhq) {
            return this.zzejq.contains(Integer.valueOf(zzbhq.zzane()));
        }

        public final /* synthetic */ Map zzabz() {
            return zzejp;
        }

        protected final Object zzb(zzbhq zzbhq) {
            switch (zzbhq.zzane()) {
                case 2:
                    return this.zzekr;
                case 3:
                    return this.zzkjl;
                case 4:
                    return this.zzekq;
                case 5:
                    return this.zzkjm;
                case 6:
                    return this.zzkjn;
                case 7:
                    return this.zzkjo;
                default:
                    int zzane = zzbhq.zzane();
                    StringBuilder stringBuilder = new StringBuilder(38);
                    stringBuilder.append("Unknown safe parcelable id=");
                    stringBuilder.append(zzane);
                    throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }

    @Hide
    public static final class zze extends zzbhs implements Organizations {
        public static final Creator<zze> CREATOR = new zzcwv();
        private static final HashMap<String, zzbhq<?, ?>> zzejp;
        private String mName;
        private String zzdxh;
        private int zzehz;
        private Set<Integer> zzejq;
        private int zzenu;
        private String zzesj;
        private String zzkjp;
        private String zzkjq;
        private String zzkjr;
        private boolean zzkjs;
        private String zzkjt;

        static {
            HashMap hashMap = new HashMap();
            zzejp = hashMap;
            hashMap.put("department", zzbhq.zzl("department", 2));
            zzejp.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, zzbhq.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 3));
            zzejp.put("endDate", zzbhq.zzl("endDate", 4));
            zzejp.put(b.LOCATION, zzbhq.zzl(b.LOCATION, 5));
            zzejp.put("name", zzbhq.zzl("name", 6));
            zzejp.put("primary", zzbhq.zzk("primary", 7));
            zzejp.put("startDate", zzbhq.zzl("startDate", 8));
            zzejp.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, zzbhq.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 9));
            zzejp.put(Param.TYPE, zzbhq.zza(Param.TYPE, 10, new zzbhl().zzi("work", 0).zzi("school", 1), false));
        }

        public zze() {
            this.zzehz = 1;
            this.zzejq = new HashSet();
        }

        zze(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, int i2) {
            this.zzejq = set;
            this.zzehz = i;
            this.zzkjp = str;
            this.zzdxh = str2;
            this.zzkjq = str3;
            this.zzkjr = str4;
            this.mName = str5;
            this.zzkjs = z;
            this.zzkjt = str6;
            this.zzesj = str7;
            this.zzenu = i2;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zze)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zze zze = (zze) obj;
            for (zzbhq zzbhq : zzejp.values()) {
                if (zza(zzbhq)) {
                    if (!zze.zza(zzbhq) || !zzb(zzbhq).equals(zze.zzb(zzbhq))) {
                        return false;
                    }
                } else if (zze.zza(zzbhq)) {
                    return false;
                }
            }
            return true;
        }

        public final /* bridge */ /* synthetic */ Object freeze() {
            if (this != null) {
                return this;
            }
            throw null;
        }

        public final String getDepartment() {
            return this.zzkjp;
        }

        public final String getDescription() {
            return this.zzdxh;
        }

        public final String getEndDate() {
            return this.zzkjq;
        }

        public final String getLocation() {
            return this.zzkjr;
        }

        public final String getName() {
            return this.mName;
        }

        public final String getStartDate() {
            return this.zzkjt;
        }

        public final String getTitle() {
            return this.zzesj;
        }

        public final int getType() {
            return this.zzenu;
        }

        public final boolean hasDepartment() {
            return this.zzejq.contains(Integer.valueOf(2));
        }

        public final boolean hasDescription() {
            return this.zzejq.contains(Integer.valueOf(3));
        }

        public final boolean hasEndDate() {
            return this.zzejq.contains(Integer.valueOf(4));
        }

        public final boolean hasLocation() {
            return this.zzejq.contains(Integer.valueOf(5));
        }

        public final boolean hasName() {
            return this.zzejq.contains(Integer.valueOf(6));
        }

        public final boolean hasPrimary() {
            return this.zzejq.contains(Integer.valueOf(7));
        }

        public final boolean hasStartDate() {
            return this.zzejq.contains(Integer.valueOf(8));
        }

        public final boolean hasTitle() {
            return this.zzejq.contains(Integer.valueOf(9));
        }

        public final boolean hasType() {
            return this.zzejq.contains(Integer.valueOf(10));
        }

        public final int hashCode() {
            int i = 0;
            for (zzbhq zzbhq : zzejp.values()) {
                if (zza(zzbhq)) {
                    i = (i + zzbhq.zzane()) + zzb(zzbhq).hashCode();
                }
            }
            return i;
        }

        public final boolean isDataValid() {
            return true;
        }

        public final boolean isPrimary() {
            return this.zzkjs;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            i = zzbgo.zze(parcel);
            Set set = this.zzejq;
            if (set.contains(Integer.valueOf(1))) {
                zzbgo.zzc(parcel, 1, this.zzehz);
            }
            if (set.contains(Integer.valueOf(2))) {
                zzbgo.zza(parcel, 2, this.zzkjp, true);
            }
            if (set.contains(Integer.valueOf(3))) {
                zzbgo.zza(parcel, 3, this.zzdxh, true);
            }
            if (set.contains(Integer.valueOf(4))) {
                zzbgo.zza(parcel, 4, this.zzkjq, true);
            }
            if (set.contains(Integer.valueOf(5))) {
                zzbgo.zza(parcel, 5, this.zzkjr, true);
            }
            if (set.contains(Integer.valueOf(6))) {
                zzbgo.zza(parcel, 6, this.mName, true);
            }
            if (set.contains(Integer.valueOf(7))) {
                zzbgo.zza(parcel, 7, this.zzkjs);
            }
            if (set.contains(Integer.valueOf(8))) {
                zzbgo.zza(parcel, 8, this.zzkjt, true);
            }
            if (set.contains(Integer.valueOf(9))) {
                zzbgo.zza(parcel, 9, this.zzesj, true);
            }
            if (set.contains(Integer.valueOf(10))) {
                zzbgo.zzc(parcel, 10, this.zzenu);
            }
            zzbgo.zzai(parcel, i);
        }

        protected final boolean zza(zzbhq zzbhq) {
            return this.zzejq.contains(Integer.valueOf(zzbhq.zzane()));
        }

        public final /* synthetic */ Map zzabz() {
            return zzejp;
        }

        protected final Object zzb(zzbhq zzbhq) {
            switch (zzbhq.zzane()) {
                case 2:
                    return this.zzkjp;
                case 3:
                    return this.zzdxh;
                case 4:
                    return this.zzkjq;
                case 5:
                    return this.zzkjr;
                case 6:
                    return this.mName;
                case 7:
                    return Boolean.valueOf(this.zzkjs);
                case 8:
                    return this.zzkjt;
                case 9:
                    return this.zzesj;
                case 10:
                    return Integer.valueOf(this.zzenu);
                default:
                    int zzane = zzbhq.zzane();
                    StringBuilder stringBuilder = new StringBuilder(38);
                    stringBuilder.append("Unknown safe parcelable id=");
                    stringBuilder.append(zzane);
                    throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }

    @Hide
    public static final class zzf extends zzbhs implements PlacesLived {
        public static final Creator<zzf> CREATOR = new zzcww();
        private static final HashMap<String, zzbhq<?, ?>> zzejp;
        private String mValue;
        private int zzehz;
        private Set<Integer> zzejq;
        private boolean zzkjs;

        static {
            HashMap hashMap = new HashMap();
            zzejp = hashMap;
            hashMap.put("primary", zzbhq.zzk("primary", 2));
            zzejp.put(b.VALUE, zzbhq.zzl(b.VALUE, 3));
        }

        public zzf() {
            this.zzehz = 1;
            this.zzejq = new HashSet();
        }

        zzf(Set<Integer> set, int i, boolean z, String str) {
            this.zzejq = set;
            this.zzehz = i;
            this.zzkjs = z;
            this.mValue = str;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zzf)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzf zzf = (zzf) obj;
            for (zzbhq zzbhq : zzejp.values()) {
                if (zza(zzbhq)) {
                    if (!zzf.zza(zzbhq) || !zzb(zzbhq).equals(zzf.zzb(zzbhq))) {
                        return false;
                    }
                } else if (zzf.zza(zzbhq)) {
                    return false;
                }
            }
            return true;
        }

        public final /* bridge */ /* synthetic */ Object freeze() {
            if (this != null) {
                return this;
            }
            throw null;
        }

        public final String getValue() {
            return this.mValue;
        }

        public final boolean hasPrimary() {
            return this.zzejq.contains(Integer.valueOf(2));
        }

        public final boolean hasValue() {
            return this.zzejq.contains(Integer.valueOf(3));
        }

        public final int hashCode() {
            int i = 0;
            for (zzbhq zzbhq : zzejp.values()) {
                if (zza(zzbhq)) {
                    i = (i + zzbhq.zzane()) + zzb(zzbhq).hashCode();
                }
            }
            return i;
        }

        public final boolean isDataValid() {
            return true;
        }

        public final boolean isPrimary() {
            return this.zzkjs;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            i = zzbgo.zze(parcel);
            Set set = this.zzejq;
            if (set.contains(Integer.valueOf(1))) {
                zzbgo.zzc(parcel, 1, this.zzehz);
            }
            if (set.contains(Integer.valueOf(2))) {
                zzbgo.zza(parcel, 2, this.zzkjs);
            }
            if (set.contains(Integer.valueOf(3))) {
                zzbgo.zza(parcel, 3, this.mValue, true);
            }
            zzbgo.zzai(parcel, i);
        }

        protected final boolean zza(zzbhq zzbhq) {
            return this.zzejq.contains(Integer.valueOf(zzbhq.zzane()));
        }

        public final /* synthetic */ Map zzabz() {
            return zzejp;
        }

        protected final Object zzb(zzbhq zzbhq) {
            switch (zzbhq.zzane()) {
                case 2:
                    return Boolean.valueOf(this.zzkjs);
                case 3:
                    return this.mValue;
                default:
                    int zzane = zzbhq.zzane();
                    StringBuilder stringBuilder = new StringBuilder(38);
                    stringBuilder.append("Unknown safe parcelable id=");
                    stringBuilder.append(zzane);
                    throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }

    @Hide
    public static final class zzg extends zzbhs implements Urls {
        public static final Creator<zzg> CREATOR = new zzcwx();
        private static final HashMap<String, zzbhq<?, ?>> zzejp;
        private String mValue;
        private String zzdxf;
        private int zzehz;
        private Set<Integer> zzejq;
        private int zzenu;
        private final int zzkju;

        static {
            HashMap hashMap = new HashMap();
            zzejp = hashMap;
            hashMap.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, zzbhq.zzl(PlusShare.KEY_CALL_TO_ACTION_LABEL, 5));
            zzejp.put(Param.TYPE, zzbhq.zza(Param.TYPE, 6, new zzbhl().zzi("home", 0).zzi("work", 1).zzi("blog", 2).zzi(Scopes.PROFILE, 3).zzi("other", 4).zzi("otherProfile", 5).zzi("contributor", 6).zzi("website", 7), false));
            zzejp.put(b.VALUE, zzbhq.zzl(b.VALUE, 4));
        }

        public zzg() {
            this.zzkju = 4;
            this.zzehz = 1;
            this.zzejq = new HashSet();
        }

        zzg(Set<Integer> set, int i, String str, int i2, String str2, int i3) {
            this.zzkju = 4;
            this.zzejq = set;
            this.zzehz = i;
            this.zzdxf = str;
            this.zzenu = i2;
            this.mValue = str2;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zzg)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzg zzg = (zzg) obj;
            for (zzbhq zzbhq : zzejp.values()) {
                if (zza(zzbhq)) {
                    if (!zzg.zza(zzbhq) || !zzb(zzbhq).equals(zzg.zzb(zzbhq))) {
                        return false;
                    }
                } else if (zzg.zza(zzbhq)) {
                    return false;
                }
            }
            return true;
        }

        public final /* bridge */ /* synthetic */ Object freeze() {
            if (this != null) {
                return this;
            }
            throw null;
        }

        public final String getLabel() {
            return this.zzdxf;
        }

        public final int getType() {
            return this.zzenu;
        }

        public final String getValue() {
            return this.mValue;
        }

        public final boolean hasLabel() {
            return this.zzejq.contains(Integer.valueOf(5));
        }

        public final boolean hasType() {
            return this.zzejq.contains(Integer.valueOf(6));
        }

        public final boolean hasValue() {
            return this.zzejq.contains(Integer.valueOf(4));
        }

        public final int hashCode() {
            int i = 0;
            for (zzbhq zzbhq : zzejp.values()) {
                if (zza(zzbhq)) {
                    i = (i + zzbhq.zzane()) + zzb(zzbhq).hashCode();
                }
            }
            return i;
        }

        public final boolean isDataValid() {
            return true;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            i = zzbgo.zze(parcel);
            Set set = this.zzejq;
            if (set.contains(Integer.valueOf(1))) {
                zzbgo.zzc(parcel, 1, this.zzehz);
            }
            if (set.contains(Integer.valueOf(3))) {
                zzbgo.zzc(parcel, 3, 4);
            }
            if (set.contains(Integer.valueOf(4))) {
                zzbgo.zza(parcel, 4, this.mValue, true);
            }
            if (set.contains(Integer.valueOf(5))) {
                zzbgo.zza(parcel, 5, this.zzdxf, true);
            }
            if (set.contains(Integer.valueOf(6))) {
                zzbgo.zzc(parcel, 6, this.zzenu);
            }
            zzbgo.zzai(parcel, i);
        }

        protected final boolean zza(zzbhq zzbhq) {
            return this.zzejq.contains(Integer.valueOf(zzbhq.zzane()));
        }

        public final /* synthetic */ Map zzabz() {
            return zzejp;
        }

        protected final Object zzb(zzbhq zzbhq) {
            switch (zzbhq.zzane()) {
                case 4:
                    return this.mValue;
                case 5:
                    return this.zzdxf;
                case 6:
                    return Integer.valueOf(this.zzenu);
                default:
                    int zzane = zzbhq.zzane();
                    StringBuilder stringBuilder = new StringBuilder(38);
                    stringBuilder.append("Unknown safe parcelable id=");
                    stringBuilder.append(zzane);
                    throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        zzejp = hashMap;
        hashMap.put("aboutMe", zzbhq.zzl("aboutMe", 2));
        zzejp.put("ageRange", zzbhq.zza("ageRange", 3, zza.class));
        zzejp.put("birthday", zzbhq.zzl("birthday", 4));
        zzejp.put("braggingRights", zzbhq.zzl("braggingRights", 5));
        zzejp.put("circledByCount", zzbhq.zzj("circledByCount", 6));
        zzejp.put("cover", zzbhq.zza("cover", 7, zzb.class));
        zzejp.put("currentLocation", zzbhq.zzl("currentLocation", 8));
        zzejp.put("displayName", zzbhq.zzl("displayName", 9));
        zzejp.put("gender", zzbhq.zza("gender", 12, new zzbhl().zzi("male", 0).zzi("female", 1).zzi("other", 2), false));
        zzejp.put("id", zzbhq.zzl("id", 14));
        zzejp.put("image", zzbhq.zza("image", 15, zzc.class));
        zzejp.put("isPlusUser", zzbhq.zzk("isPlusUser", 16));
        zzejp.put("language", zzbhq.zzl("language", 18));
        zzejp.put("name", zzbhq.zza("name", 19, zzd.class));
        zzejp.put("nickname", zzbhq.zzl("nickname", 20));
        zzejp.put("objectType", zzbhq.zza("objectType", 21, new zzbhl().zzi("person", 0).zzi("page", 1), false));
        zzejp.put("organizations", zzbhq.zzb("organizations", 22, zze.class));
        zzejp.put("placesLived", zzbhq.zzb("placesLived", 23, zzf.class));
        zzejp.put("plusOneCount", zzbhq.zzj("plusOneCount", 24));
        zzejp.put("relationshipStatus", zzbhq.zza("relationshipStatus", 25, new zzbhl().zzi("single", 0).zzi("in_a_relationship", 1).zzi("engaged", 2).zzi("married", 3).zzi("its_complicated", 4).zzi("open_relationship", 5).zzi("widowed", 6).zzi("in_domestic_partnership", 7).zzi("in_civil_union", 8), false));
        zzejp.put("tagline", zzbhq.zzl("tagline", 26));
        zzejp.put(PlusShare.KEY_CALL_TO_ACTION_URL, zzbhq.zzl(PlusShare.KEY_CALL_TO_ACTION_URL, 27));
        zzejp.put("urls", zzbhq.zzb("urls", 28, zzg.class));
        zzejp.put("verified", zzbhq.zzk("verified", 29));
    }

    public zzcwn() {
        this.zzehz = 1;
        this.zzejq = new HashSet();
    }

    public zzcwn(String str, String str2, zzc zzc, int i, String str3) {
        this.zzehz = 1;
        this.zzejq = new HashSet();
        this.zzemi = str;
        this.zzejq.add(Integer.valueOf(9));
        this.zzbzd = str2;
        this.zzejq.add(Integer.valueOf(14));
        this.zzkis = zzc;
        this.zzejq.add(Integer.valueOf(15));
        this.zzkiw = i;
        this.zzejq.add(Integer.valueOf(21));
        this.zzag = str3;
        this.zzejq.add(Integer.valueOf(27));
    }

    zzcwn(Set<Integer> set, int i, String str, zza zza, String str2, String str3, int i2, zzb zzb, String str4, String str5, int i3, String str6, zzc zzc, boolean z, String str7, zzd zzd, String str8, int i4, List<zze> list, List<zzf> list2, int i5, int i6, String str9, String str10, List<zzg> list3, boolean z2) {
        this.zzejq = set;
        this.zzehz = i;
        this.zzkil = str;
        this.zzkim = zza;
        this.zzkin = str2;
        this.zzkio = str3;
        this.zzkip = i2;
        this.zzkiq = zzb;
        this.zzkir = str4;
        this.zzemi = str5;
        this.zzbhm = i3;
        this.zzbzd = str6;
        this.zzkis = zzc;
        this.zzkit = z;
        this.zzdxa = str7;
        this.zzkiu = zzd;
        this.zzkiv = str8;
        this.zzkiw = i4;
        this.zzkix = list;
        this.zzkiy = list2;
        this.zzkiz = i5;
        this.zzkja = i6;
        this.zzkjb = str9;
        this.zzag = str10;
        this.zzkjc = list3;
        this.zzkjd = z2;
    }

    public static zzcwn zzx(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        zzcwn zzcwn = (zzcwn) CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return zzcwn;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzcwn)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zzcwn zzcwn = (zzcwn) obj;
        for (zzbhq zzbhq : zzejp.values()) {
            if (zza(zzbhq)) {
                if (!zzcwn.zza(zzbhq) || !zzb(zzbhq).equals(zzcwn.zzb(zzbhq))) {
                    return false;
                }
            } else if (zzcwn.zza(zzbhq)) {
                return false;
            }
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        if (this != null) {
            return this;
        }
        throw null;
    }

    public final String getAboutMe() {
        return this.zzkil;
    }

    public final AgeRange getAgeRange() {
        return this.zzkim;
    }

    public final String getBirthday() {
        return this.zzkin;
    }

    public final String getBraggingRights() {
        return this.zzkio;
    }

    public final int getCircledByCount() {
        return this.zzkip;
    }

    public final Cover getCover() {
        return this.zzkiq;
    }

    public final String getCurrentLocation() {
        return this.zzkir;
    }

    public final String getDisplayName() {
        return this.zzemi;
    }

    public final int getGender() {
        return this.zzbhm;
    }

    public final String getId() {
        return this.zzbzd;
    }

    public final Image getImage() {
        return this.zzkis;
    }

    public final String getLanguage() {
        return this.zzdxa;
    }

    public final Name getName() {
        return this.zzkiu;
    }

    public final String getNickname() {
        return this.zzkiv;
    }

    public final int getObjectType() {
        return this.zzkiw;
    }

    public final List<Organizations> getOrganizations() {
        return (ArrayList) this.zzkix;
    }

    public final List<PlacesLived> getPlacesLived() {
        return (ArrayList) this.zzkiy;
    }

    public final int getPlusOneCount() {
        return this.zzkiz;
    }

    public final int getRelationshipStatus() {
        return this.zzkja;
    }

    public final String getTagline() {
        return this.zzkjb;
    }

    public final String getUrl() {
        return this.zzag;
    }

    public final List<Urls> getUrls() {
        return (ArrayList) this.zzkjc;
    }

    public final boolean hasAboutMe() {
        return this.zzejq.contains(Integer.valueOf(2));
    }

    public final boolean hasAgeRange() {
        return this.zzejq.contains(Integer.valueOf(3));
    }

    public final boolean hasBirthday() {
        return this.zzejq.contains(Integer.valueOf(4));
    }

    public final boolean hasBraggingRights() {
        return this.zzejq.contains(Integer.valueOf(5));
    }

    public final boolean hasCircledByCount() {
        return this.zzejq.contains(Integer.valueOf(6));
    }

    public final boolean hasCover() {
        return this.zzejq.contains(Integer.valueOf(7));
    }

    public final boolean hasCurrentLocation() {
        return this.zzejq.contains(Integer.valueOf(8));
    }

    public final boolean hasDisplayName() {
        return this.zzejq.contains(Integer.valueOf(9));
    }

    public final boolean hasGender() {
        return this.zzejq.contains(Integer.valueOf(12));
    }

    public final boolean hasId() {
        return this.zzejq.contains(Integer.valueOf(14));
    }

    public final boolean hasImage() {
        return this.zzejq.contains(Integer.valueOf(15));
    }

    public final boolean hasIsPlusUser() {
        return this.zzejq.contains(Integer.valueOf(16));
    }

    public final boolean hasLanguage() {
        return this.zzejq.contains(Integer.valueOf(18));
    }

    public final boolean hasName() {
        return this.zzejq.contains(Integer.valueOf(19));
    }

    public final boolean hasNickname() {
        return this.zzejq.contains(Integer.valueOf(20));
    }

    public final boolean hasObjectType() {
        return this.zzejq.contains(Integer.valueOf(21));
    }

    public final boolean hasOrganizations() {
        return this.zzejq.contains(Integer.valueOf(22));
    }

    public final boolean hasPlacesLived() {
        return this.zzejq.contains(Integer.valueOf(23));
    }

    public final boolean hasPlusOneCount() {
        return this.zzejq.contains(Integer.valueOf(24));
    }

    public final boolean hasRelationshipStatus() {
        return this.zzejq.contains(Integer.valueOf(25));
    }

    public final boolean hasTagline() {
        return this.zzejq.contains(Integer.valueOf(26));
    }

    public final boolean hasUrl() {
        return this.zzejq.contains(Integer.valueOf(27));
    }

    public final boolean hasUrls() {
        return this.zzejq.contains(Integer.valueOf(28));
    }

    public final boolean hasVerified() {
        return this.zzejq.contains(Integer.valueOf(29));
    }

    public final int hashCode() {
        int i = 0;
        for (zzbhq zzbhq : zzejp.values()) {
            if (zza(zzbhq)) {
                i = (i + zzbhq.zzane()) + zzb(zzbhq).hashCode();
            }
        }
        return i;
    }

    public final boolean isDataValid() {
        return true;
    }

    public final boolean isPlusUser() {
        return this.zzkit;
    }

    public final boolean isVerified() {
        return this.zzkjd;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        Set set = this.zzejq;
        if (set.contains(Integer.valueOf(1))) {
            zzbgo.zzc(parcel, 1, this.zzehz);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzbgo.zza(parcel, 2, this.zzkil, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzbgo.zza(parcel, 3, this.zzkim, i, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzbgo.zza(parcel, 4, this.zzkin, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzbgo.zza(parcel, 5, this.zzkio, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzbgo.zzc(parcel, 6, this.zzkip);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzbgo.zza(parcel, 7, this.zzkiq, i, true);
        }
        if (set.contains(Integer.valueOf(8))) {
            zzbgo.zza(parcel, 8, this.zzkir, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            zzbgo.zza(parcel, 9, this.zzemi, true);
        }
        if (set.contains(Integer.valueOf(12))) {
            zzbgo.zzc(parcel, 12, this.zzbhm);
        }
        if (set.contains(Integer.valueOf(14))) {
            zzbgo.zza(parcel, 14, this.zzbzd, true);
        }
        if (set.contains(Integer.valueOf(15))) {
            zzbgo.zza(parcel, 15, this.zzkis, i, true);
        }
        if (set.contains(Integer.valueOf(16))) {
            zzbgo.zza(parcel, 16, this.zzkit);
        }
        if (set.contains(Integer.valueOf(18))) {
            zzbgo.zza(parcel, 18, this.zzdxa, true);
        }
        if (set.contains(Integer.valueOf(19))) {
            zzbgo.zza(parcel, 19, this.zzkiu, i, true);
        }
        if (set.contains(Integer.valueOf(20))) {
            zzbgo.zza(parcel, 20, this.zzkiv, true);
        }
        if (set.contains(Integer.valueOf(21))) {
            zzbgo.zzc(parcel, 21, this.zzkiw);
        }
        if (set.contains(Integer.valueOf(22))) {
            zzbgo.zzc(parcel, 22, this.zzkix, true);
        }
        if (set.contains(Integer.valueOf(23))) {
            zzbgo.zzc(parcel, 23, this.zzkiy, true);
        }
        if (set.contains(Integer.valueOf(24))) {
            zzbgo.zzc(parcel, 24, this.zzkiz);
        }
        if (set.contains(Integer.valueOf(25))) {
            zzbgo.zzc(parcel, 25, this.zzkja);
        }
        if (set.contains(Integer.valueOf(26))) {
            zzbgo.zza(parcel, 26, this.zzkjb, true);
        }
        if (set.contains(Integer.valueOf(27))) {
            zzbgo.zza(parcel, 27, this.zzag, true);
        }
        if (set.contains(Integer.valueOf(28))) {
            zzbgo.zzc(parcel, 28, this.zzkjc, true);
        }
        if (set.contains(Integer.valueOf(29))) {
            zzbgo.zza(parcel, 29, this.zzkjd);
        }
        zzbgo.zzai(parcel, zze);
    }

    protected final boolean zza(zzbhq zzbhq) {
        return this.zzejq.contains(Integer.valueOf(zzbhq.zzane()));
    }

    public final /* synthetic */ Map zzabz() {
        return zzejp;
    }

    protected final Object zzb(zzbhq zzbhq) {
        switch (zzbhq.zzane()) {
            case 2:
                return this.zzkil;
            case 3:
                return this.zzkim;
            case 4:
                return this.zzkin;
            case 5:
                return this.zzkio;
            case 6:
                return Integer.valueOf(this.zzkip);
            case 7:
                return this.zzkiq;
            case 8:
                return this.zzkir;
            case 9:
                return this.zzemi;
            case 12:
                return Integer.valueOf(this.zzbhm);
            case 14:
                return this.zzbzd;
            case 15:
                return this.zzkis;
            case 16:
                return Boolean.valueOf(this.zzkit);
            case 18:
                return this.zzdxa;
            case 19:
                return this.zzkiu;
            case 20:
                return this.zzkiv;
            case 21:
                return Integer.valueOf(this.zzkiw);
            case 22:
                return this.zzkix;
            case 23:
                return this.zzkiy;
            case 24:
                return Integer.valueOf(this.zzkiz);
            case 25:
                return Integer.valueOf(this.zzkja);
            case 26:
                return this.zzkjb;
            case 27:
                return this.zzag;
            case 28:
                return this.zzkjc;
            case 29:
                return Boolean.valueOf(this.zzkjd);
            default:
                int zzane = zzbhq.zzane();
                StringBuilder stringBuilder = new StringBuilder(38);
                stringBuilder.append("Unknown safe parcelable id=");
                stringBuilder.append(zzane);
                throw new IllegalStateException(stringBuilder.toString());
        }
    }
}
