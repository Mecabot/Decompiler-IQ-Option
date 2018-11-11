package com.jumio.commons.json;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class JumioJSONObject extends JSONObject {
    private JSONStringer stringer = null;

    public JumioJSONObject(String str) {
        super(str);
    }

    public StringBuilder getStringBuilder(String str) {
        Object obj = get(str);
        StringBuilder toStringBuilder = JSON.toStringBuilder(obj);
        if (toStringBuilder != null) {
            return toStringBuilder;
        }
        throw JSON.typeMismatch(str, obj, "StringBuilder");
    }

    public StringBuilder optStringBuilder(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        return optStringBuilder(str, stringBuilder);
    }

    public StringBuilder optStringBuilder(String str, StringBuilder stringBuilder) {
        StringBuilder toStringBuilder = JSON.toStringBuilder(opt(str));
        return toStringBuilder != null ? toStringBuilder : stringBuilder;
    }

    /* JADX WARNING: Can't wrap try/catch for R(4:6|7|(2:9|23)(2:10|(2:12|24)(2:13|(2:15|25)(2:16|(3:18|19|27)(1:26))))|4) */
    /* JADX WARNING: Missing block: B:5:0x0011, code:
            if (r0.hasNext() != false) goto L_0x0013;
     */
    /* JADX WARNING: Missing block: B:7:?, code:
            r1 = opt((java.lang.String) r0.next());
     */
    /* JADX WARNING: Missing block: B:8:0x001d, code:
            if (r1 == null) goto L_0x001f;
     */
    /* JADX WARNING: Missing block: B:11:0x0022, code:
            if ((r1 instanceof java.lang.StringBuilder) != false) goto L_0x0024;
     */
    /* JADX WARNING: Missing block: B:12:0x0024, code:
            overwriteStringBuilder((java.lang.StringBuilder) r1);
     */
    /* JADX WARNING: Missing block: B:14:0x002c, code:
            if ((r1 instanceof com.jumio.commons.json.JumioJSONArray) != false) goto L_0x002e;
     */
    /* JADX WARNING: Missing block: B:15:0x002e, code:
            ((com.jumio.commons.json.JumioJSONArray) r1).clear();
     */
    /* JADX WARNING: Missing block: B:17:0x0036, code:
            if ((r1 instanceof com.jumio.commons.json.JumioJSONObject) != false) goto L_0x0038;
     */
    /* JADX WARNING: Missing block: B:18:0x0038, code:
            ((com.jumio.commons.json.JumioJSONObject) r1).clear();
     */
    /* JADX WARNING: Missing block: B:20:0x003e, code:
            return;
     */
    public void clear() {
        /*
        r3 = this;
        r0 = r3.stringer;
        if (r0 == 0) goto L_0x0009;
    L_0x0004:
        r0 = r3.stringer;
        r0.clear();
    L_0x0009:
        r0 = r3.keys();
    L_0x000d:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x003e;
    L_0x0013:
        r1 = r0.next();	 Catch:{ Exception -> 0x000d }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x000d }
        r1 = r3.opt(r1);	 Catch:{ Exception -> 0x000d }
        if (r1 != 0) goto L_0x0020;
    L_0x001f:
        goto L_0x000d;
    L_0x0020:
        r2 = r1 instanceof java.lang.StringBuilder;	 Catch:{ Exception -> 0x000d }
        if (r2 == 0) goto L_0x002a;
    L_0x0024:
        r1 = (java.lang.StringBuilder) r1;	 Catch:{ Exception -> 0x000d }
        r3.overwriteStringBuilder(r1);	 Catch:{ Exception -> 0x000d }
        goto L_0x000d;
    L_0x002a:
        r2 = r1 instanceof com.jumio.commons.json.JumioJSONArray;	 Catch:{ Exception -> 0x000d }
        if (r2 == 0) goto L_0x0034;
    L_0x002e:
        r1 = (com.jumio.commons.json.JumioJSONArray) r1;	 Catch:{ Exception -> 0x000d }
        r1.clear();	 Catch:{ Exception -> 0x000d }
        goto L_0x000d;
    L_0x0034:
        r2 = r1 instanceof com.jumio.commons.json.JumioJSONObject;	 Catch:{ Exception -> 0x000d }
        if (r2 == 0) goto L_0x000d;
    L_0x0038:
        r1 = (com.jumio.commons.json.JumioJSONObject) r1;	 Catch:{ Exception -> 0x000d }
        r1.clear();	 Catch:{ Exception -> 0x000d }
        goto L_0x000d;
    L_0x003e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.json.JumioJSONObject.clear():void");
    }

    private void overwriteStringBuilder(StringBuilder stringBuilder) {
        if (stringBuilder != null) {
            for (int i = 0; i < stringBuilder.length(); i++) {
                stringBuilder.setCharAt(i, 0);
            }
        }
    }

    public String toString() {
        try {
            if (this.stringer != null) {
                this.stringer.clear();
            }
            this.stringer = new JSONStringer();
            writeTo(this.stringer);
            return this.stringer.toString();
        } catch (JSONException unused) {
            return super.toString();
        }
    }

    public String toString(int i) {
        if (this.stringer != null) {
            this.stringer.clear();
        }
        this.stringer = new JSONStringer(i);
        writeTo(this.stringer);
        return this.stringer.toString();
    }

    public void writeTo(JSONStringer jSONStringer) {
        jSONStringer.object();
        Iterator keys = keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            jSONStringer.key(str).value(opt(str));
        }
        jSONStringer.endObject();
    }
}
