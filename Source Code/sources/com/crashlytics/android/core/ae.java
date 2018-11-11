package com.crashlytics.android.core;

/* compiled from: MiddleOutStrategy */
class ae implements as {
    private final int vC;

    public ae(int i) {
        this.vC = i;
    }

    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= this.vC) {
            return stackTraceElementArr;
        }
        int i = this.vC / 2;
        int i2 = this.vC - i;
        Object obj = new StackTraceElement[this.vC];
        System.arraycopy(stackTraceElementArr, 0, obj, 0, i2);
        System.arraycopy(stackTraceElementArr, stackTraceElementArr.length - i, obj, i2, i);
        return obj;
    }
}
