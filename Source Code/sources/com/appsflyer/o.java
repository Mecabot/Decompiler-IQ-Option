package com.appsflyer;

import android.content.ContentResolver;
import android.os.Build;
import android.provider.Settings.Secure;

final class o {

    static class e extends IllegalStateException {
        e(String str) {
            super(str);
        }
    }

    static n b(ContentResolver contentResolver) {
        n nVar = null;
        if (contentResolver == null) {
            return null;
        }
        if (i.fF().getString("amazon_aid") == null && "Amazon".equals(Build.MANUFACTURER)) {
            int i = Secure.getInt(contentResolver, "limit_ad_tracking", 2);
            if (i == 0) {
                nVar = new n(e.AMAZON, Secure.getString(contentResolver, "advertising_id"), false);
            } else if (i != 2) {
                String string;
                String str = "";
                try {
                    string = Secure.getString(contentResolver, "advertising_id");
                } catch (Throwable th) {
                    AFLogger.a("Couldn't fetch Amazon Advertising ID (Ad-Tracking is limited!)", th);
                    string = str;
                }
                nVar = new n(e.AMAZON, string, true);
            }
        }
        return nVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0087 A:{SYNTHETIC, Splitter: B:28:0x0087} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A:{SYNTHETIC, RETURN, SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0133 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0087 A:{SYNTHETIC, Splitter: B:28:0x0087} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0133 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A:{SYNTHETIC, RETURN, SKIP} */
    /* JADX WARNING: Missing block: B:15:0x003d, code:
            if (r6.length() == 0) goto L_0x0046;
     */
    static void a(android.content.Context r9, java.util.Map<java.lang.String, java.lang.Object> r10) {
        /*
        r0 = "Trying to fetch GAID..";
        com.appsflyer.AFLogger.an(r0);
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = com.google.android.gms.common.GoogleApiAvailability.getInstance();	 Catch:{ Throwable -> 0x0013 }
        r1 = r1.isGooglePlayServicesAvailable(r9);	 Catch:{ Throwable -> 0x0013 }
        goto L_0x001c;
    L_0x0013:
        r1 = move-exception;
        r2 = r1.getMessage();
        com.appsflyer.AFLogger.a(r2, r1);
        r1 = -1;
    L_0x001c:
        r2 = 0;
        r3 = 1;
        r4 = 0;
        r5 = "com.google.android.gms.ads.identifier.AdvertisingIdClient";
        java.lang.Class.forName(r5);	 Catch:{ Throwable -> 0x005d }
        r5 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r9);	 Catch:{ Throwable -> 0x005d }
        if (r5 == 0) goto L_0x0050;
    L_0x002a:
        r6 = r5.getId();	 Catch:{ Throwable -> 0x005d }
        r5 = r5.isLimitAdTrackingEnabled();	 Catch:{ Throwable -> 0x004e }
        r5 = r5 ^ r3;
        r5 = java.lang.Boolean.toString(r5);	 Catch:{ Throwable -> 0x004e }
        if (r6 == 0) goto L_0x0046;
    L_0x0039:
        r2 = r6.length();	 Catch:{ Throwable -> 0x0040 }
        if (r2 != 0) goto L_0x004b;
    L_0x003f:
        goto L_0x0046;
    L_0x0040:
        r2 = move-exception;
        r4 = 1;
        r8 = r5;
        r5 = r2;
        r2 = r8;
        goto L_0x005f;
    L_0x0046:
        r2 = "emptyOrNull |";
        r0.append(r2);	 Catch:{ Throwable -> 0x0040 }
    L_0x004b:
        r4 = 1;
        goto L_0x00e9;
    L_0x004e:
        r5 = move-exception;
        goto L_0x005f;
    L_0x0050:
        r5 = "gpsAdInfo-null |";
        r0.append(r5);	 Catch:{ Throwable -> 0x005d }
        r5 = new com.appsflyer.o$e;	 Catch:{ Throwable -> 0x005d }
        r6 = "GpsAdIndo is null";
        r5.<init>(r6);	 Catch:{ Throwable -> 0x005d }
        throw r5;	 Catch:{ Throwable -> 0x005d }
    L_0x005d:
        r5 = move-exception;
        r6 = r2;
    L_0x005f:
        r7 = r5.getMessage();
        com.appsflyer.AFLogger.a(r7, r5);
        r5 = r5.getClass();
        r5 = r5.getSimpleName();
        r0.append(r5);
        r5 = " |";
        r0.append(r5);
        r5 = "WARNING: Google Play Services is missing.";
        com.appsflyer.AFLogger.an(r5);
        r5 = com.appsflyer.i.fF();
        r7 = "enableGpsFallback";
        r5 = r5.getBoolean(r7, r3);
        if (r5 == 0) goto L_0x00e8;
    L_0x0087:
        r2 = com.appsflyer.aa.H(r9);	 Catch:{ Throwable -> 0x00a6 }
        r6 = r2.fw();	 Catch:{ Throwable -> 0x00a6 }
        r2 = r2.fX();	 Catch:{ Throwable -> 0x00a6 }
        r2 = r2 ^ r3;
        r5 = java.lang.Boolean.toString(r2);	 Catch:{ Throwable -> 0x00a6 }
        if (r6 == 0) goto L_0x00a0;
    L_0x009a:
        r2 = r6.length();	 Catch:{ Throwable -> 0x00a6 }
        if (r2 != 0) goto L_0x00e9;
    L_0x00a0:
        r2 = "emptyOrNull (bypass) |";
        r0.append(r2);	 Catch:{ Throwable -> 0x00a6 }
        goto L_0x00e9;
    L_0x00a6:
        r2 = move-exception;
        r3 = r2.getMessage();
        com.appsflyer.AFLogger.a(r3, r2);
        r3 = r2.getClass();
        r3 = r3.getSimpleName();
        r0.append(r3);
        r3 = " |";
        r0.append(r3);
        r3 = com.appsflyer.i.fF();
        r5 = "advertiserId";
        r6 = r3.getString(r5);
        r3 = com.appsflyer.i.fF();
        r5 = "advertiserIdEnabled";
        r5 = r3.getString(r5);
        r3 = r2.getLocalizedMessage();
        if (r3 == 0) goto L_0x00e0;
    L_0x00d8:
        r2 = r2.getLocalizedMessage();
        com.appsflyer.AFLogger.an(r2);
        goto L_0x00e9;
    L_0x00e0:
        r2 = r2.toString();
        com.appsflyer.AFLogger.an(r2);
        goto L_0x00e9;
    L_0x00e8:
        r5 = r2;
    L_0x00e9:
        r9 = r9.getClass();
        r9 = r9.getName();
        r2 = "android.app.ReceiverRestrictedContext";
        r9 = r9.equals(r2);
        if (r9 == 0) goto L_0x0112;
    L_0x00f9:
        r9 = com.appsflyer.i.fF();
        r2 = "advertiserId";
        r6 = r9.getString(r2);
        r9 = com.appsflyer.i.fF();
        r2 = "advertiserIdEnabled";
        r5 = r9.getString(r2);
        r9 = "context = android.app.ReceiverRestrictedContext |";
        r0.append(r9);
    L_0x0112:
        r9 = r0.length();
        if (r9 <= 0) goto L_0x0131;
    L_0x0118:
        r9 = "gaidError";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r1);
        r1 = ": ";
        r2.append(r1);
        r2.append(r0);
        r0 = r2.toString();
        r10.put(r9, r0);
    L_0x0131:
        if (r6 == 0) goto L_0x015a;
    L_0x0133:
        if (r5 == 0) goto L_0x015a;
    L_0x0135:
        r9 = "advertiserId";
        r10.put(r9, r6);
        r9 = "advertiserIdEnabled";
        r10.put(r9, r5);
        r9 = com.appsflyer.i.fF();
        r0 = "advertiserId";
        r9.set(r0, r6);
        r9 = com.appsflyer.i.fF();
        r0 = "advertiserIdEnabled";
        r9.set(r0, r5);
        r9 = "isGaidWithGps";
        r0 = java.lang.String.valueOf(r4);
        r10.put(r9, r0);
    L_0x015a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.o.a(android.content.Context, java.util.Map):void");
    }
}
