package com.noveogroup.android.log;

import com.noveogroup.android.log.Logger.Level;

/* compiled from: Handler */
public interface b {
    void a(String str, Level level, Throwable th, String str2);

    void a(String str, Level level, Throwable th, String str2, Object... objArr);

    boolean a(Level level);
}
