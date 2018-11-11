package com.facebook;

import android.util.Log;
import com.facebook.internal.q;
import com.facebook.internal.w;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: GraphResponse */
public class l {
    private static final String TAG = "l";
    private final FacebookRequestError error;
    private final HttpURLConnection xz;
    private final String yA;
    private final JSONObject ya;
    private final i yo;
    private final JSONArray yz;

    l(i iVar, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject) {
        this(iVar, httpURLConnection, str, jSONObject, null, null);
    }

    l(i iVar, HttpURLConnection httpURLConnection, String str, JSONArray jSONArray) {
        this(iVar, httpURLConnection, str, null, jSONArray, null);
    }

    l(i iVar, HttpURLConnection httpURLConnection, FacebookRequestError facebookRequestError) {
        this(iVar, httpURLConnection, null, null, null, facebookRequestError);
    }

    l(i iVar, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject, JSONArray jSONArray, FacebookRequestError facebookRequestError) {
        this.yo = iVar;
        this.xz = httpURLConnection;
        this.yA = str;
        this.ya = jSONObject;
        this.yz = jSONArray;
        this.error = facebookRequestError;
    }

    public final FacebookRequestError jJ() {
        return this.error;
    }

    public final JSONObject jK() {
        return this.ya;
    }

    public String toString() {
        String format;
        try {
            Locale locale = Locale.US;
            String str = "%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(this.xz != null ? this.xz.getResponseCode() : 200);
            format = String.format(locale, str, objArr);
        } catch (IOException unused) {
            format = "unknown";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{Response: ");
        stringBuilder.append(" responseCode: ");
        stringBuilder.append(format);
        stringBuilder.append(", graphObject: ");
        stringBuilder.append(this.ya);
        stringBuilder.append(", error: ");
        stringBuilder.append(this.error);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    static List<l> b(HttpURLConnection httpURLConnection, k kVar) {
        List<l> httpURLConnection2;
        Closeable closeable = null;
        List<l> e;
        try {
            InputStream errorStream;
            if (httpURLConnection2.getResponseCode() >= 400) {
                errorStream = httpURLConnection2.getErrorStream();
            } else {
                errorStream = httpURLConnection2.getInputStream();
            }
            closeable = errorStream;
            e = a((InputStream) closeable, httpURLConnection2, kVar);
            return e;
        } catch (FacebookException e2) {
            e = e2;
            q.a(LoggingBehavior.REQUESTS, "Response", "Response <Error>: %s", e);
            httpURLConnection2 = a((List) kVar, httpURLConnection2, (FacebookException) e);
            return httpURLConnection2;
        } catch (Exception e3) {
            e = e3;
            q.a(LoggingBehavior.REQUESTS, "Response", "Response <Error>: %s", e);
            httpURLConnection2 = a((List) kVar, httpURLConnection2, new FacebookException((Throwable) e));
            return httpURLConnection2;
        } finally {
            w.closeQuietly(closeable);
        }
    }

    static List<l> a(InputStream inputStream, HttpURLConnection httpURLConnection, k kVar) {
        q.a(LoggingBehavior.INCLUDE_RAW_RESPONSES, "Response", "Response (raw)\n  Size: %d\n  Response:\n%s\n", Integer.valueOf(w.c(inputStream).length()), r6);
        return a(w.c(inputStream), httpURLConnection, kVar);
    }

    static List<l> a(String str, HttpURLConnection httpURLConnection, k kVar) {
        q.a(LoggingBehavior.REQUESTS, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", kVar.getId(), Integer.valueOf(str.length()), a(httpURLConnection, (List) kVar, new JSONTokener(str).nextValue()));
        return a(httpURLConnection, (List) kVar, new JSONTokener(str).nextValue());
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0056  */
    private static java.util.List<com.facebook.l> a(java.net.HttpURLConnection r7, java.util.List<com.facebook.i> r8, java.lang.Object r9) {
        /*
        r0 = r8.size();
        r1 = new java.util.ArrayList;
        r1.<init>(r0);
        r2 = 0;
        r3 = 1;
        if (r0 != r3) goto L_0x0051;
    L_0x000d:
        r3 = r8.get(r2);
        r3 = (com.facebook.i) r3;
        r4 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0043, IOException -> 0x0034 }
        r4.<init>();	 Catch:{ JSONException -> 0x0043, IOException -> 0x0034 }
        r5 = "body";
        r4.put(r5, r9);	 Catch:{ JSONException -> 0x0043, IOException -> 0x0034 }
        if (r7 == 0) goto L_0x0024;
    L_0x001f:
        r5 = r7.getResponseCode();	 Catch:{ JSONException -> 0x0043, IOException -> 0x0034 }
        goto L_0x0026;
    L_0x0024:
        r5 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
    L_0x0026:
        r6 = "code";
        r4.put(r6, r5);	 Catch:{ JSONException -> 0x0043, IOException -> 0x0034 }
        r5 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x0043, IOException -> 0x0034 }
        r5.<init>();	 Catch:{ JSONException -> 0x0043, IOException -> 0x0034 }
        r5.put(r4);	 Catch:{ JSONException -> 0x0043, IOException -> 0x0034 }
        goto L_0x0052;
    L_0x0034:
        r4 = move-exception;
        r5 = new com.facebook.l;
        r6 = new com.facebook.FacebookRequestError;
        r6.<init>(r7, r4);
        r5.<init>(r3, r7, r6);
        r1.add(r5);
        goto L_0x0051;
    L_0x0043:
        r4 = move-exception;
        r5 = new com.facebook.l;
        r6 = new com.facebook.FacebookRequestError;
        r6.<init>(r7, r4);
        r5.<init>(r3, r7, r6);
        r1.add(r5);
    L_0x0051:
        r5 = r9;
    L_0x0052:
        r3 = r5 instanceof org.json.JSONArray;
        if (r3 == 0) goto L_0x0098;
    L_0x0056:
        r5 = (org.json.JSONArray) r5;
        r3 = r5.length();
        if (r3 == r0) goto L_0x005f;
    L_0x005e:
        goto L_0x0098;
    L_0x005f:
        r0 = r5.length();
        if (r2 >= r0) goto L_0x0097;
    L_0x0065:
        r0 = r8.get(r2);
        r0 = (com.facebook.i) r0;
        r3 = r5.get(r2);	 Catch:{ JSONException -> 0x0086, FacebookException -> 0x0077 }
        r3 = a(r0, r7, r3, r9);	 Catch:{ JSONException -> 0x0086, FacebookException -> 0x0077 }
        r1.add(r3);	 Catch:{ JSONException -> 0x0086, FacebookException -> 0x0077 }
        goto L_0x0094;
    L_0x0077:
        r3 = move-exception;
        r4 = new com.facebook.l;
        r6 = new com.facebook.FacebookRequestError;
        r6.<init>(r7, r3);
        r4.<init>(r0, r7, r6);
        r1.add(r4);
        goto L_0x0094;
    L_0x0086:
        r3 = move-exception;
        r4 = new com.facebook.l;
        r6 = new com.facebook.FacebookRequestError;
        r6.<init>(r7, r3);
        r4.<init>(r0, r7, r6);
        r1.add(r4);
    L_0x0094:
        r2 = r2 + 1;
        goto L_0x005f;
    L_0x0097:
        return r1;
    L_0x0098:
        r7 = new com.facebook.FacebookException;
        r8 = "Unexpected number of results";
        r7.<init>(r8);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.l.a(java.net.HttpURLConnection, java.util.List, java.lang.Object):java.util.List<com.facebook.l>");
    }

    private static l a(i iVar, HttpURLConnection httpURLConnection, Object obj, Object obj2) {
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            FacebookRequestError a = FacebookRequestError.a(jSONObject, obj2, httpURLConnection);
            if (a != null) {
                Log.e(TAG, a.toString());
                if (a.getErrorCode() == 190 && w.e(iVar.jo())) {
                    if (a.iS() != 493) {
                        a.a(null);
                    } else if (!a.ik().isExpired()) {
                        a.im();
                    }
                }
                return new l(iVar, httpURLConnection, a);
            }
            obj = w.b(jSONObject, "body", "FACEBOOK_NON_JSON_RESULT");
            if (obj instanceof JSONObject) {
                return new l(iVar, httpURLConnection, obj.toString(), (JSONObject) obj);
            }
            if (obj instanceof JSONArray) {
                return new l(iVar, httpURLConnection, obj.toString(), (JSONArray) obj);
            }
            obj = JSONObject.NULL;
        }
        if (obj == JSONObject.NULL) {
            return new l(iVar, httpURLConnection, obj.toString(), (JSONObject) null);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Got unexpected object type in response, class: ");
        stringBuilder.append(obj.getClass().getSimpleName());
        throw new FacebookException(stringBuilder.toString());
    }

    static List<l> a(List<i> list, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        int size = list.size();
        List<l> arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new l((i) list.get(i), httpURLConnection, new FacebookRequestError(httpURLConnection, (Exception) facebookException)));
        }
        return arrayList;
    }
}
