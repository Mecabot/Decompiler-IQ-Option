package com.facebook;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.facebook.internal.w;
import com.facebook.internal.x;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AccessToken */
public final class a implements Parcelable {
    public static final Creator<a> CREATOR = new Creator() {
        /* renamed from: c */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* renamed from: I */
        public a[] newArray(int i) {
            return new a[i];
        }
    };
    private static final Date MAX_DATE = new Date(Long.MAX_VALUE);
    private static final Date wn = MAX_DATE;
    private static final Date wo = new Date();
    private static final AccessTokenSource wp = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
    private final String applicationId;
    private final Date expires;
    private final String token;
    private final String userId;
    private final Set<String> wq;
    private final Set<String> wr;
    private final AccessTokenSource ws;
    private final Date wt;
    private final Date wu;

    /* compiled from: AccessToken */
    public interface a {
        void a(FacebookException facebookException);

        void c(a aVar);
    }

    public int describeContents() {
        return 0;
    }

    public a(String str, String str2, String str3, @Nullable Collection<String> collection, @Nullable Collection<String> collection2, @Nullable AccessTokenSource accessTokenSource, @Nullable Date date, @Nullable Date date2, @Nullable Date date3) {
        x.F(str, "accessToken");
        x.F(str2, "applicationId");
        x.F(str3, "userId");
        if (date == null) {
            date = wn;
        }
        this.expires = date;
        this.wq = Collections.unmodifiableSet(collection != null ? new HashSet(collection) : new HashSet());
        this.wr = Collections.unmodifiableSet(collection2 != null ? new HashSet(collection2) : new HashSet());
        this.token = str;
        if (accessTokenSource == null) {
            accessTokenSource = wp;
        }
        this.ws = accessTokenSource;
        if (date2 == null) {
            date2 = wo;
        }
        this.wt = date2;
        this.applicationId = str2;
        this.userId = str3;
        if (date3 == null || date3.getTime() == 0) {
            date3 = wn;
        }
        this.wu = date3;
    }

    public static a ik() {
        return c.iD().ik();
    }

    public static boolean il() {
        a ik = c.iD().ik();
        return (ik == null || ik.isExpired()) ? false : true;
    }

    static void im() {
        a ik = c.iD().ik();
        if (ik != null) {
            a(b(ik));
        }
    }

    public static void a(a aVar) {
        c.iD().a(aVar);
    }

    public String getToken() {
        return this.token;
    }

    public Date in() {
        return this.expires;
    }

    public Date io() {
        return this.wu;
    }

    public Set<String> ip() {
        return this.wq;
    }

    public Set<String> iq() {
        return this.wr;
    }

    public AccessTokenSource ir() {
        return this.ws;
    }

    public Date is() {
        return this.wt;
    }

    public String it() {
        return this.applicationId;
    }

    public String getUserId() {
        return this.userId;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{AccessToken");
        stringBuilder.append(" token:");
        stringBuilder.append(iv());
        i(stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!(this.expires.equals(aVar.expires) && this.wq.equals(aVar.wq) && this.wr.equals(aVar.wr) && this.token.equals(aVar.token) && this.ws == aVar.ws && this.wt.equals(aVar.wt) && (!this.applicationId != null ? aVar.applicationId != null : !this.applicationId.equals(aVar.applicationId)) && this.userId.equals(aVar.userId) && this.wu.equals(aVar.wu))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return ((((((((((((((((527 + this.expires.hashCode()) * 31) + this.wq.hashCode()) * 31) + this.wr.hashCode()) * 31) + this.token.hashCode()) * 31) + this.ws.hashCode()) * 31) + this.wt.hashCode()) * 31) + (this.applicationId == null ? 0 : this.applicationId.hashCode())) * 31) + this.userId.hashCode()) * 31) + this.wu.hashCode();
    }

    static a b(a aVar) {
        return new a(aVar.token, aVar.applicationId, aVar.getUserId(), aVar.ip(), aVar.iq(), aVar.ws, new Date(), new Date(), aVar.wu);
    }

    static a b(Bundle bundle) {
        Collection a = a(bundle, "com.facebook.TokenCachingStrategy.Permissions");
        Collection a2 = a(bundle, "com.facebook.TokenCachingStrategy.DeclinedPermissions");
        String f = m.f(bundle);
        if (w.bc(f)) {
            f = h.it();
        }
        String str = f;
        String d = m.d(bundle);
        try {
            return new a(d, str, w.bP(d).getString("id"), a, a2, m.e(bundle), m.b(bundle, "com.facebook.TokenCachingStrategy.ExpirationDate"), m.b(bundle, "com.facebook.TokenCachingStrategy.LastRefreshDate"), null);
        } catch (JSONException unused) {
            return null;
        }
    }

    static List<String> a(Bundle bundle, String str) {
        Collection stringArrayList = bundle.getStringArrayList(str);
        if (stringArrayList == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(stringArrayList));
    }

    public boolean isExpired() {
        return new Date().after(this.expires);
    }

    JSONObject iu() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", 1);
        jSONObject.put("token", this.token);
        jSONObject.put("expires_at", this.expires.getTime());
        jSONObject.put("permissions", new JSONArray(this.wq));
        jSONObject.put("declined_permissions", new JSONArray(this.wr));
        jSONObject.put("last_refresh", this.wt.getTime());
        jSONObject.put(b.SOURCE, this.ws.name());
        jSONObject.put("application_id", this.applicationId);
        jSONObject.put("user_id", this.userId);
        jSONObject.put("data_access_expiration_time", this.wu.getTime());
        return jSONObject;
    }

    static a c(JSONObject jSONObject) {
        if (jSONObject.getInt("version") > 1) {
            throw new FacebookException("Unknown AccessToken serialization format.");
        }
        String string = jSONObject.getString("token");
        Date date = new Date(jSONObject.getLong("expires_at"));
        JSONArray jSONArray = jSONObject.getJSONArray("permissions");
        JSONArray jSONArray2 = jSONObject.getJSONArray("declined_permissions");
        Date date2 = new Date(jSONObject.getLong("last_refresh"));
        AccessTokenSource valueOf = AccessTokenSource.valueOf(jSONObject.getString(b.SOURCE));
        return new a(string, jSONObject.getString("application_id"), jSONObject.getString("user_id"), w.f(jSONArray), w.f(jSONArray2), valueOf, date, date2, new Date(jSONObject.getLong("data_access_expiration_time")));
    }

    private String iv() {
        if (this.token == null) {
            return "null";
        }
        return h.a(LoggingBehavior.INCLUDE_ACCESS_TOKENS) ? this.token : "ACCESS_TOKEN_REMOVED";
    }

    private void i(StringBuilder stringBuilder) {
        stringBuilder.append(" permissions:");
        if (this.wq == null) {
            stringBuilder.append("null");
            return;
        }
        stringBuilder.append("[");
        stringBuilder.append(TextUtils.join(", ", this.wq));
        stringBuilder.append("]");
    }

    a(Parcel parcel) {
        this.expires = new Date(parcel.readLong());
        Collection arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        this.wq = Collections.unmodifiableSet(new HashSet(arrayList));
        arrayList.clear();
        parcel.readStringList(arrayList);
        this.wr = Collections.unmodifiableSet(new HashSet(arrayList));
        this.token = parcel.readString();
        this.ws = AccessTokenSource.valueOf(parcel.readString());
        this.wt = new Date(parcel.readLong());
        this.applicationId = parcel.readString();
        this.userId = parcel.readString();
        this.wu = new Date(parcel.readLong());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.expires.getTime());
        parcel.writeStringList(new ArrayList(this.wq));
        parcel.writeStringList(new ArrayList(this.wr));
        parcel.writeString(this.token);
        parcel.writeString(this.ws.name());
        parcel.writeLong(this.wt.getTime());
        parcel.writeString(this.applicationId);
        parcel.writeString(this.userId);
        parcel.writeLong(this.wu.getTime());
    }
}
