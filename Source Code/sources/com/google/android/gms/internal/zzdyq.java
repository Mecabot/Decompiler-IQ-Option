package com.google.android.gms.internal;

import java.io.PrintStream;
import java.io.PrintWriter;

public final class zzdyq {
    private static zzdyr zzmmf;
    private static int zzmmg;

    static final class zza extends zzdyr {
        zza() {
        }

        public final void zza(Throwable th, PrintStream printStream) {
            th.printStackTrace(printStream);
        }

        public final void zza(Throwable th, PrintWriter printWriter) {
            th.printStackTrace(printWriter);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0068  */
    static {
        /*
        r0 = 1;
        r1 = zzbss();	 Catch:{ Throwable -> 0x002c }
        if (r1 == 0) goto L_0x0017;
    L_0x0007:
        r2 = r1.intValue();	 Catch:{ Throwable -> 0x0015 }
        r3 = 19;
        if (r2 < r3) goto L_0x0017;
    L_0x000f:
        r2 = new com.google.android.gms.internal.zzdyv;	 Catch:{ Throwable -> 0x0015 }
        r2.<init>();	 Catch:{ Throwable -> 0x0015 }
        goto L_0x0063;
    L_0x0015:
        r2 = move-exception;
        goto L_0x002e;
    L_0x0017:
        r2 = "com.google.devtools.build.android.desugar.runtime.twr_disable_mimic";
        r2 = java.lang.Boolean.getBoolean(r2);	 Catch:{ Throwable -> 0x0015 }
        r2 = r2 ^ r0;
        if (r2 == 0) goto L_0x0026;
    L_0x0020:
        r2 = new com.google.android.gms.internal.zzdyu;	 Catch:{ Throwable -> 0x0015 }
        r2.<init>();	 Catch:{ Throwable -> 0x0015 }
        goto L_0x0063;
    L_0x0026:
        r2 = new com.google.android.gms.internal.zzdyq$zza;	 Catch:{ Throwable -> 0x0015 }
        r2.<init>();	 Catch:{ Throwable -> 0x0015 }
        goto L_0x0063;
    L_0x002c:
        r2 = move-exception;
        r1 = 0;
    L_0x002e:
        r3 = java.lang.System.err;
        r4 = com.google.android.gms.internal.zzdyq.zza.class;
        r4 = r4.getName();
        r5 = java.lang.String.valueOf(r4);
        r5 = r5.length();
        r5 = r5 + 132;
        r6 = new java.lang.StringBuilder;
        r6.<init>(r5);
        r5 = "An error has occured when initializing the try-with-resources desuguring strategy. The default strategy ";
        r6.append(r5);
        r6.append(r4);
        r4 = "will be used. The error is: ";
        r6.append(r4);
        r4 = r6.toString();
        r3.println(r4);
        r3 = java.lang.System.err;
        r2.printStackTrace(r3);
        r2 = new com.google.android.gms.internal.zzdyq$zza;
        r2.<init>();
    L_0x0063:
        zzmmf = r2;
        if (r1 != 0) goto L_0x0068;
    L_0x0067:
        goto L_0x006c;
    L_0x0068:
        r0 = r1.intValue();
    L_0x006c:
        zzmmg = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdyq.<clinit>():void");
    }

    public static void zza(Throwable th, PrintStream printStream) {
        zzmmf.zza(th, printStream);
    }

    public static void zza(Throwable th, PrintWriter printWriter) {
        zzmmf.zza(th, printWriter);
    }

    private static Integer zzbss() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }
}
