package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

@Hide
public final class PasswordSpecification extends zzbgl implements ReflectedParcelable {
    public static final Creator<PasswordSpecification> CREATOR = new zzj();
    public static final PasswordSpecification zzeli = new zza().zzj(12, 16).zzey("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789").zze("abcdefghijkmnopqrstxyz", 1).zze("ABCDEFGHJKLMNPQRSTXY", 1).zze("3456789", 1).zzaca();
    private static PasswordSpecification zzelj = new zza().zzj(12, 16).zzey("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890").zze("abcdefghijklmnopqrstuvwxyz", 1).zze("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1).zze("1234567890", 1).zzaca();
    private final Random zzbje;
    @VisibleForTesting
    private String zzelk;
    @VisibleForTesting
    private List<String> zzell;
    @VisibleForTesting
    private List<Integer> zzelm;
    @VisibleForTesting
    private int zzeln;
    @VisibleForTesting
    private int zzelo;
    private final int[] zzelp;

    public static class zza {
        private final List<String> zzell = new ArrayList();
        private final List<Integer> zzelm = new ArrayList();
        private int zzeln = 12;
        private int zzelo = 16;
        private final TreeSet<Character> zzelq = new TreeSet();

        private static TreeSet<Character> zzn(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                throw new zzb(String.valueOf(str2).concat(" cannot be null or empty"));
            }
            TreeSet<Character> treeSet = new TreeSet();
            for (char c : str.toCharArray()) {
                if (PasswordSpecification.zzc(c, 32, 126)) {
                    throw new zzb(String.valueOf(str2).concat(" must only contain ASCII printable characters"));
                }
                treeSet.add(Character.valueOf(c));
            }
            return treeSet;
        }

        public final PasswordSpecification zzaca() {
            if (this.zzelq.isEmpty()) {
                throw new zzb("no allowed characters specified");
            }
            int i = 0;
            for (Integer intValue : this.zzelm) {
                i += intValue.intValue();
            }
            if (i > this.zzelo) {
                throw new zzb("required character count cannot be greater than the max password size");
            }
            boolean[] zArr = new boolean[95];
            for (String toCharArray : this.zzell) {
                for (char c : toCharArray.toCharArray()) {
                    int i2 = c - 32;
                    if (zArr[i2]) {
                        StringBuilder stringBuilder = new StringBuilder(58);
                        stringBuilder.append("character ");
                        stringBuilder.append(c);
                        stringBuilder.append(" occurs in more than one required character set");
                        throw new zzb(stringBuilder.toString());
                    }
                    zArr[i2] = true;
                }
            }
            return new PasswordSpecification(PasswordSpecification.zzb(this.zzelq), this.zzell, this.zzelm, this.zzeln, this.zzelo);
        }

        public final zza zze(@NonNull String str, int i) {
            this.zzell.add(PasswordSpecification.zzb(zzn(str, "requiredChars")));
            this.zzelm.add(Integer.valueOf(1));
            return this;
        }

        public final zza zzey(@NonNull String str) {
            this.zzelq.addAll(zzn(str, "allowedChars"));
            return this;
        }

        public final zza zzj(int i, int i2) {
            this.zzeln = 12;
            this.zzelo = 16;
            return this;
        }
    }

    public static class zzb extends Error {
        public zzb(String str) {
            super(str);
        }
    }

    PasswordSpecification(String str, List<String> list, List<Integer> list2, int i, int i2) {
        this.zzelk = str;
        this.zzell = Collections.unmodifiableList(list);
        this.zzelm = Collections.unmodifiableList(list2);
        this.zzeln = i;
        this.zzelo = i2;
        int[] iArr = new int[95];
        Arrays.fill(iArr, -1);
        i = 0;
        for (String toCharArray : this.zzell) {
            for (char c : toCharArray.toCharArray()) {
                iArr[c - 32] = i;
            }
            i++;
        }
        this.zzelp = iArr;
        this.zzbje = new SecureRandom();
    }

    private static String zzb(Collection<Character> collection) {
        char[] cArr = new char[collection.size()];
        int i = 0;
        for (Character charValue : collection) {
            int i2 = i + 1;
            cArr[i] = charValue.charValue();
            i = i2;
        }
        return new String(cArr);
    }

    private static boolean zzc(int i, int i2, int i3) {
        return i < 32 || i > 126;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 1, this.zzelk, false);
        zzbgo.zzb(parcel, 2, this.zzell, false);
        zzbgo.zza(parcel, 3, this.zzelm, false);
        zzbgo.zzc(parcel, 4, this.zzeln);
        zzbgo.zzc(parcel, 5, this.zzelo);
        zzbgo.zzai(parcel, i);
    }
}
