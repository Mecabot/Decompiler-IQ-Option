package com.iqoption.mobbtech.connect.response;

import com.google.common.base.j;

/* compiled from: ResponseStatus */
public interface l {
    public static final j<o> cVW = new j<o>() {
        /* renamed from: b */
        public boolean apply(o oVar) {
            return oVar.isSuccessful();
        }
    };

    String getMessage();

    boolean isSuccessful();
}
