package com.google.android.gms.internal;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.SSLSocketFactory;

public final class zzas extends zzai {
    private final zzat zzcg;
    private final SSLSocketFactory zzch;

    public zzas() {
        this(null);
    }

    private zzas(zzat zzat) {
        this(null, null);
    }

    private zzas(zzat zzat, SSLSocketFactory sSLSocketFactory) {
        this.zzcg = null;
        this.zzch = null;
    }

    private static InputStream zza(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    private static void zza(HttpURLConnection httpURLConnection, zzr<?> zzr) {
        byte[] zzf = zzr.zzf();
        if (zzf != null) {
            httpURLConnection.setDoOutput(true);
            String str = "Content-Type";
            String str2 = "application/x-www-form-urlencoded; charset=";
            String valueOf = String.valueOf("UTF-8");
            httpURLConnection.addRequestProperty(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(zzf);
            dataOutputStream.close();
        }
    }

    private static List<zzl> zzc(Map<String, List<String>> map) {
        List<zzl> arrayList = new ArrayList(map.size());
        for (Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                for (String zzl : (List) entry.getValue()) {
                    arrayList.add(new zzl((String) entry.getKey(), zzl));
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Missing block: B:26:0x00ab, code:
            r8.setRequestMethod(r0);
            zza(r8, (com.google.android.gms.internal.zzr) r7);
     */
    /* JADX WARNING: Missing block: B:28:0x00b4, code:
            r8.setRequestMethod(r0);
     */
    public final com.google.android.gms.internal.zzaq zza(com.google.android.gms.internal.zzr<?> r7, java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
        r6 = this;
        r0 = r7.getUrl();
        r1 = new java.util.HashMap;
        r1.<init>();
        r2 = r7.getHeaders();
        r1.putAll(r2);
        r1.putAll(r8);
        r8 = r6.zzcg;
        if (r8 == 0) goto L_0x003c;
    L_0x0017:
        r8 = r6.zzcg;
        r8 = r8.zzg(r0);
        if (r8 != 0) goto L_0x003d;
    L_0x001f:
        r7 = new java.io.IOException;
        r8 = "URL blocked by rewriter: ";
        r0 = java.lang.String.valueOf(r0);
        r1 = r0.length();
        if (r1 == 0) goto L_0x0032;
    L_0x002d:
        r8 = r8.concat(r0);
        goto L_0x0038;
    L_0x0032:
        r0 = new java.lang.String;
        r0.<init>(r8);
        r8 = r0;
    L_0x0038:
        r7.<init>(r8);
        throw r7;
    L_0x003c:
        r8 = r0;
    L_0x003d:
        r0 = new java.net.URL;
        r0.<init>(r8);
        r8 = r0.openConnection();
        r8 = (java.net.HttpURLConnection) r8;
        r2 = java.net.HttpURLConnection.getFollowRedirects();
        r8.setInstanceFollowRedirects(r2);
        r2 = r7.zzh();
        r8.setConnectTimeout(r2);
        r8.setReadTimeout(r2);
        r2 = 0;
        r8.setUseCaches(r2);
        r3 = 1;
        r8.setDoInput(r3);
        r4 = "https";
        r0 = r0.getProtocol();
        r4.equals(r0);
        r0 = r1.keySet();
        r0 = r0.iterator();
    L_0x0072:
        r4 = r0.hasNext();
        if (r4 == 0) goto L_0x0088;
    L_0x0078:
        r4 = r0.next();
        r4 = (java.lang.String) r4;
        r5 = r1.get(r4);
        r5 = (java.lang.String) r5;
        r8.addRequestProperty(r4, r5);
        goto L_0x0072;
    L_0x0088:
        r0 = r7.getMethod();
        switch(r0) {
            case -1: goto L_0x00b7;
            case 0: goto L_0x00b2;
            case 1: goto L_0x00a9;
            case 2: goto L_0x00a6;
            case 3: goto L_0x00a3;
            case 4: goto L_0x00a0;
            case 5: goto L_0x009d;
            case 6: goto L_0x009a;
            case 7: goto L_0x0097;
            default: goto L_0x008f;
        };
    L_0x008f:
        r7 = new java.lang.IllegalStateException;
        r8 = "Unknown method type.";
        r7.<init>(r8);
        throw r7;
    L_0x0097:
        r0 = "PATCH";
        goto L_0x00ab;
    L_0x009a:
        r0 = "TRACE";
        goto L_0x00b4;
    L_0x009d:
        r0 = "OPTIONS";
        goto L_0x00b4;
    L_0x00a0:
        r0 = "HEAD";
        goto L_0x00b4;
    L_0x00a3:
        r0 = "DELETE";
        goto L_0x00b4;
    L_0x00a6:
        r0 = "PUT";
        goto L_0x00ab;
    L_0x00a9:
        r0 = "POST";
    L_0x00ab:
        r8.setRequestMethod(r0);
        zza(r8, r7);
        goto L_0x00b7;
    L_0x00b2:
        r0 = "GET";
    L_0x00b4:
        r8.setRequestMethod(r0);
    L_0x00b7:
        r0 = r8.getResponseCode();
        r1 = -1;
        if (r0 != r1) goto L_0x00c6;
    L_0x00be:
        r7 = new java.io.IOException;
        r8 = "Could not retrieve response code from HttpUrlConnection.";
        r7.<init>(r8);
        throw r7;
    L_0x00c6:
        r7 = r7.getMethod();
        r1 = 4;
        if (r7 == r1) goto L_0x00de;
    L_0x00cd:
        r7 = 100;
        if (r7 > r0) goto L_0x00d5;
    L_0x00d1:
        r7 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 < r7) goto L_0x00de;
    L_0x00d5:
        r7 = 204; // 0xcc float:2.86E-43 double:1.01E-321;
        if (r0 == r7) goto L_0x00de;
    L_0x00d9:
        r7 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        if (r0 == r7) goto L_0x00de;
    L_0x00dd:
        r2 = 1;
    L_0x00de:
        if (r2 != 0) goto L_0x00ee;
    L_0x00e0:
        r7 = new com.google.android.gms.internal.zzaq;
        r8 = r8.getHeaderFields();
        r8 = zzc(r8);
        r7.<init>(r0, r8);
        return r7;
    L_0x00ee:
        r7 = new com.google.android.gms.internal.zzaq;
        r1 = r8.getHeaderFields();
        r1 = zzc(r1);
        r2 = r8.getContentLength();
        r8 = zza(r8);
        r7.<init>(r0, r1, r2, r8);
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzas.zza(com.google.android.gms.internal.zzr, java.util.Map):com.google.android.gms.internal.zzaq");
    }
}
