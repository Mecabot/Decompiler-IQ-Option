package com.noveogroup.android.log;

import com.noveogroup.android.log.Logger.Level;

/* compiled from: AbstractLogger */
public abstract class a implements Logger {
    private final String name;

    public a(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public void a(Throwable th, String str, Object... objArr) {
        a(Level.ERROR, th, str, objArr);
    }

    public void f(String str, Object... objArr) {
        a(Level.WARN, null, str, objArr);
    }

    public void g(String str, Object... objArr) {
        a(Level.ERROR, null, str, objArr);
    }
}
