package com.iqoption.portfolio.component.b;

import android.support.annotation.NonNull;

/* compiled from: ExpHeaderItem */
public final class c implements f {
    private final long expiration;

    public int getViewType() {
        return -3;
    }

    public c(long j) {
        this.expiration = j;
    }

    @NonNull
    public String Ml() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("expHeader:");
        stringBuilder.append(this.expiration);
        return stringBuilder.toString();
    }

    public long getExpiration() {
        return this.expiration;
    }
}
