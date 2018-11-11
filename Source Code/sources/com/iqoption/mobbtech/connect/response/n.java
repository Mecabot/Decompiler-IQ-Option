package com.iqoption.mobbtech.connect.response;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.iqoption.app.IQApp;
import com.iqoption.core.i;
import com.iqoption.system.c.b;

/* compiled from: SimpleResponseBase */
public abstract class n implements l {
    @SerializedName("isSuccessful")
    public Boolean isSuccessful = Boolean.valueOf(false);

    /* compiled from: SimpleResponseBase */
    public static abstract class a<T> extends b<T, n> {
        private static final String TAG = "com.iqoption.mobbtech.connect.response.n$a";

        public a(T t) {
            super((Object) t);
        }

        public void l(Throwable th) {
            i.e(TAG, th.toString(), th);
            if (th instanceof MobbErrorException) {
                Object errorMessage = ((MobbErrorException) th).auU().getErrorMessage();
                if (TextUtils.isEmpty(errorMessage)) {
                    com.iqoption.app.a.b.aT(IQApp.Dk());
                } else {
                    com.iqoption.app.a.b.b(errorMessage, IQApp.Dk());
                }
            }
            super.l(th);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("isSuccessful: ");
        stringBuilder.append(this.isSuccessful);
        return stringBuilder.toString();
    }

    public boolean isSuccessful() {
        return this.isSuccessful.booleanValue();
    }
}
