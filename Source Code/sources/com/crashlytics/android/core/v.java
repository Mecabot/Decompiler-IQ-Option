package com.crashlytics.android.core;

import io.fabric.sdk.android.h;
import io.fabric.sdk.android.services.common.a;
import io.fabric.sdk.android.services.common.p;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.c;
import java.io.File;
import java.util.Map.Entry;

/* compiled from: DefaultCreateReportSpiCall */
class v extends a implements t {
    public v(h hVar, String str, String str2, c cVar) {
        super(hVar, str, str2, cVar, HttpMethod.POST);
    }

    public boolean a(s sVar) {
        HttpRequest a = a(a(aUt(), sVar), sVar.uO);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Sending report to: ");
        stringBuilder.append(getUrl());
        io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", stringBuilder.toString());
        int code = a.code();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Create report request ID: ");
        stringBuilder2.append(a.header("X-REQUEST-ID"));
        io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", stringBuilder2.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("Result was: ");
        stringBuilder.append(code);
        io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", stringBuilder.toString());
        return p.iX(code) == 0;
    }

    private HttpRequest a(HttpRequest httpRequest, s sVar) {
        httpRequest = httpRequest.aS("X-CRASHLYTICS-API-KEY", sVar.sO).aS("X-CRASHLYTICS-API-CLIENT-TYPE", "android").aS("X-CRASHLYTICS-API-CLIENT-VERSION", this.rR.getVersion());
        for (Entry j : sVar.uO.hS().entrySet()) {
            httpRequest = httpRequest.j(j);
        }
        return httpRequest;
    }

    private HttpRequest a(HttpRequest httpRequest, Report report) {
        httpRequest.aW("report[identifier]", report.getIdentifier());
        if (report.getFiles().length == 1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Adding single file ");
            stringBuilder.append(report.getFileName());
            stringBuilder.append(" to report ");
            stringBuilder.append(report.getIdentifier());
            io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", stringBuilder.toString());
            return httpRequest.a("report[file]", report.getFileName(), "application/octet-stream", report.getFile());
        }
        int i = 0;
        for (File file : report.getFiles()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Adding file ");
            stringBuilder2.append(file.getName());
            stringBuilder2.append(" to report ");
            stringBuilder2.append(report.getIdentifier());
            io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", stringBuilder2.toString());
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("report[file");
            stringBuilder3.append(i);
            stringBuilder3.append("]");
            httpRequest.a(stringBuilder3.toString(), file.getName(), "application/octet-stream", file);
            i++;
        }
        return httpRequest;
    }
}
