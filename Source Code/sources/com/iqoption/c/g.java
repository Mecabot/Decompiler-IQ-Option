package com.iqoption.c;

import android.content.Context;
import android.text.TextUtils;
import com.google.common.util.concurrent.n;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.app.a;
import com.iqoption.microservice.authorization.AuthException;
import com.iqoption.microservice.authorization.a.c;
import com.iqoption.microservice.authorization.a.d;
import com.iqoption.util.ag;

/* compiled from: IqAccountAuthenticator */
public class g {
    private static final String TAG = "com.iqoption.c.g";

    public static s<d> JC() {
        return ag.a(JE(), h.ari);
    }

    static final /* synthetic */ s fl(String str) {
        s d = a.Jw().d(Long.valueOf(a.Cw().getUserId()).longValue(), str);
        o.a(d, new n<d>() {
            /* renamed from: a */
            public void onSuccess(d dVar) {
            }

            public void l(Throwable th) {
                a.Cw().CY();
            }
        });
        return d;
    }

    public static boolean JD() {
        return a.Cw().isAuthorized();
    }

    public static s<c> aX(Context context) {
        return ag.a(com.iqoption.microservice.authorization.a.aX(context), i.$instance);
    }

    private static s<String> JE() {
        a Cw = a.Cw();
        if (!Cw.isAuthorized()) {
            return o.m(new AuthException(202));
        }
        CharSequence CX = Cw.CX();
        if (TextUtils.isEmpty(CX)) {
            return o.m(new AuthException(8));
        }
        return o.aR(CX);
    }
}
