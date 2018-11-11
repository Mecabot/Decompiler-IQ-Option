package com.iqoption.core.microservices.c.a;

import com.google.gson.annotations.SerializedName;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003JS\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\tHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\tHÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\f\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011¨\u0006&"}, aXE = {"Lcom/iqoption/core/microservices/leaderboard/response/LeaderBoardUserInfo;", "", "userId", "", "userName", "", "score", "", "count", "", "position", "flag", "topSize", "(JLjava/lang/String;DIILjava/lang/String;I)V", "getCount", "()I", "getFlag", "()Ljava/lang/String;", "getPosition", "getScore", "()D", "getTopSize", "getUserId", "()J", "getUserName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "core_release"})
/* compiled from: LeaderBoardUserInfo.kt */
public final class a {
    @SerializedName("top_size")
    private final int aWx;
    @SerializedName("count")
    private final int count;
    @SerializedName("flag")
    private final String flag;
    @SerializedName("position")
    private final int position;
    @SerializedName("score")
    private final double score;
    @SerializedName("user_id")
    private final long userId;
    @SerializedName("user_name")
    private final String userName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if ((this.userId == aVar.userId ? 1 : null) != null && h.E(this.userName, aVar.userName) && Double.compare(this.score, aVar.score) == 0) {
                if ((this.count == aVar.count ? 1 : null) != null) {
                    if ((this.position == aVar.position ? 1 : null) != null && h.E(this.flag, aVar.flag)) {
                        if ((this.aWx == aVar.aWx ? 1 : null) != null) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.userId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.userName;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        long doubleToLongBits = Double.doubleToLongBits(this.score);
        i = (((((i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.count) * 31) + this.position) * 31;
        str = this.flag;
        if (str != null) {
            i2 = str.hashCode();
        }
        return ((i + i2) * 31) + this.aWx;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LeaderBoardUserInfo(userId=");
        stringBuilder.append(this.userId);
        stringBuilder.append(", userName=");
        stringBuilder.append(this.userName);
        stringBuilder.append(", score=");
        stringBuilder.append(this.score);
        stringBuilder.append(", count=");
        stringBuilder.append(this.count);
        stringBuilder.append(", position=");
        stringBuilder.append(this.position);
        stringBuilder.append(", flag=");
        stringBuilder.append(this.flag);
        stringBuilder.append(", topSize=");
        stringBuilder.append(this.aWx);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final long getUserId() {
        return this.userId;
    }

    public final double Wb() {
        return this.score;
    }

    public final int getPosition() {
        return this.position;
    }
}
