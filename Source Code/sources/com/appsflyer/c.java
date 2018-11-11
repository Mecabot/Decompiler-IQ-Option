package com.appsflyer;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec.Builder;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyPairGeneratorSpi;
import java.security.KeyStore;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Calendar;
import java.util.Enumeration;
import javax.security.auth.x500.X500Principal;

class c {
    private final Object ph = new Object();
    private KeyStore pi;
    private Context pj;
    private String pk;
    private int pl;

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0027 A:{Splitter: B:1:0x0018, ExcHandler: java.io.IOException (r2_7 'e' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x0027 A:{Splitter: B:1:0x0018, ExcHandler: java.io.IOException (r2_7 'e' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x0027 A:{Splitter: B:1:0x0018, ExcHandler: java.io.IOException (r2_7 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:4:0x0027, code:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:5:0x0028, code:
            com.appsflyer.AFLogger.a("Couldn't load keystore instance of type: AndroidKeyStore", r2);
     */
    /* JADX WARNING: Missing block: B:6:0x002d, code:
            return;
     */
    public c(android.content.Context r2) {
        /*
        r1 = this;
        r1.<init>();
        r0 = new java.lang.Object;
        r0.<init>();
        r1.ph = r0;
        r1.pj = r2;
        r2 = "";
        r1.pk = r2;
        r2 = 0;
        r1.pl = r2;
        r2 = "Initialising KeyStore..";
        com.appsflyer.AFLogger.an(r2);
        r2 = "AndroidKeyStore";
        r2 = java.security.KeyStore.getInstance(r2);	 Catch:{ IOException -> 0x0027, IOException -> 0x0027, IOException -> 0x0027, IOException -> 0x0027 }
        r1.pi = r2;	 Catch:{ IOException -> 0x0027, IOException -> 0x0027, IOException -> 0x0027, IOException -> 0x0027 }
        r2 = r1.pi;	 Catch:{ IOException -> 0x0027, IOException -> 0x0027, IOException -> 0x0027, IOException -> 0x0027 }
        r0 = 0;
        r2.load(r0);	 Catch:{ IOException -> 0x0027, IOException -> 0x0027, IOException -> 0x0027, IOException -> 0x0027 }
        return;
    L_0x0027:
        r2 = move-exception;
        r0 = "Couldn't load keystore instance of type: AndroidKeyStore";
        com.appsflyer.AFLogger.a(r0, r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.c.<init>(android.content.Context):void");
    }

    final void ah(String str) {
        this.pk = str;
        this.pl = 0;
        ai(fv());
    }

    final void ft() {
        String fv = fv();
        synchronized (this.ph) {
            this.pl++;
            AFLogger.an("Deleting key with alias: ".concat(String.valueOf(fv)));
            try {
                synchronized (this.ph) {
                    this.pi.deleteEntry(fv);
                }
            } catch (Throwable e) {
                StringBuilder stringBuilder = new StringBuilder("Exception ");
                stringBuilder.append(e.getMessage());
                stringBuilder.append(" occurred");
                AFLogger.a(stringBuilder.toString(), e);
            }
        }
        ai(fv());
    }

    final boolean fu() {
        boolean z;
        Throwable th;
        StringBuilder stringBuilder;
        synchronized (this.ph) {
            z = true;
            if (this.pi != null) {
                try {
                    Enumeration aliases = this.pi.aliases();
                    while (aliases.hasMoreElements()) {
                        String str = (String) aliases.nextElement();
                        if (str != null && str.startsWith("com.appsflyer")) {
                            String[] split = str.split(",");
                            if (split.length == 3) {
                                AFLogger.an("Found a matching AF key with alias:\n".concat(String.valueOf(str)));
                                try {
                                    String[] split2 = split[1].trim().split("=");
                                    split = split[2].trim().split("=");
                                    if (split2.length == 2 && split.length == 2) {
                                        this.pk = split2[1].trim();
                                        this.pl = Integer.parseInt(split[1].trim());
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    stringBuilder = new StringBuilder("Couldn't list KeyStore Aliases: ");
                                    stringBuilder.append(th.getClass().getName());
                                    AFLogger.a(stringBuilder.toString(), th);
                                    return z;
                                }
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    z = false;
                    stringBuilder = new StringBuilder("Couldn't list KeyStore Aliases: ");
                    stringBuilder.append(th.getClass().getName());
                    AFLogger.a(stringBuilder.toString(), th);
                    return z;
                }
            }
            z = false;
        }
        return z;
    }

    private void ai(String str) {
        AFLogger.an("Creating a new key with alias: ".concat(String.valueOf(str)));
        try {
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            instance2.add(1, 5);
            AlgorithmParameterSpec algorithmParameterSpec = null;
            synchronized (this.ph) {
                if (this.pi.containsAlias(str)) {
                    AFLogger.an("Alias already exists: ".concat(String.valueOf(str)));
                } else {
                    if (VERSION.SDK_INT >= 23) {
                        algorithmParameterSpec = new Builder(str, 3).setCertificateSubject(new X500Principal("CN=AndroidSDK, O=AppsFlyer")).setCertificateSerialNumber(BigInteger.ONE).setCertificateNotBefore(instance.getTime()).setCertificateNotAfter(instance2.getTime()).build();
                    } else if (VERSION.SDK_INT >= 18 && !"OPPO".equals(Build.BRAND)) {
                        algorithmParameterSpec = new KeyPairGeneratorSpec.Builder(this.pj).setAlias(str).setSubject(new X500Principal("CN=AndroidSDK, O=AppsFlyer")).setSerialNumber(BigInteger.ONE).setStartDate(instance.getTime()).setEndDate(instance2.getTime()).build();
                    }
                    KeyPairGeneratorSpi instance3 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                    instance3.initialize(algorithmParameterSpec);
                    instance3.generateKeyPair();
                }
            }
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("Exception ");
            stringBuilder.append(th.getMessage());
            stringBuilder.append(" occurred");
            AFLogger.a(stringBuilder.toString(), th);
        }
    }

    private String fv() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("com.appsflyer,");
        synchronized (this.ph) {
            stringBuilder.append("KSAppsFlyerId=");
            stringBuilder.append(this.pk);
            stringBuilder.append(",");
            stringBuilder.append("KSAppsFlyerRICounter=");
            stringBuilder.append(this.pl);
        }
        return stringBuilder.toString();
    }

    final String fw() {
        String str;
        synchronized (this.ph) {
            str = this.pk;
        }
        return str;
    }

    final int fx() {
        int i;
        synchronized (this.ph) {
            i = this.pl;
        }
        return i;
    }
}
