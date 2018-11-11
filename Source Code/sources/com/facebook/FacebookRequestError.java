package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.h;
import com.facebook.internal.l;
import com.facebook.internal.w;
import com.google.android.gms.measurement.AppMeasurement.Param;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public final class FacebookRequestError implements Parcelable {
    public static final Creator<FacebookRequestError> CREATOR = new Creator<FacebookRequestError>() {
        /* renamed from: d */
        public FacebookRequestError createFromParcel(Parcel parcel) {
            return new FacebookRequestError(parcel, null);
        }

        /* renamed from: J */
        public FacebookRequestError[] newArray(int i) {
            return new FacebookRequestError[i];
        }
    };
    static final a xo = new a(200, 299, null);
    private final int errorCode;
    private final String errorMessage;
    private final FacebookException xA;
    private final Category xp;
    private final int xq;
    private final int xr;
    private final String xs;
    private final String xt;
    private final String xu;
    private final String xv;
    private final JSONObject xw;
    private final JSONObject xx;
    private final Object xy;
    private final HttpURLConnection xz;

    public enum Category {
        LOGIN_RECOVERABLE,
        OTHER,
        TRANSIENT
    }

    private static class a {
        private final int end;
        private final int start;

        /* synthetic */ a(int i, int i2, AnonymousClass1 anonymousClass1) {
            this(i, i2);
        }

        private a(int i, int i2) {
            this.start = i;
            this.end = i2;
        }

        boolean contains(int i) {
            return this.start <= i && i <= this.end;
        }
    }

    public int describeContents() {
        return 0;
    }

    private FacebookRequestError(int i, int i2, int i3, String str, String str2, String str3, String str4, boolean z, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        Object obj2;
        Category category;
        this.xq = i;
        this.errorCode = i2;
        this.xr = i3;
        this.xs = str;
        this.errorMessage = str2;
        this.xx = jSONObject;
        this.xw = jSONObject2;
        this.xy = obj;
        this.xz = httpURLConnection;
        this.xt = str3;
        this.xu = str4;
        if (facebookException != null) {
            this.xA = facebookException;
            obj2 = 1;
        } else {
            this.xA = new FacebookServiceException(this, str2);
            obj2 = null;
        }
        h iW = iW();
        if (obj2 != null) {
            category = Category.OTHER;
        } else {
            category = iW.a(i2, i3, z);
        }
        this.xp = category;
        this.xv = iW.a(this.xp);
    }

    FacebookRequestError(HttpURLConnection httpURLConnection, Exception exception) {
        Throwable th = exception;
        this(-1, -1, -1, null, null, null, null, false, null, null, null, httpURLConnection, th instanceof FacebookException ? (FacebookException) th : new FacebookException(th));
    }

    public FacebookRequestError(int i, String str, String str2) {
        this(-1, i, -1, str, str2, null, null, false, null, null, null, null, null);
    }

    public int iR() {
        return this.xq;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public int iS() {
        return this.xr;
    }

    public String iT() {
        return this.xs;
    }

    public String getErrorMessage() {
        if (this.errorMessage != null) {
            return this.errorMessage;
        }
        return this.xA.getLocalizedMessage();
    }

    public JSONObject iU() {
        return this.xw;
    }

    public FacebookException iV() {
        return this.xA;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{HttpStatus: ");
        stringBuilder.append(this.xq);
        stringBuilder.append(", errorCode: ");
        stringBuilder.append(this.errorCode);
        stringBuilder.append(", subErrorCode: ");
        stringBuilder.append(this.xr);
        stringBuilder.append(", errorType: ");
        stringBuilder.append(this.xs);
        stringBuilder.append(", errorMessage: ");
        stringBuilder.append(getErrorMessage());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    static FacebookRequestError a(JSONObject jSONObject, Object obj, HttpURLConnection httpURLConnection) {
        JSONObject jSONObject2 = jSONObject;
        try {
            if (jSONObject2.has("code")) {
                int i = jSONObject2.getInt("code");
                Object b = w.b(jSONObject2, "body", "FACEBOOK_NON_JSON_RESULT");
                if (b != null && (b instanceof JSONObject)) {
                    String optString;
                    String optString2;
                    String optString3;
                    int i2;
                    String str;
                    boolean optBoolean;
                    JSONObject jSONObject3 = (JSONObject) b;
                    Object obj2 = 1;
                    int i3 = -1;
                    if (jSONObject3.has("error")) {
                        JSONObject jSONObject4 = (JSONObject) w.b(jSONObject3, "error", null);
                        optString = jSONObject4.optString(Param.TYPE, null);
                        optString2 = jSONObject4.optString("message", null);
                        int optInt = jSONObject4.optInt("code", -1);
                        i3 = jSONObject4.optInt("error_subcode", -1);
                        String optString4 = jSONObject4.optString("error_user_msg", null);
                        optString3 = jSONObject4.optString("error_user_title", null);
                        i2 = i3;
                        i3 = optInt;
                        str = optString4;
                        optBoolean = jSONObject4.optBoolean("is_transient", false);
                    } else if (jSONObject3.has("error_code") || jSONObject3.has("error_msg") || jSONObject3.has("error_reason")) {
                        String optString5 = jSONObject3.optString("error_reason", null);
                        optString = jSONObject3.optString("error_msg", null);
                        int optInt2 = jSONObject3.optInt("error_code", -1);
                        i2 = jSONObject3.optInt("error_subcode", -1);
                        i3 = optInt2;
                        str = null;
                        optString3 = str;
                        optBoolean = false;
                        optString2 = optString;
                        optString = optString5;
                    } else {
                        optString = null;
                        optString2 = optString;
                        str = optString2;
                        optString3 = str;
                        obj2 = null;
                        i2 = -1;
                        optBoolean = false;
                    }
                    if (obj2 != null) {
                        return new FacebookRequestError(i, i3, i2, optString, optString2, optString3, str, optBoolean, jSONObject3, jSONObject2, obj, httpURLConnection, null);
                    }
                }
                if (!xo.contains(i)) {
                    return new FacebookRequestError(i, -1, -1, null, null, null, null, false, jSONObject2.has("body") ? (JSONObject) w.b(jSONObject2, "body", "FACEBOOK_NON_JSON_RESULT") : null, jSONObject2, obj, httpURLConnection, null);
                }
            }
        } catch (JSONException unused) {
            return null;
        }
    }

    static synchronized h iW() {
        synchronized (FacebookRequestError.class) {
            l bF = FetchedAppSettingsManager.bF(h.it());
            h lB;
            if (bF == null) {
                lB = h.lB();
                return lB;
            }
            lB = bF.iW();
            return lB;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.xq);
        parcel.writeInt(this.errorCode);
        parcel.writeInt(this.xr);
        parcel.writeString(this.xs);
        parcel.writeString(this.errorMessage);
        parcel.writeString(this.xt);
        parcel.writeString(this.xu);
    }

    private FacebookRequestError(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), false, null, null, null, null, null);
    }
}
