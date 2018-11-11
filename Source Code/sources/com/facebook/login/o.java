package com.facebook.login;

import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookServiceException;
import com.facebook.a;
import com.facebook.h;
import com.facebook.internal.w;
import com.facebook.login.LoginClient.Result;
import com.facebook.login.LoginClient.c;
import java.util.Locale;

/* compiled from: WebLoginMethodHandler */
abstract class o extends k {
    private String Hc;

    abstract AccessTokenSource mN();

    protected String mO() {
        return null;
    }

    private static final String nH() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fb");
        stringBuilder.append(h.it());
        stringBuilder.append("://authorize");
        return stringBuilder.toString();
    }

    o(LoginClient loginClient) {
        super(loginClient);
    }

    o(Parcel parcel) {
        super(parcel);
    }

    protected Bundle i(c cVar) {
        Bundle bundle = new Bundle();
        if (!w.c(cVar.ip())) {
            String join = TextUtils.join(",", cVar.ip());
            bundle.putString("scope", join);
            b("scope", join);
        }
        bundle.putString("default_audience", cVar.ns().getNativeProtocolAudience());
        bundle.putString("state", bX(cVar.nt()));
        a ik = a.ik();
        String token = ik != null ? ik.getToken() : null;
        if (token == null || !token.equals(nI())) {
            w.ad(this.Gv.getActivity());
            b("access_token", "0");
        } else {
            bundle.putString("access_token", token);
            b("access_token", "1");
        }
        return bundle;
    }

    protected Bundle a(Bundle bundle, c cVar) {
        bundle.putString("redirect_uri", nH());
        bundle.putString("client_id", cVar.it());
        LoginClient loginClient = this.Gv;
        bundle.putString("e2e", LoginClient.no());
        bundle.putString("response_type", "token,signed_request");
        bundle.putString("return_scopes", "true");
        bundle.putString("auth_type", cVar.nx());
        if (mO() != null) {
            bundle.putString("sso", mO());
        }
        return bundle;
    }

    protected void a(c cVar, Bundle bundle, FacebookException facebookException) {
        Result a;
        this.Hc = null;
        if (bundle != null) {
            if (bundle.containsKey("e2e")) {
                this.Hc = bundle.getString("e2e");
            }
            try {
                a a2 = k.a(cVar.ip(), bundle, mN(), cVar.it());
                a = Result.a(this.Gv.nc(), a2);
                CookieSyncManager.createInstance(this.Gv.getActivity()).sync();
                ca(a2.getToken());
            } catch (FacebookException e) {
                a = Result.a(this.Gv.nc(), null, e.getMessage());
            }
        } else if (facebookException instanceof FacebookOperationCanceledException) {
            a = Result.a(this.Gv.nc(), "User canceled log in.");
        } else {
            String format;
            this.Hc = null;
            String message = facebookException.getMessage();
            if (facebookException instanceof FacebookServiceException) {
                format = String.format(Locale.ROOT, "%d", new Object[]{Integer.valueOf(((FacebookServiceException) facebookException).jj().getErrorCode())});
                message = r5.toString();
            } else {
                format = null;
            }
            a = Result.a(this.Gv.nc(), null, message, format);
        }
        if (!w.bc(this.Hc)) {
            bY(this.Hc);
        }
        this.Gv.a(a);
    }

    private String nI() {
        return this.Gv.getActivity().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).getString("TOKEN", "");
    }

    private void ca(String str) {
        this.Gv.getActivity().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).edit().putString("TOKEN", str).apply();
    }
}
