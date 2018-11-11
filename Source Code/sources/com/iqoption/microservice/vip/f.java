package com.iqoption.microservice.vip;

import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\tHÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, aXE = {"Lcom/iqoption/microservice/vip/VipManagerResponse;", "", "()V", "success", "", "message", "", "", "managerProfile", "Lcom/iqoption/microservice/vip/VipManager;", "(ZLjava/util/List;Lcom/iqoption/microservice/vip/VipManager;)V", "getManagerProfile", "()Lcom/iqoption/microservice/vip/VipManager;", "getMessage", "()Ljava/util/List;", "getSuccess", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VipManagerResposnses.kt */
public final class f {
    @SerializedName("result")
    private final d cTl;
    @SerializedName("message")
    private final List<String> message;
    @SerializedName("isSuccessful")
    private final boolean success;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return (this.success == fVar.success ? 1 : null) != null && h.E(this.message, fVar.message) && h.E(this.cTl, fVar.cTl);
        }
    }

    public int hashCode() {
        int i = this.success;
        if (i != 0) {
            i = 1;
        }
        i *= 31;
        List list = this.message;
        int i2 = 0;
        i = (i + (list != null ? list.hashCode() : 0)) * 31;
        d dVar = this.cTl;
        if (dVar != null) {
            i2 = dVar.hashCode();
        }
        return i + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VipManagerResponse(success=");
        stringBuilder.append(this.success);
        stringBuilder.append(", message=");
        stringBuilder.append(this.message);
        stringBuilder.append(", managerProfile=");
        stringBuilder.append(this.cTl);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public f(boolean z, List<String> list, d dVar) {
        h.e(list, "message");
        this.success = z;
        this.message = list;
        this.cTl = dVar;
    }

    public final boolean Pg() {
        return this.success;
    }

    public final d ats() {
        return this.cTl;
    }

    public f() {
        List emptyList = Collections.emptyList();
        h.d(emptyList, "Collections.emptyList()");
        this(false, emptyList, null);
    }
}
