package io.fabric.sdk.android.services.concurrency.a;

/* compiled from: RetryState */
public class e {
    private final d eoa;
    private final int retryCount;
    private final a sH;

    public e(a aVar, d dVar) {
        this(0, aVar, dVar);
    }

    public e(int i, a aVar, d dVar) {
        this.retryCount = i;
        this.sH = aVar;
        this.eoa = dVar;
    }

    public long aVe() {
        return this.sH.r(this.retryCount);
    }

    public e aVf() {
        return new e(this.retryCount + 1, this.sH, this.eoa);
    }

    public e aVg() {
        return new e(this.sH, this.eoa);
    }
}
