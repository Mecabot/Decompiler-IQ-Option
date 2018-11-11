package com.facebook.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.facebook.FacebookException;
import com.facebook.common.a.f;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.w;
import com.facebook.internal.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class LoginClient implements Parcelable {
    public static final Creator<LoginClient> CREATOR = new Creator<LoginClient>() {
        /* renamed from: n */
        public LoginClient createFromParcel(Parcel parcel) {
            return new LoginClient(parcel);
        }

        /* renamed from: Z */
        public LoginClient[] newArray(int i) {
            return new LoginClient[i];
        }
    };
    k[] Gb;
    int Gc = -1;
    b Gd;
    a Ge;
    boolean Gf;
    c Gg;
    Map<String, String> Gh;
    private i Gi;
    Fragment fragment;

    public static class Result implements Parcelable {
        public static final Creator<Result> CREATOR = new Creator<Result>() {
            /* renamed from: p */
            public Result createFromParcel(Parcel parcel) {
                return new Result(parcel, null);
            }

            /* renamed from: ab */
            public Result[] newArray(int i) {
                return new Result[i];
            }
        };
        public Map<String, String> Gh;
        final Code Gq;
        final com.facebook.a Gr;
        final String Gs;
        final c Gt;
        final String errorMessage;

        enum Code {
            SUCCESS(com.google.firebase.analytics.FirebaseAnalytics.b.SUCCESS),
            CANCEL("cancel"),
            ERROR("error");
            
            private final String loggingValue;

            private Code(String str) {
                this.loggingValue = str;
            }

            String getLoggingValue() {
                return this.loggingValue;
            }
        }

        public int describeContents() {
            return 0;
        }

        /* synthetic */ Result(Parcel parcel, AnonymousClass1 anonymousClass1) {
            this(parcel);
        }

        Result(c cVar, Code code, com.facebook.a aVar, String str, String str2) {
            x.a((Object) code, "code");
            this.Gt = cVar;
            this.Gr = aVar;
            this.errorMessage = str;
            this.Gq = code;
            this.Gs = str2;
        }

        static Result a(c cVar, com.facebook.a aVar) {
            return new Result(cVar, Code.SUCCESS, aVar, null, null);
        }

        static Result a(c cVar, String str) {
            return new Result(cVar, Code.CANCEL, null, str, null);
        }

        static Result a(c cVar, String str, String str2) {
            return a(cVar, str, str2, null);
        }

        static Result a(c cVar, String str, String str2, String str3) {
            return new Result(cVar, Code.ERROR, null, TextUtils.join(": ", w.b(str, str2)), str3);
        }

        private Result(Parcel parcel) {
            this.Gq = Code.valueOf(parcel.readString());
            this.Gr = (com.facebook.a) parcel.readParcelable(com.facebook.a.class.getClassLoader());
            this.errorMessage = parcel.readString();
            this.Gs = parcel.readString();
            this.Gt = (c) parcel.readParcelable(c.class.getClassLoader());
            this.Gh = w.g(parcel);
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.Gq.name());
            parcel.writeParcelable(this.Gr, i);
            parcel.writeString(this.errorMessage);
            parcel.writeString(this.Gs);
            parcel.writeParcelable(this.Gt, i);
            w.a(parcel, this.Gh);
        }
    }

    interface a {
        void np();

        void nq();
    }

    public interface b {
        void e(Result result);
    }

    public static class c implements Parcelable {
        public static final Creator<c> CREATOR = new Creator<c>() {
            /* renamed from: o */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel, null);
            }

            /* renamed from: aa */
            public c[] newArray(int i) {
                return new c[i];
            }
        };
        private final LoginBehavior Gj;
        private final DefaultAudience Gk;
        private final String Gl;
        private boolean Gm;
        private String Gn;
        private String Go;
        private String Gp;
        private final String applicationId;
        private Set<String> wq;

        public int describeContents() {
            return 0;
        }

        /* synthetic */ c(Parcel parcel, AnonymousClass1 anonymousClass1) {
            this(parcel);
        }

        c(LoginBehavior loginBehavior, Set<String> set, DefaultAudience defaultAudience, String str, String str2, String str3) {
            Set set2;
            this.Gm = false;
            this.Gj = loginBehavior;
            if (set2 == null) {
                set2 = new HashSet();
            }
            this.wq = set2;
            this.Gk = defaultAudience;
            this.Go = str;
            this.applicationId = str2;
            this.Gl = str3;
        }

        Set<String> ip() {
            return this.wq;
        }

        void setPermissions(Set<String> set) {
            x.a((Object) set, "permissions");
            this.wq = set;
        }

        LoginBehavior nr() {
            return this.Gj;
        }

        DefaultAudience ns() {
            return this.Gk;
        }

        String it() {
            return this.applicationId;
        }

        String nt() {
            return this.Gl;
        }

        boolean nu() {
            return this.Gm;
        }

        void P(boolean z) {
            this.Gm = z;
        }

        String nv() {
            return this.Gn;
        }

        String nw() {
            return this.Gp;
        }

        String nx() {
            return this.Go;
        }

        boolean ny() {
            for (String bW : this.wq) {
                if (j.bW(bW)) {
                    return true;
                }
            }
            return false;
        }

        private c(Parcel parcel) {
            boolean z = false;
            this.Gm = false;
            String readString = parcel.readString();
            DefaultAudience defaultAudience = null;
            this.Gj = readString != null ? LoginBehavior.valueOf(readString) : null;
            Collection arrayList = new ArrayList();
            parcel.readStringList(arrayList);
            this.wq = new HashSet(arrayList);
            readString = parcel.readString();
            if (readString != null) {
                defaultAudience = DefaultAudience.valueOf(readString);
            }
            this.Gk = defaultAudience;
            this.applicationId = parcel.readString();
            this.Gl = parcel.readString();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            }
            this.Gm = z;
            this.Gn = parcel.readString();
            this.Go = parcel.readString();
            this.Gp = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            String str = null;
            parcel.writeString(this.Gj != null ? this.Gj.name() : null);
            parcel.writeStringList(new ArrayList(this.wq));
            if (this.Gk != null) {
                str = this.Gk.name();
            }
            parcel.writeString(str);
            parcel.writeString(this.applicationId);
            parcel.writeString(this.Gl);
            parcel.writeByte((byte) this.Gm);
            parcel.writeString(this.Gn);
            parcel.writeString(this.Go);
            parcel.writeString(this.Gp);
        }
    }

    public int describeContents() {
        return 0;
    }

    public LoginClient(Fragment fragment) {
        this.fragment = fragment;
    }

    public Fragment getFragment() {
        return this.fragment;
    }

    void setFragment(Fragment fragment) {
        if (this.fragment != null) {
            throw new FacebookException("Can't set fragment once it is already set.");
        }
        this.fragment = fragment;
    }

    FragmentActivity getActivity() {
        return this.fragment.getActivity();
    }

    public c nc() {
        return this.Gg;
    }

    public static int nd() {
        return RequestCodeOffset.Login.toRequestCode();
    }

    void d(c cVar) {
        if (!ne()) {
            e(cVar);
        }
    }

    void e(c cVar) {
        if (cVar != null) {
            if (this.Gg != null) {
                throw new FacebookException("Attempted to authorize while a request is pending.");
            } else if (!com.facebook.a.il() || nh()) {
                this.Gg = cVar;
                this.Gb = f(cVar);
                ni();
            }
        }
    }

    boolean ne() {
        return this.Gg != null && this.Gc >= 0;
    }

    void nf() {
        if (this.Gc >= 0) {
            ng().cancel();
        }
    }

    k ng() {
        return this.Gc >= 0 ? this.Gb[this.Gc] : null;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        return this.Gg != null ? ng().onActivityResult(i, i2, intent) : false;
    }

    protected k[] f(c cVar) {
        ArrayList arrayList = new ArrayList();
        LoginBehavior nr = cVar.nr();
        if (nr.allowsGetTokenAuth()) {
            arrayList.add(new f(this));
        }
        if (nr.allowsKatanaAuth()) {
            arrayList.add(new g(this));
        }
        if (nr.allowsFacebookLiteAuth()) {
            arrayList.add(new d(this));
        }
        if (nr.allowsCustomTabAuth()) {
            arrayList.add(new a(this));
        }
        if (nr.allowsWebViewAuth()) {
            arrayList.add(new p(this));
        }
        if (nr.allowsDeviceAuth()) {
            arrayList.add(new c(this));
        }
        k[] kVarArr = new k[arrayList.size()];
        arrayList.toArray(kVarArr);
        return kVarArr;
    }

    boolean nh() {
        if (this.Gf) {
            return true;
        }
        if (bU("android.permission.INTERNET") != 0) {
            Activity activity = getActivity();
            b(Result.a(this.Gg, activity.getString(f.com_facebook_internet_permission_error_title), activity.getString(f.com_facebook_internet_permission_error_message)));
            return false;
        }
        this.Gf = true;
        return true;
    }

    void ni() {
        if (this.Gc >= 0) {
            a(ng().mM(), "skipped", null, null, ng().GZ);
        }
        while (this.Gb != null && this.Gc < this.Gb.length - 1) {
            this.Gc++;
            if (nk()) {
                return;
            }
        }
        if (this.Gg != null) {
            nj();
        }
    }

    private void nj() {
        b(Result.a(this.Gg, "Login attempt failed.", null));
    }

    private void b(String str, String str2, boolean z) {
        Object str22;
        if (this.Gh == null) {
            this.Gh = new HashMap();
        }
        if (this.Gh.containsKey(str) && z) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String) this.Gh.get(str));
            stringBuilder.append(",");
            stringBuilder.append(str22);
            str22 = stringBuilder.toString();
        }
        this.Gh.put(str, str22);
    }

    boolean nk() {
        k ng = ng();
        if (!ng.nF() || nh()) {
            boolean a = ng.a(this.Gg);
            if (a) {
                nl().G(this.Gg.nt(), ng.mM());
            } else {
                nl().H(this.Gg.nt(), ng.mM());
                b("not_tried", ng.mM(), true);
            }
            return a;
        }
        b("no_internet_permission", "1", false);
        return false;
    }

    void a(Result result) {
        if (result.Gr == null || !com.facebook.a.il()) {
            b(result);
        } else {
            c(result);
        }
    }

    void b(Result result) {
        k ng = ng();
        if (ng != null) {
            a(ng.mM(), result, ng.GZ);
        }
        if (this.Gh != null) {
            result.Gh = this.Gh;
        }
        this.Gb = null;
        this.Gc = -1;
        this.Gg = null;
        this.Gh = null;
        d(result);
    }

    void a(b bVar) {
        this.Gd = bVar;
    }

    void a(a aVar) {
        this.Ge = aVar;
    }

    int bU(String str) {
        return getActivity().checkCallingOrSelfPermission(str);
    }

    void c(Result result) {
        if (result.Gr == null) {
            throw new FacebookException("Can't validate without a token");
        }
        com.facebook.a ik = com.facebook.a.ik();
        com.facebook.a aVar = result.Gr;
        if (!(ik == null || aVar == null)) {
            try {
                if (ik.getUserId().equals(aVar.getUserId())) {
                    result = Result.a(this.Gg, result.Gr);
                    b(result);
                }
            } catch (Exception e) {
                b(Result.a(this.Gg, "Caught exception", e.getMessage()));
                return;
            }
        }
        result = Result.a(this.Gg, "User logged in as different Facebook user.", null);
        b(result);
    }

    private i nl() {
        if (this.Gi == null || !this.Gi.it().equals(this.Gg.it())) {
            this.Gi = new i(getActivity(), this.Gg.it());
        }
        return this.Gi;
    }

    private void d(Result result) {
        if (this.Gd != null) {
            this.Gd.e(result);
        }
    }

    void nm() {
        if (this.Ge != null) {
            this.Ge.np();
        }
    }

    void nn() {
        if (this.Ge != null) {
            this.Ge.nq();
        }
    }

    private void a(String str, Result result, Map<String, String> map) {
        a(str, result.Gq.getLoggingValue(), result.errorMessage, result.Gs, map);
    }

    private void a(String str, String str2, String str3, String str4, Map<String, String> map) {
        if (this.Gg == null) {
            nl().d("fb_mobile_login_method_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", str);
        } else {
            nl().a(this.Gg.nt(), str, str2, str3, str4, map);
        }
    }

    static String no() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("init", System.currentTimeMillis());
        } catch (JSONException unused) {
            return jSONObject.toString();
        }
    }

    public LoginClient(Parcel parcel) {
        Parcelable[] readParcelableArray = parcel.readParcelableArray(k.class.getClassLoader());
        this.Gb = new k[readParcelableArray.length];
        for (int i = 0; i < readParcelableArray.length; i++) {
            this.Gb[i] = (k) readParcelableArray[i];
            this.Gb[i].a(this);
        }
        this.Gc = parcel.readInt();
        this.Gg = (c) parcel.readParcelable(c.class.getClassLoader());
        this.Gh = w.g(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelableArray(this.Gb, i);
        parcel.writeInt(this.Gc);
        parcel.writeParcelable(this.Gg, i);
        w.a(parcel, this.Gh);
    }
}
