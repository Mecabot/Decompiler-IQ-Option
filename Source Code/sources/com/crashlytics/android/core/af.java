package com.crashlytics.android.core;

import io.fabric.sdk.android.h;
import io.fabric.sdk.android.services.common.a;
import io.fabric.sdk.android.services.common.p;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.c;
import java.io.File;

/* compiled from: NativeCreateReportSpiCall */
class af extends a implements t {
    public af(h hVar, String str, String str2, c cVar) {
        super(hVar, str, str2, cVar, HttpMethod.POST);
    }

    public boolean a(s sVar) {
        HttpRequest a = a(a(aUt(), sVar.sO), sVar.uO);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Sending report to: ");
        stringBuilder.append(getUrl());
        io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", stringBuilder.toString());
        int code = a.code();
        stringBuilder = new StringBuilder();
        stringBuilder.append("Result was: ");
        stringBuilder.append(code);
        io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", stringBuilder.toString());
        return p.iX(code) == 0;
    }

    private HttpRequest a(HttpRequest httpRequest, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Crashlytics Android SDK/");
        stringBuilder.append(this.rR.getVersion());
        httpRequest.aS("User-Agent", stringBuilder.toString()).aS("X-CRASHLYTICS-API-CLIENT-TYPE", "android").aS("X-CRASHLYTICS-API-CLIENT-VERSION", this.rR.getVersion()).aS("X-CRASHLYTICS-API-KEY", str);
        return httpRequest;
    }

    private HttpRequest a(HttpRequest httpRequest, Report report) {
        httpRequest.aW("report_id", report.getIdentifier());
        for (File file : report.getFiles()) {
            if (file.getName().equals("minidump")) {
                httpRequest.a("minidump_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("metadata")) {
                httpRequest.a("crash_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("binaryImages")) {
                httpRequest.a("binary_images_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("session")) {
                httpRequest.a("session_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("app")) {
                httpRequest.a("app_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("device")) {
                httpRequest.a("device_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("os")) {
                httpRequest.a("os_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("user")) {
                httpRequest.a("user_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("logs")) {
                httpRequest.a("logs_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("keys")) {
                httpRequest.a("keys_file", file.getName(), "application/octet-stream", file);
            }
        }
        return httpRequest;
    }
}
