package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.zzf;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import java.lang.reflect.Field;

@Hide
public final class DynamiteModule {
    private static Boolean zzhdc;
    private static zzk zzhdd;
    private static zzm zzhde;
    private static String zzhdf;
    private static final ThreadLocal<zza> zzhdg = new ThreadLocal();
    private static final zzi zzhdh = new zza();
    public static final zzd zzhdi = new zzb();
    private static zzd zzhdj = new zzc();
    public static final zzd zzhdk = new zzd();
    public static final zzd zzhdl = new zze();
    public static final zzd zzhdm = new zzf();
    public static final zzd zzhdn = new zzg();
    private final Context zzhdo;

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    static class zza {
        public Cursor zzhdp;

        private zza() {
        }

        /* synthetic */ zza(zza zza) {
            this();
        }
    }

    public static class zzc extends Exception {
        private zzc(String str) {
            super(str);
        }

        private zzc(String str, Throwable th) {
            super(str, th);
        }

        /* synthetic */ zzc(String str, Throwable th, zza zza) {
            this(str, th);
        }
    }

    public interface zzd {
        zzj zza(Context context, String str, zzi zzi);
    }

    static class zzb implements zzi {
        private final int zzhdq;
        private final int zzhdr = 0;

        public zzb(int i, int i2) {
            this.zzhdq = i;
        }

        public final int zzc(Context context, String str, boolean z) {
            return 0;
        }

        public final int zzx(Context context, String str) {
            return this.zzhdq;
        }
    }

    private DynamiteModule(Context context) {
        this.zzhdo = (Context) zzbq.checkNotNull(context);
    }

    private static Context zza(Context context, String str, int i, Cursor cursor, zzm zzm) {
        try {
            return (Context) zzn.zzy(zzm.zza(zzn.zzz(context), str, i, zzn.zzz(cursor)));
        } catch (Exception e) {
            str = "DynamiteModule";
            String str2 = "Failed to load DynamiteLoader: ";
            String valueOf = String.valueOf(e.toString());
            Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            return null;
        }
    }

    /* JADX WARNING: Missing block: B:16:0x0080, code:
            if (r1.zzhdp != null) goto L_0x0082;
     */
    /* JADX WARNING: Missing block: B:42:0x00e1, code:
            if (r1.zzhdp != null) goto L_0x0082;
     */
    public static com.google.android.gms.dynamite.DynamiteModule zza(android.content.Context r10, com.google.android.gms.dynamite.DynamiteModule.zzd r11, java.lang.String r12) {
        /*
        r0 = zzhdg;
        r0 = r0.get();
        r0 = (com.google.android.gms.dynamite.DynamiteModule.zza) r0;
        r1 = new com.google.android.gms.dynamite.DynamiteModule$zza;
        r2 = 0;
        r1.<init>(r2);
        r3 = zzhdg;
        r3.set(r1);
        r3 = zzhdh;	 Catch:{ all -> 0x0131 }
        r3 = r11.zza(r10, r12, r3);	 Catch:{ all -> 0x0131 }
        r4 = "DynamiteModule";
        r5 = r3.zzhds;	 Catch:{ all -> 0x0131 }
        r6 = r3.zzhdt;	 Catch:{ all -> 0x0131 }
        r7 = java.lang.String.valueOf(r12);	 Catch:{ all -> 0x0131 }
        r7 = r7.length();	 Catch:{ all -> 0x0131 }
        r7 = r7 + 68;
        r8 = java.lang.String.valueOf(r12);	 Catch:{ all -> 0x0131 }
        r8 = r8.length();	 Catch:{ all -> 0x0131 }
        r7 = r7 + r8;
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0131 }
        r8.<init>(r7);	 Catch:{ all -> 0x0131 }
        r7 = "Considering local module ";
        r8.append(r7);	 Catch:{ all -> 0x0131 }
        r8.append(r12);	 Catch:{ all -> 0x0131 }
        r7 = ":";
        r8.append(r7);	 Catch:{ all -> 0x0131 }
        r8.append(r5);	 Catch:{ all -> 0x0131 }
        r5 = " and remote module ";
        r8.append(r5);	 Catch:{ all -> 0x0131 }
        r8.append(r12);	 Catch:{ all -> 0x0131 }
        r5 = ":";
        r8.append(r5);	 Catch:{ all -> 0x0131 }
        r8.append(r6);	 Catch:{ all -> 0x0131 }
        r5 = r8.toString();	 Catch:{ all -> 0x0131 }
        android.util.Log.i(r4, r5);	 Catch:{ all -> 0x0131 }
        r4 = r3.zzhdu;	 Catch:{ all -> 0x0131 }
        if (r4 == 0) goto L_0x0107;
    L_0x0062:
        r4 = r3.zzhdu;	 Catch:{ all -> 0x0131 }
        r5 = -1;
        if (r4 != r5) goto L_0x006b;
    L_0x0067:
        r4 = r3.zzhds;	 Catch:{ all -> 0x0131 }
        if (r4 == 0) goto L_0x0107;
    L_0x006b:
        r4 = r3.zzhdu;	 Catch:{ all -> 0x0131 }
        r6 = 1;
        if (r4 != r6) goto L_0x0076;
    L_0x0070:
        r4 = r3.zzhdt;	 Catch:{ all -> 0x0131 }
        if (r4 != 0) goto L_0x0076;
    L_0x0074:
        goto L_0x0107;
    L_0x0076:
        r4 = r3.zzhdu;	 Catch:{ all -> 0x0131 }
        if (r4 != r5) goto L_0x008d;
    L_0x007a:
        r10 = zzz(r10, r12);	 Catch:{ all -> 0x0131 }
        r11 = r1.zzhdp;
        if (r11 == 0) goto L_0x0087;
    L_0x0082:
        r11 = r1.zzhdp;
        r11.close();
    L_0x0087:
        r11 = zzhdg;
        r11.set(r0);
        return r10;
    L_0x008d:
        r4 = r3.zzhdu;	 Catch:{ all -> 0x0131 }
        if (r4 != r6) goto L_0x00ec;
    L_0x0091:
        r4 = r3.zzhdt;	 Catch:{ zzc -> 0x00a6 }
        r4 = zza(r10, r12, r4);	 Catch:{ zzc -> 0x00a6 }
        r10 = r1.zzhdp;
        if (r10 == 0) goto L_0x00a0;
    L_0x009b:
        r10 = r1.zzhdp;
        r10.close();
    L_0x00a0:
        r10 = zzhdg;
        r10.set(r0);
        return r4;
    L_0x00a6:
        r4 = move-exception;
        r6 = "DynamiteModule";
        r7 = "Failed to load remote module: ";
        r8 = r4.getMessage();	 Catch:{ all -> 0x0131 }
        r8 = java.lang.String.valueOf(r8);	 Catch:{ all -> 0x0131 }
        r9 = r8.length();	 Catch:{ all -> 0x0131 }
        if (r9 == 0) goto L_0x00be;
    L_0x00b9:
        r7 = r7.concat(r8);	 Catch:{ all -> 0x0131 }
        goto L_0x00c4;
    L_0x00be:
        r8 = new java.lang.String;	 Catch:{ all -> 0x0131 }
        r8.<init>(r7);	 Catch:{ all -> 0x0131 }
        r7 = r8;
    L_0x00c4:
        android.util.Log.w(r6, r7);	 Catch:{ all -> 0x0131 }
        r6 = r3.zzhds;	 Catch:{ all -> 0x0131 }
        if (r6 == 0) goto L_0x00e4;
    L_0x00cb:
        r6 = new com.google.android.gms.dynamite.DynamiteModule$zzb;	 Catch:{ all -> 0x0131 }
        r3 = r3.zzhds;	 Catch:{ all -> 0x0131 }
        r7 = 0;
        r6.<init>(r3, r7);	 Catch:{ all -> 0x0131 }
        r11 = r11.zza(r10, r12, r6);	 Catch:{ all -> 0x0131 }
        r11 = r11.zzhdu;	 Catch:{ all -> 0x0131 }
        if (r11 != r5) goto L_0x00e4;
    L_0x00db:
        r10 = zzz(r10, r12);	 Catch:{ all -> 0x0131 }
        r11 = r1.zzhdp;
        if (r11 == 0) goto L_0x0087;
    L_0x00e3:
        goto L_0x0082;
    L_0x00e4:
        r10 = new com.google.android.gms.dynamite.DynamiteModule$zzc;	 Catch:{ all -> 0x0131 }
        r11 = "Remote load failed. No local fallback found.";
        r10.<init>(r11, r4, r2);	 Catch:{ all -> 0x0131 }
        throw r10;	 Catch:{ all -> 0x0131 }
    L_0x00ec:
        r10 = new com.google.android.gms.dynamite.DynamiteModule$zzc;	 Catch:{ all -> 0x0131 }
        r11 = r3.zzhdu;	 Catch:{ all -> 0x0131 }
        r12 = 47;
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0131 }
        r3.<init>(r12);	 Catch:{ all -> 0x0131 }
        r12 = "VersionPolicy returned invalid code:";
        r3.append(r12);	 Catch:{ all -> 0x0131 }
        r3.append(r11);	 Catch:{ all -> 0x0131 }
        r11 = r3.toString();	 Catch:{ all -> 0x0131 }
        r10.<init>(r11, r2);	 Catch:{ all -> 0x0131 }
        throw r10;	 Catch:{ all -> 0x0131 }
    L_0x0107:
        r10 = new com.google.android.gms.dynamite.DynamiteModule$zzc;	 Catch:{ all -> 0x0131 }
        r11 = r3.zzhds;	 Catch:{ all -> 0x0131 }
        r12 = r3.zzhdt;	 Catch:{ all -> 0x0131 }
        r3 = 91;
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0131 }
        r4.<init>(r3);	 Catch:{ all -> 0x0131 }
        r3 = "No acceptable module found. Local version is ";
        r4.append(r3);	 Catch:{ all -> 0x0131 }
        r4.append(r11);	 Catch:{ all -> 0x0131 }
        r11 = " and remote version is ";
        r4.append(r11);	 Catch:{ all -> 0x0131 }
        r4.append(r12);	 Catch:{ all -> 0x0131 }
        r11 = ".";
        r4.append(r11);	 Catch:{ all -> 0x0131 }
        r11 = r4.toString();	 Catch:{ all -> 0x0131 }
        r10.<init>(r11, r2);	 Catch:{ all -> 0x0131 }
        throw r10;	 Catch:{ all -> 0x0131 }
    L_0x0131:
        r10 = move-exception;
        r11 = r1.zzhdp;
        if (r11 == 0) goto L_0x013b;
    L_0x0136:
        r11 = r1.zzhdp;
        r11.close();
    L_0x013b:
        r11 = zzhdg;
        r11.set(r0);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zza(android.content.Context, com.google.android.gms.dynamite.DynamiteModule$zzd, java.lang.String):com.google.android.gms.dynamite.DynamiteModule");
    }

    private static DynamiteModule zza(Context context, String str, int i) {
        Boolean bool;
        synchronized (DynamiteModule.class) {
            bool = zzhdc;
        }
        if (bool != null) {
            return bool.booleanValue() ? zzc(context, str, i) : zzb(context, str, i);
        } else {
            throw new zzc("Failed to determine which loading route to use.", null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031 A:{Splitter: B:1:0x0001, ExcHandler: java.lang.ClassNotFoundException (r3_10 'e' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031 A:{Splitter: B:1:0x0001, ExcHandler: java.lang.ClassNotFoundException (r3_10 'e' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031 A:{Splitter: B:1:0x0001, ExcHandler: java.lang.ClassNotFoundException (r3_10 'e' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031 A:{Splitter: B:1:0x0001, ExcHandler: java.lang.ClassNotFoundException (r3_10 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:11:0x0031, code:
            r3 = move-exception;
     */
    /* JADX WARNING: Missing block: B:13:0x0039, code:
            throw new com.google.android.gms.dynamite.DynamiteModule.zzc("Failed to instantiate dynamite loader", r3, null);
     */
    private static void zza(java.lang.ClassLoader r3) {
        /*
        r0 = 0;
        r1 = "com.google.android.gms.dynamiteloader.DynamiteLoaderV2";
        r3 = r3.loadClass(r1);	 Catch:{ ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031 }
        r1 = 0;
        r2 = new java.lang.Class[r1];	 Catch:{ ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031 }
        r3 = r3.getConstructor(r2);	 Catch:{ ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031 }
        r1 = new java.lang.Object[r1];	 Catch:{ ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031 }
        r3 = r3.newInstance(r1);	 Catch:{ ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031 }
        r3 = (android.os.IBinder) r3;	 Catch:{ ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031 }
        if (r3 != 0) goto L_0x001a;
    L_0x0018:
        r3 = r0;
        goto L_0x002e;
    L_0x001a:
        r1 = "com.google.android.gms.dynamite.IDynamiteLoaderV2";
        r1 = r3.queryLocalInterface(r1);	 Catch:{ ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031 }
        r2 = r1 instanceof com.google.android.gms.dynamite.zzm;	 Catch:{ ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031 }
        if (r2 == 0) goto L_0x0028;
    L_0x0024:
        r3 = r1;
        r3 = (com.google.android.gms.dynamite.zzm) r3;	 Catch:{ ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031 }
        goto L_0x002e;
    L_0x0028:
        r1 = new com.google.android.gms.dynamite.zzn;	 Catch:{ ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031 }
        r1.<init>(r3);	 Catch:{ ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031 }
        r3 = r1;
    L_0x002e:
        zzhde = r3;	 Catch:{ ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031, ClassNotFoundException -> 0x0031 }
        return;
    L_0x0031:
        r3 = move-exception;
        r1 = new com.google.android.gms.dynamite.DynamiteModule$zzc;
        r2 = "Failed to instantiate dynamite loader";
        r1.<init>(r2, r3, r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zza(java.lang.ClassLoader):void");
    }

    private static DynamiteModule zzb(Context context, String str, int i) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 51);
        stringBuilder.append("Selected remote version of ");
        stringBuilder.append(str);
        stringBuilder.append(", version >= ");
        stringBuilder.append(i);
        Log.i("DynamiteModule", stringBuilder.toString());
        zzk zzdh = zzdh(context);
        if (zzdh == null) {
            throw new zzc("Failed to create IDynamiteLoader.", null);
        }
        try {
            IObjectWrapper zza = zzdh.zza(zzn.zzz(context), str, i);
            if (zzn.zzy(zza) != null) {
                return new DynamiteModule((Context) zzn.zzy(zza));
            }
            throw new zzc("Failed to load remote module.", null);
        } catch (Throwable e) {
            throw new zzc("Failed to load remote module.", e, null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x008a A:{Splitter: B:5:0x0007, ExcHandler: java.lang.ClassNotFoundException (r1_5 'e' java.lang.ClassNotFoundException)} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008a A:{Splitter: B:5:0x0007, ExcHandler: java.lang.ClassNotFoundException (r1_5 'e' java.lang.ClassNotFoundException)} */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ba A:{SYNTHETIC, Splitter: B:53:0x00ba} */
    /* JADX WARNING: Missing block: B:39:?, code:
            r2.set(null, java.lang.ClassLoader.getSystemClassLoader());
     */
    /* JADX WARNING: Missing block: B:46:0x008a, code:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:48:?, code:
            r1 = java.lang.String.valueOf(r1);
            r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r1).length() + 30);
            r4.append("Failed to load module via V2: ");
            r4.append(r1);
            android.util.Log.w("DynamiteModule", r4.toString());
            r1 = java.lang.Boolean.FALSE;
     */
    /* JADX WARNING: Missing block: B:55:0x00be, code:
            return zze(r8, r9, r10);
     */
    /* JADX WARNING: Missing block: B:56:0x00bf, code:
            r8 = move-exception;
     */
    /* JADX WARNING: Missing block: B:57:0x00c0, code:
            r9 = "DynamiteModule";
            r10 = "Failed to retrieve remote module version: ";
            r8 = java.lang.String.valueOf(r8.getMessage());
     */
    /* JADX WARNING: Missing block: B:58:0x00d0, code:
            if (r8.length() != 0) goto L_0x00d2;
     */
    /* JADX WARNING: Missing block: B:59:0x00d2, code:
            r8 = r10.concat(r8);
     */
    /* JADX WARNING: Missing block: B:60:0x00d7, code:
            r8 = new java.lang.String(r10);
     */
    /* JADX WARNING: Missing block: B:61:0x00dc, code:
            android.util.Log.w(r9, r8);
     */
    /* JADX WARNING: Missing block: B:62:0x00e0, code:
            return 0;
     */
    /* JADX WARNING: Missing block: B:64:0x00e5, code:
            return zzd(r8, r9, r10);
     */
    public static int zzc(android.content.Context r8, java.lang.String r9, boolean r10) {
        /*
        r0 = com.google.android.gms.dynamite.DynamiteModule.class;
        monitor-enter(r0);
        r1 = zzhdc;	 Catch:{ all -> 0x00e6 }
        if (r1 != 0) goto L_0x00b3;
    L_0x0007:
        r1 = r8.getApplicationContext();	 Catch:{ ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a }
        r1 = r1.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a }
        r2 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class;
        r2 = r2.getName();	 Catch:{ ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a }
        r1 = r1.loadClass(r2);	 Catch:{ ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a }
        r2 = "sClassLoader";
        r2 = r1.getDeclaredField(r2);	 Catch:{ ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a }
        monitor-enter(r1);	 Catch:{ ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a }
        r3 = 0;
        r4 = r2.get(r3);	 Catch:{ all -> 0x0087 }
        r4 = (java.lang.ClassLoader) r4;	 Catch:{ all -> 0x0087 }
        if (r4 == 0) goto L_0x0038;
    L_0x0029:
        r2 = java.lang.ClassLoader.getSystemClassLoader();	 Catch:{ all -> 0x0087 }
        if (r4 != r2) goto L_0x0032;
    L_0x002f:
        r2 = java.lang.Boolean.FALSE;	 Catch:{ all -> 0x0087 }
        goto L_0x0084;
    L_0x0032:
        zza(r4);	 Catch:{ zzc -> 0x0035 }
    L_0x0035:
        r2 = java.lang.Boolean.TRUE;	 Catch:{ all -> 0x0087 }
        goto L_0x0084;
    L_0x0038:
        r4 = "com.google.android.gms";
        r5 = r8.getApplicationContext();	 Catch:{ all -> 0x0087 }
        r5 = r5.getPackageName();	 Catch:{ all -> 0x0087 }
        r4 = r4.equals(r5);	 Catch:{ all -> 0x0087 }
        if (r4 == 0) goto L_0x0050;
    L_0x0048:
        r4 = java.lang.ClassLoader.getSystemClassLoader();	 Catch:{ all -> 0x0087 }
        r2.set(r3, r4);	 Catch:{ all -> 0x0087 }
        goto L_0x002f;
    L_0x0050:
        r4 = zze(r8, r9, r10);	 Catch:{ zzc -> 0x007c }
        r5 = zzhdf;	 Catch:{ zzc -> 0x007c }
        if (r5 == 0) goto L_0x0079;
    L_0x0058:
        r5 = zzhdf;	 Catch:{ zzc -> 0x007c }
        r5 = r5.isEmpty();	 Catch:{ zzc -> 0x007c }
        if (r5 == 0) goto L_0x0061;
    L_0x0060:
        goto L_0x0079;
    L_0x0061:
        r5 = new com.google.android.gms.dynamite.zzh;	 Catch:{ zzc -> 0x007c }
        r6 = zzhdf;	 Catch:{ zzc -> 0x007c }
        r7 = java.lang.ClassLoader.getSystemClassLoader();	 Catch:{ zzc -> 0x007c }
        r5.<init>(r6, r7);	 Catch:{ zzc -> 0x007c }
        zza(r5);	 Catch:{ zzc -> 0x007c }
        r2.set(r3, r5);	 Catch:{ zzc -> 0x007c }
        r5 = java.lang.Boolean.TRUE;	 Catch:{ zzc -> 0x007c }
        zzhdc = r5;	 Catch:{ zzc -> 0x007c }
        monitor-exit(r1);	 Catch:{ all -> 0x0087 }
        monitor-exit(r0);	 Catch:{ all -> 0x00e6 }
        return r4;
    L_0x0079:
        monitor-exit(r1);	 Catch:{ all -> 0x0087 }
        monitor-exit(r0);	 Catch:{ all -> 0x00e6 }
        return r4;
    L_0x007c:
        r4 = java.lang.ClassLoader.getSystemClassLoader();	 Catch:{ all -> 0x0087 }
        r2.set(r3, r4);	 Catch:{ all -> 0x0087 }
        goto L_0x002f;
    L_0x0084:
        monitor-exit(r1);	 Catch:{ all -> 0x0087 }
        r1 = r2;
        goto L_0x00b1;
    L_0x0087:
        r2 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0087 }
        throw r2;	 Catch:{ ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a }
    L_0x008a:
        r1 = move-exception;
        r2 = "DynamiteModule";
        r1 = java.lang.String.valueOf(r1);	 Catch:{ all -> 0x00e6 }
        r3 = java.lang.String.valueOf(r1);	 Catch:{ all -> 0x00e6 }
        r3 = r3.length();	 Catch:{ all -> 0x00e6 }
        r3 = r3 + 30;
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00e6 }
        r4.<init>(r3);	 Catch:{ all -> 0x00e6 }
        r3 = "Failed to load module via V2: ";
        r4.append(r3);	 Catch:{ all -> 0x00e6 }
        r4.append(r1);	 Catch:{ all -> 0x00e6 }
        r1 = r4.toString();	 Catch:{ all -> 0x00e6 }
        android.util.Log.w(r2, r1);	 Catch:{ all -> 0x00e6 }
        r1 = java.lang.Boolean.FALSE;	 Catch:{ all -> 0x00e6 }
    L_0x00b1:
        zzhdc = r1;	 Catch:{ all -> 0x00e6 }
    L_0x00b3:
        monitor-exit(r0);	 Catch:{ all -> 0x00e6 }
        r0 = r1.booleanValue();
        if (r0 == 0) goto L_0x00e1;
    L_0x00ba:
        r8 = zze(r8, r9, r10);	 Catch:{ zzc -> 0x00bf }
        return r8;
    L_0x00bf:
        r8 = move-exception;
        r9 = "DynamiteModule";
        r10 = "Failed to retrieve remote module version: ";
        r8 = r8.getMessage();
        r8 = java.lang.String.valueOf(r8);
        r0 = r8.length();
        if (r0 == 0) goto L_0x00d7;
    L_0x00d2:
        r8 = r10.concat(r8);
        goto L_0x00dc;
    L_0x00d7:
        r8 = new java.lang.String;
        r8.<init>(r10);
    L_0x00dc:
        android.util.Log.w(r9, r8);
        r8 = 0;
        return r8;
    L_0x00e1:
        r8 = zzd(r8, r9, r10);
        return r8;
    L_0x00e6:
        r8 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00e6 }
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzc(android.content.Context, java.lang.String, boolean):int");
    }

    private static DynamiteModule zzc(Context context, String str, int i) {
        zzm zzm;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 51);
        stringBuilder.append("Selected remote version of ");
        stringBuilder.append(str);
        stringBuilder.append(", version >= ");
        stringBuilder.append(i);
        Log.i("DynamiteModule", stringBuilder.toString());
        synchronized (DynamiteModule.class) {
            zzm = zzhde;
        }
        if (zzm == null) {
            throw new zzc("DynamiteLoaderV2 was not cached.", null);
        }
        zza zza = (zza) zzhdg.get();
        if (zza == null || zza.zzhdp == null) {
            throw new zzc("No result cursor", null);
        }
        context = zza(context.getApplicationContext(), str, i, zza.zzhdp, zzm);
        if (context != null) {
            return new DynamiteModule(context);
        }
        throw new zzc("Failed to get module context", null);
    }

    private static int zzd(Context context, String str, boolean z) {
        zzk zzdh = zzdh(context);
        if (zzdh == null) {
            return 0;
        }
        try {
            return zzdh.zza(zzn.zzz(context), str, z);
        } catch (RemoteException e) {
            str = "DynamiteModule";
            String str2 = "Failed to retrieve remote module version: ";
            String valueOf = String.valueOf(e.getMessage());
            Log.w(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            return 0;
        }
    }

    private static zzk zzdh(Context context) {
        synchronized (DynamiteModule.class) {
            zzk zzk;
            if (zzhdd != null) {
                zzk = zzhdd;
                return zzk;
            } else if (zzf.zzahf().isGooglePlayServicesAvailable(context) != 0) {
                return null;
            } else {
                try {
                    IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                    if (iBinder == null) {
                        zzk = null;
                    } else {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                        zzk = queryLocalInterface instanceof zzk ? (zzk) queryLocalInterface : new zzl(iBinder);
                    }
                    if (zzk != null) {
                        zzhdd = zzk;
                        return zzk;
                    }
                } catch (Exception e) {
                    String str = "DynamiteModule";
                    String str2 = "Failed to load IDynamiteLoader from GmsCore: ";
                    String valueOf = String.valueOf(e.getMessage());
                    Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a7  */
    private static int zze(android.content.Context r8, java.lang.String r9, boolean r10) {
        /*
        r0 = 0;
        r1 = r8.getContentResolver();	 Catch:{ Exception -> 0x0094, all -> 0x0092 }
        if (r10 == 0) goto L_0x000a;
    L_0x0007:
        r8 = "api_force_staging";
        goto L_0x000c;
    L_0x000a:
        r8 = "api";
    L_0x000c:
        r10 = java.lang.String.valueOf(r8);	 Catch:{ Exception -> 0x0094, all -> 0x0092 }
        r10 = r10.length();	 Catch:{ Exception -> 0x0094, all -> 0x0092 }
        r10 = r10 + 42;
        r2 = java.lang.String.valueOf(r9);	 Catch:{ Exception -> 0x0094, all -> 0x0092 }
        r2 = r2.length();	 Catch:{ Exception -> 0x0094, all -> 0x0092 }
        r10 = r10 + r2;
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0094, all -> 0x0092 }
        r2.<init>(r10);	 Catch:{ Exception -> 0x0094, all -> 0x0092 }
        r10 = "content://com.google.android.gms.chimera/";
        r2.append(r10);	 Catch:{ Exception -> 0x0094, all -> 0x0092 }
        r2.append(r8);	 Catch:{ Exception -> 0x0094, all -> 0x0092 }
        r8 = "/";
        r2.append(r8);	 Catch:{ Exception -> 0x0094, all -> 0x0092 }
        r2.append(r9);	 Catch:{ Exception -> 0x0094, all -> 0x0092 }
        r8 = r2.toString();	 Catch:{ Exception -> 0x0094, all -> 0x0092 }
        r2 = android.net.Uri.parse(r8);	 Catch:{ Exception -> 0x0094, all -> 0x0092 }
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r8 = r1.query(r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x0094, all -> 0x0092 }
        if (r8 == 0) goto L_0x0083;
    L_0x0046:
        r9 = r8.moveToFirst();	 Catch:{ Exception -> 0x007e, all -> 0x007a }
        if (r9 != 0) goto L_0x004d;
    L_0x004c:
        goto L_0x0083;
    L_0x004d:
        r9 = 0;
        r9 = r8.getInt(r9);	 Catch:{ Exception -> 0x007e, all -> 0x007a }
        if (r9 <= 0) goto L_0x0074;
    L_0x0054:
        r10 = com.google.android.gms.dynamite.DynamiteModule.class;
        monitor-enter(r10);	 Catch:{ Exception -> 0x007e, all -> 0x007a }
        r1 = 2;
        r1 = r8.getString(r1);	 Catch:{ all -> 0x0071 }
        zzhdf = r1;	 Catch:{ all -> 0x0071 }
        monitor-exit(r10);	 Catch:{ all -> 0x0071 }
        r10 = zzhdg;	 Catch:{ Exception -> 0x007e, all -> 0x007a }
        r10 = r10.get();	 Catch:{ Exception -> 0x007e, all -> 0x007a }
        r10 = (com.google.android.gms.dynamite.DynamiteModule.zza) r10;	 Catch:{ Exception -> 0x007e, all -> 0x007a }
        if (r10 == 0) goto L_0x0074;
    L_0x0069:
        r1 = r10.zzhdp;	 Catch:{ Exception -> 0x007e, all -> 0x007a }
        if (r1 != 0) goto L_0x0074;
    L_0x006d:
        r10.zzhdp = r8;	 Catch:{ Exception -> 0x007e, all -> 0x007a }
        r8 = r0;
        goto L_0x0074;
    L_0x0071:
        r9 = move-exception;
        monitor-exit(r10);	 Catch:{ all -> 0x0071 }
        throw r9;	 Catch:{ Exception -> 0x007e, all -> 0x007a }
    L_0x0074:
        if (r8 == 0) goto L_0x0079;
    L_0x0076:
        r8.close();
    L_0x0079:
        return r9;
    L_0x007a:
        r9 = move-exception;
        r0 = r8;
        r8 = r9;
        goto L_0x00a5;
    L_0x007e:
        r9 = move-exception;
        r7 = r9;
        r9 = r8;
        r8 = r7;
        goto L_0x0096;
    L_0x0083:
        r9 = "DynamiteModule";
        r10 = "Failed to retrieve remote module version.";
        android.util.Log.w(r9, r10);	 Catch:{ Exception -> 0x007e, all -> 0x007a }
        r9 = new com.google.android.gms.dynamite.DynamiteModule$zzc;	 Catch:{ Exception -> 0x007e, all -> 0x007a }
        r10 = "Failed to connect to dynamite module ContentResolver.";
        r9.<init>(r10, r0);	 Catch:{ Exception -> 0x007e, all -> 0x007a }
        throw r9;	 Catch:{ Exception -> 0x007e, all -> 0x007a }
    L_0x0092:
        r8 = move-exception;
        goto L_0x00a5;
    L_0x0094:
        r8 = move-exception;
        r9 = r0;
    L_0x0096:
        r10 = r8 instanceof com.google.android.gms.dynamite.DynamiteModule.zzc;	 Catch:{ all -> 0x00a3 }
        if (r10 == 0) goto L_0x009b;
    L_0x009a:
        throw r8;	 Catch:{ all -> 0x00a3 }
    L_0x009b:
        r10 = new com.google.android.gms.dynamite.DynamiteModule$zzc;	 Catch:{ all -> 0x00a3 }
        r1 = "V2 version check failed";
        r10.<init>(r1, r8, r0);	 Catch:{ all -> 0x00a3 }
        throw r10;	 Catch:{ all -> 0x00a3 }
    L_0x00a3:
        r8 = move-exception;
        r0 = r9;
    L_0x00a5:
        if (r0 == 0) goto L_0x00aa;
    L_0x00a7:
        r0.close();
    L_0x00aa:
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zze(android.content.Context, java.lang.String, boolean):int");
    }

    public static int zzx(Context context, String str) {
        StringBuilder stringBuilder;
        String valueOf;
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            stringBuilder = new StringBuilder(String.valueOf(str).length() + 61);
            stringBuilder.append("com.google.android.gms.dynamite.descriptors.");
            stringBuilder.append(str);
            stringBuilder.append(".ModuleDescriptor");
            Class loadClass = classLoader.loadClass(stringBuilder.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get(null).equals(str)) {
                return declaredField2.getInt(null);
            }
            valueOf = String.valueOf(declaredField.get(null));
            StringBuilder stringBuilder2 = new StringBuilder((String.valueOf(valueOf).length() + 51) + String.valueOf(str).length());
            stringBuilder2.append("Module descriptor id '");
            stringBuilder2.append(valueOf);
            stringBuilder2.append("' didn't match expected id '");
            stringBuilder2.append(str);
            stringBuilder2.append("'");
            Log.e("DynamiteModule", stringBuilder2.toString());
            return 0;
        } catch (ClassNotFoundException unused) {
            stringBuilder = new StringBuilder(String.valueOf(str).length() + 45);
            stringBuilder.append("Local module descriptor class for ");
            stringBuilder.append(str);
            stringBuilder.append(" not found.");
            Log.w("DynamiteModule", stringBuilder.toString());
            return 0;
        } catch (Exception e) {
            str = "DynamiteModule";
            valueOf = "Failed to load module descriptor class: ";
            String valueOf2 = String.valueOf(e.getMessage());
            Log.e(str, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
            return 0;
        }
    }

    public static int zzy(Context context, String str) {
        return zzc(context, str, false);
    }

    private static DynamiteModule zzz(Context context, String str) {
        String str2 = "DynamiteModule";
        String str3 = "Selected local version of ";
        str = String.valueOf(str);
        Log.i(str2, str.length() != 0 ? str3.concat(str) : new String(str3));
        return new DynamiteModule(context.getApplicationContext());
    }

    public final Context zzarl() {
        return this.zzhdo;
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0011 A:{Splitter: B:0:0x0000, ExcHandler: java.lang.ClassNotFoundException (r0_5 'e' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x0011 A:{Splitter: B:0:0x0000, ExcHandler: java.lang.ClassNotFoundException (r0_5 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:3:0x0011, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:4:0x0012, code:
            r2 = "Failed to instantiate module class: ";
            r5 = java.lang.String.valueOf(r5);
     */
    /* JADX WARNING: Missing block: B:5:0x001e, code:
            if (r5.length() != 0) goto L_0x0020;
     */
    /* JADX WARNING: Missing block: B:6:0x0020, code:
            r5 = r2.concat(r5);
     */
    /* JADX WARNING: Missing block: B:7:0x0025, code:
            r5 = new java.lang.String(r2);
     */
    /* JADX WARNING: Missing block: B:9:0x002e, code:
            throw new com.google.android.gms.dynamite.DynamiteModule.zzc(r5, r0, null);
     */
    public final android.os.IBinder zzhk(java.lang.String r5) {
        /*
        r4 = this;
        r0 = r4.zzhdo;	 Catch:{ ClassNotFoundException -> 0x0011, ClassNotFoundException -> 0x0011, ClassNotFoundException -> 0x0011 }
        r0 = r0.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x0011, ClassNotFoundException -> 0x0011, ClassNotFoundException -> 0x0011 }
        r0 = r0.loadClass(r5);	 Catch:{ ClassNotFoundException -> 0x0011, ClassNotFoundException -> 0x0011, ClassNotFoundException -> 0x0011 }
        r0 = r0.newInstance();	 Catch:{ ClassNotFoundException -> 0x0011, ClassNotFoundException -> 0x0011, ClassNotFoundException -> 0x0011 }
        r0 = (android.os.IBinder) r0;	 Catch:{ ClassNotFoundException -> 0x0011, ClassNotFoundException -> 0x0011, ClassNotFoundException -> 0x0011 }
        return r0;
    L_0x0011:
        r0 = move-exception;
        r1 = new com.google.android.gms.dynamite.DynamiteModule$zzc;
        r2 = "Failed to instantiate module class: ";
        r5 = java.lang.String.valueOf(r5);
        r3 = r5.length();
        if (r3 == 0) goto L_0x0025;
    L_0x0020:
        r5 = r2.concat(r5);
        goto L_0x002a;
    L_0x0025:
        r5 = new java.lang.String;
        r5.<init>(r2);
    L_0x002a:
        r2 = 0;
        r1.<init>(r5, r0, r2);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzhk(java.lang.String):android.os.IBinder");
    }
}
