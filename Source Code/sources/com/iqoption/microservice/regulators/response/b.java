package com.iqoption.microservice.regulators.response;

import com.google.gson.annotations.SerializedName;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, aXE = {"Lcom/iqoption/microservice/regulators/response/ProTraderNotification;", "", "showNotification", "", "(Z)V", "getShowNotification", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ProTraderNotification.kt */
public final class b {
    @SerializedName("show_notification")
    private final boolean cSM;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            if ((this.cSM == ((b) obj).cSM ? 1 : null) != null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        boolean z = this.cSM;
        return z ? 1 : z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ProTraderNotification(showNotification=");
        stringBuilder.append(this.cSM);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final boolean atb() {
        return this.cSM;
    }
}
