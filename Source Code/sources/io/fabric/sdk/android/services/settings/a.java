package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.h;
import io.fabric.sdk.android.j;
import io.fabric.sdk.android.services.common.p;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.c;
import java.util.Locale;

/* compiled from: AbstractAppSpiCall */
abstract class a extends io.fabric.sdk.android.services.common.a {
    public a(h hVar, String str, String str2, c cVar, HttpMethod httpMethod) {
        super(hVar, str, str2, cVar, httpMethod);
    }

    public boolean a(d dVar) {
        HttpRequest b = b(a(aUt(), dVar), dVar);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Sending app info to ");
        stringBuilder.append(getUrl());
        io.fabric.sdk.android.c.aUg().d("Fabric", stringBuilder.toString());
        if (dVar.epd != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("App icon hash is ");
            stringBuilder.append(dVar.epd.eoW);
            io.fabric.sdk.android.c.aUg().d("Fabric", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("App icon size is ");
            stringBuilder.append(dVar.epd.width);
            stringBuilder.append("x");
            stringBuilder.append(dVar.epd.height);
            io.fabric.sdk.android.c.aUg().d("Fabric", stringBuilder.toString());
        }
        int code = b.code();
        String str = "POST".equals(b.method()) ? "Create" : "Update";
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(" app request ID: ");
        stringBuilder2.append(b.header("X-REQUEST-ID"));
        io.fabric.sdk.android.c.aUg().d("Fabric", stringBuilder2.toString());
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("Result was ");
        stringBuilder3.append(code);
        io.fabric.sdk.android.c.aUg().d("Fabric", stringBuilder3.toString());
        return p.iX(code) == 0;
    }

    private HttpRequest a(HttpRequest httpRequest, d dVar) {
        return httpRequest.aS("X-CRASHLYTICS-API-KEY", dVar.sO).aS("X-CRASHLYTICS-API-CLIENT-TYPE", "android").aS("X-CRASHLYTICS-API-CLIENT-VERSION", this.rR.getVersion());
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ca  */
    private io.fabric.sdk.android.services.network.HttpRequest b(io.fabric.sdk.android.services.network.HttpRequest r8, io.fabric.sdk.android.services.settings.d r9) {
        /*
        r7 = this;
        r0 = "app[identifier]";
        r1 = r9.appId;
        r8 = r8.aW(r0, r1);
        r0 = "app[name]";
        r1 = r9.name;
        r8 = r8.aW(r0, r1);
        r0 = "app[display_version]";
        r1 = r9.eoX;
        r8 = r8.aW(r0, r1);
        r0 = "app[build_version]";
        r1 = r9.eoY;
        r8 = r8.aW(r0, r1);
        r0 = "app[source]";
        r1 = r9.epa;
        r1 = java.lang.Integer.valueOf(r1);
        r8 = r8.b(r0, r1);
        r0 = "app[minimum_sdk_version]";
        r1 = r9.epb;
        r8 = r8.aW(r0, r1);
        r0 = "app[built_sdk_version]";
        r1 = r9.epc;
        r8 = r8.aW(r0, r1);
        r0 = r9.eoZ;
        r0 = io.fabric.sdk.android.services.common.CommonUtils.bc(r0);
        if (r0 != 0) goto L_0x004b;
    L_0x0044:
        r0 = "app[instance_identifier]";
        r1 = r9.eoZ;
        r8.aW(r0, r1);
    L_0x004b:
        r0 = r9.epd;
        if (r0 == 0) goto L_0x00c6;
    L_0x004f:
        r0 = 0;
        r1 = r7.rR;	 Catch:{ NotFoundException -> 0x0097, all -> 0x0094 }
        r1 = r1.getContext();	 Catch:{ NotFoundException -> 0x0097, all -> 0x0094 }
        r1 = r1.getResources();	 Catch:{ NotFoundException -> 0x0097, all -> 0x0094 }
        r2 = r9.epd;	 Catch:{ NotFoundException -> 0x0097, all -> 0x0094 }
        r2 = r2.epu;	 Catch:{ NotFoundException -> 0x0097, all -> 0x0094 }
        r1 = r1.openRawResource(r2);	 Catch:{ NotFoundException -> 0x0097, all -> 0x0094 }
        r0 = "app[icon][hash]";
        r2 = r9.epd;	 Catch:{ NotFoundException -> 0x0092 }
        r2 = r2.eoW;	 Catch:{ NotFoundException -> 0x0092 }
        r0 = r8.aW(r0, r2);	 Catch:{ NotFoundException -> 0x0092 }
        r2 = "app[icon][data]";
        r3 = "icon.png";
        r4 = "application/octet-stream";
        r0 = r0.a(r2, r3, r4, r1);	 Catch:{ NotFoundException -> 0x0092 }
        r2 = "app[icon][width]";
        r3 = r9.epd;	 Catch:{ NotFoundException -> 0x0092 }
        r3 = r3.width;	 Catch:{ NotFoundException -> 0x0092 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ NotFoundException -> 0x0092 }
        r0 = r0.b(r2, r3);	 Catch:{ NotFoundException -> 0x0092 }
        r2 = "app[icon][height]";
        r3 = r9.epd;	 Catch:{ NotFoundException -> 0x0092 }
        r3 = r3.height;	 Catch:{ NotFoundException -> 0x0092 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ NotFoundException -> 0x0092 }
        r0.b(r2, r3);	 Catch:{ NotFoundException -> 0x0092 }
        goto L_0x00b9;
    L_0x0092:
        r0 = move-exception;
        goto L_0x009b;
    L_0x0094:
        r8 = move-exception;
        r1 = r0;
        goto L_0x00c0;
    L_0x0097:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
    L_0x009b:
        r2 = io.fabric.sdk.android.c.aUg();	 Catch:{ all -> 0x00bf }
        r3 = "Fabric";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00bf }
        r4.<init>();	 Catch:{ all -> 0x00bf }
        r5 = "Failed to find app icon with resource ID: ";
        r4.append(r5);	 Catch:{ all -> 0x00bf }
        r5 = r9.epd;	 Catch:{ all -> 0x00bf }
        r5 = r5.epu;	 Catch:{ all -> 0x00bf }
        r4.append(r5);	 Catch:{ all -> 0x00bf }
        r4 = r4.toString();	 Catch:{ all -> 0x00bf }
        r2.e(r3, r4, r0);	 Catch:{ all -> 0x00bf }
    L_0x00b9:
        r0 = "Failed to close app icon InputStream.";
        io.fabric.sdk.android.services.common.CommonUtils.a(r1, r0);
        goto L_0x00c6;
    L_0x00bf:
        r8 = move-exception;
    L_0x00c0:
        r9 = "Failed to close app icon InputStream.";
        io.fabric.sdk.android.services.common.CommonUtils.a(r1, r9);
        throw r8;
    L_0x00c6:
        r0 = r9.epe;
        if (r0 == 0) goto L_0x00f3;
    L_0x00ca:
        r9 = r9.epe;
        r9 = r9.iterator();
    L_0x00d0:
        r0 = r9.hasNext();
        if (r0 == 0) goto L_0x00f3;
    L_0x00d6:
        r0 = r9.next();
        r0 = (io.fabric.sdk.android.j) r0;
        r1 = r7.a(r0);
        r2 = r0.getVersion();
        r8.aW(r1, r2);
        r1 = r7.b(r0);
        r0 = r0.aUr();
        r8.aW(r1, r0);
        goto L_0x00d0;
    L_0x00f3:
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.settings.a.b(io.fabric.sdk.android.services.network.HttpRequest, io.fabric.sdk.android.services.settings.d):io.fabric.sdk.android.services.network.HttpRequest");
    }

    String a(j jVar) {
        return String.format(Locale.US, "app[build][libraries][%s][version]", new Object[]{jVar.getIdentifier()});
    }

    String b(j jVar) {
        return String.format(Locale.US, "app[build][libraries][%s][type]", new Object[]{jVar.getIdentifier()});
    }
}
