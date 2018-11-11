package com.iqoption.core.data.model;

import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, aXE = {"Lcom/iqoption/core/data/model/UrlOrRes;", "", "url", "", "resId", "", "(Ljava/lang/String;I)V", "getResId", "()I", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "core_release"})
/* compiled from: UrlOrRes.kt */
public final class c {
    private final int aOx;
    private final String url;

    public c() {
        this(null, 0, 3, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (h.E(this.url, cVar.url)) {
                if ((this.aOx == cVar.aOx ? 1 : null) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.url;
        return ((str != null ? str.hashCode() : 0) * 31) + this.aOx;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UrlOrRes(url=");
        stringBuilder.append(this.url);
        stringBuilder.append(", resId=");
        stringBuilder.append(this.aOx);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public c(String str, int i) {
        this.url = str;
        this.aOx = i;
    }

    public /* synthetic */ c(String str, int i, int i2, f fVar) {
        if ((i2 & 1) != 0) {
            str = (String) null;
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        this(str, i);
    }

    public final int getResId() {
        return this.aOx;
    }

    public final String getUrl() {
        return this.url;
    }
}
