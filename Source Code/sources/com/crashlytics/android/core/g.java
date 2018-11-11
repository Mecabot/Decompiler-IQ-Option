package com.crashlytics.android.core;

/* compiled from: CompositeCreateReportSpiCall */
class g implements t {
    private final v tx;
    private final af ty;

    public g(v vVar, af afVar) {
        this.tx = vVar;
        this.ty = afVar;
    }

    public boolean a(s sVar) {
        switch (sVar.uO.hT()) {
            case JAVA:
                this.tx.a(sVar);
                return true;
            case NATIVE:
                this.ty.a(sVar);
                return true;
            default:
                return false;
        }
    }
}
