package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.g;
import com.facebook.internal.w;
import com.facebook.internal.y;
import com.facebook.login.LoginClient.c;

/* compiled from: WebViewLoginMethodHandler */
class p extends o {
    public static final Creator<p> CREATOR = new Creator<p>() {
        /* renamed from: q */
        public p createFromParcel(Parcel parcel) {
            return new p(parcel);
        }

        /* renamed from: ac */
        public p[] newArray(int i) {
            return new p[i];
        }
    };
    private String Hc;
    private y Hd;

    /* compiled from: WebViewLoginMethodHandler */
    static class a extends com.facebook.internal.y.a {
        private String Go;
        private String Hc;
        private String Hf = "fbconnect://success";

        public a(Context context, String str, Bundle bundle) {
            super(context, str, "oauth", bundle);
        }

        public a cb(String str) {
            this.Hc = str;
            return this;
        }

        public a R(boolean z) {
            this.Hf = z ? "fbconnect://chrome_os_success" : "fbconnect://success";
            return this;
        }

        public a cc(String str) {
            this.Go = str;
            return this;
        }

        public y mJ() {
            Bundle jn = jn();
            jn.putString("redirect_uri", this.Hf);
            jn.putString("client_id", it());
            jn.putString("e2e", this.Hc);
            jn.putString("response_type", "token,signed_request");
            jn.putString("return_scopes", "true");
            jn.putString("auth_type", this.Go);
            return y.a(getContext(), "oauth", jn, getTheme(), mK());
        }
    }

    public int describeContents() {
        return 0;
    }

    String mM() {
        return "web_view";
    }

    boolean nF() {
        return true;
    }

    p(LoginClient loginClient) {
        super(loginClient);
    }

    AccessTokenSource mN() {
        return AccessTokenSource.WEB_VIEW;
    }

    void cancel() {
        if (this.Hd != null) {
            this.Hd.a();
            this.Hd = null;
        }
    }

    boolean a(final c cVar) {
        Bundle i = i(cVar);
        y.c anonymousClass1 = new y.c() {
            public void b(Bundle bundle, FacebookException facebookException) {
                p.this.b(cVar, bundle, facebookException);
            }
        };
        this.Hc = LoginClient.no();
        b("e2e", this.Hc);
        Context activity = this.Gv.getActivity();
        this.Hd = new a(activity, cVar.it(), i).cb(this.Hc).R(w.aj(activity)).cc(cVar.nx()).b(anonymousClass1).mJ();
        g gVar = new g();
        gVar.setRetainInstance(true);
        gVar.a(this.Hd);
        gVar.show(activity.getSupportFragmentManager(), "FacebookDialogFragment");
        return true;
    }

    void b(c cVar, Bundle bundle, FacebookException facebookException) {
        super.a(cVar, bundle, facebookException);
    }

    p(Parcel parcel) {
        super(parcel);
        this.Hc = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.Hc);
    }
}
