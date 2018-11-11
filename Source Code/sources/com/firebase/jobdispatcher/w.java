package com.firebase.jobdispatcher;

import android.net.Uri;
import android.support.annotation.NonNull;

/* compiled from: ObservedUri */
public final class w {
    private final int flags;
    private final Uri uri;

    public w(@NonNull Uri uri, int i) {
        if (uri == null) {
            throw new IllegalArgumentException("URI must not be null.");
        }
        this.uri = uri;
        this.flags = i;
    }

    public Uri getUri() {
        return this.uri;
    }

    public int getFlags() {
        return this.flags;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        if (!(this.flags == wVar.flags && this.uri.equals(wVar.uri))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.uri.hashCode() ^ this.flags;
    }
}
