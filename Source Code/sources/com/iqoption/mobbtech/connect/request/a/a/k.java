package com.iqoption.mobbtech.connect.request.a.a;

import com.iqoption.mobbtech.connect.response.l;
import java.lang.reflect.Type;
import okhttp3.Request;

/* compiled from: ResponseStatusRequestTask */
public class k<T> extends b<T> {
    public k(Class<T> cls, Request request, String str) {
        super((Class) cls, request, str);
    }

    public k(Type type, Request request, String str) {
        super(type, request, str);
    }

    protected void bx(T t) {
        if (t instanceof l) {
            l lVar = (l) t;
            if (!lVar.isSuccessful()) {
                this.success = false;
                this.errorMessage = lVar.getMessage();
            }
        }
        super.bx(t);
    }
}
