package com.crashlytics.android.core;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.settings.o;

/* compiled from: DialogStringResolver */
class x {
    private final Context context;
    private final o uL;

    public x(Context context, o oVar) {
        this.context = context;
        this.uL = oVar;
    }

    public String getTitle() {
        return q("com.crashlytics.CrashSubmissionPromptTitle", this.uL.title);
    }

    public String getMessage() {
        return q("com.crashlytics.CrashSubmissionPromptMessage", this.uL.message);
    }

    public String hL() {
        return q("com.crashlytics.CrashSubmissionSendTitle", this.uL.epv);
    }

    public String hM() {
        return q("com.crashlytics.CrashSubmissionAlwaysSendTitle", this.uL.epz);
    }

    public String hN() {
        return q("com.crashlytics.CrashSubmissionCancelTitle", this.uL.epx);
    }

    private String q(String str, String str2) {
        return r(CommonUtils.I(this.context, str), str2);
    }

    private String r(String str, String str2) {
        return bc(str) ? str2 : str;
    }

    private boolean bc(String str) {
        return str == null || str.length() == 0;
    }
}
