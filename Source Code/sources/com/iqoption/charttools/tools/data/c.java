package com.iqoption.charttools.tools.data;

import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0001\u0003\u0011\u0012\u0013¨\u0006\u0014"}, aXE = {"Lcom/iqoption/charttools/tools/data/CategoryAdapterItem;", "", "id", "", "title", "", "(JLjava/lang/String;)V", "getId", "()J", "getTitle", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "toString", "Lcom/iqoption/charttools/tools/data/AnyCategoryItem;", "Lcom/iqoption/charttools/tools/data/FavoriteCategoryItem;", "Lcom/iqoption/charttools/tools/data/CategoryItem;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: CategoryItem.kt */
public abstract class c {
    private final long id;
    private final String title;

    private c(long j, String str) {
        this.id = j;
        this.title = str;
    }

    public /* synthetic */ c(long j, String str, f fVar) {
        this(j, str);
    }

    public final long getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((h.E(getClass(), obj != null ? obj.getClass() : null) ^ 1) != 0) {
            return false;
        }
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.iqoption.charttools.tools.data.CategoryAdapterItem");
        }
        if (this.id != ((c) obj).id) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Long.valueOf(this.id).hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CategoryAdapterItem(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", title='");
        stringBuilder.append(this.title);
        stringBuilder.append("')");
        return stringBuilder.toString();
    }
}
