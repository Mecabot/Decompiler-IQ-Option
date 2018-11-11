package com.google.android.gms.ads.identifier;

import java.util.Map;

final class zza extends Thread {
    private /* synthetic */ Map zzamz;

    zza(AdvertisingIdClient advertisingIdClient, Map map) {
        this.zzamz = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x007f A:{Splitter: B:5:0x0037, ExcHandler: java.io.IOException (e java.io.IOException)} */
    /* JADX WARNING: Missing block: B:19:0x007f, code:
            r1 = e;
     */
    /* JADX WARNING: Missing block: B:20:0x0080, code:
            r2 = "HttpUrlPinger";
            r3 = r1.getMessage();
            r5 = new java.lang.StringBuilder((java.lang.String.valueOf(r0).length() + 27) + java.lang.String.valueOf(r3).length());
            r4 = "Error while pinging URL: ";
     */
    public final void run() {
        /*
        r6 = this;
        r0 = new com.google.android.gms.ads.identifier.zzc;
        r0.<init>();
        r0 = r6.zzamz;
        r1 = "https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps";
        r1 = android.net.Uri.parse(r1);
        r1 = r1.buildUpon();
        r2 = r0.keySet();
        r2 = r2.iterator();
    L_0x0019:
        r3 = r2.hasNext();
        if (r3 == 0) goto L_0x002f;
    L_0x001f:
        r3 = r2.next();
        r3 = (java.lang.String) r3;
        r4 = r0.get(r3);
        r4 = (java.lang.String) r4;
        r1.appendQueryParameter(r3, r4);
        goto L_0x0019;
    L_0x002f:
        r0 = r1.build();
        r0 = r0.toString();
        r1 = new java.net.URL;	 Catch:{ IndexOutOfBoundsException -> 0x00b6, IOException -> 0x007f, IOException -> 0x007f }
        r1.<init>(r0);	 Catch:{ IndexOutOfBoundsException -> 0x00b6, IOException -> 0x007f, IOException -> 0x007f }
        r1 = r1.openConnection();	 Catch:{ IndexOutOfBoundsException -> 0x00b6, IOException -> 0x007f, IOException -> 0x007f }
        r1 = (java.net.HttpURLConnection) r1;	 Catch:{ IndexOutOfBoundsException -> 0x00b6, IOException -> 0x007f, IOException -> 0x007f }
        r2 = r1.getResponseCode();	 Catch:{ all -> 0x007a }
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r2 < r3) goto L_0x004e;
    L_0x004a:
        r3 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r2 < r3) goto L_0x0076;
    L_0x004e:
        r3 = "HttpUrlPinger";
        r4 = java.lang.String.valueOf(r0);	 Catch:{ all -> 0x007a }
        r4 = r4.length();	 Catch:{ all -> 0x007a }
        r4 = r4 + 65;
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x007a }
        r5.<init>(r4);	 Catch:{ all -> 0x007a }
        r4 = "Received non-success response code ";
        r5.append(r4);	 Catch:{ all -> 0x007a }
        r5.append(r2);	 Catch:{ all -> 0x007a }
        r2 = " from pinging URL: ";
        r5.append(r2);	 Catch:{ all -> 0x007a }
        r5.append(r0);	 Catch:{ all -> 0x007a }
        r2 = r5.toString();	 Catch:{ all -> 0x007a }
        android.util.Log.w(r3, r2);	 Catch:{ all -> 0x007a }
    L_0x0076:
        r1.disconnect();	 Catch:{ IndexOutOfBoundsException -> 0x00b6, IOException -> 0x007f, IOException -> 0x007f }
        return;
    L_0x007a:
        r2 = move-exception;
        r1.disconnect();	 Catch:{ IndexOutOfBoundsException -> 0x00b6, IOException -> 0x007f, IOException -> 0x007f }
        throw r2;	 Catch:{ IndexOutOfBoundsException -> 0x00b6, IOException -> 0x007f, IOException -> 0x007f }
    L_0x007f:
        r1 = move-exception;
        r2 = "HttpUrlPinger";
        r3 = r1.getMessage();
        r4 = java.lang.String.valueOf(r0);
        r4 = r4.length();
        r4 = r4 + 27;
        r5 = java.lang.String.valueOf(r3);
        r5 = r5.length();
        r4 = r4 + r5;
        r5 = new java.lang.StringBuilder;
        r5.<init>(r4);
        r4 = "Error while pinging URL: ";
    L_0x00a0:
        r5.append(r4);
        r5.append(r0);
        r0 = ". ";
        r5.append(r0);
        r5.append(r3);
        r0 = r5.toString();
        android.util.Log.w(r2, r0, r1);
        return;
    L_0x00b6:
        r1 = move-exception;
        r2 = "HttpUrlPinger";
        r3 = r1.getMessage();
        r4 = java.lang.String.valueOf(r0);
        r4 = r4.length();
        r4 = r4 + 32;
        r5 = java.lang.String.valueOf(r3);
        r5 = r5.length();
        r4 = r4 + r5;
        r5 = new java.lang.StringBuilder;
        r5.<init>(r4);
        r4 = "Error while parsing ping URL: ";
        goto L_0x00a0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.zza.run():void");
    }
}
