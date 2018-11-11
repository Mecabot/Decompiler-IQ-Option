package com.facebook.login;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.v;
import com.facebook.internal.w;
import com.facebook.login.LoginClient.Result;
import com.facebook.login.LoginClient.c;

/* compiled from: NativeAppLoginMethodHandler */
abstract class m extends k {
    abstract boolean a(c cVar);

    m(LoginClient loginClient) {
        super(loginClient);
    }

    m(Parcel parcel) {
        super(parcel);
    }

    boolean onActivityResult(int i, int i2, Intent intent) {
        Result a;
        c nc = this.Gv.nc();
        if (intent == null) {
            a = Result.a(nc, "Operation canceled");
        } else if (i2 == 0) {
            a = b(nc, intent);
        } else if (i2 != -1) {
            a = Result.a(nc, "Unexpected resultCode from authorization.", null);
        } else {
            a = a(nc, intent);
        }
        if (a != null) {
            this.Gv.a(a);
        } else {
            this.Gv.ni();
        }
        return true;
    }

    private Result a(c cVar, Intent intent) {
        Bundle extras = intent.getExtras();
        String o = o(extras);
        String obj = extras.get("error_code") != null ? extras.get("error_code").toString() : null;
        String p = p(extras);
        String string = extras.getString("e2e");
        if (!w.bc(string)) {
            bY(string);
        }
        if (o == null && obj == null && p == null) {
            try {
                return Result.a(cVar, k.a(cVar.ip(), extras, AccessTokenSource.FACEBOOK_APPLICATION_WEB, cVar.it()));
            } catch (FacebookException e) {
                return Result.a(cVar, null, e.getMessage());
            }
        } else if (v.Es.contains(o)) {
            return null;
        } else {
            if (v.Et.contains(o)) {
                return Result.a(cVar, null);
            }
            return Result.a(cVar, o, p, obj);
        }
    }

    private Result b(c cVar, Intent intent) {
        Bundle extras = intent.getExtras();
        String o = o(extras);
        String obj = extras.get("error_code") != null ? extras.get("error_code").toString() : null;
        if ("CONNECTION_FAILURE".equals(obj)) {
            return Result.a(cVar, o, p(extras), obj);
        }
        return Result.a(cVar, o);
    }

    private String o(Bundle bundle) {
        String string = bundle.getString("error");
        return string == null ? bundle.getString("error_type") : string;
    }

    private String p(Bundle bundle) {
        String string = bundle.getString("error_message");
        return string == null ? bundle.getString("error_description") : string;
    }

    protected boolean b(Intent intent, int i) {
        if (intent == null) {
            return false;
        }
        try {
            this.Gv.getFragment().startActivityForResult(intent, i);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }
}
