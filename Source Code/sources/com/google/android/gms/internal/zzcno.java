package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.measurement.AppMeasurement.Event;
import com.google.android.gms.measurement.AppMeasurement.UserProperty;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.security.auth.x500.X500Principal;

public final class zzcno extends zzcli {
    private static String[] zzjsm = new String[]{"firebase_"};
    private SecureRandom zzjsn;
    private final AtomicLong zzjso = new AtomicLong(0);
    private int zzjsp;

    zzcno(zzckj zzckj) {
        super(zzckj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    private final int zza(java.lang.String r9, java.lang.Object r10, boolean r11) {
        /*
        r8 = this;
        r0 = 0;
        if (r11 == 0) goto L_0x0035;
    L_0x0003:
        r1 = "param";
        r2 = r10 instanceof android.os.Parcelable[];
        r3 = 1;
        if (r2 == 0) goto L_0x000f;
    L_0x000a:
        r2 = r10;
        r2 = (android.os.Parcelable[]) r2;
        r2 = r2.length;
        goto L_0x001a;
    L_0x000f:
        r2 = r10 instanceof java.util.ArrayList;
        if (r2 == 0) goto L_0x0030;
    L_0x0013:
        r2 = r10;
        r2 = (java.util.ArrayList) r2;
        r2 = r2.size();
    L_0x001a:
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        if (r2 <= r4) goto L_0x0030;
    L_0x001e:
        r3 = r8.zzayp();
        r3 = r3.zzbaw();
        r4 = "Parameter array is too long; discarded. Value kind, name, array length";
        r2 = java.lang.Integer.valueOf(r2);
        r3.zzd(r4, r1, r9, r2);
        r3 = 0;
    L_0x0030:
        if (r3 != 0) goto L_0x0035;
    L_0x0032:
        r9 = 17;
        return r9;
    L_0x0035:
        r1 = zzkp(r9);
        if (r1 == 0) goto L_0x0048;
    L_0x003b:
        r3 = "param";
        r5 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        r2 = r8;
        r4 = r9;
        r6 = r10;
        r7 = r11;
        r9 = r2.zza(r3, r4, r5, r6, r7);
        goto L_0x0054;
    L_0x0048:
        r2 = "param";
        r4 = 100;
        r1 = r8;
        r3 = r9;
        r5 = r10;
        r6 = r11;
        r9 = r1.zza(r2, r3, r4, r5, r6);
    L_0x0054:
        if (r9 == 0) goto L_0x0057;
    L_0x0056:
        return r0;
    L_0x0057:
        r9 = 4;
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcno.zza(java.lang.String, java.lang.Object, boolean):int");
    }

    public static zzcoc zza(zzcob zzcob, String str) {
        for (zzcoc zzcoc : zzcob.zzjui) {
            if (zzcoc.name.equals(str)) {
                return zzcoc;
            }
        }
        return null;
    }

    private static Object zza(int i, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (!(obj instanceof Boolean)) {
            return obj instanceof Float ? Double.valueOf(((Float) obj).doubleValue()) : ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) ? zza(String.valueOf(obj), i, z) : null;
        } else {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        }
    }

    public static String zza(String str, int i, boolean z) {
        if (str.codePointCount(0, str.length()) > i) {
            if (z) {
                return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
            }
            str = null;
        }
        return str;
    }

    @Nullable
    public static String zza(String str, String[] strArr, String[] strArr2) {
        zzbq.checkNotNull(strArr);
        zzbq.checkNotNull(strArr2);
        int min = Math.min(strArr.length, strArr2.length);
        for (int i = 0; i < min; i++) {
            if (zzas(str, strArr[i])) {
                return strArr2[i];
            }
        }
        return null;
    }

    private final boolean zza(String str, String str2, int i, Object obj, boolean z) {
        if (obj == null || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            return true;
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            String valueOf = String.valueOf(obj);
            if (valueOf.codePointCount(0, valueOf.length()) > i) {
                zzayp().zzbaw().zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
                return false;
            }
            return true;
        } else if ((obj instanceof Bundle) && z) {
            return true;
        } else {
            int length;
            Object obj2;
            if ((obj instanceof Parcelable[]) && z) {
                Parcelable[] parcelableArr = (Parcelable[]) obj;
                length = parcelableArr.length;
                i = 0;
                while (i < length) {
                    obj2 = parcelableArr[i];
                    if (obj2 instanceof Bundle) {
                        i++;
                    } else {
                        zzayp().zzbaw().zze("All Parcelable[] elements must be of type Bundle. Value type, name", obj2.getClass(), str2);
                        return false;
                    }
                }
                return true;
            } else if (!(obj instanceof ArrayList) || !z) {
                return false;
            } else {
                ArrayList arrayList = (ArrayList) obj;
                length = arrayList.size();
                i = 0;
                while (i < length) {
                    obj2 = arrayList.get(i);
                    i++;
                    if (!(obj2 instanceof Bundle)) {
                        zzayp().zzbaw().zze("All ArrayList elements must be of type Bundle. Value type, name", obj2.getClass(), str2);
                        return false;
                    }
                }
                return true;
            }
        }
    }

    public static boolean zza(long[] jArr, int i) {
        return i < (jArr.length << 6) && (jArr[i / 64] & (1 << (i % 64))) != 0;
    }

    static byte[] zza(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            return marshall;
        } finally {
            obtain.recycle();
        }
    }

    public static long[] zza(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i << 6) + i2;
                if (i3 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i3)) {
                    jArr[i] = jArr[i] | (1 << i2);
                }
            }
        }
        return jArr;
    }

    static zzcoc[] zza(zzcoc[] zzcocArr, String str, Object obj) {
        for (zzcoc zzcoc : zzcocArr) {
            if (str.equals(zzcoc.name)) {
                zzcoc.zzjum = null;
                zzcoc.zzgim = null;
                zzcoc.zzjsl = null;
                if (obj instanceof Long) {
                    zzcoc.zzjum = (Long) obj;
                    return zzcocArr;
                } else if (obj instanceof String) {
                    zzcoc.zzgim = (String) obj;
                    return zzcocArr;
                } else {
                    if (obj instanceof Double) {
                        zzcoc.zzjsl = (Double) obj;
                    }
                    return zzcocArr;
                }
            }
        }
        Object obj2 = new zzcoc[(zzcocArr.length + 1)];
        System.arraycopy(zzcocArr, 0, obj2, 0, zzcocArr.length);
        zzcoc zzcoc2 = new zzcoc();
        zzcoc2.name = str;
        if (obj instanceof Long) {
            zzcoc2.zzjum = (Long) obj;
        } else if (obj instanceof String) {
            zzcoc2.zzgim = (String) obj;
        } else if (obj instanceof Double) {
            zzcoc2.zzjsl = (Double) obj;
        }
        obj2[zzcocArr.length] = zzcoc2;
        return obj2;
    }

    private final boolean zzac(Context context, String str) {
        Object e;
        zzcjl zzbau;
        String str2;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = zzbih.zzdd(context).getPackageInfo(str, 64);
            if (!(packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0)) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
            }
        } catch (CertificateException e2) {
            e = e2;
            zzbau = zzayp().zzbau();
            str2 = "Error obtaining certificate";
            zzbau.zzj(str2, e);
            return true;
        } catch (NameNotFoundException e3) {
            e = e3;
            zzbau = zzayp().zzbau();
            str2 = "Package name not found";
            zzbau.zzj(str2, e);
            return true;
        }
        return true;
    }

    public static Bundle[] zzaf(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        }
        Object[] copyOf;
        if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            copyOf = Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        } else if (!(obj instanceof ArrayList)) {
            return null;
        } else {
            ArrayList arrayList = (ArrayList) obj;
            copyOf = arrayList.toArray(new Bundle[arrayList.size()]);
        }
        return (Bundle[]) copyOf;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0040 A:{RETURN, Splitter: B:9:0x0026, ExcHandler: java.io.IOException (unused java.io.IOException)} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037 A:{Catch:{ IOException -> 0x0040, IOException -> 0x0040 }} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c A:{Catch:{ IOException -> 0x0040, IOException -> 0x0040 }} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037 A:{Catch:{ IOException -> 0x0040, IOException -> 0x0040 }} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c A:{Catch:{ IOException -> 0x0040, IOException -> 0x0040 }} */
    /* JADX WARNING: Missing block: B:22:0x0040, code:
            return null;
     */
    public static java.lang.Object zzag(java.lang.Object r4) {
        /*
        r0 = 0;
        if (r4 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ all -> 0x0032 }
        r1.<init>();	 Catch:{ all -> 0x0032 }
        r2 = new java.io.ObjectOutputStream;	 Catch:{ all -> 0x0032 }
        r2.<init>(r1);	 Catch:{ all -> 0x0032 }
        r2.writeObject(r4);	 Catch:{ all -> 0x002f }
        r2.flush();	 Catch:{ all -> 0x002f }
        r4 = new java.io.ObjectInputStream;	 Catch:{ all -> 0x002f }
        r3 = new java.io.ByteArrayInputStream;	 Catch:{ all -> 0x002f }
        r1 = r1.toByteArray();	 Catch:{ all -> 0x002f }
        r3.<init>(r1);	 Catch:{ all -> 0x002f }
        r4.<init>(r3);	 Catch:{ all -> 0x002f }
        r1 = r4.readObject();	 Catch:{ all -> 0x002d }
        r2.close();	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
        r4.close();	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
        return r1;
    L_0x002d:
        r1 = move-exception;
        goto L_0x0035;
    L_0x002f:
        r1 = move-exception;
        r4 = r0;
        goto L_0x0035;
    L_0x0032:
        r1 = move-exception;
        r4 = r0;
        r2 = r4;
    L_0x0035:
        if (r2 == 0) goto L_0x003a;
    L_0x0037:
        r2.close();	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x003a:
        if (r4 == 0) goto L_0x003f;
    L_0x003c:
        r4.close();	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x003f:
        throw r1;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x0040:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcno.zzag(java.lang.Object):java.lang.Object");
    }

    private final boolean zzar(String str, String str2) {
        if (str2 == null) {
            zzayp().zzbau().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzayp().zzbau().zzj("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt) || codePointAt == 95) {
                int length = str2.length();
                codePointAt = Character.charCount(codePointAt);
                while (codePointAt < length) {
                    int codePointAt2 = str2.codePointAt(codePointAt);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        codePointAt += Character.charCount(codePointAt2);
                    } else {
                        zzayp().zzbau().zze("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            zzayp().zzbau().zze("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
    }

    public static boolean zzas(String str, String str2) {
        return (str == null && str2 == null) ? true : str == null ? false : str.equals(str2);
    }

    public static Object zzb(zzcob zzcob, String str) {
        zzcoc zza = zza(zzcob, str);
        if (zza != null) {
            if (zza.zzgim != null) {
                return zza.zzgim;
            }
            if (zza.zzjum != null) {
                return zza.zzjum;
            }
            if (zza.zzjsl != null) {
                return zza.zzjsl;
            }
        }
        return null;
    }

    private static void zzb(Bundle bundle, Object obj) {
        zzbq.checkNotNull(bundle);
        if (obj == null) {
            return;
        }
        if ((obj instanceof String) || (obj instanceof CharSequence)) {
            bundle.putLong("_el", (long) String.valueOf(obj).length());
        }
    }

    private static boolean zzd(Bundle bundle, int i) {
        if (bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    @WorkerThread
    static boolean zzd(zzcix zzcix, zzcif zzcif) {
        zzbq.checkNotNull(zzcix);
        zzbq.checkNotNull(zzcif);
        return !TextUtils.isEmpty(zzcif.zzjfl);
    }

    /* JADX WARNING: Missing block: B:12:0x000b, code:
            continue;
     */
    static java.security.MessageDigest zzeq(java.lang.String r2) {
        /*
        r0 = 0;
    L_0x0001:
        r1 = 2;
        if (r0 >= r1) goto L_0x000e;
    L_0x0004:
        r1 = java.security.MessageDigest.getInstance(r2);	 Catch:{ NoSuchAlgorithmException -> 0x000b }
        if (r1 == 0) goto L_0x000b;
    L_0x000a:
        return r1;
    L_0x000b:
        r0 = r0 + 1;
        goto L_0x0001;
    L_0x000e:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcno.zzeq(java.lang.String):java.security.MessageDigest");
    }

    static boolean zzkh(String str) {
        zzbq.zzgv(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    private final int zzkl(String str) {
        return !zzaq("event param", str) ? 3 : !zza("event param", null, str) ? 14 : !zzb("event param", 40, str) ? 3 : 0;
    }

    private final int zzkm(String str) {
        return !zzar("event param", str) ? 3 : !zza("event param", null, str) ? 14 : !zzb("event param", 40, str) ? 3 : 0;
    }

    private static int zzko(String str) {
        return "_ldl".equals(str) ? 2048 : "_id".equals(str) ? 256 : 36;
    }

    public static boolean zzkp(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    static boolean zzkr(String str) {
        return str != null && str.matches("(\\+|-)?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003b A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003b A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003b A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c A:{RETURN} */
    @android.support.annotation.WorkerThread
    static boolean zzku(java.lang.String r4) {
        /*
        com.google.android.gms.common.internal.zzbq.zzgv(r4);
        r0 = r4.hashCode();
        r1 = 94660; // 0x171c4 float:1.32647E-40 double:4.67683E-319;
        r2 = 0;
        r3 = 1;
        if (r0 == r1) goto L_0x002d;
    L_0x000e:
        r1 = 95025; // 0x17331 float:1.33158E-40 double:4.69486E-319;
        if (r0 == r1) goto L_0x0023;
    L_0x0013:
        r1 = 95027; // 0x17333 float:1.33161E-40 double:4.69496E-319;
        if (r0 == r1) goto L_0x0019;
    L_0x0018:
        goto L_0x0037;
    L_0x0019:
        r0 = "_ui";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x0037;
    L_0x0021:
        r4 = 1;
        goto L_0x0038;
    L_0x0023:
        r0 = "_ug";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x0037;
    L_0x002b:
        r4 = 2;
        goto L_0x0038;
    L_0x002d:
        r0 = "_in";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x0037;
    L_0x0035:
        r4 = 0;
        goto L_0x0038;
    L_0x0037:
        r4 = -1;
    L_0x0038:
        switch(r4) {
            case 0: goto L_0x003c;
            case 1: goto L_0x003c;
            case 2: goto L_0x003c;
            default: goto L_0x003b;
        };
    L_0x003b:
        return r2;
    L_0x003c:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcno.zzku(java.lang.String):boolean");
    }

    public static boolean zzn(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    public static boolean zzp(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0);
            if (serviceInfo != null && serviceInfo.enabled) {
                return true;
            }
        } catch (NameNotFoundException unused) {
            return false;
        }
    }

    static long zzt(byte[] bArr) {
        zzbq.checkNotNull(bArr);
        long j = null;
        zzbq.checkState(bArr.length > 0);
        long j2 = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j += 8;
            length--;
            j2 += (((long) bArr[length]) & 255) << j;
        }
        return j2;
    }

    public final Bundle zza(String str, Bundle bundle, @Nullable List<String> list, boolean z, boolean z2) {
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        int i = 0;
        for (String str2 : bundle.keySet()) {
            int zzkl;
            if (list == null || !list.contains(str2)) {
                zzkl = z ? zzkl(str2) : 0;
                if (zzkl == 0) {
                    zzkl = zzkm(str2);
                }
            } else {
                zzkl = 0;
            }
            if (zzkl == 0) {
                zzkl = zza(str2, bundle.get(str2), z2);
                if (zzkl == 0 || "_ev".equals(str2)) {
                    if (zzkh(str2)) {
                        i++;
                        if (i > 25) {
                            StringBuilder stringBuilder = new StringBuilder(48);
                            stringBuilder.append("Event can't contain more than 25 params");
                            zzayp().zzbau().zze(stringBuilder.toString(), zzayk().zzjp(str), zzayk().zzac(bundle));
                            zzd(bundle2, 5);
                        }
                    }
                } else if (zzd(bundle2, zzkl)) {
                    bundle2.putString("_ev", zza(str2, 40, true));
                    zzb(bundle2, bundle.get(str2));
                }
            } else if (zzd(bundle2, zzkl)) {
                bundle2.putString("_ev", zza(str2, 40, true));
                if (zzkl == 3) {
                    zzb(bundle2, (Object) str2);
                }
            }
            bundle2.remove(str2);
        }
        return bundle2;
    }

    final zzcix zza(String str, Bundle bundle, String str2, long j, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (zzki(str) != 0) {
            zzayp().zzbau().zzj("Invalid conditional property event name", zzayk().zzjr(str));
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str2);
        String str3 = str;
        return new zzcix(str3, new zzciu(zzad(zza(str3, bundle2, Collections.singletonList("_o"), false, false))), str2, j);
    }

    public final void zza(int i, String str, String str2, int i2) {
        zza(null, i, str, str2, i2);
    }

    public final void zza(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else {
                if (str != null) {
                    zzayp().zzbax().zze("Not putting event parameter. Invalid value type. name, type", zzayk().zzjq(str), obj != null ? obj.getClass().getSimpleName() : null);
                }
            }
        }
    }

    public final void zza(zzcoc zzcoc, Object obj) {
        zzbq.checkNotNull(obj);
        zzcoc.zzgim = null;
        zzcoc.zzjum = null;
        zzcoc.zzjsl = null;
        if (obj instanceof String) {
            zzcoc.zzgim = (String) obj;
        } else if (obj instanceof Long) {
            zzcoc.zzjum = (Long) obj;
        } else if (obj instanceof Double) {
            zzcoc.zzjsl = (Double) obj;
        } else {
            zzayp().zzbau().zzj("Ignoring invalid (type) event param value", obj);
        }
    }

    public final void zza(zzcog zzcog, Object obj) {
        zzbq.checkNotNull(obj);
        zzcog.zzgim = null;
        zzcog.zzjum = null;
        zzcog.zzjsl = null;
        if (obj instanceof String) {
            zzcog.zzgim = (String) obj;
        } else if (obj instanceof Long) {
            zzcog.zzjum = (Long) obj;
        } else if (obj instanceof Double) {
            zzcog.zzjsl = (Double) obj;
        } else {
            zzayp().zzbau().zzj("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public final void zza(String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        zzd(bundle, i);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", (long) i2);
        }
        this.zzjev.zzayd().zzd("auto", "_err", bundle);
    }

    final boolean zza(String str, String[] strArr, String str2) {
        if (str2 == null) {
            zzayp().zzbau().zzj("Name is required and can't be null. Type", str);
            return false;
        }
        Object obj;
        zzbq.checkNotNull(str2);
        for (String startsWith : zzjsm) {
            if (str2.startsWith(startsWith)) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj != null) {
            zzayp().zzbau().zze("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        }
        if (strArr != null) {
            Object obj2;
            zzbq.checkNotNull(strArr);
            for (String startsWith2 : strArr) {
                if (zzas(str2, startsWith2)) {
                    obj2 = 1;
                    break;
                }
            }
            obj2 = null;
            if (obj2 != null) {
                zzayp().zzbau().zze("Name is reserved. Type, name", str, str2);
                return false;
            }
        }
        return true;
    }

    @WorkerThread
    final long zzab(Context context, String str) {
        zzwj();
        zzbq.checkNotNull(context);
        zzbq.zzgv(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest zzeq = zzeq("MD5");
        if (zzeq == null) {
            zzayp().zzbau().log("Could not get MD5 instance");
            return -1;
        }
        if (packageManager != null) {
            try {
                if (!zzac(context, str)) {
                    PackageInfo packageInfo = zzbih.zzdd(context).getPackageInfo(getContext().getPackageName(), 64);
                    if (packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                        return zzt(zzeq.digest(packageInfo.signatures[0].toByteArray()));
                    }
                    zzayp().zzbaw().log("Could not get signatures");
                    return -1;
                }
            } catch (NameNotFoundException e) {
                zzayp().zzbau().zzj("Package name not found", e);
            }
        }
        return 0;
    }

    final Bundle zzad(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object zzk = zzk(str, bundle.get(str));
                if (zzk == null) {
                    zzayp().zzbaw().zzj("Param value can't be null", zzayk().zzjq(str));
                } else {
                    zza(bundle2, str, zzk);
                }
            }
        }
        return bundle2;
    }

    final boolean zzaq(String str, String str2) {
        if (str2 == null) {
            zzayp().zzbau().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzayp().zzbau().zzj("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt)) {
                int length = str2.length();
                codePointAt = Character.charCount(codePointAt);
                while (codePointAt < length) {
                    int codePointAt2 = str2.codePointAt(codePointAt);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        codePointAt += Character.charCount(codePointAt2);
                    } else {
                        zzayp().zzbau().zze("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            zzayp().zzbau().zze("Name must start with a letter. Type, name", str, str2);
            return false;
        }
    }

    protected final boolean zzazq() {
        return true;
    }

    /* JADX WARNING: Missing block: B:10:?, code:
            zzayp().zzbau().log("Failed to load parcelable from buffer");
     */
    /* JADX WARNING: Missing block: B:11:0x0029, code:
            r1.recycle();
     */
    /* JADX WARNING: Missing block: B:12:0x002c, code:
            return null;
     */
    /* JADX WARNING: Missing block: B:13:0x002d, code:
            r1.recycle();
     */
    final <T extends android.os.Parcelable> T zzb(byte[] r5, android.os.Parcelable.Creator<T> r6) {
        /*
        r4 = this;
        r0 = 0;
        if (r5 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = android.os.Parcel.obtain();
        r2 = r5.length;	 Catch:{ zzbgn -> 0x001c }
        r3 = 0;
        r1.unmarshall(r5, r3, r2);	 Catch:{ zzbgn -> 0x001c }
        r1.setDataPosition(r3);	 Catch:{ zzbgn -> 0x001c }
        r5 = r6.createFromParcel(r1);	 Catch:{ zzbgn -> 0x001c }
        r5 = (android.os.Parcelable) r5;	 Catch:{ zzbgn -> 0x001c }
        r1.recycle();
        return r5;
    L_0x001a:
        r5 = move-exception;
        goto L_0x002d;
    L_0x001c:
        r5 = r4.zzayp();	 Catch:{ all -> 0x001a }
        r5 = r5.zzbau();	 Catch:{ all -> 0x001a }
        r6 = "Failed to load parcelable from buffer";
        r5.log(r6);	 Catch:{ all -> 0x001a }
        r1.recycle();
        return r0;
    L_0x002d:
        r1.recycle();
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcno.zzb(byte[], android.os.Parcelable$Creator):T");
    }

    final boolean zzb(String str, int i, String str2) {
        if (str2 == null) {
            zzayp().zzbau().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        } else {
            zzayp().zzbau().zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    public final byte[] zzb(zzcod zzcod) {
        try {
            byte[] bArr = new byte[zzcod.zzhs()];
            zzflk zzp = zzflk.zzp(bArr, 0, bArr.length);
            zzcod.zza(zzp);
            zzp.zzcyx();
            return bArr;
        } catch (IOException e) {
            zzayp().zzbau().zzj("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    @WorkerThread
    protected final void zzbap() {
        zzwj();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                zzayp().zzbaw().log("Utils falling back to Random for random id");
            }
        }
        this.zzjso.set(nextLong);
    }

    public final long zzbcq() {
        long nextLong;
        if (this.zzjso.get() == 0) {
            long j;
            synchronized (this.zzjso) {
                nextLong = new Random(System.nanoTime() ^ zzxx().currentTimeMillis()).nextLong();
                int i = this.zzjsp + 1;
                this.zzjsp = i;
                j = nextLong + ((long) i);
            }
            return j;
        }
        synchronized (this.zzjso) {
            this.zzjso.compareAndSet(-1, 1);
            nextLong = this.zzjso.getAndIncrement();
        }
        return nextLong;
    }

    @WorkerThread
    final SecureRandom zzbcr() {
        zzwj();
        if (this.zzjsn == null) {
            this.zzjsn = new SecureRandom();
        }
        return this.zzjsn;
    }

    @WorkerThread
    public final boolean zzeh(String str) {
        zzwj();
        if (zzbih.zzdd(getContext()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzayp().zzbaz().zzj("Permission not granted", str);
        return false;
    }

    public final boolean zzf(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(zzxx().currentTimeMillis() - j) > j2;
    }

    public final Object zzk(String str, Object obj) {
        boolean z;
        int i = 256;
        if ("_ev".equals(str)) {
            z = true;
        } else {
            if (!zzkp(str)) {
                i = 100;
            }
            z = false;
        }
        return zza(i, obj, z);
    }

    public final int zzki(String str) {
        return !zzar("event", str) ? 2 : !zza("event", Event.zzjew, str) ? 13 : !zzb("event", 40, str) ? 2 : 0;
    }

    public final int zzkj(String str) {
        return !zzaq("user property", str) ? 6 : !zza("user property", UserProperty.zzjfa, str) ? 15 : !zzb("user property", 24, str) ? 6 : 0;
    }

    public final int zzkk(String str) {
        return !zzar("user property", str) ? 6 : !zza("user property", UserProperty.zzjfa, str) ? 15 : !zzb("user property", 24, str) ? 6 : 0;
    }

    public final boolean zzkn(String str) {
        if (TextUtils.isEmpty(str)) {
            zzayp().zzbau().log("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            return false;
        }
        zzbq.checkNotNull(str);
        if (str.matches("^1:\\d+:android:[a-f0-9]+$")) {
            return true;
        }
        zzayp().zzbau().zzj("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", str);
        return false;
    }

    public final boolean zzkq(String str) {
        return TextUtils.isEmpty(str) ? false : zzayr().zzazu().equals(str);
    }

    final boolean zzks(String str) {
        return "1".equals(zzaym().zzam(str, "measurement.upload.blacklist_internal"));
    }

    final boolean zzkt(String str) {
        return "1".equals(zzaym().zzam(str, "measurement.upload.blacklist_public"));
    }

    public final int zzl(String str, Object obj) {
        return "_ldl".equals(str) ? zza("user property referrer", str, zzko(str), obj, false) : zza("user property", str, zzko(str), obj, false) ? 0 : 7;
    }

    public final Object zzm(String str, Object obj) {
        int zzko;
        boolean z;
        if ("_ldl".equals(str)) {
            zzko = zzko(str);
            z = true;
        } else {
            zzko = zzko(str);
            z = false;
        }
        return zza(zzko, obj, z);
    }

    public final Bundle zzp(@NonNull Uri uri) {
        if (uri == null) {
            return null;
        }
        try {
            Object queryParameter;
            Object queryParameter2;
            Object queryParameter3;
            Object queryParameter4;
            if (uri.isHierarchical()) {
                queryParameter = uri.getQueryParameter("utm_campaign");
                queryParameter2 = uri.getQueryParameter("utm_source");
                queryParameter3 = uri.getQueryParameter("utm_medium");
                queryParameter4 = uri.getQueryParameter("gclid");
            } else {
                queryParameter = null;
                queryParameter2 = queryParameter;
                queryParameter3 = queryParameter2;
                queryParameter4 = queryParameter3;
            }
            if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString(b.CAMPAIGN, queryParameter);
            }
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString(b.SOURCE, queryParameter2);
            }
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString(b.MEDIUM, queryParameter3);
            }
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("gclid", queryParameter4);
            }
            queryParameter = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString(b.TERM, queryParameter);
            }
            queryParameter = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString(b.CONTENT, queryParameter);
            }
            queryParameter = uri.getQueryParameter(b.ACLID);
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString(b.ACLID, queryParameter);
            }
            queryParameter = uri.getQueryParameter(b.CP1);
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString(b.CP1, queryParameter);
            }
            Object queryParameter5 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("anid", queryParameter5);
            }
            return bundle;
        } catch (UnsupportedOperationException e) {
            zzayp().zzbaw().zzj("Install referrer url isn't a hierarchical URI", e);
            return null;
        }
    }

    public final byte[] zzr(byte[] bArr) {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            zzayp().zzbau().zzj("Failed to gzip content", e);
            throw e;
        }
    }

    public final byte[] zzs(byte[] bArr) {
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            zzayp().zzbau().zzj("Failed to ungzip content", e);
            throw e;
        }
    }
}
