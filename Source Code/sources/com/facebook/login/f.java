package com.facebook.login;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.t.a;
import com.facebook.internal.w;
import com.facebook.login.LoginClient.Result;
import com.facebook.login.LoginClient.c;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GetTokenLoginMethodHandler */
class f extends k {
    public static final Creator<f> CREATOR = new Creator() {
        /* renamed from: l */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        /* renamed from: X */
        public f[] newArray(int i) {
            return new f[i];
        }
    };
    private e FX;

    public int describeContents() {
        return 0;
    }

    String mM() {
        return "get_token";
    }

    f(LoginClient loginClient) {
        super(loginClient);
    }

    void cancel() {
        if (this.FX != null) {
            this.FX.cancel();
            this.FX.a(null);
            this.FX = null;
        }
    }

    boolean a(final c cVar) {
        this.FX = new e(this.Gv.getActivity(), cVar.it());
        if (!this.FX.start()) {
            return false;
        }
        this.Gv.nm();
        this.FX.a(new a() {
            public void l(Bundle bundle) {
                f.this.a(cVar, bundle);
            }
        });
        return true;
    }

    void a(c cVar, Bundle bundle) {
        if (this.FX != null) {
            this.FX.a(null);
        }
        this.FX = null;
        this.Gv.nn();
        if (bundle != null) {
            ArrayList stringArrayList = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
            Object<String> ip = cVar.ip();
            if (stringArrayList == null || !(ip == null || stringArrayList.containsAll(ip))) {
                Object hashSet = new HashSet();
                for (String str : ip) {
                    if (!stringArrayList.contains(str)) {
                        hashSet.add(str);
                    }
                }
                if (!hashSet.isEmpty()) {
                    b("new_permissions", TextUtils.join(",", hashSet));
                }
                cVar.setPermissions(hashSet);
            } else {
                c(cVar, bundle);
                return;
            }
        }
        this.Gv.ni();
    }

    void b(c cVar, Bundle bundle) {
        this.Gv.a(Result.a(this.Gv.nc(), k.a(bundle, AccessTokenSource.FACEBOOK_APPLICATION_SERVICE, cVar.it())));
    }

    void c(final c cVar, final Bundle bundle) {
        String string = bundle.getString("com.facebook.platform.extra.USER_ID");
        if (string == null || string.isEmpty()) {
            this.Gv.nm();
            w.a(bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN"), new w.a() {
                public void e(JSONObject jSONObject) {
                    try {
                        bundle.putString("com.facebook.platform.extra.USER_ID", jSONObject.getString("id"));
                        f.this.b(cVar, bundle);
                    } catch (JSONException e) {
                        f.this.Gv.b(Result.a(f.this.Gv.nc(), "Caught exception", e.getMessage()));
                    }
                }

                public void c(FacebookException facebookException) {
                    f.this.Gv.b(Result.a(f.this.Gv.nc(), "Caught exception", facebookException.getMessage()));
                }
            });
            return;
        }
        b(cVar, bundle);
    }

    f(Parcel parcel) {
        super(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
