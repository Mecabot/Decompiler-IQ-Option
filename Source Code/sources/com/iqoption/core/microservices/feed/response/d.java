package com.iqoption.core.microservices.feed.response;

import com.google.gson.annotations.SerializedName;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, aXE = {"Lcom/iqoption/core/microservices/feed/response/FeedItemUpdateEvent;", "", "()V", "id", "", "userId", "", "rating", "views", "(IJII)V", "getId", "()I", "getRating", "getUserId", "()J", "getViews", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "core_release"})
/* compiled from: FeedResponses.kt */
public final class d {
    @SerializedName("views")
    private final int aWd;
    @SerializedName("document_id")
    private final int id;
    @SerializedName("rating")
    private final int rating;
    @SerializedName("user_id")
    private final long userId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if ((this.id == dVar.id ? 1 : null) != null) {
                if ((this.userId == dVar.userId ? 1 : null) != null) {
                    if ((this.rating == dVar.rating ? 1 : null) != null) {
                        if ((this.aWd == dVar.aWd ? 1 : null) != null) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.id * 31;
        long j = this.userId;
        return ((((i + ((int) (j ^ (j >>> 32)))) * 31) + this.rating) * 31) + this.aWd;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FeedItemUpdateEvent(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", userId=");
        stringBuilder.append(this.userId);
        stringBuilder.append(", rating=");
        stringBuilder.append(this.rating);
        stringBuilder.append(", views=");
        stringBuilder.append(this.aWd);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public d(int i, long j, int i2, int i3) {
        this.id = i;
        this.userId = j;
        this.rating = i2;
        this.aWd = i3;
    }

    public final int getId() {
        return this.id;
    }

    public final long getUserId() {
        return this.userId;
    }

    public final int getRating() {
        return this.rating;
    }

    public final int VV() {
        return this.aWd;
    }

    public d() {
        this(0, 0, 0, 0);
    }
}
