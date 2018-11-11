package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.internal.s;
import com.facebook.login.LoginClient.c;

/* compiled from: FacebookLiteLoginMethodHandler */
class d extends m {
    public static final Creator<d> CREATOR = new Creator<d>() {
        /* renamed from: k */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        /* renamed from: W */
        public d[] newArray(int i) {
            return new d[i];
        }
    };

    public int describeContents() {
        return 0;
    }

    String mM() {
        return "fb_lite_login";
    }

    d(LoginClient loginClient) {
        super(loginClient);
    }

    boolean a(c cVar) {
        String no = LoginClient.no();
        Intent a = s.a(this.Gv.getActivity(), cVar.it(), cVar.ip(), no, cVar.nu(), cVar.ny(), cVar.ns(), bX(cVar.nt()), cVar.nx());
        b("e2e", no);
        return b(a, LoginClient.nd());
    }

    d(Parcel parcel) {
        super(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
