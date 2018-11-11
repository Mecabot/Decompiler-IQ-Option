package com.appsflyer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;

final class y {

    static final class a {
        private final String pJ;
        private final String pZ;
        private final String pr;

        a(@NonNull String str, @Nullable String str2, @Nullable String str3) {
            this.pZ = str;
            this.pr = str2;
            this.pJ = str3;
        }

        final String fN() {
            return this.pZ;
        }

        @Nullable
        final String fE() {
            return this.pr;
        }

        @Nullable
        final String fw() {
            return this.pJ;
        }

        a() {
        }

        static boolean j(Context context, String str) {
            int checkSelfPermission = ContextCompat.checkSelfPermission(context, str);
            StringBuilder stringBuilder = new StringBuilder("is Permission Available: ");
            stringBuilder.append(str);
            stringBuilder.append("; res: ");
            stringBuilder.append(checkSelfPermission);
            AFLogger.ak(stringBuilder.toString());
            return checkSelfPermission == 0;
        }
    }

    static final class b {
        static final y qI = new y();
    }

    y() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x00aa A:{SYNTHETIC, Splitter: B:57:0x00aa} */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00bb A:{Catch:{ Throwable -> 0x00b1 }} */
    /* JADX WARNING: Missing block: B:59:0x00ae, code:
            if (r3.isEmpty() != false) goto L_0x00b4;
     */
    static com.appsflyer.y.a F(@android.support.annotation.NonNull android.content.Context r10) {
        /*
        r0 = "unknown";
        r1 = 0;
        r2 = "connectivity";
        r2 = r10.getSystemService(r2);	 Catch:{ Throwable -> 0x00c2 }
        r2 = (android.net.ConnectivityManager) r2;	 Catch:{ Throwable -> 0x00c2 }
        if (r2 == 0) goto L_0x0095;
    L_0x000d:
        r3 = 21;
        r4 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x00c2 }
        r5 = 0;
        r6 = 1;
        if (r3 > r4) goto L_0x004c;
    L_0x0015:
        r3 = r2.getAllNetworks();	 Catch:{ Throwable -> 0x00c2 }
        r4 = r3.length;	 Catch:{ Throwable -> 0x00c2 }
        r7 = 0;
    L_0x001b:
        if (r7 >= r4) goto L_0x0049;
    L_0x001d:
        r8 = r3[r7];	 Catch:{ Throwable -> 0x00c2 }
        r8 = r2.getNetworkInfo(r8);	 Catch:{ Throwable -> 0x00c2 }
        if (r8 == 0) goto L_0x002d;
    L_0x0025:
        r9 = r8.isConnectedOrConnecting();	 Catch:{ Throwable -> 0x00c2 }
        if (r9 == 0) goto L_0x002d;
    L_0x002b:
        r9 = 1;
        goto L_0x002e;
    L_0x002d:
        r9 = 0;
    L_0x002e:
        if (r9 == 0) goto L_0x0046;
    L_0x0030:
        r2 = r8.getType();	 Catch:{ Throwable -> 0x00c2 }
        if (r6 != r2) goto L_0x003a;
    L_0x0036:
        r2 = "WIFI";
        goto L_0x0097;
    L_0x003a:
        r2 = r8.getType();	 Catch:{ Throwable -> 0x00c2 }
        if (r2 != 0) goto L_0x0043;
    L_0x0040:
        r2 = "MOBILE";
        goto L_0x0097;
    L_0x0043:
        r2 = "unknown";
        goto L_0x0097;
    L_0x0046:
        r7 = r7 + 1;
        goto L_0x001b;
    L_0x0049:
        r2 = "unknown";
        goto L_0x0097;
    L_0x004c:
        r3 = r2.getNetworkInfo(r6);	 Catch:{ Throwable -> 0x00c2 }
        if (r3 == 0) goto L_0x005a;
    L_0x0052:
        r3 = r3.isConnectedOrConnecting();	 Catch:{ Throwable -> 0x00c2 }
        if (r3 == 0) goto L_0x005a;
    L_0x0058:
        r3 = 1;
        goto L_0x005b;
    L_0x005a:
        r3 = 0;
    L_0x005b:
        if (r3 == 0) goto L_0x0060;
    L_0x005d:
        r2 = "WIFI";
        goto L_0x0097;
    L_0x0060:
        r3 = r2.getNetworkInfo(r5);	 Catch:{ Throwable -> 0x00c2 }
        if (r3 == 0) goto L_0x006e;
    L_0x0066:
        r3 = r3.isConnectedOrConnecting();	 Catch:{ Throwable -> 0x00c2 }
        if (r3 == 0) goto L_0x006e;
    L_0x006c:
        r3 = 1;
        goto L_0x006f;
    L_0x006e:
        r3 = 0;
    L_0x006f:
        if (r3 == 0) goto L_0x0074;
    L_0x0071:
        r2 = "MOBILE";
        goto L_0x0097;
    L_0x0074:
        r2 = r2.getActiveNetworkInfo();	 Catch:{ Throwable -> 0x00c2 }
        if (r2 == 0) goto L_0x0081;
    L_0x007a:
        r3 = r2.isConnectedOrConnecting();	 Catch:{ Throwable -> 0x00c2 }
        if (r3 == 0) goto L_0x0081;
    L_0x0080:
        r5 = 1;
    L_0x0081:
        if (r5 == 0) goto L_0x0095;
    L_0x0083:
        r3 = r2.getType();	 Catch:{ Throwable -> 0x00c2 }
        if (r6 != r3) goto L_0x008c;
    L_0x0089:
        r2 = "WIFI";
        goto L_0x0097;
    L_0x008c:
        r2 = r2.getType();	 Catch:{ Throwable -> 0x00c2 }
        if (r2 != 0) goto L_0x0095;
    L_0x0092:
        r2 = "MOBILE";
        goto L_0x0097;
    L_0x0095:
        r2 = "unknown";
    L_0x0097:
        r0 = r2;
        r2 = "phone";
        r10 = r10.getSystemService(r2);	 Catch:{ Throwable -> 0x00c2 }
        r10 = (android.telephony.TelephonyManager) r10;	 Catch:{ Throwable -> 0x00c2 }
        r2 = r10.getSimOperatorName();	 Catch:{ Throwable -> 0x00c2 }
        r3 = r10.getNetworkOperatorName();	 Catch:{ Throwable -> 0x00c0 }
        if (r3 == 0) goto L_0x00b4;
    L_0x00aa:
        r1 = r3.isEmpty();	 Catch:{ Throwable -> 0x00b1 }
        if (r1 == 0) goto L_0x00be;
    L_0x00b0:
        goto L_0x00b4;
    L_0x00b1:
        r10 = move-exception;
        r1 = r3;
        goto L_0x00c4;
    L_0x00b4:
        r1 = 2;
        r10 = r10.getPhoneType();	 Catch:{ Throwable -> 0x00b1 }
        if (r1 != r10) goto L_0x00be;
    L_0x00bb:
        r10 = "CDMA";
        goto L_0x00ca;
    L_0x00be:
        r10 = r3;
        goto L_0x00ca;
    L_0x00c0:
        r10 = move-exception;
        goto L_0x00c4;
    L_0x00c2:
        r10 = move-exception;
        r2 = r1;
    L_0x00c4:
        r3 = "Exception while collecting network info. ";
        com.appsflyer.AFLogger.a(r3, r10);
        r10 = r1;
    L_0x00ca:
        r1 = new com.appsflyer.y$a;
        r1.<init>(r0, r10, r2);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.y.F(android.content.Context):com.appsflyer.y$a");
    }
}
