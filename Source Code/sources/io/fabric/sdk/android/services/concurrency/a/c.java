package io.fabric.sdk.android.services.concurrency.a;

/* compiled from: ExponentialBackoff */
public class c implements a {
    private final long enY;
    private final int enZ;

    public c(long j, int i) {
        this.enY = j;
        this.enZ = i;
    }

    public long r(int i) {
        return (long) (((double) this.enY) * Math.pow((double) this.enZ, (double) i));
    }
}
