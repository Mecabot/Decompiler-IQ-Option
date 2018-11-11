package com.iqoption.mobbtech.connect.response;

import android.content.Context;
import android.text.TextUtils;
import com.iqoption.app.a.b;
import com.iqoption.core.i;
import org.json.JSONObject;

/* compiled from: MobbError */
public class g {
    private static final String TAG = "com.iqoption.mobbtech.connect.response.g";
    private JSONObject cVN;
    private Object cVO;
    private int code = -100;
    private String message;

    public g(String str) {
        iJ(str);
    }

    public int getCode() {
        return this.code;
    }

    public void fv(int i) {
        this.code = i;
    }

    public String getMessage() {
        return this.message != null ? this.message : "";
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public JSONObject auS() {
        return this.cVN;
    }

    /* JADX WARNING: Removed duplicated region for block: B:2:0x0007 A:{RETURN, Splitter: B:0:0x0000, ExcHandler: org.json.JSONException (unused org.json.JSONException)} */
    /* JADX WARNING: Missing block: B:2:0x0007, code:
            return;
     */
    public void iJ(java.lang.String r2) {
        /*
        r1 = this;
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0007, JSONException -> 0x0007 }
        r0.<init>(r2);	 Catch:{ JSONException -> 0x0007, JSONException -> 0x0007 }
        r1.cVN = r0;	 Catch:{ JSONException -> 0x0007, JSONException -> 0x0007 }
    L_0x0007:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.mobbtech.connect.response.g.iJ(java.lang.String):void");
    }

    public void bG(Context context) {
        Object errorMessage = getErrorMessage();
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("error: ");
        stringBuilder.append(errorMessage);
        i.e(str, stringBuilder.toString());
        if (TextUtils.isEmpty(errorMessage)) {
            b.aT(context);
        } else {
            b.b(errorMessage, context);
        }
    }

    public String getErrorMessage() {
        String str;
        if (auS() == null) {
            str = null;
        } else if (auS().optJSONArray("message") == null || auS().optJSONArray("message").length() <= 0) {
            str = auS().optString("message");
        } else {
            str = auS().optJSONArray("message").optString(0);
        }
        return TextUtils.isEmpty(str) ? this.message : str;
    }

    public void by(Object obj) {
        this.cVO = obj;
    }

    public Object auT() {
        return this.cVO;
    }

    public String toString() {
        String errorMessage = getErrorMessage();
        return TextUtils.isEmpty(errorMessage) ? super.toString() : errorMessage;
    }
}
