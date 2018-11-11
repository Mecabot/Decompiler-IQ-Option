package com.crashlytics.android.answers;

/* compiled from: SessionEventMetadata */
final class ab {
    public final String osVersion;
    private String ta;
    public final String tb;
    public final String td;
    public final String te;
    public final Boolean tf;
    public final String tg;
    public final String th;
    public final String ti;
    public final String tj;
    public final String tk;

    public ab(String str, String str2, String str3, Boolean bool, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.tb = str;
        this.td = str2;
        this.te = str3;
        this.tf = bool;
        this.tg = str4;
        this.th = str5;
        this.osVersion = str6;
        this.ti = str7;
        this.tj = str8;
        this.tk = str9;
    }

    public String toString() {
        if (this.ta == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("appBundleId=");
            stringBuilder.append(this.tb);
            stringBuilder.append(", executionId=");
            stringBuilder.append(this.td);
            stringBuilder.append(", installationId=");
            stringBuilder.append(this.te);
            stringBuilder.append(", limitAdTrackingEnabled=");
            stringBuilder.append(this.tf);
            stringBuilder.append(", betaDeviceToken=");
            stringBuilder.append(this.tg);
            stringBuilder.append(", buildId=");
            stringBuilder.append(this.th);
            stringBuilder.append(", osVersion=");
            stringBuilder.append(this.osVersion);
            stringBuilder.append(", deviceModel=");
            stringBuilder.append(this.ti);
            stringBuilder.append(", appVersionCode=");
            stringBuilder.append(this.tj);
            stringBuilder.append(", appVersionName=");
            stringBuilder.append(this.tk);
            this.ta = stringBuilder.toString();
        }
        return this.ta;
    }
}
