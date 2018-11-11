package com.crashlytics.android.answers;

import io.fabric.sdk.android.h;
import io.fabric.sdk.android.services.b.f;
import io.fabric.sdk.android.services.common.a;
import io.fabric.sdk.android.services.common.p;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.c;
import java.io.File;
import java.util.List;

/* compiled from: SessionAnalyticsFilesSender */
class y extends a implements f {
    private final String sO;

    public y(h hVar, String str, String str2, c cVar, String str3) {
        super(hVar, str, str2, cVar, HttpMethod.POST);
        this.sO = str3;
    }

    public boolean q(List<File> list) {
        HttpRequest aS = aUt().aS("X-CRASHLYTICS-API-CLIENT-TYPE", "android").aS("X-CRASHLYTICS-API-CLIENT-VERSION", this.rR.getVersion()).aS("X-CRASHLYTICS-API-KEY", this.sO);
        int i = 0;
        for (File file : list) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("session_analytics_file_");
            stringBuilder.append(i);
            aS.a(stringBuilder.toString(), file.getName(), "application/vnd.crashlytics.android.events", file);
            i++;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Sending ");
        stringBuilder2.append(list.size());
        stringBuilder2.append(" analytics files to ");
        stringBuilder2.append(getUrl());
        io.fabric.sdk.android.c.aUg().d("Answers", stringBuilder2.toString());
        int code = aS.code();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("Response code for analytics file send is ");
        stringBuilder3.append(code);
        io.fabric.sdk.android.c.aUg().d("Answers", stringBuilder3.toString());
        if (p.iX(code) == 0) {
            return true;
        }
        return false;
    }
}
