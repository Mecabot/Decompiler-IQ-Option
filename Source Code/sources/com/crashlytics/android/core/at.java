package com.crashlytics.android.core;

/* compiled from: TrimmedThrowableData */
class at {
    public final String className;
    public final String vZ;
    public final StackTraceElement[] wa;
    public final at wb;

    public at(Throwable th, as asVar) {
        this.vZ = th.getLocalizedMessage();
        this.className = th.getClass().getName();
        this.wa = asVar.a(th.getStackTrace());
        th = th.getCause();
        this.wb = th != null ? new at(th, asVar) : null;
    }
}
