package com.google.android.gms.internal;

import android.content.res.Resources.NotFoundException;

class zzasj<T extends zzasi> extends zzarh {
    private zzask<T> zzeaz;

    public zzasj(zzark zzark, zzask<T> zzask) {
        super(zzark);
        this.zzeaz = zzask;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d0 A:{Splitter: B:0:0x0000, ExcHandler: org.xmlpull.v1.XmlPullParserException (r5_1 'e' org.xmlpull.v1.XmlPullParserException)} */
    /* JADX WARNING: Missing block: B:44:0x00d0, code:
            r5 = move-exception;
     */
    /* JADX WARNING: Missing block: B:45:0x00d1, code:
            zze("Error parsing tracker configuration file", r5);
     */
    private final T zza(android.content.res.XmlResourceParser r5) {
        /*
        r4 = this;
        r5.next();	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        r0 = r5.getEventType();	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
    L_0x0007:
        r1 = 1;
        if (r0 == r1) goto L_0x00d6;
    L_0x000a:
        r0 = r5.getEventType();	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        r1 = 2;
        if (r0 != r1) goto L_0x00ca;
    L_0x0011:
        r0 = r5.getName();	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        r0 = r0.toLowerCase();	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        r1 = "screenname";
        r1 = r0.equals(r1);	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        r2 = 0;
        if (r1 == 0) goto L_0x0043;
    L_0x0022:
        r0 = "name";
        r0 = r5.getAttributeValue(r2, r0);	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        r1 = r5.nextText();	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        r1 = r1.trim();	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        r2 = android.text.TextUtils.isEmpty(r0);	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        if (r2 != 0) goto L_0x00ca;
    L_0x0036:
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        if (r2 != 0) goto L_0x00ca;
    L_0x003c:
        r2 = r4.zzeaz;	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        r2.zzi(r0, r1);	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        goto L_0x00ca;
    L_0x0043:
        r1 = "string";
        r1 = r0.equals(r1);	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        if (r1 == 0) goto L_0x0067;
    L_0x004b:
        r0 = "name";
        r0 = r5.getAttributeValue(r2, r0);	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        r1 = r5.nextText();	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        r1 = r1.trim();	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        r2 = android.text.TextUtils.isEmpty(r0);	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        if (r2 != 0) goto L_0x00ca;
    L_0x005f:
        if (r1 == 0) goto L_0x00ca;
    L_0x0061:
        r2 = r4.zzeaz;	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        r2.zzj(r0, r1);	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        goto L_0x00ca;
    L_0x0067:
        r1 = "bool";
        r1 = r0.equals(r1);	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        if (r1 == 0) goto L_0x009a;
    L_0x006f:
        r0 = "name";
        r0 = r5.getAttributeValue(r2, r0);	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        r1 = r5.nextText();	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        r1 = r1.trim();	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        r2 = android.text.TextUtils.isEmpty(r0);	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        if (r2 != 0) goto L_0x00ca;
    L_0x0083:
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        if (r2 != 0) goto L_0x00ca;
    L_0x0089:
        r2 = java.lang.Boolean.parseBoolean(r1);	 Catch:{ NumberFormatException -> 0x0093 }
        r3 = r4.zzeaz;	 Catch:{ NumberFormatException -> 0x0093 }
        r3.zzc(r0, r2);	 Catch:{ NumberFormatException -> 0x0093 }
        goto L_0x00ca;
    L_0x0093:
        r0 = move-exception;
        r2 = "Error parsing bool configuration value";
    L_0x0096:
        r4.zzc(r2, r1, r0);	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        goto L_0x00ca;
    L_0x009a:
        r1 = "integer";
        r0 = r0.equals(r1);	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        if (r0 == 0) goto L_0x00ca;
    L_0x00a2:
        r0 = "name";
        r0 = r5.getAttributeValue(r2, r0);	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        r1 = r5.nextText();	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        r1 = r1.trim();	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        r2 = android.text.TextUtils.isEmpty(r0);	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        if (r2 != 0) goto L_0x00ca;
    L_0x00b6:
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        if (r2 != 0) goto L_0x00ca;
    L_0x00bc:
        r2 = java.lang.Integer.parseInt(r1);	 Catch:{ NumberFormatException -> 0x00c6 }
        r3 = r4.zzeaz;	 Catch:{ NumberFormatException -> 0x00c6 }
        r3.zzd(r0, r2);	 Catch:{ NumberFormatException -> 0x00c6 }
        goto L_0x00ca;
    L_0x00c6:
        r0 = move-exception;
        r2 = "Error parsing int configuration value";
        goto L_0x0096;
    L_0x00ca:
        r0 = r5.next();	 Catch:{ XmlPullParserException -> 0x00d0, XmlPullParserException -> 0x00d0 }
        goto L_0x0007;
    L_0x00d0:
        r5 = move-exception;
        r0 = "Error parsing tracker configuration file";
        r4.zze(r0, r5);
    L_0x00d6:
        r5 = r4.zzeaz;
        r5 = r5.zzzt();
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzasj.zza(android.content.res.XmlResourceParser):T");
    }

    public final T zzav(int i) {
        try {
            return zza(zzxw().zzyl().getResources().getXml(i));
        } catch (NotFoundException e) {
            zzd("inflate() called with unknown resourceId", e);
            return null;
        }
    }
}
