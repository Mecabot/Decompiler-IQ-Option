package com.iqoption.microservice.withdraw.response;

import com.google.gson.annotations.SerializedName;
import com.iqoption.mobbtech.connect.response.l;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\t\u0010\u0016\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, aXE = {"Lcom/iqoption/microservice/withdraw/response/WithdrawResponse;", "Lcom/iqoption/mobbtech/connect/response/ResponseStatus;", "status", "", "id", "", "(IJ)V", "getId", "()J", "getStatus", "()I", "component1", "component2", "copy", "equals", "", "other", "", "getMessage", "", "hashCode", "isSuccessful", "toString", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawResponse.kt */
public final class n implements l {
    @SerializedName("id")
    private final long id;
    @SerializedName("status")
    private final int status;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            if ((this.status == nVar.status ? 1 : null) != null) {
                if ((this.id == nVar.id ? 1 : null) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getMessage() {
        return "";
    }

    public int hashCode() {
        int i = this.status * 31;
        long j = this.id;
        return i + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WithdrawResponse(status=");
        stringBuilder.append(this.status);
        stringBuilder.append(", id=");
        stringBuilder.append(this.id);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public boolean isSuccessful() {
        return this.status == 200;
    }
}
