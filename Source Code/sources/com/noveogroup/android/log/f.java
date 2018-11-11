package com.noveogroup.android.log;

import com.noveogroup.android.log.Logger.Level;

/* compiled from: SimpleLogger */
public class f extends a {
    private final b ecf;

    public f(String str, b bVar) {
        super(str);
        this.ecf = bVar;
    }

    public boolean a(Level level) {
        return this.ecf != null && this.ecf.a(level);
    }

    public void a(Level level, String str, Throwable th) {
        if (this.ecf != null) {
            this.ecf.a(getName(), level, th, str);
        }
    }

    public void a(Level level, Throwable th, String str, Object... objArr) {
        if (this.ecf != null) {
            this.ecf.a(getName(), level, th, str, objArr);
        }
    }
}
