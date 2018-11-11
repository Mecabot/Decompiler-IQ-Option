package io.fabric.sdk.android.services.concurrency;

public enum Priority {
    LOW,
    NORMAL,
    HIGH,
    IMMEDIATE;

    static <Y> int compareTo(f fVar, Y y) {
        Priority hA;
        if (y instanceof f) {
            hA = ((f) y).hA();
        } else {
            hA = NORMAL;
        }
        return hA.ordinal() - fVar.hA().ordinal();
    }
}
