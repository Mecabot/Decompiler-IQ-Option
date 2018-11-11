package com.iqoption.mobbtech.connect.request.a.a;

import android.support.annotation.Nullable;
import com.google.common.util.concurrent.n;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.core.d.a;
import com.iqoption.mobbtech.connect.a.b;
import com.iqoption.mobbtech.connect.response.MobbErrorException;
import com.iqoption.mobbtech.connect.response.g;
import okhttp3.Request;

/* compiled from: RequestTaskCallback */
public class h<T> extends b<T> {
    protected b<T> cVq;
    private n<T> cVr = new n<T>() {
        public void onSuccess(@Nullable T t) {
            if (h.this.cVq != null && t != null) {
                h.this.cVq.onSuccess(t);
            }
        }

        public void l(Throwable th) {
            if (h.this.cVq != null) {
                g auU;
                if (th instanceof MobbErrorException) {
                    auU = ((MobbErrorException) th).auU();
                } else {
                    auU = new g();
                    auU.iJ(h.this.cVf);
                    auU.setMessage(h.this.errorMessage);
                }
                auU.fv(h.this.responseCode);
                h.this.cVq.a(auU);
            }
        }
    };

    public h(Class<T> cls, Request request, b<T> bVar, String str) {
        super((Class) cls, request, str);
        this.cVq = bVar;
    }

    public s<T> auF() {
        s<T> auF = super.auF();
        o.a(auF, this.cVr, a.aSe);
        return auF;
    }

    public s<T> auG() {
        s<T> auG = super.auG();
        o.a(auG, this.cVr, a.aSe);
        return auG;
    }
}
