package com.firebase.jobdispatcher;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.List;

public class ValidationEnforcer implements v {
    private final v JS;

    public static final class ValidationException extends RuntimeException {
        private final List<String> errors;

        public ValidationException(String str, @NonNull List<String> list) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(TextUtils.join("\n  - ", list));
            super(stringBuilder.toString());
            this.errors = list;
        }
    }

    public ValidationEnforcer(v vVar) {
        this.JS = vVar;
    }

    @Nullable
    public List<String> c(r rVar) {
        return this.JS.c(rVar);
    }

    @Nullable
    public List<String> a(x xVar) {
        return this.JS.a(xVar);
    }

    public final void g(r rVar) {
        u(c(rVar));
    }

    public final void d(x xVar) {
        u(a(xVar));
    }

    private static void u(List<String> list) {
        if (list != null) {
            throw new ValidationException("JobParameters is invalid", list);
        }
    }
}
