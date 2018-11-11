package com.iqoption.mobbtech.connect.response;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.iqoption.app.IQApp;
import com.iqoption.app.a.b;
import com.iqoption.x.R;
import java.util.concurrent.CancellationException;

public class MobbErrorException extends Exception {
    private final g mobbError;

    public MobbErrorException(g gVar) {
        this.mobbError = gVar;
    }

    public String toString() {
        return this.mobbError.toString();
    }

    public g auU() {
        return this.mobbError;
    }

    public static String D(Throwable th) {
        String str = null;
        if (th instanceof MobbErrorException) {
            g auU = ((MobbErrorException) th).auU();
            if (auU != null) {
                str = auU.getErrorMessage();
            }
            if (TextUtils.isEmpty(str)) {
                str = IQApp.Dk().getString(R.string.unknown_error_occurred);
            }
            b.b(str, IQApp.Dk());
            return str;
        } else if (th instanceof CancellationException) {
            return null;
        } else {
            String string = IQApp.Dk().getString(R.string.unknown_error_occurred);
            b.b(string, IQApp.Dk());
            return string;
        }
    }

    @Nullable
    public static g E(Throwable th) {
        return th instanceof MobbErrorException ? ((MobbErrorException) th).auU() : null;
    }

    @Nullable
    public static <T> T a(Class<T> cls, Throwable th) {
        if (th instanceof MobbErrorException) {
            MobbErrorException mobbErrorException = (MobbErrorException) th;
            if (mobbErrorException.auU() != null && cls.isInstance(mobbErrorException.auU().auT())) {
                return cls.cast(mobbErrorException.auU().auT());
            }
        }
        return null;
    }
}
