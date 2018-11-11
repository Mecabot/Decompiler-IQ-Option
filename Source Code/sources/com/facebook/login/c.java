package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.AccessTokenSource;
import com.facebook.a;
import com.facebook.login.LoginClient.Result;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* compiled from: DeviceAuthMethodHandler */
class c extends k {
    public static final Creator<c> CREATOR = new Creator() {
        /* renamed from: j */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        /* renamed from: V */
        public c[] newArray(int i) {
            return new c[i];
        }
    };
    private static ScheduledThreadPoolExecutor zk;

    public int describeContents() {
        return 0;
    }

    String mM() {
        return "device_auth";
    }

    c(LoginClient loginClient) {
        super(loginClient);
    }

    boolean a(com.facebook.login.LoginClient.c cVar) {
        c(cVar);
        return true;
    }

    private void c(com.facebook.login.LoginClient.c cVar) {
        b na = na();
        na.show(this.Gv.getActivity().getSupportFragmentManager(), "login_with_facebook");
        na.b(cVar);
    }

    protected b na() {
        return new b();
    }

    public void onCancel() {
        this.Gv.a(Result.a(this.Gv.nc(), "User canceled log in."));
    }

    public void a(Exception exception) {
        this.Gv.a(Result.a(this.Gv.nc(), null, exception.getMessage()));
    }

    public void a(String str, String str2, String str3, Collection<String> collection, Collection<String> collection2, AccessTokenSource accessTokenSource, Date date, Date date2, Date date3) {
        this.Gv.a(Result.a(this.Gv.nc(), new a(str, str2, str3, collection, collection2, accessTokenSource, date, date2, date3)));
    }

    public static synchronized ScheduledThreadPoolExecutor nb() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        synchronized (c.class) {
            if (zk == null) {
                zk = new ScheduledThreadPoolExecutor(1);
            }
            scheduledThreadPoolExecutor = zk;
        }
        return scheduledThreadPoolExecutor;
    }

    protected c(Parcel parcel) {
        super(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
