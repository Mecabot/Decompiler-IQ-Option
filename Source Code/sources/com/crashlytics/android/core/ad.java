package com.crashlytics.android.core;

/* compiled from: MiddleOutFallbackStrategy */
class ad implements as {
    private final as[] vA;
    private final ae vB;
    private final int vz;

    public ad(int i, as... asVarArr) {
        this.vz = i;
        this.vA = asVarArr;
        this.vB = new ae(i);
    }

    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= this.vz) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
        for (as asVar : this.vA) {
            if (stackTraceElementArr2.length <= this.vz) {
                break;
            }
            stackTraceElementArr2 = asVar.a(stackTraceElementArr);
        }
        if (stackTraceElementArr2.length > this.vz) {
            stackTraceElementArr2 = this.vB.a(stackTraceElementArr2);
        }
        return stackTraceElementArr2;
    }
}
