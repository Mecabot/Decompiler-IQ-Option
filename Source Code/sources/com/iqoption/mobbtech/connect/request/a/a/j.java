package com.iqoption.mobbtech.connect.request.a.a;

import com.iqoption.core.i;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: ResponseHttpAPiRequestTask */
public class j<T> extends b<T> {
    public j(Class<T> cls, Request request, String str) {
        super((Class) cls, request, str);
    }

    protected String b(Response response) {
        String string = response.body().string();
        response.close();
        i.d(string);
        return string;
    }
}
