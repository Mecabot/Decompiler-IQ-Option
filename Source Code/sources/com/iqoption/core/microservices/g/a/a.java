package com.iqoption.core.microservices.g.a;

import android.support.v4.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007\b\u0016¢\u0006\u0002\u0010\u0002BI\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011JR\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\bHÖ\u0001J\t\u0010%\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0013\u0010\u000eR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, aXE = {"Lcom/iqoption/core/microservices/useronline/response/UserAvailability;", "", "()V", "userId", "", "status", "", "platformId", "", "idleDuration", "selectedAssetId", "selectedAssetType", "(JLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;)V", "getIdleDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPlatformId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSelectedAssetId", "getSelectedAssetType", "getStatus", "()Ljava/lang/String;", "getUserId", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(JLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;)Lcom/iqoption/core/microservices/useronline/response/UserAvailability;", "equals", "", "other", "hashCode", "toString", "Companion", "core_release"})
/* compiled from: UserAvailability.kt */
public final class a {
    private static final a aZs = new a();
    public static final a aZt = new a();
    @SerializedName("idle_duration")
    private final Long aZp;
    @SerializedName("selected_asset_id")
    private final Long aZq;
    @SerializedName("selected_asset_type")
    private final Integer aZr;
    @SerializedName("platform_id")
    private final Integer platformId;
    @SerializedName("status")
    private final String status;
    @SerializedName("user_id")
    private final long userId;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, aXE = {"Lcom/iqoption/core/microservices/useronline/response/UserAvailability$Companion;", "", "()V", "EMPTY", "Lcom/iqoption/core/microservices/useronline/response/UserAvailability;", "getEMPTY", "()Lcom/iqoption/core/microservices/useronline/response/UserAvailability;", "STATUS_OFFLINE", "", "STATUS_ONLINE", "STATUS_UNKNOWN", "core_release"})
    /* compiled from: UserAvailability.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return ((this.userId > aVar.userId ? 1 : (this.userId == aVar.userId ? 0 : -1)) == 0 ? 1 : null) != null && h.E(this.status, aVar.status) && h.E(this.platformId, aVar.platformId) && h.E(this.aZp, aVar.aZp) && h.E(this.aZq, aVar.aZq) && h.E(this.aZr, aVar.aZr);
        }
    }

    public int hashCode() {
        long j = this.userId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.status;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        Integer num = this.platformId;
        i = (i + (num != null ? num.hashCode() : 0)) * 31;
        Long l = this.aZp;
        i = (i + (l != null ? l.hashCode() : 0)) * 31;
        l = this.aZq;
        i = (i + (l != null ? l.hashCode() : 0)) * 31;
        num = this.aZr;
        if (num != null) {
            i2 = num.hashCode();
        }
        return i + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UserAvailability(userId=");
        stringBuilder.append(this.userId);
        stringBuilder.append(", status=");
        stringBuilder.append(this.status);
        stringBuilder.append(", platformId=");
        stringBuilder.append(this.platformId);
        stringBuilder.append(", idleDuration=");
        stringBuilder.append(this.aZp);
        stringBuilder.append(", selectedAssetId=");
        stringBuilder.append(this.aZq);
        stringBuilder.append(", selectedAssetType=");
        stringBuilder.append(this.aZr);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public a(long j, String str, Integer num, Long l, Long l2, Integer num2) {
        h.e(str, NotificationCompat.CATEGORY_STATUS);
        this.userId = j;
        this.status = str;
        this.platformId = num;
        this.aZp = l;
        this.aZq = l2;
        this.aZr = num2;
    }

    public final String getStatus() {
        return this.status;
    }

    public /* synthetic */ a(long j, String str, Integer num, Long l, Long l2, Integer num2, int i, f fVar) {
        this((i & 1) != 0 ? -1 : j, (i & 2) != 0 ? "unknown" : str, (i & 4) != 0 ? (Integer) null : num, (i & 8) != 0 ? (Long) null : l, (i & 16) != 0 ? (Long) null : l2, (i & 32) != 0 ? (Integer) null : num2);
    }

    public a() {
        this(-1, null, null, null, null, null, 62, null);
    }
}
