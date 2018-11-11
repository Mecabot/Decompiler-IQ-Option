package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.a;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.w;
import com.facebook.login.LoginClient.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LoginMethodHandler */
abstract class k implements Parcelable {
    Map<String, String> GZ;
    protected LoginClient Gv;

    abstract boolean a(c cVar);

    void cancel() {
    }

    void l(JSONObject jSONObject) {
    }

    abstract String mM();

    boolean nF() {
        return false;
    }

    boolean onActivityResult(int i, int i2, Intent intent) {
        return false;
    }

    k(LoginClient loginClient) {
        this.Gv = loginClient;
    }

    k(Parcel parcel) {
        this.GZ = w.g(parcel);
    }

    void a(LoginClient loginClient) {
        if (this.Gv != null) {
            throw new FacebookException("Can't set LoginClient if it is already set.");
        }
        this.Gv = loginClient;
    }

    protected String bX(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("0_auth_logger_id", str);
            jSONObject.put("3_method", mM());
            l(jSONObject);
        } catch (JSONException e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error creating client state json: ");
            stringBuilder.append(e.getMessage());
            Log.w("LoginMethodHandler", stringBuilder.toString());
        }
        return jSONObject.toString();
    }

    protected void b(String str, Object obj) {
        if (this.GZ == null) {
            this.GZ = new HashMap();
        }
        this.GZ.put(str, obj == null ? null : obj.toString());
    }

    protected void bY(String str) {
        String it = this.Gv.nc().it();
        AppEventsLogger o = AppEventsLogger.o(this.Gv.getActivity(), it);
        Bundle bundle = new Bundle();
        bundle.putString("fb_web_login_e2e", str);
        bundle.putLong("fb_web_login_switchback_time", System.currentTimeMillis());
        bundle.putString("app_id", it);
        o.a("fb_dialogs_web_login_dialog_complete", null, bundle);
    }

    static a a(Bundle bundle, AccessTokenSource accessTokenSource, String str) {
        Bundle bundle2 = bundle;
        Date a = w.a(bundle2, "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH", new Date(0));
        Collection stringArrayList = bundle2.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
        String string = bundle2.getString("com.facebook.platform.extra.ACCESS_TOKEN");
        Date a2 = w.a(bundle2, "com.facebook.platform.extra.EXTRA_DATA_ACCESS_EXPIRATION_TIME", new Date(0));
        if (w.bc(string)) {
            return null;
        }
        return new a(string, str, bundle2.getString("com.facebook.platform.extra.USER_ID"), stringArrayList, null, accessTokenSource, a, new Date(), a2);
    }

    public static a a(Collection<String> collection, Bundle bundle, AccessTokenSource accessTokenSource, String str) {
        Date a = w.a(bundle, "expires_in", new Date());
        String string = bundle.getString("access_token");
        Date a2 = w.a(bundle, "data_access_expiration_time", new Date(0));
        String string2 = bundle.getString("granted_scopes");
        if (!w.bc(string2)) {
            collection = new ArrayList(Arrays.asList(string2.split(",")));
        }
        Collection<String> collection2 = collection;
        String string3 = bundle.getString("denied_scopes");
        Collection arrayList = !w.bc(string3) ? new ArrayList(Arrays.asList(string3.split(","))) : null;
        if (w.bc(string)) {
            return null;
        }
        return new a(string, str, bZ(bundle.getString("signed_request")), collection2, arrayList, accessTokenSource, a, new Date(), a2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e A:{Splitter: B:3:0x0009, ExcHandler: java.io.UnsupportedEncodingException (unused java.io.UnsupportedEncodingException)} */
    /* JADX WARNING: Missing block: B:9:0x0035, code:
            throw new com.facebook.FacebookException("Failed to retrieve user_id from signed_request");
     */
    static java.lang.String bZ(java.lang.String r2) {
        /*
        if (r2 == 0) goto L_0x0036;
    L_0x0002:
        r0 = r2.isEmpty();
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        goto L_0x0036;
    L_0x0009:
        r0 = "\\.";
        r2 = r2.split(r0);	 Catch:{ UnsupportedEncodingException -> 0x002e, UnsupportedEncodingException -> 0x002e }
        r0 = r2.length;	 Catch:{ UnsupportedEncodingException -> 0x002e, UnsupportedEncodingException -> 0x002e }
        r1 = 2;
        if (r0 != r1) goto L_0x002e;
    L_0x0013:
        r0 = 1;
        r2 = r2[r0];	 Catch:{ UnsupportedEncodingException -> 0x002e, UnsupportedEncodingException -> 0x002e }
        r0 = 0;
        r2 = android.util.Base64.decode(r2, r0);	 Catch:{ UnsupportedEncodingException -> 0x002e, UnsupportedEncodingException -> 0x002e }
        r0 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x002e, UnsupportedEncodingException -> 0x002e }
        r1 = "UTF-8";
        r0.<init>(r2, r1);	 Catch:{ UnsupportedEncodingException -> 0x002e, UnsupportedEncodingException -> 0x002e }
        r2 = new org.json.JSONObject;	 Catch:{ UnsupportedEncodingException -> 0x002e, UnsupportedEncodingException -> 0x002e }
        r2.<init>(r0);	 Catch:{ UnsupportedEncodingException -> 0x002e, UnsupportedEncodingException -> 0x002e }
        r0 = "user_id";
        r2 = r2.getString(r0);	 Catch:{ UnsupportedEncodingException -> 0x002e, UnsupportedEncodingException -> 0x002e }
        return r2;
    L_0x002e:
        r2 = new com.facebook.FacebookException;
        r0 = "Failed to retrieve user_id from signed_request";
        r2.<init>(r0);
        throw r2;
    L_0x0036:
        r2 = new com.facebook.FacebookException;
        r0 = "Authorization response does not contain the signed_request";
        r2.<init>(r0);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.k.bZ(java.lang.String):java.lang.String");
    }

    public void writeToParcel(Parcel parcel, int i) {
        w.a(parcel, this.GZ);
    }
}
