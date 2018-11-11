package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.internal.s;
import com.facebook.login.LoginClient.c;

/* compiled from: KatanaProxyLoginMethodHandler */
class g extends m {
    public static final Creator<g> CREATOR = new Creator<g>() {
        /* renamed from: m */
        public g createFromParcel(Parcel parcel) {
            return new g(parcel);
        }

        /* renamed from: Y */
        public g[] newArray(int i) {
            return new g[i];
        }
    };

    public int describeContents() {
        return 0;
    }

    String mM() {
        return "katana_proxy_auth";
    }

    g(LoginClient loginClient) {
        super(loginClient);
    }

    boolean a(c cVar) {
        String no = LoginClient.no();
        Intent b = s.b(this.Gv.getActivity(), cVar.it(), cVar.ip(), no, cVar.nu(), cVar.ny(), cVar.ns(), bX(cVar.nt()), cVar.nx());
        b("e2e", no);
        return b(b, LoginClient.nd());
    }

    g(Parcel parcel) {
        super(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
