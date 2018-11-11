package com.iqoption.charttools.model.indicator.constructor;

import com.google.android.gms.plus.PlusShare;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, aXE = {"Lcom/iqoption/charttools/model/indicator/constructor/FigureHost;", "", "index", "", "title", "", "(ILjava/lang/String;)V", "getIndex", "()I", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "techtools_release"})
/* compiled from: FigureHost.kt */
public final class b {
    private final int index;
    private final String title;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return (this.index == bVar.index ? 1 : null) != null && h.E(this.title, bVar.title);
        }
    }

    public int hashCode() {
        int i = this.index * 31;
        String str = this.title;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FigureHost(index=");
        stringBuilder.append(this.index);
        stringBuilder.append(", title=");
        stringBuilder.append(this.title);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public b(int i, String str) {
        h.e(str, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        this.index = i;
        this.title = str;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getTitle() {
        return this.title;
    }
}
