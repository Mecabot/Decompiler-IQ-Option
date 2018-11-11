package com.google.common.cache;

import com.google.common.base.e;
import com.google.common.base.f;
import com.google.common.base.i;

/* compiled from: CacheStats */
public final class c {
    private final long Oc;
    private final long Od;
    private final long Oe;
    private final long Of;
    private final long Og;
    private final long Oh;

    public c(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j;
        long j8 = j2;
        long j9 = j3;
        long j10 = j4;
        long j11 = j5;
        long j12 = j6;
        i.checkArgument(j7 >= 0);
        i.checkArgument(j8 >= 0);
        i.checkArgument(j9 >= 0);
        i.checkArgument(j10 >= 0);
        i.checkArgument(j11 >= 0);
        i.checkArgument(j12 >= 0);
        this.Oc = j7;
        this.Od = j8;
        this.Oe = j9;
        this.Of = j10;
        this.Og = j11;
        this.Oh = j12;
    }

    public int hashCode() {
        return f.hashCode(Long.valueOf(this.Oc), Long.valueOf(this.Od), Long.valueOf(this.Oe), Long.valueOf(this.Of), Long.valueOf(this.Og), Long.valueOf(this.Oh));
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.Oc == cVar.Oc && this.Od == cVar.Od && this.Oe == cVar.Oe && this.Of == cVar.Of && this.Og == cVar.Og && this.Oh == cVar.Oh) {
            z = true;
        }
        return z;
    }

    public String toString() {
        return e.B(this).e("hitCount", this.Oc).e("missCount", this.Od).e("loadSuccessCount", this.Oe).e("loadExceptionCount", this.Of).e("totalLoadTime", this.Og).e("evictionCount", this.Oh).toString();
    }
}
