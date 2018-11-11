package com.iqoption.verify;

import android.support.v4.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import com.iqoption.mobbtech.connect.response.CardStatus;
import com.iqoption.mobbtech.connect.response.q;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, aXE = {"Lcom/iqoption/verify/VerifyStatus;", "", "id", "", "status", "Lcom/iqoption/mobbtech/connect/response/CardStatus;", "(JLcom/iqoption/mobbtech/connect/response/CardStatus;)V", "getId", "()J", "getStatus", "()Lcom/iqoption/mobbtech/connect/response/CardStatus;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VerifyLocalStatusesRepository.kt */
public final class d {
    public static final a dxx = new a();
    @SerializedName("status")
    private final CardStatus cWa;
    @SerializedName("id")
    private final long id;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/verify/VerifyStatus$Companion;", "", "()V", "fromCard", "Lcom/iqoption/verify/VerifyStatus;", "card", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VerifyLocalStatusesRepository.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final d d(q qVar) {
            h.e(qVar, "card");
            return new d(qVar.getId(), qVar.auX());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return ((this.id > dVar.id ? 1 : (this.id == dVar.id ? 0 : -1)) == 0 ? 1 : null) != null && h.E(this.cWa, dVar.cWa);
        }
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        CardStatus cardStatus = this.cWa;
        return i + (cardStatus != null ? cardStatus.hashCode() : 0);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VerifyStatus(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", status=");
        stringBuilder.append(this.cWa);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public d(long j, CardStatus cardStatus) {
        h.e(cardStatus, NotificationCompat.CATEGORY_STATUS);
        this.id = j;
        this.cWa = cardStatus;
    }

    public final long getId() {
        return this.id;
    }

    public final CardStatus auX() {
        return this.cWa;
    }
}
